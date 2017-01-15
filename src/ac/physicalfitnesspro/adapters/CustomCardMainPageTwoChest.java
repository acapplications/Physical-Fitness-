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


public class CustomCardMainPageTwoChest extends Card{
	String[] listData1;
	protected TextView mTitle;
	protected ImageView mImage;
	Intent mainIntent1;
	String strValue;
	int strValue1;
	String strValue2;

	Context context;
	int[] imgarray;
	String workout_name;
	int no_of_days;
	int add_button_check;
	int workout_id;
	SpannableString s;
	int total_days;
	int i;
	String[] chest_list= new String[]{"Bench press", "Close grip bench press", "Incline press", "Decline press", "Pushup", "Parralel bar dips", "Dumbbell press", "Incline dumbbell flys", "Dumbbell flys", "Incline dumbbell press", "Pec dec flys", "Cable Crossover Flys", "Dumbbell Pullover", "Barbell Pullover"};
	String[] chest=new String[]{"Lying on your back on a flat bench, take an overhand grip on the barbell with your hands shoulder-width apart. Keep your buttocks in contact with the bench and your feet flat on the floor during this exercise. Inhale and slowly lower the barbell until it hits your chest. Press the weight back up, exhaling as you reach the top.," +
			"Lying on your back on a flat bench, take an overhand grip on the barbell with your hands 4 to 10 inches apart. Keep your buttocks in contact with the bench and your feet flat on the floor during this exercise. Inhale and slowly lower the barbell until it hits your chest. Press the weight back up, exhaling as you reach the top.",
			"Lying on your back on an incline bench set between 45 and 60 degrees, take an overhand grip on the barbell with your hands shoulder-width apart. Keep your buttocks in contact with the bench and your feet flat on the floor during this exercise. Inhale and slowly lower the barbell until it hits your chest. Press the weight back up, exhaling as you reach the top.",
			"Lying on your back on a decline bench set between 20 and 40 degrees, take an overhand grip on the barbell with your hands shoulder-width apart. Keep your buttocks in contact with the bench and your feet flat on the floor during this exercise. Inhale and slowly lower the barbell until it hits your chest. Press the weight back up, exhaling as you reach the top.",
			"Lie in a prone position with your arms and back straight. With your hands shoulder width apart and your feet together, inhale and bend your elbows to bring your body about the width of a fist close to the floor. Push yourself back up as you exhale and complete the movement.",
			"Step between wide dip bars with dip belt around waist. Kneel as close as possible to low pulley and attach cable to dip belt. Stand up and mount dip bar with oblique grip (bar diagonal under palm), arms straight with shoulders above hands. Keep hips and knees bent.",
			"Lying on your back on a flat bench and your feet firmly on the floor for stability, extend your arms upwards. Inhale as you lower the dumbbells to your chest. Exhale as you slowly extend your arms to the starting position.",
			"Grasp two dumbbells. Lie supine on bench. Support dumbbells above upper chest with arms fixed in slightly bent position. Bend elbows slightly and internally rotate shoulders so elbows point out to sides. Lower dumbbells outward to sides of shoulders. Keep elbows fixed in slightly bent position. When a stretch is felt in chest or shoulders, bring dumbbells back together in hugging motion above upper chest until dumbbells are nearly together.",
			"Lie flat on your back on a narrow bench that allows your shoulders to move freely. Hold the dumbbells and with your arms extended and elbows slightly bend, inhale and lower the dumbbells until your elbows are shoulder height. Exhaling as you raise them back up.",
			"Lying on your back on a incline bench set less then 60 degrees and your feet firmly on the floor for stability, extend your arms upwards. Inhale as you lower the dumbbells to your chest. Exhale as you slowly extend your arms to the starting position.",
			"Sit on machine with back on pad. If available, push foot lever until padded lever moves forward. Place forearms on padded lever. Position upper arms approximately parallel. Release foot lever.  Push levers together. Return until chest muscles are stretched. Repeat.",
			"Grasp two opposing high pulley dumbbell attachments. Stand with pulleys to each side. Bend over slightly by flexing hips and knees. Bend elbows slightly and internally rotate shoulders so elbows are back initially. Bring cable attachments together in hugging motion with elbows in fixed position. Keep shoulders internally rotated so elbows are pointed upward at top and out to sides at bottom. Return to starting position until chest muscles are stretched.",
			"Lie flat on your back with your feet firmly on the floor. Holding a dumbbell in both hands with your palms against the underside of the plates, inhale as you lower the weight behind your head, bending your elbows slightly. Exhaling as you return to the starting position.",
			"Lie flat on your back with your feet firmly on the floor. Hold the barbell in an overhand grip with your hands shoulder-width apart, inhale as you lower the bar behind your head, bending your elbows slightly. Exhaling as you return to the starting position."
	};
	int[] chest_img=new int[]{R.drawable.benchpress,R.drawable.closegripbenchpress,R.drawable.inclinepress,R.drawable.declinepress,R.drawable.pushup,R.drawable.parralelbardips,R.drawable.dumbbellpress,R.drawable.inclinedumbbellflys,R.drawable.dumbbellflys,R.drawable.inclinedumbbellpress,R.drawable.pecdecflys,R.drawable.cablecrossoverflys,R.drawable.dumbbellpullover,R.drawable.barbellpullover};


