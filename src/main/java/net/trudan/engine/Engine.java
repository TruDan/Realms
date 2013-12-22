package net.trudan.engine;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import net.trudan.realms.Realms;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.input.Keyboard;

public class Engine {
	
	private static Realms realms;

	public static void main(String args[]) {
		
		initDisplay();
		initGL();
		
		realms = new Realms();
		
		while (!Display.isCloseRequested()) {
			getInput();
			update();
			render();
		}
		
		clean();
	}

	
	private static void getInput() {
		realms.getInput();
	}
	
	private static void update() {
		realms.update();
	}
	
	private static void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
		
		realms.render();
		
		Display.update();
		Display.sync(60);
	}

	private static void clean() {
		Display.destroy();
		Keyboard.destroy();
	}
	
	private static void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(900, 500));
			Display.create();
			Keyboard.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	private static void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity(); // Clear existing data
		glOrtho(0,Display.getWidth(),0,Display.getHeight(),1,-1); // Set to size of screen, -1,1 means NO Z index
		
		glMatrixMode(GL_MODELVIEW);
		
		glDisable(GL_DEPTH_TEST);
		glClearColor(0,0,0,0); // Transparent colour
	}
	
}
