package game.objects.projectiles.behaviors;
import java.util.ArrayList;

import game.objects.interfaces.Projectile;
import game.objects.interfaces.Projectile.Team;
import game.objects.projectiles.Bullet;
import game.utils.Sound;
import game.utils.Sound.soundEnum;

public class MonoBullet implements FrontGunBehavior {

	@Override
	public ArrayList<Projectile> shootBullet(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<Projectile> bullets=new ArrayList<>();
		bullets.add(new Bullet(x, y, 0, Vy, team));
		Sound.playSound(soundEnum.MULTISHOOT);
		return bullets;
	}
}