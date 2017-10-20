package org.mangelt.spellinglesson.activities;

import org.mangelt.spellinglesson.R;
import org.mangelt.spellinglesson.R.id;
import org.mangelt.spellinglesson.activities.MainActivity.PlaceholderFragment;
import org.mangelt.spellinglesson.activities.MainActivity.PlaceholderFragmentTest;
import org.mangelt.spellinglesson.database.DataBase;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MenuActivity extends ActionBarActivity {

	private final String log = MenuActivity.class.getSimpleName();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_inflate_screen_menu);
        DataBase db = new DataBase(this);
        ContentValues values2 = db.retrieveSingleEntry(DataBase.TBLLESSONS, " id_lesson = 1 ", db.retrieveAllColumnNames(DataBase.TBLLESSONS));
    	db.close();
    	Log.i(log, "show record: " + values2.getAsInteger("id_lesson")+" "+values2.getAsString("description")+" ");
    }

}
