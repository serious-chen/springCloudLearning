package myPain.algorithm;

import java.util.List;

public class InsertionSort extends Sort {

    @Override
    public List<Integer> sort(List<Integer> sortedNum){

        Integer temp;
        int size = sortedNum.size();

        for (int i = 1; i < size; i++) {

            for(int j = i - 1; j >= 0; j-- ){
                if(sortedNum.get(j+1) < sortedNum.get(j)){
                    temp = sortedNum.get(j);
                    sortedNum.set(j, sortedNum.get(j+1));
                    sortedNum.set(j+1, temp);
                } else {
                    break;
                }
            }
        }

        return sortedNum;
    }


}
