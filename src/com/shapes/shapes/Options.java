package com.shapes.shapes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Options extends Activity {
	
	private float[] settings = new float[7];
	private FeetInchesType type;
	private AlertDialog myAlertDialog;	
	private boolean changed;
	public static Class<?> previous;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ShapeTable shapes = new ShapeTable();
		String value = new String();
		
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_options);
		
		getWindow().setWindowAnimations(1);
		
		this.changed = false;
		this.type = new FeetInchesType();
		this.settings = shapes.getSettings(this);
		
		final EditText et_d_tolerance = (EditText) findViewById(R.id.d_tolerance);
		final EditText et_bf_tolerance = (EditText) findViewById(R.id.bf_tolerance);
		final EditText et_tf_tolerance = (EditText) findViewById(R.id.tf_tolerance);
		final EditText et_tw_tolerance = (EditText) findViewById(R.id.tw_tolerance);
		final EditText et_year_tolerance = (EditText) findViewById(R.id.year_tolerance);
		final RadioButton ASD = (RadioButton) findViewById(R.id.asd);
		final RadioButton LRFD = (RadioButton) findViewById(R.id.lrfd);
		
		value = Float.toString(settings[1]);
		if(value.length() > 0 && settings[1] > 0)
		{
			type.setDisplayValue(value, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			et_d_tolerance.setText(type.getDisplayValue());
		}
		else
		{
			et_d_tolerance.setText("0\"");
		}
		
		value = Float.toString(settings[2]);
		if(value.length() > 0 && settings[2] > 0)
		{
			type.setDisplayValue(value, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			et_bf_tolerance.setText(type.getDisplayValue());
		}
		else
		{
			et_bf_tolerance.setText("0\"");
		}
		
		value = Float.toString(settings[3]);
		if(value.length() > 0 && settings[3] > 0)
		{
			type.setDisplayValue(value, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			et_tf_tolerance.setText(type.getDisplayValue());
		}
		else
		{
			et_tf_tolerance.setText("0\"");
		}
		
		value = Float.toString(settings[4]);
		if(value.length() > 0 && settings[4] > 0)
		{
			type.setDisplayValue(value, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			et_tw_tolerance.setText(type.getDisplayValue());
		}
		else
		{
			et_tw_tolerance.setText("0\"");
		}
		
		value = Integer.toString((int)settings[5]);
		if(value.length() > 0 && settings[5] > 0)
		{
			et_year_tolerance.setText(value);
		}
		else
		{
			et_year_tolerance.setText("0");
		}
		
		if(settings[6] > 0)
			LRFD.setChecked(true);
		else
			ASD.setChecked(true);			
		
		et_d_tolerance.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            {
		            	et_d_tolerance.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	type.setDisplayValue(et_d_tolerance.getText().toString(), 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			        	String t = type.getDisplayValue();
			        	et_d_tolerance.setText(t);
			        	et_d_tolerance.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_d_tolerance.setText("");
	        		et_d_tolerance.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		et_bf_tolerance.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		        	if(hasFocus)
		            {
		        		et_bf_tolerance.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	type.setDisplayValue(et_bf_tolerance.getText().toString(), 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			        	String t = type.getDisplayValue();
			        	et_bf_tolerance.setText(t);
			        	et_bf_tolerance.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_bf_tolerance.setText("");
	        		et_bf_tolerance.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		et_tf_tolerance.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		        	if(hasFocus)
		            {
		        		et_tf_tolerance.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	type.setDisplayValue(et_tf_tolerance.getText().toString(), 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			        	String t = type.getDisplayValue();
			        	et_tf_tolerance.setText(t);
			        	et_tf_tolerance.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_tf_tolerance.setText("");
	        		et_tf_tolerance.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		et_tw_tolerance.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		        	if(hasFocus)
		            {
		        		et_tw_tolerance.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	type.setDisplayValue(et_tw_tolerance.getText().toString(), 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			        	String t = type.getDisplayValue();
			        	et_tw_tolerance.setText(t);
			        	et_tw_tolerance.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_tw_tolerance.setText("");
	        		et_tw_tolerance.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		et_year_tolerance.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		        	if(hasFocus)
		            {
		        		et_year_tolerance.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
			        	et_year_tolerance.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_year_tolerance.setText("");
	        		et_year_tolerance.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		et_d_tolerance.addTextChangedListener(new TextWatcher(){
	        public void afterTextChanged(Editable s) {
	            changed = true;
	        }
	        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
	        public void onTextChanged(CharSequence s, int start, int before, int count){}
	    }); 
		
		et_bf_tolerance.addTextChangedListener(new TextWatcher(){
	        public void afterTextChanged(Editable s) {
	        	changed = true;
	        }
	        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
	        public void onTextChanged(CharSequence s, int start, int before, int count){}
	    }); 
		
		et_tf_tolerance.addTextChangedListener(new TextWatcher(){
	        public void afterTextChanged(Editable s) {
	        	changed = true;
	        }
	        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
	        public void onTextChanged(CharSequence s, int start, int before, int count){}
	    }); 
		
		et_tw_tolerance.addTextChangedListener(new TextWatcher(){
	        public void afterTextChanged(Editable s) {
	        	changed = true;
	        }
	        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
	        public void onTextChanged(CharSequence s, int start, int before, int count){}
	    }); 
		
		et_year_tolerance.addTextChangedListener(new TextWatcher(){
	        public void afterTextChanged(Editable s) {
	        	changed = true;
	        }
	        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
	        public void onTextChanged(CharSequence s, int start, int before, int count){}
	    }); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_options, menu);
		return true;
	}
	
	public void button_click(View v) 
	{
	    this.changed = true;
	}
	
	public void save_click(View view) {		
		ShapeTable shapes = new ShapeTable();
		
		// get the edit view object
		EditText et_d_tolerance = (EditText) findViewById(R.id.d_tolerance);
		EditText et_bf_tolerance = (EditText) findViewById(R.id.bf_tolerance);
		EditText et_tf_tolerance = (EditText) findViewById(R.id.tf_tolerance);
		EditText et_tw_tolerance = (EditText) findViewById(R.id.tw_tolerance);
		EditText et_year_tolerance = (EditText) findViewById(R.id.year_tolerance);
		
		if(is_valid())
		{
			// create a String object with the text
			String str_d_tolerance = et_d_tolerance.getText().toString().replace("\"","");
			String str_bf_tolerance = et_bf_tolerance.getText().toString().replace("\"","");
			String str_tf_tolerance = et_tf_tolerance.getText().toString().replace("\"","");
			String str_tw_tolerance = et_tw_tolerance.getText().toString().replace("\"","");
			String str_year_tolerance = et_year_tolerance.getText().toString().replace("\"","");
			LinearLayout layout = (LinearLayout) findViewById(R.id.init);
			layout.requestFocus();			
			
			RadioButton asd = (RadioButton) findViewById(R.id.asd);
			
			// DatabaseUtils.sqlEscapeString(task[i].something)
			
			if(str_d_tolerance.length() > 0)
				this.settings[1] = Float.parseFloat(str_d_tolerance);
			if(str_bf_tolerance.length() > 0)
				this.settings[2] = Float.parseFloat(str_bf_tolerance);
			if(str_tf_tolerance.length() > 0)
				this.settings[3] = Float.parseFloat(str_tf_tolerance);
			if(str_tw_tolerance.length() > 0)
				this.settings[4] = Float.parseFloat(str_tw_tolerance);
			if(str_year_tolerance.length() > 0)
				this.settings[5] = Float.parseFloat(str_year_tolerance);
			
			if(asd.isChecked())
				this.settings[6] = 0;
			else
				this.settings[6] = 1;
			
			if(shapes.updateSettings(settings, this))		
			{
				Intent intent = new Intent(this, Options.previous);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				overridePendingTransition(R.anim.push_up, R.anim.push_out);				
				Toast.makeText(this, "Changes saved.", Toast.LENGTH_LONG).show();
			}
		}		
	}
	
	public void home_click(MenuItem menu_item) 
	{		
		if(changed) 
			confirm(this, MainActivity.class);
		else
		{
			Intent intent = new Intent(this, MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			overridePendingTransition(R.anim.push_up, R.anim.push_out);				
		}
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
	
	public void onBackPressed()
	{
		if(changed) 
			confirm(this, Options.previous);
		else
		{
			Intent intent = new Intent(this, Options.previous);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			overridePendingTransition(R.anim.push_up, R.anim.push_out);				
		}
	}

	private boolean is_valid()
	{
		boolean result = false;
		boolean numeric = true;
		
		EditText et_d_tolerance = (EditText) findViewById(R.id.d_tolerance);
		EditText et_bf_tolerance = (EditText) findViewById(R.id.bf_tolerance);
		EditText et_tf_tolerance = (EditText) findViewById(R.id.tf_tolerance);
		EditText et_tw_tolerance = (EditText) findViewById(R.id.tw_tolerance);
		EditText et_year_tolerance = (EditText) findViewById(R.id.year_tolerance);
		
		String str_d_tolerance = et_d_tolerance.getText().toString();
		String str_bf_tolerance = et_bf_tolerance.getText().toString();
		String str_tf_tolerance = et_tf_tolerance.getText().toString();
		String str_tw_tolerance = et_tw_tolerance.getText().toString();
		String str_year_tolerance = et_year_tolerance.getText().toString();
		
		if(!str_d_tolerance.matches("0\"") && !str_d_tolerance.matches("[0-9\" '-.]*"))
			numeric = false;
		if(!str_bf_tolerance.matches("0\"") && !str_bf_tolerance.matches("[0-9\" '-.]*"))
			numeric = false;
		if(!str_tf_tolerance.matches("0\"") && !str_tf_tolerance.matches("[0-9\" '-.]*"))
			numeric = false;
		if(!str_tw_tolerance.matches("0\"") && !str_tw_tolerance.matches("[0-9\" '-.]*"))
			numeric = false;
		if(str_year_tolerance.length() > 0 && !str_year_tolerance.matches("[0-9]*"))
			numeric = false;
		
		if(numeric)
		{
			result = true;
		}
		else
		{
			showDialog(this, "Please enter a valid number.");
		}
		
		return result;
	}
	
	public void showDialog(Context context, String message) 
	{
        if(myAlertDialog != null && myAlertDialog.isShowing()) return;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.dismiss();
        }});
        builder.setCancelable(false);
        myAlertDialog = builder.create();
        myAlertDialog.show();
	}
	
	private void confirm(Context context, Class<?> activity)
	{		
		final Intent intent = new Intent(context, activity);
		
		AlertDialog.Builder confirm = new AlertDialog.Builder(this);
		confirm.setTitle(Html.fromHtml("<font color='#000000'>Confirm</font>"));
		confirm.setMessage("Are you sure?  Changes will be lost.");
		confirm.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		  public void onClick(DialogInterface dialog, int arg1) {
			    dialog.dismiss();
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);		
				overridePendingTransition(R.anim.push_up, R.anim.push_out);
		}});
		
		confirm.setNegativeButton("No", new DialogInterface.OnClickListener() {
		  public void onClick(DialogInterface dialog, int arg1) {
			  dialog.dismiss();
		}});
		
		confirm.show();		
	}	
	
	public void restore_defaults(View view)
	{
		EditText et_d_tolerance = (EditText) findViewById(R.id.d_tolerance);
		EditText et_bf_tolerance = (EditText) findViewById(R.id.bf_tolerance);
		EditText et_tf_tolerance = (EditText) findViewById(R.id.tf_tolerance);
		EditText et_tw_tolerance = (EditText) findViewById(R.id.tw_tolerance);
		EditText et_year_tolerance = (EditText) findViewById(R.id.year_tolerance);
		
		et_d_tolerance.setText("0.5000\"");
		et_bf_tolerance.setText("0.2500\"");
		et_tf_tolerance.setText("0.0625\"");
		et_tw_tolerance.setText("0.0625\"");
		et_year_tolerance.setText("10");
		
		RadioGroup code = (RadioGroup) findViewById(R.id.code);		
		code.check(R.id.asd);		
	}
}
