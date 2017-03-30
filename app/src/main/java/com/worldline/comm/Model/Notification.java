package com.worldline.comm.Model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Notification implements Serializable {


    public static final class Column {

        public static final String ID = "notificationId";
        public static final String senderName = "senderName";
        public static final String TITLE = "title";
        public static final String MESSAGE = "message";
        public static final String TIMESTAMP = "timestamp";


    }

    public long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(long notificationId) {
        this.notificationId = notificationId;
    }


    private long notificationId;

    private String senderName;

    private String title;

    private String message;

    private long timestamp;

    public Notification() {
        super();

    }

    public Notification(String senderName, String title, String message) {
        this.senderName = senderName;
        this.title = title;
        this.message = message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm a");

        return df.format(timestamp);
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderName() {
        return senderName;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", senderName='" + senderName + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        if (notificationId != that.notificationId) return false;
        if (timestamp != that.timestamp) return false;
        if (senderName != null ? !senderName.equals(that.senderName) : that.senderName != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (notificationId ^ (notificationId >>> 32));
        result = 31 * result + (senderName != null ? senderName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }
}
