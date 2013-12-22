package net.trudan.realms.graphics.gui;

import net.trudan.realms.graphics.AdvancedSprite;
import net.trudan.realms.graphics.Screen;
import net.trudan.realms.graphics.Sprite;

public class PauseGUI extends GUI {

	public PauseGUI(Screen screen) {
		super(screen);
	}

	public void render() {
		screen.renderAdvSprite(120,100,(AdvancedSprite) Sprite.guiButton);
	}

}
