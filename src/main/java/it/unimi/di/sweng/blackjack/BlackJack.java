package it.unimi.di.sweng.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import org.jetbrains.annotations.NotNull;

public class BlackJack {
  public static int cardValue(@NotNull Card c) {
    return Math.min(c.getRank().ordinal() + 1, 10);
  }

}
