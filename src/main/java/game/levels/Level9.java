package game.levels;

import java.util.LinkedList;

import game.entities.MyShip;
import game.entities.interfaces.EnemyEntity;
import game.entities.interfaces.EnemyEntity.EnemyType;

public class Level9 extends Level {

	public Level9(LinkedList<EnemyEntity> enemyEntities, MyShip myShip) {
		super(enemyEntities, myShip);
		totalEnemies=150;
		enemyRate=7;
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			enemyEntities.add(enemyFactory.addEnemy(EnemyType.AIEasy));
		}
		enemiesAdded++;
	}
}
