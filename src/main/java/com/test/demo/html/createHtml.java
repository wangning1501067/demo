package com.test.demo.html;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class createHtml {
    public static void main(String[] args) throws IOException {
        createHtml("http://192.168.1.200:8080/navigation/shoppingUI.action?id=26",                "d:\\abc.html");
    }
    public static void createHtml(String url, String fileName)            throws IOException {
        URL urlC = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlC                .openConnection();
        InputStream ips = connection.getInputStream();
        FileOutputStream fos = new FileOutputStream(fileName);
        challage(ips, fos);
        ips.close();
        fos.close();
    }
    private static void challage(InputStream ips, OutputStream ops)            throws IOException {
        byte[] contents = new byte[1024];
        int len = 0;
        while ((len = ips.read(contents)) != -1) {
            ops.write(contents, 0, len);
        }
    }
}
