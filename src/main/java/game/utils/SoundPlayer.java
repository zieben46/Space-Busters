package game.utils;

import javax.sound.sampled.*;

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
			AudioInputStream audioInputstream = AudioSystem
					.getAudioInputStream(SoundPlayer.class.getClassLoader().getResourceAsStream(filePath));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputstream);
			clip.start();
		} catch (Throwable e) {
			System.out.println("Error in playing audio.  Check that speakers are turned on.");
		}
	}

	public static void startBackgroundMusic() {
		String filePath = "sound/backgroundMusic.wav";

		try {
			AudioInputStream audioInputstream = AudioSystem
					.getAudioInputStream(SoundPlayer.class.getClassLoader().getResourceAsStream(filePath));
			backgroundMusicClip = AudioSystem.getClip();
			backgroundMusicClip.open(audioInputstream);
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
