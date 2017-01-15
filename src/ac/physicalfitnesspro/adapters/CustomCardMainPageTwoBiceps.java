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



public class CustomCardMainPageTwoBiceps extends Card{
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
	int i;
	String workout_name;
	int no_of_days;
	int add_button_check;
	int workout_id;
	int total_days;
	String[] biceps_list= new String[]{"Barbell Curl", "Concentration Curl", "Curl Biceps", "Hammer Curls", "High Pulley Curls", "Low Pulley Curls", "Machine Curls", "Reverse Curls"};
	String[] biceps=new String[]{"Keeping your back straight, take an underhand grip on the bar with your hands slightly more than shoulder width apart. Inhale as you curl the barbell up towards your chest. Contract your gluteal, abdominal and back muscles to avoid too much swing in your torso. Exhale as you complete the movement.",
			"Sit on a bench. Rest your elbow on your inside of your thigh. Hold the dumbbell with an underhand grip. Inhale and curl the dumbbell, exhaling and squeeze the bicept at the top of the movement. Return the bar to the starting position in a slow and controlled manner.",
			"Hold a dumbbell in each hand and stand with your feet as wide apart as your hips. Let your arms hang down at your sides with your palms forward. Pull your abdominals in, stand tall, and keep your knees slightly bent. Curl both arms upward until they’re in front of your shoulders. Slowly lower the dumbbells back down.",
			"This exercise can be done either from a sitting or standing position. Start with the dumbbell grasped in each hand with your palms facing inward. Inhale and curl the dumbbell to your shoulders (you can lift both at the same time or alternate). Exhale as you complete the movement.",
			"Stand between the two pulleys and gasp the high pulley handles in an underhand grip. Inhale and curl the handles toward your head. Exhaling as you complete the movement. Return to the starting position in a controlled manner.",
			"Grasping the handle with an underhand grip, stand and face the machine. Inhale ans you curl the pulley handle. Exhale as you complete the movement and return to the starting position in a controlled manner.",
			"Adjust the seat to the appropriate height and make your weight selection. Place your upper arms against the pads and grasp the handles. This will be your starting position. Perform the movement by flexing the elbow, pulling your lower arm towards your upper arm. Pause at the top of the movement, and then slowly return the weight to the starting position. Avoid returning the weight all the way to the stops until the set is complete to keep tension on the muscles being worked.",
			"With your feet slightly apart and your arms straight, grasp the bar with an overhand grip with your thums toward each other. Inhale and curl the bar, exhaling as you complete the movement"
	};
	int[] biceps_img=new int[]{R.drawable.barbellcurle,R.drawable.concentrationcurl,R.drawable.curlbiceps,R.drawable.hammercurls,R.drawable.highpulleycurl,R.drawable.lowpuleycurl,R.drawable.machinecurl,R.drawable.reversecurls};


	public CustomCardMainPageTwoBiceps(Context context,String[] listData1, int[] imgarray, int i,String workout_name,int no_of_days,int workout_id,int total_days) {
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

	public CustomCardMainPageTwoBiceps(Context context, int innerLayout) {
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
					strValue=biceps_list[0];
					strValue1=biceps_img[0];
					strValue2=biceps[0];
					break;
				case 1:
					strValue=biceps_list[1];
					strValue1=biceps_img[1];
					strValue2=biceps[1];
					break;
				case 2:
					strValue=biceps_list[2];
					strValue1=biceps_img[2];
					strValue2=biceps[2];
					break;
				case 3:
					strValue=biceps_list[3];
					strValue1=biceps_img[3];
					strValue2=biceps[3];
					break;
				case 4:
					strValue=biceps_list[4];
					strValue1=biceps_img[4];
					strValue2=biceps[4];
					break;
				case 5:
					strValue=biceps_list[5];
					strValue1=biceps_img[5];
					strValue2=biceps[5];
					break;
				case 6:
					strValue=biceps_list[6];
					strValue1=biceps_img[6];
					strValue2=biceps[6];
					break;
				case 7:
					strValue=biceps_list[7];
					strValue1=biceps_img[7];
					strValue2=biceps[7];
					break;
				case 8:
					strValue=biceps_list[8];
					strValue1=biceps_img[8];
					strValue2=biceps[8];
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
