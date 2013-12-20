package net.trudan.realms.sound;

import javax.sound.sampled.Clip;

import net.trudan.realms.Realms;

import org.newdawn.easyogg.OggClip;

public class BGSound {

	private Clip curSound;

	public void play() {
		try {
			OggClip ogg = new OggClip(Realms.class.getResourceAsStream("/TownTheme1.ogg"));
		
			ogg.loop();
		} catch(Exception e) {e.printStackTrace();}
	}

	public void stopAll() {
		curSound.stop();
	}

}