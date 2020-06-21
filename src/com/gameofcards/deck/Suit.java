package com.gameofcards.deck;

public enum Suit {
    Club,
    Diamond,
    Heart,
    Spade;

    public static Suit getSuitFromIndex(int index) {
        switch (index) {
            case 0:
                return Suit.Club;
            case 1:
                return Suit.Diamond;
            case 2:
                return Suit.Heart;
            case 3:
                return Suit.Spade;
            default:
                return null;
        }
    }
}
