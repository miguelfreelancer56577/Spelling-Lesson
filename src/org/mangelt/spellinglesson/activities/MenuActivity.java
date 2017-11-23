package org.mangelt.spellinglesson.activities;

import java.util.ArrayList;

import org.mangelt.spellinglesson.R;
import org.mangelt.spellinglesson.R.id;
import org.mangelt.spellinglesson.activities.MainActivity.PlaceholderFragment;
import org.mangelt.spellinglesson.activities.MainActivity.PlaceholderFragmentTest;
import org.mangelt.spellinglesson.database.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends ActionBarActivity {

	private final String log = MenuActivity.class.getSimpleName();
	public ArrayList<ContentValues> lessons = new ArrayList<ContentValues>();
	public final static String EXTRA_ID_LESSON = "id_lesson";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_inflate_screen_menu);
        DataBase db = new DataBase(this);
        lessons = db.retrieveAllEntries(DataBase.TBLLESSONS, db.retrieveAllColumnNames(DataBase.TBLLESSONS));
    	db.close();
    	Log.i(log, "Records are into the table: " + DataBase.TBLLESSONS +" \n"+ lessons);
//    	inflate the layout
    	LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        FrameLayout content = (FrameLayout) this.findViewById(id.content);
        LinearLayout l = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        l.setLayoutParams(layoutParams);
        content.addView(l);
        int counter = 0;
        int keepId = 1;
        int idlayout = keepId;
        l.setId(idlayout);
    	for (ContentValues record : lessons) {
            if( counter ==  3 ){
            	layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            	LinearLayout KeepAlive = l; 
            	l = new LinearLayout(this);
            	l.setLayoutParams(layoutParams);
            	content.addView(l);
            	l.setId(idlayout);
            	layoutParams.addRule(RelativeLayout.BELOW,KeepAlive.getId());
            	counter = 0;
            	keepId = idlayout;
            }
            final RelativeLayout innerItem = (RelativeLayout) inflater.inflate(R.layout.inner_relative_item_menu, null);
            l.addView(innerItem);
            TextView txt1 = (TextView)innerItem.findViewWithTag("txt");
            txt1.setText(record.getAsString("description"));
            innerItem.setId(record.getAsInteger("id_lesson"));
            innerItem.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                	Intent sendIntent = new Intent(MenuActivity.this, AskActivity.class);
                	sendIntent.putExtra(EXTRA_ID_LESSON, innerItem.getId());
            		startActivity(sendIntent);
                }
            });
            idlayout++;
		}

    }

}
