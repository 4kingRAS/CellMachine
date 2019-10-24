package com.kkkk;

import javax.swing.*;

/**
 * @Date 2019.10.24
 * @Author 4king
 *
 * 1.  There are two state in every single cell: Dead or alive.Every cell interacts
 * with its eight neighbours, which are the cells that are horizontally, vertically,
 * or diagonally adjacent.At each step in time, the following transitions occur
 *
 * 2.  Any live cell with fewer than two live neighbours dies.
 *
 * 3.  Any live cell with 2 or 3 live neighbours, stay the same.
 *
 * 4.  Others, stay the same.
 **/

public class CellMachine {

    public static void main(String[] args) throws InterruptedException {
        Field field = new Field(100, 100);

        for (int i = 0; i < field.getHeight(); i++) {
            for (int j = 0; j < field.getWidth(); j++) {
                field.setCells(i, j);
            }
        }

        for (int i = 0; i < field.getHeight(); i++) {
            for (int j = 0; j < field.getWidth(); j++) {
                if (Math.random() < 0.05) {
                    Cell cell = field.getCell(i, j);
                    cell.reborn();
                }
            }
        }

        View view = new View(field);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("元胞自动机");
        frame.add(view);
        frame.pack();
        frame.setVisible(true);

        for (int i = 0; i < 5000; i++) {
            Thread.sleep(50);
            for (int row = 0; row < field.getHeight(); row++) {
                for (int col = 0; col < field.getWidth(); col++) {
                    Cell cell = field.getCell(row, col);
                    int num = field.getAliveNeighbours(row, col);
                    if (cell.isAlive()) {
                        if (num < 2 || num > 3) {
                            cell.die();
                            //System.out.println("die");
                        }
                    } else if (num == 3) {
                            cell.reborn();
                            //System.out.println("born");
                    }
                }
            }
            frame.repaint();
        }
    }
}
