package ac.physicalfitnesspro.adapters;

import it.gmariotti.cardslib.library.internal.Card;

import java.util.ArrayList;

import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.Description;
import ac.physicalfitnesspro.PhysicalFitnessActivity;
import ac.physicalfitnesspro.TypefaceSpan;
import ac.physicalfitnesspro.helper.DatabaseHelper;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomCardAddExercise extends Card  {
	ArrayList<String> listData1;
	protected TextView mTitle;
	Intent mainIntent1;
	Context context;
	int i;
	SpannableString s;
	String workout_name;
	int workout_id;
	int days;
	int total_days;
	SharedPreferences pref; 
	Editor editor;
	ArrayList<String> listDesc1=new ArrayList<String>(25);
	ArrayList<Integer> listImg1=new ArrayList<Integer>(25);
	ArrayList<Integer> listId1=new ArrayList<Integer>(25);
	public CustomCardAddExercise(Context context,ArrayList<String> listData1, int i,String workout_name,int workout_id,int days, int total_days,ArrayList<String> listDesc1, ArrayList<Integer> listImg1, ArrayList<Integer> listId1) {
		this(context, R.layout.adapter_text);
		this.context=context;
		this.i=i;
		this.listData1=listData1;
		this.workout_name=workout_name;
		this.workout_id=workout_id;
		this.days=days;
		this.total_days=total_days;
		this.listDesc1=listDesc1;
		this.listImg1=listImg1;
		this.listId1=listId1;
	}

	public CustomCardAddExercise(Context context, int innerLayout) {
		super(context, innerLayout);
		init();
	}

	private void init(){
		setOnClickListener(new OnCardClickListener() {

			@Override
			public void onClick(Card card, View view) {
				// TODO Auto-generated method stub

				pref = context.getSharedPreferences("MyPref", 0); 
				editor = pref.edit();
				if(i==0)
				{
//					System.out.println(total_days); 

					editor.putInt("add_button", 1);
					editor.putInt("check_back_total", 0);
					editor.commit();
					//	System.out.println(pref.getInt("add_button", 0)+"  555  ");
					mainIntent1 = new Intent(context,PhysicalFitnessActivity.class);
					mainIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mainIntent1.putExtra("workout_name", workout_name);
					mainIntent1.putExtra("workout_id", workout_id);
					mainIntent1.putExtra("day", days);
					mainIntent1.putExtra("total_days", total_days);
					//System.out.println(days+"customcardaddexercise");
					context.startActivity(mainIntent1);
				}
				else 
				{
					mainIntent1 = new Intent(context,Description.class);
					editor.putInt("add_button", 0);
					editor.putInt("check_back_total", 0);
					editor.commit();
					mainIntent1.putExtra("name", listData1.get(i));
					mainIntent1.putExtra("desc", listDesc1.get(i));
					mainIntent1.putExtra("pic", listImg1.get(i));
					mainIntent1.putExtra("workout_name", workout_name);
					mainIntent1.putExtra("no_of_days", days);
					mainIntent1.putExtra("workout_id", workout_id);
					mainIntent1.putExtra("total_days", total_days);
					mainIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(mainIntent1);
				}
			}
		});
		setOnSwipeListener(new OnSwipeListener() {

			@Override
			public void onSwipe(Card card) {
				// TODO Auto-generated method stub
				if(i!=0)
				{
					DatabaseHelper db=new DatabaseHelper(context);
					db.deleteWorkoutDescDayWise(listId1.get(i-1));
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
