package github.jasonpang23.data_structures.tree.segment_tree;

public class Main {

    public static void main(String[] args) {
        Integer[] nums = {-2,0,3,-5,2,-1} ;
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums,
                Integer::sum);

//        System.out.println(segmentTree);

        Integer sum = segmentTree.query(0, nums.length - 1);
        System.out.println(sum);
        segmentTree.set(3,2);
        sum = segmentTree.query(0, nums.length - 1);

        System.out.println(sum);
    }
}
