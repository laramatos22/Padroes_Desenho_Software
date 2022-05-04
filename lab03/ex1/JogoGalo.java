import java.util.*;

public class JogoGalo implements JGaloInterface{
	private char[][] game;
	private char player;
	private char winner;
	private int numMoves;

	public JogoGalo(){
		this.game = new char[3][3];
		this.player = 'X';
		this.winner = ' ';
		this.numMoves = 0;
	}

	public char getActualPlayer(){ return player; }

	public boolean setJogada(int lin, int col){
		game[lin-1][col-1] = player;
		if(player == 'X') player = 'O'; 
		else player = 'X';
		numMoves++;
		return true;
	}

	public boolean isFinished(){
		ArrayList<String> sequence = getLines();

		for(String seq : sequence){
			if(seq.equals("XXX")){
				winner = 'X';
				return true;
			}
			if(seq.equals("OOO")){
				winner = 'O';
				return true;
			}
		}
		if(numMoves == 9) return true;
		return false;
	}

	public char checkResult(){ return winner; }

	private ArrayList<String> getLines(){
		ArrayList<String> sequence = new ArrayList<String>();
		for (int i = 0; i < game.length; i++) {
			sequence.add(String.valueOf(game[i]));
		}
		for (int line = 0; line < game.length; line++) {
			String v = "";
			for (int col = 0; col < game.length; col++) {
				v = v + game[col][line];
			}
			sequence.add(v);
		}
		sequence.add(""+game[0][0]+game[1][1]+game[2][2]);
		sequence.add(""+game[0][2]+game[1][1]+game[2][0]);
		return sequence;
	}
}
