package it.unimi.di.sweng.blackjack;

public class TableStrategy implements Strategia{

    private Strategia next;
    private Sfidante giocatore;

    public TableStrategy(Strategia s, Sfidante sf){
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
