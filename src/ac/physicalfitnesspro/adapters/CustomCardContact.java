package ac.physicalfitnesspro.adapters;

import it.gmariotti.cardslib.library.internal.Card;
import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.TypefaceSpan;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomCardContact extends Card  {
	String[] listData1;
	protected TextView mTitle;
	Intent mainIntent1;
	Context context;
	Intent intent;
	int i;
	SpannableString s;

	public CustomCardContact(Context context,String[] listData1, int i) {
		this(context, R.layout.adapter_text_contact);
		this.context=context;
		this.i=i;
		this.listData1=listData1;
	}

	public CustomCardContact(Context context, int innerLayout) {
		super(context, innerLayout);
		init();
	}

	private void init(){
		setOnClickListener(new OnCardClickListener() {
			@Override
			public void onClick(Card card, View view) {
				// TODO Auto-generated method stub
			}
		});
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {

		s = new SpannableString(listData1[i]);
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		mTitle = (TextView) parent.findViewById(R.id.txt);

		if (mTitle!=null)
		{
			mTitle.setText(s);
			mTitle.setTextSize(20);
		}
	}
}
