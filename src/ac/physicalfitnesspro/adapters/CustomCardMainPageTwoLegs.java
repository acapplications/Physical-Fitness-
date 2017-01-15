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


public class CustomCardMainPageTwoLegs extends Card{
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
	String workout_name;
	int no_of_days;
	int add_button_check;
	int workout_id;
	int total_days;
	SpannableString s;
	int i;
	String[] legs_list= new String[]{"Angled leg press", "Cable adduction", "Donkey calf raises", "Dumbbell squats", "Front squat", "Good morning", "Hack squat", "Leg extensions", "Lying leg curls","Machine adductions", "One leg toe raises", "Power squats", "Seated barbell calf raises", "Seated calf raises", "Seated leg curl", "Squat", "Standing calf raises", "Standing leg curl"};
	String[] legs=new String[]{"Sit on machine with back on padded support. Place feet on platform. Extend hips and knees. Release dock lever and grasp handles to sides. Lower sled by flexing hips and knees until knees are just short of complete flexion. Return by extending knees and hips.",
			"Fasten the cuff to your ankle and hold on to a stationary object if needed for support. Inhale as you bring your leg with the attached cuff toward and then across your other leg. Exhale and return to the starting position",
			"Stand on edge of platform, toes and balls of feet on calf block with arches and heels extending off. Bend over and grasp knee high bar (as shown) or place forearms on thigh high surface. Allow training partner to mount hips or lower back from bench. Raise heels by extending ankles as high as possible. Lower heels by bending ankles until calves are stretched. ",
			"Stand with your feet slightly apart, grasping a dumbbell in each hand with your arms hanging down at your sides. Looking straight ahead, inhale, arch your back, and squat down bringing your thighs parallel to the floor. Exhale as you straighten your legs to return to the starting position",
			"Position the barbell across your anterior deltoid muscles, holding your upper arms parallel to the floor. Bend your elbows, grasp the barbell and look straight ahead. Inhale as you squat down and exhale as you return to the starting position.",
			"Standing with your feet slightly apart, rest a barbell across your back between your trap and deltoid muscles. Inhale and bend forward at the waist until your torso is roughly parallel to the floor. Return to the starting position as you exhale",
			"Position barbell just behind legs. With feet flat on floor, squat down and grasp barbell from behind with overhand grip. Lift bar by extending hips and knees to full extension. Squat down by bending hips back while allowing knees to bend forward, keeping back straight and knees pointed same direction as feet. Descend until thighs are close to parallel to floor and bar is behind lower leg. ",
			"As you sit on the machine grasp either the handles or the edge of the seat to steady your body throughout the movement. Bend your knees and place your ankles under the roller pads. Inhale and raise your legs until they are parallel to the floor. Exhale as you complete the movement.",
			"Facing bench, stand between bench and lever pads. Lie prone on bench with knees just beyond edge of bench and lower legs under lever pads. Grasp handles. Raise lever pad to back of thighs by flexing knees. Lower lever pads until knees are straight. ",
			"Sit and position yourself so that the inner legs are pressing on the pads. Squeeze the legs together until they meet (the left leg component of the machine should gently touch the right leg component of the machine in the center). In a controlled manner, move the legs apart, thereby returning to the starting position.",
			"Position toes and balls of feet on calf block or elevation with heels and arches extending off. Place hand or hands on support for balance. Lift one leg to rear by bending knee. Raise heel by extending ankle as high as possible. Lower heel by bending ankle until calf is stretched. Repeat. Continue with opposite leg.",
			"Place the barbell on a squat rack and duck under the bar, positioning it across your shoulders on the trapezius muscles, slightly above the deltoids. Grasp the bar and pull your elbows to the rear. Inhale deeply and slightly arch your back by rotating your pelvis forward. Look straight ahead and lift the bar off the rack. Move back a step or two and set your legs widely apart with your toes pointing outward, which will place emphasis on the muscles of your inner thigh. Slowly bend your knees as you squat with your back bent slightly forward. Once your thighs are parallel to the floor, extend your legs and straighten your torso, exhaling as you return to the starting position.",
			"Sitting on a bench with your toes and balls of your feet resting on a toe block with a barbell resting across your lower thighs. Push down with your toes and extend your feet as much as possible. Hold, then return to the starting position.",
			"Sit on seat facing lever. Reach forward and pull hand lever toward body. Place forefeet on platform with heels extending off. Position lower thighs under lever pads. Release hand lever by pushing away from body. Place hands on top of thigh pads. Raise heels by extending ankles as high as possible. Lower heels by bending ankles until calves are stretched. ",
			"Sit on apparatus with back against padded back support. Place back of lower leg on top of padded lever. Secure lap pad against thigh just above knees. Grasp handles on lap support. Pull lever to back of thighs by flexing knees. Return lever until knees are straight.",
			"Stand with your feet shoulder width apart. You can place your hands behind your head. This will be your starting position. Begin the movement by flexing your knees and hips, sitting back with your hips. Continue down to full depth if you are able,and quickly reverse the motion until you return to the starting position. As you squat, keep your head and chest up and push your knees out.",
			"Set barbell on power rack upper chest height with calf block under barbell. Position back of shoulders under barbell with both hands to sides. Position toes and balls of feet on calf block with arches and heels extending off. Lean barbell against rack and raise from supports by extending knees and hips. Support barbell against verticals with both hands to sides. Raise heels by extending ankles as high as possible. Lower heels by bending ankles until calves are stretched.",
			"Attach foot harness to low pulley. With foot harness on one ankle, grasp support bar with both hands and step back with other foot. Elbows remain straight to support body. Attached foot is slightly off floor. Pull cable attachment back by flexing knee until knee is fully flexed. Return by straightening knee to original position and repeat. Continue with opposite leg."

	};
	int[] legs_img= new int[]{R.drawable.angledlegpress,R.drawable.cableadduction,R.drawable.donkeycalfraises,R.drawable.dumbbellsquats,R.drawable.frontsquat,R.drawable.goodmorning,R.drawable.hacksquat,R.drawable.legextensions,R.drawable.lyinglegcurl,R.drawable.machineadductions,R.drawable.onelegtoeraises,R.drawable.powersquats,R.drawable.seatedbarbellcalfraises,R.drawable.seatedcalfraise,R.drawable.seatedlegcurl,R.drawable.squat,R.drawable.standingcalfraises,R.drawable.standinglegcurl};


