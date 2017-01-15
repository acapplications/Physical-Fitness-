package ac.physicalfitnesspro.adapters;


import it.gmariotti.cardslib.library.internal.Card;
import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.TypefaceSpan;
import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomCardDescription extends Card{
	String listData1;
	protected TextView mTitle;
	Context context;
	SpannableString s;


	public CustomCardDescription(Context context,String listData1) {
		this(context, R.layout.card_description);
		this.context=context;
		this.listData1=listData1;

	}

	public CustomCardDescription(Context context, int innerLayout) {
		super(context, innerLayout);
		this.context=context;

	}


	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {

		s = new SpannableString(listData1);
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		mTitle = (TextView) parent.findViewById(R.id.data);


		if (mTitle!=null)
		{
			mTitle.setText(s);
			
			mTitle.setTextSize(20);

		}
	}
}
