package com.example.student.myapplication;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
Button but;
    View rootView;
    TextView tv;
    Card [] card;
    Random rng = new Random();
    int z = 0;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_main, container,
                false);
        tv= (TextView) rootView.findViewById(R.id.textView);
        tv.setTextColor(Color.WHITE);
        rootView.setBackgroundColor(Color.BLACK);

        card = new Card[52];

        for (int suit = 0; suit < 4; suit++){
            for (int rank = 0; rank < 13; rank++){
                card[z] = new Card(suit, rank);
                z++;
            }
        }

        rootView.setBackgroundColor(Color.BLACK);

        card = suffleDeck(card);
        GetterSetter.card = card;

        return rootView;
    }

    public Card[] suffleDeck(Card[] deck){
        Card tempCard;
        for(int shuffleCount = 0; shuffleCount < 52; shuffleCount++){
            int randomCard = rng.nextInt(52);
            tempCard = deck[randomCard];
            deck[randomCard] = deck[shuffleCount];
            deck[shuffleCount] = tempCard;
        }
        return deck;
    }



}
