package game.objects.projectiles.behaviors;
import java.util.ArrayList;

import game.objects.interfaces.FireBehavior.FrontFireBehavior;
import game.objects.interfaces.Projectile;
import game.objects.interfaces.Projectile.Team;
import game.objects.projectiles.Bullet;
import game.utils.SoundPlayer;
import game.utils.SoundPlayer.SoundType;

public class DoubleBullets implements FrontFireBehavior {

	@Override
	public ArrayList<Projectile> fire(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<Projectile> bullets = new ArrayList<>();
		bullets.add(new Bullet(x-20, y, 0, Vy, team));
		bullets.add(new Bullet(x+20, y, 0, Vy, team));
		SoundPlayer.playSound(SoundType.MULTISHOOT);
		return bullets;
	}
}