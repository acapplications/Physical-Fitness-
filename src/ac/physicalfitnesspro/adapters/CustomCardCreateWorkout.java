package ac.physicalfitnesspro.adapters;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.TotalWorkout;
import ac.physicalfitnesspro.TypefaceSpan;
import ac.physicalfitnesspro.WorkoutNameDays;
import ac.physicalfitnesspro.helper.DatabaseHelper;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomCardCreateWorkout extends Card  {
	ArrayList<String> listData1;
	protected TextView mTitle;
	Intent mainIntent1;
	Context context;
	int i;
	String workout_name;
	String total_days;
	int workout_id;
	SpannableString s;

	public CustomCardCreateWorkout(Context context,ArrayList<String> listData1, int i)
	{
		this(context,R.layout.adapter_text);
		this.context=context;
		this.i=i;
		this.listData1=listData1;
	}

	public CustomCardCreateWorkout(Context context,ArrayList<String> listData1, int i, String workout_name,	String total_days, int workout_id) {
		this(context, R.layout.adapter_text);
		this.context=context;
		this.i=i;
		this.listData1=listData1;
		this.workout_name=workout_name;
		this.workout_id=workout_id;
		this.total_days=total_days;
	}

	public CustomCardCreateWorkout(Context context, int innerLayout) {
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
					mainIntent1 = new Intent(context,WorkoutNameDays.class);
					mainIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(mainIntent1);
				}
				else
				{
					mainIntent1 = new Intent(context,TotalWorkout.class);
					mainIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mainIntent1.putExtra("workout_name", workout_name);
					mainIntent1.putExtra("workout_id", workout_id);
					mainIntent1.putExtra("no_of_days", Integer.parseInt(total_days));
					context.startActivity(mainIntent1);
				}
			}
		});

		setOnSwipeListener(new OnSwipeListener() {

			@Override
			public void onSwipe(Card card) {
				//Do something
				if(i!=0)
				{
					DatabaseHelper db=new DatabaseHelper(context);
					//if((listData1.size()-1)>=j) {
					db.deleteWorkoutName(workout_id);

				}
			}		

		});
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {

		s = new SpannableString(listData1.get(i));
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		mTitle = (TextView) parent.findViewById(R.id.txt);

		if (mTitle!=null)
		{
			mTitle.setText(s);
			mTitle.setTextSize(20);
		}

	}
}
