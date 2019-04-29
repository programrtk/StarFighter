package starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;
        private Image image;

	public AlienHorde(int size)
	{
            aliens = new ArrayList<Alien>(size);
            
            try
		{
			URL url = getClass().getResource("/images/alien.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
                    System.out.println(e);
		}
	}

	public void add(Alien al)
	{
            aliens.add(new Alien(al.getX(), al.getY(), al.getSpeed()));
	}

	public void drawEmAll( Graphics window )
	{
            for(Alien a : aliens){
                window.drawImage(image ,a.getX(),a.getY(),a.getWidth(),a.getHeight(),null);
            }
            
            moveEmAll(window);
	}

	public void moveEmAll(Graphics window)
	{
            for(Alien a : aliens)
            {
                a.setX(a.getX() + a.getSpeed());
                System.out.println("xPosition: "+a.getX() +" ,Speed: "+a.getSpeed());
                if(a.getX() == 780)
                {
                    a.setY(a.getY() + 30);
                    a.setX(10);
                }
            }
            
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
	}

	public String toString()
	{
		return "";
	}
}
