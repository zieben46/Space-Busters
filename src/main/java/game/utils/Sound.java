package game.utils;

import jig.engine.audio.jsound.AudioClip;

import game.core.Game;
import game.core.Game.STATE;

public class Sound {
	private static AudioClip multiShoot;
	private static AudioClip bigExplosion;
	private static AudioClip smallExplosion;
	private static AudioClip buttonHover;
	private static AudioClip buttonSelect;
	private static AudioClip backgroundMusic;

	public static Thread thread;

//Audio slows down the game from time to time...
	
	public static void load() {
		buttonHover=AudioClip.createAudioClip("sound/buttonHover.wav");
		multiShoot=AudioClip.createAudioClip("sound/multiShoot.wav");
		bigExplosion=AudioClip.createAudioClip("sound/bigExplosion.wav");
		smallExplosion=AudioClip.createAudioClip("sound/smallExplosion.wav");
		buttonSelect=AudioClip.createAudioClip("sound/buttonSelect.wav");
		backgroundMusic=AudioClip.createAudioClip("sound/backgroundMusic.wav");
		thread=new Thread();
	}

	public enum soundEnum {
		MULTISHOOT,
		BIGEXPLOSION,
		SMALLEXPLOSION,
		BUTTONHOVER,
		BUTTONSELECT
	}

	public static void playSound(soundEnum se) {
		AudioClip presentClip = null;
		switch (se) {
		case MULTISHOOT:
			presentClip=multiShoot;
			break;
		case BIGEXPLOSION:
			presentClip=bigExplosion;
			break;
		case SMALLEXPLOSION:
			presentClip=smallExplosion;
			break;
		case BUTTONHOVER:
			presentClip=buttonHover;
			break;	
		case BUTTONSELECT:
			presentClip=buttonSelect;
			break;	
		}
		playClip(presentClip);
	}

		private static void playClip(AudioClip presentClip) {
			//presentClip.play();
			try{
				new Thread(){ public void run(){ presentClip.play();
				}
				}.start();
			}catch(Throwable e){
				e.printStackTrace();
			}
		}

	public static void playBackgroundMusic() {
		if (Game.state.equals(STATE.GAME)) {
			try{
				new Thread("MusicThread"){ public void run(){
					backgroundMusic.loop(0);
				}
				}.start();
			}catch(Throwable e){
				e.printStackTrace();
			}
		}
	}


	//Need to stop background music if pauses then exits
	
	public static void stopBackgroundMusic() {
		//			//backgroundMusic.stop();
		//	
		//			for (Thread th: Thread.getAllStackTraces().keySet()) {
		//	
		//				if (th.getName().equals("MusicThread")) {
		//					try {
		//						th.wait();
		//					} catch (InterruptedException e) {
		//						// TODO Auto-generated catch block
		//						e.printStackTrace();
		//					}
		//				}
		//			}
	}
}



