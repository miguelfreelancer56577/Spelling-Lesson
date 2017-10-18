package org.mangelt.spellinglesson.activities;

import org.mangelt.spellinglesson.R;
import org.mangelt.spellinglesson.activities.MainActivity.PlaceholderFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class BeginActivity extends ActionBarActivity {

	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_screen_login);
    }
	
	public void goMenu(View v){
		Intent sendIntent = new Intent(this, MenuActivity.class);
		startActivity(sendIntent);
	}
	
}
