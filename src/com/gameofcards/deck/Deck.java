package com.gameofcards.deck;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private static Deck _instance = null;

    private List<Card> cards;
    private int cardIndex = -1;

    protected Deck() {
        prepareCards();
    }

    public static Deck getInstance() {
        if(_instance == null) {
            _instance = new Deck();
        }

        return _instance;
    }

    private void prepareCards() {
        cards = new ArrayList<Card>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j <= 3; j++) {
                Suit suit = Suit.getSuitFromIndex(j);
                Card card = new Card(i, suit);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int j = random.nextInt(52);
            Card card1 = cards.get(i);
            Card card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
        cardIndex = -1;
    }

    public Card removeCard() {
        cardIndex++;
        Card card = cards.get(cardIndex);
        card.setAvailable(false);
        return card;
    }

    public void putCard(Card card) {
        card.setAvailable(true);
        cardIndex--;
    }

    public List<Card> getCards() {
        return cards;
    }

}
