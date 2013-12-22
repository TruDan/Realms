package net.trudan.realms.graphics;

public class AdvancedSprite extends Sprite {
	
	private int sizeX, sizeY;

	public AdvancedSprite(int sizeX, int sizeY, int x, int y, SpriteSheet sheet) {
		super();
		this.pixels = new int[sizeX*sizeY];
		this.sheet = sheet;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.x = x;
		this.y = y;
		loadAdvSprite();
	}
	
	private void loadAdvSprite() {
		for (int y = 0; y < sizeY; y++) {
			for (int x = 0; x < getSizeX(); x++) {
				pixels[x + y * sizeX] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}
	
}
