package net.trudan.realms.level.tile;

import net.trudan.realms.graphics.Sprite;
import net.trudan.realms.graphics.SpriteSheet;

public interface Tile {
	
	public Sprite sprite = null;
	public boolean solid = false;
	
	public Sprite getSprite();
	public boolean isSolid();
	
	
}
