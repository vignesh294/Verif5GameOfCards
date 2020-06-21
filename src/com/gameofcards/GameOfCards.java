package com.gameofcards;

import com.gameofcards.deck.Card;
import com.gameofcards.deck.Deck;
import com.gameofcards.game.SampleGame;
import java.util.Scanner;

public class GameOfCards {
    public static void main(String[] args) {
        // One deck and different types of games are played by different players
        // Deck - singleton
        Deck deck = Deck.getInstance();
        System.out.println("Hello, we have a deck of cards, we can only play a game called SampleGame for now!");
        Scanner sc= new Scanner(System.in);

        do {
            System.out.print("View cards in deck? 1 - Yes, 0 - No: ");
            if(sc.nextInt() == 1) {
                for(Card card : deck.getCards()) {
                    card.print(); System.out.print("||");
                }
                System.out.println("");
            }

            // shuffle
            System.out.println("Shuffling the deck...");
            deck.shuffle();

            // let's play!
            SampleGame sampleGame = new SampleGame(deck);
            sampleGame.play();

            System.out.print("One more round of SampleGame? 1 - Yes, 0 - No: ");
        } while(sc.nextInt() == 1);
    }

    // Taking an interview after quite a long time, enjoyed this nice question. Thanks.
}
