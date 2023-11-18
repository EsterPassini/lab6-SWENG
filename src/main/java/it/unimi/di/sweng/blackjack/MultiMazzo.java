package it.unimi.di.sweng.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Deck;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MultiMazzo implements DeckInterface  {
  List<Deck> deckList=new ArrayList<>();
  public MultiMazzo(int numMazzi) {
    for (int i = 0; i < numMazzi; i++) {
        deckList.add(new Deck());
    }
  }

  @Override
  public @NotNull Card draw() {
    if (this.isEmpty()){
      return null;
    }
    int randomNum=0;
    if(deckList.size()>1) {
      randomNum = ThreadLocalRandom.current().nextInt(0, deckList.size() - 1);

    }
    while (deckList.get(randomNum).isEmpty()){
        randomNum++;
        if(randomNum>deckList.size()){
          randomNum=0;
        }
    }
    return deckList.get(randomNum).draw();
  }

  @Override
  public boolean isEmpty() {
    for (Deck dk:deckList) {
      if(!dk.isEmpty()){
        return false;
      }
    }
    return true;

  }
}
