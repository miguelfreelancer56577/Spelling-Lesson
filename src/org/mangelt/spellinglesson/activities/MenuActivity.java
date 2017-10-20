package org.mangelt.spellinglesson.activities;

import java.util.ArrayList;

import org.mangelt.spellinglesson.R;
import org.mangelt.spellinglesson.R.id;
import org.mangelt.spellinglesson.activities.MainActivity.PlaceholderFragment;
import org.mangelt.spellinglesson.activities.MainActivity.PlaceholderFragmentTest;
import org.mangelt.spellinglesson.database.DataBase;

import android.content.ContentValues;
import android.content.Context;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends ActionBarActivity {

	private final String log = MenuActivity.class.getSimpleName();
	public ArrayList<ContentValues> lessons = new ArrayList<ContentValues>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_inflate_screen_menu);
        DataBase db = new DataBase(this);
        lessons = db.retrieveAllEntries(DataBase.TBLLESSONS, db.retrieveAllColumnNames(DataBase.TBLLESSONS));
    	db.close();
    	Log.i(log, "Records are into the table: " + DataBase.TBLLESSONS +" \n"+ lessons);
//    	inflate the layout
        FrameLayout content = (FrameLayout) this.findViewById(id.content);
        LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View child = inflater.inflate(R.layout.example, content);
        RelativeLayout onclick = (RelativeLayout) child.findViewById(id.onclick);
        TextView txt1 = (TextView)child.findViewById(id.txt1);
        txt1.setText(lessons.get(0).getAsString("description"));
        onclick.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            }
        });
    }

}
