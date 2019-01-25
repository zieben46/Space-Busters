package game;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

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
		InputStream input = ImageLoader.class.getResourceAsStream(path);
		if (input==null) {
			input=ImageLoader.class.getResourceAsStream("/"+path);
		}
		return input;
	}

	public static void loadImages() {
		try {
			menuBackground= ImageIO.read(new File("images//menuBackground.png"));
			blueSprite= ImageIO.read(new File("images//explosionSheetBlueShort.png"));
			yellowSprite= ImageIO.read(new File("images//explosionSheetYellowShort.png"));
			enemyAIEasy = ImageIO.read(new File("images//enemyAIEasy.png"));
			EnemyAIEasySlave= ImageIO.read(new File("images//enemyAIEasySlave.png"));
			EnemyAIMediumSlave= ImageIO.read(new File("images//enemyAIMediumSlave.png"));
			enemyBeamEasy= ImageIO.read(new File("images//enemyBeamEasy.png"));
			enemyCarrierEasy= ImageIO.read(new File("images//carrierEasy.png"));
			EnemyEasy1= ImageIO.read(new File("images//enemyType1.png")); 
			EnemyEasy2= ImageIO.read(new File("images//enemyType2.png"));
			enemyEasy3= ImageIO.read(new File("images//enemyType2.png")); 
			enemyMedium1= ImageIO.read(new File("images//enemyMedium1.png"));
			enemyMedium3= ImageIO.read(new File("images//enemyMedium3.png"));
			enemySuicide= ImageIO.read(new File("images//enemyTypeSuicide.png"));
			beamDown= ImageIO.read(new File("images//beam.png"));
			bulletUp= ImageIO.read(new File("images//bulletUp.png")); 
			bulletDown= ImageIO.read(new File("images//bulletDown.png"));
			purpImageSmall= ImageIO.read(new File("images//upgradePurpleSmall.png"));
			yellowImageSmall = ImageIO.read(new File("images//upgradeYellowSmall.png"));
			greenImageSmall= ImageIO.read(new File("images//upgradeGreenSmall.png"));
			missileLeft= ImageIO.read(new File("images//bulletLeft.png"));
			missileRight= ImageIO.read(new File("images//bulletRight.png"));
			myShip0= ImageIO.read(new File("images//myShipAnim1.png"));
			myShip1= ImageIO.read(new File("images//myShipAnim2.png"));
			myShip2= ImageIO.read(new File("images//myShipAnim3.png"));
			myShip3= ImageIO.read(new File("images//myShipAnim4.png"));
			myShip4= ImageIO.read(new File("images//myShipAnim5.png"));
			myShip5= ImageIO.read(new File("images//myShipAnim6.png"));
			spaceBackground= ImageIO.read(new File("images//background.png"));
			yellowUpgrade= ImageIO.read(new File("images//upgradeYellow.png"));
			purpleUpgrade= ImageIO.read(new File("images//upgradePurple.png"));
			greenUpgrade= ImageIO.read(new File("images//upgradeGreen.png"));
			healthPack= ImageIO.read(new File("images//healthPack.png"));
			//yellowSpriteBig= ImageIO.read(new File("images//explosionSheetYellowShortBig.png"));
			//yellowSpriteReallyBig= ImageIO.read(new File("images//explosionSheetYellowShortBigger.png"));
			yellowSpriteBig= ImageIO.read(new File("images//shipExplosion.png"));
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR LOADING IMAGES.  CONTACT ADMIN FOR SUPPORT");
				e.printStackTrace();
		}
		
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("ARDESTINE.ttf")));
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
