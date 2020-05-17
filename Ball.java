package com.badlogic.androidgames.Connect4;


import com.badlogic.androidgame.framework.Graphics;
import com.badlogic.androidgames.framework.math.Circle;


public class Ball {


 private float x;
 private float y;

 
 public SpeedManager speed;	 
 
 private float width=40;
 private float height=40;
 private float raduis=20;
 
 
 public  float initY=160+raduis;
 public int sprite;
 
 public Circle circle;
 
 public static final int red=1;
 public static final int blue=2;
 public static final int green=3;
 public static final int yellow=4;
 public static final int blue2=5;
 public static final int pink=6;
 public static final int orange=7;
 public static final int grey=8;
 
 
 
 public int color=red;
 public int ArrayX,ArrayY;

 
 public Ball(int i){
	 sprite=0;
	 if(i==1)
	 x=raduis;
	 else
	 x=320-raduis;
	 y=initY;
	circle =new Circle(x, y,raduis);
	
 }
 

 public void setRight(Ball other){
	 other.x=this.x+width;
	 other.y=this.y;
 }
 public void setLeft(Ball other){
	 other.x=this.x-width;
	 other.y=this.y;
 }

 
 public Ball(float x, float y) {
sprite=0;
 this.x = x;
 this.y = y;
 circle =new Circle(x, y,height/2);

 this.speed = new SpeedManager();

 }
 

 

 

 public float getX() {

 return x;

 }
 
public float getY() {
	
	return y;
}

 public void setX(float x) {

 this.x = x;

 }
 
 public void setY(float y) {
	 
	this.y = y;
}

public SpeedManager getSpeed() {

return speed;

}

public void setSpeed(SpeedManager speed) {

this.speed = speed;

}


public float getHeight() {
	return height;
}

public float getWidth() {
	return width;
}



public boolean updateRight(float srcX){
	if(this.x<srcX)
		{x++;
		return false;
		}
	return true;
		
}
public boolean updateLeft(float srcX){
	if(this.x>srcX)
		{x--;
		return false;
		}
	return true;
		
}
public boolean updateDown(float srcY){
	if(this.y<srcY)
		{y++;
		return false;
		}
	return true;
		
}
public void draw(Graphics g) {
	
	switch (color){
	case red:g.drawPixmap(Assets.red, (int)(x - (height / 2)),(int)(y - (width/ 2)),sprite*32,0,32,32 );break;
	case green:g.drawPixmap(Assets.green, (int)(x - (height / 2)),(int)(y- (width/ 2)),sprite*32,0,32,32 );break;
	case grey:g.drawPixmap(Assets.grey, (int)(x - (height / 2)),(int)(y- (width/ 2)),sprite*32,0,32,32 );break;

	case blue:g.drawPixmap(Assets.blue, (int)(x - (height / 2)),(int)(y- (width/ 2)),sprite*32,0,32,32 );break;
	case blue2:g.drawPixmap(Assets.blue2, (int)(x - (height / 2)),(int)(y- (width/ 2)),sprite*32,0,32,32 );break;
	case pink:g.drawPixmap(Assets.pink, (int)(x - (height / 2)),(int)(y- (width/ 2)),sprite*32,0,32,32 );break;
	case orange:g.drawPixmap(Assets.orange, (int)(x - (height / 2)),(int)(y- (width/ 2)),sprite*32,0,32,32 );break;

	case yellow:g.drawPixmap(Assets.yellow, (int)(x - (height / 2)),(int)(y - (width/ 2)) ,sprite*32,0,32,32);break;
	
	}
	
	
	sprite++;
	if(sprite==10)
		sprite=0;

}


public void resetBall(int i) {
	 if(i==1)
		 x=raduis;
		 else
		 x=320-raduis;
		 y=initY;
	
}
}