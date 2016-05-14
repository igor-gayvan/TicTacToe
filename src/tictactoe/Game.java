/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Igor Gayvan
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TicTacToe ticTacToe;

//        ticTacToe.showPlayerMessage();
        Scanner sc = null;

        int x = 0;
        int y = 0;

        
        boolean isInitTable = false;

        while (true) {
            if (!isInitTable) {
                // создаем доску
                try {

                    sc = new Scanner(System.in);

                    if (x == 0) {
                        System.out.print("Введите количество клеток (целое число) по X (минимальный размер 3): ");
                        x = sc.nextInt();
                    }

                    if (y == 0) {
                        System.out.print("Введите количество клеток (целое число) по Y (минимальный размер 3): ");
                        y = sc.nextInt();
                    }

                    ticTacToe = new TicTacToe(x, y);
                    ticTacToe.showTable();
                    
                    isInitTable = true;
                    //obj.getUserMessage(); 
                } catch (InputMismatchException e) {
                    System.out.println("Введены не верные символы");
                }
            } else {
                // в бесконечном цикле получаем ходы игроков
                
            }

        } // end while  
    }

}
