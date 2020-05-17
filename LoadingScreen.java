package com.badlogic.androidgames.Connect4;


import com.badlogic.androidgame.framework.Game;
import com.badlogic.androidgame.framework.Graphics;
import com.badlogic.androidgame.framework.Screen;
import com.badlogic.androidgame.framework.Graphics.PixmapFormat;

public class LoadingScreen extends Screen {
	
	public static int level;
	 public LoadingScreen(Game game) {
		
	        super(game);
	        
	        
	        level=1;
	    }

	    @Override
	    public void update(float deltaTime) {
	        Graphics g = game.getGraphics();
	
	       Assets.background3= g.newPixmap("background3.png", PixmapFormat.RGB565);
	        
	     Assets.ground2= g.newPixmap("ground2.png", PixmapFormat.RGB565);
	     
	     
	        Assets.person= g.newPixmap("person.png", PixmapFormat.ARGB4444);
	        Assets.end= g.newPixmap("end.png", PixmapFormat.ARGB4444);
	         Assets.main1= g.newPixmap("main1.png", PixmapFormat.ARGB4444);
	         Assets.main2= g.newPixmap("main2.png", PixmapFormat.ARGB4444);
	        // ali
	        Assets.paper=g.newPixmap("paper.png",PixmapFormat.ARGB4444);
	        Assets.leftDoor=g.newPixmap("leftDoor.png",PixmapFormat.ARGB4444);
	        Assets.RightDoor=g.newPixmap("RightDoor.png",PixmapFormat.ARGB4444);
	       Assets.pause1=g.newPixmap("pausemenu.png",PixmapFormat.ARGB4444);
	       Assets.level1=g.newPixmap("1player.png",PixmapFormat.ARGB4444);
	       Assets.level2=g.newPixmap("2players.png",PixmapFormat.ARGB4444);

	       Assets.winGame=g.newPixmap("win.png",PixmapFormat.ARGB4444);
	       Assets.land=g.newPixmap("land.png",PixmapFormat.ARGB4444);

	 
	       Assets.direct=g.newPixmap("direct.png",PixmapFormat.ARGB4444);
	       Assets.progress=g.newPixmap("progress.png",PixmapFormat.ARGB4444);
	       Assets.percent=g.newPixmap("percent.png",PixmapFormat.ARGB4444);
	       Assets.limit=g.newPixmap("limit.png",PixmapFormat.ARGB4444);
	       Assets.foreground=g.newPixmap("connect.png",PixmapFormat.ARGB4444);
	       Assets.back=g.newPixmap("back.png",PixmapFormat.ARGB4444);
	    Assets.sound=g.newPixmap("sound.png", PixmapFormat.ARGB4444);
	    Assets.ball=g.newPixmap("ball.png", PixmapFormat.RGB565); 
	    Assets.red=g.newPixmap("red.png", PixmapFormat.RGB565); 
	    
	    Assets.blue=g.newPixmap("blue.png", PixmapFormat.RGB565); 
	    
	    Assets.blue2=g.newPixmap("blue2.png", PixmapFormat.RGB565); 
	    Assets.green=g.newPixmap("green.png", PixmapFormat.RGB565); 
	    Assets.grey=g.newPixmap("grey.png", PixmapFormat.RGB565); 
	    Assets.pink=g.newPixmap("pink.png", PixmapFormat.RGB565); 
	    Assets.orange=g.newPixmap("orange.png", PixmapFormat.RGB565); 
	    Assets.player1=g.newPixmap("player1.png", PixmapFormat.RGB565);
	    Assets.player2=g.newPixmap("player2.png", PixmapFormat.RGB565); 
	    Assets.pcWin=g.newPixmap("pcWin.png", PixmapFormat.RGB565);
	    Assets.youWin=g.newPixmap("youWin.png", PixmapFormat.RGB565);
	    Assets.player2Win=g.newPixmap("player2Win.png", PixmapFormat.RGB565);
	    Assets.player1Win=g.newPixmap("player1Win.png", PixmapFormat.RGB565);
	    Assets.score=g.newPixmap("score.png", PixmapFormat.RGB565);
	    Assets.reset=g.newPixmap("reset.png", PixmapFormat.RGB565);
	  //  Assets.connect=g.newPixmap("connect.png", PixmapFormat.RGB565); 
	    Assets.border=g.newPixmap("border.png", PixmapFormat.RGB565); 
	       Assets.click = game.getAudio().newSound("click.WAV");
	       Assets.point = game.getAudio().newSound("point.wav");
	       Assets.gun1 = game.getAudio().newSound("gun1.WAV");
	       Assets.winGame1 = game.getAudio().newSound("gameover.wav");
	       Assets.die1 = game.getAudio().newSound("die.wav");
	       Assets.direct1 = game.getAudio().newSound("direct.wav");
	        game.setScreen(new MainMenuScreen(game));
	    }

	    @Override
	    public void present(float deltaTime) {

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