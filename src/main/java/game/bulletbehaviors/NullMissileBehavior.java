package game.bulletbehaviors;

import java.util.ArrayList;

import game.entities.interfaces.ProjectileEntity;
import game.entities.interfaces.ProjectileEntity.Team;

public class NullMissileBehavior implements MissileBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootMissile(int x, int y, int Vx, int Vy, Team team) {
		return null;
	}
}
