package org.academiadecodigo.powrangers;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Monster {
    public Picture monsterPicture;
    public int hp;
    private int speed = 10;
    public int posX;
    public int posY;
    public static int murder = 0;


    public Monster(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;

    }

    public int getPosY(){
        return posY;
    }

    public int getPosX(){
        return posX;
    }

    public void killed(int damage){
        this.hp -= damage;
        System.out.println(this.hp);
        if(this.hp <= 0){
            this.monsterPicture.delete();
            Field.getMonsters().remove(this);
            murder++;
        }
    }

    public int getHp() {
        return hp;
    }

}


