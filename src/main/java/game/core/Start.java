package game.core;

import javax.swing.JFrame;

import game.utils.ImageLoader;
import game.utils.Sound;

public class Start {
	
	public static void main(String[] args) {
		ImageLoader.loadImages();	
		Sound.load();
		Game game = new Game();
		JFrame window = new JFrame("Space-Busters");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(game);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		game.start();
	}
}