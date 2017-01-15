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


public class CustomCardMainPageTwoButtocks extends Card{
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
	int[] imgarray;
	SpannableString s;
	String workout_name;
	int no_of_days;
	int add_button_check;
	int workout_id;
	int i;
	int total_days;
	String[] buttocks_list= new String[]{"Bridging", "Cable Back Kick", "Cable Hip Adductions", "Floor Hip Adductions", "Floor Hip Extensions", "Lunges", "Machine Hip Extensions", "Seated Machine Hip Adductions", "Standing Machine Hip Adductions"};
	String[] buttocks=new String[]{"Lie on a floor mat with your entire spine in contact with the floor. Place your hands on the floor next to your hips. Flex your knees 90 degrees. Lift your buttocks off the floor as high as you can, pushing with your feet. Hold the position for 2 seconds feeling the muscle contraction, then lower your pelvis without putting your buttocks back on the floor.",
			"Attach the cuff to the cable running through the low pulley. Fasten the cuff around your ankle. Stand in front of the machine grasping the edge for support. Inhale, tilt your pelvis forward and bring your leg back. Exhale as you return your leg to the starting position.",
			"Attach a low pulley to your ankle. Grasp the edge of the machine with your opposite hand to stabilize your body. Raise your leg laterally as far as you can. Return your leg to the starting position.",
			"Lying on your side lift your leg to an angle of 70 degrees or less, keeping your knee extended and your leg straight. Hold a peak contraction for a couple of seconds at the top of the movement. Lower your leg to the starting position and repeat.",
			"Kneel on one leg with elbows or hands on the floor and your forearms straight. Tuck your opposite leg under your chest. Move your tucked leg to the rear until your hip is fully extended. Hold a peak contraction at the end of the movement for a couple of seconds and then return to the starting position.",
			"Stand with you feet hip-width apart. Lift the barbell up and position it across your shoulders behind your neck. Inhale and take a comfortable step forward, keeping your torso upright and straight as possible. At the bottom of this movement your forward thigh should be slightly below parallel. Exhale and return to the starting position.",
			"Stand on platform facing to one side and grasp bar for support. Place leg nearest machine on padded roller while standing on other leg. Lower lever by extending hip. Return until knee is higher than hip. Repeat. Continue with opposite leg.",
			"Sit on machine with legs inside of side pads. If available, place heels on foot bars. Release and pull lever brace to position legs together. Engage lever into locked position. Lie back and grasp bars to sides. Move legs apart as far as possible. Return and repeat.",
			"Adjust platform so lever fulcrum is same height as hip articulation. Adjust roller in low position. Face machine and grasp bars to sides. Place outside of thigh against roller pad and shift body weight to opposite leg. Raise leg against roller pad to side by abduction hip. Return and repeat. Reposition roller pad lever and continue with opposite leg."
	};
	int[] buttocks_img=new int[]{R.drawable.bridging,R.drawable.ablebakkiks,R.drawable.cablebackkick,R.drawable.cablehipabductions,R.drawable.floorhipabductions,R.drawable.floorhipextensions,R.drawable.lunges,R.drawable.machinehipextensions,R.drawable.seatedmachinehipabductions,R.drawable.standingmachinehipabductions};


	public CustomCardMainPageTwoButtocks(Context context,String[] listData1, int[] imgarray, int i,String workout_name,int no_of_days,int workout_id, int total_days) {
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

	public CustomCardMainPageTwoButtocks(Context context, int innerLayout) {
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
					strValue=buttocks_list[0];
					strValue1=buttocks_img[0];
					strValue2=buttocks[0];
					break;
				case 1:
					strValue=buttocks_list[1];
					strValue1=buttocks_img[1];
					strValue2=buttocks[1];
					break;
				case 2:
					strValue=buttocks_list[2];
					strValue1=buttocks_img[2];
					strValue2=buttocks[2];
					break;
				case 3:
					strValue=buttocks_list[3];
					strValue1=buttocks_img[3];
					strValue2=buttocks[3];
					break;
				case 4:
					strValue=buttocks_list[4];
					strValue1=buttocks_img[4];
					strValue2=buttocks[4];
					break;
				case 5:
					strValue=buttocks_list[5];
					strValue1=buttocks_img[5];
					strValue2=buttocks[5];
					break;
				case 6:
					strValue=buttocks_list[6];
					strValue1=buttocks_img[6];
					strValue2=buttocks[6];
					break;
				case 7:
					strValue=buttocks_list[7];
					strValue1=buttocks_img[7];
					strValue2=buttocks[7];
					break;
				case 8:
					strValue=buttocks_list[8];
					strValue1=buttocks_img[8];
					strValue2=buttocks[8];
					break;

				}
				mainIntent1 = new Intent(context,Description.class);

				mainIntent1.putExtra("name", strValue);
				mainIntent1.putExtra("desc", strValue2);
				mainIntent1.putExtra("pic", strValue1);
				mainIntent1.putExtra("workout_name", workout_name);
				mainIntent1.putExtra("no_of_days", no_of_days);
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
