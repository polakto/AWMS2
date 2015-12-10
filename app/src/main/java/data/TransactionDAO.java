package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.UrlQuerySanitizer;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DN on 24/11/2015.
 */
public class TransactionDAO {
    public static final String TAG = "TransactionDAO";

    // Database fields
    private SQLiteDatabase tDatabase;
    private DatabaseHelper tDbHelper;
    private Context tContext;
    private String[] tAllColumns = {DatabaseHelper.COLUMN_TRANS_ID,
            DatabaseHelper.COLUMN_TRANS_TRANS_Status, DatabaseHelper.COLUMN_TRANS_DATE,
            DatabaseHelper.COLUMN_TRANS_QUANTITY,DatabaseHelper.COLUMN_TRANS_VALUE,
            DatabaseHelper.COLUMN_TRANS_SUBJECT_ID};

    public TransactionDAO(Context context) {
        this.tContext = context;
        tDbHelper = new DatabaseHelper(context);
        // open the database
        try {
            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException on openning database " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        tDatabase = tDbHelper.getWritableDatabase();
    }

    public void close() {
        tDbHelper.close();
    }


    private TransactionModel cursorToTransaction(Cursor cursor) {
        TransactionModel trans = new TransactionModel();
        trans.setId(cursor.getInt(0));
        trans.setTransStatus(cursor.getString(1));
        //Date
        String s= cursor.getString(2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        try {
            d=  dateFormat.parse(s);
        } catch (ParseException e){
            e.printStackTrace();
        }
        trans.setTransDate(d);

        trans.setTransactionQuantity(cursor.getString(3));
        trans.setTransactionValue(cursor.getString(4));

        // get The Subject by id
        int subjecId = cursor.getInt(5);
        SubjectDAO sDao = new SubjectDAO(tContext);
        SubjectModel sModel = sDao.getSubjectById(subjecId);
        if (sModel != null)
            trans.setTransSubject(sModel);

        return trans;

    }

    public TransactionModel createTransaction(String status, Date date, String quantity,String value,int subjectId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
        Date transNewDate = new Date();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_TRANS_TRANS_Status, status);
        values.put(DatabaseHelper.COLUMN_TRANS_DATE, dateFormat.format(date));
        values.put(DatabaseHelper.COLUMN_TRANS_QUANTITY, quantity);
        values.put(DatabaseHelper.COLUMN_TRANS_VALUE, value);
        values.put(DatabaseHelper.COLUMN_TRANS_SUBJECT_ID, subjectId);
        long insertId = tDatabase
                .insert(DatabaseHelper.TABLE_TRANSACTIONS, null, values);
        Cursor cursor = tDatabase.query(DatabaseHelper.TABLE_TRANSACTIONS, tAllColumns,
                DatabaseHelper.COLUMN_TRANS_ID + " = " + insertId, null, null,
                null, null);
        cursor.moveToFirst();
        TransactionModel newTransaction = cursorToTransaction(cursor);
        cursor.close();
        return newTransaction;
    }
    public TransactionModel updateTransaction(TransactionModel trans) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
        Date transUpdatedDate = new Date();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_TRANS_TRANS_Status, trans.getTransactionValue());
        values.put(DatabaseHelper.COLUMN_TRANS_DATE,dateFormat.format(trans.getTransDate()));
        values.put(DatabaseHelper.COLUMN_TRANS_QUANTITY,trans.getTransactionQuantity());
        values.put(DatabaseHelper.COLUMN_TRANS_VALUE,trans.getTransactionValue());

        // updating row
        long updateId= tDatabase.update(DatabaseHelper.TABLE_TRANSACTIONS, values, DatabaseHelper.COLUMN_TRANS_ID + " = ?",
                new String[]{String.valueOf(trans.getId())});
        Cursor cursor = tDatabase.query(DatabaseHelper.TABLE_TRANSACTIONS, tAllColumns,
                DatabaseHelper.COLUMN_SUBJECT_ID + " = " + updateId, null, null,
                null, null);
        cursor.moveToFirst();
        TransactionModel newTrans = cursorToTransaction(cursor);
        cursor.close();
        return newTrans;
    }
    public void deleteTransaction(TransactionModel trans) {
        int id = trans.getId();
        System.out.println("the deleted transaction has the id: " + id);
        tDatabase.delete(DatabaseHelper.TABLE_TRANSACTIONS, DatabaseHelper.COLUMN_TRANS_ID
                + " = " + id, null);
    }

    public List<TransactionModel> getAllTransactions() {
        List<TransactionModel> listTransactions = new ArrayList<TransactionModel>();

        Cursor cursor = tDatabase.query(DatabaseHelper.TABLE_TRANSACTIONS, tAllColumns,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            TransactionModel trans = cursorToTransaction(cursor);
            listTransactions.add(trans);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return listTransactions;
    }
    public List<TransactionModel> getTransactionOfSubject(int subjectId)
    {
        List<TransactionModel> listTransaction = new ArrayList<TransactionModel>();

        Cursor cursor = tDatabase.query(DatabaseHelper.TABLE_TRANSACTIONS, tAllColumns,
                DatabaseHelper.COLUMN_TRANS_SUBJECT_ID + " = ?",
                new String[] { String.valueOf(subjectId) }, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            TransactionModel transModel = cursorToTransaction(cursor);
            listTransaction.add(transModel);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return listTransaction;
    }

}
