package com.andanhm.healthcare.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.andanhm.healthcare.R;
import com.andanhm.healthcare.fragment.Drawer;
import com.andanhm.healthcare.fragment.Appointment;
import com.andanhm.healthcare.fragment.Doctor;
import com.andanhm.healthcare.fragment.Home;

public class Main extends AppCompatActivity implements Drawer.FragmentDrawerListener {

    private static String TAG = Main.class.getSimpleName();

    private ActionBar mActionBar;
    private Activity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity=Main.this;
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mActionBar=getSupportActionBar();
        setSupportActionBar(mToolbar);
        if (mActionBar!=null){
          mActionBar.setDisplayShowHomeEnabled(true);
        }

        Drawer mDrawerFragment = (Drawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        mDrawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.healthcare_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(mActivity, getString(R.string.action_select), Toast.LENGTH_SHORT).show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new Home();
                title = getString(R.string.title_home);
                break;
            case 1:
                fragment = new Appointment();
                title = getString(R.string.text_appointment);
                break;
            case 2:
                fragment = new Doctor();
                title = getString(R.string.text_doctors);
                break;
            case 3:
                startActivity(new Intent(mActivity,AboutUs.class));
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            //Set the toolbar title
            if(mActionBar != null){
                mActionBar.setTitle(title);
            }
        }
    }
}