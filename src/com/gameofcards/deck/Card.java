package com.gameofcards.deck;

public class Card {

    private boolean available = true;

    private int number; // 1 (Ace), 2, 3, ..., 10, 11 (Jack), 12, (Queen), 13(King)

    private Suit suit;

    public Card(int c, Suit s) {
        this.number = c;
        this.suit = s;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void print() {
        switch (suit) {
            case Club:
                System.out.print("Club");
                break;
            case Heart:
                System.out.print("Heart");
                break;
            case Diamond:
                System.out.print("Diamond");
                break;
            case Spade:
                System.out.print("Spade");
                break;
        }
        System.out.print(number);
    }
}
