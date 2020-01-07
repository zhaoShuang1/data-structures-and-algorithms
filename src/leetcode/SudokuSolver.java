package leetcode;

/**
	编写一个程序，通过已填充的空格来解决数独问题。
	
	一个数独的解法需遵循如下规则：
	
	数字 1-9 在每一行只能出现一次。
	数字 1-9 在每一列只能出现一次。
	数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/sudoku-solver
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author zs
 * @date 2020年1月7日
 */
public class SudokuSolver {

	public boolean isValidSudoku(char[][] board) {
		return validSudokuHelper(board, 0, 0);
	}

	private boolean validSudokuHelper(char[][] board, int row, int col) {

		while (row < 9 && col < 9) {
			if (board[row][col] == '.') {
				break;
			}

			if (col == 8) {
				col = 0;
				row++;
			} else {
				col++;
			}
		}
		if(row >= 9) {
			return true;
		}
			
		int nextRow = (col / 8) + row;
		int nextCol = (col + 1) % 9;

		for (int i = 1; i <= 9; i++) {
			if (isValid(board, row, col, (char) (i + '0'))) {
				board[row][col] = (char) (i + '0');
				boolean result = validSudokuHelper(board, nextRow, nextCol);
				if (result) {
					return true;
				}
				board[row][col] = '.';
			}
		}

		return false;
	}

	private boolean isValid(char[][] board, int row, int col, char num) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == num || board[i][col] == num) {
				return false;
			}
		}

		int rowoff = (row / 3) * 3;
		int coloff = (col / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[rowoff + i][coloff + j] == num) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { 
				new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
//				[["5","3","4","6","7","8","9","1","2"],
//				 ["6","7","2","1","9","5","3","4","8"],
//				 ["1","9","8","3","4","2","5","6","7"],
//				 ["8","5","9","7","6","1","4","2","3"],
//				 ["4","2","6","8","5","3","7","9","1"],
//				 ["7","1","3","9","2","4","8","5","6"],
//				 ["9","6","1","5","3","7","2","8","4"],
//				 ["2","8","7","4","1","9","6","3","5"],
//				 ["3","4","5","2","8","6","1","7","9"]]
		
//		char[][] board = new char[][] {
//			new char[]{'.','8','7','6','5','4','3','2','1'},
//			new char[]{'2','.','.','.','.','.','.','.','.'},
//			new char[]{'3','.','.','.','.','.','.','.','.'},
//			new char[]{'4','.','.','.','.','.','.','.','.'},
//			new char[]{'5','.','.','.','.','.','.','.','.'},
//			new char[]{'6','.','.','.','.','.','.','.','.'},
//			new char[]{'7','.','.','.','.','.','.','.','.'},
//			new char[]{'8','.','.','.','.','.','.','.','.'},
//			new char[]{'9','.','.','.','.','.','.','.','.'}
//		};
		
				
		boolean result = new SudokuSolver().isValidSudoku(board);
		System.out.println(result);
		
		for (char[] cs : board) {
			for (char c : cs) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
		
	}

}
