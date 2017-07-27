import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class N110821 {
	static private int dif;            //当前最大组合的和
    static private Set<Integer> results = new HashSet<Integer>();    //存放结果使用
    static private int comNum;        //比较数
    static private List<Integer> iLists = new ArrayList<Integer>();    //需要筛选的list
    static private int[] arr;        //存放消除大于比较数后的list中的元素
    static private LinkedList<Integer> tmp = new LinkedList<Integer>();    //存放临时结果
    static boolean sign = false;
 
    /*
     * 参数：
     * 1.当前数组下标
     * 2.上一次调用后的和
     * 返回值，当前数
     */
    static void getNearestCom(int nIndex, int sum){
        for(int i = nIndex; i >= 0; ){
            i--;
            if(i >= 0 && sum + arr[i] < comNum){
                tmp.addLast(arr[i]);
                sign = true;
                getNearestCom(i, sum + arr[i]);
            }else{
                if(sign && sum >= dif){
                    dif = sum;
                    results.clear();
                    results.addAll(tmp);
                    System.out.println(results + "--------->" + dif);
                    sign = false;
                }
                if(i == -1)
                {
                    if(!tmp.isEmpty())
                        tmp.removeLast();
                }
            }
        }
    }
     
    static Set search(List<Integer> lists, int max){
        comNum = max;
        //先随便找一个比这个比较数小的数初始化
        iLists.addAll(lists);
        //去掉大于比较数的数
        for(int i = 0; i < iLists.size(); i++){
            if(iLists.get(i) >= comNum){
                iLists.remove(i);
                i--;
            }
        }
        arr = new int[iLists.size()];
        for(int i = 0; i < iLists.size(); i++){
            arr[i] = iLists.get(i);
        }
        dif = arr[0];    //初始化dif
        results.add(arr[0]);
        getNearestCom(arr.length, 0);
        return results;
    }
     
    public static void main(String[] args) {
        List<Integer> lists = Arrays.asList(new Integer[]{1,2,3,6,7,11,100,200,33,31});
        System.out.println("最后结果是:" + N110821.search(lists, 50));
    }
}
