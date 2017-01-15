package ac.physicalfitnesspro.adapters;

import it.gmariotti.cardslib.library.internal.Card;

import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.BMIActivity;
import ac.physicalfitnesspro.CreateWorkoutActivity;
import ac.physicalfitnesspro.PhysicalFitnessActivity;
import ac.physicalfitnesspro.TypefaceSpan;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomCardHomeFragment extends Card  {
	String[] listData1;
	protected TextView mTitle;
	Intent mainIntent1;
	Context context;
	int i;
	SpannableString s;

	public CustomCardHomeFragment(Context context,String[] listData1, int i)
	{
		this(context,R.layout.adapter_text);
		this.context=context;
		this.i=i;
		this.listData1=listData1;
	}



	public CustomCardHomeFragment(Context context, int innerLayout) {
		super(context, innerLayout);
		init();
	}

	private void init(){
		setOnClickListener(new OnCardClickListener() {

			@Override
			public void onClick(Card card, View view) {
				// TODO Auto-generated method stub


				if(i==0)
				{
					mainIntent1 = new Intent(context,PhysicalFitnessActivity.class);
					mainIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(mainIntent1);
				}
				else if(i==1)
				{
					mainIntent1 = new Intent(context,CreateWorkoutActivity.class);
					mainIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(mainIntent1);
				}
				else if(i==2)
				{
					mainIntent1 = new Intent(context,BMIActivity.class);
					mainIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(mainIntent1);
				}
			}
		});

	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {

		s = new SpannableString(listData1[i]);
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		mTitle = (TextView) parent.findViewById(R.id.txt);

		if (mTitle!=null)
		{
			mTitle.setText(s);
			mTitle.setTextSize(20);
		}

	}
}
