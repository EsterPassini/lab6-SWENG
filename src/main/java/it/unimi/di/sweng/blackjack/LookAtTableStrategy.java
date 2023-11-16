package it.unimi.di.sweng.blackjack;

public class LookAtTableStrategy implements Strategia{

    private Strategia next;
    private Sfidante g;
    private Mazziere mz;

    public LookAtTableStrategy(Strategia next, Sfidante g, Mazziere mz) {
        this.next = next;
        this.g = g;
        this.mz = mz;
    }

    @Override
    public boolean chiediCarta() {
        return false;
    }
}
