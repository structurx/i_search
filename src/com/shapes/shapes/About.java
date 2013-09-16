package com.shapes.shapes;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class About extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		
		TextView txt_website = (TextView) findViewById(R.id.website);
		
		txt_website.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW); 
				intent.setData(Uri.parse("http://www.structurx.com"));
				About.this.startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_about, menu);
		return true;
	}
	
	public void home_click(MenuItem menu_item) {
		Intent intent = new Intent(this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);		
		overridePendingTransition(R.anim.push_up, R.anim.push_out);
	}
	
	 public void options_click(MenuItem menu_item) {
		Intent intent = new Intent(this, Options.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);	
		overridePendingTransition(R.anim.push_up, R.anim.push_out);
	}
	 
	public void help_click(MenuItem menu)
	{
		Intent intent = new Intent(Intent.ACTION_VIEW); 
		intent.setData(Uri.parse(MainActivity.URL));
		this.startActivity(intent);
	}

}
