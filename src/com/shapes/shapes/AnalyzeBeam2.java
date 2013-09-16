package com.shapes.shapes;

import java.text.DecimalFormat;

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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class AnalyzeBeam2 extends Activity {
	
	private AlertDialog myAlertDialog;	
	private FeetInchesType type;
	private BeamAnalysis beam1;
	private ShapeTable table;
	private float[] settings = new float[7];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_analyze_beam2);
		
		this.type = new FeetInchesType();
		this.table = new ShapeTable();
		this.beam1 = Analyze.beam;
		this.settings = table.getSettings(this);
		Options.previous = AnalyzeBeam2.class;
		
		final EditText edt_live_limit = (EditText) findViewById(R.id.live_limit);
		final EditText edt_live_abs = (EditText) findViewById(R.id.live_abs);
		final EditText edt_total_limit = (EditText) findViewById(R.id.total_limit);
		final EditText edt_total_abs = (EditText) findViewById(R.id.total_abs);
		final EditText edt_dead_load = (EditText) findViewById(R.id.dead_load);
		final EditText edt_live_load = (EditText) findViewById(R.id.live_load);
		
		edt_live_limit.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            {
		            	edt_live_limit.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	int live_limit = 0;
		            	
		            	if(edt_live_limit.getText().toString().length() > 0)
		            		live_limit = Integer.parseInt(edt_live_limit.getText().toString());
		            	
		            	edt_live_limit.setText(String.format("%4d", live_limit));
			        	edt_live_limit.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		edt_live_limit.setText("");
	        		edt_live_limit.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		edt_live_abs.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            {
		            	edt_live_abs.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	type.setDisplayValue("0", 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		            	
		            	if(edt_live_abs.getText().toString().length() > 0)
		            		type.setDisplayValue(edt_live_abs.getText().toString(), 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		            	
			        	String t = type.getDisplayValue();
			        	edt_live_abs.setText(t);
			        	edt_live_abs.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		edt_live_abs.setText("");
	        		edt_live_abs.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		edt_total_limit.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            {
		            	edt_total_limit.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	int total_limit = 0;
		            	
		            	if(edt_total_limit.getText().toString().length() > 0)
		            		total_limit = Integer.parseInt(edt_total_limit.getText().toString());
		            	
		            	edt_total_limit.setText(String.format("%4d", total_limit));
			        	edt_total_limit.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		edt_total_limit.setText("");
	        		edt_total_limit.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		edt_total_abs.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            {
		            	edt_total_abs.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	type.setDisplayValue("0", 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		            	
		            	if(edt_total_abs.getText().toString().length() > 0)
		            		type.setDisplayValue(edt_total_abs.getText().toString(), 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		            	
			        	String t = type.getDisplayValue();
			        	edt_total_abs.setText(t);
			        	edt_total_abs.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		edt_total_abs.setText("");
	        		edt_total_abs.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		edt_dead_load.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            {
		            	edt_dead_load.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	float dead_load = 0;
		            	
		            	if(edt_dead_load.getText().toString().length() > 0)
		            		dead_load = Float.parseFloat(edt_dead_load.getText().toString());
		            	
		            	edt_dead_load.setText(String.format("%2.2f", dead_load));
			        	edt_dead_load.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		edt_dead_load.setText("");
	        		edt_dead_load.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
		
		edt_live_load.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{
		            if(hasFocus)
		            {
		            	edt_live_load.setBackgroundResource(R.drawable.selected_edittext);
		            }
		            else
		            {
		            	float live_load = 0;
		            	
		            	if(edt_live_load.getText().toString().length() > 0)
		            		live_load = Float.parseFloat(edt_live_load.getText().toString());
		            		
		            	edt_live_load.setText(String.format("%2.2f", live_load));
			        	edt_live_load.setBackgroundResource(R.drawable.rounded_edittext);
		            }
	        	}
	        	catch(Exception e)
	        	{
	        		edt_live_load.setText("");
	        		edt_live_load.setBackgroundResource(R.drawable.rounded_edittext);
	        	}
	        }
	    });
				
		edt_live_limit.setText(Integer.toString(beam1.getLiveLimit()));
		
		this.type.setDisplayValue("360", 4, FeetInchesType.FeetInches.Inches1,  FeetInchesType.LengthUnitsType.InchSymbol);
		this.type.setDisplayValue(Double.toString(beam1.getLiveAbsolute()), 4, FeetInchesType.FeetInches.Inches1,  FeetInchesType.LengthUnitsType.InchSymbol);
		edt_live_abs.setText(this.type.getDisplayValue());
		
		edt_total_limit.setText(Integer.toString(beam1.getTotalLimit()));
		
		this.type.setDisplayValue("240", 4, FeetInchesType.FeetInches.Inches1,  FeetInchesType.LengthUnitsType.InchSymbol);
		this.type.setDisplayValue(Double.toString(beam1.getTotalAbsolute()), 4, FeetInchesType.FeetInches.Inches1,  FeetInchesType.LengthUnitsType.InchSymbol);
		edt_total_abs.setText(this.type.getDisplayValue());
		
		edt_dead_load.setText(Double.toString(beam1.getDeadLoad()));
		edt_live_load.setText(Double.toString(beam1.getLiveLoad()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if(it is present.
		getMenuInflater().inflate(R.menu.activity_analyze_beam2, menu);
		return true;
	}
	
	public void home_click(MenuItem menu_item) {
		Intent intent = new Intent(this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
		overridePendingTransition(R.anim.push_up, R.anim.push_out);
	}
	
	public void options_click(MenuItem menu_item) {
		Options.previous = AnalyzeBeam2.class;
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
	
	public void clear_click(View view)
	{
		EditText edt_live_limit = (EditText) findViewById(R.id.live_limit);
		EditText edt_live_abs = (EditText) findViewById(R.id.live_abs);
		EditText edt_total_limit = (EditText) findViewById(R.id.total_limit);
		EditText edt_total_abs = (EditText) findViewById(R.id.total_abs);
		EditText edt_dead_load = (EditText) findViewById(R.id.dead_load);
		EditText edt_live_load = (EditText) findViewById(R.id.live_load);
		
		edt_live_limit.setText("0");
		edt_live_abs.setText("0.0000\"");
		edt_total_limit.setText("0");
		edt_total_abs.setText("0.0000\"");
		edt_dead_load.setText("0.0");
		edt_live_load.setText("0.0");
	}
	
	public void calculate_click(View view)
	{
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		LayoutInflater li = LayoutInflater.from(this);
		final ScrollView layout = (ScrollView) li.inflate(R.layout.calculate_loads, null);
		
		dialog.setTitle(Html.fromHtml("<font color='#000000'>Calculate Loads</font>"));		
		dialog.setView(layout);
		
		dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int whichButton) {
		    	String value = new String();
		    	int dead_load = 0;
				int live_load = 0;
				double trib_width = 0;
				
				EditText edt_calc_dead_load = (EditText) layout.findViewById(R.id.calc_dead_load);
		    	EditText edt_calc_live_load = (EditText) layout.findViewById(R.id.calc_live_load);
		    	EditText edt_calc_width_load = (EditText) layout.findViewById(R.id.calc_trib_width);
				
		     	type.setDisplayValue("", 4,  FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		    	
		    	value = edt_calc_dead_load.getText().toString();
		    	if(value.length() > 0)
		    		dead_load = Integer.parseInt(value);
		    	
		    	value = edt_calc_live_load.getText().toString();
		    	if(value.length() > 0)
					live_load = Integer.parseInt(value);		
		    	
		    	value = edt_calc_width_load.getText().toString();
		    	type.setDisplayValue(value, 4,  FeetInchesType.FeetInches.Feet1, FeetInchesType.LengthUnitsType.InchSymbol);
		    	value = type.getDisplayValue().replace("\"", "");
		    	
		    	if(value.length() > 0)
		    		trib_width = Double.parseDouble(value);
				
				EditText edt_dead_load = (EditText) findViewById(R.id.dead_load);
				EditText edt_live_load = (EditText) findViewById(R.id.live_load);
				
				double dl = (dead_load * trib_width) / 12.0 / 1000.0;
				double ll = (live_load * trib_width) / 12.0 / 1000.0;
				
				edt_dead_load.setText(Double.toString(dl));
				edt_live_load.setText(Double.toString(ll));
		    }
		});
		
		dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			  public void onClick(DialogInterface dialog, int arg1) {
				  dialog.dismiss();
		}});
		
    	final EditText edt_calc_width_load = (EditText) layout.findViewById(R.id.calc_trib_width);
    	
    	edt_calc_width_load.setOnFocusChangeListener(new OnFocusChangeListener() {
	        public void onFocusChange(View v, boolean hasFocus) {
	        	try
	        	{		           
	            	type.setDisplayValue("0", 4, FeetInchesType.FeetInches.Feet1, FeetInchesType.LengthUnitsType.FtIn);
	            	type.setDisplayValue(edt_calc_width_load.getText().toString(), 4, FeetInchesType.FeetInches.Feet1, FeetInchesType.LengthUnitsType.FtIn);
		        	String t = type.getDisplayValue();
		        	edt_calc_width_load.setText(t);			        	
	        	}
	        	catch(Exception e)
	        	{
	        		edt_calc_width_load.setText("");	        		
	        	}
	        }
	    });

		dialog.show();
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
	                    dialog.dismiss();
	                }});

	        builder.setCancelable(false);	        
	        myAlertDialog = builder.create();
	        myAlertDialog.show();
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
	
	public void analyze_click(View view)
	{
		LinearLayout layout = (LinearLayout) findViewById(R.id.init);
		layout.requestFocus();
		
		try
		{
			// get the values
			EditText edt_live_limit = (EditText) findViewById(R.id.live_limit);
			EditText edt_live_abs = (EditText) findViewById(R.id.live_abs);
			EditText edt_total_limit = (EditText) findViewById(R.id.total_limit);
			EditText edt_total_abs = (EditText) findViewById(R.id.total_abs);
			EditText edt_dead_load = (EditText) findViewById(R.id.dead_load);
			EditText edt_live_load = (EditText) findViewById(R.id.live_load);		
			
			// check if(it's valid				
			int live_limit = Integer.parseInt(edt_live_limit.getText().toString().trim());
			double live_absolute = Double.parseDouble(edt_live_abs.getText().toString().replace("\"", ""));
			int total_limit = Integer.parseInt(edt_total_limit.getText().toString().trim());
			double total_absolute = Double.parseDouble(edt_total_abs.getText().toString().replace("\"", ""));
			double dead_load = 0;
			double live_load = 0;
			String str_dead_load = edt_dead_load.getText().toString().trim();
			String str_live_load = edt_live_load.getText().toString().trim();
			
			if(str_dead_load.length() > 0)
				dead_load = Double.parseDouble(str_dead_load);
			else
				showDialog(this, "Invalid load.");
			
			if(str_live_load.length() > 0)
				live_load = Double.parseDouble(str_live_load);
			else
				showDialog(this, "Invalid load.");			
			
			if(isValid(dead_load, live_load) == true)
			{
				double main_span = this.beam1.getMainSpan();
				double Lb_top = this.beam1.getTopFlange();
				double Fy = this.beam1.getYieldStrength();
	
				float code = this.settings[6];				
				
				this.beam1.setLiveLimit(live_limit);
				this.beam1.setLiveAbsolute(live_absolute);
				this.beam1.setTotalLimit(total_limit);
				this.beam1.setTotalAbsolute(total_absolute);
				this.beam1.setDeadLoad(dead_load);
				this.beam1.setLiveLoad(live_load);
				
				if(Lb_top == 0)
					Lb_top = main_span;
	
				// save to database
				this.table.updateBeamAnalysis(this.beam1,  this);
				
				analyze(main_span, Lb_top, Fy, live_limit, live_absolute, total_limit, total_absolute, dead_load, live_load, code);
			}
		}
		catch(Exception e)
		{
			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}
	}
	
	private boolean isValid(double dead_load, double live_load)
	{
		boolean result = true;
		
		if(dead_load + live_load <= 0)
		{
			showDialog(this, "Invalid load.");
			result = false;
		}
		
		// check if unbraced is greater than another value, height?
		return result;		
	}
	
	private void analyze(double MainSpan, double Lb_top, double Fy, double LLL, double AbsoluteLLL, double TLL, double AbsoluteTLL, double DL, double LL, float code)
	{
		Shape shape = this.table.getSelected(this);
		
		double[] state = {0, 1, 2};							// [0] Compact, [1] Noncompact, [2] Slender
		double[] section = {0, 1, 2, 3};					// [0] F2, [1] F3, [2] F4, [3] F5
		double web_state = 0;
		double flange_state = 0;
		double section1 = 0;
		double Ix = shape.get_ix();
		// double Iy = shape.get_iy();
		double J = shape.get_j();
		double Zx = shape.get_zx();
		double Sx = shape.get_sx();
		double ry = shape.get_ry();
		double rts = shape.get_rts();
		double ho = shape.get_ho();
		double bf_over_2tf = shape.get_bf_2tf();
		double h_over_tw = shape.get_h_tw();
		double Iyc_over_Iy = shape.get_iyc_over_iy();
		double aw = shape.get_aw();
		double rt = shape.get_rt();
		double Aweb = shape.get_aweb();
		double TL = 0;
		double Mpos = 0;
		double V = 0;
		double EI = 0;
		double D_TL = 0;
		double D_LL = 0;
		double Mp = 0;
		double Lp = 0;
		double Lr = 0;
		double Mltb_top = 0;
		double Fcr = 0;
		double LambdaPF = 0;
		double LambdaRF = 0;
		double LambdaPW = 0;
		double LambdaRW = 0;
		double Mcflb = 0;
		double kc = 0;
		double Mn_top = 0;
		double Rpc = 0;
		double Myc = 0;
		double Mcfy = 0;
		double Rpg = 0;
		double phiVn = 0;
		double VnAll = 0;
		double Cv = 0;
		double Cb = 0;
		double Phi = 0;
		double Omega = 0;
		boolean all_ok = true;
		String[] message = new String[10];
		String[] temp = new String[10];
		String flange = new String();
		String web = new String();
		
		// ****************** set material, section and load properties
        // set Modulus of Elasticity
        int E = 29000;  									// ksi
        EI = E * Ix;										// set EI       
        TL = Math.abs(DL + LL);								// set total load
        
        // ****************** calculate actual forces and deflections
        // determine maximum deflection
        D_TL = 5 * TL *  Math.pow(MainSpan, 4) / 12.0 / (384 * EI);
        D_LL = 5 * LL *  Math.pow(MainSpan, 4) / 12.0 / (384 * EI);
 
        if(code > 0)
            TL = Math.abs(1.2 * DL + 1.6 * LL);
        
        V = TL * MainSpan / 12.0 / 2;								// determine maximum shear
        Mpos = TL * Math.pow(MainSpan / 12.0, 2) / 8;				// determine maximum moments
        
        // ****************** calculate Moment capacity per AISC Chapter F
        // conservatively set Cb=1.0 for all cases
        Cb = (double) Math.round((12.5 * Math.pow(MainSpan, 2)) / (12.5 * Math.pow(MainSpan, 2) - 1.5 * Math.pow(Lb_top, 2)) * 100) / 100.0;
        
        message[1] = "C<sub>b</sub> = " + Double.toString(Cb);
 
        // ****determine shape state
        LambdaPF = 0.38 * Math.sqrt(E / Fy);
        LambdaRF = 1.0 * Math.sqrt(E / Fy);
        LambdaPW = 3.76 * Math.sqrt(E / Fy);
        LambdaRW = 5.7 * Math.sqrt(E / Fy);
        
        // flange
        if(bf_over_2tf <= LambdaPF)
        {
        	flange_state = state[0];
        	flange = "Compact";
        }
        else if(bf_over_2tf <= LambdaRF)
        {
        	flange_state = state[1];						
        	flange = "Noncompact";
        }
        else
        {
        	flange_state = state[2];
        	flange = "Slender";
        }
        
        message[2] = "Flange is " + flange;
        
        // web												
        if(h_over_tw <= LambdaPW)
        {
        	web_state = state[0];							
        	web = "Compact";
        }
        else if(h_over_tw <= LambdaRW)
        {
        	web_state = state[1];							
        	web = "Noncompact";
        }
        else
        {
        	web_state = state[2];
        	web = "Slender";
        }

        message[3] = "Web is " + web;
        
        // set chapter section in AISC based on state of shape        
        if(flange_state == state[0] && web_state == state[0])
        	section1 = section[0];
        else if(web_state == state[0])
        	section1 = section[1];
        else if(web_state == state[1])
        	section1 = section[2];
        else
        	section1 = section[3];
        
        // ****set limit states based on chapter section
        // Plastic limit state (eqn F2-1)
        Mp = Fy * Zx;
        
        message[6] = "(eqn F2-1)";
 
        if(section1 == section[0])
        {
        	// calcualate Lp (eqn F2-5)
            Lp = 1.76 * ry * Math.sqrt(E / Fy);

            // calculate Lr (eqn F2-6)
            Lr = 1.95 * rts * E / (0.7 * Fy) * Math.sqrt(J / (Sx * ho) + Math.sqrt(Math.pow((J / (Sx * ho)), 2) + 6.76 * Math.pow((0.7 * Fy / E), 2)));

            message[4] = "L<sub>p</sub> = " + Math.round((Lp / 12.00) * 100.00) / 100.0 + " ft. (eqn F2-5)";
            message[5] = "L<sub>r</sub> = " + Math.round((Lr / 12.00) * 100.00) / 100.0 + " ft. (eqn F2-6)";
            
            // ****Lateral torsional buckling limit state; calculate Mltb for top and bottom flanges
            if(Lb_top <= Lp)
            {
            	Mltb_top = Mp;
            	message[6] = "(eqn F2-1)";
            }
            else if(Lb_top <= Lr)
            {            	
                Mltb_top = Cb * (Mp - (Mp - 0.7 * Fy * Sx) * (Lb_top - Lp) / (Lr - Lp));
                if(Mltb_top > Mp) Mltb_top = Mp;
                message[6] = "(eqn F2-2)";
            }
            else
            {
            	// eqn F2-4
                Fcr = Cb * Math.pow(Math.PI, 2) * E / Math.pow((Lb_top / rts), 2) * Math.sqrt(1 + 0.078 * J / (Sx * ho) * Math.pow((Lb_top / rts), 2));
                Mltb_top = Fcr * Sx;
                message[6] = "(eqn F2-3)";
            }
            
            // ****set Mn
            Mn_top = minimum(Mp, Mltb_top) / 12.0;
        }
        else if(section1 == section[1])
        {
        	// ---------------------------------------------this section is identical to above for Section.F2
            // calcualate Lp (eqn F2-5)
            Lp = 1.76 * ry * Math.sqrt(E / Fy);

            // calculate Lr (eqn F2-6)
            Lr = 1.95 * rts * E / (0.7 * Fy) * Math.sqrt(J / (Sx * ho) + Math.sqrt(Math.pow((J / (Sx * ho)), 2) + 6.76 * Math.pow((0.7 * Fy / E), 2)));

            message[4] = "L<sub>p</sub> = " + Math.round((Lp / 12.00) * 100.00) / 100.0 + "ft. (eqn F2-5)";
            message[5] = "L<sub>r</sub> = " + Math.round((Lr / 12.00) * 100.00) / 100.0 + "ft. (eqn F2-6)";
            
            // ****Lateral torsional buckling limit state; calculate Mltb for top and bottom flanges
            
            if(Lb_top <= Lp)
            {
            	Mltb_top = Mp;
            	message[6] = "(eqn F2-1)";
            }
            else if(Lb_top <= Lr)
            {
                Mltb_top = Cb * (Mp - (Mp - 0.7 * Fy * Sx) * (Lb_top - Lp) / (Lr - Lp));
                if(Mltb_top > Mp) Mltb_top = Mp;
                message[6] = "(eqn F2-2)";
            }
            else
            {              
             	// eqn F2-4
                Fcr = Cb * Math.pow(Math.PI, 2) * E / Math.pow((Lb_top / rts), 2) * Math.sqrt(1 + 0.078 * J / (Sx * ho) * Math.pow((Lb_top / rts), 2));
                Mltb_top = Fcr * Sx;
                message[6] = "(eqn F2-3)";
            }            
            
            // ---------------------------------------------            
            // ****Compression flange local bucking limit state; calculate Mcflb for top and bottom flanges
            if(flange_state == state[1])            	
            {
                Mcflb = Mp - (Mp - 0.7 * Fy * Sx) * (bf_over_2tf - LambdaPF) / (LambdaRF - LambdaPF);
                temp[0] = "(eqn F3-1)";
            }
            else if(flange_state == state[2])	
            {
                kc = 4 / Math.sqrt(h_over_tw);
                Mcflb = 0.9 * E * kc * Sx / Math.pow(bf_over_2tf, 2);
                temp[0] = "(eqn F3-2)";
            }

            // ****set Mn
            Mn_top = minimum(Mp, Mltb_top, Mcflb) / 12.0;
            
            if(Mn_top == Mcflb)
            	message[6] = new String(temp[0]);
        }
        else if(section1 == section[2])
        {
        	// ****Compression Flange Yielding
            Mp = minimum(Fy * Zx, 1.6 * Fy * Sx);
            Myc = Fy * Sx;
            
            if(Iyc_over_Iy > 0.23)
            {
                if(h_over_tw <= LambdaPW)
                    Rpc = Mp / Myc;
                else
                {
                    Rpc = (Mp / Myc - (Mp / Myc - 1) * (h_over_tw - LambdaPW) / (LambdaRW - LambdaPW));
                    Rpc = minimum(Rpc, Mp / Myc);
                }
            }
            else
                Rpc = 1.0;
            
            Mcfy = Rpc * Myc;
            message[6] = "(eqn F4-1)";

            // ****Lateral-torsional Buckling
            // calcualate Lp (eqn F4-7)
            Lp = 1.1 * rt * Math.sqrt(E / Fy);

            // calculate Lr (eqn F4-8)
            Lr = 1.95 * rt * E / (0.7 * Fy) * Math.sqrt(J / (Sx * ho) + Math.sqrt(Math.pow((J / (Sx * ho)), 2) + 6.76 * Math.pow((0.7 * Fy / E), 2)));
            
            message[4] = "L<sub>p</sub> = " + Math.round((Lp / 12.00) * 100.00) / 100.0 + "ft. (eqn F2-5)";
            message[5] = "L<sub>r</sub> = " + Math.round((Lr / 12.00) * 100.00) / 100.0 + "ft. (eqn F2-6)";

            if(Lb_top <= Lp)
            	Mltb_top = Mcfy;
            else if(Lb_top <= Lr)
            {
            	 Mltb_top = Cb * (Rpc * Myc - (Rpc * Myc - 0.7 * Fy * Sx) * (Lb_top - Lp) / (Lr - Lp));		// eqn F4-2
            	 message[6] = "(eqn F4-2)";
            }
            else
            {
                if(Iyc_over_Iy <= 0.23)
                    Fcr = Cb * Math.pow(Math.PI, 2) * E / Math.pow((Lb_top / rt), 2);		// eqn F4-5
                else
                    Fcr = Cb * Math.pow(Math.PI, 2) * E / Math.pow((Lb_top / rt), 2) * Math.sqrt(1 + 0.078 * J / (Sx * ho) * Math.pow((Lb_top / rt), 2));      // eqn F4-5
                
                Mltb_top = Fcr * Sx;
                message[6] = "(eqnS. F4-4, F4-5)";
            }
                
            // ****Compression flange local bucking limit state; calculate Mcflb for top and bottom flanges
            if(flange_state == state[0])
            	Mcflb = Mcfy;							// compact flange, so this state does not apply
            else if(flange_state == state[1])
            {
            	 Mcflb = Mcfy - (Mcfy - 0.7 * Fy * Sx) * (bf_over_2tf - LambdaPF) / (LambdaRF - LambdaPF);
            	 temp[0] = "(eqn F4-13)";
            }
            else if(flange_state == state[2])
            {
            	// slender flange, eqn F4-14
                kc = 4 / Math.sqrt(h_over_tw);
                Mcflb = 0.9 * E * kc * Sx / Math.pow(bf_over_2tf, 2);
                temp[0] = "(eqn F4-14)";
            }            
            
            // ****tension flange yielding
            // this limit state does not apply since Sxt=Sxc for doubly symetric shapes

            // ****set Mn
            Mn_top = minimum(Mcfy, Mltb_top, Mcflb) / 12.0;
            
            if(Mn_top == Mcflb)
            	message[6] = new String(temp[0]);
        }
        else if(section1 == section[3])
        {
        	// ****Compression Flange Yielding
           if(aw > 10) aw = 10;
           
           Rpg = 1 - aw / (12.000 + 300 * aw) * (h_over_tw - 5.7 * Math.sqrt(E / Fy));		// eqn F5-6
           Mcfy = Rpg * Fy * Sx;            // eqn F5-1
           
           message[6] = "(eqn F5-1)";

           // ****Lateral-torsional Buckling
           Lp = 1.1 * rt * Math.sqrt(E / Fy);	         	    // calcualate Lp (eqn F4-7)           
           Lr = Math.PI * rt * Math.sqrt(E / (0.7 * Fy));		// calculate Lr (eqn F5-5)

           message[4] = "L<sub>p</sub> = " + Lp / 12.0 + "ft. (eqn F4-7)";
           message[5] = "L<sub>r</sub> = " + Lp / 12.0 + "ft. (eqn F5-5)";
           
           if(Lb_top <= Lp)
        	   Mltb_top = Mcfy;
           else if(Lb_top <= Lr)
           {
               Fcr = minimum(Cb * (Fy - (0.3 * Fy) * (Lb_top - Lp) / (Lr - Lp)), Fy);
               Mltb_top = Fcr * Rpg * Sx;
               message[6] = "(eqnS. F5-2, F5-3)";
           }
           else
           {
        	   // eqn F5-4
               Fcr = minimum(Cb * Math.pow(Math.PI, 2) * E / Math.pow((Lb_top / rt), 2), Fy);
               Mltb_top = Fcr * Rpg * Sx;
               message[6] = "(eqnS. F5-2, F5-4)";
           }

            // ****Compression flange local bucking limit state; calculate Mcflb for top and bottom flanges
           if(flange_state == state[0])
           {
        	   // compact flange, so this state does not apply
               Mcflb = Mcfy;
           }
           else if(flange_state == state[1])
           {
        	   // noncompact flange, eqn F5-8
               Mcflb = Rpg * Sx * (Fy - (0.3 * Fy) * (bf_over_2tf - LambdaPF) / (LambdaRF - LambdaPF));
               temp[0] = "(eqn F5-8)";
           }
           else if(flange_state == state[2])
           {
        	   // slender flange, eqn F5-9
               kc = 4 / Math.sqrt(h_over_tw);
               Mcflb = Rpg * Sx * 0.9 * E * kc / Math.pow(bf_over_2tf, 2);
               temp[0] = "(eqn F5-9)";
           }
           
           // ****tension flange yielding
           // this limit state does not apply since Sxt=Sxc for doubly symetric shapes

           // ****set Mn
           Mn_top = minimum(Mcfy, Mltb_top, Mcflb) / 12.0;
           
           if(Mn_top == Mcflb)
        	   message[6] = temp[0];
        }      
 
        // ****************** calculate shear capacity per AISC Chapter G
        if(h_over_tw <= 2.24 * Math.sqrt(E / Fy))
        {
            Cv = 1;
            Phi = 1.0;
            Omega = 1.5;            
            temp[1] = "C<sub>v</sub> = 1.0 (eqn G2-2)";
            
            if(code > 0)
            	temp[2] = "&#934; = 1.0";
            else
            	temp[2] = "&#937; = 1.5";
        }
        else if(h_over_tw <= 1.1 * Math.sqrt(5 * E / Fy))
        {
            Cv = 1;
            Phi = 0.9;
            Omega = 1.67;            
            temp[1] = "C<sub>v</sub> = 1.0 (eqn G2-3)";
            
            if(code > 0)
            	temp[2] = "&#934; = 0.9";
            else
            	temp[2] = "&#937; = 1.67";
        }
        else if(h_over_tw <= 1.37 * Math.sqrt(5 * E / Fy))
        {
            Cv = 1.1 * Math.sqrt(5 * E / Fy) / h_over_tw;
            Phi = 0.9;
            Omega = 1.67;            
            temp[1] = "C<sub>v</sub> = " + Cv + " (eqn G2-4)";
            
            if(code > 0)
            	temp[2] = "&#934; = 0.9";
            else
            	temp[2] = "&#937; = 1.67";
        }
        else
        {
            Cv = 1.51 * 5 * E / (Math.pow(h_over_tw, 2) * Fy);
            Phi = 0.9;
            Omega = 1.67;
            temp[1] = "C<sub>v</sub> = " + Cv + " (eqn G2-5)";
            
            if(code > 0)
            	temp[2] = "&#934; = 0.9";
            else
            	temp[2] = "&#937; = 1.67";
        }
        
        // eqn G2-1
        phiVn = Phi * 0.6 * Fy * Aweb * Cv;
        VnAll = 0.6 * Fy * Aweb * Cv / Omega;
        
        DecimalFormat format1 = new DecimalFormat("#,##0.00");
        DecimalFormat format2 = new DecimalFormat("#,##0.000");
 
        // set message
        String msg = "";
        
        h_over_tw = Math.round(h_over_tw * 100.0) / 100.0;
        
        msg += "<b>" + shape.get_designation() + "</b><br/>";
        msg += "Span = " + MainSpan / 12.0 + " ft.<br/>";
        msg += "Yield Strength = F<sub>y</sub> " + Fy + " ksi<br/>";
        msg += "Dead Load = " + DL + " klf<br/>";
        msg += "Live Load = " + LL + " klf<br/>";
        msg += "<br/>";
        msg += "<u><b>Shear Check</b></u><br/>";
        msg += "h/t<sub>w</sub> = " + h_over_tw + "<br/>";
        msg += temp[1] + "<br/>";
        msg += temp[2] + "<br/>";        
        
        // LRFD
        if(code > 0)
        {
            msg += "Ultimate Shear Load, V<sub>u</sub> = " + format1.format(V) + " k";
            msg += "<br/>Factored Capcity, &#934;V<sub>n</sub> = " + format1.format(phiVn) + " k (eqn G2-1)";
           
            if(V <= phiVn)
                msg += "<br/>Shear is OK <br/>";
            else
            {
                msg += "<br/>Shear is NO GOOD <br/>";
                all_ok = false;
            }
        }
        else
        {
            msg += "<br/>Actual Shear Load, V = " + format1.format(V) + " k";
            msg += "<br/>Allowable Capcity, V<sub>n</sub>/&#937; = " + format1.format(VnAll) + " k (eqn G2-1)";
            
            if(V <= phiVn)
                msg += "<br/>Shear is OK<br/>";
            else
            {
                msg += "<br/>Shear is NO GOOD<br/>";
                all_ok = false;
            }
        }
        
        msg += "<br/><u><b>Moment Check</b></u><br/>";
        
        if(code > 0)
        	msg += "&#934; = 0.9<br/>";
        else
        	msg += "&#937; = 1.67<br/>";
        
        msg += message[1] + "<br/>";
        msg += message[2] + "<br/>";
        msg += message[3] + "<br/>";
        
        msg += "Unbraced Length, L<sub>b</sub> = " + Math.round((Lb_top / 12.0) * 100.0) / 100.0  + " ft.<br/>";
        
        msg += message[4] + "<br/>";
        msg += message[5] + "<br/>";
        
        if(code > 0)
        {
        	 msg += "<br/>Ultimate Moment, M<sub>u</sub> = " + format1.format(Mpos) + " k-ft";
             msg += "<br/>Factored Capcity, &#934;M<sub>n</sub> = " + format1.format(Mn_top * 0.9) + " k-ft " + message[6];
             
             if(Mpos <= Mn_top * 0.9)
                 msg += "<br/>Moment is OK<br/>";
             else
             {
                 msg += "<br/>Moment is NO GOOD<br/>";
                 all_ok = false;
             }
        }
        else
        {
        	 msg += "<br/>Actual Moment, M = " + format1.format(Mpos) + " k-ft";
             msg += "<br/>Allowable Capcity, M<sub>n</sub>/&#937; = " + format1.format(Mn_top / 1.67) + " k-ft " + message[6];
             
             if(Mpos <= Mn_top / 1.67)
                 msg += "<br/>Positive Moment is OK<br/>";
             else
             {
                 msg += "<br/>Positive Moment is NO GOOD<br/>";
                 all_ok = false;
             }
        }        

        double TLall = 0;
        double LLall = 0;
        
        if(TLL > 0)
            TLall = MainSpan / TLL;

        if(AbsoluteTLL > 0)
            TLall = minimum(TLall, AbsoluteTLL);
        
        if(LLL > 0)
            LLall = MainSpan / LLL;

        if(AbsoluteLLL > 0)
            LLall = minimum(LLall, AbsoluteLLL);
        
        msg += "<br/><u><b>Deflection Check</b></u><br/>";
        
        msg += "Actual Live Load Deflection = " + format1.format(D_LL) + (char)34 + "<br/>";
		
        if(LLall != 0)
        {
            msg += "Allowable Deflection = " + format2.format(LLall) + (char)34 + "<br/>";
            if(D_LL <= LLall)
                msg += "Live Load Deflection is OK<br/>";
            else
            {
                msg += "Live Load Deflection is NO GOOD<br/>";
                all_ok = false;
            }
        }

        msg +=  "<br/>Actual Total Load Deflection = " + format1.format(D_TL) + (char)34 + "<br/>";
        
        if(TLall != 0)
        {
           msg += "Allowable Deflection = " + format2.format(TLall) + (char)34 + "<br/>";
        
        	if(D_TL <= TLall)
               msg += "Total Load Deflection is OK<br/>";
            else
            {
               msg += "Total Load Deflection is NO GOOD<br/>";
               all_ok = false;
            }
        }      
        
        if(all_ok)
        	msg += "<br/><b>Beam is OK</b><br/>";
        else
        	msg += "<br/><b>Beam is <u>NOT</u> OK</b><br/>";
        
        msg += "</br>";
        
        showResults(this, msg);
	}
	
	private double minimum(double value1, double value2, double value3)
	{
		double result = 0;
		
		if((value1 < value2) && (value1 < value3))
			result = value1;
        else if((value2 < value1) && (value2 < value3))
        	result = value2;
        else
        	result = value3;
		
		return result;
	}	
	
	private double minimum(double value1, double value2)
	{
		double result = 0;
		
		if(value1 < value2)
			result = value1;
		else
			result = value2;
		
		return result;
	}
}
