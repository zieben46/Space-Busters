package game.bulletbehaviors;

import java.util.ArrayList;

import game.entities.interfaces.ProjectileEntity;
import game.entities.interfaces.ProjectileEntity.Team;

public class NullBulletBehavior implements BulletBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team team) {
		return null;
	}
}
