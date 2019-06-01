public class ArrayList{
     int size=0;
    int[ ] array=new int[10]; 
	//顺序表存储的是int类型的元素
    //理论上支持保存任意类型的数据
    //增 删 查 改
    //将element插入到index所在的下标
    //要求，对index做合法性校验
	public ArrayList(int[] array){
		//1.this.array和array不是一回事
		//2.申请的空间至少需要array.length长
		this.array = new int[array.length];
		//把传入数组的所有元素copy到属性array中
		for(int i = 0;i<array.length;i++){
			this.array[i] = array[i];
		}
		//记得更新size
		size = array.length;
	}
	public void insert(int index, int element){
		if(index<0||index>size){
		System.out.println("index不合法");
		return;
		}
		//确保空间够用，否则进行扩容
		private void ensureCapacity(){
			if(size<array.length){
				return;
			}
			int oldCapacity = array.length;
			int newCapacity = oldCapacity+oldCapacity/2;
			int[]newCapacity = new int[newCapacity];
			for(int i=0;i<size;i++){
				newArray[i] = array[i];
			}
			array = newArray;
		}
		public String toString(){
			int
		}
			for(int i = size-1;i>=index;i--){
			array[i+1] = array[i];
			}
           array[index] = element;
           size++;
}
		public void erase(int index){
	         if(index<0||index>size){
				System.out.println("index不合法");
				return;
			}
			for(int i=index;i<size-1;i++){
			array[i] = array[i+1];
			}
         size--;
}
      
public static void main(String[] args){
	
}
}