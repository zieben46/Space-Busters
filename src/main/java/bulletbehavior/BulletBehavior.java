package bulletbehavior;
import java.util.ArrayList;

import entity.ProjectileEntity;
import entity.ProjectileEntity.Team;

public interface BulletBehavior {
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team Team);
}