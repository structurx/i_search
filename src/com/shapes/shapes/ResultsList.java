package com.shapes.shapes;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsList extends ListActivity {
	// define the data source
	private ArrayList<String> list_data;
	private Shape[] shapes;
	private int selected_position;
	private ShapeTable shape_table;
    private FeetInchesType type;
    private float[] settings;
    private float[] search;
    private Shape selected;
    private int shape_id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setWindowAnimations(1);

        this.shapes = null;
        this.shape_table = new ShapeTable();
        this.selected_position = -1;
        this.list_data = new ArrayList<String>();
        this.type = new FeetInchesType();
        Options.previous = ResultsList.class;
        this.search = shape_table.getSearch(this);
        this.settings = shape_table.getSettings(this);
        this.selected = new Shape();
        this.shape_id = -1;
        
	    String str_d = Float.toString(search[1]);
		String str_bf = Float.toString(search[2]);
		String str_tf = Float.toString(search[3]);
		String str_tw = Float.toString(search[4]);
		String str_year = Float.toString(search[5]);
		String str_d_tolerance = Float.toString(settings[1]);
		String str_bf_tolerance = Float.toString(settings[2]);
		String str_tf_tolerance = Float.toString(settings[3]);
		String str_tw_tolerance = Float.toString(settings[4]);
		String str_year_tolerance = Float.toString(settings[5]);
		
		float d = 0;
		float bf = 0;
		float tf = 0;
		float tw = 0;
		float year = 0;
		float d_tolerance = 0;
		float bf_tolerance = 0;
		float tf_tolerance = 0;
		float tw_tolerance = 0;
		float year_tolerance = 0;
		
		TextView txt_d = (TextView) findViewById(R.id.search_d);
		TextView txt_bf = (TextView) findViewById(R.id.search_bf);
		TextView txt_tf = (TextView) findViewById(R.id.search_tf);
		TextView txt_tw = (TextView) findViewById(R.id.search_tw);
		TextView txt_year = (TextView) findViewById(R.id.search_year);
		
		if(str_d.length() == 0)
			str_d = "0";
		if(str_bf.length() == 0)
			str_bf = "0";
		if(str_tf.length() == 0)
			str_tf = "0";
		if(str_tw.length() == 0)
			str_tw = "0";
		if(str_year.length() == 0)
			str_year = "0";
		else
			str_year = str_year.substring(0, str_year.length() - 2);		
		
		type.setDisplayValue(str_d, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		txt_d.setText(" = " + type.getDisplayValue() + "  \u00B1" + str_d_tolerance + "\"");
		
		type.setDisplayValue(str_bf, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		txt_bf.setText(" = " + type.getDisplayValue() + "  \u00B1" + str_bf_tolerance + "\"");
		
		type.setDisplayValue(str_tf, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		txt_tf.setText(" = " + type.getDisplayValue() + "  \u00B1" + str_tf_tolerance + "\"");
		
		type.setDisplayValue(str_tw, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		txt_tw.setText(" = " + type.getDisplayValue() + "  \u00B1" + str_tw_tolerance + "\"");
		
		txt_year.setText(" = " + str_year + "  \u00B1" + str_year_tolerance);
		
		if(str_d.length() > 0)
			d = Float.parseFloat(str_d.replace("\"", ""));
		
		if(str_bf.length() > 0)
			bf = Float.parseFloat(str_bf.replace("\"", ""));
		
		if(str_tf.length() > 0)
			tf = Float.parseFloat(str_tf.replace("\"", ""));
		
		if(str_tw.length() > 0)
			tw = Float.parseFloat(str_tw.replace("\"", ""));
		
		if(str_year.length() > 0)
			year = Float.parseFloat(str_year);
		
		if(str_d_tolerance.length() > 0)
			d_tolerance = Float.parseFloat(str_d_tolerance.replace("\"", ""));
		
		if(str_bf_tolerance.length() > 0)
			bf_tolerance = Float.parseFloat(str_bf_tolerance.replace("\"", ""));
		
		if(str_tf_tolerance.length() > 0)
			tf_tolerance = Float.parseFloat(str_tf_tolerance.replace("\"", ""));
		
		if(str_tw_tolerance.length() > 0)
			tw_tolerance = Float.parseFloat(str_tw_tolerance.replace("\"", ""));	
		
		if(str_year_tolerance.length() > 0)
			year_tolerance = Float.parseFloat(str_year_tolerance);
                
		// query DB
		shapes = shape_table.getShapes(this, d, bf, tf, tw, year, d_tolerance, bf_tolerance, tf_tolerance, tw_tolerance, year_tolerance);
		
		int length;
		TextView total = (TextView)findViewById(R.id.total);
		
		if(shapes.length > 100)
		{
			length = 100;
			total.setText("Found 100+ shapes");
		}
		else
		{
			length = shapes.length;
			total.setText("Found " + length + " shapes");
		}
		
		// add objects into the array list
		for(int i=0; i<length; i++)
			this.list_data.add(shapes[i].get_designation());

        // setup the data adaptor
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.text, this.list_data);

        // specify the list adaptor
        setListAdapter(adapter);
        
        final ListView list = (ListView)findViewById(android.R.id.list);            
        list.setClickable(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {          
          public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
        	
            // Object o = list.getItemAtPosition(position);            
            /* write you handling code like...
            String st = "sdcard/";
            File f = new File(st+o.toString());
            // do whatever u want to do with 'f' File object
            */
            
            shape_click(position);
          }
        });
        
        if(MainActivity.pd != null)
    		MainActivity.pd.dismiss();
    }
    
    private void shape_click(int position)
    {
    	Shape shape = shapes[position];        
        this.selected_position = position;        
        this.shape_id= shape.get_id(); 

        String str_d = Double.toString(shape.get_d());
        String str_bf = Double.toString(shape.get_bf()); 
        String str_tf = Double.toString(shape.get_tf());
        String str_tw = Double.toString(shape.get_tw());
        String str_start_year = Integer.toString(shape.get_start_year());
        String str_end_year = Integer.toString(shape.get_end_year());
        
		type.setDisplayValue(str_d, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		str_d = type.getDisplayValue();
		
		type.setDisplayValue(str_bf, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		str_bf = type.getDisplayValue();
		
		type.setDisplayValue(str_tf, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		str_tf = type.getDisplayValue();
		
		type.setDisplayValue(str_tw, 4, FeetInchesType.FeetInches.Inches1, FeetInchesType.LengthUnitsType.InchSymbol);
		str_tw = type.getDisplayValue();
        
        show_values(str_d, str_bf, str_tf, str_tw, str_start_year, str_end_year);
    }
    
    
    public void show_values(String str_d, String str_bf, String str_tf, String str_tw, String str_start_year, String str_end_year)
    {
		TextView txt_d = (TextView) findViewById(R.id.d);
		TextView txt_bf = (TextView) findViewById(R.id.bf);
		TextView txt_tf = (TextView) findViewById(R.id.tf);
		TextView txt_tw = (TextView) findViewById(R.id.tw);
		TextView txt_year = (TextView) findViewById(R.id.years);
		
		// TextView txt_start_year = null;
		// TextView txt_end_year = null;
		// this.selected.set_d(Double.parseDouble(str_d.replace("\"", "")));		
		
		if(str_d.length() > 0)
			txt_d.setText(" = " + str_d);
		
		if(str_bf.length() > 0)
			txt_bf.setText(" = " + str_bf);
		
		if(str_tf.length() > 0)
			txt_tf.setText(" = " + str_tf);
		
		if(str_tw.length() > 0)
			txt_tw.setText(" = " + str_tw);
		
		if(str_start_year.length() > 0 && str_end_year.length() > 0)
			txt_year.setText(" = " + str_start_year + " - " + str_end_year);
    }
    
    public void home_click(MenuItem menu_item) {
		Intent intent = new Intent(this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);		
		overridePendingTransition(R.anim.push_up, R.anim.push_out);
	}
    
    public void options_click(MenuItem menu_item) {
    	Options.previous = ResultsList.class;
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
    
    public void beam_click(View view) {
    	if(this.selected_position > -1)
    	{	
    		// get the shape based on the id
    		this.selected = this.shape_table.getShape(this, this.shape_id);
    		
    		// save the shape selection
    		this.shape_table.updateSelected(this.selected, this);
    		
	    	Intent intent = new Intent(this, Analyze.class);
	    	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			overridePendingTransition(R.anim.push_up, R.anim.push_out);
    	}
    	else
    	{
    		Toast.makeText(this, "Please make a selection.", Toast.LENGTH_LONG).show();
    	}
    }
    
    public void column_click(View view) {
    	if(this.selected_position > -1)
    	{	
    		// get the shape based on the id
    		this.selected = this.shape_table.getShape(this, this.shape_id);
    		
    		// save the shape selection
    		this.shape_table.updateSelected(this.selected, this);
    		
	    	Intent intent = new Intent(this, AnalyzeColumn.class);
	    	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			overridePendingTransition(R.anim.push_up, R.anim.push_out);
    	}
    	else
    	{
    		Toast.makeText(this, "Please make a selection.", Toast.LENGTH_LONG).show();
    	}
    }
    
    @SuppressWarnings("deprecation")		
    public void copy_click(View view)
    {
    	Shape shape = this.shape_table.getShape(this, this.shape_id);
    	
    	String message = "<b>" + shape.get_designation() + "</b>" +
    			"<br/>" +
    			"d = " + shape.get_d() + 
    			"<br/>" +
    			"bf = " + shape.get_bf() + 
    			"<br/>" +
    			"tf = " + shape.get_tf() + 
    			"<br/>" +
    			"tw = " + shape.get_tw() + 
    			"<br/>" +
    			"Year = " + shape.get_start_year() + " - " + shape.get_end_year() +    			
    			"<br/><br/>" +
    			"Search:" +
    			"<br/>" +
    			"d = " + Float.toString(search[1]) + " &plusmn; " + Float.toString(settings[1]) + "\"" + 
    			"<br/>" +
    			"bf = " + Float.toString(search[2]) + " &plusmn; " + Float.toString(settings[2]) + "\"" +
    			"<br/>" +
    			"tf = " + Float.toString(search[3]) + " &plusmn; " + Float.toString(settings[3]) + "\"" +
    			"<br/>" +
    			"tw = " + Float.toString(search[4]) + " &plusmn; " + Float.toString(settings[4]) + "\"" +
    			"<br/>" +
    			"Year = " + Float.toString(search[5]) + " &plusmn; " + Float.toString(settings[5]) +
    			"";    	
    		
		android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
 	    clipboard.setText(Html.fromHtml(message).toString());
 	    
 	    Toast.makeText(this, "Copied " + shape.get_designation() + " to Clipboard",  Toast.LENGTH_LONG).show();
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_results, menu);
        return true;
    }
}