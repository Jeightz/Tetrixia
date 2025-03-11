/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function.GameAudio;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Admin
 */
public class GameBackGroundMusic {
    // Music playback

    private Clip musicClip;//a short sound file the can be played 
    private boolean isMusicPlaying = true;
    private float musicVolume = 0.5f;

    public void loadMusic() {
        try {
            
            String filePath = System.getProperty("user.dir") + "\\src\\song\\song.wav";
            File soundFile = new File(filePath);
            
            if (!soundFile.exists()) {
                System.err.println("ERROR: Sound file not found!");
                return;
            }
//the one who convert the audio data to audioinputstream for futher intputs
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            //describe the format of the audio
            AudioFormat format = audioInputStream.getFormat();
            //provide info of  the clip is to the system 
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            // check the audio if it supported
            if (!AudioSystem.isLineSupported(info)) {
                System.err.println("ERROR: Line not supported!");
                return;
            }
            //get the clip so it can play
            musicClip = (Clip) AudioSystem.getLine(info);
            //load the audio
            musicClip.open(audioInputStream);

            setMusicVolume(musicVolume);
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            System.err.println("ERROR: Unknown exception! " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void toggleMusic(boolean toggle) {
        if (musicClip != null) {
            if (!toggle) {
                musicClip.stop();
            } else {
                musicClip.start();
            }
            isMusicPlaying = !isMusicPlaying;
        }
    }

    public void setMusicVolume(float volume) {
        // Ensure volume is between 0.0 and 1.0
        this.musicVolume = Math.max(0.0f, Math.min(1.0f, volume));

        if (musicClip != null) {
            try {
                FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);// handle the volume format
                float gainValue;
                if (volume > 0) {
                    gainValue = 20f * (float) Math.log10(volume);
                } else {
                    gainValue = -80f; // Effectively silent
                }
                gainValue = Math.max(gainControl.getMinimum(), Math.min(gainControl.getMaximum(), gainValue));

                gainControl.setValue(gainValue);
            } catch (Exception e) {
                System.err.println("Failed to set volume: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
