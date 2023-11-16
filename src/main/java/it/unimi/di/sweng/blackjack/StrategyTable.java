package it.unimi.di.sweng.blackjack;

public class StrategyTable implements Strategia{

    private Strategia next;
    private Sfidante giocatore;

    public StrategyTable(Strategia s, Sfidante sf){
        this.giocatore = sf;
        this.next= s;
    }
    @Override
    public boolean chiediCarta() {
        if(giocatore.getPunti()<17){
            return true;
        }
        return next.chiediCarta();
    }
}
