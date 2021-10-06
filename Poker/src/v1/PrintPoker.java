package v1;

import java.util.Optional;
//the class that manage the output message
public class PrintPoker {
	private Game game;
	
	public PrintPoker(Game g) {
		this.game=g;
	}

	
	//print the winner
	public void win(Optional<Hand> winner) {
		if(!(winner.isPresent()))System.out.println("Egalite");
		else{
			Hand realWinner = winner.get();
			System.out.println("Le joueur "+ realWinner.getName()+ " a gagne avec "+this.game.gethowWin() +" avec la carte "+this.game.getwhatWin().getValue());
		}
	}
	// present the game, the two players and theirs cards
	public void start(){
		System.out.println(game);
		}
}


