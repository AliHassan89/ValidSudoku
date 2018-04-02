/**

 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


 A partially filled sudoku which is valid.

 |----|-----|----|----|----|----|---|---|---|
 |5   | 3   |    |    | 7  |    |   |   |   |
 |----|-----|----|----|----|----|---|---|---|
 |6   |     |    | 1  | 9  | 5  |   |   |   |
 |----|-----|----|----|----|----|---|---|---|
 |    | 9   |  8 |    |    |    |   | 6 |   |
 |----|-----|----|----|----|----|---|---|---|
 |8   |     |    |    | 6  |    |   |   | 3 |
 |----|-----|----|----|----|----|---|---|---|
 |4   |     |    | 8  |    |  3 |   |   |  1|
 |----|-----|----|----|----|----|---|---|---|
 | 7  |     |    |    |  2 |    |   |   |  6|
 |----|-----|----|----|----|----|---|---|---|
 |    | 6   |    |    |    |    |   | 2 | 8 |
 |----|-----|----|----|----|----|---|---|---|
 |    |     |    |  4 | 1  | 9  |   |   | 5 |
 |----|-----|----|----|----|----|---|---|---|
 |    |     |    |    |   8|    |   | 7 |  9|
 |----|-----|----|----|----|----|---|---|---|


 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to
 be validated.

 */

package main.java;

import java.util.Arrays;

public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    int row = board.length;
    int cols = board[0].length;
    if (row != 9 || cols != 9)
      return false;

    boolean[] rowCheck = new boolean[10];
    for (int i=0; i<9; i++){
      for (int j=0; j<9; j++){
        if (board[i][j] == '.')
          continue;
        int val = Character.getNumericValue(board[i][j]);
        if (val > 9 || val < 1 || rowCheck[val])
          return false;
        rowCheck[val] = true;
      }
      Arrays.fill(rowCheck, false);
    }

    Arrays.fill(rowCheck, false);
    for (int i=0; i<9; i++){
      for (int j=0; j<9; j++){
        if (board[j][i] == '.')
          continue;
        int val = Character.getNumericValue(board[j][i]);
        if (val > 9 || val < 1 || rowCheck[val])
          return false;
        rowCheck[val] = true;
      }
      Arrays.fill(rowCheck, false);
    }

    Arrays.fill(rowCheck, false);
    for(int i=0; i<9; i+=3){
      for (int j=0; j<9; j+=3){
        for (int k = j;k<j+3; k++){
          for(int m = i; m<i+3; m++){
            if (board[k][m] == '.')
              continue;
            int val = Character.getNumericValue(board[k][m]);
            if (rowCheck[val])
            {
              return false;
            }
            rowCheck[val] = true;
          }
        }
        Arrays.fill(rowCheck, false);
      }
    }

    return true;
  }
}
