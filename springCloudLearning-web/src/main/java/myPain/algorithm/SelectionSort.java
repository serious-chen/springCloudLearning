package myPain.algorithm;

import java.util.List;

public class SelectionSort extends Sort {

    /**
     * 最好：f(n) = n-1 + n-2 + ... + 1 = (n+1)*(n-1)/2 = O(n^2)
     * 最坏：f(n) = n-1 + n-2 + ... + 1 = (n+1)*(n-1)/2 = O(n^2)
     * @param list
     * @return
     */
    @Override
    public List<Integer> sort(List<Integer> list) {

        // 每次选择时最小值得索引
        int minIndex;
        // 临时变量；
        int temp;
        for (int i = 0; i < list.size() - 1; i++) {
            int j = i;
            for(minIndex = j; j < list.size(); j++){

                // 不稳定，相同时，总是把后面的放到前面
                if(list.get(minIndex) > list.get(j)){
                    minIndex = j;
                }
            }

            // 当前循环，首位元素不为最小
            if(minIndex != i){
                temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
            }

        }
        return list;
    }
}
