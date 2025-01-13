package bulletbehavior;

import java.util.ArrayList;

import entity.ProjectileEntity;
import entity.ProjectileEntity.Team;

public interface MissileBehavior {

	public ArrayList<ProjectileEntity> shootMissile(int x, int y, int Vx, int Vy, Team team);
}
