package com.bank.xy;

public class NIOSummary {

	/*
	 * java NIO 核心组成部分
	 * 
	 * 1 Channels
	 * 2 Buffers
	 * 3 Selectors
	 * 
	 * Channel和Buffer
	 * 基本上，所有的IO在NIO中都从一个Channel开始，Channel有点像流。数据可以从Channel读到Buffer中，也可以从Buffer写到
	 * Channel中.
	 * 
	 * java NIO中的一些主要Channel的实现
	 * FileChannel
	 * DatagramChannel
	 * SocketChannel
	 * ServerSocketChannel
	 * 
	 * java NIO中关键的Buffer实现
	 * ByteBuffer
	 * CharBuffer
	 * DoubleBuffer
	 * FloatBuffer
	 * IntBuffer
	 * LongBuffer
	 * ShortBuffer
	 * java NIO中还有一个MappedBuffer,用于表示内存映射文件
	 * 
	 * Selector允许单线程处理多个Channel，如果你的应用打开了多个连接(通道),但每个连接的流量都很低，使用Selector就会很方便
	 * 要使用Selector，得向Selector注册channel，然后调用它的select()方法，这个方法会一直堵塞到某个注册的通道有事件就绪。
	 * 一旦这个方法返回，线程就可以处理这些事情。
	 */
}
