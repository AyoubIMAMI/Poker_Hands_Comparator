package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import v1.game_class.Card;
import v1.game_class.rules_class.Combo;
import v1.game_class.rules_class.Flush;
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
        assertEquals(color, flushHand.findColor());
    }

}
