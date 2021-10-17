package shooter;

import java.awt.Rectangle;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Fire extends Thread {

	Bullet bullet;
	GhostLevel gl;
	Ghost[][] ghost;
	public static int score=0;
	Fire(Bullet bullet,GhostLevel gl,Ghost[][] ghost){
		this.bullet=bullet;
		this.gl=gl;
		this.ghost=ghost;
	}
	
	public void run() {
		while(bullet.getX()>-100) {
			bullet.setY(bullet.getY()-10);
			check();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			gl.repaint();
		}
		
	}
	
	public void check() {
		Rectangle bulletRect=new Rectangle(bullet.getX(),bullet.getY(),13,40);
		for(int i=0;i<ghost.length;i++) {
			for(int j=0;j<ghost[i].length;j++) {
				Rectangle ghostRect	= new Rectangle(ghost[i][j].getX(),ghost[i][j].getY(),25,25);
				if(bulletRect.intersects(ghostRect)) {
				
					ghost[i][j].setX(50000);
					bullet.setX(-50000);
					score++;
					try {
						File fi=new File("sound//mixkit-retro-game-notification-212.wav");
						AudioInputStream ai=AudioSystem.getAudioInputStream(fi);
						Clip c=AudioSystem.getClip();
						c.open(ai);
						c.start();
						
					}catch(Exception e) {
						System.out.println(e);
					}
					
				}
			}
		}
	}
}
