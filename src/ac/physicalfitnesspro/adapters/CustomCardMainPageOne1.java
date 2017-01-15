package ac.physicalfitnesspro.adapters;


import it.gmariotti.cardslib.library.internal.Card;

import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.TypefaceSpan;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomCardMainPageOne1 extends Card  {
	String listData1;
	protected TextView mTitle;
	protected ImageView mImage;
	Intent mainIntent1;
	Context context;
	int imgarray;
	SpannableString s;

	public CustomCardMainPageOne1(Context context,String listData1, int imgarray) {
		this(context, R.layout.image_text_layout);
		this.context=context;
		this.listData1=listData1;
		this.imgarray=imgarray;
	}

	public CustomCardMainPageOne1(Context context, int innerLayout) {
		super(context, innerLayout);
		this.context=context;

	}


	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {

		s = new SpannableString(listData1);
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		mTitle = (TextView) parent.findViewById(R.id.txt);
		mImage=(ImageView) parent.findViewById(R.id.img);

		if (mTitle!=null)
		{
			mTitle.setText(s);
			mTitle.setTextSize(20);
			mImage.setImageResource(imgarray);
		}
	}
}
