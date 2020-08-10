package org.medianik.bothelp.Config;


import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;


public class ConfigHandler {


    private static Path findFilePath(String fileName){
        return new File(fileName).toPath();
    }

    public static String readFile(String fileName){
        String out = "";

        try(SeekableByteChannel channel = Files.newByteChannel(findFilePath(fileName))){
            out = readFromSeekableByteChannel(channel);
        }catch (IOException e){
            e.printStackTrace();
        }
        return out;
    }

    private static String readFromSeekableByteChannel(SeekableByteChannel channel) throws IOException{
        ByteBuffer bf = ByteBuffer.allocate((int)channel.size());
        channel.read(bf);
        return new String(bf.array());
    }
}
