package shooter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GhostLevel extends JPanel implements KeyListener{
	
	JFrame s=new JFrame();
	Shooter shooter=new Shooter(500,500,"images//s.png");
	Ghost[][] ghost=new Ghost[2][23];
	int x=0;
	int y=0;
	Bullet[] bullets=new Bullet[1000];
	int count=0;
	Drooper drooper=new Drooper(this,ghost);
	Font c= new Font("bold",Font.BOLD,20);
	private boolean fail=false;
	
	GhostLevel(){
		this.setFocusable(true);
		this.addKeyListener(this);
		
		s.add(this);
		
		for(int i=0;i<ghost.length;i++)
		{
			for(int j=0;j<ghost[i].length;j++)
			{
				ghost[i][j]=new Ghost(x,y,"images//b1.png");
				x+=50;
			}
			y+=50;
			x=0;
		}
		drooper.start();
		for(int i=0;i<bullets.length;i++) {
		 bullets[i]= new Bullet(350,650,"images//l.png");
		 
		}
		
		
		s.setSize(1174,689);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setVisible(true);
	}

	
	 public void paint (Graphics g) {
		  ImageIcon i=new ImageIcon("images//8.jpg");
		  g.drawImage(i.getImage(),0,0,null);
		  
		 
		  
		  for(int i1=0;i1<ghost.length;i1++)
			{
				for(int j=0;j<ghost[i1].length;j++)
				{
					ghost[i1][j].drawGhost(g);
					
				}
				
			}
		  for(int i2=0;i2<bullets.length;i2++) {
				 bullets[i2].drawBullet(g);
				 
				}
		  
		  shooter.drawShooter(g);
		  
		  g.setColor(Color.WHITE);
		  g.setFont(c);
		  g.drawString("Score = "+Fire.score, 1000, 600);
		  
		  LevelFailed();
		  LevelComplete();
		 }
	 
	 
	public void LevelFailed() {
		
	for(int i=0;i<ghost.length;i++) 
	{
		for(int j=0;j<ghost[i].length;j++) {
			if(ghost[i][j].getY()>400) {
				fail=true;	
			}
		}
		if(fail==true) {
			s.dispose();
			drooper.stop();
			
			try {
				File fi=new File("sound//mixkit-arcade-retro-game-over-213.wav");
				AudioInputStream ai=AudioSystem.getAudioInputStream(fi);
				Clip c=AudioSystem.getClip();
				c.open(ai);
				c.start();
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
			JOptionPane.showMessageDialog(null, "You have failed!","Game Over", JOptionPane.ERROR_MESSAGE);
			Menu m=new Menu();
			Fire.score=0;
		}
	}

	}
	public void LevelComplete() {
		if(Fire.score>=10) {
			drooper.stop();
			s.dispose();
			
		
			try {
				File fi=new File("sound//mixkit-coin-win-notification-1992.wav");
				AudioInputStream ai=AudioSystem.getAudioInputStream(fi);
				Clip c=AudioSystem.getClip();
				c.open(ai);
				c.start();
				
			}catch(Exception e) {
				System.out.println(e);
			}
			JOptionPane.showMessageDialog(null, "Level Complete");
			try {
				Thread.sleep(100);
			}catch(Exception e) {
				System.out.println(e);
			}
			Menu m=new Menu();
			Fire.score=0;
			
		}
	}
	
	@Override
	public void keyTyped(KeyEvent kp) {


	}

	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(shooter.getX()<805)
				shooter.setX(shooter.getX()+5);
			this.repaint();
		}
		else if(kp.getKeyCode()==KeyEvent.VK_LEFT) {
			if(shooter.getX()>=-30) {
				shooter.setX(shooter.getX()-5);	
			}
			this.repaint();
		}
		else if(kp.getKeyCode()==KeyEvent.VK_SPACE) {
			try {
				File fi=new File("sound//gun-gunshot-01.wav");
				AudioInputStream ai=AudioSystem.getAudioInputStream(fi);
				Clip c=AudioSystem.getClip();
				c.open(ai);
				c.start();
				
			}catch(Exception e) {
				System.out.println(e);
			}
			bullets[count].setX(shooter.getX()+50);
			Fire f=new Fire(bullets[count],this,ghost);
			bullets[count].setY(shooter.getY()+10);
			f.start();
			count++;
		}
	}

	@Override
	public void keyReleased(KeyEvent kp) {
	}

}
