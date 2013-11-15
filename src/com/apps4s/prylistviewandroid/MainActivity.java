package com.apps4s.prylistviewandroid;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] arrayCountries = new String[]{"Brasil","Mexico","Colombia",
				"Argentina","Peru","Venezuela","Chile","Ecuador","Guatemala","Cuba"};
		ArrayList<String> countries = new ArrayList<String>(Arrays.asList(arrayCountries));
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);
		ListView list = (ListView)findViewById(R.id.listViewPaises);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
		// TODO Auto-generated method stub
		String country = adapterView.getItemAtPosition(position).toString();
		Intent intent = new Intent(this, DetallePaisActivity.class);
		intent.putExtra(DetallePaisActivity.COUNTRY, country);
		startActivity(intent);
		
	}

}
