package game.objects.projectiles.behaviors;

import java.util.ArrayList;

import game.objects.interfaces.FireBehavior.FrontFireBehavior;
import game.objects.interfaces.FireBehavior.SideFireBehavior;
import game.objects.interfaces.Projectile;
import game.objects.interfaces.Projectile.Team;

public class Off implements FrontFireBehavior, SideFireBehavior {

	@Override
	public ArrayList<Projectile> fire(int x, int y, int Vx, int Vy, Team team) {
		return null;
	}
}
