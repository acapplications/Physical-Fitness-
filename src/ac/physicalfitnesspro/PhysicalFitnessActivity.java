
package ac.physicalfitnesspro;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;

import java.util.ArrayList;

import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.adapters.CustomCardMainPageOne1;
import ac.physicalfitnesspro.adapters.CustomCardMainPageTwoAbdomen;
import ac.physicalfitnesspro.adapters.CustomCardMainPageTwoBack;
import ac.physicalfitnesspro.adapters.CustomCardMainPageTwoBiceps;
import ac.physicalfitnesspro.adapters.CustomCardMainPageTwoButtocks;
import ac.physicalfitnesspro.adapters.CustomCardMainPageTwoChest;
import ac.physicalfitnesspro.adapters.CustomCardMainPageTwoForearm;
import ac.physicalfitnesspro.adapters.CustomCardMainPageTwoLegs;
import ac.physicalfitnesspro.adapters.CustomCardMainPageTwoShoulders;
import ac.physicalfitnesspro.adapters.CustomCardMainPageTwoTriceps;
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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class PhysicalFitnessActivity extends Activity{
	Context context;
	ListView schedule;
	ActionBar actionBar;

	CardArrayAdapter adapter_back,adapter_biceps,adapter_buttocks,adapter_chest,adapter_forearm,adapter_legs,adapter_shoulders,adapter_triceps,adapter_abdomen;

	CustomCardMainPageOne1 card_one1, card_one6, card_one7, card_one5, card_one4, card_one3, card_one9, card_one8, card_one2;

	CustomCardMainPageTwoAbdomen card_abdomen;
	CustomCardMainPageTwoBack card_back;
	CustomCardMainPageTwoBiceps card_biceps;
	CustomCardMainPageTwoButtocks card_buttocks;
	CustomCardMainPageTwoChest card_chest;
	CustomCardMainPageTwoForearm card_forearm;
	CustomCardMainPageTwoShoulders card_shoulders;
	CustomCardMainPageTwoLegs card_legs;
	CustomCardMainPageTwoTriceps card_triceps;

	CardListView cardView_back,	cardView_biceps, cardView_chest,	cardView_shoulders,	cardView_legs, cardView_buttocks, cardView_triceps, cardView_forearm, cardView_abdomen;

	ArrayList<Card> cardslist_abdomen, cardslist_back,cardslist_,cardslist_shoulders,cardslist_triceps,cardslist_biceps,cardslist_buttocks,cardslist_legs,cardslist_chest,cardslist_forearm;

	String[] main= new String[]{"Back","Biceps","Buttocks","Chest","Forearm","Legs","Shoulders","Triceps","Abdomen"};
	int[] main_img=new int[]{R.drawable.back,R.drawable.biceps,R.drawable.buttocks,R.drawable.chest,R.drawable.forearm,R.drawable.legs,R.drawable.shoulders,R.drawable.triceps,R.drawable.abdomen,};
	String[] abdomen_list=new String[]{"Broom Stick Twist","Calves Over Bench Sit-ups", "Crunches", "Dumbbell Side Bends", "Gym Ladder Sit-up", "Hanging Leg Raises", "High Pulley Crunches", "Incline Bench Sit-ups", "Incline Leg Raises", "Leg Raises", "Machine Crunches", "Machine Trunk Rotations", "Roman Chair Side Bends", "Sit-ups"};

	int[] abdomen_img=new int[]{R.drawable.broomsticktwist,R.drawable.calvesoverbenchsitups,R.drawable.crunch,R.drawable.dumbbellsidebend,R.drawable.gymladdersitup,R.drawable.hanginglegraise,R.drawable.highpulleycrunches,R.drawable.inclinebenchsitups,R.drawable.inclinelegraises,
			R.drawable.legraises,R.drawable.machinecrunches,R.drawable.machinetrunkrotation,R.drawable.romanchairsidebends,R.drawable.situps};

	String[] back_list= new String[]{"Back Extensions", "Back Lat Pull Down", "Barbell Shrugs", "Bent Rows", "Chin-ups", "Close Grip Lat Pull Down", "Deadlift", "Dumbbell Shrugs", "Lat Pull Down", "One Arm Dumbbell Row", "Reverse Chin-ups", "Seated Rows", "Stiff Legged Deadlift", "Straight Arm Pull Down", "Sumo Deadlift", "T-bar Rows", "Upright Rows"};

	int[] back_img=new int[]{R.drawable.backextensions,R.drawable.backlatpulldown,R.drawable.barbellshrugs,R.drawable.bentrow,R.drawable.chinups,R.drawable.closegriplatpulldown,R.drawable.deadlift,R.drawable.dumbbellshrug,R.drawable.latpulldown,R.drawable.onearmdumbbellrow,
			R.drawable.reversechinups,R.drawable.seatedrows,R.drawable.stiffleggeddeadlift,R.drawable.straightarmpulldown,R.drawable.sumodeadlift,R.drawable.tbarrows,R.drawable.uprightrow};

	String[] biceps_list= new String[]{"Barbell Curl", "Concentration Curl", "Curl Biceps", "Hammer Curls", "High Pulley Curls", "Low Pulley Curls", "Machine Curls", "Reverse Curls"};

	int[] biceps_img=new int[]{R.drawable.barbellcurle,R.drawable.concentrationcurl,R.drawable.curlbiceps,R.drawable.hammercurls,R.drawable.highpulleycurl,R.drawable.lowpuleycurl,R.drawable.machinecurl,R.drawable.reversecurls};

	String[] buttocks_list= new String[]{"Bridging", "Cable Back Kick", "Cable Hip Adductions", "Floor Hip Adductions", "Floor Hip Extensions", "Lunges", "Machine Hip Extensions", "Seated Machine Hip Adductions", "Standing Machine Hip Adductions"};

	int[] buttocks_img=new int[]{R.drawable.bridging,R.drawable.ablebakkiks,R.drawable.cablebackkick,R.drawable.cablehipabductions,R.drawable.floorhipabductions,R.drawable.floorhipextensions,R.drawable.lunges,R.drawable.machinehipextensions,R.drawable.seatedmachinehipabductions,R.drawable.standingmachinehipabductions};

	String[] chest_list= new String[]{"Bench press", "Close grip bench press", "Incline press", "Decline press", "Pushup", "Parralel bar dips", "Dumbbell press", "Incline dumbbell flys", "Dumbbell flys", "Incline dumbbell press", "Pec dec flys", "Cable Crossover Flys", "Dumbbell Pullover", "Barbell Pullover"};

	int[] chest_img=new int[]{R.drawable.benchpress,R.drawable.closegripbenchpress,R.drawable.inclinepress,R.drawable.declinepress,R.drawable.pushup,R.drawable.parralelbardips,R.drawable.dumbbellpress,R.drawable.inclinedumbbellflys,R.drawable.dumbbellflys,R.drawable.inclinedumbbellpress,R.drawable.pecdecflys,R.drawable.cablecrossoverflys,R.drawable.dumbbellpullover,R.drawable.barbellpullover};

	String[] forearm_list= new String[]{"Wrist curls", "Reverse wrist curls"};
	int[] forearm_img=new int[]{R.drawable.wristcurls,R.drawable.reversewristcurl};

	String[] legs_list= new String[]{"Angled leg press", "Cable adduction", "Donkey calf raises", "Dumbbell squats", "Front squat", "Good morning", "Hack squat", "Leg extensions", "Lying leg curls","Machine adductions", "One leg toe raises", "Power squats", "Seated barbell calf raises", "Seated calf raises", "Seated leg curl", "Squat", "Standing calf raises", "Standing leg curl"};

	int[] legs_img= new int[]{R.drawable.angledlegpress,R.drawable.cableadduction,R.drawable.donkeycalfraises,R.drawable.dumbbellsquats,R.drawable.frontsquat,R.drawable.goodmorning,R.drawable.hacksquat,R.drawable.legextensions,R.drawable.lyinglegcurl,R.drawable.machineadductions,R.drawable.onelegtoeraises,R.drawable.powersquats,R.drawable.seatedbarbellcalfraises,R.drawable.seatedcalfraise,R.drawable.seatedlegcurl,R.drawable.squat,R.drawable.standingcalfraises,R.drawable.standinglegcurl};

	String[] shoulders_list= new String[]{"Back press", "Barbell front raises", "Barbell upright row", "Bent over lateral raises", "Dumbbell press", "Front press", "Front raises", "Lateral raises", "Low pulley bent over lateral raises", "Low pulley lateral raises", "one arm dumbbell press", "One dumbbell front raises", "Side lying lateral raises"};
	int[] shoulders_img=new int[]{R.drawable.backpress,R.drawable.barbellfrontraise,R.drawable.barbelluprightrow,R.drawable.bentoverlateralraise,R.drawable.dubbellpress,R.drawable.frontpress1,R.drawable.frontraises,R.drawable.lateralraise,R.drawable.lowpulleybentoerlateralraises,R.drawable.lowpulleylateralraises,R.drawable.oneardubbellpress,R.drawable.onedubbellfrontraises,R.drawable.sidelyinglateralraises};

	String[] triceps_list= new String[]{"Dumbbell tricep extension", "One arm dumbbell triceps extensions", "One arm reverse pushdowns", "Pushdown", "Reverse pushdowns", "Seated dumbbell triceps extensions", "Seated e-z bar triceps extensions", "Tricep kick back", "Triceps dips", "Triceps extension"};
	int[] triceps_img=new int[]{R.drawable.dumbbelltricepextension,R.drawable.onearmdumbbelltricepsextensions,R.drawable.onearmreversepushdowns,R.drawable.pushdown,R.drawable.reversepushdowns,R.drawable.seateddumbbelltricepsextensions,R.drawable.seatedezbartricepsextensions,R.drawable.tricepkickbackt,R.drawable.tricepsdips,R.drawable.tricepsextension};

	String workout_name="";
	int no_of_days=0;
	int add_button_check=0;
	int workout_id=0;
	int total_days=0;
	SharedPreferences sharedPreferences;
	Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.physicalfitness_fragment);

		context=getApplicationContext();

		sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
		add_button_check=sharedPreferences.getInt("add_button", 0);

		SpannableString s = new SpannableString("PHYSICAL FITNESS");
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		//Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/Roboto-Medium.ttf");
		actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D75BD")));
		actionBar.setTitle(s);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			workout_name= bundle.getString("workout_name");
			no_of_days= bundle.getInt("day");
			workout_id= bundle.getInt("workout_id");
			total_days=bundle.getInt("total_days");
		}

		cardslist_back= new ArrayList<Card>();
		cardslist_abdomen= new ArrayList<Card>();
		cardslist_shoulders= new ArrayList<Card>();
		cardslist_triceps= new ArrayList<Card>();
		cardslist_biceps= new ArrayList<Card>();
		cardslist_buttocks= new ArrayList<Card>();
		cardslist_legs= new ArrayList<Card>();
		cardslist_chest= new ArrayList<Card>();
		cardslist_forearm = new ArrayList<Card>();

		card_one1 = new CustomCardMainPageOne1(context, main[0],main_img[0]);
		card_one2 = new CustomCardMainPageOne1(context, main[1],main_img[1]);
		card_one3 = new CustomCardMainPageOne1(context, main[2],main_img[2]);
		card_one4 = new CustomCardMainPageOne1(context, main[3],main_img[3]);
		card_one5 = new CustomCardMainPageOne1(context, main[4],main_img[4]);
		card_one6 = new CustomCardMainPageOne1(context, main[5],main_img[5]);
		card_one7 = new CustomCardMainPageOne1(context, main[6],main_img[6]);
		card_one8 = new CustomCardMainPageOne1(context, main[7],main_img[7]);
		card_one9 = new CustomCardMainPageOne1(context, main[8],main_img[8]);
		//card_one.setShadow(true);


		CardView c1=(CardView)findViewById(R.id.card_1);
		c1.setCard(card_one1);

		CardView c2=(CardView)findViewById(R.id.card_2);
		c2.setCard(card_one2);

		CardView c4=(CardView)findViewById(R.id.card_4);
		c4.setCard(card_one4);

		CardView c3=(CardView)findViewById(R.id.card_3);
		c3.setCard(card_one3);

		CardView c6=(CardView)findViewById(R.id.card_6);
		c6.setCard(card_one6);


		CardView c5=(CardView)findViewById(R.id.card_5);
		c5.setCard(card_one5);

		CardView c7=(CardView)findViewById(R.id.card_7);
		c7.setCard(card_one7);

		CardView c8=(CardView)findViewById(R.id.card_8);
		c8.setCard(card_one8);

		CardView c9=(CardView)findViewById(R.id.card_9);
		c9.setCard(card_one9);

		for(int j=0;j<abdomen_list.length;j++)
		{ 
			card_abdomen = new CustomCardMainPageTwoAbdomen(context, abdomen_list,abdomen_img, j,workout_name, no_of_days, workout_id, total_days);
			card_abdomen.setShadow(true);
			cardslist_abdomen.add(card_abdomen);			
		}
		for(int j=0;j<back_list.length;j++)
		{ 
			card_back = new CustomCardMainPageTwoBack(context, back_list,back_img, j,workout_name, no_of_days, workout_id, total_days);
			card_back.setShadow(true);
			cardslist_back.add(card_back);			
		}
		for(int j=0;j<buttocks_list.length;j++)
		{ 
			card_buttocks = new CustomCardMainPageTwoButtocks(context, buttocks_list,buttocks_img, j,workout_name, no_of_days, workout_id, total_days);
			card_buttocks.setShadow(true);
			cardslist_buttocks.add(card_buttocks);			
		}
		for(int j=0;j<shoulders_list.length;j++)
		{ 
			card_shoulders = new CustomCardMainPageTwoShoulders(context, shoulders_list,shoulders_img, j,workout_name, no_of_days, workout_id, total_days);
			card_shoulders.setShadow(true);
			cardslist_shoulders.add(card_shoulders);			
		}
		for(int j=0;j<triceps_list.length;j++)
		{ 
			card_triceps = new CustomCardMainPageTwoTriceps(context, triceps_list,triceps_img, j,workout_name, no_of_days, workout_id, total_days);
			card_triceps.setShadow(true);
			cardslist_triceps.add(card_triceps);			
		}
		for(int j=0;j<biceps_list.length;j++)
		{ 
			card_biceps = new CustomCardMainPageTwoBiceps(context, biceps_list,biceps_img, j,workout_name, no_of_days, workout_id, total_days);
			card_biceps.setShadow(true);
			cardslist_biceps.add(card_biceps);			
		}
		for(int j=0;j<forearm_list.length;j++)
		{ 
			card_forearm = new CustomCardMainPageTwoForearm(context, forearm_list,forearm_img, j,workout_name, no_of_days, workout_id, total_days);
			card_forearm.setShadow(true);
			cardslist_forearm.add(card_forearm);			
		}
		for(int j=0;j<legs_list.length;j++)
		{ 
			card_legs = new CustomCardMainPageTwoLegs(context, legs_list,legs_img, j,workout_name, no_of_days, workout_id, total_days);
			card_legs.setShadow(true);
			cardslist_legs.add(card_legs);			
		}
		for(int j=0;j<chest_list.length;j++)
		{ 
			card_chest = new CustomCardMainPageTwoChest(context, chest_list, chest_img,j , workout_name, no_of_days, workout_id, total_days);
			card_chest.setShadow(true);
			cardslist_chest.add(card_chest);			
		}



		cardView_back = (CardListView) findViewById(R.id.card_back);
		cardView_chest= (CardListView) findViewById(R.id.card_chest);	
		cardView_shoulders = (CardListView)findViewById(R.id.card_shoulders);	

		cardView_legs = (CardListView)findViewById(R.id.card_legs);	

		cardView_buttocks = (CardListView)findViewById(R.id.card_buttocks);	

		cardView_triceps = (CardListView)findViewById(R.id.card_triceps);	

		cardView_biceps = (CardListView)findViewById(R.id.card_biceps);	

		cardView_forearm = (CardListView)findViewById(R.id.card_forearm);	

		cardView_abdomen = (CardListView) findViewById(R.id.card_abdomen);	

		adapter_back= new CardArrayAdapter(context, cardslist_back);
		cardView_back.setAdapter(adapter_back);
		adapter_biceps= new CardArrayAdapter(context, cardslist_biceps);
		cardView_biceps.setAdapter(adapter_biceps);
		adapter_buttocks= new CardArrayAdapter(context, cardslist_buttocks);
		cardView_buttocks.setAdapter(adapter_buttocks);
		adapter_chest= new CardArrayAdapter(context, cardslist_chest);
		cardView_chest.setAdapter(adapter_chest);
		adapter_forearm= new CardArrayAdapter(context, cardslist_forearm);
		cardView_forearm.setAdapter(adapter_forearm);
		adapter_legs= new CardArrayAdapter(context, cardslist_legs);
		cardView_legs.setAdapter(adapter_legs);
		adapter_shoulders= new CardArrayAdapter(context, cardslist_shoulders);
		cardView_shoulders.setAdapter(adapter_shoulders);
		adapter_triceps= new CardArrayAdapter(context, cardslist_triceps);
		cardView_triceps.setAdapter(adapter_triceps);
		adapter_abdomen= new CardArrayAdapter(context, cardslist_abdomen);
		cardView_abdomen.setAdapter(adapter_abdomen);

		c1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cardView_back.setVisibility(CardListView.VISIBLE);	
				cardView_biceps.setVisibility(CardListView.INVISIBLE); 
				cardView_chest.setVisibility(CardListView.INVISIBLE);
				cardView_shoulders.setVisibility(CardListView.INVISIBLE);
				cardView_legs.setVisibility(CardListView.INVISIBLE);
				cardView_buttocks.setVisibility(CardListView.INVISIBLE);
				cardView_triceps.setVisibility(CardListView.INVISIBLE);
				cardView_forearm.setVisibility(CardListView.INVISIBLE);
				cardView_abdomen.setVisibility(CardListView.INVISIBLE);
			}
		});
		c2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cardView_biceps.setVisibility(CardListView.VISIBLE);
				cardView_back.setVisibility(CardListView.INVISIBLE);	
				cardView_chest.setVisibility(CardListView.INVISIBLE);
				cardView_shoulders.setVisibility(CardListView.INVISIBLE);
				cardView_legs.setVisibility(CardListView.INVISIBLE);
				cardView_buttocks.setVisibility(CardListView.INVISIBLE);
				cardView_triceps.setVisibility(CardListView.INVISIBLE);
				cardView_forearm.setVisibility(CardListView.INVISIBLE);
				cardView_abdomen.setVisibility(CardListView.INVISIBLE);
			}
		});
		c3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cardView_buttocks.setVisibility(CardListView.VISIBLE);
				cardView_back.setVisibility(CardListView.INVISIBLE);	
				cardView_biceps.setVisibility(CardListView.INVISIBLE); 
				cardView_chest.setVisibility(CardListView.INVISIBLE);
				cardView_shoulders.setVisibility(CardListView.INVISIBLE);
				cardView_legs.setVisibility(CardListView.INVISIBLE);
				cardView_triceps.setVisibility(CardListView.INVISIBLE);
				cardView_forearm.setVisibility(CardListView.INVISIBLE);
				cardView_abdomen.setVisibility(CardListView.INVISIBLE);
			}
		});
		c4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cardView_chest.setVisibility(CardListView.VISIBLE);
				cardView_back.setVisibility(CardListView.INVISIBLE);	
				cardView_biceps.setVisibility(CardListView.INVISIBLE); 
				cardView_shoulders.setVisibility(CardListView.INVISIBLE);
				cardView_legs.setVisibility(CardListView.INVISIBLE);
				cardView_buttocks.setVisibility(CardListView.INVISIBLE);
				cardView_triceps.setVisibility(CardListView.INVISIBLE);
				cardView_forearm.setVisibility(CardListView.INVISIBLE);
				cardView_abdomen.setVisibility(CardListView.INVISIBLE);
			}
		});
		c5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cardView_forearm.setVisibility(CardListView.VISIBLE);
				cardView_back.setVisibility(CardListView.INVISIBLE);	
				cardView_biceps.setVisibility(CardListView.INVISIBLE); 
				cardView_chest.setVisibility(CardListView.INVISIBLE);
				cardView_shoulders.setVisibility(CardListView.INVISIBLE);
				cardView_legs.setVisibility(CardListView.INVISIBLE);
				cardView_buttocks.setVisibility(CardListView.INVISIBLE);
				cardView_triceps.setVisibility(CardListView.INVISIBLE);
				cardView_abdomen.setVisibility(CardListView.INVISIBLE);
			}
		});
		c6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cardView_legs.setVisibility(CardListView.VISIBLE);	
				cardView_back.setVisibility(CardListView.INVISIBLE);	
				cardView_biceps.setVisibility(CardListView.INVISIBLE); 
				cardView_chest.setVisibility(CardListView.INVISIBLE);
				cardView_shoulders.setVisibility(CardListView.INVISIBLE);
				cardView_buttocks.setVisibility(CardListView.INVISIBLE);
				cardView_triceps.setVisibility(CardListView.INVISIBLE);
				cardView_forearm.setVisibility(CardListView.INVISIBLE);
				cardView_abdomen.setVisibility(CardListView.INVISIBLE);
			}
		});
		c7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cardView_shoulders.setVisibility(CardListView.VISIBLE);
				cardView_back.setVisibility(CardListView.INVISIBLE);	
				cardView_biceps.setVisibility(CardListView.INVISIBLE); 
				cardView_chest.setVisibility(CardListView.INVISIBLE);
				cardView_legs.setVisibility(CardListView.INVISIBLE);
				cardView_buttocks.setVisibility(CardListView.INVISIBLE);
				cardView_triceps.setVisibility(CardListView.INVISIBLE);
				cardView_forearm.setVisibility(CardListView.INVISIBLE);
				cardView_abdomen.setVisibility(CardListView.INVISIBLE);
			}
		});
		c8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cardView_triceps.setVisibility(CardListView.VISIBLE);
				cardView_back.setVisibility(CardListView.INVISIBLE);	
				cardView_biceps.setVisibility(CardListView.INVISIBLE); 
				cardView_chest.setVisibility(CardListView.INVISIBLE);
				cardView_shoulders.setVisibility(CardListView.INVISIBLE);
				cardView_legs.setVisibility(CardListView.INVISIBLE);
				cardView_buttocks.setVisibility(CardListView.INVISIBLE);
				cardView_forearm.setVisibility(CardListView.INVISIBLE);
				cardView_abdomen.setVisibility(CardListView.INVISIBLE);
			}
		});
		c9.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cardView_abdomen.setVisibility(CardListView.VISIBLE);
				cardView_back.setVisibility(CardListView.INVISIBLE);	
				cardView_biceps.setVisibility(CardListView.INVISIBLE); 
				cardView_chest.setVisibility(CardListView.INVISIBLE);
				cardView_shoulders.setVisibility(CardListView.INVISIBLE);
				cardView_legs.setVisibility(CardListView.INVISIBLE);
				cardView_buttocks.setVisibility(CardListView.INVISIBLE);
				cardView_triceps.setVisibility(CardListView.INVISIBLE);
				cardView_forearm.setVisibility(CardListView.INVISIBLE);
			}
		});

	}

	@Override
	public void onBackPressed() {
		Log.d("CDA", "onBackPressed Called");

		SharedPreferences sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
		Editor editor = sharedpreferences.edit();
		add_button_check=sharedpreferences.getInt("add_button_check", 0);
		if(add_button_check==1)
		{
			editor.putInt("add_button_check", 0);
			editor.commit();
			Intent mainIntent = new Intent(context,TotalWorkout.class);
			mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
			mainIntent.putExtra("workout_name", workout_name);
			mainIntent.putExtra("workout_id", workout_id);
			mainIntent.putExtra("no_of_days", total_days);
			this.startActivity(mainIntent);
			this.finish();

		}
		else
		{
			Intent mainIntent = new Intent(context,PhysicalSchedule.class);
			mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
			this.startActivity(mainIntent);
			this.finish();

		}


	}

}
