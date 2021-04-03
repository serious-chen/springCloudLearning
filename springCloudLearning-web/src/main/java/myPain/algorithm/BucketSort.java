package myPain.algorithm;

import java.util.List;

/**
 * @Description 暂未实现，重写了一次快排
 * @Date 2021/4/2 10:47 上午
 **/
public class BucketSort extends Sort {

    @Override
    public List<Integer> sort(List<Integer> list) {
        sortPartition(list, 0, list.size() - 1);
        return list;
    }

    private void sortPartition(List<Integer> list, int start, int end){
        if(start >= end){
            return;
        }

        int pivot = getPivotAndPartition(start, end, list);
        sortPartition(list, start, pivot -1);
        sortPartition(list, pivot + 1, end);
    }

    private int getPivotAndPartition(int start, int end, List<Integer> list){
        int pivotIndex = start;
        Integer pivotValue = list.get(end);
        Integer temp;
        for(int i = start; i < end; i++){
            if((temp = list.get(i)) < pivotValue){
                list.set(i, list.get(pivotIndex));
                list.set(pivotIndex ++, temp);
            }
        }

        temp = list.get(pivotIndex);
        list.set(pivotIndex, pivotValue);
        list.set(end, temp);
        return pivotIndex;
    }
}
