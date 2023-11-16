package it.unimi.di.sweng.blackjack;

public class TableStrategy implements Strategia{

    Strategia next;
    Sfidante giocatore;

    public TableStrategy(Strategia s, Sfidante sf){
        this.giocatore = sf;
        this.next= s;
    }
    @Override
    public boolean chiediCarta() {

        return false;
    }
}
