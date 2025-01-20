package game.objects.projectiles.projectilebehaviors;
import java.util.ArrayList;

import game.objects.interfaces.ProjectileEntity;
import game.objects.interfaces.ProjectileEntity.Team;

public interface ProjectileBehavior {
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team Team);
}