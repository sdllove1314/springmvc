package com.sdl.utils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class Coverimage {

    public String outimage(Object imageblob,String path) throws IOException {

        byte [] imageByte = (byte[]) imageblob;
        BASE64Encoder encoder = new BASE64Encoder();
        String str = encoder.encode(imageByte).trim();
        BASE64Decoder decoder = new BASE64Decoder();

        String fileName = UUID.randomUUID().toString()+"img.jpeg";
        String finalPath = path+fileName;
        System.out.println(path);
        imageByte = decoder.decodeBuffer(str);
        OutputStream os = new FileOutputStream(finalPath);
        os.write(imageByte, 0, imageByte.length);
        os.flush();
        os.close();

        String exaPath = "upload/image/"+fileName;
        return exaPath;
    }
}
