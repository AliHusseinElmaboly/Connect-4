package com.badlogic.androidgames.Connect4;

import java.util.List;

import com.badlogic.androidgame.framework.Game;
import com.badlogic.androidgame.framework.Graphics;
import com.badlogic.androidgame.framework.Screen;
import com.badlogic.androidgame.framework.Input.TouchEvent;




public class GameScreen extends Screen {
	int leftDoor;
	int rightDoor;
	

	
	 enum GameState {
	        Ready,
	        Running,
	        Paused,
	        end,
	        winGame
	    }
	    
	    GameState state = GameState.Ready;
	    World world;
	  //  PhysicsWorld physicsWorld;
	    int oldScore = 0;
	
	   
	    public GameScreen(Game game) {
	        super(game);
	        
	        leftDoor=0;
	        rightDoor=0;
		
			world=new World();
		
	    
	        
	    }

	    @Override
	    public void update(float deltaTime) {
	        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
	        game.getInput().getKeyEvents();
	        
	        if(state == GameState.Ready)
	            updateReady(touchEvents);
	        if(state == GameState.Running)
	            updateRunning(touchEvents, deltaTime);
	        if(state == GameState.Paused)
	            updatePaused(touchEvents);
	        if(state == GameState.winGame)
	            updateWinGame(touchEvents);  
	        if(state == GameState.end)
	            updateEnd(touchEvents); 
	        
	        
	    }
	    
	    private void updateEnd(List<TouchEvent> touchEvents) {
	    
	         int len = touchEvents.size();
	         for(int i = 0; i < len; i++) {
	             TouchEvent event = touchEvents.get(i);
	             if(event.type == TouchEvent.TOUCH_UP) {
	                 
	                 if(inBounds(event, 64,170, 192, 42) ) {
	                     game.setScreen(new playing(game));
	                     if(Settings.soundEnabled)
	                         Assets.click.play(1);
	                     return;
	                 }
	              
	                 

	             }}
		}

		private void updateReady(List<TouchEvent> touchEvents) {
	        if(leftDoor>-160||rightDoor<280)
	        {
	        	leftDoor-=8;
	        	rightDoor+=8;
	        	
	        	
	        }
	        else
	            state = GameState.Running;
	    }
	    
	    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {   
	    	int eventx = 0;
	        int len = touchEvents.size();
	        for(int i = 0; i < len; i++) {
	            TouchEvent event = touchEvents.get(i);
	            if(event.type == TouchEvent.TOUCH_UP) {
	                if(event.x >288 && event.y <32) {
	                 
	                    state = GameState.Paused;
	                    
	                    if(Settings.soundEnabled)
	                        Assets.click.play(1);
	                    return;
	                }
	                if(inBounds(event, 110,110, 100, 50) && world.shoot){
		                 
	                    world.reset();
	                    
	                    if(Settings.soundEnabled)
	                        Assets.click.play(1);
	                    
	                }
	            }
	            if(event.type == TouchEvent.TOUCH_DOWN) {     	
	                
	            	 if(!inBounds(event, 110,110, 100, 50) &&!(event.x >288 && event.y <32)){
	                	if(world.shoot){
	                		if(Settings.soundEnabled)
	                            Assets.click.play(1);
	                		
	                world.setPostion(event.x);

	                	world.shoot=false;
	                	}
	                }
	               
	            }
	            
	        }
if(!world.shoot){
	
if(world.condition)
 world.update(deltaTime);
else
	world.shoot=true;

}
		      if(world.winner1||world.winner2){
		    	  if(Settings.soundEnabled)
		    		  Assets.winGame1.play(1);
		    	  state=GameState.winGame;
		      }
	      
	      if(world.gameOver){
	    	  if(Settings.soundEnabled)
	    		  Assets.winGame1.play(1);
	    	  state=GameState.winGame;
	      }

	    
	        
	     

	    }
	    