	public CustomCardMainPageTwoLegs(Context context,String[] listData1, int[] imgarray, int i,String workout_name,int no_of_days,int workout_id, int total_days) {
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

	public CustomCardMainPageTwoLegs(Context context, int innerLayout) {
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
					strValue=legs_list[0];
					strValue1=legs_img[0];
					strValue2=legs[0];
					break;
				case 1:
					strValue=legs_list[1];
					strValue1=legs_img[1];
					strValue2=legs[1];
					break;
				case 2:
					strValue=legs_list[2];
					strValue1=legs_img[2];
					strValue2=legs[2];
					break;
				case 3:
					strValue=legs_list[3];
					strValue1=legs_img[3];
					strValue2=legs[3];
					break;
				case 4:
					strValue=legs_list[4];
					strValue1=legs_img[4];
					strValue2=legs[4];
					break;
				case 5:
					strValue=legs_list[5];
					strValue1=legs_img[5];
					strValue2=legs[5];
					break;
				case 6:
					strValue=legs_list[6];
					strValue1=legs_img[6];
					strValue2=legs[6];
					break;
				case 7:
					strValue=legs_list[7];
					strValue1=legs_img[7];
					strValue2=legs[7];
					break;
				case 8:
					strValue=legs_list[8];
					strValue1=legs_img[8];
					strValue2=legs[8];
					break;
				case 9:
					strValue=legs_list[9];
					strValue1=legs_img[9];
					strValue2=legs[9];
					break;
				case 10:
					strValue=legs_list[10];
					strValue1=legs_img[10];
					strValue2=legs[10];
					break;
				case 11:
					strValue=legs_list[11];
					strValue1=legs_img[11];
					strValue2=legs[11];
					break;
				case 12:
					strValue=legs_list[12];
					strValue1=legs_img[12];
					strValue2=legs[12];
					break;
				case 13:
					strValue=legs_list[13];
					strValue1=legs_img[13];
					strValue2=legs[13];
					break;
				case 14:
					strValue=legs_list[14];
					strValue1=legs_img[14];
					strValue2=legs[14];
					break;
				case 15:
					strValue=legs_list[15];
					strValue1=legs_img[15];
					strValue2=legs[15];
					break;
				case 16:
					strValue=legs_list[16];
					strValue1=legs_img[16];
					strValue2=legs[16];
					break;
				case 17:
					strValue=legs_list[17];
					strValue1=legs_img[17];
					strValue2=legs[17];
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

