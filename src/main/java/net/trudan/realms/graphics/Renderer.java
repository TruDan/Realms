package net.trudan.realms.graphics;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import net.trudan.realms.Realms;
import net.trudan.realms.entity.Player;

public class Renderer {

	protected Screen screen;
	protected Realms realms;
	protected int renderX, renderY;

	protected BufferedImage image;
	protected int[] pixels;

	public Renderer(Realms realms, Screen screen) {
		this.realms = realms;
		this.screen = screen;

		image = new BufferedImage(screen.getWidth(), screen.getHeight(), BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	}

	protected Player getPlayer() {
		return realms.getPlayer();
	}

	public void render(BufferStrategy bs) {

	}

	protected final int getRenderX() {
		return renderX;
	}

	protected final int getRenderY() {
		return renderY;
	}

	public void setRenderX(int x) {
		this.renderX = x;
	}

	public void setRenderY(int y) {
		this.renderY = y;
	}

}
