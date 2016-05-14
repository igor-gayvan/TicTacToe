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

    private int cntCellX = 3; //размер поля по горизонтали
    private int cntCellY = 3; //размер поля по вертикали	

    private final int COUNT_STEP_FOR_WIN = 3; // длина хода

    private char[][] table;

    public int currentPlayer = 0; // текущий игрок

    private int moveX = 0;  // ход игрока x
    private int moveY = 0;  // ход игрока y

    public TicTacToe(int cntCellX, int cntCellY) {

        if (cntCellX > 3) {
            this.cntCellX = cntCellX;
        }
        if (cntCellY > 3) {
            this.cntCellY = cntCellY;
        }

        table = new char[this.cntCellX][this.cntCellY];
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

    /**
     * @return определяем чем играет игрок
     */
    private char getPlayerSymbol() {
        if (currentPlayer == 1) {
            return '0';
        } else if (currentPlayer == 2) {
            return 'X';
        }

        return ' ';
    }

    /**
     * Задаем координаты хода
     *
     * @param x
     * @param y
     */
    public void setMovePosition(int x, int y) {
        moveX = x;
        moveY = y;
    }

    /**
     * Выводим кто ходит
     */
    public void showPlayerMessage() {
        System.out.println("");
        System.out.print("Игрок №" + currentPlayer + " (" + getPlayerSymbol() + ")\n" + "Введите координаты хода в формате 'N,N': ");
    }

    /**
     * Делаем ход
     */
    public void makeMove() {

        if (currentPlayer == 1) {
            table[moveY][moveX] = getPlayerSymbol();
            currentPlayer = 2;
        } else if (currentPlayer == 2) {
            table[moveY][moveX] = getPlayerSymbol();
            currentPlayer = 1;
        }
    }

    /**
     * проверяем возможность хода
     *
     * @return int 0 - занято, -1 - выход за диапазон, 1 - пусто
     */
    public int checkCell(int x, int y) {

        int statusCell = 0;

        if ((x >= 0 && y >= 0) && (x < this.cntCellX && y < this.cntCellX)) {

            if (table[y][x] == 0) {
                statusCell = 1;
            }

        } else {
            statusCell = -1; // выход за диапазон
        }

        return statusCell;
    }

    /*	
	 * Проверка рекурсией количества одинаковых символов по направлениям
     */
    private boolean calcSteps(int x, int y, String way, int count) {
        switch (way) {
            case "up":
                if (checkCell(x, y - 1) >= 0) {
                    //если следующий такой же символ
                    if (table[y - 1][x] == getPlayerSymbol()) {
                        if (count + 1 == COUNT_STEP_FOR_WIN - 1) { //достигнуто максимальное количество
                            return true;
                        } else {
                            return calcSteps(x, y - 1, way, count + 1);
                        }
                    }
                }
                break;
            case "up-left":
                if (checkCell(x - 1, y - 1) >= 0) {
                    //если следующий такой же символ
                    if (table[y - 1][x - 1] == getPlayerSymbol()) {
                        if (count + 1 == COUNT_STEP_FOR_WIN - 1) { //достигнуто максимальное количество
                            return true;
                        } else {
                            return calcSteps(x - 1, y - 1, way, count + 1);
                        }
                    }
                }
                break;

            case "up-right":
                if (checkCell(x + 1, y - 1) >= 0) {
                    //если следующий такой же символ
                    if (table[y - 1][x + 1] == getPlayerSymbol()) {
                        if (count + 1 == COUNT_STEP_FOR_WIN - 1) { //достигнуто максимальное количество
                            return true;
                        } else {
                            return calcSteps(x + 1, y - 1, way, count + 1);
                        }
                    }
                }
                break;

            case "down":
                if (checkCell(x, y + 1) >= 0) {
                    //если следующий такой же символ
                    if (table[y + 1][x] == getPlayerSymbol()) {
                        if (count + 1 == COUNT_STEP_FOR_WIN - 1) { //достигнуто максимальное количество
                            return true;
                        } else {
                            return calcSteps(x, y + 1, way, count + 1);
                        }
                    }
                }
                break;

            case "down-left":
                if (checkCell(x - 1, y + 1) >= 0) {
                    //если следующий такой же символ
                    if (table[y + 1][x - 1] == getPlayerSymbol()) {
                        if (count + 1 == COUNT_STEP_FOR_WIN - 1) { //достигнуто максимальное количество
                            return true;
                        } else {
                            return calcSteps(x - 1, y + 1, way, count + 1);
                        }
                    }
                }
                break;

            case "down-right":
                if (checkCell(x + 1, y + 1) >= 0) {
                    //если следующий такой же символ
                    if (table[y + 1][x + 1] == getPlayerSymbol()) {
                        if (count + 1 == COUNT_STEP_FOR_WIN - 1) { //достигнуто максимальное количество
                            return true;
                        } else {
                            return calcSteps(x + 1, y + 1, way, count + 1);
                        }
                    }
                }
                break;

            case "left":
                if (checkCell(x - 1, y) >= 0) {
                    //если следующий такой же символ
                    if (table[y][x - 1] == getPlayerSymbol()) {
                        if (count + 1 == COUNT_STEP_FOR_WIN - 1) { //достигнуто максимальное количество
                            return true;
                        } else {
                            return calcSteps(x - 1, y, way, count + 1);
                        }
                    }
                }
                break;

            case "right":
                if (checkCell(x + 1, y) >= 0) {
                    //если следующий такой же символ
                    if (table[y][x + 1] == getPlayerSymbol()) {
                        if (count + 1 == COUNT_STEP_FOR_WIN - 1) { //достигнуто максимальное количество
                            return true;
                        } else {
                            return calcSteps(x + 1, y, way, count + 1);
                        }
                    }
                }
                break;
        }
        return false;
    }

    /**
     * Проверка на конец игры
     */
    public boolean checkGameOver() {

        String[] arrWay = new String[]{"up", "down", "left", "right", "up-left", "up-right", "down-left", "down-right"};

        for (int i = 0; i < arrWay.length; i++) {
            if (calcSteps(moveX, moveY, arrWay[i], 0)) {
                return true;
            }
        }

        return false;
    }
}
