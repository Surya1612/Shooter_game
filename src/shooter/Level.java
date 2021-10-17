package shooter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Level extends JPanel implements KeyListener,ActionListener{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame s=new JFrame();
	String [] b= {"Easy","Beginner"," Novice"};
	JComboBox level=new JComboBox(b);
	JButton enter=new JButton();
	JButton exit=new JButton();
	Font c= new Font("bold",Font.BOLD,25);

	
	Level(){
		s.add(this);
		try {
			File fi=new File("sound//POL-treasure-match-short.wav");
			AudioInputStream ai=AudioSystem.getAudioInputStream(fi);
			Clip c=AudioSystem.getClip();
			c.open(ai);
			c.start();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		this.setBackground(Color.BLACK);
		
		
		s.add(level,BorderLayout.PAGE_START);
		level.setBackground(Color.BLACK);
		level.setForeground(Color.WHITE);
		level.setFont(c);
		
		exit.setFont(c);
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		exit.setText("Exit");
		exit.addKeyListener(this);
		exit.addActionListener(this);
		s.add(exit,BorderLayout.PAGE_END);
		
		
		enter.setBackground(Color.BLACK);
		enter.setIcon(new ImageIcon("images/6.jpg"));
		enter.addKeyListener(this);
		enter.addActionListener(this);
		s.add(enter,BorderLayout.CENTER);
		
		s.setSize(1174,689);
		s.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit) {
			s.dispose();
			Menu m=new Menu();
		}else if(e.getSource()==enter && level.getSelectedIndex()==0) {
			GhostLevel ob=new GhostLevel();
			s.dispose();
		}else if(e.getSource()==enter && level.getSelectedIndex()==1) {
			JOptionPane.showMessageDialog(null, "Coming soon!!");
		}else if(e.getSource()==enter && level.getSelectedIndex()==2) {
			JOptionPane.showMessageDialog(null, "Coming soon!!");
		}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			s.dispose();
		}else if(e.getKeyCode()==KeyEvent.VK_ENTER && level.getSelectedIndex()==0) {
			GhostLevel ob=new GhostLevel();
			s.dispose();
		}else if(e.getKeyCode()==KeyEvent.VK_ENTER && level.getSelectedIndex()==1) {
			JOptionPane.showMessageDialog(null, "Coming soon!!");
		}else if(e.getKeyCode()==KeyEvent.VK_ENTER && level.getSelectedIndex()==2) {
			JOptionPane.showMessageDialog(null, "Coming Soon!!");
		}
	}
	
	
}
