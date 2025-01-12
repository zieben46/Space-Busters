package main.java.bulletbehavior;
import java.util.ArrayList;

import main.java.entity.ProjectileEntity;
import main.java.entity.ProjectileEntity.Team;

public interface BulletBehavior {
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team Team);
}