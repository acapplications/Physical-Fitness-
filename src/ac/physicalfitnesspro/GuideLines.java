package ac.physicalfitnesspro;

import ac.physicalfitnesspro.R;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class GuideLines extends ActionBarActivity {
	TextView guidLines1,guidLines2,guidLines3,guidLines4,guidLines5;
	ActionBar actionBar;
	Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide_lines);
		context=getApplicationContext();

		SpannableString s = new SpannableString("GUIDELINES");
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/Roboto-Medium.ttf");
		actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1D75BD")));
		actionBar.setTitle(s);

		guidLines1=(TextView)findViewById(R.id.guide_lines1);
		guidLines2=(TextView)findViewById(R.id.guide_lines2);
		guidLines3=(TextView)findViewById(R.id.guide_lines3);
		guidLines4=(TextView)findViewById(R.id.guide_lines4);
		guidLines5=(TextView)findViewById(R.id.guide_lines5);
		guidLines1.setTypeface(typeFace);
		guidLines1.setTextSize(25);
		guidLines2.setTypeface(typeFace);
		guidLines2.setTextSize(25);
		guidLines3.setTypeface(typeFace);
		guidLines3.setTextSize(25);
		guidLines4.setTypeface(typeFace);
		guidLines4.setTextSize(25);
		guidLines5.setTypeface(typeFace);
		guidLines5.setTextSize(25);

	}
}
