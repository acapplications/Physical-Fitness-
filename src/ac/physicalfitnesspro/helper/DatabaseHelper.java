package ac.physicalfitnesspro.helper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import ac.physicalfitnesspro.model.Workout;
import ac.physicalfitnesspro.model.WorkoutDescDayWise;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	// Logcat tag
	private static final String LOG = "DatabaseHelper";

	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "workoutManager";

	// Table Names
	private static final String TABLE_NAME_WORKOUT = "workout";
	private static final String TABLE_NAME_WORKOUT_DESC = "workoutDescDayWise";
	//  private static final String TABLE_TODO_TAG = "todo_tags";

	// Common column names
	private static final String KEY_ID = "id";
	private static final String KEY_CREATED_AT = "created_at";

	//workout Table - column names
	private static final String KEY_WORKOUT_NAME = "workout_name";
	private static final String KEY_NUMBER_OF_DAYS = "number_of_days";


	// workoutDescDayWise Table - column names
	private static final String KEY_WORKOUT_ID = "workout_id";
	private static final String KEY_DESCRIPTION = "description";
	private static final String KEY_IMG = "image";
	private static final String KEY_DAY = "dayA";
	private static final String KEY_EXERCISE_NAME="exercise_name";
	private static final String KEY_CREATED_AT_TWO = "created_at";
	/*// NOTE_TAGS Table - column names
    private static final String KEY_TODO_ID = "todo_id";
    private static final String KEY_TAG_ID = "tag_id";*/

	// Table Create Statements
	// Todo table create statement
	private static final String CREATE_WORKOUT = "CREATE TABLE "
			+ TABLE_NAME_WORKOUT + "(" + KEY_ID + " INTEGER PRIMARY KEY ," 
			+ KEY_WORKOUT_NAME + " TEXT,"
			+ KEY_NUMBER_OF_DAYS + " STRING,"
			+ KEY_CREATED_AT + " DATETIME" + ", UNIQUE("+KEY_WORKOUT_NAME+"))";

	// Tag table create statement
	private static final String CREATE_WORKOUT_DESC = "CREATE TABLE " + TABLE_NAME_WORKOUT_DESC
			+ " (" + KEY_ID + " INTEGER PRIMARY KEY, " 
			+ KEY_WORKOUT_ID + " INTEGER, "
			+ KEY_EXERCISE_NAME + " TEXT, "
			+ KEY_DAY+ " TEXT, "
			+ KEY_IMG+ " INTEGER,"
			+ KEY_DESCRIPTION + " TEXT, "
			+ KEY_CREATED_AT_TWO + " DATETIME" + ")";
	/*
    // todo_tag table create statement
    private static final String CREATE_TABLE_TODO_TAG = "CREATE TABLE "
            + TABLE_TODO_TAG + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_TODO_ID + " INTEGER," + KEY_TAG_ID + " INTEGER,"
            + KEY_CREATED_AT + " DATETIME" + ")";
	 */
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// creating required tables
		db.execSQL(CREATE_WORKOUT);
		db.execSQL(CREATE_WORKOUT_DESC);
		//db.execSQL(CREATE_TABLE_TODO_TAG);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// on upgrade drop older tables
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_WORKOUT);
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_WORKOUT_DESC);
		//db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO_TAG);

		// create new tables
		onCreate(db);
	}



	// ------------------------ "workout" table methods ----------------//

	public long createTag(WorkoutDescDayWise tag) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_DESCRIPTION, tag.getDescription());
		values.put(KEY_WORKOUT_ID, tag.getWorkout_id());
		values.put(KEY_EXERCISE_NAME, tag.getExercise_Name());
		values.put(KEY_IMG,tag.getImage());
		values.put(KEY_DAY, tag.getDay());
		values.put(KEY_CREATED_AT_TWO, getDateTime());

		// insert row
		long tag_id = db.insert(TABLE_NAME_WORKOUT_DESC, null, values);

		return tag_id;
	}
	
	/*
	 * Creating a todo
	 */
	public long createToDo(Workout workout) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_WORKOUT_NAME, workout.getWorkout_name());
		values.put(KEY_NUMBER_OF_DAYS, workout.getNumber_of_days());
		values.put(KEY_CREATED_AT, getDateTime());

		// insert row
		long todo_id = db.insert(TABLE_NAME_WORKOUT, null, values);

		/*// insert tag_ids
 		for (long tag_id : tag_ids) {
 			createTodoTag(todo_id, tag_id);
 		}*/
		return todo_id;
	}

	/*
	 * get single todo
	 */
	public Workout getWorkout(long workout_id) {
		SQLiteDatabase db = this.getReadableDatabase();

		String selectQuery = "SELECT  * FROM " + TABLE_NAME_WORKOUT + " WHERE "
				+ KEY_ID + " = " + workout_id;

		Log.e(LOG, selectQuery);

		Cursor c = db.rawQuery(selectQuery, null);

		if (c != null)
			c.moveToFirst();

		Workout td = new Workout();
		td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
		td.setWorkout_name((c.getString(c.getColumnIndex(KEY_WORKOUT_NAME))));
		td.setNumber_of_days((c.getString(c.getColumnIndex(KEY_NUMBER_OF_DAYS))));
		td.setCreated_at(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

		return td;
	}

	/**
	 * getting all todos
	 * */
	public List<Workout> getAllToDos() {
		List<Workout> workout = new ArrayList<Workout>();
		String selectQuery = "SELECT  * FROM " + TABLE_NAME_WORKOUT;

		Log.e(LOG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (c.moveToFirst()) {
			do {
				Workout td = new Workout();
				td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
				//System.out.println("ID-----------------"+c.getInt(c.getColumnIndex(KEY_ID)));
				td.setWorkout_name((c.getString(c.getColumnIndex(KEY_WORKOUT_NAME))));
				//System.out.println("Workout Name------------------------"+(c.getString(c.getColumnIndex(KEY_WORKOUT_NAME))));
				td.setNumber_of_days((c.getString(c.getColumnIndex(KEY_NUMBER_OF_DAYS))));
				//System.out.println("No Of Days -------------------"+(c.getString(c.getColumnIndex(KEY_NUMBER_OF_DAYS))));
				td.setCreated_at(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

				// adding to todo list
				workout.add(td);
			} while (c.moveToNext());
		}

		return workout;
	}

	/**
	 * getting all todos under single tag
	 * */
	public List<Workout> getAllWorkoutByWorkoutName(String workout_name) {
		List<Workout> workout = new ArrayList<Workout>();

		String selectQuery = "SELECT  * FROM " + TABLE_NAME_WORKOUT + " tnw, "
				+ TABLE_NAME_WORKOUT_DESC + " tnwd WHERE tnw."
				+ KEY_WORKOUT_NAME + " = '" + workout_name + "'" + " AND tnw." + KEY_ID
				+ " = " + "tnwd." + KEY_WORKOUT_ID;

		Log.e(LOG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (c.moveToFirst()) {
			do {
				Workout td = new Workout();
				td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
				td.setWorkout_name((c.getString(c.getColumnIndex(KEY_WORKOUT_NAME))));
				td.setNumber_of_days((c.getString(c.getColumnIndex(KEY_NUMBER_OF_DAYS))));
				td.setCreated_at(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

				// adding to todo list
				workout.add(td);
			} while (c.moveToNext());
		}

		return workout;
	}

	/*
	 * get workout id
	 */
	
	public int getWorkoutId(String workoutName) {
		String countQuery = "SELECT  * FROM " + TABLE_NAME_WORKOUT +"where key_workout_Name = "+workoutName +" order by key_created_at desc" ;
		SQLiteDatabase db = this.getReadableDatabase();
		int id = 0;
		Cursor cursor = db.rawQuery(countQuery, null);
		if(cursor.moveToFirst()) {
			
			do {
				id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
			}while(cursor.moveToNext());
		}

		// return count
		return id;
	}
	
	/*
	 * getting todo count
	 */
	public int getWorkoutCount() {
		String countQuery = "SELECT  * FROM " + TABLE_NAME_WORKOUT;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);

		int count = cursor.getCount();
		cursor.close();

		// return count
		return count;
	}

	/*
	 * Updating a todo
	 */
	public int updateToDo(Workout todo) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NUMBER_OF_DAYS, todo.getNumber_of_days());
		values.put(KEY_WORKOUT_NAME, todo.getWorkout_name());

		// updating row
		return db.update(TABLE_NAME_WORKOUT, values, KEY_ID + " = ?",
				new String[] { String.valueOf(todo.getId()) });
	}

	/*
	 * Deleting a todo
	 */
	public void deleteWorkoutName(long tado_id) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NAME_WORKOUT, KEY_ID + " = ?",
				new String[] { String.valueOf(tado_id) });
		db.delete(TABLE_NAME_WORKOUT_DESC, KEY_WORKOUT_ID + " = ?",
				new String[] { String.valueOf(tado_id) });
		
	}
	/*public void deleteWorkoutDescription(long del_id)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NAME_WORKOUT_DESC, KEY_ID + " = ?",
				new String[] { String.valueOf(del_id) });	
	}*/

	// ------------------------ "workout desc" table methods ----------------//

	/*
	 * Creating tag
	 */
	

	/**
	 * getting all tags
	 * */
	public List<WorkoutDescDayWise> getAllTags() {
		List<WorkoutDescDayWise> tags = new ArrayList<WorkoutDescDayWise>();
		String selectQuery = "SELECT  * FROM " + TABLE_NAME_WORKOUT_DESC;
		Log.e(LOG, selectQuery);
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (c.moveToFirst()) {
			do {
				WorkoutDescDayWise t = new WorkoutDescDayWise();
				t.setId(c.getInt((c.getColumnIndex(KEY_ID))));
				t.setDescription(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
				t.setDay(c.getString(c.getColumnIndex(KEY_DAY)));
				t.setExercise_Name(c.getString(c.getColumnIndex(KEY_EXERCISE_NAME)));
				t.setWorkout_id(c.getInt(c.getColumnIndex(KEY_WORKOUT_ID)));
				t.setCreated_at(c.getString(c.getColumnIndex(KEY_CREATED_AT_TWO)));
				t.setImage(c.getInt(c.getColumnIndex(KEY_IMG)));
				// adding to tags list
				tags.add(t);
			} while (c.moveToNext());
		}
		return tags;
	}
	
	public List<WorkoutDescDayWise> getDetailsDayWise(int workoutId, int day) {
		List<WorkoutDescDayWise> tags = new ArrayList<WorkoutDescDayWise>();
		String selectQuery = "SELECT  * FROM " + TABLE_NAME_WORKOUT_DESC +" WHERE "+KEY_WORKOUT_ID+" = " + workoutId +" AND "+KEY_DAY+" = "+day;
		Log.e(LOG, selectQuery);
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (c.moveToFirst()) {
			do {
				WorkoutDescDayWise t = new WorkoutDescDayWise();
				t.setId(c.getInt((c.getColumnIndex(KEY_ID))));
				t.setDescription(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
				t.setDay(c.getString(c.getColumnIndex(KEY_DAY)));
				t.setExercise_Name(c.getString(c.getColumnIndex(KEY_EXERCISE_NAME)));
				t.setWorkout_id(c.getInt(c.getColumnIndex(KEY_WORKOUT_ID)));
				t.setCreated_at(c.getString(c.getColumnIndex(KEY_CREATED_AT_TWO)));
				t.setImage(c.getInt(c.getColumnIndex(KEY_IMG)));
				// adding to tags list
				tags.add(t);
			} while (c.moveToNext());
		}
		return tags;
	}
	
	

	/*
	 * Updating a description
	 */
	public int updateDesc(WorkoutDescDayWise tag) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_DESCRIPTION, tag.getDescription());

		// updating row
		return db.update(TABLE_NAME_WORKOUT_DESC, values, KEY_ID + " = ?",
				new String[] { String.valueOf(tag.getId()) });
	}

	/*
	 * Updating a day
	 */
	public int updateDay(long id, long day) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_DAY, day);

		// updating row
		return db.update(TABLE_NAME_WORKOUT_DESC, values, KEY_ID + " = ?",
				new String[] { String.valueOf(id) });
	}

	/*
	 * Deleting a todo tag
	 */
	public void deleteWorkoutDescDayWise(long id) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NAME_WORKOUT_DESC, KEY_ID + " = ?",
				new String[] { String.valueOf(id) });
	}

	// closing database
	public void closeDB() {
		SQLiteDatabase db = this.getReadableDatabase();
		if (db != null && db.isOpen())
			db.close();
	}

	/**
	 * get datetime
	 * */
	private String getDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date date = new Date();
		return dateFormat.format(date);
	}
}
