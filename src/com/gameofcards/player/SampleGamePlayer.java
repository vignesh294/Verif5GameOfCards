package com.gameofcards.player;

import com.gameofcards.deck.Card;

public class SampleGamePlayer extends BasicPlayer {

    private Card cardInHand;

    public SampleGamePlayer(int number) {
        super(number);
    }

    public Card getCardInHand() {
        return cardInHand;
    }

    public Card returnCardInHand() {
        Card c = cardInHand;
        cardInHand = null;
        return c;
    }

    public void setCardInHand(Card cardInHand) {
        this.cardInHand = cardInHand;
    }
}
