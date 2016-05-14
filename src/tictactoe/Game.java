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
        TicTacToe ticTacToe = null;

//        ticTacToe.showPlayerMessage();
        Scanner sc = null;

        int cntCellX = 0;
        int cntCellY = 0;

        boolean isInitTable = false;

        while (true) {
            if (!isInitTable) {
                // создаем доску
                try {

                    sc = new Scanner(System.in);

                    if (cntCellX == 0) {
                        System.out.print("Введите количество клеток (целое число) по X (минимальный размер 3): ");
                        cntCellX = sc.nextInt();
                    }

                    if (cntCellY == 0) {
                        System.out.print("Введите количество клеток (целое число) по Y (минимальный размер 3): ");
                        cntCellY = sc.nextInt();
                    }

                    ticTacToe = new TicTacToe(cntCellX, cntCellY);
                    ticTacToe.showTable();

                    isInitTable = true;
                    //ticTacToe.showPlayerMessage(); 
                } catch (InputMismatchException e) {
                    System.out.println("Введены не верные символы");
                }
            } else {
                // в бесконечном цикле получаем ходы игроков
                String str = sc.nextLine();
                if (!str.equals("")) {
                    String[] position = str.split(",");

                    if (position.length == 2) {

                        try {
                            int moveX = Integer.parseInt(position[0]);
                            int moveY = Integer.parseInt(position[1]);

                            ticTacToe.setMovePosition(moveX, moveY);

                            int statusCell = ticTacToe.checkCell(moveX, moveY);

                            // если ход возможен и ячейка не занятеа
                            if (statusCell > 0) {

                                boolean isGameOver = ticTacToe.checkGameOver();
                                String message = "Игра окончена!\n" + "Победа игрока №" + ticTacToe.currentPlayer;

                                ticTacToe.makeMove();
                                ticTacToe.showTable();

                                if (isGameOver) {
                                    System.out.println(message);
                                    break;
                                }

                            } else if (statusCell == -1) {
                                System.out.println("Выход за границы доски");
                            } else {
                                System.out.println("Указанная ячейка занята");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Координаты: должны быть целые числа!");
                        }
                    } else {
                        System.out.println("Координаты должны быть в виде 'N,N'!");
                    }
                }
                ticTacToe.showPlayerMessage();
            }

        } // end while  
    }

}
