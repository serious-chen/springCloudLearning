package myPain.algorithm;

import java.util.List;

/**
 * 冒泡
 */
public class BubbleSort extends Sort {

    /**
     * 最坏：f(n) = n-1 + n-2 + ... + n-n+1 = n^2 - (1+ n-1)*n/2 = n^2 - n^2/2 = n^2/2 = O(n^2)
     * 最好：O(1)
     * @param sortedNum
     * @return
     */
    public List<Integer> sort(List<Integer> sortedNum){

        boolean changed = false;

        Integer template;
        for (int i = 0; i < sortedNum.size() - 1; i++) {

            for (int j = 1; j < sortedNum.size() - i; j++) {

                if(sortedNum.get(j - 1) > sortedNum.get(j)){
                    template = sortedNum.get(j - 1);
                    sortedNum.set(j - 1, sortedNum.get(j));
                    sortedNum.set(j, template);
                    changed = true;
                    continue;
                }
            }

            if(!changed) break;
            changed = false;
        }

        return sortedNum;
    }
}
