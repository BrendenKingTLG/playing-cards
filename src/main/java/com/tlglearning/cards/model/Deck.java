package com.tlglearning.cards.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Deck implements Iterable<Card> {
    //fields
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for(Suit s: Suit.values()){
            for (Rank r: Rank.values()) {
                Card card = new Card(r, s);
                cards.add(card);

            }
        }
    }

    @Override
    public Iterator<Card> iterator() {
        return Collections.unmodifiableList(cards).iterator();
    }

   public void shuffle(Random rng) {
        Collections.shuffle(cards, rng);
    }

   public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public int hashCode() {
        return cards.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean result;

        if (this.hashCode() == obj.hashCode()){
            result = true;
        } else if (obj instanceof Card) {
            result = (cards.equals(((Card) obj).cards));
        }
        else {
            result = false;
        }

        return result;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
