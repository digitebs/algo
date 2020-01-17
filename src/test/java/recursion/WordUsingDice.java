package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * construct the word using  6 sided dice
 *
 */
public class WordUsingDice {
    /**
     *
     * @param word
     * @param dice
     * @param visited backtracking
     * @return
     */
    public static boolean construct(String word, char[][] dice,List<Integer> visited){
        if(word.isEmpty()) return true;
        for(char c: word.toCharArray()){
            for (int i = 0; i < dice.length; i++) {
                for(int j = 0; j < dice[i].length; j++){
                    if(!visited.contains(i) && dice[i][j]== c) {
                        visited.add(i);
                        if(construct(word.substring(1),dice,visited)) return true;
                        visited.remove(visited.size()-1); // remove the last inserted?
                    }
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {

        String word = "hello";
        char[][] dice = {
                {'a','l','c','d','e','f'},
                {'a','b','c','d','e','f'},
                {'a','b','c','h','e','f'},
                {'a','b','c','d','o','f'},
                {'a','b','c','l','e','f'}
        };

        char[][] dice2 = {
                {'a','b','c','d','e','f'},
                {'a','b','c','d','e','f'},
                {'a','b','c','h','e','f'},
                {'a','b','c','d','o','f'},
                {'a','b','c','l','e','f'}
        };

        String word2 = "aaaa";
        char[][] dice3 = {
                {'a','a','a','a','a','a'},
                {'b','b','b','b','b','b'},
                {'a','b','c','d','e','f'},
                {'a','b','c','d','e','f'}
        };

        List<Integer> visited = new ArrayList<>();
        System.out.println(construct(word,dice2,visited));
    }
}
