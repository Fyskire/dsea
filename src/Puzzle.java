import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Puzzle {
	
	private int [][] arr;
	private int groeszeX=3;
	private int groeszeY=3;
	private HashMap h;

	
	/**
	 * Konstruktor
	 * 2b) 
	 * @param filepath
	 */
	public Puzzle(String filepath){
		fillMap();
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
	
	
	/**
	 * Befüllt HashMap mit ArrayListen die die möglichen Wege enthalten.
	 */
	public void fillMap(){
		ArrayList a0 = new ArrayList();
		a0.add(1);
		a0.add(3);
		ArrayList a1 = new ArrayList();
		a1.add(0);
		a1.add(2);
		a1.add(4);
		ArrayList a2 = new ArrayList();
		a2.add(1);
		a2.add(5);
		ArrayList a3 = new ArrayList();
		a3.add(0);
		a3.add(4);
		a3.add(6);
		ArrayList a4 = new ArrayList();
		a4.add(1);
		a4.add(3);
		a4.add(5);
		a4.add(7);
		ArrayList a5 = new ArrayList();
		a5.add(2);
		a5.add(4);
		a5.add(8);
		ArrayList a6 = new ArrayList();
		a6.add(3);
		a6.add(7);
		ArrayList a7 = new ArrayList();
		a7.add(6);
		a7.add(4);
		a7.add(8);
		ArrayList a8 = new ArrayList();
		a8.add(5);
		a8.add(7);
		
		h = new HashMap();
		h.put(0, a0);
		h.put(1, a1);
		h.put(2, a2);
		h.put(3, a3);
		h.put(4, a4);
		h.put(5, a5);
		h.put(6, a6);
		h.put(7, a7);
		h.put(8, a8);
		h.put(8, a8);
		System.out.println("Filling done");
		
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
