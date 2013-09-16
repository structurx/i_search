package com.shapes.shapes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHelper extends SQLiteOpenHelper
{
	@SuppressWarnings("unused")
	private Context context;
	
	OpenHelper(final Context context)
	{
		super(context, ShapeTable.DATABASE_NAME, null, ShapeTable.DATABASE_VERSION);
		this.context = context;
	}
	
	@Override
	public void onOpen(final SQLiteDatabase db)
	{
		super.onOpen(db);
	}
	
	// override onCreate to create tables
	@Override
	public void onCreate(final SQLiteDatabase db)
	{
		ShapeTable.onCreate(db);
		
		/*ShapeDAO shapeDao = new ShapeDAO(db);
		String[] categories = context.getResources().getStringArray(R.array.tmdb_shapes);
		for(String s : shapes)
		{
			shapeDao.save(new Shape(0, s));
		}
		MovieTable.onCreate(db);
		MovieCategoryTable.onCreate(db);*/
	}
	
	@Override
	public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion)
	{
		ShapeTable.onUpgrade(db, oldVersion, newVersion);
	}
}