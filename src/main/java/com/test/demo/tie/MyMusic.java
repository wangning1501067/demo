package com.test.demo.tie;
import sun.audio.AudioPlayer;

import java.io.IOException;

/**
 * 百度glodwave即可，度出第一条就是官方下载。  软件很小很好用，把你的MP3文件拖进去再另存为wav的格式就行了
 */
public class MyMusic {
    sun.audio.AudioStream   as;
    public void music()  throws IOException
    {
        try
        {
            java.io.InputStream in = new java.io.FileInputStream("E:\\test\\222.wav");
            as = new sun.audio.AudioStream(in);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Start()
    {
        AudioPlayer.player.start(as);
    }
    public void Pause()
    {
        AudioPlayer.player.stop(as);
    }
    public void Continue()
    {
        AudioPlayer.player.start(as);
    }

    public static void main(String []args)
    {
        MyMusic m = new MyMusic();
        try
        {
            m.music();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        m.Start();
    }
}