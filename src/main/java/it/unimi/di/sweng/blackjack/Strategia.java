package it.unimi.di.sweng.blackjack;

// TODO implementare almeno tre strategie di vostra invenzione per comporre il modo di giocare dei giocatori
// potranno basarsi sulle proprie carte o sulla carta iniziale del banco

public interface Strategia {
  boolean chiediCarta();

  Strategia STAYALWAYS= new Strategia() {
    @Override
    public boolean chiediCarta() {
      return false;
    }
  };
}

