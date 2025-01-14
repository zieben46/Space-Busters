package game.bulletbehaviors;
import java.util.ArrayList;

import game.assets.Sound;
import game.assets.Sound.soundEnum;
import game.entities.interfaces.ProjectileEntity;
import game.entities.interfaces.ProjectileEntity.Team;
import game.projectiles.Bullet;

public class DuoBulletBehavior implements BulletBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<ProjectileEntity> bullets=new ArrayList<>();
		bullets.add(new Bullet(x-20, y, 0, Vy, team));
		bullets.add(new Bullet(x+20, y, 0, Vy, team));
		Sound.playSound(soundEnum.MULTISHOOT);
		return bullets;
	}
}