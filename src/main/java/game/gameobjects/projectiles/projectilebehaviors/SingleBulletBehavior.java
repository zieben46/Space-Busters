package game.gameobjects.projectiles.projectilebehaviors;
import java.util.ArrayList;

import game.gameobjects.interfaces.ProjectileEntity;
import game.gameobjects.interfaces.ProjectileEntity.Team;
import game.gameobjects.projectiles.Bullet;
import game.utils.Sound;
import game.utils.Sound.soundEnum;

public class SingleBulletBehavior implements ProjectileBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<ProjectileEntity> bullets=new ArrayList<>();
		bullets.add(new Bullet(x, y, 0, Vy, team));
		Sound.playSound(soundEnum.MULTISHOOT);
		return bullets;
	}
}