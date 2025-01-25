package game.utils;

import javax.sound.sampled.*;

import java.io.InputStream;
import java.io.BufferedInputStream;

public class SoundPlayer {
	private static Clip backgroundMusicClip;

	public enum SoundType {
		MULTISHOOT("sound/multiShoot.wav"),
		BIGEXPLOSION("sound/bigExplosion.wav"),
		SMALLEXPLOSION("sound/smallExplosion.wav"),
		BUTTONHOVER("sound/buttonHover.wav"),
		BUTTONSELECT("sound/buttonSelect.wav");

		private final String filePath;

		SoundType(String filePath) {
			this.filePath = filePath;
		}

		public String getFilePath() {
			return filePath;
		}
	}

	public static void playSound(SoundType se) {
		String filePath = se.getFilePath();

		try {
			InputStream audioSrc = SoundPlayer.class.getClassLoader().getResourceAsStream(filePath);
			if (audioSrc == null) {
				throw new IllegalArgumentException("Sound file not found: " + filePath);
			}

			InputStream bufferedIn = new BufferedInputStream(audioSrc);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} catch (Throwable e) {
			System.out.println("Error in playing audio.  Check that speakers are turned on.");
		}
	}

	public static void startBackgroundMusic() {
		String filePath = "sound/backgroundMusic.wav";

		try {
			InputStream audioSrc = SoundPlayer.class.getClassLoader().getResourceAsStream(filePath);
			if (audioSrc == null) {
				throw new IllegalArgumentException("Sound file not found: " + filePath);
			}

			InputStream bufferedIn = new BufferedInputStream(audioSrc);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
			backgroundMusicClip = AudioSystem.getClip();
			backgroundMusicClip.open(audioStream);
			backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY);

		} catch (Throwable e) {
			System.out.println("Error in playing audio.  Check that speakers are turned on.");
		}

	}

	public static void stopBackgroundMusic() {
		if (backgroundMusicClip != null && backgroundMusicClip.isOpen()) {
			backgroundMusicClip.stop();
			backgroundMusicClip.close();
		}
	}

}