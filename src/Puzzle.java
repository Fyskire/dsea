import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Puzzle {

    private String grid;
    private static final HashMap<Integer,ArrayList<Integer>> MOVES;
    static {
        MOVES = new HashMap<Integer,ArrayList<Integer>>(9);
        for (int i = 0;i<9;i++) MOVES.put(i,new ArrayList<Integer>());
        MOVES.get(0).add(1);
        MOVES.get(0).add(3);
        MOVES.get(1).add(0);
        MOVES.get(1).add(2);
        MOVES.get(1).add(4);
        MOVES.get(2).add(1);
        MOVES.get(2).add(5);
        MOVES.get(3).add(0);
        MOVES.get(3).add(4);
        MOVES.get(3).add(6);
        MOVES.get(4).add(1);
        MOVES.get(4).add(3);
        MOVES.get(4).add(5);
        MOVES.get(4).add(7);
        MOVES.get(5).add(2);
        MOVES.get(5).add(4);
        MOVES.get(5).add(8);
        MOVES.get(6).add(3);
        MOVES.get(6).add(7);
        MOVES.get(7).add(4);
        MOVES.get(7).add(6);
        MOVES.get(7).add(8);
        MOVES.get(8).add(5);
        MOVES.get(8).add(7);
        MOVES.get(1).add(0);
    }


    /**
     * Konstruktor
     * 2b)
     * @param filepath
     */
    public Puzzle(String filepath){
        try (Scanner s = new Scanner(new File(filepath))) {
            StringBuilder sb = new StringBuilder();
            while (s.hasNext())
                sb.append(s.next());
            grid = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Puzzle(int[][] arr) {
        grid = encode(arr);
    }

    /*
     * 2a) gibt Matrix als String zurück
     */
    public String encode(int[][] arr){
        StringBuilder sb = new StringBuilder(9);
        for(int i = 0; i<3; i++)
            for(int j=0; j<3; j++)
                sb.append(arr[i][j]);
        return sb.toString();
    }


    public String solve() {
        Set<String> explored = new HashSet<String>();
        MyQueue<String> q = new MyQueue<String>(362880); // = 9!
        q.push(grid);
        explored.add(grid);
        String current, next;
        while (q.size()>0) {
            current = q.pop();
            if (current == "012345678")
                return current;
            for (Integer i: MOVES.get(current.indexOf('0'))) {
                next = current.replace('0',i.toString().charAt(0));
                q.push(next);
                explored.add(next);
            }
        }
        return null;
    }

    public String toString() {
        return grid;
    }

    public static void main(String[] args) {
        Puzzle p = new Puzzle(args[0]);
        System.out.println("Inhalt der Matrix als String: " + p);
        System.out.println(p.solve());
    }

}
