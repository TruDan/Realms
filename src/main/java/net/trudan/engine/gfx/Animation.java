package net.trudan.engine.gfx;

import java.util.ArrayList;

public class Animation {

	private ArrayList<AnimationFrame> frames;
	private int curFrame;

	public Animation() {
		frames = new ArrayList<AnimationFrame>();
		frames.add(new AnimationFrame(new Sprite(50,50),10));
	}

	public void render() {
		AnimationFrame tempFrame = frames.get(curFrame);
		if(tempFrame.render()) {
			curFrame++;
			curFrame %= frames.size();
		}
	}
}
