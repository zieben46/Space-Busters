package game.levels;

import java.util.LinkedList;

import game.gameobjects.Player;
import game.gameobjects.interfaces.EnemyEntity;
import game.gameobjects.interfaces.EnemyEntity.EnemyType;

public class Level3 extends Level {

	public Level3(LinkedList<EnemyEntity> enemyEntities, Player myShip) {
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
