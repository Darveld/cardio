package com.valsoft.cardiodiary.presentation;

import android.app.AlarmManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.presentation.ui.diary.DiaryFragment;
import com.valsoft.cardiodiary.presentation.ui.medical_card.MedicalRecordsFragment;
import com.valsoft.cardiodiary.presentation.ui.quality.QualityListFragment;
import com.valsoft.cardiodiary.presentation.ui.reminders.RemindersFragment;
import com.valsoft.cardiodiary.presentation.ui.statistic.StatisticListFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String FRAGMENT_ID = "form";
    private FragmentManager fm;
    private AlarmManager mAlarmManager;
    private int notifyType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notifyType = getIntent().getIntExtra("type_notification", 0);
        fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.frame_container);
        if (fragment == null){
            fragment = RemindersFragment.newInstance();
            fm.beginTransaction().replace(R.id.frame_container, fragment)
                    .commit();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_reminders);
//        if (notifyType == 1){
//            fm.beginTransaction()
//                    .replace(R.id.frame_container, QualityListFragment.newInstance())
//                    .commit();
//            navigationView.setCheckedItem(R.id.nav_quality);
//        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_reminders) {
            fm.beginTransaction()
                    .replace(R.id.frame_container, RemindersFragment.newInstance())
                    .commit();
        } else if (id == R.id.nav_diary) {
            fm.beginTransaction()
                    .replace(R.id.frame_container, DiaryFragment.newInstance())
                    .commit();
        } else if (id == R.id.nav_medical_record) {
            fm.beginTransaction()
                    .replace(R.id.frame_container, MedicalRecordsFragment.newInstance())
                    .commit();
        } else if (id == R.id.nav_statistic) {
            fm.beginTransaction()
                    .replace(R.id.frame_container, StatisticListFragment.newInstance())
                    .commit();
        } else if (id == R.id.nav_quality){
            fm.beginTransaction()
                    .replace(R.id.frame_container, QualityListFragment.newInstance())
                    .commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
