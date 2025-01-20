package game.objects.projectiles.projectilebehaviors;

import java.util.ArrayList;

import game.objects.interfaces.ProjectileEntity;
import game.objects.interfaces.ProjectileEntity.Team;

public class NullMissileBehavior implements MissileBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootMissile(int x, int y, int Vx, int Vy, Team team) {
		return null;
	}
}
