package myPain.algorithm;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class Sort {

    public abstract List<Integer> sort(List<Integer> list);

    public static Sort getBean(SortType type){
        switch (type){
            case BUBBLE:
                return SortType.BUBBLE.getSortBean();

            case SELECTION:
                return SortType.SELECTION.getSortBean();

            case MERGE:
                return SortType.MERGE.getSortBean();

            case QUICK:
                return SortType.QUICK.getSortBean();

            case INSERTION:
            default:
                return SortType.INSERTION.getSortBean();
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(7,5,3,2,6,1,4,5,4);
        System.out.println(getBean(SortType.MERGE).sort(list));
    }
}
