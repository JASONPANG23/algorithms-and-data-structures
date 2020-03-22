package github.jasonpang23.data_structures.tree.segment_tree;


/**
 * 以数组方式实现的线段树
 * 给定一个有界区间，维护该区间内的信息
 * @param <E>
 */
@SuppressWarnings("all")
public class SegmentTree<E> {

    private E[] data ;
    private E[] tree ;
    private Merger<E> merger ;

    public SegmentTree(E [] arr,Merger<E> merger){
        this.merger = merger ;
        data = (E[])new Object[arr.length] ;
        System.arraycopy(arr,0,data,0,arr.length);

        // 给予他可能的最大容量空间
        tree = (E[])new Object[4 * arr.length] ;
        buildSegementTree(0,0,data.length - 1);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal") ;
        return data[index] ;
    }

    /**
     * 查询[l...r]区间中的信息
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL,int queryR){
        if(queryL < 0 || queryL >= data.length ||
            queryR < 0 || queryR >= data.length)
            throw new IllegalArgumentException("Index is illegal.") ;

        return query(0,0,data.length - 1,queryL,queryR) ;
    }

    // 在[l...r]范围中，搜索[queryL...queryR]区间的信息
    private E query(int treeIndex ,int l,int r,int queryL,int queryR){

        // 如果查询的区间刚好匹配上，则返回结果
        if(l == queryL && r == queryR)
            return tree[treeIndex] ;

        // 计算中间值
        int mid = l + (r - l) / 2 ;

        // 左节点
        int leftTreeIndex = leftChild(treeIndex) ;
        // 右节点
        int rightTreeIndex = rightChild(treeIndex) ;

        //如果要查询的区间不在左区间，那么直接到右区间找
        if(queryL >= mid + 1){
            return  query(rightTreeIndex,mid + 1 ,r ,queryL,queryR) ;

        }else if (queryR <= mid){ //如果要查询的区间不在右区间，那么直接到左区间找
            return query(leftTreeIndex,l,mid,queryL,queryR) ;

        }else{ // 如果要查询的区间信息在左区间有一部分，在右区间也有一部分，那么分别去查询最后合并信息
            E leftResult = query(leftTreeIndex,l,mid,queryL,mid) ;
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);

            return merger.merge(leftResult,rightResult) ;
        }

    }

    /**
     * 将index位置的值，更新为e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if (index < 0 || index >= data.length )
            throw new IllegalArgumentException("index is illegal.") ;
        data[index] = e ;
        set(0,0,data.length - 1 ,index ,e ) ;
    }

    //更新线段树
    private void set(int treeIndex,int l,int r,int index,E e){
        if(l == r){
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
        else // index <= mid
            set(leftTreeIndex, l, mid, index, e);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    private int leftChild(int index){
        return 2 * index + 1 ;
    }

    private int rightChild(int index){
        return 2 * index + 2 ;
    }

    /**
     * 在treeIndex的位置创建表示区间[l...r]的线段树
     * @param treeIndex 当前要构造线段树的节点
     * @param l 左边界
     * @param r 右边界
     */
    private void buildSegementTree(int treeIndex,int l,int r){

        // 当区间中只有一个元素时
        if(l == r){
            tree[treeIndex] = data[l] ;
            return ;
        }

        int leftTreeIndex = leftChild(treeIndex) ;
        int rightTreeIndex = rightChild(treeIndex) ;

        int mid = l + (r - l) / 2 ;

        // 构造左子树的线段树
        buildSegementTree(leftTreeIndex,l,mid) ;
        // 构造右子树的线段树
        buildSegementTree(rightTreeIndex,mid + 1,r) ;
        // 综合左右两个线段节点的信息组织成更大线段节点的信息
        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]) ;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder() ;
        sb.append("[") ;
        for (int i = 0; i < tree.length; i++) {
            if(tree[i] != null){
                sb.append(tree[i]);
            }else {
                sb.append("null") ;
            }
            if(i != tree.length - 1)
                sb.append(", ");
        }
        sb.append("]") ;
        return sb.toString() ;
    }

}
