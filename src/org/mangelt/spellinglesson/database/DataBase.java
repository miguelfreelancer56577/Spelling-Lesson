package org.mangelt.spellinglesson.database;

import java.util.ArrayList;
import java.util.HashMap;

import com.Visdrotech.library.sqlitehelp.main.SQLiteHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBase extends SQLiteHelper{

	public static final String NAMEBD = "spellinglesson";
	private final String log = DataBase.class.getSimpleName();
//	name of the tables
	public static final String TBLLESSONS = "lessons";
	public static final String TBLCATALOGSPANISH = "catalog_spanish";
	public static final String TBLCATALOGENGLISH = "catalog_english";
	public static final String TBLCATALOGWORDS = "words";
	
	public DataBase(Context contexto) {
		super(contexto, NAMEBD);
		createTables();
    }
	
	public void createTables(){
//		table lessons
		if(super.isTablePresent(TBLLESSONS) == false){
			ArrayList<String> columns = new ArrayList<String>(); 
			columns.add("id_lesson@integer");
			columns.add("description@text");
			createStructureCols(TBLLESSONS, columns);
			ArrayList<String> rows = new ArrayList<String>();
			rows.add("1@5A");
//			rows.add("2@lesson 5");
//			rows.add("3@6A");
//			rows.add("4@6B");
//			rows.add("5@7A");
//			rows.add("6@7B");
//			rows.add("7@8A");
//			rows.add("8@8B");
			populateTable(TBLLESSONS, columns, rows);
		}
//		table catalog_spanish
		if(super.isTablePresent(TBLCATALOGSPANISH) == false){
			ArrayList<String> columns = new ArrayList<String>(); 
			columns.add("id_word_s@integer");
			columns.add("description@text");
			createStructureCols(TBLCATALOGSPANISH, columns);
			ArrayList<String> rows = new ArrayList<String>();
			rows.add("1@saltar");
			rows.add("2@jaula");
			populateTable(TBLCATALOGSPANISH, columns, rows);
		}
//		table catalog_english
		if(super.isTablePresent(TBLCATALOGENGLISH) == false){
			ArrayList<String> columns = new ArrayList<String>(); 
			columns.add("id_word_e@integer");
			columns.add("description@text");
			createStructureCols(TBLCATALOGENGLISH, columns);
			ArrayList<String> rows = new ArrayList<String>();
			rows.add("1@leap");
			rows.add("2@hurdle");
			rows.add("3@jump");
			rows.add("4@cage");
			populateTable(TBLCATALOGENGLISH, columns, rows);
		}
//		table words
		if(super.isTablePresent(TBLCATALOGWORDS) == false){
			ArrayList<String> columns = new ArrayList<String>(); 
			columns.add("id_lesson@integer");
			columns.add("id_word_s@integer");
			columns.add("id_word_e@integer");
			createStructureCols(TBLCATALOGWORDS, columns);
			ArrayList<String> rows = new ArrayList<String>();
			rows.add("1@1@1");
			rows.add("1@1@2");
			rows.add("1@1@3");
			rows.add("1@2@4");
			populateTable(TBLCATALOGWORDS, columns, rows);
		}
		
	}
	public void createStructureCols(final String table, final ArrayList<String> columns){
		ArrayList<String> cols = new ArrayList<String>();
		HashMap<String, String> typeMap = new HashMap<String, String>();
		for (String current : columns) {
			String[] column = current.split("@");
			cols.add(column[0]);
			typeMap.put(column[0], column[1]);
		}
		if(cols.size() > 0 && typeMap.size() > 0){
			Log.d(log, "creating table:\n " + table + "\nwith columns:\n "  + columns);
			super.createTable(table, cols, typeMap);
		}
			
	}
	
	public void populateTable(final String table, final ArrayList<String> columns, final ArrayList<String> rows){
		ArrayList<ContentValues> records = new ArrayList<ContentValues>();
		for (String row : rows) {
			String[] record = row.split("@");
			ContentValues values = new ContentValues();
			for (int i = 0; i < record.length; i++) {
				if(i > columns.size())
					break;
				String value = record[i];
				String nameColumn = columns.get(i).split("@")[0]; 
				values.put(nameColumn, value);
			}
			records.add(values);
		}
		Log.d(log, "inserting into table:\n " + table + "\nrecords:\n "  + records);
		super.insertMultipleEntries(table, records);
	}
}
