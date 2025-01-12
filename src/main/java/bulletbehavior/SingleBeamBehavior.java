package main.java.bulletbehavior;
import java.util.ArrayList;

import main.java.entity.ProjectileEntity;
import main.java.entity.ProjectileEntity.Team;
import main.java.game.Beam;

public class SingleBeamBehavior implements BulletBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<ProjectileEntity> beam=new ArrayList<>();
		beam.add(new Beam(x, y, 0, Vy, team));
		return beam;
	}
}