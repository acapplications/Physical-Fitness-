package ac.physicalfitnesspro.fragments;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

import java.util.ArrayList;

import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.adapters.CustomCardCredit;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class CreditsFragment extends Fragment {

	ListView listView;
	Activity activity;
	String [] listData1;
	TextView credits1,credits2;
	CardArrayAdapter adapter;
	CustomCardCredit card;
	CardListView cardView;
	ArrayList<Card> cards;
	SharedPreferences sharedPreferences;
	Editor editor;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView= inflater.inflate(R.layout.activity_credits, container, false);

		activity = getActivity();
		listData1=activity.getResources().getStringArray(R.array.credits_fragment_listdata1);
		sharedPreferences = activity.getSharedPreferences("MyPref", Context.MODE_PRIVATE);	
		editor = sharedPreferences.edit();
		editor.putInt("at_home", 0);
		editor.commit();

		cards = new ArrayList<Card>();
		for(int i=0;i<listData1.length;i++)
		{ 
			card = new CustomCardCredit(activity, listData1,i);
			cards.add(card);			
		}
		adapter = new CardArrayAdapter(activity, cards);
		cardView = (CardListView) rootView.findViewById(R.id.credit_list);
		cardView.setAdapter(adapter);

		return rootView;
	}
}