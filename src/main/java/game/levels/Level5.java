package game.levels;

import java.util.LinkedList;

import game.gameobjects.Player;
import game.gameobjects.interfaces.EnemyEntity;
import game.gameobjects.interfaces.EnemyEntity.EnemyType;

public class Level5 extends Level {

	public Level5(LinkedList<EnemyEntity> enemyEntities, Player myShip) {
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
