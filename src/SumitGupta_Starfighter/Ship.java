package SumitGupta_Starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;
        //private MovingThing m;

	public Ship()
	{
            this(75, 440, 50, 50, 0);
            speed = 1;
	}

	public Ship(int x, int y)
	{
	   //add code here
           this(x, y, 50, 50, 0);
           speed = 1;
	}

	public Ship(int x, int y, int s)
	{
	   //add code here
           this(x, y, 50, 50, s);
           //this.speed = s;
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
                //m.setSpeed(s);
		try
		{
			URL url = getClass().getResource("/starfighter/images/ship.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
                    System.out.println(e);
		}
	}


	public void setSpeed(int s)
	{
	   //add more code
            this.speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(String direction)
	{
		//add code here
            if(direction.equals("LEFT")){
                setX(getX() - speed);
            }
            if(direction.equals("RIGHT")){
                setX(getX() + speed);
            }
            if(direction.equals("UP")){
                setY(getY() + speed);
            }
            if(direction.equals("DOWN")){
                setY(getY() - speed);
            }
            //System.out.println(getX() +", "+ getY());
	}

	public void draw( Graphics window )
	{
            window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + "" + getSpeed();
	}
}
