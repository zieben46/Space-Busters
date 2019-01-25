package main.java.game;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;

import main.java.game.Game;
import main.java.game.ImageLoader;
import main.java.game.Sound;

public class Start {
	
	public static void main(String[] args) throws LineUnavailableException {
		ImageLoader.loadImages();	
		Sound.load();
		Game game=new Game();
		JFrame window=new JFrame("Space Busters");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(game);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		game.start();
	}
}
