package it.unimi.di.sweng.blackjack;

public class StrategyLookAtTable implements Strategia{

    private Strategia next;
    private Sfidante g;
    private Mazziere mz;

    public StrategyLookAtTable(Strategia next, Sfidante g, Mazziere mz) {
        this.next = next;
        this.g = g;
        this.mz = mz;
    }

    @Override
    public boolean chiediCarta() {
        if(g.getPunti()< mz.getPunti()){
            return true;
        }
        return next.chiediCarta();
    }
}