	    private void updatePaused(List<TouchEvent> touchEvents) {
	        int len = touchEvents.size();
	        for(int i = 0; i < len; i++) {
	            TouchEvent event = touchEvents.get(i);
	            if(event.type == TouchEvent.TOUCH_UP) {
	                if(event.x > 80 && event.x <= 240) {
	                    if(event.y > 170 && event.y <= 218) {
	                    	 
	                        if(Settings.soundEnabled)
	                            Assets.click.play(1);
	                        state = GameState.Running;
	                        return;
	                    }                    
	                    if(event.y > 218 && event.y < 266) {
	                    	 
	                        if(Settings.soundEnabled)
	                            Assets.click.play(1);
	                        game.setScreen(new playing(game));                        
	                        return;
	                    }
	                }
	            }
	        }
	    }
	    
	    private void updateWinGame(List<TouchEvent> touchEvents) {

	         int len = touchEvents.size();
	         for(int i = 0; i < len; i++) {
	             TouchEvent event = touchEvents.get(i);
	             if(event.type == TouchEvent.TOUCH_UP) {
	                
	                 if(inBounds(event, 75, 180, 192, 42) ) {
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
	        
	        g.drawPixmap(Assets.land, 0,0);
	       
	        drawWorld(world);
	        if(state == GameState.Ready) 
	            drawReadyUI();
	        if(state == GameState.Running)
	            drawRunningUI();
	        if(state == GameState.Paused)
	            drawPausedUI();
	        if(state == GameState.winGame)
	            drawWinGameUI();
	        
	        if(state == GameState.end)
	        	drawEndUI();
	      
	        
	    }
	    
	    private void drawEndUI() {
	        Graphics g = game.getGraphics();
	        g.drawPixmap(Assets.paper, 32, 130);
	        g.drawPixmap(Assets.end, 64, 170);
	      
	        
			
		}

		private void drawWorld(World world) {
	        Graphics g = game.getGraphics();
	        
	
		 for(int i=0;i<=world.current1;i++){
			 if(i!=21)
					 world.Ball1[i].draw(g); 
				 
			 
		 }

		 for(int i=0;i<=world.current2;i++){
			 if(i!=21)
					 world.Ball2[i].draw(g); 
				 
			 
		 }
		 g.drawPixmap(Assets.reset,110,110);
 g.drawPixmap(Assets.score, 120,160 ,world.score1*20,0,20,40);
 g.drawPixmap(Assets.score, 180,160 ,world.score2*20,0,20,40);
	if(playing.player==1){
		if(world.turn%2==0)
			 g.drawPixmap(Assets.player1, 10, 10);
		else
			 g.drawPixmap(Assets.player2, 10, 10);
			
	}
	
	  g.drawPixmap(Assets.foreground, 0, 205);
	//g.drawPixmap(Assets.connect, 0, 205);

	   }
	    
	    private void drawReadyUI() {
	        Graphics g = game.getGraphics();
	      g.drawPixmap(Assets.leftDoor, leftDoor, 0, 0, 0, 160, 480);
	      g.drawPixmap(Assets.RightDoor, rightDoor, 0, 0, 0, 320, 480);
	   
	        	    }
	    
	    private void drawRunningUI() {
	        Graphics g = game.getGraphics();
     

	    }
	    
	    private void drawPausedUI() {
	        Graphics g = game.getGraphics();
	        g.drawPixmap(Assets.paper, 32, 130);
	    g.drawPixmap(Assets.pause1, 80, 170);
	
	    }

	    private void drawWinGameUI() {
	        Graphics g = game.getGraphics();
	        g.drawPixmap(Assets.paper, 32, 130);
	        if(playing.player==1){
	        if(world.winner1)
	        g.drawPixmap(Assets.player1Win, 75, 180);
	        else if(world.winner2)
	         g.drawPixmap(Assets.player2Win, 75, 180);
	        }
	        else{
	        	 if(world.winner1)
	     	        g.drawPixmap(Assets.youWin, 75, 180);
	     	        else if(world.winner2)
	     	         g.drawPixmap(Assets.pcWin, 75, 180);
	        }
	        	
	     
	    }
	    
	  
	    
	    @Override
	    public void pause() {
	        if(state == GameState.Running)
	            state = GameState.Paused;
	       
	    }

	    @Override
	    public void resume() {
	        
	    }

	    @Override
	    public void dispose() {
	        
	    }
	    
	    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
	        if(event.x > x && event.x < x + width - 1 && 
	           event.y > y && event.y < y + height - 1) 
	            return true;
	        else
	            return false;
	    }

}