package game.objects.projectiles.behaviors;

import java.util.ArrayList;

import game.objects.interfaces.Projectile;
import game.objects.interfaces.Projectile.Team;
import game.objects.projectiles.Missile;
import game.utils.Sound;
import game.utils.Sound.soundEnum;

public class OnSideBullets implements SideGunBehavior {

	@Override
	public ArrayList<Projectile> shootMissile(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<Projectile> missiles=new ArrayList<>();
		missiles.add(new Missile(x, y, Vx, 0, team));
		Sound.playSound(soundEnum.MULTISHOOT);
		return missiles;
	}
}