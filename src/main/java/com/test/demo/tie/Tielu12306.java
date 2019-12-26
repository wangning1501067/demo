package com.test.demo.tie;

import javax.mail.MessagingException;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class Tielu12306 {
    public static void main(String[] args) throws MessagingException {
        boolean flag = getMain();
        if (flag) {
            System.out.println("===========================");
            getMusic();
            SendQQMailUtil.sendMail();
        }


    }

    public static boolean getMain() {
        boolean flag = HttpUtils.getK819();
        if (!flag) {
            getMain();
        } else {
            return true;
        }
        return false;
    }

    public static void getMusic() {
        try {
            String fileName = "E:\\test\\222.wav";
            //选择播放文件
            File file = new File(fileName);
            //创建audioclip对象
            AudioClip audioClip = null;
            //将file转换为url
            audioClip = Applet.newAudioClip(file.toURL());
            //audioClip.loop();
            audioClip.play();
            //Thread.sleep(100000);
            System.out.println("执行完了");
        } catch (Exception e) {
            e.printStackTrace();
        }


        /*try {
            InputStream in = new FileInputStream("E:\\test\\aee40b8ce006f598c2177d46034bffb7.wav");//找到这个音乐文件
            AudioStream as = new AudioStream(in);
            AudioPlayer.player.start(as);// 开始播放
//AudioPlayer.player.stop(as);
            System.out.println("执行完了");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}

