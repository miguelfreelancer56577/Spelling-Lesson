package org.mangelt.spellinglesson.activities;

import org.mangelt.spellinglesson.R;
import org.mangelt.spellinglesson.R.id;
import org.mangelt.spellinglesson.activities.MainActivity.PlaceholderFragment;
import org.mangelt.spellinglesson.activities.MainActivity.PlaceholderFragmentTest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class MenuActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_inflate_screen_menu);
    }

}
