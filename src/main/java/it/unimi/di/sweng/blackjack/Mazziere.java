package it.unimi.di.sweng.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;
import ca.mcgill.cs.stg.solitaire.cards.Suit;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mazziere implements GiocatoreBJ,Iterable<Card> {

    private MultiMazzo mazzo;
    private List<Card> mano;

    public Mazziere(){
        this.mazzo = new MultiMazzo(6);
        carteIniziali();
    }
    @Override
    public void carteIniziali() {
        mano=new ArrayList<>();
        mano.add(mazzo.draw());
    }

    @Override
    public void gioca() {
        while (getPunti()<17){
            mano.add(mazzo.draw());
        }
    }

    @Override
    public Iterator<Card> getCards() {
        return iterator();
    }

    @Override
    public @NotNull String getName() {
        return "Mazziere";
    }

    @NotNull
    @Override
    public Iterator<Card> iterator() {
        return mano.iterator();
    }

    public Card daiCarta() {
        return mazzo.draw();
    }
}
