package game.objects.projectiles.behaviors;
import java.util.ArrayList;

import game.objects.interfaces.FireBehavior.FrontFireBehavior;
import game.objects.interfaces.Projectile;
import game.objects.interfaces.Projectile.Team;
import game.objects.projectiles.Beam;

public class SingleBeam implements FrontFireBehavior {

	@Override
	public ArrayList<Projectile> fire(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<Projectile> beam = new ArrayList<>();
		beam.add(new Beam(x, y, 0, Vy, team));
		return beam;
	}
}