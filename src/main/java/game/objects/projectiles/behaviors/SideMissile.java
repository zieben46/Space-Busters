package game.objects.projectiles.behaviors;

import java.util.ArrayList;

import game.objects.interfaces.Projectile;
import game.objects.interfaces.FireBehavior.SideFireBehavior;
import game.objects.interfaces.Projectile.Team;
import game.objects.projectiles.Missile;
import game.utils.SoundPlayer;
import game.utils.SoundPlayer.SoundType;

public class SideMissile implements SideFireBehavior {

	@Override
	public ArrayList<Projectile> fire(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<Projectile> missiles = new ArrayList<>();
		missiles.add(new Missile(x, y, Vx, 0, team));
		SoundPlayer.playSound(SoundType.MULTISHOOT);
		return missiles;
	}
}