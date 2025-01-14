package game.bulletbehaviors;

import java.util.ArrayList;

import game.assets.Sound;
import game.assets.Sound.soundEnum;
import game.entities.interfaces.ProjectileEntity;
import game.entities.interfaces.ProjectileEntity.Team;
import game.projectiles.Missile;

public class SingleMissileBehavior implements MissileBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootMissile(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<ProjectileEntity> missiles=new ArrayList<>();
		missiles.add(new Missile(x, y, Vx, 0, team));
		Sound.playSound(soundEnum.MULTISHOOT);
		return missiles;
	}
}
