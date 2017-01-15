package ac.physicalfitnesspro;


import ac.physicalfitnesspro.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;

public class Version extends Activity {

	ActionBar actionBar;
	Context context;
	TextView version;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context=getApplicationContext();
		setContentView(R.layout.activity_version);
		SpannableString s = new SpannableString("VERSION");
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(),
		        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		actionBar = getActionBar();
		actionBar.setTitle(s);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D75BD")));
	
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/Roboto-Medium.ttf");
		version=(TextView)findViewById(R.id.version_number);
		version.setTypeface(typeFace);
		version.setTextSize(25);
	}
}