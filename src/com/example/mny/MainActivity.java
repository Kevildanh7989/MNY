package com.example.mny;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.slidingmenu.lib.SlidingMenu;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.R.drawable.*;



public class MainActivity extends ListActivity {
	
	
	//creates a list view in an array
		ListView myList; 
	    String[] listContent = {
	    	"East London Mosque", 
	    	"Finsbury Park Mosque"
	    };
	    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    
		//list view by id
		//myList = (ListView)findViewById(R.id.list);
		ListView myList = getListView();
		//Adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.mylistlayout, listContent);
		myList.setAdapter(adapter);
		
		//title on top of action bar
		setTitle(R.string.attach);
		 // configure the SlidingMenu
        SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        menu.setMenu(R.layout.menu_frame);
        getFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame, new Fragment())
		.commit();
		
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	    // set each click to a new class
		switch( position )
		{
		   case 0:  Intent newActivity0 = new Intent(this, Maps.class);     
		            startActivity(newActivity0);
		            break;
		   case 1:  Intent newActivity1 = new Intent(this, MainActivity.class);     
		            startActivity(newActivity1);
		            break;
		            }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.main, menu);
	    SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
	    // Configure the search info and add any event listeners
	    
	    return super.onCreateOptionsMenu(menu);
	}
	
	
}
 

