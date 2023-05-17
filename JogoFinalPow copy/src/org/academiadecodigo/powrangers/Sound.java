package org.academiadecodigo.powrangers;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



import java.io.File;


public class Sound {



    Clip clip;

    private final File[] soundFile = new File[6];
    public Sound(int chosenSound) {
        System.out.println("creating Souund object");
       init();

    }
    public void init(){

        soundFile[0] = new File( org.academiadecodigo.powrangers.File.Game.prefix + "Resources/Recharge.wav"); // recarregar arma
        soundFile[1] = new File(org.academiadecodigo.powrangers.File.Game.prefix + "Resources/9mm.wav"); // som disparo
        soundFile[2] = new File(org.academiadecodigo.powrangers.File.Game.prefix + "Resources/Entrance.wav"); // musica de entrada
        soundFile[3] = new File(org.academiadecodigo.powrangers.File.Game.prefix + "Resources/Empty-Bullet.wav"); // som quando o player ganha
        soundFile[4] = new File(org.academiadecodigo.powrangers.File.Game.prefix + "Resources/Heartbeat.wav"); // som de coração, usar o loop();
        soundFile[5] = new File(org.academiadecodigo.powrangers.File.Game.prefix + "Resources/gameover.wav"); // som do game over

        System.out.println("creating all files");
    }
    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile[i]);
            clip = AudioSystem.getClip();
            System.out.println("clip is " + clip);
            clip.open(ais);
        } catch (Exception e) {
            System.out.println("UPS, DEU CÓCÓ");
            e.printStackTrace();
        }
    }
    public void play() {

        clip.start();
        //loop();

    }
   public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}

