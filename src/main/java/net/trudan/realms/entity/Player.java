package net.trudan.realms.entity;

import net.trudan.realms.graphics.Screen;
import net.trudan.realms.graphics.Sprite;
import net.trudan.realms.input.Keyboard;

public class Player extends LivingEntity {

	@SuppressWarnings("unused")
	private int health;
	@SuppressWarnings("unused")
	private int mana;

	private Keyboard input;

	public Player(Keyboard input) {
		this.input = input;
		this.x = 50;
		this.y = 100;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	public void tick() {
		super.tick();
		int xa = 0, ya = 0;
		if (input.pup) ya--;
		if (input.pdown) ya++;
		if (input.pleft) xa--;
		if (input.pright) xa++;
		if (xa != 0 || ya != 0) move(xa, ya);
	}

	public void render(Screen screen) {
		if (isMoving()) {
			if (direction == 0) sprite = Sprite.playerF;
			if (direction == 1) sprite = Sprite.playerR;
			if (direction == 2) sprite = Sprite.playerB;
			if (direction == 3) sprite = Sprite.playerL;
		} else {
			if (direction == 0) sprite = Sprite.playerFS;
			if (direction == 1) sprite = Sprite.playerRS;
			if (direction == 2) sprite = Sprite.playerBS;
			if (direction == 3) sprite = Sprite.playerLS;

		}
		screen.renderPlayer(x, y, sprite);
	}

}
