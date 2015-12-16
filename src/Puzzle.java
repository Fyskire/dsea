
public class Puzzle {
	
	private int [][] arr;
	private int groeszeX;
	private int groeszeY;

	/**
	 * Setzt die Belegung wie auf dem Blatt
	 */
	private void setDefault(){
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
	
	private String print(){
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

		Puzzle p = new Puzzle();
		p.setDefault();
		System.out.println(p.print());
	}

}
