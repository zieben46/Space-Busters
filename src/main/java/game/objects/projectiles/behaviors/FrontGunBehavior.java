package game.objects.projectiles.behaviors;
import java.util.ArrayList;

import game.objects.interfaces.Projectile;
import game.objects.interfaces.Projectile.Team;

public interface FrontGunBehavior {
	public ArrayList<Projectile> shootBullet(int x, int y, int Vx, int Vy, Team Team);
}