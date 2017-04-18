package com.worldline.comm.landingpage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.worldline.comm.LoginActivity;
import com.worldline.comm.Model.Notification;
import com.worldline.comm.R;
import com.worldline.comm.Utils.Constant;
import com.worldline.comm.pdfreader.PDFReaderActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Bind(R.id.toolbar)
    Toolbar toolbar;

/*
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
*/

    @Bind(R.id.textViewName)
    TextView textViewName;

    @Bind(R.id.textViewTitle)
    TextView textViewTitle;

    @Bind(R.id.textViewMessage)
    TextView textViewMessage;

    @Bind(R.id.textTime)
    TextView textTime;


    @Bind(R.id.notification_listadapter)
    View container;

    @Bind(R.id.emptylistview)
    View emptylistviewContainer;

    @Bind(R.id.navigation_view)
    NavigationView navigation_view;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private BroadCast broadCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
//        recyclerView.setVisibility(View.GONE);

        broadCast = new BroadCast();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigation_view.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        container.setVisibility(View.GONE);
        emptylistviewContainer.setVisibility(View.VISIBLE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadCast(), new IntentFilter(Constant.General.PUSH_NOTIFICATION));

    }

    @Override
    protected void onPause() {
        super.onPause();

        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadCast);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        Intent intent;
        switch (id) {
            case R.id.home:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.pdf:
                intent = new Intent(this, PDFReaderActivity.class);
                startActivity(intent);
                break;

            case R.id.logout:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            default:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.START))
            drawerLayout.closeDrawer(Gravity.START);
        else
            super.onBackPressed();
    }

    private class BroadCast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            //System.out.print(intent);

            container.setVisibility(View.VISIBLE);
            emptylistviewContainer.setVisibility(View.GONE);
            final Bundle extras = intent.getExtras();

            Notification notification = (Notification) extras.getSerializable("notification");

            textViewTitle.setText(notification.getTitle());
            textViewName.setText(notification.getSenderName());
            textViewMessage.setText(notification.getMessage());
            textTime.setText(notification.getTimestamp());


            /*//retriving all the notification
            listOfNotification = new DatabaseService().getListNotification(databaseHelper, ListNotification.this);
            notificationListAdapter.setData(listOfNotification);
            notificationListAdapter.notifyDataSetChanged();
            mLayoutManager.scrollToPosition(0);
            //only once to call show
            if (listOfNotification.size() == 1)
                showRecyclerView();*/


        }
    }


}
