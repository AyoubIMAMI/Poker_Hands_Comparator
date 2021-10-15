package v1.game_engine;

import v1.game_class.Card;
import v1.game_class.Hand;
import v1.game_class.rules_class.Hauteur;

import java.util.ArrayList;
import java.util.Optional;

public class HandComparator {
    private Hand firstHand;
    private Hand secondHand;
    private ArrayList<Card> winningCards;
    private String winningMethod;
    private HandAnalyzer hand1Analyzer;
    private HandAnalyzer hand2Analyzer;
    private Optional <String> winner;

    public HandComparator(Hand newHand1, Hand newHand2){
        this.firstHand = newHand1;
        this.secondHand = newHand2;
        winningCards = new ArrayList<Card>();
        hand1Analyzer= new HandAnalyzer(this.firstHand);
        hand2Analyzer= new HandAnalyzer(this.secondHand);
        winner=Optional.empty();
    }
    public void setWinner(){
        hand1Analyzer.analyze();
        hand2Analyzer.analyze();
        ArrayList<Hauteur> hauteurs1=hand1Analyzer.getCombo();
        ArrayList<Hauteur> hauteurs2=hand2Analyzer.getCombo();
        int i=0;
        while (i<hauteurs1.size()){
            Optional <String> compare=compareHauteur(hauteurs1.get(i).getValue(),hauteurs2.get(i).getValue());
            if (compare.isPresent()){
                if ("P1".equals(compare.get())){
                    winningCards.add(0,new Card(hauteurs1.get(i).getValue()));
                    winningMethod="Hauteur";
                    winner=Optional.of("P1");
                    i=hauteurs1.size();
                }
                else if ("P2".equals(compare.get())){
                    winningCards.add(0,new Card(hauteurs2.get(i).getValue()));
                    winningMethod="Hauteur";
                    winner=Optional.of("P2");
                    i=hauteurs1.size();
                }
            }
            i++;
        }
    }
    public Optional<String> compareHauteur(int carteP1, int carteP2){
        if (carteP1>carteP2)
        {return(Optional.of("P1"));}
        else if (carteP1<carteP2)
        {return(Optional.of("P2"));}
        return (Optional.empty());
    }
    public ArrayList<Card> getWinningCard() {
        return winningCards;
    }
    public String getWinningMethod() {
        return winningMethod;
    }

    public Optional<String> getWinner() {
        return winner;
    }
}
