package game.input;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import game.core.Game;
import game.utils.SaveManager;
import game.utils.SoundPlayer;
import game.utils.SoundPlayer.SoundType;

public class MouseInput implements MouseListener, MouseMotionListener  {

	private Game game;
	private boolean inStart;
	private boolean inLoad;
	private boolean inQuit;

	public MouseInput(Game game) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {


	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (Game.state.equals(Game.STATE.MENU)) {
			int x = e.getX();
			int y = e.getY();
			if (x>100&&x<200&&y>150&&y<200) {
				SoundPlayer.playSound(SoundType.BUTTONSELECT);
				game.startLevels(1);
				Game.state = Game.STATE.GAME;
				SoundPlayer.startBackgroundMusic();
			}

			if (x>100&&x<200&&y>250&&y<300) {
				SoundPlayer.playSound(SoundType.BUTTONSELECT);
				int levelNumber = SaveManager.Load();
				game.startLevels(levelNumber);
				Game.state = Game.STATE.GAME;
				SoundPlayer.startBackgroundMusic();
			}

			if (x>100&&x<200&&y>350&&y<400) {
				SoundPlayer.playSound(SoundType.BUTTONSELECT);
				try {
					Thread.sleep(400);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.exit(1);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (Game.state.equals(Game.STATE.MENU)) {
			int x = e.getX();
			int y = e.getY();

			if (x>100&&x<200&&y>150&&y<200) {
				if (inStart == false) {
					SoundPlayer.playSound(SoundType.BUTTONHOVER);
				}
				inStart = true;
			} else {
				inStart = false;
			}

			if (x>100&&x<200&&y>250&&y<300) {
				if (inLoad == false) {
					SoundPlayer.playSound(SoundType.BUTTONHOVER);
				}
				inLoad = true;
			} else {
				inLoad = false;
			}

			if (x>100&&x<200&&y>350&&y<400) {
				if (inQuit == false) {
					SoundPlayer.playSound(SoundType.BUTTONHOVER);
				}
				inQuit = true;
			} else {
				inQuit = false;
			}

		}
	}

	public boolean getInStart() {
		return inStart;
	}

	public boolean getInLoad() {
		return inLoad;
	}

	public boolean getInQuit() {
		return inQuit;

	}
}
