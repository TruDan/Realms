package net.trudan.realms.level;

import net.trudan.realms.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tiles;

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

	}

	@SuppressWarnings("unused")
	private void time() {

	}

	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.AIR;
		
		if (tiles[x + y * width] == 0) return Tile.GRASS;
		if (tiles[x + y * width] == 1) return Tile.GRASS;
		if (tiles[x + y * width] == 2) return Tile.GRASS;
		
		return Tile.DIRT;
	}

}
