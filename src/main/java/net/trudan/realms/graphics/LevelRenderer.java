package net.trudan.realms.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import net.trudan.realms.Realms;
import net.trudan.realms.graphics.gui.PauseGUI;
import net.trudan.realms.level.Level;

public class LevelRenderer extends Renderer {
	
	private Level level;
	private PauseGUI pauseGUI;

	public LevelRenderer(Realms realms, Screen screen, Level level) {
		super(realms, screen);
		this.level = level;
		this.pauseGUI = new PauseGUI(screen);
		addGUI(pauseGUI);
	}

	public void render(BufferStrategy bs) {
		super.render(bs);
		
		renderLevel();
		
		getPlayer().render(screen);
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();

		g.drawImage(image, 0, 0, screen.getWidth()*Realms.scale, screen.getHeight()*Realms.scale, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 10));
		g.drawString("TL Tile X: " + (getRenderX() / Realms.tileSize) + ", Y:" + (getRenderY() / Realms.tileSize), 5, 10);
		g.drawString("Player  X: " + (getPlayer().x / Realms.tileSize) + ", Y:" + (getPlayer().y / Realms.tileSize) + ", D: " + getPlayer().direction, 5, 20);

		g.drawString("TPS: " + realms.getTPS() + ", FPS:" + realms.getFPS(), 5, 30);

		g.dispose();
	}
	
	private void renderLevel() {
		screen.setOffset(getRenderX(), getRenderY());
		int x0 = getRenderX();
		int x1 = (getRenderX() + screen.getWidth() + Realms.tileSize) / Realms.tileSize;
		int y0 = getRenderY();
		int y1 = (getRenderY() + screen.getHeight() + Realms.tileSize) / Realms.tileSize;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				screen.renderTile(x * Realms.tileSize, y * Realms.tileSize, level.getTile(x, y));
			}
		}
		
		if(level.isPaused()) {
			pauseGUI.render();
		}
	}

}
