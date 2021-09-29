package v1;

import java.util.Optional;

public class PrintPoker {
	private Game game;
	
	public PrintPoker(Game g) {
		this.game=g;
	}
	
	public void win(Optional<Hand> winner) {
		if(!(winner.isPresent()))System.out.println("Egalite");
		else{
			Hand realWinner = winner.get();
			System.out.println("Le joueur "+ realWinner.getName()+ " a gagne !!");
		}
	}
	
	public void start(){
		System.out.println(game);
		}
}


