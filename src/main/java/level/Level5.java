package level;

import java.util.LinkedList;

import entity.EnemyEntity;
import entity.EnemyEntity.EnemyType;
import game.entities.MyShip;

public class Level5 extends Level {

	public Level5(LinkedList<EnemyEntity> enemyEntities, MyShip myShip) {
		super(enemyEntities, myShip);
		totalEnemies=30;
		enemyRate=8;
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.Easy3));
			enemiesAdded++;
		}
	}
}
