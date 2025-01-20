package game.levels;

import java.util.LinkedList;

import game.gameobjects.Player;
import game.gameobjects.interfaces.EnemyEntity;
import game.gameobjects.interfaces.EnemyEntity.EnemyType;

public class Level1 extends Level {

	public Level1(LinkedList<EnemyEntity> enemyEntities, Player myShip) {
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