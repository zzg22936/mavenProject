package sort;

import java.util.Arrays;
import java.util.List;

public class HeapSort implements SortAlgorithm{
    
    @Override
    public <T extends Comparable<T>> void sort(List<T> unsorted) {
       sort(unsorted.toArray((T[]) new Comparable[unsorted.size()]));
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] unsorted) {
        int length = unsorted.length;
        //1.构建初始大顶堆,最顶上为最大值
        for(int i=length/2-1; i>=0; i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(unsorted,i,length); //确保该叶子节点所代表的树满足要求
        }
        System.out.println("初始结果");
        printResult(unsorted);
        //2.去掉最顶端元素，重新调整堆
        int k = 0;
        for(int i= length-1;i>0;i--){
           T tmp = unsorted[i];
           unsorted[i] = unsorted[0];
           unsorted[0] = tmp;
           adjustHeap(unsorted,0,i);
           k++;
           System.out.println("第"+k+"次调整结果");
           printResult(unsorted);
        }
    }

    private <T extends Comparable<T>> void printResult(T[] unsorted){
        for(int i = 0;i<unsorted.length;i++){
            System.out.print(unsorted[i]+"\t");
        }
        System.out.println("\n");
    }

    public <T extends Comparable<T>> void adjustHeap(T[] unsorted,int i,int length){
        T tmp = unsorted[i]; // temp保存当前父节点
        for(int k = i*2+1; k<length; k=k*2){
            if(k+1<length && less(unsorted[k],unsorted[k+1])){
                k++;         // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            }
            if(greater(tmp,unsorted[k])){
                break;   //父节点小于孩子 则跳出
            }else{
                unsorted[i] = unsorted[k]; //将子节点赋值给父节点（不交换）
                i = k; //并记下交换的位置
            }
            unsorted[i]=tmp;
        }
    }

    static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }
    static <T extends Comparable<T>> boolean greater(T v, T w) {
        return v.compareTo(w) > 0;
    }
}
