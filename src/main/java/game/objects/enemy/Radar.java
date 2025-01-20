package game.objects.enemy;

import game.objects.Player;

public class Radar {
	private static int playerX;
	private static int playerY;
	private static Player player;
	
	public Radar(Player player) {
		Radar.player=player;
	}
	
	public static void update() {
		playerX=player.getX();
		playerY=player.getY();
	}
	
	public static int getPlayerX() {
		return playerX;
	}
	public static int getPlayerY() {
		return playerY;
	}
}