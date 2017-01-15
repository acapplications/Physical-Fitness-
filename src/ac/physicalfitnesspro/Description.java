package ac.physicalfitnesspro;

import it.gmariotti.cardslib.library.view.CardView;

import java.util.List;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.adapters.CustomCardDescription;
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
import android.widget.ImageButton;
import android.widget.Toast;

public class Description extends Activity {

	static String listData1=new String();
	int MENU_GUIDE = Menu.FIRST;
	int MENU_ADD= Menu.FIRST+1;
	InterstitialAd mInterstitialAd;
	AdView adView;
	SharedPreferences sharedPreferences;
	Editor editor;
	ActionBar actionBar;
	static int strValue4;
	String strValue;
	int check_ads=2;;
	Context context;
	ImageButton img;
	CardView c1;
	CustomCardDescription card;
	DatabaseHelper db;

	String workout_name;
	int no_of_days;
	int add_button_check;
	int workout_id;
	int total_days;
	int check_same=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_description);

		context=getApplicationContext();
		sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
		Editor editor=sharedPreferences.edit();
		
			editor.putInt("check_ads_description", check_ads++);
			editor.commit();
			mInterstitialAd = new InterstitialAd(this);
			mInterstitialAd.setAdUnitId("ca-app-pub-5252090216747895/1046021169");
			displayInterstitial();

			mInterstitialAd.setAdListener(new AdListener() {
				public void onAdLoaded() {
					// Call displayInterstitial() function
					displayInterstitial();
				}
			});
			editor.putInt("check_ads_description", ++check_ads);
			editor.commit();
		

		SpannableString s1 = new SpannableString("DESCRIPTION");
		s1.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s1.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		actionBar = getActionBar();
		actionBar.setTitle(s1);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D75BD")));



		add_button_check=sharedPreferences.getInt("add_button", 0);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			if(add_button_check==1)
			{
				no_of_days= extras.getInt("no_of_days");
				workout_name= extras.getString("workout_name");
				workout_id= extras.getInt("workout_id");
				total_days=extras.getInt("total_days");
			}
			listData1= extras.getString("desc");
			strValue4= extras.getInt("pic");
			strValue= extras.getString("name");
		}
		card= new CustomCardDescription(context,listData1);
		c1= (CardView) findViewById(R.id.desc);
		c1.setCard(card);
		img=(ImageButton)findViewById(R.id.img);
		img.setImageResource(strValue4);

		img.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent mainIntent = new Intent(context,Picture.class);
				mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				mainIntent.putExtra("pic", strValue4);
				context.startActivity(mainIntent);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.resistance, menu);

		MenuItem set1=menu.add(Menu.NONE,MENU_GUIDE,1,wrapInSpan(getResources().getString(R.string.guide)))
				.setTitleCondensed(getResources().getString(R.string.guide));
		set1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		if(add_button_check==1)
		{
			MenuItem set2=menu.add(Menu.NONE,MENU_ADD,2,wrapInSpan(getResources().getString(R.string.add)))
					.setTitleCondensed(getResources().getString(R.string.add));
			set2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		}
		return super.onCreateOptionsMenu(menu);
	}

	private CharSequence wrapInSpan(CharSequence value) {
		SpannableStringBuilder sb = new SpannableStringBuilder(value);
		sb.setSpan(new TypefaceSpan(context,"Roboto-Medium.ttf"), 0, value.length(), 0);
		return sb;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id=item.getItemId();

		if(id==MENU_GUIDE)
		{
			displayGuidelines();
		}
		else if(id==MENU_ADD)
		{

			if(add_button_check==1)
			{
				try
				{
					// Reading all contacts
					SharedPreferences sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
					Editor editor = sharedpreferences.edit();
					editor.putInt("check_back_total", 1);
					editor.commit();
					Log.d("Reading: ", "Reading all contacts..");
					db=new DatabaseHelper(context);
					List<WorkoutDescDayWise> nameWorkout = db.getAllTags();  
					if(nameWorkout!=null)
					{
						for (WorkoutDescDayWise cn : nameWorkout) {

							if(workout_id==cn.getWorkout_id() && no_of_days==Integer.valueOf(cn.getDay()) && strValue.equals(cn.getExercise_Name()))
							{

								editor.putInt("check_same",1);
								editor.commit();
							}
						}
					}
					check_same=sharedpreferences.getInt("check_same", 0);
					if(check_same==0)
					{	
						//		System.out.println("entered");
						Log.d("Insert: ", "Inserting ..");
						System.out.println(no_of_days+"no of days "+" description");
						WorkoutDescDayWise oWorkout = new WorkoutDescDayWise();
						oWorkout.setDay(String.valueOf(no_of_days));
						oWorkout.setDescription(listData1);
						oWorkout.setImage(strValue4);
						oWorkout.setExercise_Name(strValue);
						oWorkout.setWorkout_id(workout_id);
						db.createTag(oWorkout);
						editor.putInt("add_button", 0);
					}

					Intent mainIntent1 = new Intent(context,TotalWorkout.class);
					mainIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mainIntent1.putExtra("workout_name", workout_name);
					mainIntent1.putExtra("workout_id", workout_id);
					mainIntent1.putExtra("no_of_days", total_days);
					context.startActivity(mainIntent1);

				}
				catch(Exception e)
				{
					Toast.makeText(context, "Try again!!! =)",
							Toast.LENGTH_LONG).show();
				}
			}

		}
		return super.onOptionsItemSelected(item);
	}
	protected void displayGuidelines()
	{
		Intent mainIntent1 = new Intent(context,GuideLines.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(mainIntent1);	
	}
	protected void displayInterstitial() {
		// If Ads are loaded, show Interstitial else show nothing.
		AdRequest adRequest = new AdRequest.Builder()
		// Add a test device to show Test Ads
		.build();
		mInterstitialAd.loadAd(adRequest);
		mInterstitialAd.show();
	}

}
