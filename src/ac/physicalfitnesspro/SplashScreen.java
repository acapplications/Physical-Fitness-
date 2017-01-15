package ac.physicalfitnesspro;

import ac.physicalfitnesspro.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;


public class SplashScreen extends Activity {

	Context context;
	ActionBar actionBar;
	SharedPreferences sharedPreferences;
	Editor editorr;
	Editor editorw;
	static String loginDate="";
	int check;
	int year;
	int month;
	int day;
	int add_button_check;
	private final int SPLASH_DISPLAY_LENGTH = 3000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_splash_screen);
		
		context=getApplicationContext();
		sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
		Editor editor = sharedPreferences.edit();
		editor.putInt("check_back_total", 0);
		editor.putInt("add_button", 0);
		editor.commit();
		

		new Handler().postDelayed(new Runnable(){
			@Override
			public void run() {
				Intent mainIntent = new Intent(context,PhysicalSchedule.class);
				SplashScreen.this.startActivity(mainIntent);
				SplashScreen.this.finish();

			}
		}, SPLASH_DISPLAY_LENGTH);
	}
}