package ac.physicalfitnesspro.adapters;

import it.gmariotti.cardslib.library.internal.Card;
import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.TypefaceSpan;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomCardListFollow extends Card  {
	String[] listData1;
	protected TextView mTitle;
	Intent mainIntent1;
	Context context;
	Intent intent;
	ImageView mImage;
	int i;
	SpannableString s;

	public CustomCardListFollow(Context context,String[] listData1, int i) {
		this(context, R.layout.image_text_layout);
		this.context=context;
		this.i=i;
		this.listData1=listData1;
	}

	public CustomCardListFollow(Context context, int innerLayout) {
		super(context, innerLayout);
		init();
	}

	private void init(){
		setOnClickListener(new OnCardClickListener() {
			@Override
			public void onClick(Card card, View view) {
				// TODO Auto-generated method stub

				switch (i) {


				case 1:
					intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.diabetesfitness"));
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intent);
					break;


				}
			}
		});
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {

		s = new SpannableString(listData1[i]);
		s.setSpan(new TypefaceSpan(context, "Roboto-Medium.ttf"), 0, s.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
		mTitle = (TextView) parent.findViewById(R.id.txt);
		mImage= (ImageView) parent.findViewById(R.id.img);

		if (mTitle!=null)
		{
			if(i==0)
			{
				mImage.setImageResource(R.drawable.zspture);
			}
			else if(i==1)
			{
				mImage.setImageResource(R.drawable.zspture);
			}
			mTitle.setText(s);
			mTitle.setTextSize(20);
		}
	}
}
