package game.levels;

import java.util.LinkedList;

import game.objects.Player;
import game.objects.interfaces.Enemy;
import game.objects.interfaces.Enemy.EnemyType;

public class Level9 extends LevelBase {

	public Level9(LinkedList<Enemy> enemyEntities, Player player) {
		super(enemyEntities, player);
		totalEnemies = 150;
		enemyRate = 7;
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.AIEasy));
		}
		enemiesAdded++;
	}
}
