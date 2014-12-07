package com.mjdev.raygun;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TaskDescription extends Activity {

	ArrayList<String> titles = new ArrayList<String>();
	ArrayList<String> description = new ArrayList<String>();
	
	public final static String EXTRA_MESSAGE = "com.mjdev.raygun.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int ndx = -1;
		setContentView(R.layout.activity_task_description);
		Intent i = getIntent();
		titles = i.getStringArrayListExtra("titles");
		description = i.getStringArrayListExtra("descriptions");
		String task = i.getStringExtra("task");
		for(String t : titles){
			if(t.equals(task)){
				ndx = titles.indexOf(t);
			}
		}
		TextView tv = (TextView) findViewById(R.id.desc);
		tv.setText(description.get(ndx));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.task_description, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.badges) {
			goToBadges(item.getActionView());
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void goToBadges(View view){
		Intent intent = new Intent(this, Badges.class);
		startActivity(intent);
	}
}
