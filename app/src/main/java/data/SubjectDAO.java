package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

/**
 * Created by DN on 23/11/2015.
 */
public class SubjectDAO {

    public static final String TAG = "SubjectDAO";

    // Database fields
    private SQLiteDatabase sDatabase;
    private DatabaseHelper sDbHelper;
    private Context sContext;
    private String[] sAllColumns = {DatabaseHelper.COLUMN_SUBJECT_ID,
            DatabaseHelper.COLUMN_SUBJECT_NAME, DatabaseHelper.COLUMN_SUBJECT_UOM_ID};

    public SubjectDAO(Context context) {
        this.sContext = context;
        sDbHelper = new DatabaseHelper(context);
        // open the database
        try {
            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException on openning database " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        sDatabase = sDbHelper.getWritableDatabase();
    }

    public void close() {
        sDbHelper.close();
    }


    private SubjectModel cursorToSubject(Cursor cursor) {
        SubjectModel subject = new SubjectModel();
        subject.setId(cursor.getInt(0));
        subject.setSubjectName(cursor.getString(1));

        // get The Uom by id
        int UoMId = cursor.getInt(2);
        UoMDAO dao = new UoMDAO(sContext);
        UomModel uom = dao.getUoMById(UoMId);
        if (uom != null)
            subject.setUoM(uom);

        return subject;

    }
     /*
     TransactionModel
      */
    public SubjectModel insertSubject(String sName)
    {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_SUBJECT_NAME, sName);
        long insertId = sDatabase.insert(DatabaseHelper.TABLE_SubjectS, null, values);
        Cursor cursor = sDatabase.query(DatabaseHelper.TABLE_SubjectS, sAllColumns,
                DatabaseHelper.COLUMN_SUBJECT_ID + " = " + insertId, null, null,
                null, null);
        cursor.moveToFirst();
        SubjectModel newSubject = cursorToSubject(cursor);
        cursor.close();
        return newSubject;

    }
    public SubjectModel updateSubject(SubjectModel subject) {

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_SUBJECT_NAME, subject.getSubjectName());

        // updating row
        long updateId= sDatabase.update(DatabaseHelper.TABLE_SubjectS, values,DatabaseHelper.COLUMN_SUBJECT_ID + " = ?",
                new String[]{String.valueOf(subject.getId())});
        Cursor cursor = sDatabase.query(DatabaseHelper.TABLE_SubjectS, sAllColumns,
                DatabaseHelper.COLUMN_SUBJECT_ID + " = " + updateId, null, null,
                null, null);
        cursor.moveToFirst();
        SubjectModel newSubject = cursorToSubject(cursor);
        cursor.close();
        return newSubject;
    }


    public void deleteSubject(SubjectModel subject) {
        int id = subject.getId();
        // delete all Transactions of this subject
        TransactionDAO transDao = new TransactionDAO(sContext);
        List<TransactionModel> listTransactions = transDao.getTransactionOfSubject(id);
        if (listTransactions != null && !listTransactions.isEmpty()) {
            for (TransactionModel e : listTransactions) {
                transDao.deleteTransaction(e);
            }
        }

        System.out.println("the deleted subject has the id: " + id);
        sDatabase.delete(DatabaseHelper.TABLE_SubjectS, DatabaseHelper.COLUMN_SUBJECT_ID
                + " = " + id, null);
    }

    public List<SubjectModel> getSubjectsOfTransaction(int transactionId) {
        List<SubjectModel> listSubjects = new ArrayList<SubjectModel>();

        Cursor cursor = sDatabase.query(DatabaseHelper.TABLE_SubjectS, sAllColumns,
                DatabaseHelper.COLUMN_TRANS_ID + " = ?",
                new String[]{String.valueOf(transactionId)}, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            SubjectModel subject = cursorToSubject(cursor);
            listSubjects.add(subject);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return listSubjects;
    }

    public List<SubjectModel> getAllSubjects() {
        List<SubjectModel> listSubjects = new ArrayList<SubjectModel>();

        Cursor cursor = sDatabase.query(DatabaseHelper.TABLE_SubjectS, sAllColumns,
                null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                SubjectModel subject = cursorToSubject(cursor);
                listSubjects.add(subject);
                cursor.moveToNext();
            }

            // make sure to close the cursor
            cursor.close();
        }
        return listSubjects;
    }
    public SubjectModel getSubjectById(int id) {
        Cursor cursor = sDatabase.query(DatabaseHelper.TABLE_SubjectS, sAllColumns,
                DatabaseHelper.COLUMN_SUBJECT_ID + " = ?",
                new String[] { String.valueOf(id) }, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        SubjectModel subject = cursorToSubject(cursor);
        return subject;
    }



}
