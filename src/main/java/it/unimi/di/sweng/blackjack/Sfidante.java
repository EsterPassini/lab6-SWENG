package it.unimi.di.sweng.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sfidante  implements GiocatoreBJ, Iterable<Card>{

  final private String name;
  final private Mazziere banco;
  private List<Card> mano;
  private Strategia strategia;


  public Sfidante(@NotNull String name, @NotNull Mazziere banco) {
    this.name = name;
    this.banco = banco;
    carteIniziali();

  }

  public void setStrategia(@NotNull Strategia strategia) {
    this.strategia = strategia;
  }

  @Override
  public void carteIniziali() {
      mano =new ArrayList<>();
      mano.add(banco.daiCarta());
      mano.add(banco.daiCarta());
  }

  @Override
  public void gioca() {
    while (strategia.chiediCarta() && !(isSballato())) {
      mano.add(banco.daiCarta());
    }

  }

  @Override
  public Iterator<Card> getCards() {
    return iterator();
  }

  @Override
  public @NotNull String getName() {
    return name;
  }

  @NotNull
  @Override
  public Iterator<Card> iterator() {
    return mano.iterator();
  }

  public int numCards(){
    return mano.size();
  }
}
