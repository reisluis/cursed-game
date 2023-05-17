package org.academiadecodigo.powrangers;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Level extends Thread {

    private int dificulty;
    private Picture gameOver = new Picture(10, 10, File.Game.prefix + "Resources/Screen-Game-Over.png");
    File.Game game;
    Sound backgroundSound;
    Sound gameoverSound;
    Text text1;
    public int letter= 0;
    private int init= 0;

    public Level(int dificulty){
        this.dificulty = dificulty;
    }

    public boolean stategame=true;

    public int deaths = 0;

    @Override
    public void run() {

        try {

            while(stategame){

                if(Monster.murder == (3 + deaths)){
                    dificulty += 30;
                    deaths = Monster.murder;
                }

                if (init==0) {
                    text1 = new Text(650, 550, "Enemy Down: " + Monster.murder);
                    text1.setColor(Color.WHITE);
                    text1.grow(40, 7);
                    text1.draw();
                    init=1;
                }

                if (Monster.murder>letter){
                    text1.setText("Enemy Down: "+Monster.murder);
                    letter=Monster.murder;
                }

                if (Field.sizeMonster()<3) {
                    Monster m1 = new MonsterFactory().getNewMonster();
                    Field.addMonster(m1);
                }
                for (int i = 0; i < Field.sizeMonster(); i++) {

                    if(Field.posMonter(i).monsterPicture.getY()>=490){
                        gameoverSound = new Sound(5);
                        gameoverSound.setFile(5);
                        gameoverSound.play();

                        gameOver.draw();

                        backgroundSound = new Sound(2);
                        backgroundSound.setFile(2);
                        backgroundSound.play();
                        backgroundSound.loop();


                        stategame=false;

                    }
                    Field.posMonter(i).monsterPicture.translate(0,20);
                }

                int nbr =  ((int) (400 - this.dificulty ));
                Thread.sleep(nbr);
                System.out.println(nbr);



            }

        } catch (Exception e) {

        }

    }

}
