package net.trudan.engine;

import java.awt.Rectangle;

public class Physics {

	public static boolean checkCollision(TruObject obj1, TruObject obj2) {
		Rectangle r1 = new Rectangle((int) obj1.getX(),(int) obj1.getSizeX(),(int) obj1.getY(),(int) obj1.getSizeY());
		Rectangle r2 = new Rectangle((int) obj2.getX(),(int) obj2.getSizeX(),(int) obj2.getY(),(int) obj2.getSizeY());
				
		return r1.intersects(r2);
	}
	
}
