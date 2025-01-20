package game.objects.projectiles.behaviors;

import java.util.ArrayList;

import game.objects.interfaces.Projectile;
import game.objects.interfaces.Projectile.Team;

public interface SideGunBehavior {

	public ArrayList<Projectile> shootMissile(int x, int y, int Vx, int Vy, Team team);
}
