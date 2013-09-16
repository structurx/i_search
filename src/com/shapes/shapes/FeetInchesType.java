package com.shapes.shapes;
import java.text.DecimalFormat;

public class FeetInchesType
{
	private double feet;
	private double inches;
	private String input;
	
	public enum FeetInches
	{
		Feet1,
		Inches1
	}
	
	public enum LengthUnitsType
	{
		Feet,
        Ft,
        FeetSymbol,
        Inches,
        InchAbbrev,
        InchSymbol,
        FtIn
	}
	
	public FeetInchesType()
	{
		this.feet = 0;
		this.inches = 0;
		this.input = "";
	}
	
	public double getFeet()
	{
		return this.feet;
	}
	
	public double getInches()
	{
		return this.feet;
	}
	
	public String getDisplayValue()
	{
		return this.input;
	}
	
	public void setDisplayValue(String value, int precision, FeetInches default_units, LengthUnitsType display_units)
	{
		this.input = formattedLength(value, precision, default_units, display_units);
	}
	
	public String formattedLength(String value, int precision, FeetInches default_units, LengthUnitsType display_units)
	{
		String result = new String();
		String fraction = new String();
		String descriptor = new String();
		String[] current_value = {new String(), new String()};
		String numerator = new String();
		String denominator = new String();
		boolean repeat = true;
		int negative = 0;
		
		if(value.length() > 0)
		{			
			if(value.substring(0, 1).equals("-"))
			{
				value = value.substring(1, value.length());
				negative = -1;
			}
			else
			{
				negative = 1;
			}
			
			value.replace(",", "");
			
			while((value.length() > 0) && ("0123456789.".indexOf(value.charAt(0)) > -1))
			{
				current_value[0] = current_value[0].toString() + value.substring(0, 1);
				value = value.substring(1, value.length());
			}
			
			// find the first descriptor or fraction
			while(repeat && value.length() > 0)
			{
				if("-".indexOf(value.charAt(0)) > -1)
				{
					// it's a separator for foot-inches
					value = value.substring(1, value.length());
					descriptor = "F";
				}
				else if("'FOET".indexOf(Character.toUpperCase(value.charAt(0))) > -1)
				{
					value = value.substring(1, value.length());
					descriptor = "F";
				}
				else if("\"INCHS".indexOf(Character.toUpperCase(value.charAt(0))) > -1)
				{
					value = value.substring(1, value.length());
					descriptor = "I";
				}
				else if("0123456789.".indexOf(value.charAt(0)) > -1)
				{
					repeat = false;
				}
				else if(" ".indexOf(value.charAt(0)) > -1)
				{
					if(descriptor.equals("F"))
					{
						repeat = false;
						value = value.substring(1, value.length());
					}
					else
					{
						if(value.indexOf("/") > -1)
						{
							fraction = value.substring(1, value.length());
							value = value.substring(1, value.length());
							
							while(repeat)
							{
								if((value.length() > 0) && "0123456789./".indexOf(value.charAt(0)) > -1)
									value = value.substring(1, value.length());
								else
									repeat = false;
							}
							repeat = true;
						}
						else
						{
							value = value.substring(1, value.length());
						}
					}
				}
				else if("/".indexOf(value.charAt(0)) > -1)
				{
					fraction = current_value[0] + value;
					current_value[0] = "0";
					value = fraction;
					while(repeat)
					{
						if(value.length() > 0 && "0123456789./".indexOf(value.substring(0, 1)) > -1)
							value = value.substring(1, value.length());
						else
							repeat = false;
					}
					fraction = fraction.substring(0, fraction.length() - value.length());
					repeat = true;
				}
				else
				{
					value = value.substring(1, value.length());
				}				
			}
			
			// find second number
			if(value.length() == 0 && descriptor.matches("I"))
			{
				// there is no second number; units as inches
				feet = 0;
				
				if(current_value[0].length() > 0)
					inches = Double.parseDouble(current_value[0]);
					
				if(!fraction.matches(""))
				{
					numerator = fraction.substring(0, fraction.trim().indexOf("/"));
					denominator = fraction.substring(fraction.trim().indexOf("/") + 1, fraction.length());
					repeat = true;
					while(repeat)
					{
						if(denominator.length() > 1 && "0123456789.".indexOf(denominator.substring(0, 1)) > -1)
							denominator = denominator.substring(0, denominator.length() - 1);
						else
							repeat = false;
					}
					inches = inches + Double.parseDouble(numerator) / Double.parseDouble(denominator);
				}
				fraction = "";
			}
			else if(value.length() == 0 && descriptor.matches("F"))
			{
				// there is no second number; units as feet
				inches = 0;
				
				if(current_value[0].toUpperCase().matches("[A-Z]*"))
				{
					feet = 0;
				}
				else
				{
					feet = Double.parseDouble(current_value[0]);
				}				
				
				if(!fraction.matches(""))
				{
					numerator = fraction.substring(0, fraction.trim().indexOf("/"));
					denominator = fraction.substring(fraction.trim().indexOf("/") + 1, fraction.length());
					feet = feet + Double.parseDouble(numerator) / Double.parseDouble(denominator);
				}
				fraction = "";
			}
			else if(value.length() == 0 && descriptor.matches(""))
			{
				// there is no second number; units unknown
				// default to unit format of text box
				switch(default_units)
				{
					case Inches1:
						feet = 0;
						inches = Double.parseDouble(current_value[0]);
						// finish for the fraction
						if(!fraction.matches(""))
						{
							numerator = fraction.substring(0, fraction.trim().indexOf("/"));
							denominator = fraction.substring(fraction.trim().indexOf("/") + 1, fraction.length());
							if(denominator.length() > 0)
								inches = inches + Double.parseDouble(numerator) / Double.parseDouble(denominator);
						}
						fraction = "";
						break;
					case Feet1:
						feet = Double.parseDouble(current_value[0]);
						inches = 0;
						// finish for the fraction
						if(!fraction.matches(""))
						{							
							numerator = fraction.substring(0, fraction.trim().indexOf("/"));
							denominator = fraction.substring(fraction.trim().indexOf("/") + 1, fraction.length());
							if(denominator.length() > 0)
								feet = feet + Double.parseDouble(numerator) / Double.parseDouble(denominator);
						}
						fraction = "";
						break;
				}				
			}
			else
			{
				// there should be another number
				while(value.length() > 0)
				{
					if("0123456789.".indexOf(value.substring(0, 1)) > -1)
					{
						current_value[1] += value.substring(0, 1);
						value = value.substring(1, value.length());
					}
					else if(" ".indexOf(value.substring(0, 1)) > -1)
					{
						fraction = value.substring(1, value.length());
						value = "";
					}
					else if("/".indexOf(value.substring(0, 1)) > -1)
					{
						repeat = true;
						fraction = current_value[1] + value;
						current_value[1] = "0";
						value = fraction;
						while(repeat)
						{
							if(value.length() > 0 && "0123456789./".indexOf(value.substring(0, 1)) > -1)
								value = value.substring(1, value.length());
							else
								repeat = false;
						}
						fraction = fraction.substring(0, fraction.length() - value.length());
					}
					else
					{
						value = value.substring(1, value.length());
					}
				}
				
				feet = Double.parseDouble(current_value[0]);
				inches = Double.parseDouble(current_value[1]);
				
				// finish for the fraction
				if(!fraction.matches("") && fraction.indexOf("/") > -1)
				{
					numerator = fraction.substring(0, fraction.trim().indexOf("/"));
					denominator = fraction.substring(fraction.trim().indexOf("/") + 1, fraction.length());
					repeat = true;
					while(repeat)
					{
						if(denominator.length() > 1 && "0123456789.".indexOf(denominator.substring(0, 1)) > -1)
							denominator = denominator.substring(0, denominator.length() - 1);
						else
							repeat = false;
					}
					inches = inches + Double.parseDouble(numerator) / Double.parseDouble(denominator);
				}
			}
			
			double feet = this.feet;
			double inches = this.inches;
			String str = new String();
			double n = 1;
			
			for(int i=0; i<precision; i++)
			{
				n *= 10;
				str += "0";
			}
			
			if(str.length() > 0)
				str = "." + str;
			
			DecimalFormat df = new DecimalFormat("#0" + str);
			
			switch(display_units)
			{
				case Feet:
					result = df.format((float)(Math.round((negative * (feet + inches / 12)) * n)) / n).toString() + " feet";
					break;
				case Ft:
					result = df.format((float)(Math.round((negative * (feet + inches / 12)) * n)) / n).toString() + " ft";
					break;
				case FeetSymbol:
					result = df.format((float)(Math.round((negative * (feet + inches / 12)) * n)) / n).toString() + "'";
					break;
				case Inches:
					result = df.format((float)(Math.round((negative * feet * 12 + inches) * n)) / n).toString() + " inches";
					break;
				case InchAbbrev:
					result = df.format((float)(Math.round((negative * feet * 12 + inches) * n)) / n).toString() + " in";
					break;
				case InchSymbol:
					result = df.format((float)(Math.round((negative * feet * 12 + inches) * n)) / n).toString() + (char)34;
					break;
				case FtIn:
					DecimalFormat df2 = new DecimalFormat("###,##0");
					inches += 12 * (feet - ((int)feet));
					if(inches >= 12)
					{
						feet = feet + (int)(inches / 12);
						inches = inches - 12 * (int)(inches / 12);
					}
					result = df2.format((double)(Math.round((negative * (int)feet) * n) / n)).toString() + "'-" + df.format((double)((int)(inches * n) / n)).toString() + (char)34;
					if(feet == 0 && negative == -1)
						result = "-" + result;
					
					break;
				default:
					result = "0";
					break;
			}
			
			double temp_feet = this.feet;
			double temp_inches = this.inches;
			this.feet = negative * (temp_feet + temp_inches / 12);
			this.inches = negative * (temp_feet * 12 + temp_inches);
		}
		
		return result;
	}	
}