package net.trudan.realms.graphics;

import net.trudan.engine.Engine;

public class AnimatedSprite extends Sprite {

	private int currentAnim;
	private Sprite[] sprites;
	private int xFrom, xTo, yFrom, yTo;
	private int speed,prevTick,tickCounter = 0;

	public AnimatedSprite(int size, int xFrom, int xTo, int yFrom, int yTo, int speed, SpriteSheet sheet) {
		super(size, 0xFFFF00FF);
		this.xFrom = xFrom;
		this.xTo = xTo;
		this.yFrom = yFrom;
		this.yTo = yTo;
		this.speed = speed;
		this.sheet = sheet;
		loadAnim();
	}

	public void loadAnim() {

		sprites = new Sprite[(xTo - xFrom + 1) * (yTo - yFrom + 1)];

		int i = 0;
		for (x = xFrom; x <= xTo; x++) {
			for (y = yFrom; y <= yTo; y++) {
				sprites[i] = new Sprite(SIZE, x, y, sheet);
				i++;

			}
		}
		System.out.println(i);
	}

	public int[] getPixels() {
		if (Engine.getTick() != prevTick) {
			prevTick = Engine.getTick();
			tickCounter++;
		}
		if(tickCounter == speed) {
			tickCounter = 0;
			if (currentAnim < (sprites.length - 1)) currentAnim++;
			else
				currentAnim = 0;
		}
		return sprites[currentAnim].pixels;
	}
}
