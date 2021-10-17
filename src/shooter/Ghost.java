package shooter;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Ghost {

	
	private int x;
	private int y;
	private String image;
	

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Ghost(int x, int y, String image) {
		super();
		this.x = x;
		this.y = y;
		this.image = image;
	}


	public void drawGhost(Graphics g) {
		  ImageIcon i=new ImageIcon(image);
		  g.drawImage(i.getImage(),x,y,null);
		 }
}
