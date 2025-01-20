package game.objects.projectiles.behaviors;
import java.util.ArrayList;

import game.objects.interfaces.Projectile;
import game.objects.interfaces.Projectile.Team;
import game.objects.projectiles.Beam;

public class ConstantBeam implements FrontGunBehavior {

	@Override
	public ArrayList<Projectile> shootBullet(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<Projectile> beam=new ArrayList<>();
		beam.add(new Beam(x, y, 0, Vy, team));
		return beam;
	}
}