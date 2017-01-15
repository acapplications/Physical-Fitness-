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

public class CustomCardMainPageTwoTriceps extends Card{
	String[] listData1;
	protected TextView mTitle;
	protected ImageView mImage;
	Intent mainIntent1;
	String strValue;
	int strValue1;
	String strValue2;
	int video;
	int strValue4;
	Context context;
	String workout_name;
	int no_of_days;
	int add_button_check;
	int workout_id;
	int[] imgarray;
	SpannableString s;
	int total_days;
	int i;
	String[] triceps_list= new String[]{"Dumbbell tricep extension", "One arm dumbbell triceps extensions", "One arm reverse pushdowns", "Pushdown", "Reverse pushdowns", "Seated dumbbell triceps extensions", "Seated e-z bar triceps extensions", "Tricep kick back", "Triceps dips", "Triceps extension"};
	String[] triceps=new String[]{"With your arms extended straight above your shoulders, lie on your back with a dumbbell in each hand. Holding the dumbbells parallel to your body, inhale and slowly bend your arms. Keeping are elbows in place throughout the movement. When your forearms are parallel to the bench, return the the starting position as you exhale.",
			"This exercise can be performed both sitting and standing. To begin hold a dumbbell in your hand with your arm extended over your head. Inhale and bend your elbow lowering the dumbbell behind your neck. Exhale as you return to the starting position and complete the movement.",
			"Grasping the handle with an underhand grip, stand and face the machine. Inhale and straighten your arm. Hold the contraction for 2 seconds and exhale. Returning the handle to the starting position in a controlled manner.",
			"With elbows at your side, grab the bar with an overhand and face the machine. Inhale and straighten your arms keeping your elbows at your side. At the end of the movement hold the contraction for 2 seconds and exhale as you complete the movement and return the bar to itself original position in a control manner.",
			"As you face the machine with bar in your hands, flex your elbow against your sides. Being careful not to separate your elbows from your side, inhale and straighten your arms. Exhale as you return the bar to your starting position. The underhand grip doesn't allow you to work with a heavy weight. Perform this a light weight to work the triceps fully and to target the medial head.",
			"Position one dumbbell over head with both hands under inner plate (heart shaped grip). With elbows over head, lower forearm behind upper arm by flexing elbows. Flex wrists at bottom to avoid hitting dumbbell on back of neck. Raise dumbbell over head by extending elbows while hyperextending wrists. Return and repeat.",
			"In a sited position, take an overhand grip on the EZ-bar with your arms extended upward. Inhale and bend at the elbows to lower the bar behind your neck in a controlled manner. Exhaling as you return to the starting position",
			"With your knees slightly flexed, bend forward at the waist keeping your back straight. Holding a dumbbell in one hand, press your upper arm against your side while bending your arm at a 90-degree angle. Inhale a straighten your parallel with your back. Exhale has your completing this movement and then return your arm to the starting position.",
			"You will need two benches or a bench and a chair for this exercise. Place your hands on the edge of one bench and your feet on another. While keeping your back straight, inhale and bend your arms lower your body toward the floor. Straight your arms and raise yourself to the starting point exhaling as you complete the move.",
	"Lie on a flat bench and take an overhand grip on the bar with your arms extended. Inhale and bend your elbows, making sure you don't allow them to flare to the sides. Return to the starting position,exhaling as you complete the movement"};
	int[] triceps_img=new int[]{R.drawable.dumbbelltricepextension,R.drawable.onearmdumbbelltricepsextensions,R.drawable.onearmreversepushdowns,R.drawable.pushdown,R.drawable.reversepushdowns,R.drawable.seateddumbbelltricepsextensions,R.drawable.seatedezbartricepsextensions,R.drawable.tricepkickbackt,R.drawable.tricepsdips,R.drawable.tricepsextension};


	public CustomCardMainPageTwoTriceps(Context context,String[] listData1, int[] imgarray, int i,String workout_name,int no_of_days,int workout_id,int total_days) {
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

	public CustomCardMainPageTwoTriceps(Context context, int innerLayout) {
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
					strValue=triceps_list[0];
					strValue1=triceps_img[0];
					strValue2=triceps[0];
					break;
				case 1:
					strValue=triceps_list[1];
					strValue1=triceps_img[1];
					strValue2=triceps[1];
					break;
				case 2:
					strValue=triceps_list[2];
					strValue1=triceps_img[2];
					strValue2=triceps[2];
					break;
				case 3:
					strValue=triceps_list[3];
					strValue1=triceps_img[3];
					strValue2=triceps[3];
					break;
				case 4:
					strValue=triceps_list[4];
					strValue1=triceps_img[4];
					strValue2=triceps[4];
					break;
				case 5:
					strValue=triceps_list[5];
					strValue1=triceps_img[5];
					strValue2=triceps[5];
					break;
				case 6:
					strValue=triceps_list[6];
					strValue1=triceps_img[6];
					strValue2=triceps[6];
					break;
				case 7:
					strValue=triceps_list[7];
					strValue1=triceps_img[7];
					strValue2=triceps[7];
					break;
				case 8:
					strValue=triceps_list[8];
					strValue1=triceps_img[8];
					strValue2=triceps[8];
					break;
				case 9:
					strValue=triceps_list[9];
					strValue1=triceps_img[9];
					strValue2=triceps[9];
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
