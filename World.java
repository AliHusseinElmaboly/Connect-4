package com.badlogic.androidgames.Connect4;

import java.util.LinkedList;
import java.util.Random;

import android.util.Log;

import com.badlogic.androidgames.framework.math.OverlapTester;
import com.badlogic.androidgames.framework.math.Rectangle;
import com.badlogic.androidgames.framework.math.Vector2;
public class World {
	static final float TICK_INITIAL = 0.004f;
    
public Ball [] Ball1;
public Ball [] Ball2;
public int current1;
public int current2;
public boolean win1;
public boolean win2; 
Random r;
public boolean winner1;
public boolean winner2;
public int score1;
public int score2;
float yIndex,xIndex,xCpu,yCpu;
int row,col,rowCpu,colCpu;
int [] []Connect=new int [6][7];
public boolean condition=false;
    public boolean shoot;
    public boolean gameOver=false;
    static int turn =0;
    float tickTime = 0;
    static float tick = TICK_INITIAL;


    public World() {
    	Ball1=new Ball[21];
         r = new Random();
         colCpu=  r.nextInt(7);
    	for(int i=0;i<Ball1.length;i++)
    		{Ball1[i]=new Ball(1);
    		Ball1[i].color=1;
    		}
      	Ball2=new Ball[21];
    	for(int i=0;i<Ball2.length;i++)
    		{Ball2[i]=new Ball(2);
    		Ball2[i].color=2;
    		}
  turn=0;
    	shoot=true;
   

    }

  

public boolean TestWins(int i,int j,int type){
if(testWinRow(i,j,type))
	return true;
if(testWinCol(i,j,type))
	return true;
if(testWinLeft(i,j,type))
	return true;
if(testWinRight(i,j,type))
	return true;

return false;

}
private boolean testWinRight(int i, int j, int type) {
	int left,right,up,down;
	left=j+1;
	up=i-1;
	right=j-1;
	down=i+1;
	int count=1;
	while(left<7&&down<6&&Connect[down][left]==type){
		count++;
		if(count==4)
			return true;
		left++;
		down++;
		
	}
	while(right>-1&&up>-1&&Connect[up][right]==type){
		count++;
		if(count==4)
			return true;
		right--;
		up--;
	}
		return false;
}


private boolean testWinLeft(int i, int j, int type) {
	int left,right,up,down;
	left=j+1;
	up=i-1;
	right=j-1;
	down=i+1;
	int count=1;
	while(left<7&&up>-1&&Connect[up][left]==type){
		count++;
		if(count==4)
			return true;
		left++;
		up--;
		
	}
	while(right>-1&&down<6&&Connect[down][right]==type){
		count++;
		if(count==4)
			return true;
		right--;
		down++;
	}
		return false;
		
}


public boolean testWinCol(int i,int j,int type){
	int count=0;
	while(i<6&&Connect[i][j]==type){
		count++;
		if(count==4)
			return true;
		i++;
	}
	return false;
}
	
public boolean testWinRow(int i,int j,int type){
int left,right;
left=j+1;
right=j-1;
int count=1;
while(left<7&&Connect[i][left]==type){
	count++;
	if(count==4)
		return true;
	left++;
	
}
while(right>-1&&Connect[i][right]==type){
	count++;
	if(count==4)
		return true;
	right--;
}
	return false;
	
}


