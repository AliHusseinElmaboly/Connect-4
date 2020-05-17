package com.badlogic.androidgames.Connect4;

import java.util.List;

import com.badlogic.androidgame.framework.Game;
import com.badlogic.androidgame.framework.Graphics;
import com.badlogic.androidgame.framework.Screen;
import com.badlogic.androidgame.framework.Input.TouchEvent;





public class HelpScreen extends Screen {      
    public HelpScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
         
                 if(event.x <64  && event.y > 416 ) {
                    game.setScreen(new MainMenuScreen(game));
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();      
      g.drawPixmap(Assets.ground2, 0, 0);
    
    
       g.drawPixmap(Assets.direct,0, 416);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}