package ac.physicalfitnesspro.adapters;


import it.gmariotti.cardslib.library.internal.Card;
import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.Description;
import ac.physicalfitnesspro.TypefaceSpan;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomCardMainPageTwoForearm extends Card{
	String[] listData1;
	protected TextView mTitle;
	protected ImageView mImage;
	Intent mainIntent1;
	String strValue;
	int strValue1;
	String strValue2;
	Context context;
	int[] imgarray;
	SpannableString s;
	String workout_name;
	int no_of_days;
	int add_button_check;
	int workout_id;
	int i;
	int total_days;
	String[] forearm_list= new String[]{"Wrist curls", "Reverse wrist curls"};
	String[] forearm=new String[]{"This exercise trains the flexors of the wrist and fingers. This muscle are often over looked when exercising. Resting your forearms on your thighs or on a bench. Take an underhand grip on the bar as you extend your wrists. Inhale and curl your wrists up. Exhaling as you complete the movement. Lower the bar into the starting position in a controlled manner.",
			"A great exercise for strengthening the wrist, which can be often over looked. Resting your forearms on your thighs or on a bench, take an overhand grip on the bar with your wrist flexed. Curl your wrists back toward you and returning them to the starting position in a controlled manner."
	};
	int[] forearm_img=new int[]{R.drawable.wristcurls,R.drawable.reversewristcurl};

	public CustomCardMainPageTwoForearm(Context context,String[] listData1, int[] imgarray, int i,String workout_name,int no_of_days,int workout_id,int total_days) {
		this(context, R.layout.text_image_layout);
		this.context=context;
		this.i=i;
		this.listData1=listData1;
		this.workout_name=workout_name;
		this.imgarray=imgarray;
		this.no_of_days=no_of_days;
		this.workout_id= workout_id;
		this.total_days=total_days;
	}

	public CustomCardMainPageTwoForearm(Context context, int innerLayout) {
		super(context, innerLayout);
		this.context=context;
		init();
	}

	private void init(){

		setOnClickListener(new OnCardClickListener() {

			@Override
			public void onClick(Card card, View view) {
				// TODO Auto-generated method stub
				switch(i)
				{
				case 0:
					strValue=forearm_list[0];
					strValue1=forearm_img[0];
					strValue2=forearm[0];
					break;
				case 1:
					strValue=forearm_list[1];
					strValue1=forearm_img[1];
					strValue2=forearm[1];
					break;

				}
				mainIntent1 = new Intent(context,Description.class);

				mainIntent1.putExtra("name", strValue);
				mainIntent1.putExtra("desc", strValue2);
				mainIntent1.putExtra("no_of_days", no_of_days);
				mainIntent1.putExtra("workout_name", workout_name);
				mainIntent1.putExtra("workout_id", workout_id);
				mainIntent1.putExtra("pic", strValue1);
				mainIntent1.putExtra("total_days", total_days);
				mainIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(mainIntent1);
			}
		});
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {

		s = new SpannableString(listData1[i]);
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		mTitle = (TextView) parent.findViewById(R.id.txt);
		mImage=(ImageView) parent.findViewById(R.id.img);

		if (mTitle!=null)
		{
			mTitle.setText(s);
			mTitle.setTextSize(20);
			mImage.setImageResource(imgarray[i]);
		}
	}
}

