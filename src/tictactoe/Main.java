/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Igor Gayvan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TicTacToe ticTacToe = new TicTacToe(3, 3);

        ticTacToe.showTable();
        
        ticTacToe.showPlayerMessage();
    }

}
