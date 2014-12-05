package com.mjdev.raygun;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTab3 extends Fragment {
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	                           Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.tab_my_badges, container, false);
		//TextView textview = (TextView) view.findViewById(R.id.tabtextview);
		//textview.setText(R.string.TabThree);
		return view;
	  }
	}
