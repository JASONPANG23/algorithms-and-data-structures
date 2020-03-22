package github.jasonpang23.data_structures.queue.前K个高频元素_347;

import github.jasonpang23.data_structures.queue.PriorityQueue;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 说明：
 *
 *     你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 *     你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {

        // 统计词频
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            if (treeMap.containsKey(num))
                treeMap.replace(num, treeMap.get(num) + 1);
            else
                treeMap.put(num, 1);
        }

        //将元素依次添加进优先队列
        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>() ;
        for (Integer key : treeMap.keySet()){
            if(priorityQueue.getSize() < k){
                priorityQueue.enqueue(new Freq(key,treeMap.get(key)));
            }else if(priorityQueue.front().v < treeMap.get(key)){
                priorityQueue.dequeue() ;
                priorityQueue.enqueue(new Freq(key,treeMap.get(key)));
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            list.push(priorityQueue.dequeue().k);
        }

        return list ;
    }

    private class Freq implements Comparable<Freq>{

        private int k,v ;

        public Freq(int k, int v) {
            this.k = k;
            this.v = v;
        }

        /**
         * 词频低的优先级高
         * @param another
         * @return
         */
        @Override
        public int compareTo(Freq another) {
            if(this.v < another.v)
                return 1 ;
            else if(this.v > another.v)
                return -1 ;
            return 0 ;
        }
    }
}
