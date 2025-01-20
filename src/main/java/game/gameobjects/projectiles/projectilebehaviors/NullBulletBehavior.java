package game.gameobjects.projectiles.projectilebehaviors;

import java.util.ArrayList;

import game.gameobjects.interfaces.ProjectileEntity;
import game.gameobjects.interfaces.ProjectileEntity.Team;

public class NullBulletBehavior implements ProjectileBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team team) {
		return null;
	}
}
