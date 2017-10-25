package org.mangelt.spellinglesson.activities;

import org.mangelt.spellinglesson.R;
import org.mangelt.spellinglesson.activities.MainActivity.PlaceholderFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

public class AskActivity extends ActionBarActivity {

	private final String log = AskActivity.class.getSimpleName();
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_question);
        Intent i = getIntent();
        int id_lesson = i.getIntExtra(MenuActivity.EXTRA_ID_LESSON, 0);
        Log.i(log, "show lesson: " + id_lesson);
    }
	
	public void goMenu(View v){
		Intent sendIntent = new Intent(this, MenuActivity.class);
		startActivity(sendIntent);
	}
	
}
