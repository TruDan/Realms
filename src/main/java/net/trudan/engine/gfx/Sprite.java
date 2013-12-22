package net.trudan.engine.gfx;

import static org.lwjgl.opengl.GL11.*;

public class Sprite {
	
	private float sizeX;
	private float sizeY;
	
	public Sprite(float sizeX, float sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public void render() {
		glBegin(GL_QUADS);
		
		glColor3f(60,0,0);
		glVertex2f(0,0);
		glVertex2f(0,sizeY);
		glVertex2f(sizeX,sizeY);
		glVertex2f(sizeX,0);
		
		glEnd();
	}

}
