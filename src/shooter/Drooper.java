package shooter;

public class Drooper extends Thread {

	
	GhostLevel gl;
	Ghost[][] ghost;
	
	Drooper(GhostLevel gl,Ghost[][] ghost){
		
		this.ghost=ghost;
		this.gl=gl;
		
	}
	public void run() {
		
		while(ghost[0][0].getX()<700) {
			for(int i=0;i<ghost.length;i++) {
				for(int j=0;j<ghost[i].length;j++) {
					
					ghost[i][j].setY(ghost[i][j].getY()+20);
					System.out.println(ghost[i][j].getY());
				}
			}
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println(e);
			}
			gl.repaint();
		}
	}
	
	
}
