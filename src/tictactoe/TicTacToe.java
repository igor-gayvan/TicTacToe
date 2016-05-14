/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Arrays;

/**
 *
 * @author Igor Gayvan
 */
public class TicTacToe {

    private int x = 3; //размер поля по горизонтали
    private int y = 3; //размер поля по вертикали	

    private char[][] table;

    private int currentPlayer = 0; // текущий игрок

    public TicTacToe(int x, int y) {

        if (x > 3) {
            this.x = x;
        }
        if (y > 3) {
            this.y = y;
        }

        table = new char[this.y][this.x];
        currentPlayer = 1;
    }

    public void showTable() {
        System.out.print("  ");
        for (int i = 0; i < table[0].length; i++) {
            System.out.print("" + i);
        }
        System.out.println("");

        for (int i = 0; i < table.length; i++) {
            System.out.print(i + "|");

            for (int j = 0; j < table[i].length; j++) {

                if (table[i][j] != 0) {
                    System.out.print("" + table[i][j]);
                } else {
                    System.out.print("_");
                }

            }
            System.out.println("");
        }
    }

}
