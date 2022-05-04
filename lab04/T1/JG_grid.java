package lab03;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class JG_grid extends JGaloInterface{
    
    private Character[][] grid = new Character[3][3]; // 3x3 grid
    private player actualplayer = player.o; // starting player
    private final List<int[]> directions = Arrays.asList(new int[][] {{1,0},{0,1},{1,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1}}); // posible directions
    private int[] lastplaycoord = null; // last played coord
    private enum player{x,o;} // possible players
    private int turns = 0; // number of turns played
    private char res; // result of the match
    
    // gets player sets next
    public char getActualPlayer(){
        if(this.actualplayer.equals(player.o)){
            this.actualplayer = player.x;
            return 'o';
        }
        this.actualplayer = player.o;
        return 'x';
    }
    
    // fill the grid and update last played coord
    public boolean setJogada(int lin, int col){
        if(this.grid[col-1][lin-1] == null){
            this.grid[col-1][lin-1] = String.valueOf(this.actualplayer).charAt(0);
            this.lastplaycoord = new int[] {col-1,lin-1};
            this.turns += 1;
            return true;
        }
        return false;
        
    }
    
    // Tells if the match is finished and if so updates the res
    public boolean isFinished(){
        // Test 1
        // System.out.printf("New check -> playercord {%d,%d}\n",this.lastplacement[0],this.lastplacement[1]);
        char token = String.valueOf(actualplayer).charAt(0);
        ArrayBlockingQueue<int[]> directions_queue = new ArrayBlockingQueue<int[]>(directions.size());
        directions_queue.addAll(directions);
        
        while(!directions_queue.isEmpty()){
            // Test 2
            // System.out.println("in cicle");
            int[] dir = directions_queue.poll();
            // Test 3
            // System.out.printf("{%d,%d} -> direction\n",dir[0],dir[1]);
            int i;
            for (i=1;i<3;i++){
                try{
                    // here we check if the next coord is equal in the direction, if so i++
                    System.out.printf("{%d,%d} -> coord\n",this.lastplaycoord[0]+dir[0]*i,this.lastplaycoord[1]+dir[1]*i);
                    if(this.grid[this.lastplaycoord[0]+dir[0]*i][this.lastplaycoord[1]+dir[1]*i].equals(token)){
                        // Test 4
                        // System.out.println("its equal");
                        continue;
                    }
                }catch(Exception e){
                    // Array out of bounds
                    break;
                }
                // else we try check another direction
                break;
            }
            if(i == 3){
                // If a tic-tac-toe ocurred updates the res with the winner (kinda of junky, but it works)
                if(token == 'o'){
                    this.res = 'x';
                    return true;
                }
                this.res = 'o';
                return true;
                
            }
        }
       // If all positions are filled than its a tie
       if(this.turns == 9){
            this.res = ' ';
            return true;
        }
        return false; 
    }
    
    // Resturns res
    public char checkResult(){
       return this.res; 
    }    
}
