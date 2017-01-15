package ac.physicalfitnesspro;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import ac.physicalfitnesspro.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Picture extends Activity {

	Context context;
	ActionBar actionBar;
	int strValue4;
	RelativeLayout rl;
	ImageView img;
	SharedPreferences sharedPreferences;
	int check_ads;
	InterstitialAd mInterstitialAd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picture);

		context=getApplicationContext();

		sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
		Editor editor=sharedPreferences.edit();
		check_ads=sharedPreferences.getInt("check_ads_picture", 5);
		if(check_ads%3==1)
		{
			editor.putInt("check_ads_description", check_ads++);
			editor.commit();
			mInterstitialAd = new InterstitialAd(this);
			mInterstitialAd.setAdUnitId("ca-app-pub-8182751914500309/4548756677");
			displayInterstitial();

			mInterstitialAd.setAdListener(new AdListener() {
				public void onAdLoaded() {
					// Call displayInterstitial() function
					displayInterstitial();
				}
			});
			editor.putInt("check_ads_picture", check_ads++);
			editor.commit();
		}
		else
		{

			editor.putInt("check_ads_picture", check_ads++);
			editor.commit();
		}


		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			strValue4= extras.getInt("pic");
		}

		rl=(RelativeLayout)findViewById(R.id.rl);
		rl.setBackgroundResource(strValue4);
		SpannableString s1 = new SpannableString("PICTURE");
		s1.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s1.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		actionBar = getActionBar();
		actionBar.setTitle(s1);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D75BD")));

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