	public void update(float deltaTime) {
     if(gameOver){
    	 return;
     }
        
       tickTime += deltaTime;

       while (tickTime > tick) {
    	  
    	if(playing.player==1){
    		//two player
    	   if(turn%2== 0){
  			 if(  Ball1[current1].updateRight(xIndex)){
  				 if(Ball1[current1].updateDown(yIndex))
  				 { 	current1++;
  					turn=1;
  					win1=TestWins(row, col, 1);
  					
  					if(win1){
  						turn=0;
  						reset();
  						score1++;
  					if(score1==6)
  						winner1=true;
  					}
  					 shoot=true;
  				 
  				 }
  			 }
  		   }
  		 else{
    			 if(  Ball2[current2].updateLeft(xIndex)){
    				 if(Ball2[current2].updateDown(yIndex))
    				 { 	current2++;
    					turn=0;
    					win2=TestWins(row, col, 2);
    					
    					if(win2){
    						turn=1;
    						reset();
    						score2++;
    						if(score2==6)
    							winner2=true;
    					}
    					shoot=true;
    				 
    				 }
    			 }
    		   }
    	}
    	else if(playing.player==2){
    		 if(Ball1[current1].updateRight(xIndex)){
  		     if(Ball1[current1].updateDown(yIndex))
  				 { 	
  					
  				
  					
  				
  					//make pc function
  					
  				
  					 if(Ball2[current2].updateLeft(xCpu)){
  						 if(Ball2[current2].updateDown(yCpu)){
  				current1++;
  	  			current2++;
  				win1=TestWins(row, col, 1);
				win2=TestWins(rowCpu, colCpu, 2);
				
				if(win1){
						
  					
					score1++;
					if(score1==6)
						winner1=true;
				}
				if(win2){
					
					score2++;
					if(score2==6)
						winner2=true;
				}
		
  						
  						if(win1||win2)
  							reset();
				 	    shoot=true;
				 	}
  					 }
				 	
 
    		 }
  							 
 
  				 
  				 
  			 }
    
    		
    	}
          tickTime -= tick;

      
       }
   
    }
	void pc_player(){
	//check for win
		int count=0;
		int i=5,j=0;
		boolean cond=false;
		if(Connect[5][3]==1&&Connect[4][3]==1&&Connect[3][3]==1)
			j=0;
		
for(i=5;i>=0;i--){
	
	for( j=0;j<7;j++){
		if(Connect[i][j]==0)
			cond=check(i,j);
			if(cond)
				break;
				
	}
	if(cond)
		break;
}

	
		
		
		

if(!cond)
  player();
else
{
	
	while(i+1<6&&Connect[i+1][j]==0)
	i++;
	rowCpu=i;
	colCpu=j;
	Connect[rowCpu][colCpu]=2;

		 yCpu=(float)((205+2.5)+rowCpu*45+22.5);
		 xCpu=(float)(2.5+colCpu*45+22.5);
}
}

public boolean check(int i,int j){
	
	//check left
	//check right
	//check leftDiagnol
	//check rightDiagnol
	//check top
	boolean result=false;
	if(i<3){
		if(Connect[i+1][j]==2){
			if(Connect[i+2][j]==2){
				if(Connect[i+3][j]==2){
			result=true;}}}
		else if(Connect[i+1][j]==1){
			 if(Connect[i+2][j]==1){
				if(Connect[i+3][j]==1){
					result=true;}}}
		
			
	}
		
	 if(j>2){
		 if(Connect[i][j-1]==2){
			 if(Connect[i][j-2]==2){
				 if(Connect[i][j-3]==2){
				result=true;}}}
		 else if (Connect[i][j-1]==1){
			      if(Connect[i][j-2]==1){
			    	  if(Connect[i][j-3]==1){
				result=true;}}}
	 }
	 if(j>2&&i<3){
		 if(Connect[i+1][j-1]==2){
			 if(Connect[i+2][j-2]==2){
				 if(Connect[i+3][j-3]==2){
					 return true;}}}
		 else if (Connect[i+1][j-1]==1){
			 if(Connect[i+2][j-2]==1){
				 if(Connect[i+3][j-3]==1){
					 return true;}}}
			
	 }
	
	if(j<4){
		if(Connect[i][j+1]==2){
			if(Connect[i][j+2]==2){
				if(Connect[i][j+3]==2){
			result=true;}}}
		else if(Connect[i][j+1]==1){
			if(Connect[i][j+2]==1){
				if(Connect[i][j+3]==1){
			result=true;}}}
	}
	if(j<4&&i<3){
		if(Connect[i+1][j+1]==2){
			if(Connect[i+2][j+2]==2){
				if(Connect[i+3][j+3]==2){
			result=true;}}}
		else if(Connect[i+1][j+1]==1){
			if(Connect[i+2][j+2]==1){
				if(Connect[i+3][j+3]==1){
			result=true;}}}
	}
    	return 	result;
}

void player(){
	rowCpu=row;
	colCpu=col;
	int left,right,downLeft,downRight;
	left=colCpu+1;
	right=colCpu-1;
	downLeft=rowCpu;
	downRight=rowCpu;
	
	
	while(left<7&&(Connect[rowCpu][left]==1||Connect[rowCpu][left]==2)){
		
	
		left++;
		
	}
	if(left<7&&Connect[rowCpu][left]==0){
		//colCpu=left;
		while(downLeft+1<6&&Connect[downLeft+1][left]==0)
			downLeft++;
		
	}
	while(right>-1&&(Connect[rowCpu][right]==1||Connect[rowCpu][right]==2)){
		
		right--;
	}
	
	if(right>-1&&Connect[rowCpu][right]==0){
	//	colCpu=right;
		while(downRight+1<6&&Connect[downRight+1][right]==0)
			downRight++;
	}
	if(left<7&&right>-1){
		 int choice = r.nextInt(2);
    if(choice==0){
    	
			 rowCpu=downRight;
			 colCpu=right;
		 }
		 else
		 {
			 rowCpu=downLeft;
			 colCpu=left;
		
		 }
		
	}
	else if(left<7){
	
		 rowCpu=downLeft;
		 colCpu=left;
	}
	else if(right>-1){
		
		rowCpu=downRight;
		 colCpu=right;
	}
	else{
		rowCpu--;
	}
	Connect[rowCpu][colCpu]=2;
	 yCpu=(float)((205+2.5)+rowCpu*45+22.5);
	 xCpu=(float)(2.5+colCpu*45+22.5);
}





//void pc_player(){
//	
//	//rowCpu=row;
//	//colCpu=col;
//	int left,right,downLeft,downRight,top;
//	top=rowCpu-1;
//	left=colCpu+1;
//	right=colCpu-1;
//	downLeft=rowCpu;
//	downRight=rowCpu;
//	
//	while(top+1<6&&Connect[top+1][colCpu]==0)
//		top++;
//	//rowCpu=top;
//	while(left<7&&(Connect[rowCpu][left]==1||Connect[rowCpu][left]==2)){
//		
//	
//		left++;
//		
//		
//	}
//	if(left<7&&Connect[rowCpu][left]==0){
//		//colCpu=left;
//		while(downLeft+1<6&&Connect[downLeft+1][left]==0)
//			downLeft++;
//		
//	}
//	while(right>-1&&(Connect[rowCpu][right]==1||Connect[rowCpu][right]==2)){
//		
//		right--;
//	}
//	if(right>-1&&Connect[rowCpu][right]==0){
//	//	colCpu=right;
//		while(downRight+1<6&&Connect[downRight+1][right]==0)
//			downRight++;
//	}
//
//	//check for win first
//	//check from top
//	if(top<3&&top>-1&&Connect[rowCpu-1][colCpu]==2&&Connect[rowCpu-2][colCpu]==2&&Connect[rowCpu-3][colCpu]==2){
//		
//			rowCpu=top;
//		//	Connect[rowCpu][colCpu]=2;
//		
//		
//	}
//	else if(left>-1&&left<4&&Connect[downLeft][left+1]==2&&Connect[downLeft][left+2]==2&&Connect[downLeft][left+3]==2)
//{
//		
//			rowCpu=downLeft;
//			colCpu=left;
//		
//		
//	}
//	else if(right>2&&right<7&&Connect[downRight][right-1]==2&&Connect[downRight][right-2]==2&&Connect[downRight][right-3]==2){
//	
//			rowCpu=downRight;
//			colCpu=right;
//		
//	}
//	else{
//
//	if(left<7&&right>-1){
//		 int choice = r.nextInt(2);
//    if(choice==0){
//    	
//			 rowCpu=downRight;
//			 colCpu=right;
//		 }
//		 else
//		 {
//			 rowCpu=downLeft;
//			 colCpu=left;
//		
//		 }
//		
//	}
//	else if(left<7){
//	
//		 rowCpu=downLeft;
//		 colCpu=left;
//	}
//	else if(right>-1){
//		
//		rowCpu=downRight;
//		 colCpu=right;
//	}
//	else{
//		if(rowCpu>0)
//		rowCpu--;
//	}
//	Connect[rowCpu][colCpu]=2;
//	}
//	 yCpu=(float)((205+2.5)+rowCpu*45+22.5);
//	 xCpu=(float)(2.5+colCpu*45+22.5);
//}
	public void setPostion(float x){
		
		x-=2.5;
		col=(int)(x/45);
		condition=false;
		for( row=5;row>=0;row--){
			if(Connect[row][col]==0){
				 yIndex=(float)((205+2.5)+row*45+22.5);
				 xIndex=(float)(2.5+col*45+22.5);
				 if(playing.player==1){
				if(turn%2== 0){
					Connect[row][col]=1;
			
					

				}
				else{
					Connect[row][col]=2;	
				
				}
				
				 }
				 else  if(playing.player==2){
					 //pc
						Connect[row][col]=1;
						pc_player();
				 }
			condition=true;
			
				 break;
			}
		}
	

	}
	public void reset(){
		
		for(int i=0;i<current1;i++){
			Ball1[i].resetBall(1);
		}
		for(int j=0;j<current2;j++){
			Ball2[j].resetBall(2);
		}
		for(int i=0;i<Connect.length;i++)
			for(int j=0;j<Connect[i].length;j++)
				Connect[i][j]=0;
			current1=current2=0;
	}

	
}