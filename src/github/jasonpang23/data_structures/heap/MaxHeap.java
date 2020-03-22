package github.jasonpang23.data_structures.heap;

import github.jasonpang23.data_structures.array.Array;

public class MaxHeap<E extends Comparable<E>>{

    private Array<E> array ;

    public MaxHeap(int capacity){
        array = new Array<>(capacity) ;
    }

    public MaxHeap(){
        array = new Array<>() ;
    }

    public MaxHeap(E[] arr){
        array = new Array<>(arr) ;
        for (int i = parent(arr.length - 1); i >= 0 ; i--) {
            siftDown(i);
        }
    }

    public int size(){
        return array.size() ;
    }


    public boolean isEmpty(){
        return array.isEmpty();
    }


    public void add(E e){
        array.addLast(e);
        siftUp(array.size() - 1) ;
    }

    public E findMax(){
        if(array.size() == 0){
            throw new IllegalArgumentException("Can not findMax when the maxHeap is empty.") ;
        }
        return array.get(0) ;
    }

    public E extractMax(){
        E result = array.getfirst() ;
        array.swap(0,array.size() - 1);
        array.removeLast() ;

        siftDown(0);
        return result ;
    }


    private void siftUp(int index){
        while(index != 0 && array.get(index).compareTo(array.get(parent(index))) > 0 ){
            array.swap(index,parent(index)); ;
            index = parent(index) ;
        }
    }

    private void siftDown(int index){
        while(lChild(index) < array.size()){
            int childIndex = lChild(index) ;
            // 选出左右孩子之间最大的那个
            if(rChild(index) < array.size() &&  array.get(rChild(index)).compareTo(array.get(childIndex)) > 0)
                childIndex = rChild(index) ;
            if(array.get(index).compareTo(array.get(childIndex))>= 0)
                break;
            array.swap(index,childIndex);
            index = childIndex ;
        }
    }

    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index 0 doesn't have parent.") ;
        }

        return (index - 1) / 2 ;
    }

    private int lChild(int index){
        return index * 2 + 1 ;
    }

    private int rChild(int index){
        return index * 2 + 2 ;
    }
}
