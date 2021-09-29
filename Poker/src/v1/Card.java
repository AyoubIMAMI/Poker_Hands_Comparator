package v1;

import java.util.ArrayList;

public class Card {
	private int value;
	
	public Card(int v) {
		this.value = v;
	}

	public int getValue() {
		return value;
	}
	
	public String toString(){
		return String.valueOf(this.value);
		}

}
