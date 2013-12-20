package net.trudan.realms.graphics;

import net.trudan.realms.level.tile.Tile;

public class Screen {

	public int width;
	public int height;
	public int[] pixels;
	public final int MAP_SIZE = 4;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;

	public int xOffset, yOffset;

	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;

		for (int y = 0; y < tile.getSprite().SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.getSprite().SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.getSprite().SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;

				pixels[xa + ya * width] = tile.getSprite().pixels[x + y * tile.getSprite().SIZE];
			}
		}
	}

	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		int[] spixels = sprite.getPixels();

		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;

				if (spixels[x + y * sprite.SIZE] != 0xFFFF00FF) pixels[xa + ya * width] = spixels[x + y * sprite.SIZE];
			}
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

}
