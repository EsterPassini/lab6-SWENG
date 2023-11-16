package it.unimi.di.sweng.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mazziere implements GiocatoreBJ,Iterable<Card> {

    private DeckInterface mazzo;
    private List<Card> mano = new ArrayList<>();

    public Mazziere(){
        this.mazzo = new MultiMazzo(6);
    }
    @Override
    public void carteIniziali() {
        mano.add(mazzo.draw());
    }

    @Override
    public void gioca() {

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
}
