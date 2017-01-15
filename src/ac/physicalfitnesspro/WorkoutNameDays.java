package ac.physicalfitnesspro;

import java.util.ArrayList;
import java.util.List;

import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.helper.DatabaseHelper;
import ac.physicalfitnesspro.model.Workout;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WorkoutNameDays extends Activity {
	EditText workout_name;
	Context context;
	EditText no_days;
	int days;
	Button proceed;
	ActionBar actionBar;
	TextView name,n_dy;
	int i=0;
	int id;
	int check_same_name=0;
	ArrayList<String> dayList=new ArrayList<String>(7);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workout_name_days);
 
		context=getApplicationContext();

		SpannableString s = new SpannableString("ENTER DETAILS");
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/Roboto-Medium.ttf");
		actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D75BD")));
		actionBar.setTitle(s);

		final DatabaseHelper db = new DatabaseHelper(this);

		no_days=(EditText)findViewById(R.id.no_days);
		no_days.setTypeface(typeFace);
		no_days.setTextSize(22);
		no_days.setGravity(Gravity.CENTER);

		workout_name=(EditText)findViewById(R.id.workout_name);
		workout_name.setTypeface(typeFace);
		workout_name.setTextSize(22);
		workout_name.setGravity(Gravity.CENTER);

		proceed=(Button) findViewById(R.id.proceed);
		proceed.setTypeface(typeFace);
		proceed.setTextSize(25);

		name=(TextView)findViewById(R.id.workout_name_txt);
		name.setTypeface(typeFace);
		name.setTextSize(25);

		n_dy=(TextView)findViewById(R.id.no_days_txt);
		n_dy.setTypeface(typeFace);
		n_dy.setTextSize(25);

		proceed.setOnClickListener(new View.OnClickListener() {


			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				SharedPreferences sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
				Editor editor = sharedPreferences.edit();

				if(workout_name.getText().toString().equals(""))
				{
					Toast.makeText(context, "Enter Workout Name",
							Toast.LENGTH_LONG).show();
				}
				else
				{
					try
					{
						days=Integer.parseInt(no_days.getText().toString());

						Log.d("Insert: ", "Inserting ..");
						Workout oWorkout = new Workout();
						List<Workout> nameWorkout = db.getAllToDos();       
						if(nameWorkout!=null)
						{
							for (Workout cn : nameWorkout) {
								// Writing Contacts to log
								if(workout_name.getText().toString().equals(cn.getWorkout_name()))
								{
									editor.putInt("check_same_name",1);
									editor.commit();
								}
							}
						}

						check_same_name=sharedPreferences.getInt("check_same_name", 0);
						if(check_same_name==0)
						{
							oWorkout.setNumber_of_days(no_days.getText().toString());
							oWorkout.setWorkout_name(workout_name.getText().toString());
							db.createToDo(oWorkout);
							// Reading all contacts
							Log.d("Reading: ", "Reading all contacts..");
							for (Workout cn : nameWorkout) {
								String log = "Id: "+cn.getId()+", Workout Name: " + cn.getWorkout_name()+", Number of Days: "+cn.getNumber_of_days()+", Created At: "+cn.getCreated_at(); 
								// Writing Contacts to log
								id=cn.getId();
								Log.d("Workout Details: ", log);
							}

							Intent mainIntent = new Intent(context,CreateWorkoutActivity.class);
							editor.putInt("check_back_total", 1);
							editor.commit();
							mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
							context.startActivity(mainIntent);
							//	.finish();

						}
						else
						{
							Toast.makeText(context, "Duplicate data",
									Toast.LENGTH_LONG).show();
							editor.putInt("check_same_name",0);
							editor.commit();
						}
					}				
					catch(Exception e)
					{
						Toast.makeText(context, "Check the entered values =)",
								Toast.LENGTH_LONG).show();
					}
				}

			}
		});
	}

}
