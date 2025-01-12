package main.java.bulletbehavior;
import java.util.ArrayList;

import main.java.entity.ProjectileEntity;
import main.java.entity.ProjectileEntity.Team;
import main.java.game.Bullet;
import main.java.game.Sound;
import main.java.game.Sound.soundEnum;

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