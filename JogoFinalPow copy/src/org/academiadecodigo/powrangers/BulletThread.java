package org.academiadecodigo.powrangers;

public class BulletThread extends Thread
{
    private Bullet b;

    public BulletThread(Bullet b){
        this.b = b;
    }


    @Override
    public void run() {
        boolean isRunning = true;
        while (isRunning){
            try {

                //mover a bala a cada 0,03 segundos
                Thread.sleep(30);
                b.getBulletPicture().translate(0, -1 * b.getSpeed());


                //verificar colisão de monstros


                for(Monster m : Field.getMonsters()){
                    if((b.getBulletPicture().getY() -1 * b.getSpeed() - b.getBulletPicture().getHeight()) <= m.monsterPicture.getY()){
                        if(b.getBulletPicture().getX() >= m.monsterPicture.getX() && b.getBulletPicture().getX() <= m.getPosX()){
                            System.out.println("colidiu");
                            m.killed(b.getDamage());
                            isRunning = false; b.deleteBullet();
                        }
                    }
                }

                //bala desaparece e thread para quando bala chega ao cimo do field
                if(b.getBulletPicture().getY() - b.getBulletPicture().getHeight() <= 0) { isRunning = false; b.deleteBullet(); }

            } catch (Exception e) {
                b.deleteBullet();
            }
        }
    }


}
