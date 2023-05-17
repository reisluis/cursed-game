package org.academiadecodigo.powrangers;

public class Position {

    private int x;
    private int y;

    public Position() {
        this.x = (int) (Math.random() * Field.getFieldHeight());
        this.y = (int) (Math.random() * Field.getFieldHeight());
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}

