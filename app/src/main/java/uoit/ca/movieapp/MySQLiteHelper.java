package uoit.ca.movieapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
/* values of movie object
* (String posterPath, boolean adult, String overview, String releaseDate, List<Integer> genreIds, Integer id,
                 String originalTitle, String originalLanguage, String title, String backdropPath, Double popularity,
                 Integer voteCount, Boolean video, Double voteAverage)*/

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";
    public static final String TABLE_NAME = "moviesToWatch";
    public static final String COL_1 = "id";
    public static final String COL_2 = "originalTitle";
    public static final String COL_3 = "popularity";
    public static final String COL_4 = "voteAverage";


    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_1 + " Integer PRIMARY KEY AUTOINCREMENT," +
                COL_2 + " Text NOT NULL," +
                COL_3 + " number DEFAULT 0)"+
                COL_4 + " number DEFAULT 0)"+ ";";

        Log.d("DBText", "createTable: " + createTable);
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table " + TABLE_NAME + ";");
        this.onCreate(db);
    }

    public void addRecord(Movie movie) {
        ContentValues values = new ContentValues();
        values.put(COL_2,movie.getOriginalTitle());
        values.put(COL_3,movie.getPopularity());
        values.put(COL_4,movie.getVoteAverage());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
        db.close();
    }


    public void deleteRecord(String movieName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("Delete from " + TABLE_NAME + " where " + COL_2 + "='" + movieName + "';");
        db.close();
    }

    public void deleteAll() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("Delete from " + TABLE_NAME + ";");
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
