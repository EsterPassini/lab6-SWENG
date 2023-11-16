package it.unimi.di.sweng.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public interface GiocatoreBJ {
  void carteIniziali();

  void gioca();

  Iterator<Card> getCards();

  @NotNull String getName();

  default int getPunti() {
    // TODO quanto valgono le carte? Occhio agli assi!
    return 0;
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
