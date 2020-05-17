package com.badlogic.androidgames.Connect4;

import java.util.List;

import com.badlogic.androidgame.framework.Game;
import com.badlogic.androidgame.framework.Graphics;
import com.badlogic.androidgame.framework.Screen;
import com.badlogic.androidgame.framework.Input.TouchEvent;






public class playing extends Screen {      
	public static int player;
    public playing(Game game) {
        super(game);
       player=0;
        
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
            	
            	if(event.x>10&&event.x<310)
            	{
                if(event.y > 100&& event.y<200) {
                	
                      
                    	  player=2;
                    	  
                          if(Settings.soundEnabled)
                              Assets.click.play(1);
                	  game.setScreen(new GameScreen(game));
                }
                else if(event.y > 200 && event.y<300 ) {
                    
                	
                	
                	
                		player=1;
                		  
                          if(Settings.soundEnabled)
                              Assets.click.play(1);
                	  game.setScreen(new GameScreen(game));
                }
                
               
                
                
                
                
                
            	}
            	if(event.x<64&&event.y>416){
            		  if(Settings.soundEnabled)
                          Assets.click.play(1);
            		  
            		  
            		  game.setScreen(new MainMenuScreen(game));   
            	}
            	
            	
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();      
        g.drawPixmap(Assets.background3, 0, 0);
        
        g.drawPixmap(Assets.level1, 10, 100);
      
        g.drawPixmap(Assets.level2, 10, 200);
     

        g.drawPixmap(Assets.direct, 0, 416);
     //   g.drawPixmap(Assets.buttons, 256, 416, 0, 64, 64, 64);
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