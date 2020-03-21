package com.jack.main.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class Deck {

    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        for (Value v : Value.values()) {
            for (Kind k : Kind.values()) {
                Card c = new Card(v, k);
                this.deck.add(c);
            }
        }
    }

    public List<Card> getDeck() {
        return deck;
    }

    public Card drawCard() {
        Random rd = new Random();
        int random = rd.nextInt(this.deck.size());
        Card c = this.deck.get(random);
        this.deck.remove(random);
        return c;
    }
}
