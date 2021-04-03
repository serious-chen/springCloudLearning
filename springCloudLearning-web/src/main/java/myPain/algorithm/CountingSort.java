package myPain.algorithm;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 计数排序，保证要排序的数值区间大小相对数据量为常数K
 * 空间复杂度：O(N + K)
 * 最坏时间复杂度：O(3N + K) = 2*N + K + N;
 */
public class CountingSort extends Sort {

    @Override
    public List<Integer> sort(List<Integer> list) {
//        return resetValueByPointCountArr(list, getPointCountArr(list));
        Pair<Integer, List<Integer>> pair = getMinValAndPointCountArr(list);
        return resetValueByPointCountArr(list, pair.getKey(), pair.getValue());
    }

    /**
     * 获取 分数索引、数量值的数组
     * @param list
     * @return
     */
    private List<Integer> getPointCountArr(List<Integer> list){
        Integer max = list.get(0);

        // 最小值过大可声明大小为 max - min，分数根据point - min定位count的数量
        Integer min = list.get(0);
        for (Integer integer : list) {
            if(integer > max){
                max = integer;
            } else if(integer < min){
                min = integer;
            }
        }

        List<Integer> pointCountArr = new ArrayList<>(max);
        for (Integer integer : list) {
            Integer count = Optional.ofNullable(pointCountArr.get(integer)).orElse(0);
            pointCountArr.set(integer, ++ count);
        }

        Integer lastVal = pointCountArr.get(0);
        for (int i = 1; i < pointCountArr.size(); i++) {
            pointCountArr.set(i, lastVal += pointCountArr.get(i));
        }
        return pointCountArr;
    }

    private List<Integer> resetValueByPointCountArr(List<Integer> list, List<Integer> pointCountArr){
        List<Integer> result = new ArrayList<>(list.size());
        list.forEach(item ->{
            result.set(pointCountArr.get(item), item);
            pointCountArr.set(item, pointCountArr.get(item) - 1);
        });
        return result;
    }

    private Pair<Integer, List<Integer>> getMinValAndPointCountArr(List<Integer> list){
        Integer max = list.get(0);

        // 最小值过大可声明大小为 max - min，分数根据point - min定位count的数量
        Integer min = list.get(0);
        for (Integer integer : list) {
            if(integer > max){
                max = integer;
            } else if(integer < min){
                min = integer;
            }
        }

        List<Integer> pointCountArr = new ArrayList<>(max - min + 1);
        for (Integer integer : list) {
            int val = integer - min;
            Integer count = Optional.ofNullable(pointCountArr.get(val)).orElse(0);
            pointCountArr.set(val, ++ count);
        }

        Integer lastVal = pointCountArr.get(0);
        for (int i = 1; i < pointCountArr.size(); i++) {
            pointCountArr.set(i, lastVal += pointCountArr.get(i));
        }
        return new Pair(min, pointCountArr);
    }

    private List<Integer> resetValueByPointCountArr(List<Integer> list, Integer min, List<Integer> pointCountArr){
        List<Integer> result = new ArrayList<>(list.size());
        list.forEach(item ->{
            int val = item - min;
            result.set(pointCountArr.get(val), item);
            pointCountArr.set(val, pointCountArr.get(val) - 1);
        });
        return result;
    }
}
