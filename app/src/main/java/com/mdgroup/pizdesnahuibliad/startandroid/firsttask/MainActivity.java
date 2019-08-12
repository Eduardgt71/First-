package com.mdgroup.pizdesnahuibliad.startandroid.firsttask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null)
        {
            // Display the fragment as the main content.
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contentFragment, new ProgressFragment())
                    .commit();
        }

    }
}
