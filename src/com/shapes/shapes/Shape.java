package com.shapes.shapes;
/*
*	Author:  John Musgrave
*	Date:  11/26/12
*	Abstract:  Class for Shape data
*/

public class Shape
{
	private int id;
	private int start_year;
	private int end_year;
	private String edition;
	private String designation;
	private double ag;
	private double d;
	private double tw;
	private double bf;
	private double tf;
	private double h;
	private double ho;
	private double aweb;
	private double aw;
	private double bf_2tf;
	private double h_tw;
	private double ix;
	private double zx;
	private double sx;
	private double rx;
	private double iy;
	private double iyc_over_iy;
	private double ry;
	private double j;
	private double rt;
	private double rts;
	
	// class constructor
	public Shape()
	{
		this.id = 0;
		this.start_year = 0;
		this.end_year = 0;
		this.edition = "";
		this.designation = "";
		this.ag = 0;
		this.d = 0;
		this.tw = 0;
		this.bf = 0;
		this.tf = 0;
		this.h = 0;
		this.ho = 0;
		this.aweb = 0;
		this.aw = 0;
		this.bf_2tf = 0;
		this.h_tw = 0;
		this.ix = 0;
		this.zx = 0;
		this.sx = 0;
		this.rx = 0;
		this.iy = 0;
		this.iyc_over_iy = 0;
		this.ry = 0;
		this.j = 0;
		this.rt = 0;
		this.rts = 0;	
	}
	
	public Shape(int id, int start_year, int end_year, String edition, String designation, double ag, double d, double tw, double bf, double tf, double h, double ho, double aweb, double aw, double bf_2tf, double h_tw, double ix, double zx, double sx, double rx, double iy, double iyc_over_iy, double ry, double j, double rt, double rts)
	{
		this.id = id;
		this.start_year = start_year;
		this.end_year = end_year;
		this.edition = edition;
		this.designation = designation;
		this.ag = ag;
		this.d = d;
		this.tw = tw;
		this.bf = bf;
		this.tf = tf;
		this.h = h;
		this.ho = ho;
		this.aweb = aweb;
		this.aw = aw;
		this.bf_2tf = bf_2tf;
		this.h_tw = h_tw;
		this.ix = ix;
		this.zx = zx;
		this.sx = sx;
		this.rx = rx;
		this.iy = iy;
		this.iyc_over_iy = iyc_over_iy;
		this.ry = ry;
		this.j = j;
		this.rt = rt;
		this.rts = rts;	
	}
	
	public int get_id()
	{
		return this.id;
	}

	public void set_id(int id)
	{
		this.id = id;
	}

	public int get_start_year()
	{
		return this.start_year;
	}

	public void set_start_year(int start_year)
	{
		this.start_year = start_year;
	}

	public int get_end_year()
	{
		return this.end_year;
	}

	public void set_end_year(int end_year)
	{
		this.end_year = end_year;
	}

	public String get_edition()
	{
		return this.edition;
	}

	public void set_edition(String edition)
	{
		this.edition = edition;
	}

	public String get_designation()
	{
		return this.designation;
	}

	public void set_designation(String designation)
	{
		this.designation = designation;
	}

	public double get_ag()
	{
		return this.ag;
	}

	public void set_ag(double ag)
	{
		this.ag = ag;
	}
	
	public double get_d()
	{
		return this.d;
	}

	public void set_d(double d)
	{
		this.d = d;
	}

	public double get_tw()
	{
		return this.tw;
	}

	public void set_tw(double tw)
	{
		this.tw = tw;
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

	public double get_h()
	{
		return this.h;
	}

	public void set_h(double h)
	{
		this.h = h;
	}

	public double get_ho()
	{
		return this.ho;
	}

	public void set_ho(double ho)
	{
		this.ho = ho;
	}

	public double get_aweb()
	{
		return this.aweb;
	}

	public void set_aweb(double aweb)
	{
		this.aweb = aweb;
	}

	public double get_aw()
	{
		return this.aw;
	}

	public void set_aw(double aw)
	{
		this.aw = aw;
	}

	public double get_bf_2tf()
	{
		return this.bf_2tf;
	}

	public void set_bf_2tf(double bf_2tf)
	{
		this.bf_2tf = bf_2tf;
	}

	public double get_h_tw()
	{
		return this.h_tw;
	}

	public void set_h_tw(double h_tw)
	{
		this.h_tw = h_tw;
	}

	public double get_ix()
	{
		return this.ix;
	}

	public void set_ix(double ix)
	{
		this.ix = ix;
	}

	public double get_zx()
	{
		return this.zx;
	}

	public void set_zx(double zx)
	{
		this.zx = zx;
	}

	public double get_sx()
	{
		return this.sx;
	}

	public void set_sx(double sx)
	{
		this.sx = sx;
	}

	public double get_rx()
	{
		return this.rx;
	}

	public void set_rx(double rx)
	{
		this.rx = rx;
	}

	public double get_iy()
	{
		return this.iy;
	}

	public void set_iy(double iy)
	{
		this.iy = iy;
	}

	public double get_iyc_over_iy()
	{
		return this.iyc_over_iy;
	}

	public void set_iyc_over_iy(double iyc_over_iy)
	{
		this.iyc_over_iy = iyc_over_iy;
	}

	public double get_ry()
	{
		return this.ry;
	}

	public void set_ry(double ry)
	{
		this.ry = ry;
	}

	public double get_j()
	{
		return this.j;
	}

	public void set_j(double j)
	{
		this.j = j;
	}

	public double get_rt()
	{
		return this.rt;
	}

	public void set_rt(double rt)
	{
		this.rt = rt;
	}

	public double get_rts()
	{
		return this.rts;
	}

	public void set_rts(double rts)
	{
		this.rts = rts;
	}

}