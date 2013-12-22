package net.trudan.realms.level;

import java.awt.event.KeyEvent;



import net.trudan.engine.Engine;
import net.trudan.realms.level.tile.Terrain;
import net.trudan.realms.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tiles;
	protected boolean paused = false;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();

	}

	public Level(String path) {
		loadLevel(path);
	}

	protected void generateLevel() {

	}

	private void loadLevel(String path) {

	}

	public void tick() {
		if(Engine.getKeyboard().getKeys()[KeyEvent.VK_ESCAPE]) {
			if(paused) {
				paused = false;
			}
			else {
				paused = true;
			}
		}
	}
	
	public boolean isPaused() {
		return paused;
	}

	@SuppressWarnings("unused")
	private void time() {

	}

	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) return Terrain.ID_0;
		
		if (tiles[x + y * width] == 0) return Terrain.ID_1;
		if (tiles[x + y * width] == 1) return Terrain.ID_2;
		if (tiles[x + y * width] == 2) return Terrain.ID_3;
		if (tiles[x + y * width] == 3) return Terrain.ID_4;
		if (tiles[x + y * width] == 4) return Terrain.ID_5;
		if (tiles[x + y * width] == 5) return Terrain.ID_6;
		if (tiles[x + y * width] == 6) return Terrain.ID_7;
		
		return Terrain.ID_0;
	}

}
