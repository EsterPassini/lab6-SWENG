package it.unimi.di.sweng.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import org.jetbrains.annotations.NotNull;

public class MultiMazzo implements DeckInterface  {
  // TODO deve implementare DeckInterface

  public MultiMazzo(int numMazzi) {
    // TODO definire un costruttore che crei un mazzo composto da numMazzi mescolato casualmente
  }

  @Override
  public @NotNull Card draw() {
    return null;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }
}
