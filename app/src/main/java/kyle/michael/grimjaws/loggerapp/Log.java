package kyle.michael.grimjaws.loggerapp;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Grimjaws on 2/19/2015.
 */
public class Log {
    String title;
    String description;
    double distance;
    double pace;
    Calendar startTime;
    Calendar endTime;
    double totalTime;
    long logID;

    public Log(long logID, String title, String description, double distance,
               String startTime, String endTime, String totalTime, double pace, String date) {
        this.logID = logID;
        this.title = title;
        this.description = description;
        this.distance = distance;
        Calendar cal = new Calendar() {
            @Override
            public void add(int field, int value) {

            }

            @Override
            protected void computeFields() {

            }

            @Override
            protected void computeTime() {

            }

            @Override
            public int getGreatestMinimum(int field) {
                return 0;
            }

            @Override
            public int getLeastMaximum(int field) {
                return 0;
            }

            @Override
            public int getMaximum(int field) {
                return 0;
            }

            @Override
            public int getMinimum(int field) {
                return 0;
            }

            @Override
            public void roll(int field, boolean increment) {

            }
        };
        cal.setTimeInMillis(Long.parseLong(startTime));
        this.startTime = cal;
        cal.setTimeInMillis(Long.parseLong(endTime));
        this.endTime = cal;
        this.totalTime = Double.parseDouble(totalTime);
        this.pace = pace;
    }

    public Log(String title, String description, double distance,
               String startTime, String endTime, String totalTime, double pace, Date date) {
        this.logID = logID;
        this.title = title;
        this.description = description;
        this.distance = distance;
        Calendar cal = new Calendar() {
            @Override
            public void add(int field, int value) {

            }

            @Override
            protected void computeFields() {

            }

            @Override
            protected void computeTime() {

            }

            @Override
            public int getGreatestMinimum(int field) {
                return 0;
            }

            @Override
            public int getLeastMaximum(int field) {
                return 0;
            }

            @Override
            public int getMaximum(int field) {
                return 0;
            }

            @Override
            public int getMinimum(int field) {
                return 0;
            }

            @Override
            public void roll(int field, boolean increment) {

            }
        };
        cal.setTimeInMillis(Long.parseLong(startTime));
        this.startTime = cal;
        cal.setTimeInMillis(Long.parseLong(endTime));
        this.endTime = cal;
        this.totalTime = Double.parseDouble(totalTime);
        this.pace = pace;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPace() {
        return pace;
    }

    public void setPace(double pace) {
        this.pace = pace;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public long getLogID() {
        return logID;
    }

    public void setLogID(long logID) {
        this.logID = logID;
    }
}