	public CustomCardMainPageTwoChest (Context context,String[] listData1, int[] imgarray, int i,String workout_name,int no_of_days,int workout_id, int total_days) {
		this(context, R.layout.text_image_layout);
		this.context=context;
		this.i=i;
		this.listData1=listData1;
		this.imgarray=imgarray;
		this.no_of_days=no_of_days;
		this.workout_name=workout_name;
		this.workout_id= workout_id;
		this.total_days=total_days;
	}

	public CustomCardMainPageTwoChest (Context context, int innerLayout) {
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
					strValue=chest_list[0];
					strValue1=chest_img[0];
					strValue2=chest[0];
					break;
				case 1:
					strValue=chest_list[1];
					strValue1=chest_img[1];
					strValue2=chest[1];
					break;
				case 2:
					strValue=chest_list[2];
					strValue1=chest_img[2];
					strValue2=chest[2];
					break;
				case 3:
					strValue=chest_list[3];
					strValue1=chest_img[3];
					strValue2=chest[3];
					break;
				case 4:
					strValue=chest_list[4];
					strValue1=chest_img[4];
					strValue2=chest[4];
					break;
				case 5:
					strValue=chest_list[5];
					strValue1=chest_img[5];
					strValue2=chest[5];
					break;
				case 6:
					strValue=chest_list[6];
					strValue1=chest_img[6];
					strValue2=chest[6];
					break;
				case 7:
					strValue=chest_list[7];
					strValue1=chest_img[7];
					strValue2=chest[7];
					break;
				case 8:
					strValue=chest_list[8];
					strValue1=chest_img[8];
					strValue2=chest[8];
					break;
				case 9:
					strValue=chest_list[9];
					strValue1=chest_img[9];
					strValue2=chest[9];
					break;
				case 10:
					strValue=chest_list[10];
					strValue1=chest_img[10];
					strValue2=chest[10];
					break;
				case 11:
					strValue=chest_list[11];
					strValue1=chest_img[11];
					strValue2=chest[11];
					break;
				case 12:
					strValue=chest_list[12];
					strValue1=chest_img[12];
					strValue2=chest[12];
					break;
				case 13:
					strValue=chest_list[13];
					strValue1=chest_img[13];
					strValue2=chest[13];
					break;
				case 14:
					strValue=chest_list[14];
					strValue1=chest_img[14];
					strValue2=chest[14];
					break;

				}
				mainIntent1 = new Intent(context,Description.class);

				mainIntent1.putExtra("name", strValue);
				mainIntent1.putExtra("desc", strValue2);
				mainIntent1.putExtra("no_of_days", no_of_days);
				mainIntent1.putExtra("workout_id", workout_id);
				mainIntent1.putExtra("workout_name", workout_name);
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

