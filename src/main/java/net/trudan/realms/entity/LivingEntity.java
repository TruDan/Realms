package net.trudan.realms.entity;

import net.trudan.engine.Engine;
import net.trudan.realms.graphics.Sprite;

public abstract class LivingEntity extends Entity {

	protected Sprite sprite;
	public int direction = 0;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		moving = true;
		if (ya < 0) direction = 0;
		if (ya > 0) direction = 2;
		if (xa < 0) direction = 3;
		if (xa > 0) direction = 1;

		if (!collision(x + xa, y + ya)) {
			x += xa;
			y += ya;
		}
	}

	public void tick() {
		moving = false;
	}

	private boolean collision(int x, int y) {
		for (int c = 0; c < 4; c++) {
			int xt = (x + c % 2 * 8 + 4) / 16;
			int yt = (y + c / 2 * 10 + 6) / 16;
			if (Engine.getLevel().getTile(xt, yt).isSolid()) return true;
			if(xt < 0 || yt < 0) return true;
		}
		return false;
	}

	public boolean isMoving() {
		return moving;
	}
}
