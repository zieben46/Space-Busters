package game.gameobjects.projectiles.projectilebehaviors;
import java.util.ArrayList;

import game.gameobjects.interfaces.ProjectileEntity;
import game.gameobjects.interfaces.ProjectileEntity.Team;

public interface ProjectileBehavior {
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team Team);
}