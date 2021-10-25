package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import v1.game_class.Card;
import v1.game_class.rules_class.*;
import v1.game_engine.HandAnalyzer;

import java.util.ArrayList;
import java.util.Optional;

public class HandAnalyzerTest {

    //Variables
    private ArrayList<Card> listCardsPaire;
    private ArrayList<Card> listCardsPaire2;
    private ArrayList<Card> listCardsBrelan;
    private ArrayList<Card> listCardsSquare;
    private ArrayList<Card> listCardsFull1;
    private ArrayList<Card> listCardsFull2;
    private ArrayList<Card> listCardsQuinte;
    private ArrayList<Card> listCardsDoublePaire1;
    private ArrayList<Card> listCardsDoublePaire2;
    private ArrayList<Card> listCardsFlush;
    private ArrayList<Card> listCardsQuinteFlush;
    private ArrayList<Card> listCardsOptionalEmpty;

    @BeforeEach
    private void init() {
        listCardsPaire = new ArrayList<Card>();
        listCardsPaire.add(new Card(2, "tr"));
        listCardsPaire.add(new Card(2,"ca"));

        listCardsPaire2 = new ArrayList<Card>();
        listCardsPaire2.add(new Card(7, "tr"));
        listCardsPaire2.add(new Card(7, "ca"));

        listCardsBrelan = new ArrayList<Card>();
        listCardsBrelan.add(new Card(7, "tr"));
        listCardsBrelan.add(new Card(7,"ca"));
        listCardsBrelan.add(new Card(7,"pi"));

        listCardsSquare = new ArrayList<Card>();
        listCardsSquare.add(new Card(9, "tr"));
        listCardsSquare.add(new Card(9,"ca"));
        listCardsSquare.add(new Card(9,"pi"));
        listCardsSquare.add(new Card(9,"pi"));

        listCardsFull1 = new ArrayList<Card>();
        listCardsFull1.add(new Card(5, "tr"));
        listCardsFull1.add(new Card(5,"ca"));
        listCardsFull1.add(new Card(5,"tr"));
        listCardsFull1.add(new Card(8,"pi"));
        listCardsFull1.add(new Card(8,"ca"));

        listCardsFull2 = new ArrayList<Card>();
        listCardsFull2.add(new Card(5, "tr"));
        listCardsFull2.add(new Card(5,"ca"));
        listCardsFull2.add(new Card(8,"tr"));
        listCardsFull2.add(new Card(8,"pi"));
        listCardsFull2.add(new Card(8,"ca"));

        listCardsDoublePaire1 = new ArrayList<Card>();
        listCardsDoublePaire1.add(new Card(3, "tr"));
        listCardsDoublePaire1.add(new Card(3,"ca"));
        listCardsDoublePaire1.add(new Card(6,"ca"));
        listCardsDoublePaire1.add(new Card(6,"pi"));
        listCardsDoublePaire1.add(new Card(10,"ca"));

        listCardsDoublePaire2 = new ArrayList<Card>();
        listCardsDoublePaire2.add(new Card(7, "tr"));
        listCardsDoublePaire2.add(new Card(7,"ca"));
        listCardsDoublePaire2.add(new Card(5,"ca"));
        listCardsDoublePaire2.add(new Card(5,"pi"));
        listCardsDoublePaire2.add(new Card(10,"ca"));

        listCardsQuinte = new ArrayList<Card>();
        listCardsQuinte.add(new Card(2, "tr"));
        listCardsQuinte.add(new Card(3,"ca"));
        listCardsQuinte.add(new Card(4,"ca"));
        listCardsQuinte.add(new Card(5,"ca"));
        listCardsQuinte.add(new Card(14,"ca"));

        listCardsFlush = new ArrayList<Card>();
        listCardsFlush.add(new Card(3, "ca"));
        listCardsFlush.add(new Card(5,"ca"));
        listCardsFlush.add(new Card(6,"ca"));
        listCardsFlush.add(new Card(8,"ca"));
        listCardsFlush.add(new Card(10,"ca"));

        listCardsQuinteFlush = new ArrayList<Card>();
        listCardsQuinteFlush.add(new Card(3, "ca"));
        listCardsQuinteFlush.add(new Card(4,"ca"));
        listCardsQuinteFlush.add(new Card(5,"ca"));
        listCardsQuinteFlush.add(new Card(6,"ca"));
        listCardsQuinteFlush.add(new Card(7,"ca"));

        listCardsOptionalEmpty = new ArrayList<Card>();
        listCardsOptionalEmpty.add(new Card(3, "ca"));
        listCardsOptionalEmpty.add(new Card(5,"pi"));
        listCardsOptionalEmpty.add(new Card(7,"ca"));
        listCardsOptionalEmpty.add(new Card(8,"tr"));
        listCardsOptionalEmpty.add(new Card(10,"ca"));

    }


