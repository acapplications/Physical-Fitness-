package ac.physicalfitnesspro;

import java.text.DecimalFormat;

import ac.physicalfitnesspro.R;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class BMIActivity  extends Activity {
	double height;
	double weight;
	static double BMI;
	String BMIvalue; 
	EditText h1;
	TextView t1 ,t2 ,inch, kgs, bmi_Result, bmi_text;
	EditText w1;
	ActionBar actionBar;
	Button proceed;
	static Context context;
	SpannableString s,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
	private Typeface myFont;
	String [] items_inch;
	String [] items_kg;
	String set_inch,set_kg;
	EditText foot,foot_inch;
	double value_foot;
	double value_inch;
	int set_foot_inch=0;
	InterstitialAd mInterstitialAd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bmi_activity);

		context = getApplicationContext();

		items_inch = getResources().getStringArray(R.array.bmi_activity_items_inch);
		items_kg = getResources().getStringArray(R.array.bmi_activity_items_kg);

		SpannableString s = new SpannableString("BMI");
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

		actionBar = getActionBar();
		actionBar.setTitle(s);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D75BD")));

		mInterstitialAd = new InterstitialAd(this);
		mInterstitialAd.setAdUnitId("ca-app-pub-5252090216747895/2522754364");
		displayInterstitial();

		mInterstitialAd.setAdListener(new AdListener() {
			public void onAdLoaded() {
				// Call displayInterstitial() function
				displayInterstitial();
			}
		});

		h1=(EditText)findViewById(R.id.height);
		Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Medium.ttf"); 
		h1.setTypeface(type);
		h1.setTextSize(25);
		h1.setGravity(Gravity.CENTER);

		w1=(EditText)findViewById(R.id.weight);
		w1.setTextSize(25);
		w1.setTypeface(type);
		w1.setGravity(Gravity.CENTER);

		t1=(TextView)findViewById(R.id.askHeight);
		t1.setText(getResources().getString(R.string.ask_height));
		t1.setTextSize(25);
		t1.setTypeface(type);

		t2=(TextView)findViewById(R.id.askWeight);
		t2.setText(getResources().getString(R.string.ask_weight));
		t2.setTextSize(25);
		t2.setTypeface(type);

		bmi_Result=(TextView)findViewById(R.id.bmi_result);

		bmi_text=(TextView)findViewById(R.id.bmi_text);

		proceed=(Button)findViewById(R.id.proceed);
		s5 = new SpannableString(getResources().getString(R.string.proceed));
		s5.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s5.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		proceed.setText(s5);
		proceed.setTextSize(25);
		Spinner spinner_inch = (Spinner) findViewById(R.id.txt_inch);

		foot= (EditText) findViewById(R.id.foot);
		foot.setTextSize(25);
		foot.setTypeface(type);
		foot.setGravity(Gravity.CENTER);

		foot_inch= (EditText) findViewById(R.id.inch);
		foot_inch.setTextSize(25);
		foot_inch.setTypeface(type);
		foot_inch.setGravity(Gravity.CENTER);

		MyArrayAdapter ma = new MyArrayAdapter(context,items_inch);
		spinner_inch.setAdapter(ma);

		spinner_inch.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				set_inch=items_inch[arg2];
				if(arg2==2)
				{
					foot.setVisibility(EditText.VISIBLE);
					foot_inch.setVisibility(EditText.VISIBLE);
					h1.setVisibility(EditText.INVISIBLE);
					set_foot_inch=1;
				}
				else
				{
					h1.setVisibility(EditText.VISIBLE);
					foot.setVisibility(EditText.INVISIBLE);
					foot_inch.setVisibility(EditText.INVISIBLE);
					set_foot_inch=0;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				set_inch=items_inch[0];
				set_foot_inch=0;
				//System.out.println("pon nothing");

			}
		});

		Spinner spinner_kg = (Spinner) findViewById(R.id.txt_kg);


		myFont = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");
		MyArrayAdapter ma1 = new MyArrayAdapter(context,items_kg);
		spinner_kg.setAdapter(ma1);

		spinner_kg.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				set_kg=items_kg[arg2];
			}	

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				set_kg=items_kg[0];
			}
		});

		proceed.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); 

				inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
				try{
					weight= Double.parseDouble(w1.getText().toString());

					if(set_foot_inch==1)
					{
						value_foot=Double.parseDouble(foot.getText().toString());
						value_inch=Double.parseDouble(foot_inch.getText().toString());
						if(value_inch<13 || value_inch>=0)
						{
							height=(double)(value_foot*12)+(double)value_inch;
						}
						else
						{
							height=0.0;
						}
					}
					else if(set_foot_inch==0)
					{
						height= Double.parseDouble(h1.getText().toString());
					}
				}
				catch (NumberFormatException e){
					Toast.makeText(context, "Please enter the values",
							Toast.LENGTH_LONG).show();	
				}

				if(set_inch.equals(items_inch[0]) && set_kg.equals(items_kg[0]))
				{
					BMI = (weight*703)/((height)*(height));
					//inches and pounds
				}
				else if(set_inch.equals(items_inch[1]) && set_kg.equals(items_kg[1]))
				{ 
					BMI = (weight*10000)/((height)*(height));
					//	System.out.println(BMI);
				}
				else if(set_inch.equals(items_inch[0]) && set_kg.equals(items_kg[1]))
				{
					BMI = (weight)/((height/39.3701)*(height/39.3701));
				}
				else if(set_inch.equals(items_inch[1]) && set_kg.equals(items_kg[0]))
				{
					BMI = (weight*703*6.45)/((height)*(height));
				}
				else if(set_inch.equals(items_inch[2]) && set_kg.equals(items_kg[1]))
				{
					BMI = (weight)/(((height)/39.3701)*(height/39.3701));
				}
				else if(set_inch.equals(items_inch[2]) && set_kg.equals(items_kg[0]))
				{
					BMI = (weight*703)/(height*height);
				}
				DecimalFormat f = new DecimalFormat("##.00");
				BMIvalue=f.format(BMI);
				if(weight==0 || height==0)
				{

					Toast.makeText(context,getResources().getString(R.string.toast_please_enter_correct_values),
							Toast.LENGTH_LONG).show();	
				}

				else if(BMI<16.5 || BMI>55)
				{
					Toast.makeText(context, getResources().getString(R.string.toast_please_enter_correct_values),
							Toast.LENGTH_LONG).show();
				}
				else 
				{	
					s2 = new SpannableString("BMI"+" : "+BMIvalue);
					s2.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s2.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					bmi_Result.setText(s2);
					bmi_Result.setTextSize(35);
					bmi_Result.setVisibility(TextView.VISIBLE);

					bmi_text.setVisibility(TextView.VISIBLE);
					if(BMI<16.5)
					{
						s8 = new SpannableString(getResources().getString(R.string.bmi_activity_severly_under));
					}
					else if(BMI>=16.5 && BMI<18.5)
					{
						s8 = new SpannableString(getResources().getString(R.string.bmi_activity_under));	
					}
					else if(BMI>=18.5 && BMI<25)
					{
						s8 = new SpannableString(getResources().getString(R.string.bmi_activity_normal));
					}
					else if(BMI>=25 && BMI<30)
					{s8 = new SpannableString(getResources().getString(R.string.bmi_activity_overweight));

					}
					else if(BMI>=30 && BMI<35)
					{
						s8 = new SpannableString(getResources().getString(R.string.bmi_activity_obese));
					}
					else if(BMI>=35 && BMI<40)
					{
						s8 = new SpannableString(getResources().getString(R.string.bmi_activity_clinically_obese));
					}
					else if(BMI>=40)
					{
						s8 = new SpannableString(getResources().getString(R.string.bmi_activity_clinically_obese));
					}
					s8.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s8.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					bmi_text.setText(s8);
					bmi_text.setTextSize(35);
				}
			}
		});


	}
	private class MyArrayAdapter extends BaseAdapter {
		String[] items;
		private LayoutInflater mInflater;

		public MyArrayAdapter(Context con,String[] items) {
			// TODO Auto-generated constructor stub
			mInflater = LayoutInflater.from(con);
			this.items=items;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return items.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@SuppressLint("InflateParams") @Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			final ListContent holder;
			View v = convertView;
			if (v == null) {
				v = mInflater.inflate(R.layout.my_spinner_style, null);
				holder = new ListContent();

				holder.name = (TextView) v.findViewById(R.id.textView1);

				v.setTag(holder);
			} else {

				holder = (ListContent) v.getTag();
			}

			holder.name.setTypeface(myFont);
			holder.name.setText("" + items[position]);

			return v;
		}

	}

	static class ListContent {

		TextView name;

	}



	protected void displayInterstitial() {
		// If Ads are loaded, show Interstitial else show nothing.
		AdRequest adRequest = new AdRequest.Builder()
		// Add a test device to show Test Ads
		.build();
		mInterstitialAd.loadAd(adRequest);
		mInterstitialAd.show();
	}
	@Override
	public void onBackPressed() {

		Intent mainIntent1 = new Intent(context,PhysicalSchedule.class);
		mainIntent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(mainIntent1);
	}

}
