package com.tlglearing.cards.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        return cards.iterator();
    }
}
