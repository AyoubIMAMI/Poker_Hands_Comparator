package v1.game_class.rules_class;

public class Hauteur extends Combo{
	private int value;
	public Hauteur(int valeur) {
		value=valeur;
		this.name = "Hauteur";
		this.priorityValue = 1;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getValue() {
		return value;
	}
}
