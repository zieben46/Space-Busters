package main.java.EntityBehaviors;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;

import main.java.classes.ProjectileEntity;
import main.java.classes.ProjectileEntity.Team;
import main.java.game.Bullet;
import main.java.game.Sound;
import main.java.game.Sound.soundEnum;

public class SingleBulletBehavior implements BulletBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<ProjectileEntity> bullets=new ArrayList<>();
		bullets.add(new Bullet(x, y, 0, Vy, team));
		Sound.playSound(soundEnum.MULTISHOOT);
		return bullets;
	}
}