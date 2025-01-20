package game.levels;

import java.util.LinkedList;

import game.objects.Player;
import game.objects.interfaces.EnemyEntity;
import game.objects.projectiles.projectilebehaviors.DuoBulletBehavior;
import game.objects.projectiles.projectilebehaviors.NullMissileBehavior;
import game.objects.projectiles.projectilebehaviors.SingleBulletBehavior;
import game.objects.projectiles.projectilebehaviors.SingleMissileBehavior;
import game.objects.projectiles.projectilebehaviors.SpreadBulletBehavior;

public class LevelFactory {
	private LinkedList<EnemyEntity> enemyEntities;
	private Player player;

	public LevelFactory(LinkedList<EnemyEntity> enemyEntities, Player player) {
		this.enemyEntities=enemyEntities;
		this.player=player;
	}


	public LevelEntity newLevel(int levelNumber) {
		setPlayerUpgrades(levelNumber);
		switch (levelNumber) {
		case 1:
			return new Level1(enemyEntities, player);
		case 2: 
			return new Level2(enemyEntities, player);
		case 3: 
			return new Level3(enemyEntities, player);
		case 4: 
			return new Level4(enemyEntities, player);
		case 5: 
			return new Level5(enemyEntities, player);
		case 6:
			return new Level6(enemyEntities, player);
		case 7:
			return new Level7(enemyEntities, player);
		case 8:
			return new Level8(enemyEntities, player);
		case 9:
			return new Level9(enemyEntities, player);
		case 10:
			return new Level10(enemyEntities, player);
		case 11:
			return new Level11(enemyEntities, player);
		case 12:
			return new Level12(enemyEntities, player);
		case 13:
			return new Level13(enemyEntities, player);
		case 14:
			return new Level14(enemyEntities, player);
		case 15:
			return new Level15(enemyEntities, player);
		case 16:
			return new Level16(enemyEntities, player);
		case 17:
			//return new Level17(enemyEntities, player);
		case 18:
			//return new Level18(enemyEntities, player);
		case 19:
			//return new Level19(enemyEntities, player);
		case 20:
			//return new Level20(enemyEntities, player);
			
		}
		return null;
	}

	private static void setPlayerUpgrades(int level) {
		switch (level) {
		case 1:
			Player.setBulletBehavior(new SingleBulletBehavior());
			Player.setGunSpeedUps(0);
			Player.setMissileBehavior(new NullMissileBehavior());
			Player.setSpeedUps(0);
			Player.setBulletSpeedUps(0);
			break;
		case 2:
			Player.setBulletBehavior(new SingleBulletBehavior());
			Player.setGunSpeedUps(1);
			Player.setMissileBehavior(new NullMissileBehavior());
			Player.setSpeedUps(1);
			Player.setBulletSpeedUps(1);
			break;
		case 3:
			Player.setBulletBehavior(new SingleBulletBehavior());
			Player.setGunSpeedUps(2);
			Player.setMissileBehavior(new NullMissileBehavior());
			Player.setSpeedUps(2);
			Player.setBulletSpeedUps(2);
			break;
		case 4:
			Player.setBulletBehavior(new SingleBulletBehavior());
			Player.setGunSpeedUps(3);
			Player.setMissileBehavior(new NullMissileBehavior());
			Player.setSpeedUps(3);
			Player.setBulletSpeedUps(3);
			break;
		case 5:
			Player.setBulletBehavior(new DuoBulletBehavior());
			Player.setGunSpeedUps(4);
			Player.setMissileBehavior(new NullMissileBehavior());
			Player.setSpeedUps(4);
			Player.setBulletSpeedUps(4);
			break;
		case 6:
			Player.setBulletBehavior(new DuoBulletBehavior());
			Player.setGunSpeedUps(5);
			Player.setMissileBehavior(new NullMissileBehavior());
			Player.setSpeedUps(5);
			Player.setBulletSpeedUps(5);
			break;
		case 7:
			Player.setBulletBehavior(new DuoBulletBehavior());
			Player.setGunSpeedUps(6);
			Player.setMissileBehavior(new SingleMissileBehavior());
			Player.setSpeedUps(6);
			Player.setBulletSpeedUps(5);
			break;
		case 8:
			Player.setBulletBehavior(new DuoBulletBehavior());
			Player.setGunSpeedUps(7);
			Player.setMissileBehavior(new SingleMissileBehavior());
			Player.setSpeedUps(6);
			Player.setBulletSpeedUps(5);
			break;	
		case 9:
			Player.setBulletBehavior(new DuoBulletBehavior());
			Player.setGunSpeedUps(8);
			Player.setMissileBehavior(new SingleMissileBehavior());
			Player.setSpeedUps(6);
			Player.setBulletSpeedUps(5);
			break;
		case 10:
			Player.setBulletBehavior(new DuoBulletBehavior());
			Player.setGunSpeedUps(9);
			Player.setMissileBehavior(new SingleMissileBehavior());
			Player.setSpeedUps(6);
			Player.setBulletSpeedUps(5);
			break;	
		case 11:
			Player.setBulletBehavior(new DuoBulletBehavior());
			Player.setGunSpeedUps(10);
			Player.setMissileBehavior(new SingleMissileBehavior());
			Player.setSpeedUps(6);
			Player.setBulletSpeedUps(5);
			break;
		case 12:
			Player.setBulletBehavior(new DuoBulletBehavior());
			Player.setGunSpeedUps(11);
			Player.setMissileBehavior(new SingleMissileBehavior());
			Player.setSpeedUps(6);
			Player.setBulletSpeedUps(5);
			break;
		case 13:
			Player.setBulletBehavior(new SpreadBulletBehavior());
			Player.setGunSpeedUps(12);
			Player.setMissileBehavior(new SingleMissileBehavior());
			Player.setSpeedUps(6);
			Player.setBulletSpeedUps(5);
			break;
		case 14:
			Player.setBulletBehavior(new SpreadBulletBehavior());
			Player.setGunSpeedUps(13);
			Player.setMissileBehavior(new SingleMissileBehavior());
			Player.setSpeedUps(6);
			Player.setBulletSpeedUps(5);
			break;
		case 15:
			Player.setBulletBehavior(new SpreadBulletBehavior());
			Player.setGunSpeedUps(14);
			Player.setMissileBehavior(new SingleMissileBehavior());
			Player.setSpeedUps(6);
			Player.setBulletSpeedUps(5);
			break;
		case 16:
			Player.setBulletBehavior(new SpreadBulletBehavior());
			Player.setGunSpeedUps(14);
			Player.setMissileBehavior(new SingleMissileBehavior());
			Player.setSpeedUps(6);
			Player.setBulletSpeedUps(5);
			break;
		case 17:
			Player.setBulletBehavior(new SpreadBulletBehavior());
			Player.setGunSpeedUps(14);
			Player.setMissileBehavior(new SingleMissileBehavior());
			Player.setSpeedUps(6);
			Player.setBulletSpeedUps(5);
			break;
		case 18:
			Player.setBulletBehavior(new SpreadBulletBehavior());
			Player.setGunSpeedUps(14);
			Player.setMissileBehavior(new SingleMissileBehavior());
			Player.setSpeedUps(6);
			Player.setBulletSpeedUps(5);
			break;
		case 19:
			Player.setBulletBehavior(new SpreadBulletBehavior());
			Player.setGunSpeedUps(14);
			Player.setMissileBehavior(new SingleMissileBehavior());
			Player.setSpeedUps(6);
			Player.setBulletSpeedUps(5);
			break;
			
		}
	}
}