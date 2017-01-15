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


public class CustomCardMainPageTwoBack extends Card{
	String[] listData1;
	protected TextView mTitle;
	protected ImageView mImage;
	Intent mainIntent1;
	String strValue;
	String strValue2;
	String strValue3;
	int video;
	int strValue4;
	Context context;
	int[] imgarray;
	SpannableString s;
	String workout_name;
	int no_of_days;
	int add_button_check;
	int workout_id;
	int total_days;
	int i;
	String[] back=new String[]{"Cross your arms over your chest, pull your abs in, and lower your upper body a few inches by bending forward at the hips. Raise back up, using your lower back, so your body is parallel to the floor. ",
			"Face the machine with your knees under the restraint pads. With a wide overhand grip on the the bar, inhale and lower the bar down behind your neck by bringing your elbows back. Exhale as you return the bar slowly to the starting position.",
			"With an overhand grip on the barbell, over-under for heavy loads, and your hands shoulder-width apart, keep your back straight, contract your abdominals and shrug your shoulders upward and to the rear as high as possible. Hold this position, then return your shoulders to the starting position.",
			"Bending at the torso with your knees slightly flexed, keep your back straight and hold the barbell with an overhand grip with your hands shoulder-width apart. Inhale, contract your abdominal muscles and pull the barbell straight up until it touches your chest. Exhale and return the barbell to the starting position.",
			"Step up and grasp bar with underhand shoulder width grip. Pull body up until elbows are to sides. Lower body until arms and shoulders are fully extended.",
			"Face the machine with your knees under the restraint pads. Gripping the handles with your palms facing each other, inhale and pull the handle down to your upper chest. Make sure you arch your back and tilt  your upper body backward. Exhale as you return the bar slowly to the starting position.",
			"Stand facing the barbell with your feet slightly apart. Keeping your back motionless and slightly arched, flex at the knees until your thighs are almost parallel to the floor. Take and overhand grip on the barbell with your hand shoulder-width apart, inhale, contract your abdominals and lower back, and extend your torso until your reach and standing position with your arms down at your sides, exhaling as you complete the movement. Hold this position for 2 seconds, then return the barbell to the floor, making sure to keep your back straight at all times.",
			"Stand with your feet slightly apart, keeping your head straight and your back slightly arched, hold the dumbbells with your arms extended at your sides. Shrug your shoulders as high and as far back as possible. Hold this position and then return the dumbbells to the starting position.",
			"Face the machine with your knees under the restraint pads. With a wide overhand grip on the the bar, inhale and lower the bar down to your upper chest arching your back by bringing your elbows back. Exhale as you return the bar slowly to the starting position.",
			"With your palms facing in, grab the dumbbell and place your opposite hand on the bench for support. Inhale as you pull the dumbbell up as high as possible, keeping your elbow back. Exhale as you complete the movement and return the dumbbell to the starting position.",
			"Step up and grasp bar with wide overhand grip. Bend knees so partner can assist from behind. Pull body up until chin is just above bar. Lower body until arms and shoulders are fully extended.",
			"Sitting facing the machine with your feet against the foot stops, inhale and arching your back, pull the handle until it touches your lower rib cage. Make sure you bring your elbows as far back as possible pinching your shoulder blades. Exhale as you return to the starting position completing the movement.",
			"Standing with your feet fairly close together with the bar in front of you on the floor. Bend forward at the waist, keeping your back arched and your legs straight as possible, take an over hand grip on the barbell, inhale and straighten your body, flexing at the hips and keeping your back straight. Exhale as you complete the movement and return the barbell back to the floor, keeping your back and legs straight.",
			"Face high pulley and grasp revolving cable attachment with arm slightly bent. Place one foot slightly back and bend over at hip until shoulder is fully flexed (upper arms at sides of head). With elbows fixed approximately 30°, pull cable attachment down until upper arms are to sides. Return attachment overhead. ",
			"Stand facing the bar with your feet place wider than shoulder-width apart. Point your toes outward and keep them in line with your knees. Flexing your knees until they are parallel to the floor and take an overhand grip on the barbell, keeping your arms straight. Inhale, hold your breath, arch your back slightly to keep your shoulders back, contract your abdominals and straighten your legs until your standing erect. Exhale and return the barbell to the floor. ",
			"Stand over the bar, and position a Double D row handle around the bar next to the collar. Using your hips and legs, rise to a standing position. Assume a wide stance with your hips back and your chest up. Your arms should be extended. This will be your starting position. Pull the weight to your upper abdomen by retracting the shoulder blades and flexing the elbows. Do not jerk the weight or cheat during the movement.",
			"Standing with your feet slightly spread apart, take an overhand grip on the barbell with your hands shoulder-width apart. With the barbell resting on your thighs and your back straight, inhale and pull the barbell upward till it reaches your chin. Slowly return the bar to the starting position as you exhale. Try to make the return a smooth of a motion as possible."
	};
	int[] back_img=new int[]{R.drawable.backextensions,R.drawable.backlatpulldown,R.drawable.barbellshrugs,R.drawable.bentrow,R.drawable.chinups,R.drawable.closegriplatpulldown,R.drawable.deadlift,R.drawable.dumbbellshrug,R.drawable.latpulldown,R.drawable.onearmdumbbellrow,
			R.drawable.reversechinups,R.drawable.seatedrows,R.drawable.stiffleggeddeadlift,R.drawable.straightarmpulldown,R.drawable.sumodeadlift,R.drawable.tbarrows,R.drawable.uprightrow};

