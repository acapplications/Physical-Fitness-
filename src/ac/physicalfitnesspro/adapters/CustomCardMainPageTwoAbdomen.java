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



public class CustomCardMainPageTwoAbdomen extends Card{
	String[] listData1;
	protected TextView mTitle;
	protected ImageView mImage;
	Intent mainIntent1;
	String strValue;
	int strValue1;
	String strValue2;

	String workout_name;
	int no_of_days;
	int add_button_check;
	int workout_id;
	int total_days;

	Context context;
	int[] imgarray;
	SpannableString s;
	int i;
	String[] abdomen_list=new String[]{"Broom Stick Twist","Calves Over Bench Sit-ups", "Crunches", "Dumbbell Side Bends", "Gym Ladder Sit-up", "Hanging Leg Raises", "High Pulley Crunches", "Incline Bench Sit-ups", "Incline Leg Raises", "Leg Raises", "Machine Crunches", "Machine Trunk Rotations", "Roman Chair Side Bends", "Sit-ups"};
	String[] abdomen= new String[]{"With your feet spread apart, hold a broomstick or barbell across your trapezius, above the deltoids. Make sure you don't pull or hang on to the stick. Rotate your upper body from side to side, keeping your hips as motionless as possible throughout the movement.",
			"Lying on your back with your hands behind your hand and your calves laying over a flat exercise bench. Inhale and curl your shoulders off the floor. Try to touch or knees with your head. Exhale as you complete the movement.",
			"Lying on your back with your hands behind your hand and your hips and knees flexed to a 90 degree angle, inhale and lift your shoulders off the floor, moving your knees closer to your head and shortening your torso. Exhale as you complete the movement.",
			"With your feet slightly apart, place your hand behind your head, hold the dumbbell in the other hand. Bend at the torso to the opposite side as the dumbbell. Return to the starting position",
			"Hook your feet on the ladder with knee and hips flexed 90 degrees. Your hand behind your head. Inhale and curl your torso as high as possible off the floor. Exhale as complete the movement",
			"Grasp and hang from high bar with slightly wider than shoulder width overhand grip. Raise legs by flexing hips and knees until hips are completely flexed or knees are well above hips. Return until hips and knees are extended downward. Repeat.",
			"Seat on a flat bench with your back facing a high pulley. Grasp the cable rope attachment with both hands (with the palms of the hands facing each other) and place your hands securely over both shoulders. With the hips stationary, flex the waist so the elbows travel toward the hips.",
			"Lie back on an incline board set at an angle of your choosing. Hook your feet under the pad to secure your body. Keep your knees slightly bent. You can either place your hands behind your head or crossed in front of your body. Slowly curl your body upwards to your knees and slowly descend back down. Repeat. Keep the movement fluent, slow, and controlled.",
			"Lie down on the sit-up bench in the reverse direction, i.e. with your head up, and hold the padded knee bar firmly with both hands, reaching above your head for it. With the knees slightly bent, raise your legs up and then your hips until you reach a perpendicular position to the floor.",
			"Rest your elbows on the elbow support pads and position the lumbar support pad in the small of your back. Inhale and pull your knees up into your chest, rounding your back to contract your abdominal muscles. Exhale as you complete the movement",
			"Select a light resistance and sit down on the ab machine placing your feet under the pads provided and grabbing the top handles. Your arms should be bent at a 90 degree angle as you rest the triceps on the pads provided. At the same time, begin to lift the legs up as you crunch your upper torso. Breathe out as you perform this movement. ",
			"Stand on the swivel plate and hold the handle. Twist your hips from one side to the other being sure to keep your shoulders stationary throughout the movement. Bend your knees slightly, making sure you perform this movement under control.",
			"Position yourself sideways on the Roman chair and hook your feet underneath the foot bar. Start with your torso parallel to the ground. (Note: This exercise is uncomfortable for some people with pre-existing back pain. Do not perform this if you feel any discomfort.",
			"Lying on your back with your hands behind your hand and your feet on the floor, inhale and curl your torso off the floor. Exhale as you complete the movement."
	};
	int[] abdomen_img=new int[]{R.drawable.broomsticktwist,R.drawable.calvesoverbenchsitups,R.drawable.crunch,R.drawable.dumbbellsidebend,R.drawable.gymladdersitup,R.drawable.hanginglegraise,R.drawable.highpulleycrunches,R.drawable.inclinebenchsitups,R.drawable.inclinelegraises,
			R.drawable.legraises,R.drawable.machinecrunches,R.drawable.machinetrunkrotation,R.drawable.romanchairsidebends,R.drawable.situps};


	public CustomCardMainPageTwoAbdomen(Context context,String[] listData1, int[] imgarray, int i,String workout_name,int no_of_days,int workout_id, int total_days) {
		this(context, R.layout.text_image_layout);
		this.context=context;
		this.i=i;
		this.listData1=listData1;
		this.imgarray=imgarray;
		this.workout_name=workout_name;
		this.no_of_days=no_of_days;
		this.workout_id= workout_id;
		this.total_days=total_days;
	}

	public CustomCardMainPageTwoAbdomen(Context context, int innerLayout) {
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
					strValue=abdomen_list[0];
					strValue1=abdomen_img[0];
					strValue2=abdomen[0];
					break;
				case 1:
					strValue=abdomen_list[1];
					strValue1=abdomen_img[1];
					strValue2=abdomen[1];
					break;
				case 2:
					strValue=abdomen_list[2];
					strValue1=abdomen_img[2];
					strValue2=abdomen[2];
					break;
				case 3:
					strValue=abdomen_list[3];
					strValue1=abdomen_img[3];
					strValue2=abdomen[3];
					break;
				case 4:
					strValue=abdomen_list[4];
					strValue1=abdomen_img[4];
					strValue2=abdomen[4];
					break;
				case 5:
					strValue=abdomen_list[5];
					strValue1=abdomen_img[5];
					strValue2=abdomen[5];
					break;
				case 6:
					strValue=abdomen_list[6];
					strValue1=abdomen_img[6];
					strValue2=abdomen[6];
					break;
				case 7:
					strValue=abdomen_list[7];
					strValue1=abdomen_img[7];
					strValue2=abdomen[7];
					break;
				case 8:
					strValue=abdomen_list[8];
					strValue1=abdomen_img[8];
					strValue2=abdomen[8];
					break;
				case 9:
					strValue=abdomen_list[9];
					strValue1=abdomen_img[9];
					strValue2=abdomen[9];
					break;
				case 10:
					strValue=abdomen_list[10];
					strValue1=abdomen_img[10];
					strValue2=abdomen[10];
					break;
				case 11:
					strValue=abdomen_list[11];
					strValue1=abdomen_img[11];
					strValue2=abdomen[11];
					break;
				case 12:
					strValue=abdomen_list[12];
					strValue1=abdomen_img[12];
					strValue2=abdomen[12];
					break;
				case 13:
					strValue=abdomen_list[13];
					strValue1=abdomen_img[13];
					strValue2=abdomen[13];
					break;
				}
				mainIntent1 = new Intent(context,Description.class);
				System.out.println(workout_name+"  "+no_of_days+" "+ workout_name+"  name");
				mainIntent1.putExtra("name", strValue);
				mainIntent1.putExtra("desc", strValue2);
				mainIntent1.putExtra("workout_name", workout_name);
				mainIntent1.putExtra("no_of_days", no_of_days);
				mainIntent1.putExtra("workout_id", workout_id);
				mainIntent1.putExtra("total_days",total_days);
				mainIntent1.putExtra("pic", strValue1);
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
