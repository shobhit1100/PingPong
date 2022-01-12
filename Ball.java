package com.main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	public static final int SIZE  = 16;
	private int x,y;
	private int xVEL , yVEL;
	private int speed = 5;
	public Ball()
	{
		reset();
	}
	private void reset() {
		// TODO Auto-generated method stub
		x = Game.WIDTH/2 - SIZE/2;
		x = Game.HEIGHT/2 - SIZE/2;
		xVEL = Game.sign(Math.random()*2.0 -1);
		yVEL = Game.sign(Math.random()*2.0 -1);
		
	}
	
	public void changeYDirection()
	{
		yVEL *= -1;
	}
	
	public void changeXDirection()
	{
		xVEL *= -1;
	}
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.fillRect(x, y, SIZE, SIZE);
	}
	public void update(Paddle paddle1, Paddle paddle2) {
		x += xVEL * speed;
		y += yVEL * speed;
		
		if(y+SIZE >= Game.HEIGHT || y <= 0)
		{
			changeYDirection();
		}
		
		if(x + SIZE >= Game.WIDTH)
		{
			paddle1.addPoint();
			reset();
		}
		if(x <= 0)
		{
			paddle2.addPoint();
			reset();
		}
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
