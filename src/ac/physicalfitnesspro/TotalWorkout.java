package ac.physicalfitnesspro;


import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

import java.util.ArrayList;
import java.util.List;

import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.adapters.CustomCardAddExercise;
import ac.physicalfitnesspro.helper.DatabaseHelper;
import ac.physicalfitnesspro.model.WorkoutDescDayWise;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TotalWorkout extends Activity {

	int MENU_DELETE = Menu.FIRST;
	Button day1,day2,day3,day4,day5,day6,day7;
	CardArrayAdapter adapter1,adapter2,adapter3,adapter4,adapter5,adapter6,adapter7;
	Context context;
	CustomCardAddExercise Listcard1, Listcard2, Listcard3, Listcard4, Listcard5, Listcard6, Listcard7;
	CardListView cardView1, cardView2, cardView3, cardView4, cardView5, cardView6, cardView7;
	ArrayList<String> listData1=new ArrayList<String>(25),
			listData2=new ArrayList<String>(25),
			listData3=new ArrayList<String>(25)
			,listData4=new ArrayList<String>(25)
			, listData5=new ArrayList<String>(25)
			,listData6=new ArrayList<String>(25),
			listData7=new ArrayList<String>(25),
			dayList=new ArrayList<String>(7);

	ArrayList<String> listDesc1=new ArrayList<String>(25),
			listDesc2=new ArrayList<String>(25),
			listDesc3=new ArrayList<String>(25)
			,listDesc4=new ArrayList<String>(25)
			, listDesc5=new ArrayList<String>(25)
			,listDesc6=new ArrayList<String>(25),
			listDesc7=new ArrayList<String>(25);

	ArrayList<Integer> listImg1=new ArrayList<Integer>(25),
			listImg2=new ArrayList<Integer>(25),
			listImg3=new ArrayList<Integer>(25)
			,listImg4=new ArrayList<Integer>(25)
			, listImg5=new ArrayList<Integer>(25)
			,listImg6=new ArrayList<Integer>(25),
			listImg7=new ArrayList<Integer>(25);

	ArrayList<Integer> listId1=new ArrayList<Integer>(25),
			listId2=new ArrayList<Integer>(25),
			listId3=new ArrayList<Integer>(25)
			,listId4=new ArrayList<Integer>(25)
			, listId5=new ArrayList<Integer>(25)
			,listId6=new ArrayList<Integer>(25),
			listId7=new ArrayList<Integer>(25);

	ArrayList<Card> cards1, cards2, cards3, cards4, cards5, cards6, cards7;
	String workout_name;
	int no_of_days;
	int workout_id;
	ActionBar actionBar;
	DatabaseHelper db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_total_workout);

		context=getApplicationContext();

		SharedPreferences sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
		Editor editor = sharedpreferences.edit();

		if(sharedpreferences.getInt("first", 0)==0)
		{
			Toast.makeText(context, "Swipe to Delete!!",
					Toast.LENGTH_LONG).show();
			editor.putInt("first", 1);
			editor.commit();
		}
		if(sharedpreferences.getInt("check_same", 0)==1)
		{
			Toast.makeText(context, "Duplicate data",
					Toast.LENGTH_LONG).show();
			editor.putInt("check_same",0);
			editor.commit();	
		}


		Bundle extras = getIntent().getExtras();
		if (extras != null) {

			workout_name= extras.getString("workout_name");
			no_of_days= extras.getInt("no_of_days");
			workout_id= extras.getInt("workout_id");

		}
		SpannableString s = new SpannableString(workout_name);
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D75BD")));
		actionBar.setTitle(s);

		listData1.add("Add exercise");
		listDesc1.add("");
		listImg1.add(0);
		listData2.add("Add exercise");
		listDesc2.add("");
		listImg2.add(0);
		listData3.add("Add exercise");
		listDesc3.add("");
		listImg3.add(0);
		listData4.add("Add exercise");
		listDesc4.add("");
		listImg4.add(0);
		listData5.add("Add exercise");
		listDesc5.add("");
		listImg5.add(0);
		listData6.add("Add exercise");
		listDesc6.add("");
		listImg6.add(0);
		listData7.add("Add exercise");
		listDesc7.add("");
		listImg7.add(0);

		System.out.println(no_of_days +"fdbgnfsadgndsadgnsa*************");
		for(int i=1;i<=no_of_days;i++)
		{

			Log.d("Reading: ", "Reading all contacts.."); 
			db= new DatabaseHelper(context);
			List<WorkoutDescDayWise> workout =  db.getDetailsDayWise(workout_id, i);       

			if(workout!=null && !workout.isEmpty())
			{
				for (WorkoutDescDayWise cn : workout) {
					switch(i)
					{
					case 1:
						String log = "Id: "+cn.getExercise_Name()+" ,Name: " + cn.getExercise_Name();
						// Writing Contacts to log
						listData1.add(cn.getExercise_Name());
						//	System.out.println(cn.getExercise_Name());
						listDesc1.add(cn.getDescription());
						//	System.out.println(cn.getDescription());
						listImg1.add(cn.getImage());
						listId1.add(cn.getId());
						Log.d("Name: ", log);
						break;
					case 2:
						log = "Id: "+cn.getExercise_Name()+" ,Name: " + cn.getExercise_Name();
						// Writing Contacts to log
						listData2.add(cn.getExercise_Name());
						listDesc2.add(cn.getDescription());
						listImg2.add(cn.getImage());
						listId2.add(cn.getId());
						Log.d("Name: ", log);
						break;
					case 3:
						log = "Id: "+cn.getExercise_Name()+" ,Name: " + cn.getExercise_Name();
						// Writing Contacts to log
						listData3.add(cn.getExercise_Name());
						listDesc3.add(cn.getDescription());
						listImg3.add(cn.getImage());
						listId3.add(cn.getId());
						Log.d("Name: ", log);
						break;
					case 4:
						log = "Id: "+cn.getExercise_Name()+" ,Name: " + cn.getExercise_Name();
						// Writing Contacts to log
						listData4.add(cn.getExercise_Name());
						listDesc4.add(cn.getDescription());
						listImg4.add(cn.getImage());
						listId4.add(cn.getId());
						Log.d("Name: ", log);
						break;
					case 5:
						log = "Id: "+cn.getExercise_Name()+" ,Name: " + cn.getExercise_Name();
						listData5.add(cn.getExercise_Name());
						listDesc5.add(cn.getDescription());
						listImg5.add(cn.getImage());
						listId5.add(cn.getId());
						Log.d("Name: ", log);
						break;
					case 6:
						log = "Id: "+cn.getExercise_Name()+" ,Name: " + cn.getExercise_Name();
						// Writing Contacts to log
						listData6.add(cn.getExercise_Name());
						listDesc6.add(cn.getDescription());
						listImg6.add(cn.getImage());
						listId6.add(cn.getId());
						Log.d("Name: ", log);
						break;
					case 7:
						log = "Id: "+cn.getExercise_Name()+" ,Name: " + cn.getExercise_Name();
						// Writing Contacts to log
						listData7.add(cn.getExercise_Name());
						listDesc7.add(cn.getDescription());
						listImg7.add(cn.getImage());
						listId7.add(cn.getId());
						Log.d("Name: ", log);
						break;
					}

				}
			}
			else
			{
				break;
			}
		}
		day1=(Button)findViewById(R.id.day1);
		day2=(Button)findViewById(R.id.day2);
		day3=(Button)findViewById(R.id.day3);
		day4=(Button)findViewById(R.id.day4);
		day5=(Button)findViewById(R.id.day5);
		day6=(Button)findViewById(R.id.day6);
		day7=(Button)findViewById(R.id.day7);


		cardView1 = (CardListView) findViewById(R.id.dayList1);
		cardView1.setVisibility(CardListView.VISIBLE);
		cardView2 = (CardListView) findViewById(R.id.dayList2);

		cardView3 = (CardListView) findViewById(R.id.dayList3);

		cardView4 = (CardListView) findViewById(R.id.dayList4);

		cardView5 = (CardListView) findViewById(R.id.dayList5);

		cardView6 = (CardListView) findViewById(R.id.dayList6);

		cardView7 = (CardListView) findViewById(R.id.dayList7);



		switch(no_of_days)
		{
		case 1:
			day1.setVisibility(Button.VISIBLE);
			cards1 = new ArrayList<Card>();
			for(int i=0;i<listData1.size();i++)
			{ 
				Listcard1 = new CustomCardAddExercise(context, listData1,i,workout_name,workout_id,1,no_of_days, listDesc1, listImg1,listId1);
				cards1.add(Listcard1);	
				Listcard1.setSwipeable(true);
			}
			adapter1 = new CardArrayAdapter(context, cards1);
			cardView1.setAdapter(adapter1);
			break;
		case 2:
			day1.setVisibility(Button.VISIBLE);
			day2.setVisibility(Button.VISIBLE);
			cards1=new ArrayList<Card>();
			for(int i=0;i<listData1.size();i++)
			{ 
				Listcard1 = new CustomCardAddExercise(context, listData1,i,workout_name,workout_id,1,no_of_days, listDesc1, listImg1,listId1);
				System.out.println(workout_name);
				cards1.add(Listcard1);		
				Listcard1.setSwipeable(true);
			}
			adapter1 = new CardArrayAdapter(context, cards1);
			cardView1.setAdapter(adapter1);

			cards2 = new ArrayList<Card>();
			for(int i=0;i<listData2.size();i++)
			{ 
				Listcard2 = new CustomCardAddExercise(context, listData2,i,workout_name,workout_id,2,no_of_days, listDesc2, listImg2,listId2);
				cards2.add(Listcard2);		
				Listcard2.setSwipeable(true);
			}
			adapter2 = new CardArrayAdapter(context, cards2);
			cardView2.setAdapter(adapter2);
			break;

		case 3:
			day1.setVisibility(Button.VISIBLE);
			day2.setVisibility(Button.VISIBLE);
			day3.setVisibility(Button.VISIBLE);
			cards1 = new ArrayList<Card>();
			for(int i=0;i<listData1.size();i++)
			{ 
				Listcard1 = new CustomCardAddExercise(context, listData1,i,workout_name,workout_id,1,no_of_days, listDesc1, listImg1,listId1);
				cards1.add(Listcard1);
				Listcard1.setSwipeable(true);
			}
			adapter1 = new CardArrayAdapter(context, cards1);
			cardView1.setAdapter(adapter1);
			cards2 = new ArrayList<Card>();
			for(int i=0;i<listData2.size();i++)
			{ 
				Listcard2 = new CustomCardAddExercise(context, listData2,i,workout_name,workout_id,2,no_of_days, listDesc2, listImg2,listId2);
				cards2.add(Listcard2);	
				Listcard2.setSwipeable(true);
			}
			adapter2 = new CardArrayAdapter(context, cards2);
			cardView2.setAdapter(adapter2);
			cards3 = new ArrayList<Card>();
			for(int i=0;i<listData3.size();i++)
			{ 
				Listcard3 = new CustomCardAddExercise(context, listData3,i,workout_name,workout_id,3,no_of_days, listDesc3, listImg3,listId3);
				cards3.add(Listcard3);	
				Listcard3.setSwipeable(true);
			}
			adapter3 = new CardArrayAdapter(context, cards3);
			cardView3.setAdapter(adapter3);
			break;
		case 4:
			day1.setVisibility(Button.VISIBLE);
			day2.setVisibility(Button.VISIBLE);
			day3.setVisibility(Button.VISIBLE);
			day4.setVisibility(Button.VISIBLE);
			cards1 = new ArrayList<Card>();
			for(int i=0;i<listData1.size();i++)
			{ 
				Listcard1 = new CustomCardAddExercise(context, listData1,i,workout_name,workout_id,1,no_of_days, listDesc1, listImg1,listId1);
				cards1.add(Listcard1);		
				Listcard1.setSwipeable(true);
			}
			adapter1 = new CardArrayAdapter(context, cards1);
			cardView1.setAdapter(adapter1);
			cards2 = new ArrayList<Card>();
			for(int i=0;i<listData2.size();i++)
			{ 
				Listcard2 = new CustomCardAddExercise(context, listData2,i,workout_name,workout_id,2,no_of_days, listDesc2, listImg2,listId2);
				cards2.add(Listcard2);	
				Listcard2.setSwipeable(true);
			}
			adapter2 = new CardArrayAdapter(context, cards2);
			cardView2.setAdapter(adapter2);
			cards3 = new ArrayList<Card>();
			for(int i=0;i<listData3.size();i++)
			{ 
				Listcard3 = new CustomCardAddExercise(context, listData3,i,workout_name,workout_id,3,no_of_days, listDesc3, listImg3,listId3);
				cards3.add(Listcard3);	
				Listcard3.setSwipeable(true);
			}
			adapter3 = new CardArrayAdapter(context, cards3);
			cardView3.setAdapter(adapter3);
			cards4 = new ArrayList<Card>();
			for(int i=0;i<listData4.size();i++)
			{ 
				Listcard4 = new CustomCardAddExercise(context, listData4,i,workout_name,workout_id,4,no_of_days, listDesc4, listImg4,listId4);
				cards4.add(Listcard4);			
				Listcard4.setSwipeable(true);
			}
			adapter4 = new CardArrayAdapter(context, cards4);
			cardView4.setAdapter(adapter4);
			break;
		case 5:
			day1.setVisibility(Button.VISIBLE);
			day2.setVisibility(Button.VISIBLE);
			day3.setVisibility(Button.VISIBLE);
			day4.setVisibility(Button.VISIBLE);
			day5.setVisibility(Button.VISIBLE);
			cards1 = new ArrayList<Card>();
			for(int i=0;i<listData1.size();i++)
			{ 
				Listcard1 = new CustomCardAddExercise(context, listData1,i,workout_name,workout_id,1,no_of_days, listDesc1, listImg1,listId1);
				cards1.add(Listcard1);	
				Listcard1.setSwipeable(true);
			}
			adapter1 = new CardArrayAdapter(context, cards1);
			cardView1.setAdapter(adapter1);
			cards2 = new ArrayList<Card>();
			for(int i=0;i<listData2.size();i++)
			{ 
				Listcard2 = new CustomCardAddExercise(context, listData2,i,workout_name,workout_id,2,no_of_days, listDesc2, listImg2,listId2);
				cards2.add(Listcard2);	
				Listcard2.setSwipeable(true);
			}
			adapter2 = new CardArrayAdapter(context, cards2);
			cardView2.setAdapter(adapter2);
			cards3 = new ArrayList<Card>();
			for(int i=0;i<listData3.size();i++)
			{ 
				Listcard3 = new CustomCardAddExercise(context, listData3,i,workout_name,workout_id,3,no_of_days, listDesc3, listImg3,listId3);
				cards3.add(Listcard3);	
				Listcard3.setSwipeable(true);
			}
			adapter3 = new CardArrayAdapter(context, cards3);
			cardView3.setAdapter(adapter3);
			cards4 = new ArrayList<Card>();
			for(int i=0;i<listData4.size();i++)
			{ 
				Listcard4 = new CustomCardAddExercise(context, listData4,i,workout_name,workout_id,4,no_of_days, listDesc4, listImg4,listId4);
				cards4.add(Listcard4);			
				Listcard4.setSwipeable(true);
			}
			adapter4 = new CardArrayAdapter(context, cards4);
			cardView4.setAdapter(adapter4);
			cards5 = new ArrayList<Card>();
			for(int i=0;i<listData5.size();i++)
			{ 
				Listcard5 = new CustomCardAddExercise(context, listData5,i,workout_name,workout_id,5,no_of_days, listDesc5, listImg5,listId5);
				cards5.add(Listcard5);	
				Listcard5.setSwipeable(true);
			}
			adapter5 = new CardArrayAdapter(context, cards5);
			cardView5.setAdapter(adapter5);
			break;
		case 6:
			day1.setVisibility(Button.VISIBLE);
			day2.setVisibility(Button.VISIBLE);
			day3.setVisibility(Button.VISIBLE);
			day4.setVisibility(Button.VISIBLE);
			day5.setVisibility(Button.VISIBLE);
			day6.setVisibility(Button.VISIBLE);
			cards1 = new ArrayList<Card>();
			for(int i=0;i<listData1.size();i++)
			{ 
				Listcard1 = new CustomCardAddExercise(context, listData1,i,workout_name,workout_id,1,no_of_days, listDesc1, listImg1,listId1);
				cards1.add(Listcard1);	
				Listcard1.setSwipeable(true);
			}
			adapter1 = new CardArrayAdapter(context, cards1);
			cardView1.setAdapter(adapter1);
			cards2 = new ArrayList<Card>();
			for(int i=0;i<listData2.size();i++)
			{ 
				Listcard2 = new CustomCardAddExercise(context, listData2,i,workout_name,workout_id,2,no_of_days, listDesc2, listImg2,listId2);
				cards2.add(Listcard2);		
				Listcard2.setSwipeable(true);
			}
			adapter2 = new CardArrayAdapter(context, cards2);
			cardView2.setAdapter(adapter2);
			cards3 = new ArrayList<Card>();
			for(int i=0;i<listData3.size();i++)
			{ 
				Listcard3 = new CustomCardAddExercise(context, listData3,i,workout_name,workout_id,3,no_of_days, listDesc3, listImg3,listId3);
				cards3.add(Listcard3);	
				Listcard3.setSwipeable(true);
			}
			adapter3 = new CardArrayAdapter(context, cards3);
			cardView3.setAdapter(adapter3);
			cards4 = new ArrayList<Card>();
			for(int i=0;i<listData4.size();i++)
			{ 
				Listcard4 = new CustomCardAddExercise(context, listData4,i,workout_name,workout_id,4,no_of_days, listDesc4, listImg4,listId4);
				cards4.add(Listcard4);	
				Listcard4.setSwipeable(true);
			}
			adapter4 = new CardArrayAdapter(context, cards4);
			cardView4.setAdapter(adapter4);
			cards5 = new ArrayList<Card>();
			for(int i=0;i<listData5.size();i++)
			{ 
				Listcard5 = new CustomCardAddExercise(context, listData5,i,workout_name,workout_id,5,no_of_days, listDesc5, listImg5,listId5);
				cards5.add(Listcard5);	
				Listcard5.setSwipeable(true);
			}
			adapter5 = new CardArrayAdapter(context, cards5);
			cardView5.setAdapter(adapter5);
			cards6 = new ArrayList<Card>();
			for(int i=0;i<listData6.size();i++)
			{ 
				Listcard6 = new CustomCardAddExercise(context, listData6,i,workout_name,workout_id,6,no_of_days, listDesc6, listImg6,listId6);
				cards6.add(Listcard6);		
				Listcard6.setSwipeable(true);
			}
			adapter6 = new CardArrayAdapter(context, cards6);
			cardView6.setAdapter(adapter6);
			break;
		case 7:
			day1.setVisibility(Button.VISIBLE);
			day2.setVisibility(Button.VISIBLE);
			day3.setVisibility(Button.VISIBLE);
			day4.setVisibility(Button.VISIBLE);
			day5.setVisibility(Button.VISIBLE);
			day6.setVisibility(Button.VISIBLE);
			day7.setVisibility(Button.VISIBLE);
			cards1 = new ArrayList<Card>();
			for(int i=0;i<listData1.size();i++)
			{ 
				Listcard1 = new CustomCardAddExercise(context, listData1,i,workout_name,workout_id,1,no_of_days, listDesc1, listImg1,listId1);
				cards1.add(Listcard1);	
				Listcard1.setSwipeable(true);
			}
			adapter1 = new CardArrayAdapter(context, cards1);
			cardView1.setAdapter(adapter1);
			cards2 = new ArrayList<Card>();
			for(int i=0;i<listData2.size();i++)
			{ 
				Listcard2 = new CustomCardAddExercise(context, listData2,i,workout_name,workout_id,2,no_of_days, listDesc2, listImg2,listId2);
				cards2.add(Listcard2);	
				Listcard2.setSwipeable(true);
			}
			adapter2 = new CardArrayAdapter(context, cards2);
			cardView2.setAdapter(adapter2);
			cards3 = new ArrayList<Card>();
			for(int i=0;i<listData3.size();i++)
			{ 
				Listcard3 = new CustomCardAddExercise(context, listData3,i,workout_name,workout_id,3,no_of_days, listDesc3, listImg3,listId3);
				cards3.add(Listcard3);	
				Listcard3.setSwipeable(true);
			}
			adapter3 = new CardArrayAdapter(context, cards3);
			cardView3.setAdapter(adapter3);
			cards4 = new ArrayList<Card>();
			for(int i=0;i<listData4.size();i++)
			{ 
				Listcard4 = new CustomCardAddExercise(context, listData4,i,workout_name,workout_id,4,no_of_days, listDesc4, listImg4,listId4);
				cards4.add(Listcard4);	
				Listcard4.setSwipeable(true);
			}
			adapter4 = new CardArrayAdapter(context, cards4);
			cardView4.setAdapter(adapter4);
			cards5 = new ArrayList<Card>();
			for(int i=0;i<listData5.size();i++)
			{ 
				Listcard5 = new CustomCardAddExercise(context, listData5,i,workout_name,workout_id,5,no_of_days, listDesc5, listImg5,listId5);
				cards5.add(Listcard5);	
				Listcard5.setSwipeable(true);
			}
			adapter5 = new CardArrayAdapter(context, cards5);
			cardView5.setAdapter(adapter5);
			cards6 = new ArrayList<Card>();
			for(int i=0;i<listData6.size();i++)
			{ 
				Listcard6 = new CustomCardAddExercise(context, listData6,i,workout_name,workout_id,6,no_of_days, listDesc6, listImg6,listId6);
				cards6.add(Listcard6);	
				Listcard6.setSwipeable(true);
			}
			adapter6 = new CardArrayAdapter(context, cards6);
			cardView6.setAdapter(adapter6);
			cards7 = new ArrayList<Card>();
			for(int i=0;i<listData7.size();i++)
			{ 
				Listcard7 = new CustomCardAddExercise(context, listData7,i,workout_name,workout_id,7,no_of_days, listDesc7, listImg7,listId7);
				cards7.add(Listcard7);	
				Listcard7.setSwipeable(true);
			}
			adapter7 = new CardArrayAdapter(context, cards7);
			cardView7.setAdapter(adapter7);

			break;
		default:
		}
		
		day1.setBackgroundResource(R.drawable.button_selected);
		day2.setBackgroundResource(R.drawable.button_selector);
		day3.setBackgroundResource(R.drawable.button_selector);
		day4.setBackgroundResource(R.drawable.button_selector);
		day5.setBackgroundResource(R.drawable.button_selector);
		day6.setBackgroundResource(R.drawable.button_selector);
		day7.setBackgroundResource(R.drawable.button_selector);

		day1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				day1.setBackgroundResource(R.drawable.button_selected);
				day2.setBackgroundResource(R.drawable.button_selector);
				day3.setBackgroundResource(R.drawable.button_selector);
				day4.setBackgroundResource(R.drawable.button_selector);
				day5.setBackgroundResource(R.drawable.button_selector);
				day6.setBackgroundResource(R.drawable.button_selector);
				day7.setBackgroundResource(R.drawable.button_selector);
				cardView1.setVisibility(CardListView.VISIBLE);
				cardView2.setVisibility(CardListView.INVISIBLE);
				cardView3.setVisibility(CardListView.INVISIBLE);
				cardView4.setVisibility(CardListView.INVISIBLE);
				cardView5.setVisibility(CardListView.INVISIBLE);
				cardView6.setVisibility(CardListView.INVISIBLE);
				cardView7.setVisibility(CardListView.INVISIBLE);

			}
		});
		day2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				day1.setBackgroundResource(R.drawable.button_selector);
				day2.setBackgroundResource(R.drawable.button_selected);
				day3.setBackgroundResource(R.drawable.button_selector);
				day4.setBackgroundResource(R.drawable.button_selector);
				day5.setBackgroundResource(R.drawable.button_selector);
				day6.setBackgroundResource(R.drawable.button_selector);
				day7.setBackgroundResource(R.drawable.button_selector);
				cardView1.setVisibility(CardListView.INVISIBLE);
				cardView2.setVisibility(CardListView.VISIBLE);
				cardView3.setVisibility(CardListView.INVISIBLE);
				cardView4.setVisibility(CardListView.INVISIBLE);
				cardView5.setVisibility(CardListView.INVISIBLE);
				cardView6.setVisibility(CardListView.INVISIBLE);
				cardView7.setVisibility(CardListView.INVISIBLE);

			}
		});

		day3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				day1.setBackgroundResource(R.drawable.button_selector);
				day2.setBackgroundResource(R.drawable.button_selector);
				day3.setBackgroundResource(R.drawable.button_selected);
				day4.setBackgroundResource(R.drawable.button_selector);
				day5.setBackgroundResource(R.drawable.button_selector);
				day6.setBackgroundResource(R.drawable.button_selector);
				day7.setBackgroundResource(R.drawable.button_selector);
				cardView1.setVisibility(CardListView.INVISIBLE);
				cardView2.setVisibility(CardListView.INVISIBLE);
				cardView3.setVisibility(CardListView.VISIBLE);
				cardView4.setVisibility(CardListView.INVISIBLE);
				cardView5.setVisibility(CardListView.INVISIBLE);
				cardView6.setVisibility(CardListView.INVISIBLE);
				cardView7.setVisibility(CardListView.INVISIBLE);

			}
		});

		day4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				day1.setBackgroundResource(R.drawable.button_selector);
				day2.setBackgroundResource(R.drawable.button_selector);
				day3.setBackgroundResource(R.drawable.button_selector);
				day4.setBackgroundResource(R.drawable.button_selected);
				day5.setBackgroundResource(R.drawable.button_selector);
				day6.setBackgroundResource(R.drawable.button_selector);
				day7.setBackgroundResource(R.drawable.button_selector);
				cardView1.setVisibility(CardListView.INVISIBLE);
				cardView2.setVisibility(CardListView.INVISIBLE);
				cardView3.setVisibility(CardListView.INVISIBLE);
				cardView4.setVisibility(CardListView.VISIBLE);
				cardView5.setVisibility(CardListView.INVISIBLE);
				cardView6.setVisibility(CardListView.INVISIBLE);
				cardView7.setVisibility(CardListView.INVISIBLE);
			}
		});

		day5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				day1.setBackgroundResource(R.drawable.button_selector);
				day2.setBackgroundResource(R.drawable.button_selector);
				day3.setBackgroundResource(R.drawable.button_selector);
				day4.setBackgroundResource(R.drawable.button_selector);
				day5.setBackgroundResource(R.drawable.button_selected);
				day6.setBackgroundResource(R.drawable.button_selector);
				day7.setBackgroundResource(R.drawable.button_selector);
				cardView1.setVisibility(CardListView.INVISIBLE);
				cardView2.setVisibility(CardListView.INVISIBLE);
				cardView3.setVisibility(CardListView.INVISIBLE);
				cardView4.setVisibility(CardListView.INVISIBLE);
				cardView5.setVisibility(CardListView.VISIBLE);
				cardView6.setVisibility(CardListView.INVISIBLE);
				cardView7.setVisibility(CardListView.INVISIBLE);

			}
		});

		day6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				day1.setBackgroundResource(R.drawable.button_selector);
				day2.setBackgroundResource(R.drawable.button_selector);
				day3.setBackgroundResource(R.drawable.button_selector);
				day4.setBackgroundResource(R.drawable.button_selector);
				day5.setBackgroundResource(R.drawable.button_selector);
				day6.setBackgroundResource(R.drawable.button_selected);
				day7.setBackgroundResource(R.drawable.button_selector);
				cardView1.setVisibility(CardListView.INVISIBLE);
				cardView2.setVisibility(CardListView.INVISIBLE);
				cardView3.setVisibility(CardListView.INVISIBLE);
				cardView4.setVisibility(CardListView.INVISIBLE);
				cardView5.setVisibility(CardListView.INVISIBLE);
				cardView6.setVisibility(CardListView.VISIBLE);
				cardView7.setVisibility(CardListView.INVISIBLE);
			}
		});

		day7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				day1.setBackgroundResource(R.drawable.button_selector);
				day2.setBackgroundResource(R.drawable.button_selector);
				day3.setBackgroundResource(R.drawable.button_selector);
				day4.setBackgroundResource(R.drawable.button_selector);
				day5.setBackgroundResource(R.drawable.button_selector);
				day6.setBackgroundResource(R.drawable.button_selector);
				day7.setBackgroundResource(R.drawable.button_selected);
				cardView1.setVisibility(CardListView.INVISIBLE);
				cardView2.setVisibility(CardListView.INVISIBLE);
				cardView3.setVisibility(CardListView.INVISIBLE);
				cardView4.setVisibility(CardListView.INVISIBLE);
				cardView5.setVisibility(CardListView.INVISIBLE);
				cardView6.setVisibility(CardListView.INVISIBLE);
				cardView7.setVisibility(CardListView.VISIBLE);
			}
		});

	}
	@Override
	public void onBackPressed() {
		Log.d("CDA", "onBackPressed Called");
		Intent mainIntent = new Intent(context,CreateWorkoutActivity.class);
		/*SharedPreferences sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
		Editor editor = sharedpreferences.edit();
		editor.putInt("check_back_total", 1);
		editor.commit();*/
		mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
		this.startActivity(mainIntent);
		this.finish();
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
	private CharSequence wrapInSpan(CharSequence value) {
		SpannableStringBuilder sb = new SpannableStringBuilder(value);
		sb.setSpan(new TypefaceSpan(context,"Roboto-Medium.ttf"), 0, value.length(), 0);
		return sb;
	}
	
}