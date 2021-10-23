package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import v1.game_class.Card;
import v1.game_class.Hand;
import v1.game_engine.HandComparator;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandComparatorTest {
    ArrayList<Card> listCard1;

    Hand handFull;
    Hand handPaire;
    Hand handHauteur;
    Hand handCouleur;
    Hand handBrelan;
    Hand handDoublePaire;
    Hand handQuinte;
    Hand handQuinteFlush;
    Hand handCarré;

    @BeforeEach
    void init(){
        //initialization handFull
        listCard1 = new ArrayList<Card>();
        listCard1.add(new Card(5, "tr"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(8,"ca"));
        listCard1.add(new Card(8,"ca"));
        handFull=new Hand("player",listCard1);

        //initialization handPaire
        listCard1 = new ArrayList<Card>();
        listCard1.add(new Card(5, "tr"));
        listCard1.add(new Card(4,"ca"));
        listCard1.add(new Card(3,"ca"));
        listCard1.add(new Card(8,"ca"));
        listCard1.add(new Card(8,"ca"));
        handPaire=new Hand("player",listCard1);

        //initialization handHauteur
        listCard1 = new ArrayList<Card>();
        listCard1.add(new Card(2, "tr"));
        listCard1.add(new Card(4,"ca"));
        listCard1.add(new Card(6,"ca"));
        listCard1.add(new Card(8,"ca"));
        listCard1.add(new Card(10,"ca"));
        handHauteur=new Hand("player",listCard1);

        //initialization handCouleur
        listCard1 = new ArrayList<Card>();
        listCard1.add(new Card(2, "ca"));
        listCard1.add(new Card(4,"ca"));
        listCard1.add(new Card(6,"ca"));
        listCard1.add(new Card(8,"ca"));
        listCard1.add(new Card(10,"ca"));
        handCouleur=new Hand("player",listCard1);

        //initialization handBrelan
        listCard1 = new ArrayList<Card>();
        listCard1.add(new Card(5, "tr"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(8,"ca"));
        listCard1.add(new Card(2,"ca"));
        handBrelan=new Hand("player",listCard1);

        //initialization handDoublePaire
        listCard1 = new ArrayList<Card>();
        listCard1.add(new Card(5, "tr"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(3,"ca"));
        listCard1.add(new Card(8,"ca"));
        listCard1.add(new Card(8,"ca"));
        handDoublePaire=new Hand("player",listCard1);

        //initialization handQuinte
        listCard1 = new ArrayList<Card>();
        listCard1.add(new Card(3, "tr"));
        listCard1.add(new Card(4,"ca"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(6,"ca"));
        listCard1.add(new Card(7,"ca"));
        handQuinte=new Hand("player",listCard1);

        //initialization handQuinteFlush
        listCard1 = new ArrayList<Card>();
        listCard1.add(new Card(3, "ca"));
        listCard1.add(new Card(4,"ca"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(6,"ca"));
        listCard1.add(new Card(7,"ca"));
        handQuinteFlush=new Hand("player",listCard1);

        //initialization handCarré
        listCard1 = new ArrayList<Card>();
        listCard1.add(new Card(5, "tr"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(7,"ca"));
        handCarré=new Hand("player",listCard1);

    }
    //Test of getWinner

    //Test equality pour chaque type
    @Test
    void getWinnerTestEgalitéType0() {
        //on recréer exactement la meme main
        listCard1 = new ArrayList<Card>();
        listCard1.add(new Card(2, "tr"));
        listCard1.add(new Card(4,"ca"));
        listCard1.add(new Card(6,"ca"));
        listCard1.add(new Card(8,"ca"));
        listCard1.add(new Card(10,"ca"));
        Hand hand1=new Hand("player",listCard1);
        HandComparator handComparator = new HandComparator(handHauteur, hand1);
        assertEquals(handComparator.getWinner(), Optional.empty());
    }
    @Test
    void getWinnerTestEgalitéType1() {
        //on recréer exactement la meme main
        listCard1 = new ArrayList<Card>();
        listCard1.add(new Card(5, "tr"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(8,"ca"));
        listCard1.add(new Card(8,"ca"));
        Hand hand1=new Hand("player",listCard1);
        HandComparator handComparator = new HandComparator(handBrelan, hand1);
        assertEquals(handComparator.getWinner(), Optional.empty());
    }

    @Test
    void getWinnerTestEgalitéType2() {
        //on recréer exactement la meme main
        listCard1 = new ArrayList<Card>();
        listCard1.add(new Card(5, "tr"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(5,"ca"));
        listCard1.add(new Card(8,"ca"));
        listCard1.add(new Card(8,"ca"));
        Hand hand1=new Hand("player",listCard1);
        HandComparator handComparator = new HandComparator(handFull, hand1);
        assertEquals(handComparator.getWinner(), Optional.empty());
    }

    //Test of Type vs another Type in getWinner
    @Test
    void getWinnerTestType2vsType1(){

        //Hand with a type 1: Brelan
        //We compare her with handFull containing a type 2 : Full
        HandComparator handComparator=new HandComparator(handFull,handBrelan);
        assertEquals(handComparator.getWinner().get(),handFull);
    }
    @Test
    void getWinnerTestType2vsType2(){
        //Hand with a type 1: Full Brelan de 8 et paire de 4
        ArrayList <Card>listCardp2 = new ArrayList<>();
        listCardp2.add(new Card(4, "tr"));
        listCardp2.add(new Card(4,"ca"));
        listCardp2.add(new Card(8,"ca"));
        listCardp2.add(new Card(8,"ca"));
        listCardp2.add(new Card(8,"ca"));
        Hand hand2=new Hand("player1",listCardp2);
        //We compare her to handFull with a type 2 : Full Brelan de 8 et paire de 5
        HandComparator handComparator=new HandComparator(handFull,hand2);
        assertEquals(handComparator.getWinner().get(),handFull);
    }
    @Test
    void getWinnerTestType2vsType0(){

        //Hand with a type 0: Hauteur
        //We compare her to handFull with a type 2 : Full
        HandComparator handComparator=new HandComparator(handFull,handHauteur);
        assertEquals(handComparator.getWinner().get(),handFull);
    }
    @Test
    void getWinnerTestType0vsType0(){

        //Hand with a type 0: Hauteur
        ArrayList <Card>listCardp2 = new ArrayList<>();
        listCardp2.add(new Card(2, "tr"));
        listCardp2.add(new Card(4,"ca"));
        listCardp2.add(new Card(5,"ca"));
        listCardp2.add(new Card(8,"ca"));
        listCardp2.add(new Card(10,"ca"));
        Hand hand2=new Hand("player1",listCardp2);
        //We compare her to handFull with a type 2 : Full
        HandComparator handComparator=new HandComparator(handHauteur,hand2);
        assertEquals(handComparator.getWinner().get(),handHauteur);
    }




}
