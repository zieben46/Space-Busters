package game.bulletbehaviors;
import java.util.ArrayList;

import game.entities.interfaces.ProjectileEntity;
import game.entities.interfaces.ProjectileEntity.Team;

public interface BulletBehavior {
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team Team);
}