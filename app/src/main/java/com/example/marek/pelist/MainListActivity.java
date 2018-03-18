package com.example.marek.pelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainListActivity extends AppCompatActivity {
    private List<ProfileModel> models;

    public final static int ADD_CONTACT_REQ_CODE = 1;

    public MainListActivity() {
        models = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupAddButton();
        setupList();
        addTestProfiles();
    }

    protected void setupAddButton() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newUserIntent = new Intent(view.getContext(), ProfileEditingActivity.class);
                startActivityForResult(newUserIntent, ADD_CONTACT_REQ_CODE);
            }
        });
    }

    protected void setupList() {
        ListView profilesListView = (ListView)findViewById(R.id.profiles_list);

        if (profilesListView != null) {
            ProfileListAdapter profiles = new ProfileListAdapter(getBaseContext(), R.layout.person_entry, models);
            profilesListView.setAdapter(profiles);
        }
    }

    protected void addTestProfiles() {
        models.add(new ProfileModel("Marek", "Iwaniuk", new Date()));
        models.add(new ProfileModel("Jakub", "Holowczyc", new Date()));
        models.add(new ProfileModel("Janusz", "Skwierczak", new Date()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_CONTACT_REQ_CODE) {
            if (resultCode == RESULT_OK) {
                ProfileModel model = (ProfileModel)data.getExtras().getSerializable("ProfileModel");

                if (model != null) {
                    models.add(model);
                }
            }
        }
    }
}
