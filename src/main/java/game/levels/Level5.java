package game.levels;

import java.util.LinkedList;

import game.entities.MyShip;
import game.entities.interfaces.EnemyEntity;
import game.entities.interfaces.EnemyEntity.EnemyType;

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
