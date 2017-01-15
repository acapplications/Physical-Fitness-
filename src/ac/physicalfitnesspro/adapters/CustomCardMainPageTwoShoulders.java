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


public class CustomCardMainPageTwoShoulders extends Card{
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
	String[] shoulders_list= new String[]{"Back press", "Barbell front raises", "Barbell upright row", "Bent over lateral raises", "Dumbbell press", "Front press", "Front raises", "Lateral raises", "Low pulley bent over lateral raises", "Low pulley lateral raises", "one arm dumbbell press", "One dumbbell front raises", "Side lying lateral raises"};
	String[] shoulders=new String[]{"Sitting on a bench or standing with your back straight, grasp a barbell with an overhand grip and rest it across your shoulders behind your neck. Inhale as you press the barbell directly above your head without arching your back. Exhale as you return the barbell to your starting position.",
			"With your legs slightly spread, take an overhand grip on the barbell and rest it on your thighs. Keeping your back straight and your abdominals contracted, inhale and raise the barbell forward to shoulder height. Exhale and complete the movement by returning to the starting position.",
			"Standing with your feet slightly spread apart, take an overhand grip on the barbell with your hands shoulder-width apart. With the barbell resting on your thighs and your back straight, inhale and pull the barbell upward till it reaches your chin. Slowly return the bar to the starting position as you exhale. Try to make the return a smooth of a motion as possible",
			"Stand with your feet spread apart and your knees slightly bent. Bend forward at the waist being careful to keep your back straight. Hold the dumbbells in front of you with your elbows slightly bent. Inhale and raise the weights to your sides. Exhale as you complete the movement.",
			"As you sit on the bench, grasp two dumbbells with your palms facing toward each other and lift them to your shoulders. Inhale and press your arms upwards exhaling as you complete the movement.",
			"Sit or stand with your back straight. With an overhand grip on the barbell, let the bar rest on your upper chest. Inhale and press the barbell straight up, exhaling at the top of the movement.",
			"Stand with your feet slightly apart holding the dumbbells in and overhand grip. With the dumbbells resting on your thighs, inhale and raise the dumbbells to shoulder height. Exhale as you complete the movement.",
			"Stand with your feet slightly spread apart. Keeping your back straight and let your arms hang at your sides. Raise the dumbbells level with your shoulder, keeping your elbows slightly bent. In a controlled manner, return the weights to your starting position.",
			"Stand with your feet spread apart and your knees slightly bent. Bend forward at the waist being careful to keep your back straight. Hold the pulley handle in front of you with your elbows slightly bent. Inhale and pull to your sides. Exhale as you complete the movement.",
			"Grasping the handle with your arm at your side, inhale and raise your arm to shoulder height. Complete the movement by returning to the starting position as you exhale.",
			"Sitting on a bench, grasp your dumbbells with an underhand grip and lift them to your shoulders. Inhale and raise your arms one at a time to an extended position. Rotate your wrist forward as you complete the movement and exhale.",
			"Stand with your feet slightly apart holding the dumbbell in and overhand grip. With the dumbbells resting on your thigh, inhale and raise the dumbbell to shoulder height. Exhale as you complete the movement.",
	"On a bench, lie on your side holding a dumbbell with an overhand grip. Inhale and raise your arm. Exhale and return your arm to the starting position."};
	int[] shoulders_img=new int[]{R.drawable.backpress,R.drawable.barbellfrontraise,R.drawable.barbelluprightrow,R.drawable.bentoverlateralraise,R.drawable.dubbellpress,R.drawable.frontpress1,R.drawable.frontraises,R.drawable.lateralraise,R.drawable.lowpulleybentoerlateralraises,R.drawable.lowpulleylateralraises,R.drawable.oneardubbellpress,R.drawable.onedubbellfrontraises,R.drawable.sidelyinglateralraises};


	public CustomCardMainPageTwoShoulders(Context context,String[] listData1, int[] imgarray, int i,String workout_name,int no_of_days,int workout_id,int total_days) {
		this(context, R.layout.text_image_layout);
		this.context=context;
		this.i=i;
		this.listData1=listData1;
		this.imgarray=imgarray;
		this.no_of_days=no_of_days;
		this.workout_id= workout_id;
		this.workout_name=workout_name;
		this.total_days=total_days;
	}

	public CustomCardMainPageTwoShoulders(Context context, int innerLayout) {
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
					strValue=shoulders_list[0];
					strValue1=shoulders_img[0];
					strValue2=shoulders[0];
					break;
				case 1:
					strValue=shoulders_list[1];
					strValue1=shoulders_img[1];
					strValue2=shoulders[1];
					break;
				case 2:
					strValue=shoulders_list[2];
					strValue1=shoulders_img[2];
					strValue2=shoulders[2];
					break;
				case 3:
					strValue=shoulders_list[3];
					strValue1=shoulders_img[3];
					strValue2=shoulders[3];
					break;
				case 4:
					strValue=shoulders_list[4];
					strValue1=shoulders_img[4];
					strValue2=shoulders[4];
					break;
				case 5:
					strValue=shoulders_list[5];
					strValue1=shoulders_img[5];
					strValue2=shoulders[5];
					break;
				case 6:
					strValue=shoulders_list[6];
					strValue1=shoulders_img[6];
					strValue2=shoulders[6];
					break;
				case 7:
					strValue=shoulders_list[7];
					strValue1=shoulders_img[7];
					strValue2=shoulders[7];
					break;
				case 8:
					strValue=shoulders_list[8];
					strValue1=shoulders_img[8];
					strValue2=shoulders[8];
					break;
				case 9:
					strValue=shoulders_list[9];
					strValue1=shoulders_img[9];
					strValue2=shoulders[9];
					break;
				case 10:
					strValue=shoulders_list[10];
					strValue1=shoulders_img[10];
					strValue2=shoulders[10];
					break;
				case 11:
					strValue=shoulders_list[11];
					strValue1=shoulders_img[11];
					strValue2=shoulders[11];
					break;
				case 12:
					strValue=shoulders_list[12];
					strValue1=shoulders_img[12];
					strValue2=shoulders[12];
					break;
				case 13:
					strValue=shoulders_list[13];
					strValue1=shoulders_img[13];
					strValue2=shoulders[13];
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

