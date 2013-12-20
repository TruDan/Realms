package net.trudan.realms.level.tile;

import net.trudan.realms.graphics.Sprite;
import net.trudan.realms.graphics.SpriteSheet;

public enum Tile {
	
	AIR(new Sprite(16,0x333333),true),
	DIRT(new Sprite(16, 1, 0, SpriteSheet.tiles)),
	GRASS(new Sprite(16, 0, 0, SpriteSheet.tiles)),
	;
	
	private Sprite sprite;
	private boolean solid;
	
	
	Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	Tile(Sprite sprite, boolean solid) {
		this.sprite = sprite;
		this.solid = solid;
	}
	
	public boolean isSolid() {
		return solid;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
}
