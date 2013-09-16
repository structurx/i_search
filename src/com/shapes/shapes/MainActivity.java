package com.shapes.shapes;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	private AlertDialog myAlertDialog;
	public static ProgressDialog pd;
	public static String URL;
	private ShapeTable shapes = new ShapeTable();
	private float[] settings = new float[6];
	private float[] search = new float[6];
	private FeetInchesType type;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_main);

		MainActivity.pd = new ProgressDialog(this);
		MainActivity.pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		MainActivity.pd.setMessage(Html.fromHtml("<font color='#000000'>Loading...</font>"));
		MainActivity.pd.setIndeterminate(true);
		MainActivity.pd.show();		
		
		getWindow().setWindowAnimations(1);
		SQLiteDatabase db = this.openOrCreateDatabase(ShapeTable.DATABASE_NAME, MODE_PRIVATE, null);		
		
		this.type = new FeetInchesType();
		this.settings = shapes.getSettings(this);
		this.search = shapes.getSearch(this);
		MainActivity.URL = "http://docs.google.com/gview?embedded=true&url=http://structurx.com/help/Help.pdf";
		Options.previous = MainActivity.class;
		
		TextView d_tolerance = (TextView) findViewById(R.id.d_tolerance);
		TextView bf_tolerance = (TextView) findViewById(R.id.bf_tolerance);
		TextView tf_tolerance = (TextView) findViewById(R.id.tf_tolerance);
		TextView tw_tolerance = (TextView) findViewById(R.id.tw_tolerance);
		TextView year_tolerance = (TextView) findViewById(R.id.year_tolerance);
		
		String value = new String();
		
		value = "\u00B1" + Float.toString(settings[1]) + "\"";
		if(value.length() > 0)
			d_tolerance.setText(value);
		
		value = "\u00B1" + Float.toString(settings[2]) + "\"";
		if(value.length() > 0)
			bf_tolerance.setText(value);
		
		value = "\u00B1" + Float.toString(settings[3]) + "\"";
		if(value.length() > 0)
			tf_tolerance.setText(value);
		
		value = "\u00B1" + Float.toString(settings[4]) + "\"";
		if(value.length() > 0)
			tw_tolerance.setText(value);
		
		value = "\u00B1" + Integer.toString((int)settings[5]);
		if(value.length() > 0 && settings[5] > 1)
			year_tolerance.setText(value + " years");
		else
			year_tolerance.setText(value + " year");
		
		// add event listeners for edit text fields
		final EditText et_d = (EditText) findViewById(R.id.d);
		final EditText et_bf = (EditText) findViewById(R.id.bf);
		final EditText et_tf = (EditText) findViewById(R.id.tf);
		final EditText et_tw = (EditText) findViewById(R.id.tw);
		final EditText et_year = (EditText) findViewById(R.id.year);
		
		/*
		final TextWatcher text_watcher = new TextWatcher()
		{
            public void afterTextChanged(Editable s){            	
            	if(!s.toString().matches("^[0-9]*.?[0-9 ]*[foet\']*[0-9 -]*.?[0-9 ]*[inches\"]*$"))
            	{
            		et_d.removeTextChangedListener(this);
            		et_d.setText(s.toString().replaceAll("[^0-9 .-]*", ""));
            		et_d.addTextChangedListener(this);
            	}            	
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after){}

            public void onTextChanged(CharSequence s, int start, int before, int count){}
		};
            
		et_d.addTextChangedListener(text_watcher);		
		*/
		
		et_d.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            {
		            	et_d.setHint("");
		            	et_d.setBackgroundResource(R.drawable.selected_edittext_dark);
		            }
		            else
		            {
		            	type.setDisplayValue("0", 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		            	type.setDisplayValue(et_d.getText().toString(), 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			        	String t = type.getDisplayValue();
			        	et_d.setText(t);
			        	et_d.setHint(R.string.d);
			        	et_d.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_d.setText("");
	        		et_d.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		et_bf.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		        	if(hasFocus)
		            {
		        		et_bf.setHint("");
		        		et_bf.setBackgroundResource(R.drawable.selected_edittext_dark);
		            }
		        	else
		            {
		        		type.setDisplayValue("0", 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		            	type.setDisplayValue(et_bf.getText().toString(), 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			        	String t = type.getDisplayValue();
			        	et_bf.setText(t);
			        	et_bf.setHint(R.string.bf);
			        	et_bf.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_bf.setText("");
	        		et_bf.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		et_tf.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		        	if(hasFocus)
		            {
		        		et_tf.setHint("");
		        		et_tf.setBackgroundResource(R.drawable.selected_edittext_dark);
		            }
		        	else
		            {
		        		type.setDisplayValue("0", 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		            	type.setDisplayValue(et_tf.getText().toString(), 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			        	String t = type.getDisplayValue();
			        	et_tf.setText(t);
			        	et_tf.setHint(R.string.tf);
			        	et_tf.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_tf.setText("");
	        		et_tf.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		et_tw.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		        	if(hasFocus)
		            {
		        		et_tw.setHint("");
		        		et_tw.setBackgroundResource(R.drawable.selected_edittext_dark);
		            }
		        	else
		            {
		        		type.setDisplayValue("0", 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		            	type.setDisplayValue(et_tw.getText().toString(), 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			        	String t = type.getDisplayValue();
			        	et_tw.setText(t);
			        	et_tw.setHint(R.string.tw);
			        	et_tw.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_tw.setText("");
	        		et_tw.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });	
		
		et_year.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		        	if(hasFocus)
		            {
		        		et_year.setHint("");
		        		et_year.setBackgroundResource(R.drawable.selected_edittext_dark);
		            }
		        	else
		            {
		        		et_year.setHint(R.string.year);
			        	et_year.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_year.setText("");
	        		et_year.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		/* search[]
		 * 1 - d 
		 * 2 - bf 
		 * 3 - tf 
		 * 4 - tw  
		 * 5 - years
		 */
		
		value = Float.toString(search[1]);
		if(value.length() > 0 && search[1] > 0)
		{
			type.setDisplayValue(value, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			et_d.setText(type.getDisplayValue());
		}
		
		value = Float.toString(search[2]);
		if(value.length() > 0 && search[2] > 0)
		{
			type.setDisplayValue(value, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			et_bf.setText(type.getDisplayValue());
		}
	
		value = Float.toString(search[3]);
		if(value.length() > 0 && search[3] > 0)
		{
			type.setDisplayValue(value, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			et_tf.setText(type.getDisplayValue());
		}
		
		value = Float.toString(search[4]);
		if(value.length() > 0 && search[4] > 0)
		{
			type.setDisplayValue(value, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			et_tw.setText(type.getDisplayValue());
		}
		
		value = Float.toString(search[5]);
		if(value.length() > 0 && search[5] > 0)
		{			
			et_year.setText(value);
		}
		
		if(ShapeTable.CREATED == true)
			db.execSQL("UPDATE " + ShapeTable.TABLE_SHAPES + " SET end_year = '" + Calendar.getInstance().get(Calendar.YEAR) + "' WHERE end_year >= '2010';");
		
		db.close();
		MainActivity.pd.dismiss();
	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	// Called when the user clicks the Options button
	public void options_click(MenuItem menu_item) {		
		EditText et_d = (EditText) findViewById(R.id.d);
		EditText et_bf = (EditText) findViewById(R.id.bf);
		EditText et_tf = (EditText) findViewById(R.id.tf);
		EditText et_tw = (EditText) findViewById(R.id.tw);
		EditText et_year = (EditText) findViewById(R.id.year);
		
		String str_d = et_d.getText().toString();
		String str_bf = et_bf.getText().toString();
		String str_tf = et_tf.getText().toString();
		String str_tw = et_tw.getText().toString();
		String str_year = et_year.getText().toString();
		
		if(str_d.length() > 0)
			this.search[1] = Float.parseFloat(str_d.replace("\"",""));
		else
			this.search[1] = 0;
			
		if(str_bf.length() > 0)
			this.search[2] = Float.parseFloat(str_bf.replace("\"",""));
		else
			this.search[2] = 0;
		
		if(str_tf.length() > 0)
			this.search[3] = Float.parseFloat(str_tf.replace("\"",""));
		else
			this.search[3] = 0;
			
		if(str_tw.length() > 0)
			this.search[4] = Float.parseFloat(str_tw.replace("\"",""));
		else
			this.search[4] = 0;
			
		if(str_year.length() > 0)
			this.search[5] = Float.parseFloat(str_year);
		else
			this.search[5] = 0;
		
		shapes.updateSearch(this.search, this);
		
		Options.previous = MainActivity.class;
		Intent intent = new Intent(this, Options.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
		overridePendingTransition(R.anim.push_up, R.anim.push_out);
	}
	
	// Called when the user clicks the Search button
	public void search_click(View view) 
	{		
		// get the edit view object
		EditText et_d = (EditText) findViewById(R.id.d);
		EditText et_bf = (EditText) findViewById(R.id.bf);
		EditText et_tf = (EditText) findViewById(R.id.tf);
		EditText et_tw = (EditText) findViewById(R.id.tw);
		EditText et_year = (EditText) findViewById(R.id.year);
		
		// create a String object with the text
		String str_d = et_d.getText().toString();
		String str_bf = et_bf.getText().toString();
		String str_tf = et_tf.getText().toString();
		String str_tw = et_tw.getText().toString();
		String str_year = et_year.getText().toString();
		
		if(is_valid(str_d, str_bf, str_tf, str_tw, str_year))
		{
			LinearLayout layout = (LinearLayout) findViewById(R.id.init);
			layout.requestFocus();
			
			MainActivity.pd = new ProgressDialog(this);
			MainActivity.pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			MainActivity.pd.setMessage(Html.fromHtml("<font color='#000000'>Searching for shapes.</font>"));
			MainActivity.pd.setIndeterminate(true);
			MainActivity.pd.show();
			
			if(str_d.length() > 0)
				this.search[1] = Float.parseFloat(str_d.replace("\"",""));
			else
				this.search[1] = 0;
			
			if(str_bf.length() > 0)
				this.search[2] = Float.parseFloat(str_bf.replace("\"",""));
			else
				this.search[2] = 0;
			
			if(str_tf.length() > 0)
				this.search[3] = Float.parseFloat(str_tf.replace("\"",""));
			else 
				this.search[3] = 0;
			
			if(str_tw.length() > 0)
				this.search[4] = Float.parseFloat(str_tw.replace("\"",""));
			else
				this.search[4] = 0;
			
			if(str_year.length() > 0)
				this.search[5] = Float.parseFloat(str_year);
			else
				this.search[5] = 0;			
			
			shapes.updateSearch(this.search, this);
			
			Intent intent = new Intent(this, ResultsList.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);			
			overridePendingTransition(R.anim.push_up, R.anim.push_out);
		}
	}
	
	private boolean is_valid(String str_d, String str_bf, String str_tf, String str_tw, String str_year)
	{
		boolean result = false;
		int year = 0;
		int fields = 0;
		
		float d = 0;
		float bf = 0;
		float tf = 0;
		float tw = 0;
		
		// check if there are at least two fields
		if(str_d.length() > 0)
		{
			d = Float.parseFloat(str_d.replace("\"", ""));
			fields++;
		}
		
		if(str_bf.length() > 0)
		{
			bf = Float.parseFloat(str_bf.replace("\"", ""));
			fields++;
		}
		
		if(str_tf.length() > 0)
		{
			tf = Float.parseFloat(str_tf.replace("\"", ""));
			fields++;
		}
		
		if(str_tw.length() > 0)
		{
			tw = Float.parseFloat(str_tw.replace("\"", ""));
			fields++;
		}
		
		if(str_year.length() == 4)
			fields++;
		
		if(fields >= 2)
		{
			boolean numeric = true;
			
			// check if it's a number
			if(!str_d.matches("[0-9\" '-.]*"))
				numeric = false;
			if(!str_bf.matches("[0-9\" '-.]*"))
				numeric = false;
			if(!str_tf.matches("[0-9\" '-.]*"))
				numeric = false;
			if(!str_tw.matches("[0-9\" '-.]*"))
				numeric = false;
			
			if(str_year.length() > 0)
			{
				if(str_year.matches("[0-9]*"))
					year = Integer.parseInt(str_year);
				else
					numeric = false;
			}
			
			if(numeric)
			{				
				if((d > 0) && (d < 3 || d > 50))
					showDialog(this, "Value d out of range (3-50).");
				else if((bf > 0) && (bf < 2 || bf > 20))
					showDialog(this, "Value bf out of range (2-20).");
				else if((tf > 0) && (tf < 0 || tf > 3))
					showDialog(this, "Value tf out of range (0-3).");
				else if((tw > 0) && (tw < 0 || tw > 2))
					showDialog(this, "Value tw out of range (0-2).");
				else if((year > 0 && year < 1870) || (year > Calendar.getInstance().get(Calendar.YEAR)))
					showDialog(this, "Year out of range (1870+).");
				else					
					result = true;
			}
			else
				showDialog(this, "Please enter a valid number.");
		}
		else
		{
			showDialog(this, "Please enter at least two criteria.");	
		}
		
		return result;
	}	
	
	public void showDialog(Context context, String message) 
	{
        if( myAlertDialog != null && myAlertDialog.isShowing() ) return;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(Html.fromHtml("<font color='#000000'>Invalid Search</font>"));
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    dialog.dismiss();
                }});
        builder.setCancelable(false);
        myAlertDialog = builder.create();
        myAlertDialog.show();
	}
	
	public void about_click(MenuItem menu)
	{
		Intent intent = new Intent(this, About.class);
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

	/*
	private void click_button_effect(Button button, boolean selected)
	{
		if(selected)
		{
			button.setBackgroundResource(R.drawable.selected_button);
			button.setTextColor(Color.WHITE);
			button.setClickable(false);
		}
		else
		{
			button.setBackgroundResource(R.drawable.rounded_button);
			button.setTextColor(Color.BLACK);
			button.setClickable(true);
		}
	}
	*/
}
