/*
 * 
 * Source library: https://github.com/pardom/ActiveAndroid/wiki/Getting-started
 * 
 */

package org.mangelt.spellinglesson.database;

import java.util.List;

import org.mangelt.spellinglesson.activities.MenuActivity;
import org.mangelt.spellinglesson.domain.Category;
import org.mangelt.spellinglesson.domain.Item;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

import android.content.Context;
import android.util.Log;

public class DataBaseActiveAndroid {
	
	private final String log = DataBaseActiveAndroid.class.getSimpleName();
	
	 public DataBaseActiveAndroid(Context cxt){
		 ActiveAndroid.initialize(cxt);
	 }
	 
	 public void howToUse(){
		 
		Category restaurants = new Category();
        restaurants.name = "Restaurants";
        restaurants.save();
        
        Item item = new Item();
        item.category = restaurants;
        item.name = "Outback Steakhouse";
        item.save();
        
        item = new Item();
        item.category = restaurants;
        item.name = "Red Robin";
        item.save();
         
        item = new Item();
        item.category = restaurants;
        item.name = "Olive Garden";
        item.save();
        
//        ActiveAndroid.beginTransaction();
//        try {
//                for (int i = 0; i < 100; i++) {
//                    item = new Item();
//                    item.name = "Example " + i;
//                    item.save();
//                }
//                ActiveAndroid.setTransactionSuccessful();
//        }
//        finally {
//                ActiveAndroid.endTransaction();
//        }
        
        /*You can delete records in three different ways*/ 
        
//        with the first way you must choose one of the records by its id, and then calling the delete function like the following example:
        
//        you have to take care of this way, because if the record dosen't exit you can have an error when you tray to delete one that's why the Object is empty.    
//        item = Item.load(Item.class, 416);
//        item.delete();
        
//        with the second way you must call directly the delete function from the Item class  like this:
        
        Item.delete(Item.class, 417);
        
//        with the last you can use a query builder to make this task:
        
        new Delete().from(Item.class).where("Id = ?", 418).execute();
        
        /*
         * Querying the database 
         * 
         * */
        
//        get a single record random
        
        item = new Select().from(Item.class).orderBy("RANDOM()").executeSingle();
        
        Log.i(log, "RANDOM record: " + item.toString());
        
//        get a record by category
        
        item = new Select()
		.from(Item.class)
		.where("Category = ?", restaurants.getId())
		.orderBy("RANDOM()")
		.executeSingle();
        
        Log.i(log, "random record by Category: " + item.toString());
        
//        get all records by category
        
        List<Item> records = new Select()
		.from(Item.class)
		.where("Category = ?", restaurants.getId())
		.orderBy("Name ASC")
		.execute();
        
        Log.i(log, "all records from the table: " + records.toString());
        
	 }
	 
}
