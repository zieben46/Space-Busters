package game.objects.projectiles.projectilebehaviors;

import java.util.ArrayList;

import game.objects.interfaces.ProjectileEntity;
import game.objects.interfaces.ProjectileEntity.Team;

public class NullBulletBehavior implements ProjectileBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team team) {
		return null;
	}
}
