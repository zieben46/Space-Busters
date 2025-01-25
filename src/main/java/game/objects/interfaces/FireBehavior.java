package game.objects.interfaces;

import java.util.ArrayList;

import game.objects.interfaces.Projectile.Team;

public interface FireBehavior {
    ArrayList<Projectile> fire(int x, int y, int Vx, int Vy, Team team);

    public interface FrontFireBehavior extends FireBehavior {
    }

    public interface SideFireBehavior extends FireBehavior {
    }
}