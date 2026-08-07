package BASE.SOM;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Som {

    private Clip clip;  

//==========================================================================
    public void tocar(String nomeAudio) {
        try {
            Clip c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(
                getClass().getResource("/BASE/SOM/" + nomeAudio)
            ));
            c.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO ao tocar: " + e.getMessage());
        }
    }

//==========================================================================
    public void tocarLoop(String caminhoResource) {
        try {
            parar();

            java.net.URL url = getClass().getResource(caminhoResource);
            if (url == null) {
                System.out.println("Música não encontrada: " + caminhoResource);
                return;
            }

            AudioInputStream audio = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            System.out.println("Erro ao tocar música: " + e.getMessage());
            e.printStackTrace();
        }
    }

//==========================================================================
    public void parar() {
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop();
            }
            clip.close();
            clip = null;
        }
    }

//==========================================================================
    public void pausar() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

//==========================================================================
    public void continuar() {
        if (clip != null && !clip.isRunning()) {
            clip.start();
        }
    }
//==========================================================================

}