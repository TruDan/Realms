package net.trudan.realms.sound;

import javax.sound.sampled.Clip;

import net.trudan.engine.Engine;

import org.newdawn.easyogg.OggClip;

public class BGSound {

	private Clip curSound;

	public void play() {
		try {
			OggClip ogg = new OggClip(Engine.class.getResourceAsStream("/TownTheme1.ogg"));
		
			ogg.loop();
		} catch(Exception e) {e.printStackTrace();}
	}

	public void stopAll() {
		curSound.stop();
	}

}