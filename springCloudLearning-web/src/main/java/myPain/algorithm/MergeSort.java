package myPain.algorithm;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 归并排序：
 *  1、拆为较小问题后，分别排序；
 *  2、合并至原有上一级问题；
 *  3、所以是两个步骤：
 *      a、把数组拆分为小数组；小数组分别排序；
 *      b、小数组解决后，合并，合并时的顺序（对两个有序数组的排序）；
 */
public class MergeSort extends Sort {

    @Override
    public List<Integer> sort(List<Integer> list) {

        return sortOnlyIfSimply(list, 0, list.size() - 1);
    }

    /**
     * 分解、合并
     * 时间复杂度：
     *  1、f(n) = f(n1) + f(n2) + K;
     *  2、...
     *  3、f(1) = C；
     *  4、f(n) = 2*f(n/2) + n;
     *  5、     = 2*(2*f(n/4) + n/2) = 4*f(n/4) + 2*n;
     *  6、     = 4*(2*f(n/8) + n/4) + 2*n = 8*f(n/8) + 3*n
     *  7、     = 2^k * f(n/2^k) + k*n;
     *  8、f(1) = f(n/2^k)时, k = log2n;即分解足够多次
     *  9、f(n) = nf(1) + nlog2n = O(nlog2n);
     *
     *  空间复杂度：
     *      1、每次合并都会额外创造一次合并空间；
     *      2、合并空间当子递归被执行完就被释放，所以最大空间复杂度为O(n)；但是会频繁开辟内存空间，和回收
     * @param list
     * @param beginning
     * @param ending
     * @return
     */
    private List<Integer> sortOnlyIfSimply(List<Integer> list, int beginning, int ending){
        int size = ending - beginning + 1;
        if(size == 1){
            return Lists.newArrayList(list.get(beginning));
        }

        if(size == 2){
            if(list.get(beginning) > list.get(ending)){
                return Lists.newArrayList(list.get(ending), list.get(beginning));
            }
            return Lists.newArrayList(list.get(beginning), list.get(ending));
        }

        int midIndex = size/2 + beginning;

        List<Integer> aList = sortOnlyIfSimply(list, beginning, midIndex);
        List<Integer> bList = sortOnlyIfSimply(list, midIndex + 1, ending);

        return merge(aList, bList);
    }

    /**
     * 合并两个有序数组
     * @param aList
     * @param bList
     * @return
     */
    private List<Integer> merge(List<Integer> aList, List<Integer> bList){
        int aSize = aList.size();
        int bSize = bList.size();

        List<Integer> result = new ArrayList<>(aSize + bSize);
        int aCursor = 0, bCursor = 0;
        for(; aCursor < aSize && bCursor < bSize; ){
            // 只要aList与bList元素相等时，不交换，即稳定
            if (aList.get(aCursor) > bList.get(bCursor)){
                result.add(bList.get(bCursor++));
            } else {
                result.add(aList.get(aCursor++));
            }
        }

        if(aCursor == aSize){
            for(; bCursor < bSize;){
                result.add(bList.get(bCursor++));
            }
        } else {
            for(; aCursor < aSize;){
                result.add(aList.get(aCursor++));
            }
        }
        return result;
    }
}
