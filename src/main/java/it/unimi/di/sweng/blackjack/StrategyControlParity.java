package it.unimi.di.sweng.blackjack;

public class StrategyControlParity implements Strategia{
    Strategia next;
    Sfidante sf;

    public StrategyControlParity(Strategia next, Sfidante sf) {
        this.next = next;
        this.sf = sf;
    }


    @Override
    public boolean chiediCarta() {
        return false;
    }
}
