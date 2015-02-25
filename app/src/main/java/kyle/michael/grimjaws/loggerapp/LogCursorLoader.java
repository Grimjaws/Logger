package kyle.michael.grimjaws.loggerapp;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;

/**
 * Created by Kyle on 2/24/2015.
 */
public class LogCursorLoader extends CursorLoader {

    DatabaseHandler db;

    public LogCursorLoader(Context context) {
        super(context);
    }

    @Override
    public Cursor loadInBackground() {
        Cursor cursor = db.getLogs();
        return cursor;
    }
}
