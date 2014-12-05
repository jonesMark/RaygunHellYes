package com.mjdev.raygun;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FragmentTab1 extends Fragment {
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	                           Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.tab1, container, false);
		view.setClickable(true);
		ListView listView = (ListView) view.findViewById(R.id.bucketlist);
		listView.setOnItemClickListener(myClickListener);
		//TextView textview = (TextView) view.findViewById(R.id.tabtextview);
		//textview.setText(R.string.TabOne);
		return view;
	  }
	  public OnItemClickListener myClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			MainActivity act = (MainActivity) getActivity();
			String entry = (String) parent.getItemAtPosition(position);
//        	String entry = ((TextView)view).getText().toString();
            Intent intent = new Intent(view.getContext(), TaskDescription.class);
            intent.putExtra("task", entry);
        	intent.putStringArrayListExtra("titles", act.titles);
        	Log.v("Time Elements", act.description.get(0).toString());
        	intent.putStringArrayListExtra("descriptions", act.description);
            startActivity(intent);
		}
	  };
	}