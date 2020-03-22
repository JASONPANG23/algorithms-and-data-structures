package github.jasonpang23.data_structures.tree.segment_tree;

/**
 * 定义线段树的合并逻辑
 * @param <E>
 */
public interface Merger<E> {

    E merge(E a,E b);
}
