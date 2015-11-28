package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "WarehouseMsDb.db";

    //columns of Subjects table
    public static final String TABLE_SubjectS = "subjects_table";
    public static final String COLUMN_SUBJECT_ID = "subjectID";
    public static final String COLUMN_SUBJECT_NAME = "subjectNAME";
    public static final String COLUMN_SUBJECT_UOM_ID="subjectUomId";

    //columns of UoMs table
    public static  final String TABLE_UoMS = "UoMs";
    public static  final String COLUMN_UoM_ID = "uomId";
    public static  final String COLUMN_UoM_NAME = "uomName";

    //columns of transactions table
    public static  final String TABLE_TRANSACTIONS = "transactions_table";
    public static  final String COLUMN_TRANS_ID = "transId";
    public static  final String COLUMN_TRANS_SUBJECT_ID = "transSubjectSId";
    public static  final String COLUMN_TRANS_TRANS_Status = "transTransStatus";
    public static  final String COLUMN_TRANS_DATE = "transDate";
    public static  final String COLUMN_TRANS_QUANTITY = "transQuantity";
    public static  final String COLUMN_TRANS_UNIT_PRICE = "transUnitPrice";
    public static  final String COLUMN_TRANS_VALUE = "transValue";

    //create
    /*CREATE TABLE TABLE_TRANSACTIONS (
    COLUMN_TRANS_ID INTEGER PRIMARY KEY AUTOINCREMENT, COLUMN_TRANS_SUBJECT_ID INTEGER,
    FOREIGN KEY (COLUMN_TRANS_SUBJECT_ID) REFERENCES TABLE_SubjectS(COLUMN_SUBJECT_ID)
            );*/
   private static final String SQL_CREATE_TABLE_TRANSACTIONS = "CREATE TABLE " + TABLE_TRANSACTIONS + "("
            + COLUMN_TRANS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +"transSubjectId INTEGER NOT NULL,"
            + COLUMN_TRANS_SUBJECT_ID + " INTEGER REFERENCES " + TABLE_SubjectS + ","
            + COLUMN_TRANS_TRANS_Status+ " INTEGER NOT NULL ,"
            + COLUMN_TRANS_DATE + " INTEGER, "
            + COLUMN_TRANS_QUANTITY + " TEXT NOT NULL, "
            + COLUMN_TRANS_UNIT_PRICE + " TEXT NOT NULL, "
            + COLUMN_TRANS_VALUE + " TEXT NOT NULL "
            +");";

    private static final String SQL_CREATE_TABLE_Subjects = "CREATE TABLE " + TABLE_SubjectS + "("
            + COLUMN_SUBJECT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +"subjectUomId INTEGER NOT NULL,"
            + COLUMN_SUBJECT_UOM_ID + " INTEGER REFERENCES " + TABLE_UoMS + ","
            + COLUMN_SUBJECT_NAME +"TEXT NOT NULL"+");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_Subjects);
        db.execSQL("create table " + TABLE_UoMS + "(uomId INTEGER PRIMARY KEY AUTOINCREMENT,uomName TEXT NOT NULL)");
        db.execSQL(SQL_CREATE_TABLE_TRANSACTIONS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SubjectS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UoMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTIONS);
        onCreate(db);
    }
}