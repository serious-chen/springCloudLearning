package myPain.algorithm;

import java.util.List;
/**
 * @Description 快速排序
 *      需要多回顾，这个算法并不是自己一开始就想通的，甚至连解法都没看懂
 * @Date 2021/3/9 6:03 下午
 **/
public class QuickSort extends Sort {

    /**
     * 空间复杂度：O(1)并无创造额外空间；
     * 时间复杂度：
     * @param list
     * @return
     */
    @Override
    public List<Integer> sort(List<Integer> list) {
        sort(list, 0, list.size() - 1);
        return list;
    }

    /**
     * 获取分区标识并排序
     * 快慢指针法：
     *  快指针指向当前遍历处，慢指针指向比pivot大的第一个数；遇见较小值时再次交换
     * @param list
     * @param begin
     * @param end
     * @return
     */
    private int partition(List<Integer> list, int begin, int end){
        Integer pivotValue = list.get(end);
        int pivotIndex = begin;

        Integer temp;
        for (int i = begin; i < end; i++){
            if((temp = list.get(i)) < pivotValue){
                list.set(i, list.get(pivotIndex));
                list.set(pivotIndex ++, temp);
            }
        }

        temp = list.get(pivotIndex);
        list.set(end, temp);
        list.set(pivotIndex, pivotValue);
        return pivotIndex;
    }

    private void sort(List<Integer> list, int begin, int end){
        if(begin >= end){
            return;
        }
        int pivot = partition(list, begin, end);

        sort(list, begin, pivot - 1);
        sort(list, pivot + 1, end);
    }
}
