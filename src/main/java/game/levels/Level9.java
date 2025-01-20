package game.levels;

import java.util.LinkedList;

import game.gameobjects.Player;
import game.gameobjects.interfaces.EnemyEntity;
import game.gameobjects.interfaces.EnemyEntity.EnemyType;

public class Level9 extends Level {

	public Level9(LinkedList<EnemyEntity> enemyEntities, Player myShip) {
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
