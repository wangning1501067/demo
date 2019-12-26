package com.test.demo.tie;


import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class SendWavUtil {
    public static void main(String[] args) throws MalformedURLException, FileNotFoundException, InterruptedException {
        //选择播放文件
        File file = new File("E:\\test\\222.wav");
        //创建audioclip对象
        AudioClip audioClip = null;
        //将file转换为url
        audioClip = Applet.newAudioClip(file.toURL());
        //循环播放	播放一次可以使用audioClip.play
        audioClip.loop();
        Thread.sleep(5000);
    }


    //需求：通过代码播放音乐
//1.读取文件
//2.将音乐文件放到播放代码中
//3.播放
    /*public static void main(String[] args)
    {
        *//*try{
            Scanner input = new Scanner(System.in);
            File sound1=new File("E:\\test\\aee40b8ce006f598c2177d46034bffb7.wav");//java只支持wav格式
            AudioClip sound_choose=Applet.newAudioClip(sound1.toURL());
            sound_choose.play();//播放
            System.out.println("请输入任意键结束");
            input.nextLine();
        }catch (Exception e){
            e.printStackTrace();
        }*//*


        AudioInputStream as;
        try {
            final File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
            System.out.println(basePath);
            as = AudioSystem.getAudioInputStream(new File(basePath+"/img/aee40b8ce006f598c2177d46034bffb7.wav"));//音频文件在项目根目录的img文件夹下
            AudioFormat format = as.getFormat();
            SourceDataLine sdl = null;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            sdl = (SourceDataLine) AudioSystem.getLine(info);
            sdl.open(format);
            sdl.start();
            int nBytesRead = 0;
            byte[] abData = new byte[512];
            while (nBytesRead != -1) {
                nBytesRead = as.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                    sdl.write(abData, 0, nBytesRead);
            }
            //关闭SourceDataLine
            sdl.drain();
            sdl.close();
        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/


    /*public static void main(String[] args) throws Exception
    {
        //URL soundFile =new URL("http://5.133998.com/2014/ring/000/105/6e5c03b68ac97a7905047057b3744076.mp3");
        File soundFile =new File("E:\\test\\222.wav");
        AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
        AudioPlayer.player.start(ais);
    }*/
}
