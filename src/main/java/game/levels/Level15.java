package game.levels;

import java.util.LinkedList;

import game.entities.MyShip;
import game.entities.interfaces.EnemyEntity;
import game.entities.interfaces.EnemyEntity.EnemyType;

public class Level15 extends Level {

	public Level15(LinkedList<EnemyEntity> enemyEntities, MyShip myShip) {
		super(enemyEntities, myShip);
		totalEnemies=150;
		enemyRate=6;
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.Medium3));
		}
		enemiesAdded++;
	}
}