    @Test
    void getComboType1PaireTest(){
        HandAnalyzer analyze = new HandAnalyzer(this.listCardsPaire);
        Combo otherCombo = new Paire(listCardsPaire);
        Optional<Combo> optCombo = analyze.getCombo();
        Combo combo;
        assertTrue(optCombo.isPresent());
        combo = optCombo.get();
        assertEquals(otherCombo,combo);
    }

    @Test
    void getComboType1BrelanTest(){
        HandAnalyzer analyze = new HandAnalyzer(this.listCardsBrelan);
        Combo otherCombo = new Brelan(listCardsBrelan);
        Optional<Combo> optCombo = analyze.getCombo();
        Combo combo;
        assertTrue(optCombo.isPresent());
        combo = optCombo.get();
        assertEquals(otherCombo,combo);
    }

    @Test
    void getComboType1SquareTest(){
        HandAnalyzer analyze = new HandAnalyzer(this.listCardsSquare);
        Combo otherCombo = new Square(listCardsSquare);
        Optional<Combo> optCombo = analyze.getCombo();
        Combo combo;
        assertTrue(optCombo.isPresent());
        combo = optCombo.get();
        assertEquals(otherCombo,combo);
    }

    @Test
    void getComboType2Full1Test(){
        HandAnalyzer analyze = new HandAnalyzer(this.listCardsFull1);
        Combo comboBrelan = new Brelan(listCardsBrelan);
        Combo comboPaire = new Paire(listCardsPaire);
        Combo otherCombo = new Full(comboBrelan, comboPaire);
        Optional<Combo> optCombo = analyze.getCombo();
        Combo combo;
        assertTrue(optCombo.isPresent());
        combo = optCombo.get();
        assertNotEquals(otherCombo,combo);
    }

    @Test
    void getComboType2Full2Test(){
        HandAnalyzer analyze = new HandAnalyzer(this.listCardsFull2);
        Combo comboBrelan = new Brelan(listCardsBrelan);
        Combo comboPaire = new Paire(listCardsPaire);
        Combo otherCombo = new Full(comboBrelan, comboPaire);
        Optional<Combo> optCombo = analyze.getCombo();
        Combo combo;
        assertTrue(optCombo.isPresent());
        combo = optCombo.get();
        assertNotEquals(otherCombo,combo);
    }

    @Test
    void getComboType2DoublePaire1Test(){
        HandAnalyzer analyze = new HandAnalyzer(this.listCardsDoublePaire1);
        Combo comboPaire1 = new Paire(listCardsPaire);
        Combo comboPaire2 = new Paire(listCardsPaire2);
        Combo otherCombo = new DoublePaire(comboPaire1, comboPaire2);
        Optional<Combo> optCombo = analyze.getCombo();
        Combo combo;
        assertTrue(optCombo.isPresent());
        combo = optCombo.get();
        assertNotEquals(otherCombo,combo);
    }

    @Test
    void getComboType2DoublePaire2Test(){
        HandAnalyzer analyze = new HandAnalyzer(this.listCardsDoublePaire2);
        Combo comboPaire1 = new Paire(listCardsPaire);
        Combo comboPaire2 = new Paire(listCardsPaire2);
        Combo otherCombo = new DoublePaire(comboPaire1, comboPaire2);
        Optional<Combo> optCombo = analyze.getCombo();
        Combo combo;
        assertTrue(optCombo.isPresent());
        combo = optCombo.get();
        assertNotEquals(otherCombo,combo);
    }

    @Test
    void getComboType3Test(){
        HandAnalyzer analyze = new HandAnalyzer(this.listCardsQuinte);
        Combo otherCombo = new Quinte(listCardsQuinte);
        Optional<Combo> optCombo = analyze.getCombo();
        Combo combo;
        assertTrue(optCombo.isPresent());
        combo = optCombo.get();
        assertEquals(otherCombo,combo);
    }

    @Test
    void getComboFindColorTest(){
        HandAnalyzer analyze = new HandAnalyzer(this.listCardsFlush);
        Combo otherCombo = new Flush(listCardsFlush);
        Optional<Combo> optCombo = analyze.getCombo();
        Combo combo;
        assertTrue(optCombo.isPresent());
        combo = optCombo.get();
        assertEquals(otherCombo,combo);
    }

    @Test
    void getComboType3AndFindColorTest(){
        HandAnalyzer analyze = new HandAnalyzer(this.listCardsQuinteFlush);
        Combo otherCombo = new QuinteFlush(listCardsQuinteFlush);
        Optional<Combo> optCombo = analyze.getCombo();
        Combo combo;
        assertTrue(optCombo.isPresent());
        combo = optCombo.get();
        assertEquals(otherCombo,combo);
    }

    @Test
    void getComboOptionalEmpty(){
        HandAnalyzer analyze = new HandAnalyzer(this.listCardsOptionalEmpty);
        Optional<Combo> optCombo = analyze.getCombo();
        assertTrue(optCombo.isEmpty());
    }

}
