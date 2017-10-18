package org.mangelt.spellinglesson.activities;

import org.mangelt.spellinglesson.R;
import org.mangelt.spellinglesson.R.id;
import org.mangelt.spellinglesson.R.layout;
import org.mangelt.spellinglesson.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	public static int layout = R.layout.screen_login;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action1) {
        	layout = R.layout.screen_login;
        	getSupportFragmentManager().beginTransaction()
            .add(R.id.container, new PlaceholderFragment())
            .commit();
            return true;
        }
        if (id == R.id.action2) {
        	layout = R.layout.screen_menu;
        	getSupportFragmentManager().beginTransaction()
            .add(R.id.container, new PlaceholderFragment())
            .commit();
            return true;
        }
        if (id == R.id.action3) {
        	layout = R.layout.screen_question;
        	getSupportFragmentManager().beginTransaction()
            .add(R.id.container, new PlaceholderFragment())
            .commit();
            return true;
        }
        if (id == R.id.action4) {
        	layout = R.layout.test_inflate_screen_menu;
        	getSupportFragmentManager().beginTransaction()
            .add(R.id.container, new PlaceholderFragmentTest())
            .commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(layout, container, false);
            return rootView;
        }
    }
    
    public static class PlaceholderFragmentTest extends Fragment {

        public PlaceholderFragmentTest() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(layout, container, false);
            FrameLayout content = (FrameLayout) rootView.findViewById(id.content);
            View child = inflater.inflate(R.layout.example, content);
            return rootView;
        }
    }

}
