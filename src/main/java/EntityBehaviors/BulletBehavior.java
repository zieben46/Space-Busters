package main.java.EntityBehaviors;
import java.util.ArrayList;

import main.java.classes.ProjectileEntity;
import main.java.classes.ProjectileEntity.Team;

public interface BulletBehavior {
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team Team);
}