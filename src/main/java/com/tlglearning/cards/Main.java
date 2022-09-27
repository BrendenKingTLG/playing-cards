package com.tlglearning.cards;

import com.tlglearning.cards.model.Deck;
import com.tlglearning.cards.strategy.ColorFirst;

import java.security.SecureRandom;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
//    TODO create inst of deck
//    TODO print string rep of deck
//    TODO create accept src of ran
//    TODO shuffle deck
//    TODO print string rep of deck

    Deck deck = new Deck();

    System.out.println(deck);
    Random rng = new SecureRandom();
    deck.shuffle(rng);

    System.out.println(deck);
    deck.sort();
    System.out.println(deck);
    deck.sort(new ColorFirst());
    System.out.println(deck);
  }

}
