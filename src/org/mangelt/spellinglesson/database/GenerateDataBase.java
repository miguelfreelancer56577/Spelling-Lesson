package org.mangelt.spellinglesson.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class GenerateDataBase extends SQLiteOpenHelper {

	public static final String NAMEBD = "spellinglesson";
	public static final int VERSION = 0;
	private final String log = GenerateDataBase.class.getSimpleName();
	
	public GenerateDataBase(Context contexto, CursorFactory factory) {
        super(contexto, NAMEBD, factory, VERSION);
    }
	
	@Override
    public void onCreate(SQLiteDatabase db) {
		
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
    	
    }
	public void populate(){
		
	}
	public boolean isExit(){
		return false;
	}
}
