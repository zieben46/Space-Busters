package level;

import java.util.LinkedList;

import entity.EnemyEntity;
import entity.EnemyEntity.EnemyType;
import game.entities.MyShip;

public class Level3 extends Level {

	public Level3(LinkedList<EnemyEntity> enemyEntities, MyShip myShip) {
		super(enemyEntities, myShip);
		totalEnemies=15;
		enemyRate=4;
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies)
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.EasySuicide));
		enemiesAdded++;
	}
}
