package main.java.bulletbehavior;

import java.util.ArrayList;

import main.java.entity.ProjectileEntity;
import main.java.entity.ProjectileEntity.Team;

public class NullBulletBehavior implements BulletBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team team) {
		return null;
	}
}
