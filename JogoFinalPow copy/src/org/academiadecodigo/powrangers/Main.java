package org.academiadecodigo.powrangers;


public class Main {
    public static void main(String[] args) {

        Sound background;

        //Field field = new Field();
        //Player player = new Player(File.Game.prefix  + "Resources/Player1.png");
        //MonsterFactory monster = new MonsterFactory();




        //player.init();

        File.Game game = new File.Game();
        game.init();
        game.start();
        new Level(4).start();
    }
}
