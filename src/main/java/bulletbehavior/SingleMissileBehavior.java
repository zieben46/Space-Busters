package bulletbehavior;

import java.util.ArrayList;

import entity.ProjectileEntity;
import entity.ProjectileEntity.Team;
import game.assets.Sound;
import game.assets.Sound.soundEnum;
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
