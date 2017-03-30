package com.worldline.comm.firebase;


import android.content.SharedPreferences;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        final String token = FirebaseInstanceId.getInstance().getToken();
        addDataToShared(token);

    }

    private void addDataToShared(String token) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("com/worldline/comm/firebase", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("regId", token);
        editor.commit();
    }


}
