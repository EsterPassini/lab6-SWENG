package it.unimi.di.sweng.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Sfidante {
  //TODO i vari metodi richiesti per aderire all'interfaccia GiocatoreBJ

  final private String name;
  final private Mazziere banco;
  final private List<Card> mano = new ArrayList<>();
  private Strategia strategia;


  public Sfidante(@NotNull String name, @NotNull Mazziere banco) {
    this.name = name;
    this.banco = banco;
  }

  public void setStrategia(@NotNull Strategia strategia) {
    this.strategia = strategia;
  }

}
