import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	public Sound() {
		// TODO Auto-generated constructor stub
	}

	public static Clip playSound(String name) {
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(name));
			clip.open(inputStream);
			clip.loop(0);
			return clip;
		} catch (Exception e) {
			e.printStackTrace();
			Clip clip = null;
			return clip;
		}

	}

	public static void stopClip(Clip clip) {
		clip.stop();
	}

	public static Clip playSoundLoop(String name) {
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(name));
			clip.open(inputStream);
			clip.loop(clip.LOOP_CONTINUOUSLY);
			return clip;
		} catch (Exception e) {
			e.printStackTrace();
			Clip clip = null;
			return clip;
		}
	}
}
