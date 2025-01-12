package main.java.level;

import java.util.LinkedList;
import java.util.Random;

import main.java.entity.EnemyEntity;
import main.java.entity.EnemyEntity.EnemyType;
import main.java.game.MyShip;

public class Level16 extends Level {
	private Random random;
	private int enemyTypes;

	public Level16(LinkedList<EnemyEntity> enemyEntities, MyShip myShip) {
		super(enemyEntities, myShip);
		totalEnemies=500;
		enemyRate=20;
		enemyTypes=2;
		random=new Random();
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			int r=random.nextInt(enemyTypes)+1;
			switch (r) {
			case 1:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.BeamEasy));
				break;
			case 2:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.MediumSuicide));
				break;
			}
		}
		enemiesAdded++;
	}
}
