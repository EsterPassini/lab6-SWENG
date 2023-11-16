package it.unimi.di.sweng.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import org.jetbrains.annotations.NotNull;

public interface DeckInterface {
  @NotNull Card draw();

  boolean isEmpty();
}
