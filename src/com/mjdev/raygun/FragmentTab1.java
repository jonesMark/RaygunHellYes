package com.mjdev.raygun;


import java.util.ArrayList;

import junit.framework.Assert;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class FragmentTab1 extends Fragment {
	ListView listView;
	int num = 1;
	String[] text;
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	                           Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.frag1, container, false);
		System.out.print("I AM RUNNING");
		Log.d("TAG", "Message");
		view.setClickable(true);
		ListView listView = (ListView) view.findViewById(R.id.ListView01);
		listView.setOnItemClickListener(myClickListener);

		text = getResources().getStringArray(R.array.bucket_list);
		listView.setAdapter(new MyCustomAdapter(text));
		
		return view;
	  }
		class MyCustomAdapter extends BaseAdapter
		{

			String[] data_text;

			MyCustomAdapter()
			{

			}

			MyCustomAdapter(String[] text)
			{
				data_text = text;
			}
			MyCustomAdapter(ArrayList<String> text)
			{
				data_text = new String[text.size()];

				for(int i=0;i<text.size();i++)
				{
					data_text[i] = text.get(i);
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

			@SuppressLint({ "NewApi", "ViewHolder" })
			public View getView(int position, View convertView, ViewGroup parent)
			{
				
				LayoutInflater inflater = getActivity().getLayoutInflater();
				View row;
				row = inflater.inflate(R.layout.listview, parent, false);
				TextView textview = (TextView) row.findViewById(R.id.TextView01);				
				
				
				textview.setText(data_text[position]);
				textview.setBackgroundColor(0xB3FFFFFF);
				String imagename = "i" + num;
				num ++;
				if (num == 4) {
					num = 1;
				}

				row.setBackground(getResources().getDrawable(getDrawables( getActivity().getBaseContext() , imagename)));

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
			Log.d("message01", Integer.toString(position));
			//String entry = (String) parent.getItemAtPosition(position);
			Log.d("killme","dummy message");
            Intent intent = new Intent(view.getContext(), TaskDescription.class);
            intent.putExtra("task", "Zoo Brew");
        	intent.putStringArrayListExtra("titles", act.titles);
        	intent.putStringArrayListExtra("descriptions", act.description);
            startActivity(intent);
		}
	  };
	}