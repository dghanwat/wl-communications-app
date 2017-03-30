package com.worldline.comm.firebase;


import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import com.worldline.comm.Model.Notification;
import com.worldline.comm.Utils.Constant;


public class FirebaseMessageService extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage == null)
            return;


        //   JSONObject jsonObject = new JSONObject(remoteMessage.getData());
        Notification notification = null;
        if (remoteMessage.getData().size() == 0)
            return;

        try {
            notification = new Notification(remoteMessage.getData().get(Notification.Column.senderName), remoteMessage.getData().get(Notification.Column.TITLE), remoteMessage.getData().get(Notification.Column.MESSAGE));
            notification.setTimestamp(remoteMessage.getSentTime());

        } catch (Exception e) {
            e.printStackTrace();
        }


        Intent pushNotification = new Intent(Constant.General.PUSH_NOTIFICATION);
        pushNotification.putExtra("notification", notification);
        LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);

        //if (Helper.isAppIsInBackground(this))
        //  NotificationsUtils.displayNewTweetsNotification(notification, true, true);

    }

    /*@Override
    public void onDestroy() {
        super.onDestroy();

        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }*/
}
