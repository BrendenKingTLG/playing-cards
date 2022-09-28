package com.tlglearning.cards.model;

import java.security.SecureRandom;
import java.util.*;
import java.util.function.Predicate;

public class Trick {
    //create a deck and shuffle
    //divide deck into 2 piles, red and black; discard indc cards
    //swap rand number of cards
    //count red and black in piles, display contents

    private final List<Card> blackPile;
    private final List<Card> redPile;
    private final Random rng;

    public Trick(Random rng) {
        this.rng = rng;
        Deck deck = new Deck();
        deck.shuffle(rng);
        blackPile = new ArrayList<>();
        redPile = new ArrayList<>();
        divideIntoPiles(deck);
    }

    private void divideIntoPiles(Deck deck) {
        for (Iterator<Card> iterator = deck.iterator(); iterator.hasNext(); ) {
            Card indicator = iterator.next();
            Card next = iterator.next();
            if (indicator.suit().color()== Suit.Color.BLACK) {
                blackPile.add(next);
            } else {
                redPile.add(next);
            }
        }
    }

    public static void main(String[] args) {
        Trick trick = new Trick(new SecureRandom());

    }

    private void swapBetweenPiles() {
        int maxSwapCount = Math.min(blackPile.size(), redPile.size());
        int swapCount = rng.nextInt(maxSwapCount+1);
        for (int i = 0; i < swapCount; i++) {
            redPile.add(blackPile.remove(0));
            blackPile.add(redPile.remove(0));
        }
    }

    private int countColor(Collection<Card> cards, Suit.Color color) {
        return (int) cards
                .stream()
                .filter(new Predicate<Card>() {
                    @Override
                    public boolean test(Card card) {
                        return card.suit().color()==color;
                    }
                })
                .count();
    }

}
