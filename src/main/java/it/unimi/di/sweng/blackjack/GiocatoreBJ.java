package it.unimi.di.sweng.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public interface GiocatoreBJ{
  void carteIniziali();

  void gioca();

  Iterator<Card> getCards();

  @NotNull String getName();

  default int getPunti() {
    int n=0;
    int aCounter=0;
    for (Iterator<Card> it = getCards(); it.hasNext(); ) {
      Card g = it.next();
      n+=BlackJack.cardValue(g);
      if(g.getRank()== Rank.ACE){
        aCounter++;
      }
    }
    for (int i = aCounter; i>0; i--) {
        if (n+10<=21){
          n+=10;
        }else {
          break;
        }
    }

    return n;
  }

  default boolean isSballato() {
    return getPunti() > 21;
  }

  default @NotNull String asString() {
    final StringBuilder sb = new StringBuilder(getName());
    sb.append(": [")
        .append(getPunti())
        .append("] ");
    for (Card card : (Iterable<Card>) this::getCards)
      sb.append(card).append(" ");
    if (isSballato())
      sb.append("SBALLATO");
    return sb.toString();
  }
}
