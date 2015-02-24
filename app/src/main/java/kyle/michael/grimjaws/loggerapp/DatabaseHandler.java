package kyle.michael.grimjaws.loggerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;import kyle.michael.grimjaws.loggerapp.Log;

/**
 * Created by Kyle on 9/2/2014.
 * Send me a message over hangout if you need a feature added to the database.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "logManager";

    private static final String TABLE_LOGS = "logs";

    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_DISTANCE = "distance";
    private static final String KEY_START_TIME = "start_time";
    private static final String KEY_END_TIME = "end_time";
    private static final String KEY_TOTAL_TIME = "total_time";
    private static final String KEY_PACE = "pace";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOGS_TABLE = "CREATE TABLE " + TABLE_LOGS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT," + KEY_DESCRIPTION + " TEXT," +
                KEY_DISTANCE + " TEXT," + KEY_START_TIME + " TEXT," + KEY_END_TIME + " TEXT," + KEY_TOTAL_TIME
        + " TEXT," + KEY_PACE + " TEXT" + ")";
        db.execSQL(CREATE_LOGS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGS);
        onCreate(db);
    }

    // Adding new log
    public void addLog(Log log) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, log.getTitle());
        values.put(KEY_DESCRIPTION, String.valueOf(log.getDescription()));
        values.put(KEY_DISTANCE, String.valueOf(log.getDistance()));
        values.put(KEY_START_TIME, String.valueOf(log.getStartTime()));
        values.put(KEY_END_TIME, String.valueOf(log.getEndTime()));
        values.put(KEY_TOTAL_TIME, String.valueOf(log.getTotalTime()));
        values.put(KEY_PACE, String.valueOf(log.getPace()));
        long rowID = db.insert(TABLE_LOGS, null, values);
        log.setLogID(rowID);
        db.close();
    }

    // Getting single log by id
    public Log getLog(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        final Cursor cursor = db.query(TABLE_LOGS, new String[] { KEY_ID, KEY_TITLE, KEY_DESCRIPTION, KEY_DISTANCE,
                KEY_START_TIME, KEY_END_TIME, KEY_TOTAL_TIME, KEY_PACE}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            return new Log(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2), Double.parseDouble(cursor.getString(3)),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6), Double.parseDouble(cursor.getString(7)),
                    cursor.getString(8));
        }
        return null;
    }

    // Getting all logs
    public ArrayList<Log> getLogs() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LOGS, new String[] { KEY_ID, KEY_TITLE, KEY_DESCRIPTION, KEY_DISTANCE,
                        KEY_START_TIME, KEY_END_TIME, KEY_TOTAL_TIME, KEY_PACE}, null,
                null, null, null, null, null); // TODO order properly :)
        ArrayList<Log> logs = new ArrayList<Log>();
        if (cursor.moveToFirst()) {
            do {
                Log log = new Log(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), cursor.getString(2), Double.parseDouble(cursor.getString(3)),
                        cursor.getString(4), cursor.getString(5), cursor.getString(6), Double.parseDouble(cursor.getString(7)),
                        cursor.getString(8));
                logs.add(log);
            } while (cursor.moveToNext());
        }
        return logs;
    }


    // Updating single log
    public void updateLog(Log log) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, log.getLogID());
        values.put(KEY_TITLE, log.getTitle());
        values.put(KEY_DESCRIPTION, String.valueOf(log.getDescription()));
        values.put(KEY_DISTANCE, String.valueOf(log.getDistance()));
        values.put(KEY_START_TIME, String.valueOf(log.getStartTime()));
        values.put(KEY_END_TIME, String.valueOf(log.getEndTime()));
        values.put(KEY_TOTAL_TIME, String.valueOf(log.getTotalTime()));
        values.put(KEY_PACE, String.valueOf(log.getPace()));

        db.update(TABLE_LOGS, values, KEY_ID + " = ?", new String[] { String.valueOf(log.getLogID()) });
    }

    // Deleting single log
    // Returns true if a log has been deleted
    public boolean deleteLog(Log log) {
        SQLiteDatabase db = getWritableDatabase();
        boolean value = (db.delete(TABLE_LOGS, KEY_ID + " = ?",
                new String[] { String.valueOf(log.getLogID()) }) > 0);
        db.close();
        return value;
    }

}