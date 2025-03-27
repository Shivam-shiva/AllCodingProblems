package allQuestions;

import java.util.Scanner;

public class TowerOfHanoi {

	public static void main(String[] args) {
		Scanner s = new  Scanner(System.in);
		System.out.println("Enter number of plates");
		int plate = s.nextInt();
		
		towerOfHanoi(plate,"src", "hel", "des");
	}

	private static void towerOfHanoi(int plate, String sr, String hl, String de) {
		
		if(plate<1) {
			return;
		}
		
		towerOfHanoi(plate-1, sr, de, hl);
		System.out.println("Move plate number "+ plate+ " from " + sr+" to "+de );
		towerOfHanoi(plate-1, hl, sr, de);	
		
	}

}
