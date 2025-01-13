package level;

import java.util.LinkedList;

import entity.EnemyEntity;
import entity.EnemyEntity.EnemyType;
import game.entities.MyShip;

public class Level1 extends Level {

	public Level1(LinkedList<EnemyEntity> enemyEntities, MyShip myShip) {
		super(enemyEntities, myShip);
		gapTime=10*1000;
		totalEnemies=25;
		enemyRate=10;
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies)
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.Easy1));
		enemiesAdded++;
	}
}