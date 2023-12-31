package it.unimi.di.sweng.blackjack;

import org.jetbrains.annotations.NotNull;

public class StrategyRandom implements Strategia {
  final private Strategia next;

  public StrategyRandom(@NotNull Strategia next) {
    this.next = next;
  }

  @Override
  public boolean chiediCarta() {
    if (Math.random() > 0.5)
      return true;
    return next.chiediCarta();
  }
}
