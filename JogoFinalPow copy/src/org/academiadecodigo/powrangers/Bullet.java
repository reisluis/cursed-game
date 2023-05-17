package org.academiadecodigo.powrangers;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet{

    private int x;
    private int y;
    private int speed;
    public boolean isVisible;
    private Picture bulletPicture;
    private Player player;

    private int damage =10;

    public Bullet(Player player, int x, int y) {
        this.player = player;
        this.x = x;
        this.y = y;
        speed = 15;
        isVisible = true;

        bulletPicture = new Picture(x, y, File.Game.prefix  + "Resources/oulibala2.png");
        bulletPicture.draw();
    }




    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Picture getBulletPicture() {
        return bulletPicture;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void deleteBullet() {
        bulletPicture.delete();
    }

    public int getDamage() {
        return damage;
    }
}
