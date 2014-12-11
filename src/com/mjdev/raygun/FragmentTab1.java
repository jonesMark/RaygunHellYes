package com.mjdev.raygun;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;


import junit.framework.Assert;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class FragmentTab1 extends Fragment {
	ListView listView;
	int num = 1;
	String[] text = { "I NEED A VACA", "GIVE ME A DOLLA", "PARTY!!!", "WHO NEES SLEEP?", "Five", "Six", "Seven",
			"Eight", "Nine", "Ten" };
	/*	ListView listview;
	int num = 1; 
	String[] text = { "I NEED A VACA", "GIVE ME A DOLLA", "PARTY!!!", "WHO NEES SLEEP?", "Five", "Six", "Seven",
			"Eight", "Nine", "Ten" };

	int[] image = { R.drawable.one, R.drawable.two, R.drawable.three,
			R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven,
			R.drawable.eight, R.drawable.nine, R.drawable.ten };
	int textlength = 0;
	ArrayList<String> text_sort = new ArrayList<String>();
	ArrayList<Integer> image_sort = new ArrayList<Integer>();
	
			listview = (ListView) findViewById(R.id.ListView01);
		listview.setAdapter(new MyCustomAdapter(text, image));

*/
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	                           Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.frag1, container, false);
		view.setClickable(true);
		ListView listView = (ListView) view.findViewById(R.id.ListView01);
		//listView.setAdapter(new MyCustomAdapter(text));
		listView.setOnItemClickListener(myClickListener);
		return view;
	  }
		class MyCustomAdapter extends BaseAdapter
		{

			String[] data_text;
			//int[] data_image;

			MyCustomAdapter()
			{

			}

			MyCustomAdapter(String[] text)
			{
				data_text = text;
				//data_image = image;
			}
			MyCustomAdapter(ArrayList<String> text)
			{
				data_text = new String[text.size()];
				//data_image = new int[image.size()];

				for(int i=0;i<text.size();i++)
				{
					data_text[i] = text.get(i);
					//data_image[i] = image.get(i);
				}

			}

			public int getCount()
			{
				return data_text.length;
			}

			public String getItem(int position)
			{
				return null;
			}

			public long getItemId(int position)
			{
				return position;
			}

			@SuppressLint("NewApi")
			public View getView(int position, View convertView, ViewGroup parent)
			{
				
				LayoutInflater inflater = getActivity().getLayoutInflater();
				View row;
				row = inflater.inflate(R.layout.listview, parent, false);
				//String back = Integer.toString(num);
				//row.setBackground(R.id.(Integer.toString(num)));
				TextView textview = (TextView) row.findViewById(R.id.TextView01);
				//ImageView imageview = (ImageView) row.findViewById(R.id.ImageView01);
				//imageview.setVisibility(imageview.INVISIBLE);
				//getResources().getIdentifier(imagename, "drawable", this.getPackageName()
				
				
				
				textview.setText(data_text[position]);
				//textview.setBackground(getResources().getDrawable(R.drawable.eight));
				//().getDrawable(R.drawable.ready)
				String imagename = "i" + num;
				num ++;
				if (num == 4) {
					num = 1;
				}
				//row.setBackground(getResources().getIdentifier(imagename, "drawable", null ));
				//row.setBackground(getDrawable(getApplicationContext(), imagename));			
				row.setBackground(getResources().getDrawable(getDrawables( getActivity().getBaseContext() , imagename)));

				//imageview.setImageResource(data_image[position]);

				return (row);

			}
		}
	    public static int getDrawables(Context context, String name)
	    {
	        Assert.assertNotNull(context);
	        Assert.assertNotNull(name);

	        return context.getResources().getIdentifier(name,
	                "drawable", context.getPackageName());
	    }
	  public OnItemClickListener myClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			MainActivity act = (MainActivity) getActivity();
			String entry = (String) parent.getItemAtPosition(position);
            Intent intent = new Intent(view.getContext(), TaskDescription.class);
            intent.putExtra("task", entry);
        	intent.putStringArrayListExtra("titles", act.titles);
        	intent.putStringArrayListExtra("descriptions", act.description);
            startActivity(intent);
		}
	  };
	}