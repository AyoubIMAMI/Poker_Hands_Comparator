package v1.game_class.rules_class;

import v1.game_class.Card;

import java.util.ArrayList;

public class Quinte extends Combo {

    public Quinte(ArrayList<Card> quinte) {
        this.name = "Quinte";
        this.priorityValue = 4;
        this.cardOfCombo = quinte;
        this.comboValue = quinte.get(quinte.size()-1).getValue();
        this.type = 3;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

}
