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
        if (sf.numCards()%2==1){
            return true;
        }
        return next.chiediCarta();
    }
}
