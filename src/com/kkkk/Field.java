package com.kkkk;

public class Field {
    private int height = 10;
    private int width = 10;
    private Cell[][] cells;

    public Field(int height, int width) {
        this.height = height;
        this.width = width;
        cells = new Cell[height][width];
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setCells(int x, int y) {
        cells[x][y] = new Cell();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getAliveNeighbours(int x, int y) {
        int ret = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int r = x + i;
                int c = y + j;
                if (r > -1 && c > -1 && r < height && c < width && !(r == x && c == y)) {
                    Cell cell = cells[r][c];
                    if (cell.isAlive()) { ret++; }
                }
            }
        }
        return ret;
    }
}
