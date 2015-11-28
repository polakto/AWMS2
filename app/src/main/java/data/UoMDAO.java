package data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by DN on 24/11/2015.
 */
public class UoMDAO {

    public static final String TAG = "UoMDAO";

    // Database fields
    private SQLiteDatabase uomDatabase;
    private DatabaseHelper uomDbHelper;
    private Context uomContext;
    private String[] uomAllColumns = { DatabaseHelper.COLUMN_UoM_ID,
            DatabaseHelper.COLUMN_UoM_NAME};

    public UoMDAO(Context context) {
        this.uomContext = context;
        uomDbHelper = new DatabaseHelper(context);
        // open the database
        try {
            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException on openning database " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        uomDatabase = uomDbHelper.getWritableDatabase();
    }

    public void close() {
        uomDbHelper.close();
    }

    public UomModel getUoMById(int id) {
        Cursor cursor = uomDatabase.query(DatabaseHelper.TABLE_UoMS, uomAllColumns,
                DatabaseHelper.COLUMN_UoM_ID + " = ?",
                new String[] { String.valueOf(id) }, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        UomModel uom = cursorToUom(cursor);
        return uom;
    }

    protected UomModel cursorToUom(Cursor cursor) {
        UomModel uom = new UomModel();
        uom.setId(cursor.getInt(0));
        uom.setUomName(cursor.getString(1));
        return uom;
    }

}
