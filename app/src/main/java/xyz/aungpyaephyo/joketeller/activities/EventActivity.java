package xyz.aungpyaephyo.joketeller.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import xyz.aungpyaephyo.joketeller.JokeTellerApp;
import xyz.aungpyaephyo.joketeller.R;
import xyz.aungpyaephyo.joketeller.data.vos.EventVO;
import xyz.aungpyaephyo.joketeller.fragments.EventFragment;

/**
 * Created by aung on 6/26/16.
 */
public class EventActivity extends AppCompatActivity
        implements EventFragment.ControllerEventItem{

    public static Intent newIntent() {
        Intent intent = new Intent(JokeTellerApp.getContext(), EventActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        FloatingActionButton fabSearch = (FloatingActionButton) findViewById(R.id.fab_search);
        fabSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Search on Phandeeyar Events", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (savedInstanceState == null) {
            EventFragment fragment = EventFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onTapEvent(EventVO event) {
        Intent intent = EventDetailActivity.newIntent(event.getEventTitle());
        startActivity(intent);
    }
}
