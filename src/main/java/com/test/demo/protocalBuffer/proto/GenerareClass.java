package com.test.demo.protocalBuffer.proto;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerareClass {
    public static void main(String[] args) throws IOException {
        String protoPath = System.getProperty("user.dir") + "/src/main/java/com/test/demo/protocalBuffer/proto";
        List<String> protoFileList = new ArrayList<String>();
        File f = new File(protoPath);
        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isFile()) {
                String name = fs.getName();
                String extension=name.substring(name.lastIndexOf(".")+1,name.length());
                if("proto".equals(extension)){
                    protoFileList.add(name);
                }
            }
        }
        for (String protoFile : protoFileList) {
            System.out.println(protoFile);

            String strCmd = "E:/project/beyondsoft/demo/src/main/java/com/test/demo/protocalBuffer/proto/protoc --java_out=./ " + protoFile;
            Runtime.getRuntime().exec(strCmd, null, new File(protoPath));
        }
    }
}
