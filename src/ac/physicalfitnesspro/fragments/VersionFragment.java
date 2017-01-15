package ac.physicalfitnesspro.fragments;

import ac.physicalfitnesspro.R;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class VersionFragment extends Fragment {

	ActionBar actionBar;
	Activity activity;
	TextView version;
	SharedPreferences sharedPreferences;
	Editor editor;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView= inflater.inflate(R.layout.activity_version, container, false);

		activity=getActivity();
		sharedPreferences = activity.getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
		editor = sharedPreferences.edit();
		editor.putInt("at_home", 0);
		editor.commit();
		sharedPreferences = activity.getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
		editor = sharedPreferences.edit();
		editor.putInt("at_home", 0);
		editor.commit();

		Typeface typeFace=Typeface.createFromAsset(activity.getAssets(),"fonts/Roboto-Medium.ttf");
		version=(TextView)rootView.findViewById(R.id.version_number);
		version.setTypeface(typeFace);
		version.setTextSize(25);

		return rootView;
	}
}