package com.shapes.shapes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.shapes.shapes.FeetInchesType.FeetInches;

public class Analyze extends Activity {
	
	public AlertDialog myAlertDialog;
	
	private FeetInchesType type;
	public static BeamAnalysis beam;
	private Shape selected;
	private double d = 0;
	private double bf = 0;
	private double tf = 0;
	private double tw = 0;
	private ShapeTable shape_table;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_analyze);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    getWindow().setWindowAnimations(1);
	    		
	    this.type = new FeetInchesType();
	    this.shape_table = new ShapeTable();
		Analyze.beam = this.shape_table.getBeamAnalysis(this);		
		Options.previous = Analyze.class;
		this.selected = shape_table.getSelected(this);
		
	    this.d = selected.get_d();
	    this.bf = selected.get_bf();
	    this.tf = selected.get_tf();
	    this.tw = selected.get_tw();
		
		final EditText et_main_span = (EditText) findViewById(R.id.main_span);		
		final EditText et_top_flange = (EditText) findViewById(R.id.top_flange);		
		final EditText et_yield_strength = (EditText) findViewById(R.id.yield_strength);
		
		et_main_span.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            {
		            	et_main_span.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	type.setDisplayValue("0", 4, FeetInchesType.FeetInches.Feet1, FeetInchesType.LengthUnitsType.FtIn);
		            	
		            	if(et_main_span.getText().toString().length() > 0)
		            		type.setDisplayValue(et_main_span.getText().toString(), 4, FeetInchesType.FeetInches.Feet1, FeetInchesType.LengthUnitsType.FtIn);
		            	
			        	String t = type.getDisplayValue();
			        	et_main_span.setText(t);
			        	et_main_span.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_main_span.setText("");
	        		et_main_span.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		et_top_flange.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            {
		            	et_top_flange.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	type.setDisplayValue("0", 4, FeetInchesType.FeetInches.Feet1, FeetInchesType.LengthUnitsType.FtIn);
		            	
		            	if(et_top_flange.getText().toString().length() > 0)
		            		type.setDisplayValue(et_top_flange.getText().toString(), 4, FeetInchesType.FeetInches.Feet1, FeetInchesType.LengthUnitsType.FtIn);
		            	
			        	String t = type.getDisplayValue();
			        	et_top_flange.setText(t);
			        	et_top_flange.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_top_flange.setText("");
	        		et_top_flange.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		et_yield_strength.setOnFocusChangeListener(new OnFocusChangeListener(){
			public void onFocusChange(View v, boolean hasFocus) {
				try
				{
		            if(hasFocus)
		            {
		            	et_yield_strength.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	if(et_yield_strength.getText().toString().length() <= 0)
		            		et_yield_strength.setText("0");
		            		
		               	et_yield_strength.setBackgroundResource(R.drawable.rounded_edittext);
		            }
				}
				catch(Exception e)
				{
					et_yield_strength.setText("");
					et_yield_strength.setBackgroundResource(R.drawable.rounded_edittext);
				}
	        }			
		});
		
		String value = new String();
		
		value = Double.toString(beam.getMainSpan());
		type.setDisplayValue(value, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.FtIn);
		et_main_span.setText(type.getDisplayValue());

		value = Double.toString(beam.getTopFlange());
		type.setDisplayValue(value, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.FtIn);
		et_top_flange.setText(type.getDisplayValue());

		value = Integer.toString(beam.getYieldStrength());
		et_yield_strength.setText(value);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_analyze, menu);
		return true;
	}
	
	public void home_click(MenuItem menu_item) {
		Intent intent = new Intent(this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
		overridePendingTransition(R.anim.push_up, R.anim.push_out);
	}
	
	public void options_click(MenuItem menu_item) {
		Options.previous = Analyze.class;
		Intent intent = new Intent(this, Options.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);		
		overridePendingTransition(R.anim.push_up, R.anim.push_out);
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
	
	private boolean is_valid(String str_main_span, String str_top_flange, String str_yield_strength)
	{
		boolean result = true;
		
		double main_span = 0;
		double top_flange = 0;
		double yield_strength = 0;
		
		if(str_main_span.length() > 0)
		{
			this.type.setDisplayValue(str_main_span, 4, FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			main_span = Double.parseDouble(this.type.getDisplayValue().replace("\"", ""));		
			
			if(main_span <= 0)
			{
				result = false;
				showDialog(this, "Please enter a valid main span.");
			}
		}
		
		if(str_yield_strength.length() > 0)
		{
			this.type.setDisplayValue(str_yield_strength, 4, FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			yield_strength = Double.parseDouble(this.type.getDisplayValue().replace("\"", ""));
			
			if(yield_strength < 18 || yield_strength > 65)
			{
				result = false;
				showDialog(this, "Please enter a valid yield strength.");
			}	
		}		
		
		if(str_top_flange.length() > 0)
		{
			this.type.setDisplayValue(str_top_flange, 4, FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
			top_flange = Double.parseDouble(this.type.getDisplayValue().replace("\"", ""));		
			
			if(top_flange > main_span)
			{
				result = false;
				showDialog(this, "Unbraced Length cannot exceed Main Span.");
			}			
		}		
		
		return result;
	}
	
	public void next_click(View view)
	{		
		LinearLayout layout = (LinearLayout) findViewById(R.id.init);
		layout.requestFocus();	

		try
		{
			EditText edt_main_span = (EditText) findViewById(R.id.main_span);
			EditText edt_top_flange = (EditText) findViewById(R.id.top_flange);
			EditText edt_yield_strength = (EditText) findViewById(R.id.yield_strength);
			
			String str_main_span = edt_main_span.getText().toString();
			String str_top_flange = edt_top_flange.getText().toString();		
			String str_yield_strength = edt_yield_strength.getText().toString();
			
			if(is_valid(str_main_span, str_top_flange, str_yield_strength))
			{			
				double main_span = 0;			
				double top_flange = 0;			
				int yield_strength = 0;			
				
				if(str_main_span.length() > 0)
				{
					this.type.setDisplayValue(str_main_span, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
					main_span = Double.parseDouble(type.getDisplayValue().replace("\"",""));			
				}				
				else
					edt_main_span.setText("0'-0.0000\"");
				
				if(str_top_flange.length() > 0)
				{
					this.type.setDisplayValue(str_top_flange, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
					top_flange = Double.parseDouble(type.getDisplayValue().replace("\"",""));
				}
				else
					edt_top_flange.setText("0'-0.0000\"");
					
				if(str_yield_strength.length() > 0)
					yield_strength = Integer.parseInt(str_yield_strength);					// yield in ksi	
				else
					edt_yield_strength.setText("0");
				
				beam.setMainSpan(main_span);			
				beam.setTopFlange(top_flange);			
				beam.setYieldStrength(yield_strength);
				beam.set_d(d);
				beam.set_bf(bf);
				beam.set_tf(tf);
				beam.set_tw(tw);
				
				shape_table.updateBeamAnalysis(beam, this);
				
				Intent intent = new Intent(this, AnalyzeBeam2.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				overridePendingTransition(R.anim.slide, R.anim.push_out);
			}
		}
		catch(Exception e)
		{
			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}
	}
	
	public void clear_click(View view)
	{
		EditText et_main_span = (EditText) findViewById(R.id.main_span);		
		EditText et_top_flange = (EditText) findViewById(R.id.top_flange);		
		EditText et_yield_strength = (EditText) findViewById(R.id.yield_strength);
		
		et_main_span.setText("0'-0.0000\"");
		et_top_flange.setText("0'-0.0000\"");
		et_yield_strength.setText("0");
	}
	
	public void showDialog(Context context, String message) 
	{
        if( myAlertDialog != null && myAlertDialog.isShowing() ) return;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    dialog.dismiss();
                }});
        builder.setCancelable(false);
        myAlertDialog = builder.create();
        myAlertDialog.show();
	}
}
