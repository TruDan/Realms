package net.trudan.realms.graphics;


public class Sprite {

	public int SIZE;
	protected int x, y;
	public int[] pixels;
	protected SpriteSheet sheet;
	
	public static Sprite guiButton = new AdvancedSprite(64,16,0,0,SpriteSheet.gui);
	
	public static Sprite playerF = new AnimatedSprite(16,0,1,1,1,10,SpriteSheet.tiles);
	public static Sprite playerB = new AnimatedSprite(16,0,1,3,3,10,SpriteSheet.tiles);
	public static Sprite playerL = new AnimatedSprite(16,0,1,4,4,10,SpriteSheet.tiles);
	public static Sprite playerR = new AnimatedSprite(16,0,1,2,2,10,SpriteSheet.tiles);
	public static Sprite playerFS = new Sprite(16,0,1,SpriteSheet.tiles);
	public static Sprite playerBS = new Sprite(16,0,3,SpriteSheet.tiles);
	public static Sprite playerLS = new Sprite(16,0,4,SpriteSheet.tiles);
	public static Sprite playerRS = playerLS.flip();

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
	}
	
	protected Sprite() {
		// do nothing
	}
	
	private void setColour(int colour) {
		for(int i = 0; i < SIZE*SIZE;i++) {
			pixels[i] = colour;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
	
	public int[] getPixels() {
		return pixels;
	}
	
	private Sprite flip() {
		Sprite sprite = new Sprite(SIZE,x/SIZE,y/SIZE,sheet);
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				sprite.pixels[x + y * SIZE] = pixels[(SIZE-1-x) + y * SIZE];
			}
		}
		return sprite;
	}
}
