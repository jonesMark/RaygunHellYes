package com.mjdev.raygun;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//Urness Assignments:
//Complete Super Basic Prototype, XML lists, and Memory for bucked list/completed apps
public class MainActivity extends Activity {
	ArrayList<String> titles = new ArrayList<String>();
	ArrayList<String> description = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		File list = new File("list.txt");
		try {
			Scanner scanner = new Scanner(list);
			readInfo(scanner);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	private void readInfo(Scanner s) {
		//pull first num, numer of iterations
		int numOfItems = s.nextInt();
		while(s.hasNext()){
			//pull title
			titles.add(s.nextLine());
			s.nextLine();
			System.out.println(s.nextLine());//0
			boolean go = true;
			while (go) {
				String check = s.nextLine();
				if (Integer.parseInt(check)==0) {
					go = false;
				}
				else {
					description.add(check);
				}
			}


		}
	}
}
