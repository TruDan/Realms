package net.trudan.engine;

import static org.lwjgl.opengl.GL11.*;
import net.trudan.engine.gfx.Animation;


public class TruObject {

	private float x;
	private float y;
	private float sizeX;
	private float sizeY;
	private Animation anim;
	
	public TruObject() {
		anim = new Animation();
	}
	
	public void update() {
	}
	
	public void render() {
		glPushMatrix();
		glTranslatef(x,y,0);
		
		anim.render();
		
		glPopMatrix();
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getSizeX() {
		return sizeX;
	}

	public void setSizeX(float sizeX) {
		this.sizeX = sizeX;
	}

	public float getSizeY() {
		return sizeY;
	}

	public void setSizeY(float sizeY) {
		this.sizeY = sizeY;
	}

	public Animation getAnim() {
		return anim;
	}

	public void setAnim(Animation anim) {
		this.anim = anim;
	}
	
}
