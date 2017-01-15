package ac.physicalfitnesspro;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

import java.util.ArrayList;
import java.util.List;

import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.adapters.CustomCardCreateWorkout;
import ac.physicalfitnesspro.helper.DatabaseHelper;
import ac.physicalfitnesspro.model.Workout;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class CreateWorkoutActivity extends Activity {

	int MENU_DELETE = Menu.FIRST;
	CardArrayAdapter adapter;
	CustomCardCreateWorkout card;
	CardListView cardView;
	ArrayList<Card> cards;
	Context context;
	ArrayList<String> listData1= new ArrayList<String>();
	ArrayList<Integer> id_data= new ArrayList<Integer>();
	ArrayList<String> days_data= new ArrayList<String>();
	SharedPreferences sharedPreferences;
	Editor editor;
	DatabaseHelper db;
	int i=0;
	int id=0;
	ActionBar actionBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_create_workout);

		SpannableString s = new SpannableString("CREATE WORKOUT");
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D75BD")));
		actionBar.setTitle(s);
		
		sharedPreferences= getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
		editor= sharedPreferences.edit();
		if(sharedPreferences.getInt("second", 0)==0)
		{
			Toast.makeText(context, "Swipe to Delete!!",Toast.LENGTH_LONG).show();
			editor.putInt("second", 1);
			editor.commit();
		}
		listData1.add("Create Workout");
	//	System.out.println(listData1.get(0));
		//editor.putInt("first_login", 0);
		try
		{
			db = new DatabaseHelper(context);

			Log.d("Reading: ", "Reading all contacts..");
			List<Workout> nameWorkout = db.getAllToDos();       

			if(nameWorkout!=null)
			{
				for (Workout cn : nameWorkout) {
					String log = "Id: "+cn.getId()+", Workout Name: " + cn.getWorkout_name()+", Number of Days: "+cn.getNumber_of_days()+", Created At: "+cn.getCreated_at(); 
					// Writing Contacts to log
					listData1.add(cn.getWorkout_name());
					id_data.add(cn.getId());
					days_data.add(cn.getNumber_of_days());
					Log.d("Workout Details: ", log);
				}
			}
		}
		catch(Exception e)
		{
			Toast.makeText(context, "Try again!!! =)",
					Toast.LENGTH_LONG).show();
		}

		cards = new ArrayList<Card>();
		card = new CustomCardCreateWorkout(context, listData1,i);
		//listData1.get(i+1),days_data.get(i),id_data.get(i));
		cards.add(card);
		for(int i=1;i<listData1.size();i++)
		{ 
			if(i<=(listData1.size()-1))
			{
				id=id_data.get(i-1);
				card = new CustomCardCreateWorkout(context, listData1,i,listData1.get(i),days_data.get(i-1),id_data.get(i-1));
				cards.add(card);
				card.setSwipeable(true);
//				System.out.println(i+"  dfvfdv   "+listData1.size());
			}
			else 
			{
	//			System.out.println(i+"  dfvfdv   "+listData1.size());
				break;
			}
		}
		adapter = new CardArrayAdapter(context, cards);
		cardView = (CardListView) findViewById(R.id.create_workout_list);
		cardView.setAdapter(adapter);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.diabetes_schedule, menu);

		MenuItem set1=menu.add(Menu.NONE,MENU_DELETE,1,wrapInSpan(getResources().getString(R.string.delete)))
				.setTitleCondensed(getResources().getString(R.string.delete));
		set1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		return super.onCreateOptionsMenu(menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id=item.getItemId();
		if(id == MENU_DELETE)
		{

			Toast.makeText(this, "Swipe card to delete", Toast.LENGTH_SHORT).show();

		}


		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onBackPressed() {
		
		Intent mainIntent1 = new Intent(context,PhysicalSchedule.class);
		mainIntent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(mainIntent1);
	}
	
	private CharSequence wrapInSpan(CharSequence value) {
		SpannableStringBuilder sb = new SpannableStringBuilder(value);
		sb.setSpan(new TypefaceSpan(context,"Roboto-Medium.ttf"), 0, value.length(), 0);
		return sb;
	}
	
}
