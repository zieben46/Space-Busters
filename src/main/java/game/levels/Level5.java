package game.levels;

import java.util.LinkedList;

import game.objects.Player;
import game.objects.interfaces.Enemy;
import game.objects.interfaces.Enemy.EnemyType;

public class Level5 extends LevelBase {

	public Level5(LinkedList<Enemy> enemyEntities, Player player) {
		super(enemyEntities, player);
		totalEnemies = 30;
		enemyRate = 8;
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.Easy3));
			enemiesAdded++;
		}
	}
}
