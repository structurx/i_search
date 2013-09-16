package com.shapes.shapes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AnalyzeColumn extends Activity {
	
	private AlertDialog myAlertDialog;
	private FeetInchesType type;
	private ColumnAnalysis column;
	private ShapeTable table;
	private Shape shape;
	private float[] settings = new float[7];
	private int warning;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_analyze_column);
		
		this.table = new ShapeTable();
		this.type = new FeetInchesType();
		this.column = table.getColumnAnalysis(this);
		Options.previous = AnalyzeColumn.class;
		this.settings = table.getSettings(this);
		this.shape = table.getSelected(this);
		this.warning = 0;
		
		final EditText et_column_height = (EditText) findViewById(R.id.column_height);
		final EditText et_weak_axis = (EditText) findViewById(R.id.weak_axis);
		final EditText et_strong_axis = (EditText) findViewById(R.id.strong_axis);
		final EditText et_yield_strength = (EditText) findViewById(R.id.yield_strength);		
		
		et_column_height.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            {
		            	et_column_height.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	type.setDisplayValue("0", 4, FeetInchesType.FeetInches.Feet1, FeetInchesType.LengthUnitsType.FtIn);
		            	
		            	if(et_column_height.getText().toString().length() > 0)
		            		type.setDisplayValue(et_column_height.getText().toString(), 4, FeetInchesType.FeetInches.Feet1, FeetInchesType.LengthUnitsType.FtIn);
		            	
			        	String t = type.getDisplayValue();
			        	et_column_height.setText(t);
			        	et_column_height.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_column_height.setText("");
	        		et_column_height.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		et_weak_axis.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            {
		            	et_weak_axis.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	type.setDisplayValue("0", 4, FeetInchesType.FeetInches.Feet1, FeetInchesType.LengthUnitsType.FtIn);
		            	
		            	if(et_weak_axis.getText().toString().length() > 0)
		            		type.setDisplayValue(et_weak_axis.getText().toString(), 4, FeetInchesType.FeetInches.Feet1, FeetInchesType.LengthUnitsType.FtIn);
		            	
			        	String t = type.getDisplayValue();
			        	et_weak_axis.setText(t);
			        	et_weak_axis.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_weak_axis.setText("");
	        		et_weak_axis.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		et_strong_axis.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            {
		            	et_strong_axis.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	type.setDisplayValue("0", 4, FeetInchesType.FeetInches.Feet1, FeetInchesType.LengthUnitsType.FtIn);
		            	
		            	if(et_strong_axis.getText().toString().length() > 0)
		            		type.setDisplayValue(et_strong_axis.getText().toString(), 4, FeetInchesType.FeetInches.Feet1, FeetInchesType.LengthUnitsType.FtIn);
		            	
			        	String t = type.getDisplayValue();
			        	et_strong_axis.setText(t);
			        	et_strong_axis.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		et_strong_axis.setText("");
	        		et_strong_axis.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		et_yield_strength.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            	et_yield_strength.setBackgroundResource(R.drawable.selected_edittext);
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
		
		value = Double.toString(column.getHeight());	
		type.setDisplayValue(value, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.FtIn);
		et_column_height.setText(type.getDisplayValue());
		
		value = Double.toString(column.getWeakAxis());		
		type.setDisplayValue(value, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.FtIn);
		et_weak_axis.setText(type.getDisplayValue());
		
		value = Double.toString(column.getStrongAxis());		
		type.setDisplayValue(value, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.FtIn);
		et_strong_axis.setText(type.getDisplayValue());
		
		value = Integer.toString(column.getYieldStrength());		
		et_yield_strength.setText(value);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_analyze_column, menu);
		return true;
	}

	public void clear_click(View view)
	{
		EditText et_height = (EditText) findViewById(R.id.column_height);
		EditText et_weak_axis = (EditText) findViewById(R.id.weak_axis);
		EditText et_strong_axis = (EditText) findViewById(R.id.strong_axis);
		EditText et_yield_strength = (EditText) findViewById(R.id.yield_strength);
		
		et_height.setText("0'-0.0000\"");
		et_weak_axis.setText("0'-0.0000\"");
		et_strong_axis.setText("0'-0.0000\"");
		et_yield_strength.setText("0");
	}
	
	public void analyze_click(View view)
	{
		LinearLayout layout = (LinearLayout) findViewById(R.id.init);
		layout.requestFocus();
		
		try
		{	
			EditText edt_column_height = (EditText) findViewById(R.id.column_height);
			EditText edt_weak_axis = (EditText) findViewById(R.id.weak_axis);
			EditText edt_strong_axis = (EditText) findViewById(R.id.strong_axis);
			EditText edt_yield_strength = (EditText) findViewById(R.id.yield_strength);		
			String value = new String();
			String str_column_height = edt_column_height.getText().toString();
			String str_weak_axis = edt_weak_axis.getText().toString();
			String str_strong_axis = edt_strong_axis.getText().toString();		
			String str_yield_strength = edt_yield_strength.getText().toString();
			double column_height = 0;
			double weak_axis = 0;
			double strong_axis = 0;
			int yield_strength = 0;
			double d = 0;
			double bf = 0;
			double tf = 0;
			double tw = 0;			
			
			if(str_column_height.length() > 0)
			{
				this.type.setDisplayValue(str_column_height, 4, FeetInchesType.FeetInches.Inches1,  FeetInchesType.LengthUnitsType.InchSymbol);
				value = this.type.getDisplayValue().replace("\"", "");
				str_column_height = value;
				column_height = Double.parseDouble(str_column_height);
			}
			else
				edt_column_height.setText("0'-0.0000\"");
			
			if(str_weak_axis.length() > 0)
			{
				this.type.setDisplayValue(str_weak_axis, 4, FeetInchesType.FeetInches.Inches1,  FeetInchesType.LengthUnitsType.InchSymbol);
				value = this.type.getDisplayValue().replace("\"", "");
				str_weak_axis = value;
				weak_axis = Double.parseDouble(str_weak_axis);
			}
			else
				edt_weak_axis.setText("0'-0.0000\"");
			
			if(str_strong_axis.length() > 0)
			{	
				this.type.setDisplayValue(str_strong_axis, 4, FeetInchesType.FeetInches.Inches1,  FeetInchesType.LengthUnitsType.InchSymbol);
				value = this.type.getDisplayValue().replace("\"", "");
				str_strong_axis = value;
				strong_axis = Double.parseDouble(str_strong_axis);
			}
			else
				edt_strong_axis.setText("0'-0.0000\"");
			
			if(str_yield_strength.length() > 0)
				yield_strength = Integer.parseInt(str_yield_strength);
			else
				edt_yield_strength.setText("0");
			
			// check the values
			if(isValid(column_height, weak_axis, strong_axis, yield_strength) == true)
			{
				this.column = new ColumnAnalysis(column_height, weak_axis, strong_axis, yield_strength, d, bf, tf, tw);
				
				// save to database
				table.updateColumnAnalysis(column, this);
				
				display_calculation(column_height, strong_axis, weak_axis, yield_strength);
			}		
		}
		catch(Exception e)
		{
			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}
	}
	
	private boolean isValid(double column_height, double weak_axis, double strong_axis, int yield_strength)
	{
		boolean result = true;
		
		if(yield_strength < 18 || yield_strength > 65)
		{
			result = false;
			showDialog(this, "Please enter a valid yield strength.");
		}	 
		else if(this.warning <= 0 && (weak_axis > column_height) || (strong_axis > column_height))
		{
			warningDialog(this, "Warning: Unbraced length is greater than column length.");			
		}
		
		return result;
	}
	
    public void home_click(MenuItem menu_item) {
		Intent intent = new Intent(this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);		
		overridePendingTransition(R.anim.push_up, R.anim.push_out);
	}
    
    public void options_click(MenuItem menu_item) {
    	Options.previous = AnalyzeColumn.class;
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
    
    public void showResults(Context context, final String message) 
	{
        if( myAlertDialog != null && myAlertDialog.isShowing() ) return;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // builder.setMessage(message);
        
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_dialog, null);
        
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setMovementMethod(LinkMovementMethod.getInstance());
        text.setTextSize(12);
        text.setText(Html.fromHtml(message));
        builder.setView(layout);
        
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    dialog.dismiss();
                }});
        
        builder.setNegativeButton("Copy to Clipboard", new DialogInterface.OnClickListener() {
            @SuppressWarnings("deprecation")
			public void onClick(DialogInterface dialog, int arg1) {
				android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        	    clipboard.setText(Html.fromHtml(message).toString());
                dialog.dismiss();
            }});
        
        myAlertDialog = builder.create();
        myAlertDialog.show();
	}
    
    public void warningDialog(Context context, final String message) 
	{
        if( myAlertDialog != null && myAlertDialog.isShowing() ) return;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // builder.setMessage(message);
        
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_dialog, null);
        
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setMovementMethod(LinkMovementMethod.getInstance());
        text.setTextSize(12);
        text.setText(Html.fromHtml(message));
        builder.setView(layout);
        
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
            	warning = 1;
                dialog.dismiss();
                analyze_click(null);
            }});
        
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.dismiss();
            }});
        
        myAlertDialog = builder.create();
        myAlertDialog.show();
	}
    
    public void showDialog(Context context, final String message) 
	{
        if( myAlertDialog != null && myAlertDialog.isShowing() ) return;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // builder.setMessage(message);
        
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_dialog, null);
        
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setMovementMethod(LinkMovementMethod.getInstance());
        text.setTextSize(12);
        text.setText(Html.fromHtml(message));
        builder.setView(layout);
        
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
            	warning = 1;
                dialog.dismiss();
            }});
        
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.dismiss();
            }});
        
        myAlertDialog = builder.create();
        myAlertDialog.show();
	}
    
	private void display_calculation(double ColHt, double StrongL, double WeakL, double Fy)
	{		
		double h = this.shape.get_h();
		double tw = this.shape.get_tw();
		double Ag = this.shape.get_ag();
		double rx = this.shape.get_rx();
		double ry = this.shape.get_ry();
		double h_over_tw = this.shape.get_h_tw();
		double Fcr = 0;
		double Fe = 0;
		double Qa = 0;
		double Qs = 0;
		double Q = 0;
		double KL_over_rx = 0;
		double KL_over_ry = 0;
		double KL_over_r = 0;
		double bf_over_2tf = this.shape.get_bf_2tf();		
		double he = 0;
		double Ae = 0;
		double Pn = 0;
		float code = this.settings[6];											
		final int E = 29000;													// ksi
		String[] messages = new String[4];
																				// set lengths
		if(StrongL == 0)
			StrongL = ColHt;
		
		if(WeakL == 0)
			WeakL = ColHt;	
																				
		KL_over_rx = StrongL / rx;												// find controlling axis
		KL_over_ry = WeakL / ry;
		
		if(KL_over_rx > KL_over_ry)
		{
			KL_over_r = KL_over_rx;
			messages[0] = "Strong Axis";
		}
		else
		{
			KL_over_r = KL_over_ry;
			messages[0] = "Weak Axis";
		}
		
		if(KL_over_r > 2)																				
			Fe = Math.pow(Math.PI, 2) * E / Math.pow(KL_over_r, 2);				// calculate the elastic buckling stress, eqn E3-4
		else
			Fe = Math.pow(Math.PI, 2) * E / Math.pow(2, 2);
																				// calculate critical stress with Q=1.0 (i.e. assume non-slender elements)		
		if(KL_over_r <= (4.71 * Math.sqrt(E / Fy)))
		{
			Fcr = Math.pow(0.658, (Fy / Fe)) * Fy;								// eqn E3-2
			messages[1] = "(EQN E 3-2)";
		}
		else
		{
			Fcr = 0.877 * Fe;													// eqn E3-3
			messages[1] = "(EQN E 3-3)";
		}
																				// calculate Qs per AISC E7.1 
		if(bf_over_2tf <= 0.56 * Math.sqrt(E / Fy))
		{
			Qs = 1.0;															// eqn E7-4
			messages[2] = "Flange is compact, Q<sub>s</sub> = 1.0 (EQN E7-4)";
		}
		else if(bf_over_2tf < 1.03 * Math.sqrt(E / Fy))
		{
			Qs = Math.round((1.415 - 0.74 * bf_over_2tf * Math.sqrt(Fy / E)) * 100) / 100.0;	// eqn E7-5
			messages[2] = "Flange is non-compact, Q<sub>s</sub> = " + Qs + " 1.0 (EQN E7-5)";
		}
		else
		{
			Qs = Math.round((0.69 * E / (Fy * Math.pow(bf_over_2tf, 2))) * 100) / 100.0; 	// eqn E7-6
			messages[2] = "Flange is slender, Q<sub>s</sub> = " + Qs + " 1.0 (EQN E7-6)";
		}
																				// calculate Qa		
		if(h_over_tw <= 1.49 * Math.sqrt(E / Fy))
		{
			Qa = 1.0;
			messages[3] = "Web is compact, Qa = 1.0";
		}
		else if(h_over_tw < 1.49 * Math.sqrt(E / Fcr))
		{
			Qa = 1.0;
			messages[3] = "Web is non-compact, Qa = 1.0";
		}
		else
		{
			he = (1.92 * tw * Math.sqrt(E / Fcr) * (1 - 0.34 / bf_over_2tf * Math.sqrt(E / Fcr))); 	// eqn E7-17

			if(he > h)			
				he = h;			
			
			Ae = Ag - tw * (h - he);
			Qa = Math.round((Ae / Ag) * 100) / 100.0;							// eqn E7-16
			messages[3] = "Web is slender, Qa = " + Qa + " (EQN E7-16)";
		}		
																				
	    Q = Math.round((Qs * Qa) * 100) / 100.0;								// calculate Q
	    																		// calculate critical stress with Q taking into account slender elments (if they exist)
		if(Q < 1)
		{
			if(KL_over_r <= (4.71 * Math.sqrt(E / (Fy * Q))))
			{
				Fcr = Q * Math.pow(0.658, (Q * Fy / Fe)) * Fy;					// eqn E7-2
				messages[1] = "(E7-2)";
			}
			else
			{
				Fcr = 0.877 * Fe;												// eqn E7-3
				messages[1] = "(E7-3)";
			}
		}		
																				// calculate nominal capacity, eqn E3-1 or E7-1
	    Pn = Fcr * Ag;															// set capacity message for modal form
	    String load = "";
	    
	    																		// round everything
	    Double Pn1 = Math.round((0.9 * Pn) * 10.0) / 10.0;																		
	    Double Pn2 = Math.round((Pn / 1.67) * 10.0) / 10.0;
	    Double Pn3 = Math.round((Pn) * 100.00) / 100.00;
	    ColHt = Math.round((ColHt / 12.0) * 100.00) / 100.00;
	    StrongL = Math.round((StrongL / 12.0) * 100.00) / 100.00;
	    WeakL = Math.round((WeakL / 12.0) * 100.00) / 100.00;
	    KL_over_r = Math.round((KL_over_r) * 10.0) / 10.0;
	    Fe = Math.round(Fe * 10.0) / 10.0;
	    Fcr = Math.round((Fcr) * 100.00) / 100.00;
	    																		// report results
	    																		// Modal with msg and OK button	    
		if(code > 0)
			load = "Factored Load, &#934;P<sub>n</sub> = " + Pn1 + " k";
		else
			load = "Allowable Load, P<sub>n</sub>/&#937; = " + Pn2 + " k";	
		
		String message = "<b>" + shape.get_designation() +"</b><br/>";
		message += "Column height = " + ColHt + " ft.<br/>";
		message += "Unbraced Length, Strong Axis = " + StrongL + " ft.<br/>";
		message += "Ubraced Length, Weak Axis = " + WeakL + " ft.<br/>";
		message += "Yield Strength, F<sub>y</sub> = " + Fy +  " ksi<br/>";
		message += "<br/>";
		message += "K = 1.0 for both axes<br/>";
		message += "Controlling axis is the " + messages[0] + "<br/>";
		message += "Slenderness ratio, KL/r = " + KL_over_r + "<br/>";
		message += "Elastic buckling stress, F<sub>e</sub> = " + Fe + " ksi (EQN E3-4) <br/>";
		
		if(Q < 1.0)
		{
			message += messages[2] + "<br/>";
			message += messages[3] + "<br/>";
		}
		else
		{
			message += "Flange is compact<br/>";
			message += "Web is compact<br/>";
		}
		
		message += "Q = " + Q + "<br/>";
		message += "Critical stress, F<sub>cr</sub> " + Fcr + " ksi " + messages[1] + "<br/>";
		message += "Nominal capacity, P<sub>n</sub> = " + Pn3 + " k<br/><br/>";
		message += "<b>" + load + "</b><br/>";
		
		showResults(this, message);
	}
}
