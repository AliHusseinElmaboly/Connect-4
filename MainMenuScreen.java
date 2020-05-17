package com.badlogic.androidgames.Connect4;

import java.util.List;

import com.badlogic.androidgame.framework.Game;
import com.badlogic.androidgame.framework.Graphics;
import com.badlogic.androidgame.framework.Screen;
import com.badlogic.androidgame.framework.Input.TouchEvent;




import android.util.Log;


public class MainMenuScreen extends Screen {
	
	
    static final float TICK_INITIAL = 0.005f;
    
    float tickTime = 0;
    static float tick = TICK_INITIAL;
    
    static int upDateShadow;
 int x=0;
 int y=0;
    
    public MainMenuScreen(Game game) {
        super(game);     
        upDateShadow=0;
        
    }   

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        
        tickTime += deltaTime;
        while (tickTime > tick) {
         tickTime -= tick;
        upDateShadow+=1;
        if(upDateShadow>190)
        	upDateShadow=-190;
         }
        
        
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();       
        
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
            	
            	x=event.x;
            	y=event.y;
            	Log.d("x :"+event.x+ " y :"+event.y, "x :"+event.x+ " y :"+event.y);
            	 if(inBounds(event, 0,0,32 , 32)) {

                   
                         Assets.click.play(1);
                	 Settings.soundEnabled=!Settings.soundEnabled;

                 
                }
            	
                if(inBounds(event, 85, 200,155, 35)) {
                	 game.setScreen(new playing(game));
                 
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                }
                else if(inBounds(event, 85, 250, 155,40) ) {
                   game.setScreen(new HelpScreen(game));
                   if(Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
                else if(inBounds(event, 85, 308, 155, 40) ) {
                    game.setScreen(new GameScreen(game));
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                	System.exit(0);
                
                
                  }
               
            }
        }
    }
    
    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 && 
           event.y > y && event.y < y + height - 1) 
            return true;
        else
            return false;
    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.main1, 0, 0);
       // g.drawPixmap(Assets.background2,0,0);
        g.drawPixmap(Assets.main2,0 , upDateShadow, 0, upDateShadow, 320, 190);
       if(Settings.soundEnabled)
            g.drawPixmap(Assets.sound, 0, 0,32, 0, 32, 32);
        else
            g.drawPixmap(Assets.sound, 0,0, 0, 0, 32, 32);

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
