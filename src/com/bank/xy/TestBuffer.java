package com.bank.xy;

public class TestBuffer {

	/*
	 * Buffer的基本用法
	 * 缓冲区本质上是一块可以写入数据，然后可以从缓冲区中读取数据的内存，这快内存被包装成NIO Buffer对象，并提供了一组方法，
	 * 用来方便的访问该内存块。
	 * Buffer的基本用法：
	 * 使用Buffer读写数据一般遵循一下四个步骤
	 * 1 写入数据到Buffer
	 * 2 调用flip()方法
	 * 3 从Buffer中读取数据
	 * 4 调用clear()方法或compact方法
	 * 当向Buffer中写入数据时，Buffer会记录写下了多少数据，一旦要读取数据，需要通过flip()方法将Buffer从写模式切换到读模式，
	 * 在读模式下，可以读取之前写入到buffer中的数据
	 * 一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。有两种方式可以清空：调用clear()或compact()方法。
	 * clear()方法会清空整个缓冲区，compact()方法只会清楚已经读过的数据，任何未被读的数据都将被移到缓冲区的起始处，新写入的数据
	 * 将放到缓冲区未读数据的后面。
	 * 
	 * buffer的三个属性：
	 * capacity
	 * position
	 * limit
	 * position和limit的含义取决于Buffer是读模式还是写模式，不管Buffer处于什么模式，capacity的含义是一致的.
	 * 
	 * capacity:
	 * 作为一块内存块，Buffer有一个固定的大小值，叫capacity，只能往里面写这么多数据，一旦满了，需要将其清空才能继续往里面写数据
	 * 
	 * position:
	 * 当你写数据到Buffer中时，position表示当前的位置，初始的position值为0，当一个数据写入到buffer时，position会向后移动
	 * 到下一个可插入数据的单元位置，position的最大值是capacity-1
	 * 当读取数据时，也是从某个特定的位置开始读，当将Buffer从写模式切换到读模式，position会被重置为0，当从Buffer的position
	 * 处读取数据时，position向前移动到下一个可读的位置。
	 * 
	 * limit:
	 * 在写模式下，Buffer的limit表示你最多能往Buffer里写多少数据。写模式下，limit等于Buffer的capacity。
	 * 当切换Buffer到读模式时， limit表示你最多能读到多少数据。因此，当切换Buffer到读模式时，
	 * limit会被设置成写模式下的position值。换句话说，你能读到之前写入的所有数据
	 * （limit被设置成已写数据的数量，这个值在写模式下就是position）
	 * 
	 * 向Buffer中写数据：
	 * 写数据有两种方式:
	 * 1 从channel到Buffer
	 * 2 通过Buffer的put方法写到Buffer
	 * (put方法有很多版本，允许你以不同的方式把数据写入到Buffer中，例如，写到一个指定的位置，或者把一个字节数组写入到Buffer中
	 * 
	 * flip()方法
	 * flip()方法将Buffer从写模式切换到读模式，调用flip()方法会将position设回0，并将limit设置成之前的position值。
	 * 
	 * 从Buffer中读取数据
	 * 读数据有两种方式：
	 * 1 从Buffer读数据到channel
	 * 如:int bytesWritten = inChannel.write(buf);
	 * 2 使用get()方法从Buffer中读取数据
	 * 如：byte aByte = buf.get();
	 * get方法有很多版本，允许你以不同的方式从Buffer中读取数据。例如，从指定position读取，或者从Buffer中读取数据到字节数组
	 * 
	 * rewind()方法：
	 * Buffer.rewind()将position设回0，所以你可以重读Buffer中的所有数据。limit保持不变，仍然表示能从Buffer中读取多少个元素
	 * 
	 * clear()与compact()方法
	 * 如果调用的是clear()方法，position将被设回0，limit被设置成 capacity的值。换句话说，Buffer 被清空了。
	 * Buffer中的数据并未清除，只是这些标记告诉我们可以从哪里开始往Buffer里写数据。
	 * 如果Buffer中有一些未读的数据，调用clear()方法，数据将“被遗忘”，意味着不再有任何标记会告诉你哪些数据被读过，哪些还没有。
	 * 如果Buffer中仍有未读的数据，且后续还需要这些数据，但是此时想要先先写些数据，那么使用compact()方法。
	 * compact()方法将所有未读的数据拷贝到Buffer起始处。然后将position设到最后一个未读元素正后面。
	 * limit属性依然像clear()方法一样，设置成capacity。现在Buffer准备好写数据了，但是不会覆盖未读的数据。
	 * 
	 * mark()与reset()方法
	 * 通过调用Buffer.mark()方法，可以标记Buffer中的一个特定position。
	 * 之后可以通过调用Buffer.reset()方法恢复到这个position。
	 * 
	 * equals()与compareTo()方法
	 * equals():
	 * 当满足下列条件时，表示两个Buffer相等：
	 * 有相同的类型（byte、char、int等）。
	 * Buffer中剩余的byte、char等的个数相等。
	 * Buffer中所有剩余的byte、char等都相同。
	 * 如你所见，equals只是比较Buffer的一部分，不是每一个在它里面的元素都比较。实际上，它只比较Buffer中的剩余元素
	 * 
	 * compareTo()方法
     * compareTo()方法比较两个Buffer的剩余元素(byte、char等)， 如果满足下列条件，则认为一个Buffer“小于”另一个Buffer：
     * 第一个不相等的元素小于另一个Buffer中对应的元素 。
     * 所有元素都相等，但第一个Buffer比另一个先耗尽(第一个Buffer的元素个数比另一个少)。
     * 
     * （译注：剩余元素是从 position到limit之间的元素）
	 *	
	 */
}