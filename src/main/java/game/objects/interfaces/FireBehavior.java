package game.objects.interfaces;

import java.util.ArrayList;

import game.objects.interfaces.Projectile.Team;

public interface FireBehavior {
    public interface FrontFireBehavior {
        public ArrayList<Projectile> fire(int x, int y, int Vx, int Vy, Team Team);
    }

    public interface SideFireBehavior {
        public ArrayList<Projectile> fire(int x, int y, int Vx, int Vy, Team team);
    }
}