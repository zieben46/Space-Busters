package game.levels;

import java.util.LinkedList;

import game.objects.Player;
import game.objects.interfaces.Enemy;
import game.objects.interfaces.Enemy.EnemyType;

public class Level3 extends LevelBase {

	public Level3(LinkedList<Enemy> enemyEntities, Player player) {
		super(enemyEntities, player);
		totalEnemies = 30;
		enemyRate = 4;
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies)
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.EasySuicide));
		enemiesAdded++;
	}
}
