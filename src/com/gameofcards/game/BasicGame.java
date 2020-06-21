package com.gameofcards.game;

import com.gameofcards.deck.Deck;
import com.gameofcards.player.BasicPlayer;

import java.util.List;

public abstract class BasicGame <T extends BasicPlayer> {

    protected List<T> players;

    protected Deck deck;

    public BasicGame(Deck deck) {
        this.deck = deck;
    }

    public abstract void play();

    protected abstract void initializePlayers();

    protected abstract void distributeCards();

    protected abstract void collectCards() ;

    protected void print(String message) {
        System.out.print(message);
    }

    protected void println(String message) {
        System.out.println(message);
    }
}