	String[] back_list= new String[]{"Back Extensions", "Back Lat Pull Down", "Barbell Shrugs", "Bent Rows", "Chin-ups", "Close Grip Lat Pull Down", "Deadlift", "Dumbbell Shrugs", "Lat Pull Down", "One Arm Dumbbell Row", "Reverse Chin-ups", "Seated Rows", "Stiff Legged Deadlift", "Straight Arm Pull Down", "Sumo Deadlift", "T-bar Rows", "Upright Rows"};


	public CustomCardMainPageTwoBack(Context context,String[] listData1, int[] imgarray, int i,String workout_name,int no_of_days,int workout_id, int total_days) {
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

	public CustomCardMainPageTwoBack(Context context, int innerLayout) {
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
					strValue=back_list[0];
					strValue3=back[0];
					strValue4=back_img[0];
					break;
				case 1:
					strValue=back_list[1];
					strValue3=back[1];
					strValue4=back_img[1];
					break;
				case 2:
					strValue=back_list[2];
					strValue3=back[2];
					strValue4=back_img[2];
					break;		
				case 3:
					strValue=back_list[3];
					strValue3=back[3];
					strValue4=back_img[3];
					break;		
				case 4:
					strValue=back_list[4];
					strValue3=back[4];
					strValue4=back_img[4];
					break;		
				case 5:
					strValue=back_list[5];
					strValue3=back[5];
					strValue4=back_img[5];
					break;	
				case 6:
					strValue=back_list[6];
					strValue3=back[6];
					strValue4=back_img[6];
					break;			
				case 7:
					strValue=back_list[7];
					strValue3=back[7];
					strValue4=back_img[7];
					break;			
				case 8:
					strValue=back_list[8];
					strValue3=back[8];
					strValue4=back_img[8];
					break;	
				case 9:
					strValue=back_list[9];
					strValue3=back[9];
					strValue4=back_img[9];
					break;	
				case 10:
					strValue=back_list[10];
					strValue3=back[10];
					strValue4=back_img[10];
					break;			
				case 11:
					strValue=back_list[11];
					strValue3=back[11];
					strValue4=back_img[11];
					break;				
				case 12:
					strValue=back_list[12];
					strValue3=back[12];
					strValue4=back_img[12];
					break;	
				case 13:
					strValue=back_list[13];
					strValue3=back[13];
					strValue4=back_img[13];
					break;	
				case 14:
					strValue=back_list[14];
					strValue3=back[14];
					strValue4=back_img[14];
					break;	
				case 15:
					strValue=back_list[15];
					strValue3=back[15];
					strValue4=back_img[15];
					break;			
				case 16:
					strValue=back_list[16];
					strValue3=back[16];
					strValue4=back_img[16];
					break;
				}
				mainIntent1 = new Intent(context,Description.class);
				mainIntent1.putExtra("desc", strValue3);
				mainIntent1.putExtra("pic", strValue4);
				mainIntent1.putExtra("workout_name", workout_name);
				mainIntent1.putExtra("no_of_days", no_of_days);
				mainIntent1.putExtra("name", strValue);
				mainIntent1.putExtra("workout_id", workout_id);
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
