package main.java.bulletbehavior;

import java.util.ArrayList;

import main.java.entity.ProjectileEntity;
import main.java.entity.ProjectileEntity.Team;

public class NullMissileBehavior implements MissileBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootMissile(int x, int y, int Vx, int Vy, Team team) {
		return null;
	}
}
