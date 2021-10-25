package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import v1.game_class.Card;
import v1.game_class.rules_class.Combo;
import v1.game_class.rules_class.Flush;
import v1.game_class.rules_class.Quinte;
import v1.game_engine.HandAnalyzer;

import java.util.ArrayList;
import java.util.Optional;

public class HandAnalyzerTest {

    //Variables
    private ArrayList<Card> listCardsPaire;
    private ArrayList<Card> listCardsBrelan;
    private ArrayList<Card> listCardsSquare;
    private ArrayList<Card> listCardsFlush;
    private HandAnalyzer flushHand;

    @BeforeEach
    private void init() {
        listCardsPaire = new ArrayList<Card>();
        listCardsPaire.add(new Card(2));
        listCardsPaire.add(new Card(2));
        listCardsPaire.add(new Card(4));
        listCardsPaire.add(new Card(5));
        listCardsPaire.add(new Card(6));

        listCardsBrelan = new ArrayList<Card>();
        listCardsBrelan.add(new Card(7));
        listCardsBrelan.add(new Card(7));
        listCardsBrelan.add(new Card(7));
        listCardsBrelan.add(new Card(10));
        listCardsBrelan.add(new Card(11));

        listCardsSquare = new ArrayList<Card>();
        listCardsSquare.add(new Card(12));
        listCardsSquare.add(new Card(12));
        listCardsSquare.add(new Card(12));
        listCardsSquare.add(new Card(12));
        listCardsSquare.add(new Card(14));

        listCardsFlush = new ArrayList<Card>();
        listCardsFlush.add(new Card(2, "ca"));
        listCardsFlush.add(new Card(4, "ca"));
        listCardsFlush.add(new Card(6, "ca"));
        listCardsFlush.add(new Card(8, "ca"));
        listCardsFlush.add(new Card(14,"ca"));

        flushHand = new HandAnalyzer(listCardsFlush);
    }


    @Test
    void findColorTest() {
        Optional<Combo> color = Optional.of(new Flush(this.listCardsFlush));
        assertTrue(flushHand.findColor().isPresent());
        for (int i = 0; i < listCardsFlush.size(); i++) {
            assertEquals(color.get(), flushHand.findColor().get().getComboColor());
        }
    }

    @Test
    void getComboTest(){
        ArrayList <Card>listCardp2 = new ArrayList<>();
        listCardp2.add(new Card(2, "tr"));
        listCardp2.add(new Card(3,"ca"));
        listCardp2.add(new Card(4,"ca"));
        listCardp2.add(new Card(5,"ca"));
        listCardp2.add(new Card(6,"ca"));
        HandAnalyzer analyze = new HandAnalyzer(listCardp2);
        Combo type3Combo = new Quinte(listCardp2);

        Optional<Combo> optCombo1 = analyze.getCombo();
        Combo combo1;
        assertTrue(optCombo1.isPresent());
        combo1 = optCombo1.get();
        assertEquals(combo1,type3Combo);
    }

}
