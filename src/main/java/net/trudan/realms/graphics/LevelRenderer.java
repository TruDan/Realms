package net.trudan.realms.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import net.trudan.engine.Engine;
import net.trudan.realms.graphics.gui.PauseGUI;
import net.trudan.realms.level.Level;

public class LevelRenderer extends Renderer {
	
	private Level level;
	private PauseGUI pauseGUI;

	public LevelRenderer(Engine realms, Screen screen, Level level) {
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

		g.drawImage(image, 0, 0, screen.getWidth()*Engine.scale, screen.getHeight()*Engine.scale, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 10));
		g.drawString("TL Tile X: " + (getRenderX() / Engine.tileSize) + ", Y:" + (getRenderY() / Engine.tileSize), 5, 10);
		g.drawString("Player  X: " + (getPlayer().x / Engine.tileSize) + ", Y:" + (getPlayer().y / Engine.tileSize) + ", D: " + getPlayer().direction, 5, 20);

		g.drawString("TPS: " + realms.getTPS() + ", FPS:" + realms.getFPS(), 5, 30);

		g.dispose();
	}
	
	private void renderLevel() {
		screen.setOffset(getRenderX(), getRenderY());
		int x0 = getRenderX();
		int x1 = (getRenderX() + screen.getWidth() + Engine.tileSize) / Engine.tileSize;
		int y0 = getRenderY();
		int y1 = (getRenderY() + screen.getHeight() + Engine.tileSize) / Engine.tileSize;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				screen.renderTile(x * Engine.tileSize, y * Engine.tileSize, level.getTile(x, y));
			}
		}
		
		if(level.isPaused()) {
			pauseGUI.render();
		}
	}

}
