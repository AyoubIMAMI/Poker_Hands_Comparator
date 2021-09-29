package v1;

public class PrintPoker {
	private Game game;
	
	public PrintPoker(Game g) {
		this.game=g;
	}
	
	public void win(Hand winner) {
		System.out.println("Le joueur "+ winner.getName()+ " a gagné !!");
	}
	
	public void start(){
		System.out.println(game);
		}
}


