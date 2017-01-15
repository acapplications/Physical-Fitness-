package ac.physicalfitnesspro.fragments;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

import java.util.ArrayList;

import ac.physicalfitnesspro.R;
import ac.physicalfitnesspro.adapters.CustomCardHomeFragment;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment{

	Activity activity;
	String[] listData1= new String[]{"Physical Fitness", "Workout", "Body Mass Index"};
	CardArrayAdapter adapter;
	CustomCardHomeFragment card;
	CardListView cardView;
	ArrayList<Card> cards;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView= inflater.inflate(R.layout.home_fragment_layout, container, false);

		activity=getActivity();
		
		cards = new ArrayList<Card>();
		for(int i=0;i<listData1.length;i++)
		{ 
			card = new CustomCardHomeFragment(activity, listData1,i);
			card.setShadow(true);
			cards.add(card);			
		}
		adapter = new CardArrayAdapter(activity, cards);
		cardView = (CardListView) rootView.findViewById(R.id.home_list);		
		cardView.setAdapter(adapter);

		
		return rootView;
	}
}
