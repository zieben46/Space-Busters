package game.levels;

import java.util.LinkedList;
import java.util.Random;

import game.objects.Player;
import game.objects.interfaces.EnemyEntity;
import game.objects.interfaces.EnemyEntity.EnemyType;

public class Level8 extends Level {
	private Random random;
	private int enemyTypes=2;

	public Level8(LinkedList<EnemyEntity> enemyEntities, Player player) {
		super(enemyEntities, player);
		totalEnemies=100;
		enemyRate=9;
		random=new Random();
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			int r=random.nextInt(enemyTypes)+1;
			switch (r) {
			case 1:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.Medium1));
				break;
			case 2:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.MediumSuicide));
				break;
			}
			enemiesAdded++;
		}
	}
}
