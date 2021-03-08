package myPain.algorithm;

public enum SortType {
    INSERTION("插入", new InsertionSort()),
    BUBBLE("冒泡", new BubbleSort()),
    SELECTION("选择", new SelectionSort()),
    MERGE("归并", new MergeSort()),
    ;


    private String desc;

    private Sort sortBean;

    SortType(String desc, Sort sortBean){
        this.desc = desc;
        this.sortBean = sortBean;
    }

    public String getDesc() {
        return desc;
    }

    public Sort getSortBean() {
        return sortBean;
    }
}
