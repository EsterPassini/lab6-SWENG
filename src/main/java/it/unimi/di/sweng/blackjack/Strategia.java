package it.unimi.di.sweng.blackjack;


public interface Strategia {
  boolean chiediCarta();

  Strategia STAYALWAYS= new Strategia() {
    @Override
    public boolean chiediCarta() {
      return false;
    }
  };
}

