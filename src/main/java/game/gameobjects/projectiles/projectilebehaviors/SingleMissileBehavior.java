package game.gameobjects.projectiles.projectilebehaviors;

import java.util.ArrayList;

import game.gameobjects.interfaces.ProjectileEntity;
import game.gameobjects.interfaces.ProjectileEntity.Team;
import game.gameobjects.projectiles.Missile;
import game.utils.Sound;
import game.utils.Sound.soundEnum;

public class SingleMissileBehavior implements MissileBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootMissile(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<ProjectileEntity> missiles=new ArrayList<>();
		missiles.add(new Missile(x, y, Vx, 0, team));
		Sound.playSound(soundEnum.MULTISHOOT);
		return missiles;
	}
}
