package ac.physicalfitnesspro.adapters;


import it.gmariotti.cardslib.library.internal.Card;
import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.TypefaceSpan;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomCardResistance extends Card  {

	String[] listData1;
	String[] listData2;
	protected TextView mTitle;
	protected TextView mData;

	int i;
	 AssetManager mngr;
	Context context;
	SpannableString s,s1;

	public CustomCardResistance(Context context,String[] listData1,String[] listData2, int i) {
		this(context, R.layout.card_start_finish);
		this.context=context;
		this.listData1=listData1;
		this.i=i;
		this.listData2=listData2;
	}

	public CustomCardResistance(Context context, int innerLayout) {
		super(context, innerLayout);
		this.context=context;
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {

		mngr = context.getAssets();
		s = new SpannableString(listData1[i]);
		s1= new SpannableString(listData2[i]);
		Typeface typeFace=Typeface.createFromAsset(mngr,"fonts/Roboto-Medium.ttf");
		s1.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		mTitle = (TextView) parent.findViewById(R.id.title);
		mData= (TextView) parent.findViewById(R.id.data);

		if (mTitle!=null)
		{
			mTitle.setText(s);
			mTitle.setTypeface(typeFace);
			mTitle.setTextSize(24);
			mData.setText(s1);
			mData.setTypeface(typeFace);
			mData.setTextSize(18);
		}
	}
}