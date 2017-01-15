
package ac.physicalfitnesspro;

import java.util.ArrayList;

import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.adapters.NavDrawerListAdapter;
import ac.physicalfitnesspro.fragments.ContactFragment;
import ac.physicalfitnesspro.fragments.CreditsFragment;
import ac.physicalfitnesspro.fragments.HomeFragment;
import ac.physicalfitnesspro.fragments.NavDrawerItem;
import ac.physicalfitnesspro.fragments.VersionFragment;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class PhysicalSchedule extends Activity {

	//InterstitialAd mInterstitialAd;
	//AdView adView;
	int at_home;

	SharedPreferences sharedPreferences;
	Editor editor;
	boolean doubleBackToExitPressedOnce = false;
	//InterstitialAd banner;
	Context context;
	ActionBar actionBar;
	int tag=0;

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	// slide menu items
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter_slider;

	String workout_name;
	int no_of_days;
	int add_button_check;
	int workout_id;
	int total_days;

	int check_back_total;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	

		context=getApplicationContext();

		SharedPreferences sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
/*		add_button_check=sharedpreferences.getInt("add_button", 0);

		if(add_button_check==1)
		{
			Bundle extras = getIntent().getExtras();
			if (extras != null) {

				workout_name= extras.getString("workout_name");
				no_of_days= extras.getInt("day");
				workout_id= extras.getInt("workout_id");
				total_days=extras.getInt("total_days");
			}
		}*/
		check_back_total=sharedpreferences.getInt("check_back_total", 0);

		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

		// nav drawer icons from resources
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

		navDrawerItems = new ArrayList<NavDrawerItem>();

		// adding nav drawer items to array
		// DIABETES FITNESS
		/*if(check_back_total==1)
		{
			tag=3;
		}*/
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
		// PHYSICAL FITNESS
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
		// Photos

		// Recycle the typed array
		navMenuIcons.recycle();

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		// setting the nav drawer list adapter
		adapter_slider = new NavDrawerListAdapter(context,navDrawerItems);
		mDrawerList.setAdapter(adapter_slider);

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, //nav menu toggle icon
				R.string.app_name, // nav drawer open - description for accessibility
				R.string.app_name // nav drawer close - description for accessibility
				) {
			public void onDrawerClosed(View view) {

				/*if(check_back_total==1)
				{
					tag=3;
				}*/



				if(tag==0)
				{
					SpannableString s = new SpannableString("PHYSICAL FITNESS");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				else if(tag==1)
				{
					SpannableString s = new SpannableString("CREDITS");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				else if(tag==2)
				{
					SpannableString s = new SpannableString("CONTACT");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				else if(tag==3)
				{
					SpannableString s = new SpannableString("VERSION");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				else if(tag==4)
				{
					SpannableString s = new SpannableString("PHYSICAL FITNESS");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
				/*

				if(tag==1)
				{
					SpannableString s = new SpannableString("PHYSICAL FITNESS");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				else if(tag==2)
				{
					SpannableString s = new SpannableString("BMI VALUE");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				else if(tag==3)
				{
					SpannableString s = new SpannableString("CUSTOM WORKOUT");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
				 */			}

			public void onDrawerOpened(View drawerView) {
		//		SharedPreferences sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
				/*check_back_total=sharedpreferences.getInt("check_back_total", 0);
				if(check_back_total==1)
				{
					tag=3;
				}
				if(tag==1)
				{
					SpannableString s = new SpannableString("PHYSICAL FITNESS");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				else if(tag==2)
				{
					SpannableString s = new SpannableString("BMI VALUE");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				else if(tag==3)
				{
					SpannableString s = new SpannableString("CUSTOM WORKOUT");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
				 */ 
				if(tag==0)
				{
					SpannableString s = new SpannableString("PHYSICAL FITNESS");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				else if(tag==1)
				{
					SpannableString s = new SpannableString("CREDITS");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				else if(tag==2)
				{
					SpannableString s = new SpannableString("CONTACT");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				else if(tag==3)
				{
					SpannableString s = new SpannableString("VERSION");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				else if(tag==4)
				{
					SpannableString s = new SpannableString("PHYSICAL FITNESS");
					s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					getActionBar().setTitle(s);
				}
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();

			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0);
		}

		SpannableString s2 = new SpannableString("PHYSICAL FITNESS");
		s2.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s2.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

		actionBar = getActionBar();
		actionBar.setTitle(s2);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D75BD")));

	}

	private class SlideMenuClickListener implements
	ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
		}
	}



	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	public void displayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		SharedPreferences sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
		check_back_total=sharedpreferences.getInt("check_back_total", 0);
	//	Editor editor = sharedpreferences.edit();

		Intent mainIntent1;
		/*		if(check_back_total==1)
		{

			fragment= new CreateWorkoutActivity();
			tag=3;
			editor.putInt("check_back_total", 0);
			editor.commit();
		}
		else
		{*/
		switch (position) {
		case 0:
			fragment= new HomeFragment();
			tag=0;
			break;
		case 1:
			fragment= new CreditsFragment();
			tag=1;
			break;
		case 2:
			fragment= new ContactFragment();
			tag=2;
			/*				editor.putInt("check_back_total", 0);
				editor.putInt("add_button", 0);
				editor.commit();
			 */				break;
		case 3:
			fragment= new VersionFragment();
			tag=3;
			break;
		case 4:
			mainIntent1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.diabetesfitness"));
			mainIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(mainIntent1);
			tag=4;
			break;
		default:
			break;
		}
		//}
		if (fragment != null) 
		{
			FragmentManager fragmentManager = getFragmentManager();

			/*if(position==0)
			{
				Bundle bundle = new Bundle();
				bundle.putInt("workout_id", workout_id);
				bundle.putInt("no_of_days", no_of_days);
				bundle.putString("workout_name", workout_name);
				bundle.putInt("total_days", total_days);
				System.out.println(total_days);
				fragment.setArguments(bundle);
			}*/

			fragmentManager.beginTransaction()
			.replace(R.id.frame_container, fragment).commit();
			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}

	@Override
	public void setTitle(CharSequence title) {

		if(tag==0)
		{
			SpannableString s = new SpannableString("PHYSICAL FITNESS");
			s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
			getActionBar().setTitle(s);
		}
		else if(tag==1)
		{
			SpannableString s = new SpannableString("CREDITS");
			s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
			getActionBar().setTitle(s);
		}
		else if(tag==2)
		{
			SpannableString s = new SpannableString("CONTACT");
			s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
			getActionBar().setTitle(s);
		}
		else if(tag==3)
		{
			SpannableString s = new SpannableString("VERSION");
			s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
			getActionBar().setTitle(s);
		}
		else if(tag==4)
		{
			SpannableString s = new SpannableString("PHYSICAL FITNESS");
			s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
			getActionBar().setTitle(s);
		}
		// calling onPrepareOptionsMenu() to show action bar icons
		invalidateOptionsMenu();
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.diabetes_schedule, menu);

		return super.onCreateOptionsMenu(menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}	
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void onBackPressed() {
		SharedPreferences sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
		editor=sharedpreferences.edit();
		at_home=sharedpreferences.getInt("at_home", 1);

		if(at_home!=1)
		{

			editor.putInt("at_home", 1);
			editor.commit();
			displayView(0);

		}
		else
		{
			if (doubleBackToExitPressedOnce) {

				super.onBackPressed();
				return;
			}

			this.doubleBackToExitPressedOnce = true;
			Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					doubleBackToExitPressedOnce=false;                       
				}
			}, 2000);
		}
	}

}
