package main.java.EntityBehaviors;

import java.util.ArrayList;

import main.java.classes.ProjectileEntity;
import main.java.classes.ProjectileEntity.Team;
import main.java.game.Missile;
import main.java.game.Sound;
import main.java.game.Sound.soundEnum;

public class SingleMissileBehavior implements MissileBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootMissile(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<ProjectileEntity> missiles=new ArrayList<>();
		missiles.add(new Missile(x, y, Vx, 0, team));
		Sound.playSound(soundEnum.MULTISHOOT);
		return missiles;
	}
}
