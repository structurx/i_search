package com.shapes.shapes;

public class BeamAnalysis
{
	private double left_cantilever;
	private double main_span;
	private double right_cantilever;
	private double top_flange;
	private double bottom_flange;
	private int yield_strength;
	private int live_limit;
	private double live_absolute;
	private int total_limit;
	private double total_absolute;
	private double dead_load;
	private double live_load;
	private double d;
	private double bf;
	private double tf;
	private double tw;
	private double result;
	
	public BeamAnalysis(double left_cantilever, double main_span, double right_cantilever, double top_flange, double bottom_flange, int yield_strength, int live_limit, double live_absolute, int total_limit, double total_absolute, double dead_load, double live_load, double d, double bf, double tf, double tw)
	{
		this.left_cantilever = left_cantilever;
		this.main_span = main_span;
		this.right_cantilever = right_cantilever;
		this.top_flange = top_flange;
		this.bottom_flange = bottom_flange;
		this.yield_strength = yield_strength;
		this.live_limit = live_limit;
		this.live_absolute = live_absolute;
		this.total_limit = total_limit;
		this.total_absolute = total_absolute;
		this.dead_load = dead_load;
		this.live_load = live_load;
		this.d = d;
		this.bf = bf;
		this.tf = tf;
		this.tw = tw;
	}	
	
	public BeamAnalysis()
	{
		this.left_cantilever = 0;
		this.main_span = 0;
		this.right_cantilever = 0;
		this.top_flange = 0;
		this.bottom_flange = 0;
		this.yield_strength = 0;
		this.live_limit = 0;
		this.live_absolute = 0;
		this.total_limit = 0;
		this.total_absolute = 0;
		this.dead_load = 0;
		this.live_load = 0;
		this.d = 0;
		this.bf = 0;
		this.tf = 0;
		this.tw = 0;
		this.result = 0;
	}
	
	public double analyze()
	{
		return result;
	}
		
	public double getLeftCantilever()
	{
		return this.left_cantilever;
	}
	
	public void setLeftCantilever(double left_cantilever)
	{
		this.left_cantilever = left_cantilever;
	}
	
	public double getMainSpan()
	{
		return this.main_span;
	}
	
	public void setMainSpan(double main_span)
	{
		this.main_span = main_span;
	}
	
	public double getRightCantilever()
	{
		return this.right_cantilever;
	}
	
	public void setRightCantilever(double right_cantilever)
	{
		this.right_cantilever = right_cantilever;
	}
	
	public double getTopFlange()
	{
		return this.top_flange;
	}
	
	public void setTopFlange(double top_flange)
	{
		this.top_flange = top_flange;
	}
	
	public double getBottomFlange()
	{
		return this.bottom_flange;
	}
	
	public void setBottomFlange(double bottom_flange)
	{
		this.bottom_flange = bottom_flange;
	}
	
	public int getYieldStrength()
	{
		return this.yield_strength;
	}
	
	public void setYieldStrength(int yield_strength)
	{
		this.yield_strength = yield_strength;
	}
	
	public int getLiveLimit()
	{
		return this.live_limit;
	}
	
	public void setLiveLimit(int live_limit)
	{
		this.live_limit = live_limit;
	}
	
	public int getTotalLimit()
	{
		return this.total_limit;
	}
	
	public double getLiveAbsolute()
	{
		return this.live_absolute;
	}
	
	public void setLiveAbsolute(double live_absolute)
	{
		this.live_absolute = live_absolute;
	}
	
	public void setTotalLimit(int total_limit)
	{
		this.total_limit = total_limit;
	}

	public double getTotalAbsolute()
	{
		return this.total_absolute;
	}
	
	public void setTotalAbsolute(double total_absolute)
	{
		this.total_absolute = total_absolute;
	}
	
	public double getDeadLoad()
	{
		return this.dead_load;
	}
	
	public void setDeadLoad(double dead_load)
	{
		this.dead_load = dead_load;
	}
	
	public double getLiveLoad()
	{
		return this.live_load;
	}
	
	public void setLiveLoad(double live_load)
	{
		this.live_load = live_load;
	}
	
	public double get_d()
	{
		return this.d;
	}
	
	public void set_d(double d)
	{
		this.d = d;
	}
	
	public double get_bf()
	{
		return this.bf;
	}
	
	public void set_bf(double bf)
	{
		this.bf = bf;
	}
	
	public double get_tf()
	{
		return this.tf;
	}
	
	public void set_tf(double tf)
	{
		this.tf = tf;
	}
	
	public double get_tw()
	{
		return this.tw;
	}
	
	public void set_tw(double tw)
	{
		this.tw = tw;
	}
}