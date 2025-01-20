package game.objects.interfaces;

public interface ItemEntity extends Drawable {
	
	enum ItemType {
		gunType,
		gunRate,
		movement,
		healthPack
	}
	abstract ItemType itemType();
}
