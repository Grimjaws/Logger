package kyle.michael.grimjaws.loggerapp;

import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Kyle on 2/24/2015.
 */
public class LogCursorAdapter extends SimpleCursorAdapter {

    public LogCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }
}
