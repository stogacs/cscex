import java.util.*;
import java.io.*;
public class SudokuSolver {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("SudokuSolverIN.txt"));
        
        int[][] puzzle = new int[9][9];
        
        while(sc.hasNext()) {
        	for(int i = 0; i < 9; i++) {
        		for(int j = 0; j < 9; j++) {
        			puzzle[i][j] = sc.nextInt();
        		}
        	}
        	
        	puzzle = sudokuSolve(puzzle);
        	
        	for(int i = 0; i < 9; i++) {
        		for(int j = 0; j < 9; j++) {
        			if(j < 8) {
        				System.out.print(puzzle[i][j] + " ");
        			} else {
        				System.out.println(puzzle[i][j]);
        			}
        		}
        	}
        	
        	System.out.println("");
        	
        }
    }
    
    public static int[][] sudokuSolve(int[][] puzzle) {
    	ArrayList<String> emptySquareKeys = new ArrayList<String>();
    	HashMap<String, Integer> emptySquares = new HashMap<String, Integer>();
    	HashMap<String, ArrayList<Integer>> emptyPossibilities =
    			new HashMap<String, ArrayList<Integer>>();
    	
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    			if(puzzle[i][j] == 0) {
    				HashSet<Integer> numbersInRowAndColumn = new HashSet<Integer>();
    				
    				for(int a = 0; a < 9; a++) {
    					if(puzzle[a][j] != 0) {
    						numbersInRowAndColumn.add(puzzle[a][j]);
    					}
    				}
    				
    				for(int a = 0; a < 9; a++) {
    					if(puzzle[i][a] != 0) {
    						numbersInRowAndColumn.add(puzzle[i][a]);
    					}
    				}
    				
    				ArrayList<Integer> possibilities = new ArrayList<Integer>();
    				
    				for(int x = 1; x <= 9; x++) {
    					if(!numbersInRowAndColumn.contains(x)) {
    						possibilities.add(x);
    					}
    				}
    				
    				if(possibilities.size() == 1) {
    					puzzle[i][j] = possibilities.get(0);
    				} else {
    					emptySquareKeys.add(i + "," + j);
    					emptyPossibilities.put(i + "," + j, possibilities);
    					emptySquares.put(i + "," + j, possibilities.get(0));
    				}
    				
    			}
    		}
    	}
    	
    	boolean solved = false;
    	
    	if(emptySquareKeys.size() == 0) {
    		return puzzle;
    	}
    	
    	while(!solved) {
    		for(int i = 0; i < emptySquareKeys.size(); i++) {
    			String[] coordinates = emptySquareKeys.get(i).split(",");
    			int y = Integer.parseInt(coordinates[0]);
    			int x = Integer.parseInt(coordinates[1]);
    			
    			puzzle[y][x] = emptySquares.get(emptySquareKeys.get(i));
    		}
    		
    		if(checkSolution(puzzle)) {
    			solved = true;
    			return puzzle;
    		}
    		
    		int lastIndex = emptySquareKeys.size() - 1;
    		
    		while(lastIndex >= 0) {
    			ArrayList<Integer> possibilities = 
    					emptyPossibilities.get(emptySquareKeys.get(lastIndex));
    			
    			if(emptySquares.get(emptySquareKeys.get(lastIndex)) == 
    					possibilities.get(possibilities.size() - 1)) {
    				emptySquares.put(emptySquareKeys.get(lastIndex), 
    						possibilities.get(0));
    				lastIndex--;
    			} else {
    				int pIndex = possibilities.indexOf(emptySquares.get(
    						emptySquareKeys.get(lastIndex)));
    				emptySquares.put(emptySquareKeys.get(lastIndex), 
    						possibilities.get(pIndex + 1));
    				lastIndex = -1;
    			}
    		}
    	}
    	
    	return null;
    }
    
    public static boolean checkSolution(int[][] puzzle) {
    	boolean correct = true;
    	int i = 0;
    	
    	while(correct && i < 9) {
    		HashSet<Integer> squareValues = new HashSet<Integer>();
    		for(int j = 0; j < 9; j++) {
    			squareValues.add(puzzle[i][j]);
    		}
    		
    		if(squareValues.size() != 9) {
    			correct = false;
    		}
    		
    		i++;
    	}
    	
    	i = 0;
    	
    	while(correct && i < 9) {
    		HashSet<Integer> squareValues = new HashSet<Integer>();
    		for(int j = 0; j < 9; j++) {
    			squareValues.add(puzzle[j][i]);
    		}
    		
    		if(squareValues.size() != 9) {
    			correct = false;
    		}
    		
    		i++;
    	}
    	
    	i = 0;
    	
    	while(correct && i < 9) {
    		HashSet<Integer> squareValues = new HashSet<Integer>();
    		int xOffset = 3 * (i % 3);
    		int yOffset = 3 * (i / 3);
    		for(int j = 0; j < 9; j++) {
    			int xMiniOffset = j % 3;
    			int yMiniOffset = j / 3;
    			squareValues.add(puzzle[yOffset + yMiniOffset][xOffset + xMiniOffset]);
    		}
    		
    		if(squareValues.size() != 9) {
    			correct = false;
    		}
    		i++;
    	}
    	
    	return correct;
    }
}
