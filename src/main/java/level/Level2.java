package level;

import java.util.LinkedList;

import entity.EnemyEntity;
import entity.EnemyEntity.EnemyType;
import game.entities.MyShip;

public class Level2 extends Level {
	
	public Level2(LinkedList<EnemyEntity> enemyEntities, MyShip myShip) {
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