package net.trudan.realms.entity;

import java.util.Random;

import net.trudan.realms.graphics.Screen;
import net.trudan.realms.level.Level;


public class Entity {

	public int x,y;
	private boolean removed = false;
	
	protected Level level;
	protected final Random random = new Random();
	
	public void tick() {
		
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
}
