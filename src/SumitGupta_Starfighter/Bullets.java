package SumitGupta_Starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class Bullets
{
	private List<Ammo> bullet;

	public Bullets()
	{
            bullet = new ArrayList<Ammo>();
	}

	public void add(Ammo al)
	{
            bullet.add(new Ammo(al.getX(), al.getY()));
            //System.out.println("Size: "+ bullet.size() + ", xPos: "+ al.getX()+ ", yPos: "+ al.getY());
	}
        
        public int getSize()
	{
            return bullet.size();
	}

	//post - draw each Ammo
	public void drawEmAll( Graphics window )
	{
            window.setColor(Color.YELLOW);
            for(Ammo a : bullet)
            {
                window.fillRect(a.getX(), a.getY(), 10, 12);
            }
            
            moveEmAll();
	}

	public void moveEmAll()
	{
            for(Ammo a : bullet){
                a.setY(a.getY() - 20);
            }
            
            //drawEmAll(window);
	}

	public void cleanEmUp()
	{
            bullet.clear();
	}

	public List<Ammo> getList()
	{
		return bullet;
	}
                
	public String toString()
	{
		return "";
	}
}
