package org.pierre.screencapture;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Line;
import javax.sound.sampled.Mixer;
import java.util.Arrays;

public class DetectSystem {
    public static void main(String[] args) {
        listAllMixers();
        listAllLines();
        Mixer.Info headset = getMixer("Headset Earphone");
        System.out.println(headset);
    }

    public static void listAllMixers() {
        System.out.println("DETECTING MIXERS");
        Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();
        for (Mixer.Info mixerInfo : mixerInfos) {
            System.out.println(mixerInfo);
        }
    }

    public static Mixer.Info getMixer(String description) {
        Mixer.Info result;
        return Arrays.stream(AudioSystem.getMixerInfo()).filter(mixerInfo -> mixerInfo.getName().startsWith(description)).findFirst().orElse(null);
    }

    public static Mixer.Info getMixerFOrHeadset() {
        return getMixer("Headset Earphone");
    }


    public static void listAllLines() {
        for (Mixer.Info mixerInfo : AudioSystem.getMixerInfo()) {
            System.out.println("MIXER: " + mixerInfo);
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line[] sourceLines = mixer.getSourceLines();
            for (Line sourceLIne : sourceLines) {
                System.out.println(sourceLIne);
            }
        }
    }
}
