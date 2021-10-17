package shooter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JPanel implements KeyListener,ActionListener  {

	JFrame j=new JFrame();
	JButton start=new JButton();
	JButton exit=new JButton();
	JLabel img=new JLabel();
	Menu(){
		
		this.setBackground(Color.BLACK);
		this.setForeground(Color.BLACK);
		j.add(this);
				
		img.setBackground(Color.BLACK);
		img.setSize(1174,689);
		img.setIcon(new ImageIcon("images/7.jpg"));
		j.add(img,BorderLayout.CENTER);
		
		start.setBackground(Color.BLACK);
		start.setIcon(new ImageIcon("images/8.png"));
		start.addKeyListener(this);
		start.addActionListener(this);
		j.add(start,BorderLayout.PAGE_START);
		
		
		exit.setBackground(Color.BLACK);
		exit.setIcon(new ImageIcon("images/9.png"));
		exit.setOpaque(true);
		exit.addKeyListener(this);
		exit.addActionListener(this);
		j.add(exit,BorderLayout.PAGE_END);
		
		j.setSize(1174,689);
		j.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent p) {
		if(p.getSource()==exit) {
			j.dispose();
		}
		if(p.getSource()==start) {
			Level n=new Level();
			j.dispose();
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent kp) {

	}
	@Override
	public void keyReleased(KeyEvent ae) {
		
		
	}
	
}
