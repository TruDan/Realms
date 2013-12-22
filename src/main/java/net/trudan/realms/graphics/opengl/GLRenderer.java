package net.trudan.realms.graphics.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class GLRenderer {

	public GLRenderer() {

		initDisplay();
		initGL();

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
	
	public static void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
		
		Display.update();Display.sync(60);
	}
	
	public static void clean() {
		Display.destroy();
	}

}
