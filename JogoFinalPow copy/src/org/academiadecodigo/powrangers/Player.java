package org.academiadecodigo.powrangers;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class Player implements KeyboardHandler {

    Sound BulletFired;

    Sound recharge;
    Field field;
    private Picture picture; // = new Picture(Field.getFieldHeight(), 700, "Resources/Player1.png");
    //private Direction direction;
    private int speed = 15;
    private Keyboard keyboard = new Keyboard(this);
    private ArrayList<Bullet> bullets = new ArrayList<>();
    Level level;
    File.Game game;

    private int widthBullet;

    public int numBullets = 0;


    public Player(String nameFile) {

        /* definir variaveis para tamanho de imagem senão tem de instanciar a imagem para ir buscar o width/height */
        Picture aux = new Picture(0, 0, File.Game.prefix + "Resources/Player1.png");
        aux.draw();
        aux.delete();



        picture = new Picture((Field.getFieldWidth() / 2 - aux.getWidth() / 2), Field.getFieldHeight() - aux.getHeight() - 10, nameFile);
        picture.draw();
    }
    public void init() {

        Picture aux = new Picture(0, 0, File.Game.prefix + "Resources/oulibala2.png");
        aux.draw();
        widthBullet = aux.getWidth();
        aux.delete();


        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent recharge = new KeyboardEvent();
        recharge.setKey(KeyboardEvent.KEY_R);
        recharge.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent Restart = new KeyboardEvent();
        Restart.setKey(KeyboardEvent.KEY_P);
        Restart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(space);
        keyboard.addEventListener(recharge);
        keyboard.addEventListener(Restart);


    }
    public void moveRight() {
        if (picture.getMaxX() <= (field.getFieldWidth() - field.getLineWidth())) {
            picture.translate(field.getLineWidth(), 0);
        }
    }
    public void moveLeft() {
        if (picture.getX() >= (0 + field.getLineWidth())) {
            picture.translate(-field.getLineWidth(), 0);
        }
    }
    public void moveSpace() {
        shootBullet();
        BulletFired = new Sound(1);
        BulletFired.setFile(1);
        BulletFired.play();
    }




    private void shootBullet(){
        Bullet b = new Bullet(this, picture.getX()+(widthBullet+5), Field.getFieldHeight() - picture.getHeight() - (50 * (bullets.size() + 1)));
        new BulletThread(b).start();
    }


    ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        //if (pressedKeys.contains(keyboardEvent.getKey())) {

        //}else{
        pressedKeys.add(keyboardEvent.getKey());
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_D:
                moveRight();
                break;
            case KeyboardEvent.KEY_A:
                moveLeft();
                break;
            case KeyboardEvent.KEY_S:
                //moveDown();
                break;
            case KeyboardEvent.KEY_W:
                //moveUp();
                break;
            case KeyboardEvent.KEY_SPACE:
                if (numBullets < 5){
                    moveSpace();
                    numBullets++;
        }
                break;
            case KeyboardEvent.KEY_R:
                numBullets = 0;
                recharge = new Sound(0);
                recharge.setFile(0);
                recharge.play();


                break;

        }

        //}
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        System.out.println("key released");
        pressedKeys.remove(keyboardEvent.getKey());
    }




    public Picture getPicture(){ return picture;}


}









