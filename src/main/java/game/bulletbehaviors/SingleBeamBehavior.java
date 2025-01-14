package game.bulletbehaviors;
import java.util.ArrayList;

import game.entities.interfaces.ProjectileEntity;
import game.entities.interfaces.ProjectileEntity.Team;
import game.projectiles.Beam;

public class SingleBeamBehavior implements BulletBehavior {

	@Override
	public ArrayList<ProjectileEntity> shootBullet(int x, int y, int Vx, int Vy, Team team) {
		ArrayList<ProjectileEntity> beam=new ArrayList<>();
		beam.add(new Beam(x, y, 0, Vy, team));
		return beam;
	}
}