package kyle.michael.grimjaws.loggerapp;

/**
 * Created by Grimjaws on 2/20/2015.
 */

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import kyle.michael.grimjaws.loggerapp.R;


public class NewLog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_log);

        Button butt = (Button) findViewById(R.id.dateButton);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void showStartTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager().beginTransaction(), "timePicker");
    }
}
