package main.java.level;

import java.util.LinkedList;

import main.java.classes.EnemyEntity;
import main.java.classes.EnemyEntity.EnemyType;
import main.java.game.MyShip;

public class Level1 extends Level implements LevelEntity {

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
