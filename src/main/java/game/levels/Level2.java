package game.levels;

import java.util.LinkedList;

import game.objects.Player;
import game.objects.interfaces.EnemyEntity;
import game.objects.interfaces.EnemyEntity.EnemyType;

public class Level2 extends Level {
	
	public Level2(LinkedList<EnemyEntity> enemyEntities, Player myShip) {
		super(enemyEntities, myShip);
		totalEnemies=15;
		enemyRate=5;
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies)
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.Easy2));
		enemiesAdded++;
	}
}