package game.levels;

public interface Level {
	void initialize();
	void addEnemy();
	int getTotalEnemies();
	boolean levelComplete();
	void update();
	int getHeathSpawnRate();
	boolean getInGap();
}