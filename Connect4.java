package com.badlogic.androidgames.Connect4;


import com.badlogic.androidgame.framework.Screen;
import com.badlogic.androidgames.framework.impl.AndroidGame;

public class Connect4 extends AndroidGame {
    @Override
    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }
}