package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean result = false;
        for (int cell = 0; cell < board.length; cell++) {
            if (board[cell][cell] == 1 && (horizontal(board, cell) || vertical(board, cell))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean vertical(int[][] board, int column) {
        boolean result = true;
        for (int[] cell : board) {
            if (cell[column] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean horizontal(int[][] board, int line) {
        boolean result = true;
        for (int cell = 0; cell < board.length; cell++) {
            if (board[line][cell] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
