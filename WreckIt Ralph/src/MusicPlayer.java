import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer{
	
	private ArrayList<String> musicFiles;
	private int musicTimer, musicCurrentIndex = 0;
	File audioFile;
	AudioInputStream ais;
	AudioFormat formate;
	Clip clip;
	FloatControl gainControl;
	
	public MusicPlayer(String... files) {
		musicFiles = new ArrayList<String>();
		for(String file : files)
			musicFiles.add(file);
	}

	public void music(String audioFileName) {
		try {
			if(musicTimer == 1) {
			audioFile = new File(audioFileName);
			ais = AudioSystem.getAudioInputStream(audioFile);
			formate = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, formate);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(ais);
			gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-10);
			if(audioFileName == "death.wav")
				gainControl.setValue(0);
			clip.start();			
			}
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public void run(int musicTimer) {
		this.musicTimer = musicTimer;
		music(musicFiles.get(musicCurrentIndex));
	}

}
