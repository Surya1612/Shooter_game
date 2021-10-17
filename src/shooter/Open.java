package shooter;

import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Open extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f=new JFrame();
	Open(){
		f.add(this);
		try {
			File fi=new File("sound//1.wav");
			AudioInputStream ai=AudioSystem.getAudioInputStream(fi);
			Clip c=AudioSystem.getClip();
			c.open(ai);
			c.start();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		f.setSize(1174,689);
		f.setVisible(true);
		try {
			Thread.sleep(8000);
			f.dispose();
			Menu m=new Menu();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	 public void paint (Graphics g) {
	  ImageIcon i=new ImageIcon("images//1.jpg");
	  g.drawImage(i.getImage(),0,0,null);
	 }
}
