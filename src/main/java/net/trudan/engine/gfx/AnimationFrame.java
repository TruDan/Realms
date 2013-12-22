package net.trudan.engine.gfx;

public class AnimationFrame {
	
	private int length;
	private Sprite sprite;
	private int numDisplayed;
	
	public AnimationFrame(Sprite sprite, int length) {
		this.sprite = sprite;
		this.length = length;
		numDisplayed = 0;
	}

	public boolean render() {
		
		sprite.render();
		numDisplayed++;
		
		if(numDisplayed >= length) {
			numDisplayed = 0;
			return true;
		}
		return false;
	}
	
}
