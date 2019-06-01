import java.util.Arrays;
//Sequence List
//顺序表中保存的数据元素是int类型
public class Seqlist{
	//属性
	private int[] array; //用来保存数据
	private int size;//用来保存array中已经有的数据
	
	//构造方法
	public Seqlist(){
		//初始化部分
		//1.初始化array 给定一个默认大小
		//2.初始化size，没有数据，所以size=0
		array = new int[11];//11可以任意改
		size = 0;
	}
	
	//支持的方法
	//头插
	//O(n)
	public void pushFront(int element){
	ensureCapacity();
	
	//i是数据下标，遍历范围是[size-1,0]
	for(int i=size-1;i>=0;i--){
		array[i+1] =array[i];	
			}
		//0空出来了
		array[0] = element;
		size++;
	}
	
	//尾插
	//时间复杂度：O(1)
	public void pushBack(int element){
		ensureCapacity();
		array[size++] = element;
	}
	
	//正常插入
	//O(n)  最好是O(1)
	public void insert(int index,int element){
		
		//index的合法性：[0,size]
		if(index<0||index>size){
			System.out.println("index不合法");
			return;
		}
		ensureCapacity();
		//i代表的是空间的下标
		for(int i=size-1;i>=index;i--){
			array[i+1] = array[i];
		}
		array[index] = element;
		size++;
		
	}
	
	//头删
	public void popFront(){
		if(size==0){
			System.out.println("空顺序表，无法删除");
			return;
		}
		//从前往后移动
		for(int i=0;i<size-1;i++){
			array[i] = array[i+1];
		}
		size--;
	}
	
	//尾删
	public void popBack(){
		if(size==0){
			System.out.println("空顺序表，无法删除");
			return;
		}
		array[--size] = 0;
	}
	
	//正常删除
	public void erase(int index){
		if(size==0){
			System.out.println("空顺序表，无法删除");
			return;
		}
		for(int i=index;i<size-1;i++){
			array[i] = array[i+1];
		}
		size--;
	}
	
	//查找
	public int indexOf(int element){
		for(int i=0;i<=size-1;i++){
			if(element == array[i]){
				return i;
			}
		}
		return -1;
	}
	
	//根据下标获取元素
	public int get(int index){
		if(index<0||index>=size){
			System.out.println("下标错误");
			return -1;
		}
		return array[index];
	}
	
	//给定下标，修改下标所在元素的值
	public int set(int index,int element){
		array[index]=element;
		return 0;
	}
	
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	// public int capacity(){
		// return array.length;
	// }
	//便于打印，显示顺序表中已有元素
	public String toString(){
		return Arrays.toString(Arrays.copyOf(array,size));
	}
	
	//O(n)
	public void remove(int element){
		int index = indexOf(element);
		if(index != -1){
			erase(index);
		}
	
	}
	
	
	public void removeAll(int element){
		//时间：O(n^2) 空间：O(1)
		/*
		int index;
		while((index = indexOf(element))!=-1){
			erase(index);
		}
		*/
		/*
		时间：O(n) 空间：O(n)
		int[] newArray = new int[size];
		int j = 0;
		for(int i = 0;i < size;i++){
			if(array[i]!=element){
				newArray[j++] = array[i];
			}
		}
		最后剩下的数一共有j个
		1.把数据搬回去 2.更新size
		for(int i=0;i<j;i++){
			array[i] = newArray[i];
		}
		size =j;
		*/
		
		//时间：O(n) 空间：O(1)
		int j = 0;
		for(int i = 0;i<size;i++){
			if(array[i]!=element){
				array[j++] = array[i];
			}
		}
		size = j;
		
	}
	//内部使用的方法
	//无论是否需要扩容，调用完这个方法后一定够用
	private void ensureCapacity(){
		if(size < array.length){
			//不需要扩容
			return;
		}
		//1.申请新房子
		int newCapacity = array.length + array.length/2;
		int[] newArray = new int[newCapacity];
		//2.搬家
		for(int i=0;i<array.length;i++){
			newArray[i] = array[i];
		}
		//3.发朋友圈
		this.array = newArray;
		//4.退老房子，利用java的垃圾回收，自动回收原来的数组
	}
	
	public static void test1(String[] args){
		Seqlist seqlist = new Seqlist();
		System.out.println(seqlist.toString());
		//尾插1，2，3
		seqlist.pushBack(1);
		seqlist.pushBack(2);
		seqlist.pushBack(3);
		//[1,2,3]
		System.out.println(seqlist.toString());
		
		//头插10 20 30
		seqlist.pushFront(10);
		seqlist.pushFront(20);
		seqlist.pushFront(30);
		//[30,20,10,1,2,3]
		System.out.println(seqlist.toString());
		
		seqlist.insert(2,100);
		seqlist.insert(4,200);
		//[30,20,100,10,200,1,2,3]
		System.out.println(seqlist.toString());
		//System.out.print("当前容量：%d%n",seqlist.capacity());
		
		seqlist.pushBack(1000);
		seqlist.pushBack(2000);
		seqlist.pushBack(3000);
		seqlist.pushBack(4000);
		seqlist.pushBack(5000);
		seqlist.pushBack(6000);
		//System.out.print("当前容量：%d%n",seqlist.capacity());
		seqlist.popFront();
		seqlist.popFront();
		seqlist.popFront();
		seqlist.popFront();
		//[200,1,2,3]
		System.out.println(seqlist.toString());
		
		seqlist.popBack();
		seqlist.popBack();
		seqlist.popBack();
		//[200]
		System.out.println(seqlist.toString());
		
	}	
	public static void test2(String[] args){
		Seqlist s = new Seqlist();
		s.pushBack(1);
		s.pushBack(2);
		s.pushBack(3);
		s.pushBack(4);
		s.pushBack(1);
		s.pushBack(2);
		s.pushBack(3);
		s.pushBack(4);
		//[1,2,3,4,1,2,3,4]
		System.out.println(s.toString());
		s.remove(2);
		//[1,3,4,1,2,3,4]
		System.out.println(s.toString());
		s.removeAll(4);
		//[1,3,1,2,3]
		System.out.println(s.toString());
	}
	public static void main(String[] args){
		test1(args);
		test2(args);
	}	
}