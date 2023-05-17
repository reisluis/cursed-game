package org.academiadecodigo.powrangers;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public  class MonsterFactory {

    public static Monster getNewMonster() {



        int monsterType = ((int) (Math.ceil(Math.random() * 4)));

        int randomX = (int) (Math.random() * Field.getLines());
        if (randomX == 0) {
            randomX = 1;
        } else if (randomX == Field.getLines()) {
            randomX = Field.getLineWidth() - 1;
        }
        randomX = Field.getLineWidth() * randomX;

        int counter = 0;
        int speed = counter <= 15 ? 15 : (10 * (counter / 10));
        Monster monster;

        boolean canCreate = true;
        int x;
        switch (monsterType) {
            case 2:
                monster = new MonsterMedium(randomX, speed);
                counter++;

                /* definir variaveis para tamanho de imagem senão tem de instanciar a imagem para ir buscar o width/height */
                Picture aux3 = new Picture(0, 0, File.Game.prefix  + "Resources/Enemy3.png");
                aux3.draw();
                aux3.delete();


                x = randomX - aux3.getWidth() / 2;
                for(Monster m : Field.getMonsters()){
                    if(x == m.monsterPicture.getX()){ canCreate = false; }
                }

                if(canCreate)
                {
                    monster.monsterPicture = new Picture(x, 10, File.Game.prefix  + "Resources/Enemy3.png");
                    monster.monsterPicture.draw();
                }

                break;
            case 3:
                monster = new MonsterHard(randomX, speed);
                counter++;

                /* definir variaveis para tamanho de imagem senão tem de instanciar a imagem para ir buscar o width/height */
                Picture aux1 = new Picture(0, 0, File.Game.prefix  + "Resources/Enemy.png");
                aux1.draw();
                aux1.delete();

                canCreate = true;
                x = randomX - aux1.getWidth() / 2;
                for(Monster m : Field.getMonsters()){
                    if(x == m.monsterPicture.getX()){ canCreate = false; }
                }

                if(canCreate) {
                    monster.monsterPicture = new Picture(x, 10, File.Game.prefix  + "Resources/Enemy.png");
                    monster.monsterPicture.draw();
                }


                break;
            case 1:
            default:
                monster = new MonsterEasy(randomX, speed);
                counter++;

                /* definir variaveis para tamanho de imagem senão tem de instanciar a imagem para ir buscar o width/height */
                Picture aux2 = new Picture(0, 0, File.Game.prefix  + "Resources/Enemy2.png");
                aux2.draw();
                aux2.delete();

                canCreate = true;
                x = randomX - aux2.getWidth() / 2;
                for(Monster m : Field.getMonsters()){
                    if(x == m.monsterPicture.getX()){ canCreate = false; }
                }

                monster.monsterPicture = new Picture(x, 10, File.Game.prefix  + "Resources/Enemy2.png");
                monster.monsterPicture.draw();
                break;
        }
        return monster;

    }


}
