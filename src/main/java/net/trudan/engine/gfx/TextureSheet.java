package net.trudan.engine.gfx;

import java.io.IOException;
import java.util.ArrayList;

import net.trudan.engine.Engine;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureSheet {

	private Texture sheet;
	
	private ArrayList<TruTexture> textures;

	public TextureSheet(String name) {
		try {
			sheet = TextureLoader.getTexture("PNG", Engine.class.getResourceAsStream("/textures/" + name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
