package uoit.ca.movieapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";
    public static final String TABLE_NAME = "product";
    public static final String COL_1 = "id";
    public static final String COL_2 = "productName";
    public static final String COL_3 = "price";

    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_1 + " Integer PRIMARY KEY AUTOINCREMENT," +
                COL_2 + " Text NOT NULL," +
                COL_3 + " number DEFAULT 0)" + ";";

        Log.d("DBText", "createTable: " + createTable);
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table " + TABLE_NAME + ";");
        this.onCreate(db);
    }

    public void addRecord(Object product) {
        /*
        ContentValues values= new ContentValues();

        values.put(COL_2,product.getProductName());
        values.put(COL_3,product.getPrice());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME,null,values);

        db.close();
        */
    }


    public void deleteRecord(String nameInput) {

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("Delete from " + TABLE_NAME + " where " + COL_2 + "='" + nameInput + "';");
        db.close();
    }

    public String databaseToString() {
        String result = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = " Select * from " + TABLE_NAME + ";";

        Cursor c = db.rawQuery(query, null);

        c.moveToFirst();

        while (!(c.isAfterLast())) {
            result += c.getString(c.getColumnIndex(COL_2));
            result += " \n ";
            //result += c.getString(c.getColumnIndex(COL_3));
            c.moveToNext();

        }
        db.close();
        return result;
    }
}
