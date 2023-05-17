package org.academiadecodigo.powrangers;


import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.KEY_ENTER;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.KEY_R;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_PRESSED;

public class File {


    public static class Game implements KeyboardHandler {
        public static final String prefix = "";

        Sound backgroundSound;
        Sound gameOverSound;

        Sound gameStartSound;

        Field field = new Field();
        Player player = new Player(prefix + "Resources/Player1.png");
        MonsterFactory monster = new MonsterFactory();

        private Picture gameOver = new Picture(10, 10, prefix + "Resources/Screen-Game-Over.png");
        private Picture gameStart = new Picture(10, 10, prefix + "Resources/Screen-Game-Start-C.png");

        private Keyboard keyboard = new Keyboard(this);
        private boolean restart;
        private boolean enterNotPressed = true;

        public Game() {

        }


        public void init() {

            gameStartSound = new Sound(2);
            gameStartSound.setFile(2);
            gameStartSound.play();



            KeyboardEvent enter = new KeyboardEvent();
            enter.setKey(KEY_ENTER);
            enter.setKeyboardEventType(KEY_PRESSED);
            keyboard.addEventListener(enter);



            KeyboardEvent restart = new KeyboardEvent();
            restart.setKey(KEY_R);
            restart.setKeyboardEventType(KEY_PRESSED);
            keyboard.addEventListener(restart);

        }


        public void start() {

            startMenu();

            //monster.getNewMonster();
            player.init();
            backgroundSound = new Sound(4);
            backgroundSound.setFile(4);
            backgroundSound.play();
            backgroundSound.loop();

        }

        private void startMenu() {


            while (enterNotPressed) {
                gameStart.draw();
            }
            gameStart.delete();
            gameStartSound.stop();

        }


        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            switch (keyboardEvent.getKey()) {
                case KEY_ENTER:
                    enterNotPressed = false;
                    break;
                case KEY_R:
                    setNotRestart(false);
                    //player.setDontShoot(false);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }

        public void setNotRestart(boolean notRestart) {
            this.restart = notRestart;
        }


        public void gameOver() {
            System.out.println("antes stop");
            /*backgroundSound.clip.stop();

            gameOverSound = new Sound(3);
            gameOverSound.setFile(3);
            gameOverSound.play();
            System.out.println("ahhhhhh");
    */
            field.getBackground().delete();
            player.getPicture().delete();
            System.out.println("uiiiiii");
            gameOver.draw();
        }

            // TEM QUE TESTAR!
            /*
            while(restart) {
                field.getBackground().draw();
                System.out.println("Press R to restart");
                return false;

            }
            setNotRestart(true);
            return true;
        }
    */

    }
}

