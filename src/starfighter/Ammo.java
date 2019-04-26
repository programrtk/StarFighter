package starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
            this(30,30,0);
	}

	public Ammo(int x, int y)
	{
		//add code
            this(x, y, 3);
	}

	public Ammo(int x, int y, int s)
	{
		//add code
            super(x, y, 8, 8);
            speed = s;
	}
        
	public void setSpeed(int s)
	{
	   //add code
            this.speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		//add code to draw the ammo
            window.setColor(Color.yellow);
            //window.fillRect(71, 54, 2, 5);
            window.fillRect(getX(), getY(), getWidth(), getHeight());
            
            move("ShootUp");
	}
	
	
	public void move( String direction )
	{
		//add code to draw the ammo
            if(direction.equals("ShootDown"))
            {
                setY(getY() + speed);
            }
            
            if(direction.equals("ShootUp"))
            {
                setY(getY() - speed);
            }
            
	}

	public String toString()
	{
		return "";
	}
}
