package game.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import game.core.Start;

final public class ImageLoader {

	public static BufferedImage blueSprite;
	public static BufferedImage yellowSprite;
	public static BufferedImage enemyAIEasy;
	public static BufferedImage EnemyAIEasySlave;
	public static BufferedImage EnemyAIMediumSlave;
	public static BufferedImage enemyBeamEasy;
	public static BufferedImage enemyCarrierEasy;
	public static BufferedImage EnemyEasy1;
	public static BufferedImage EnemyEasy2;
	public static BufferedImage enemyEasy3;
	public static BufferedImage enemyMedium1;
	public static BufferedImage enemyMedium3;
	public static BufferedImage enemySuicide;
	public static BufferedImage beamDown;
	public static BufferedImage bulletUp;
	public static BufferedImage bulletDown;
	public static BufferedImage purpImageSmall;
	public static BufferedImage yellowImageSmall;
	public static BufferedImage greenImageSmall;
	public static BufferedImage menuBackground;
	public static BufferedImage missileLeft;
	public static BufferedImage missileRight;
	public static BufferedImage myShip0;
	public static BufferedImage myShip1;
	public static BufferedImage myShip2;
	public static BufferedImage myShip3;
	public static BufferedImage myShip4;
	public static BufferedImage myShip5;
	public static BufferedImage spaceBackground;
	public static BufferedImage yellowUpgrade;
	public static BufferedImage purpleUpgrade;
	public static BufferedImage greenUpgrade;
	public static BufferedImage healthPack;
	
	public static BufferedImage yellowSpriteBig;
	public static BufferedImage yellowSpriteReallyBig;
	public static BufferedImage yellowSpriteAll;

	public static InputStream load(String path) {
		InputStream input = Start.class.getResourceAsStream(path);
		
		if (input==null) {
			input = Start.class.getResourceAsStream("/"+path);
		}

		return input;
	}
	
	public static void loadImages() {
		try {
			menuBackground= ImageIO.read(load("/images/menuBackground.png"));
			blueSprite= ImageIO.read(load("/images/explosionSheetBlueShort.png"));
			yellowSprite= ImageIO.read(load("/images/explosionSheetYellowShort.png"));
			enemyAIEasy = ImageIO.read(load("/images/enemyAIEasy.png"));
			EnemyAIEasySlave= ImageIO.read(load("/images/enemyAIEasySlave.png"));
			EnemyAIMediumSlave= ImageIO.read(load("/images/enemyAIMediumSlave.png"));
			enemyBeamEasy= ImageIO.read(load("/images/enemyBeamEasy.png"));
			enemyCarrierEasy= ImageIO.read(load("/images/carrierEasy.png"));
			EnemyEasy1= ImageIO.read(load("/images/enemyType1.png")); 
			EnemyEasy2= ImageIO.read(load("/images/enemyType2.png"));
			enemyEasy3= ImageIO.read(load("/images/enemyType2.png")); 
			enemyMedium1= ImageIO.read(load("/images/enemyMedium1.png"));
			enemyMedium3= ImageIO.read(load("/images/enemyMedium3.png"));
			enemySuicide= ImageIO.read(load("/images/enemyTypeSuicide.png"));
			beamDown= ImageIO.read(load("/images/beam.png"));
			bulletUp= ImageIO.read(load("/images/bulletUp.png")); 
			bulletDown= ImageIO.read(load("/images/bulletDown.png"));
			purpImageSmall= ImageIO.read(load("/images/upgradePurpleSmall.png"));
			yellowImageSmall = ImageIO.read(load("/images/upgradeYellowSmall.png"));
			greenImageSmall= ImageIO.read(load("/images/upgradeGreenSmall.png"));
			missileLeft= ImageIO.read(load("/images/bulletLeft.png"));
			missileRight= ImageIO.read(load("/images/bulletRight.png"));
			myShip0= ImageIO.read(load("/images/myShipAnim1.png"));
			myShip1= ImageIO.read(load("/images/myShipAnim2.png"));
			myShip2= ImageIO.read(load("/images/myShipAnim3.png"));
			myShip3= ImageIO.read(load("/images/myShipAnim4.png"));
			myShip4= ImageIO.read(load("/images/myShipAnim5.png"));
			myShip5= ImageIO.read(load("/images/myShipAnim6.png"));
			spaceBackground= ImageIO.read(load("/images/background.png"));
			yellowUpgrade= ImageIO.read(load("/images/upgradeYellow.png"));
			purpleUpgrade= ImageIO.read(load("/images/upgradePurple.png"));
			greenUpgrade= ImageIO.read(load("/images/upgradeGreen.png"));
			healthPack= ImageIO.read(load("/images/healthPack.png"));
			//yellowSpriteBig= ImageIO.read(load("images/explosionSheetYellowShortBig.png"));
			//yellowSpriteReallyBig= ImageIO.read(load("images/explosionSheetYellowShortBigger.png"));
			yellowSpriteBig= ImageIO.read(load("/images/shipExplosion.png"));
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR LOADING IMAGES.  CONTACT ADMIN FOR SUPPORT");
				e.printStackTrace();
		}
		
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, load("/font/ARDESTINE.ttf")));
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
