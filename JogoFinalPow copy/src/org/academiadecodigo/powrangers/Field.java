package org.academiadecodigo.powrangers;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class Field {
    private static int fieldWidth;
    private static int fieldHeight;
    private static int lines = 8;


    private Picture field;

    private static ArrayList<Monster> monsters;


    public Field() {
        field = new Picture(10, 10, File.Game.prefix + "Resources/Field.png");
        field.draw();
        fieldWidth = field.getMaxX();
        fieldHeight = field.getMaxY();
        monsters = new ArrayList<>();
    }

    public static int getFieldWidth() {
        return fieldWidth;
    }

    public static int getFieldHeight() {
        return fieldHeight;
    }

    public Picture getBackground() {
        return this.field;
    }

    public static int getLineWidth() {
        return getFieldWidth() / lines;
    }

    public static int getLines() {
        return lines;
    }

    public static void addMonster(Monster m){
        monsters.add(m);
    }

    public static ArrayList<Monster> getMonsters() {
        return monsters;
    }


    public static Monster posMonter(int pos){
        return monsters.get(pos);
    }

    public static int sizeMonster(){
        return monsters.size();
    }












}
