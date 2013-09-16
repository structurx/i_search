package com.shapes.shapes;

public class ColumnAnalysis
{
	private double height;
	private double weak_axis;
	private double strong_axis;
	private int yield_strength;
	private double d;
	private double bf;
	private double tf;
	private double tw;
	private double result;
	
	public ColumnAnalysis(double height, double weak_axis, double strong_axis, int yield_strength, double d, double bf, double tf, double tw)
	{
		this.height = height;
		this.weak_axis = weak_axis;
		this.strong_axis = strong_axis;
		this.yield_strength = yield_strength;
		this.d = d;
		this.bf = bf;
		this.tf = tf;
		this.tw = tw;
	}
	
	public ColumnAnalysis()
	{
		this.height = 0;
		this.weak_axis = 0;
		this.strong_axis = 0;
		this.yield_strength = 0;
		this.d = 0;
		this. bf = 0;
		this.tf = 0;
		this. tw = 0;
		this.result = 0;		
	}
	
	public double analyze()
	{
		return result;
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	public void setHeight(double height)
	{
		this.height = height;
	}
	
	public double getWeakAxis()
	{
		return this.weak_axis;
	}
	
	public void setWeakAxis(double weak_axis)
	{
		this.weak_axis = weak_axis;
	}
	
	public double getStrongAxis()
	{
		return this.strong_axis;
	}
	
	public void setStrongAxis(double strong_axis)
	{
		this.strong_axis = strong_axis;
	}
	
	public int getYieldStrength()
	{
		return this.yield_strength;
	}
	
	public void setYieldStrength(int yield_strength)
	{
		this.yield_strength = yield_strength;
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