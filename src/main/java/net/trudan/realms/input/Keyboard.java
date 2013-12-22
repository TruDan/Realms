package net.trudan.realms.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[120];
	public boolean mup, mdown, mleft, mright, pup, pdown, pleft, pright;

	public void tick() {
		mup = keys[KeyEvent.VK_UP];
		mdown = keys[KeyEvent.VK_DOWN];
		mleft = keys[KeyEvent.VK_LEFT];
		mright = keys[KeyEvent.VK_RIGHT];
		pup = keys[KeyEvent.VK_W];
		pdown = keys[KeyEvent.VK_S];
		pleft = keys[KeyEvent.VK_A];
		pright = keys[KeyEvent.VK_D];
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {

	}
	
	public boolean[] getKeys() {
		return keys;
	}

}
