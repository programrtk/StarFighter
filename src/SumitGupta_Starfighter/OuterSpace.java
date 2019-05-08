package SumitGupta_Starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;
        private Ammo ammoOne;
        private Boolean shoot = false;
        
        private AlienHorde horde, horde2;
	
        private Bullets shots;
	

	private boolean[] keys;
	private BufferedImage back;
        
        private int NumOfAliens;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[6];

                System.out.println("Sumit Gupta, P. 1, 5/8/2019, Computer #11");
                
		//instantiate other instance variables
                ship = new Ship();
		//Ship, Alien
                
                alienOne = new Alien(90,40, 1);
                
                alienTwo = new Alien(150, 40, 1);
                
		shots = new Bullets();
                
                NumOfAliens = 10;
                
                horde = new AlienHorde(NumOfAliens);
                
                //horde2 = new AlienHorde(NumOfAliens);
                
                for(int i = 0; i < NumOfAliens; i++)
                {
                    horde.add(new Alien(55*i, 30, 1));
                    
                    horde.add(new Alien(55*i + 30, 70, 1));
                }
                
                
                
                
                this.addKeyListener(this);
		
                new Thread(this).start();
		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and save it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
                
                
                ship.draw(graphToBack);
                
                alienOne.draw(graphToBack);
                alienTwo.draw(graphToBack);
               
                horde.drawEmAll(graphToBack);
               
                //this is where I have aliens shoot
                for(int i = 0; i < NumOfAliens; i = i+2){
                    ammoOne = new Ammo(horde.get(i).getX() + 10, horde.get(i).getY() + 25);
                    ammoOne.draw(graphToBack);
                }
                
                horde.removeDeadOnes(shots.getList());
             
		if(keys[0] == true)
		{
                    ship.move("LEFT");
		}

		//add code to move Ship, Alien, etc.
                if(keys[1] == true)
		{
                    ship.move("RIGHT");
		}
                
                if(keys[2] == true)
		{
                    ship.move("DOWN");
		}
                
                if(keys[3] == true)
		{
                    ship.move("UP");
		}
                
                if(keys[4] == true)
                {   
                    //ammoOne = new Ammo(ship.getX() + 20, ship.getY());
                    
                    shots.add(new Ammo(ship.getX() + 20, ship.getY()));
                    
                    //System.out.println("shots size: " + shots.getSize());
                    
                    shots.drawEmAll(graphToBack);
                    
                    //shoot = true;
                    
                }else if(keys[4] == false)
                {
                    shots.cleanEmUp();
                }
                
                if(shoot){
                    
                    //draws and moves the ammo
                    //ammoOne.draw(graphToBack);
                    
                    //shoot is false when ammo is out of screen
                    if(ammoOne.getY() == 0){
                        shoot = false;
                    }
                }
                
                if(keys[5] == true){
                    
                }

		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship

		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
                if (e.getKeyCode() == KeyEvent.VK_S)
                {
                        keys[5] = true;
                }
		//repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
                if  (e.getKeyCode() == KeyEvent.VK_S){
                        
                        keys[5] = false;
                }
		//repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

