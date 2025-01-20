package game.levels;

import java.util.LinkedList;
import java.util.Random;

import game.objects.Player;
import game.objects.interfaces.Enemy;
import game.objects.interfaces.Enemy.EnemyType;

public class Level11 extends LevelBase {
	private Random random;
	private int enemyTypes=8;

	public Level11(LinkedList<Enemy> enemyEntities, Player player) {
		super(enemyEntities, player);
		totalEnemies=150;
		enemyRate=9;
		random=new Random();
	}

	@Override
	public void addEnemy() {
		if (enemiesAdded<totalEnemies) {
			int r=random.nextInt(enemyTypes)+1;
			switch (r) {
			case 1:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.AIEasy));
				break;
			case 2:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.MediumSuicide));
				break;
			case 3:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.Easy1));
				break;
			case 4:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.Easy2));
				break;
			case 5:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.Easy3));
				break;
			case 6:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.EasySuicide));
				break;
			case 7:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.Medium1));
				break;
			case 8:
				enemyEntities.add(enemyFactory.addEnemy(EnemyType.Medium3));
				break;
			}
			enemiesAdded++;
		}
	}
}
