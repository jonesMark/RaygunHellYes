package com.mjdev.raygun;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

//Urness Assignments:
//Complete Super Basic Prototype, XML lists, and Memory for bucked list/completed apps
public class MainActivity extends Activity{
	//initialize tabs
	ActionBar.Tab tab1, tab2, tab3;
	Fragment fragmentTab1 = new FragmentTab1();
	Fragment fragmentTab2 = new FragmentTab2();
	Fragment fragmentTab3 = new FragmentTab3();    

	ListView listView;

	public ArrayList<String> titles = new ArrayList<String>();
	public ArrayList<String> description = new ArrayList<String>();
	
	public final static String EXTRA_MESSAGE = "com.mjdev.raygun.MESSAGE";
	
	//Now, we can populate the lists for the main screen and the xml files.  
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			parseXmlFile();
		} catch (XmlPullParserException e) {
			Log.v("Time Elements", e.toString());
		} catch (IOException e) {
			Log.v("Time Elements", e.toString());
		}
		//tabs
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		tab1 = actionBar.newTab().setText(R.string.TabOne);
		tab2 = actionBar.newTab().setText(R.string.TabTwo);
		tab3 = actionBar.newTab().setText(R.string.TabThree);

		tab1.setTabListener(new MyTabListener(fragmentTab1));
		tab2.setTabListener(new MyTabListener(fragmentTab2));
		tab3.setTabListener(new MyTabListener(fragmentTab3));

		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		actionBar.addTab(tab3);

		//list 
		listView = (ListView) findViewById(R.id.bucketlist);
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
	private void parseXmlFile() throws XmlPullParserException, IOException{
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser xpp = factory.newPullParser();
		xpp.setInput(getAssets().open("list.xml"),null);
		int eventType = xpp.getEventType();
		String lastTag = "";
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if(eventType == XmlPullParser.START_DOCUMENT) {
			} else if(eventType == XmlPullParser.END_DOCUMENT) {
			} else if(eventType == XmlPullParser.START_TAG) {
				lastTag = xpp.getName();
			} else if(eventType == XmlPullParser.END_TAG) {
				lastTag = "";
			} else if(eventType == XmlPullParser.TEXT) {
				if (lastTag.equals("title")){
					titles.add(xpp.getText());
				}
				else if (lastTag.equals("description")){
					description.add(xpp.getText());
				}
			}
			eventType = xpp.next();
		}
	}
	public ArrayList<String> getTitles() {
		return titles;
	}

}
