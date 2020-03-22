package github.jasonpang23.data_structures.array;


/**
 * 动态数组
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class Array<E> {

    private E[] data ;
    private int size ;//[1...capacity]

    public Array(int capacity){
        data = (E[]) new Object[capacity] ;
    }

    public Array(E [] arr){
        data = (E[])new Object[arr.length] ;
        System.arraycopy(arr, 0, data, 0, arr.length);
        size = arr.length ;
    }

    public Array(){
        this(10) ;
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取当前存储元素的个数
     * @return
     */
    public int size(){
        return size ;
    }

    /**
     * 当前数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0  ;
    }

    /**
     * 将元素添加到指定位置
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if(index < 0 || index > size)
            throw  new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        if(size == data.length){
            resize(size * 2) ;
        }

        for (int i = size; i > index; i--)
            data[i] = data[i - 1] ;

        data[index] = e ;
        size ++ ;
    }

    /**
     * 添加一个元素到数组的最后一个位置
     * @param e
     */
    public void addLast(E e){
        add(size,e) ;
    }

    /**
     * 添加一个元素到数组第一个位置
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 根据索引获取一个元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index <0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index] ;
    }

    /**
     * 获取数组中第一个元素
     * @return
     */
    public E getfirst(){
        return get(0) ;
    }

    /**
     * 获取数组中最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1) ;
    }
    /**
     * 更新某个索引下的元素
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index <0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e ;
    }

    /**
     * 是否包含某个元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        return find(e) != -1 ;
    }

    /**
     * 根据元素查找对应的下标
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return i ;
        }
        return -1  ;
    }

    /**
     * 根据索引删除一个元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index <0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        E result = data[index] ;
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i] ;
        }
        data[--size] = null ;
        if(size <= data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return result;
    }



    /**
     * 删除数组中最后一个元素
     * @return
     */
    public E removeLast(){
        return  remove(size - 1) ;
    }

    /**
     * 删除数组中第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0) ;
    }

    /**
     * 删除匹配的元素
     * @param e
     * @return
     */
    public E removeElement(E e){
        int i = find(e);
        E result = data[i];
        remove(i) ;
        return result ;
    }

    public void swap(int a,int b){
        E temp = data[a] ;
        data[a] = data[b] ;
        data[b] = temp ;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array: size = %d , capacity = %d \n", size, data.length));
        stringBuilder.append("[") ;

        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]) ;
            if(i != size - 1)
                stringBuilder.append(",") ;
        }
        stringBuilder.append("]") ;
        return  stringBuilder.toString() ;
    }

    private void resize(int newCapacity){
        E[] arr = (E[]) new Object[newCapacity];

        // size 永远比 capacity小
        for(int i = 0;i<size;i++){
            arr[i] = data[i] ;
        }
        data = arr ;
    }
}
