import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Puzzle {

    private int [][] arr;
    private int groeszeX=3;
    private int groeszeY=3;
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
        try{
            Scanner s = new Scanner(new File(filepath));

            String save = "";
            arr = new int[groeszeY][groeszeX];

            //Baut immer erst Zeile auf, bevor die Spalte wechselt
            while(s.hasNext()){
                for(int i = 0; i<groeszeY; i++){
                    for(int j=0; j<groeszeX; j++){
                        arr[i][j] = Integer.parseInt(s.next());
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Setzt die Belegung wie auf dem Blatt
     */
    public void setDefault(){
        this.groeszeX=3;
        this.groeszeY=3;
        arr= new int[groeszeY][groeszeX];
        arr[0][0]=3;
        arr[0][1]=2;
        arr[0][2]=7;
        arr[1][0]=1;
        arr[1][1]=4;
        arr[1][2]=5;
        arr[2][0]=0;
        arr[2][1]=6;
        arr[2][2]=8;
    }

    /*
     * 2a) gibt Matrix als String zurück
     */
    public String print(){
        String erg = "";
        for(int i = 0; i<groeszeY; i++){
            for(int j=0; j<groeszeX; j++){
                erg += arr[i][j];
            }
        }
        return erg;
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Puzzle p = new Puzzle("C:\\Users\\Yorrick\\workspace\\DSEA\\src\\puzzle.txt");
        //p.setDefault();
        System.out.println("Inhalt der Matrix als String: " + p.print());
    }

}
