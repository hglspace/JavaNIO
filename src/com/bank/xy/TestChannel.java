package com.bank.xy;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestChannel {

	/*
	 * java NIO的通道和流有点类似，但又有些不同
	 * 1 既可以从通道中读取数据，又可以写数据到通道，但流的读写通常是单向的
	 * 2 通道可以异步的读写
	 * 3 通道中的数据总是要先读到一个Buffer，或者总是从一个Buffer中写入
	 * 
	 */
	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("/Users/zyq/Applications/error.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buffer);
        while(bytesRead!=-1){
        	System.out.println("Read " + bytesRead);
        	buffer.flip();
        	while(buffer.hasRemaining()){
        		System.out.print((char) buffer.get());
        	}
        	buffer.clear();
            bytesRead=inChannel.read(buffer);
            System.out.println("");
        }
        aFile.close();
	}
}
