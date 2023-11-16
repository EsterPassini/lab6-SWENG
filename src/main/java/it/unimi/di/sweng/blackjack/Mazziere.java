package it.unimi.di.sweng.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Mazziere implements GiocatoreBJ,Iterable<Card> {

    private DeckInterface mazzo;

    public Mazziere(){
        this.mazzo = new MultiMazzo(6);
    }
    @Override
    public void carteIniziali() {

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
        return null;
    }

    @NotNull
    @Override
    public Iterator<Card> iterator() {
        return null;
    }
    // TODO i vari metodi richiesti per aderire all'interfaccia GiocatoreBJ
}
