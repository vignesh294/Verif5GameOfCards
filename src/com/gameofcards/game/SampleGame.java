package com.gameofcards.game;

import com.gameofcards.deck.Card;
import com.gameofcards.deck.Deck;
import com.gameofcards.deck.Suit;
import com.gameofcards.player.SampleGamePlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SampleGame extends BasicGame {

    int noOfPlayers = 0;

    public SampleGame(Deck deck) {
        super(deck);
        players = new ArrayList<>();
    }

    @Override
    public void play() {
        initializePlayers();
        println("Distributing cards to players...");
        distributeCards();
        println("Players with their cards:");
        printPlayersCards();
        SampleGamePlayer winner = determineWinner();
        println("Winner: " + winner.getNumber());
        collectCards();
    }

    @Override
    protected void initializePlayers() {
        print("Input the number of players: ");
        Scanner sc = new Scanner(System.in);
        noOfPlayers = sc.nextInt();
        for(int i = 1; i <= noOfPlayers; ++i) {
            players.add(new SampleGamePlayer(i));
        }
    }

    @Override
    protected void distributeCards() {
        for(int i = 0; i < noOfPlayers; ++i)
            ((SampleGamePlayer) players.get(i)).setCardInHand(deck.removeCard());
    }

    @Override
    protected void collectCards() {
        for(int i = 0; i < noOfPlayers; ++i)
            deck.putCard(((SampleGamePlayer) players.get(i)).returnCardInHand());
    }

    private void printPlayersCards() {
        for(int i = 0; i < noOfPlayers; ++i) {
            SampleGamePlayer player = (SampleGamePlayer) players.get(i);
            print( "Player #" + player.getNumber() + ": ");
            player.getCardInHand().print();
            println("");
        }
    }

    private SampleGamePlayer determineWinner() {
        // get players with highest number in their card
        // return the first player with the best suit among them
        int maxNumber = -1;
        List<SampleGamePlayer> shortlists = new ArrayList<>();
        for(int i = 0; i < noOfPlayers; ++i) {
            SampleGamePlayer player = (SampleGamePlayer) players.get(i);
            Card card = player.getCardInHand();
            if(card.getNumber() > maxNumber) {
                maxNumber = card.getNumber();
                shortlists.clear();
                shortlists.add(player);
            } else if(card.getNumber() == maxNumber) {
                shortlists.add(player);
            }
        }

        /*
        Among the players having same numeric value cards, the suit decides.
        Searching for the best suit among the shortlists.
        The below method is not the best way, but falling a little short on time.
        An alternate way I can think is to have temporary face values based on suit,
        so that the best card can be found in one pass.
         */

        for(SampleGamePlayer shortlist : shortlists) {
            if(shortlist.getCardInHand().getSuit().equals(Suit.Spade)) {
                return shortlist;
            }
        }

        for(SampleGamePlayer shortlist : shortlists) {
            if(shortlist.getCardInHand().getSuit().equals(Suit.Heart)) {
                return shortlist;
            }
        }

        for(SampleGamePlayer shortlist : shortlists) {
            if(shortlist.getCardInHand().getSuit().equals(Suit.Club)) {
                return shortlist;
            }
        }

        return shortlists.get(0);
    }
}
