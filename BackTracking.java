package allQuestions;

import java.util.*;

public class BackTracking {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int board[][] = new int[num][num];
		for(int i =0;i<num ; i++) {
			for(int j=0;j<num;j++) {
				board[i][j]= s.nextInt();
			}
		}
		
		ArrayList<Integer> colPos = new ArrayList<Integer>();
		// System.out.println(nQueen(board, num, 0, colPos));
	//	System.out.println(nKnights(board, 0, 0, num));
		System.out.println(ratInMaze(board, 0, 0));
	}

	public static int nQueen(int board[][], int num, int r, ArrayList<Integer> colPos) {
		if (num == 0) {
			for (int i = 0; i < colPos.size(); i++)
				System.out.print("(" + i + " , " + colPos.get(i) + ") ");
			System.out.println();
			return 1;
		}
		if (r >= board.length)
			return 0;
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			boolean safe = isSafe(board, r, i);
			if (safe) {
				board[r][i] = 1;
				colPos.add(i);
				count += nQueen(board, num - 1, r + 1, colPos);
				board[r][i] = 0;
				colPos.remove(colPos.size() - 1);
			}
		}

		return count;
	}

	public static boolean isSafe(int board[][], int r, int c) {
		boolean safe = true;
		for (int i = 0; i < r; i++) {
			if (board[i][c] == 1)
				safe = false;
		}
		if (!safe)
			return false;

		int col = c, row = r, n = board.length;
		while (col >= 0 && row >= 0) {
			if (board[row][col] == 1)
				safe = false;
			col--;
			row--;
		}
		if (!safe)
			return false;
		col = c;
		row = r;
		while (col < n && row >= 0) {
			if (board[row][col] == 1)
				safe = false;
			row--;
			col++;
		}
		return safe;
	}

	public static int nKnights(int board[][], int r, int c, int num) {
		if (r == 0 && c == 0)
			System.out.println("kmnklmnk");
		if (num == 0)
			return 1;
		if (r >= board.length)
			return 0;

		int count = 0;
		int row = r, col = c;
		while (row < board.length && col < board.length) {
			if (isSafeKnights(board, row, col)) {
				board[row][col] = 1;
				if (col + 1 < board.length)
					count += nKnights(board, row, col + 1, num - 1);
				else if (row + 1 < board.length)
					count += nKnights(board, row + 1, 0, num - 1);
				board[row][col] = 0;
			}
			col++;
			if (col == board.length) {
				row++;
				col = 0;
			}
		}
		return count;

	}

	private static boolean isSafeKnights(int[][] board, int r, int c) {
		if (r - 2 >= 0) {
			if ((c - 1 >= 0 && board[r - 2][c - 1] == 1) || (c + 1 < board.length && board[r - 2][c + 1] == 1))
				return false;
		}
		if (c - 2 >= 0) {
			if ((r - 1 >= 0 && board[r - 1][c - 2] == 1))
				return false;
		}
		if (c + 2 < board.length) {
			if ((r - 1 >= 0 && board[r - 1][c + 2] == 1))
				return false;
		}
		return true;

	}

	public static int ratInMaze(int[][] board , int r , int c ) {
		if(r>=board.length || c==board.length || r<0  || c<0 || board[r][c]==0 || board[r][c]==-1)
			return 0;
		if(r==board.length-1 && c==board.length-1)
			return 1;
		
		board[r][c]=-1;
		int count =0;
		count+= ratInMaze(board, r, c+1);
		count+= ratInMaze(board, r+1, c);
		count+= ratInMaze(board, r, c-1);
		count+= ratInMaze(board, r-1, c);
		board[r][c]=1;
		
		return count ;
	}

}
