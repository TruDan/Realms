package net.trudan.realms.level.tile;

import net.trudan.realms.graphics.Sprite;
import net.trudan.realms.graphics.SpriteSheet;

public enum Terrain implements Tile {
	
	ID_0(0,"Air",new Sprite(32,0x333333),true),
	ID_1(1,"Grass 1",new Sprite(32,0,0,SpriteSheet.terrain)),
	ID_2(2,"Grass 2",new Sprite(32,1,0,SpriteSheet.terrain)),
	ID_3(3,"Grass 3",new Sprite(32,2,0,SpriteSheet.terrain)),
	ID_4(4,"Grass 4",new Sprite(32,3,0,SpriteSheet.terrain)),
	ID_5(5,"Grass 5",new Sprite(32,4,0,SpriteSheet.terrain)),
	ID_6(6,"Grass 6",new Sprite(32,5,0,SpriteSheet.terrain)),
	ID_7(7,"Grass 7",new Sprite(32,6,0,SpriteSheet.terrain)),
	;
	
	private Sprite sprite;
	private int ID;
	private String name;
	private boolean solid = false;
	
	Terrain(int ID, String name, Sprite sprite) {
		this.ID = ID;
		this.name = name;
		this.sprite = sprite;
	}
	
	Terrain(int ID, String name, Sprite sprite, boolean solid) {
		this(ID,name,sprite);
		this.solid = solid;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return ID;
	}
	
	public boolean isSolid() {
		return solid;
	}
}