import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class N110821 {
	static private int dif;            //��ǰ�����ϵĺ�
    static private Set<Integer> results = new HashSet<Integer>();    //��Ž��ʹ��
    static private int comNum;        //�Ƚ���
    static private List<Integer> iLists = new ArrayList<Integer>();    //��Ҫɸѡ��list
    static private int[] arr;        //����������ڱȽ������list�е�Ԫ��
    static private LinkedList<Integer> tmp = new LinkedList<Integer>();    //�����ʱ���
    static boolean sign = false;
 
    /*
     * ������
     * 1.��ǰ�����±�
     * 2.��һ�ε��ú�ĺ�
     * ����ֵ����ǰ��
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
        //�������һ��������Ƚ���С������ʼ��
        iLists.addAll(lists);
        //ȥ�����ڱȽ�������
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
        dif = arr[0];    //��ʼ��dif
        results.add(arr[0]);
        getNearestCom(arr.length, 0);
        return results;
    }
     
    public static void main(String[] args) {
        List<Integer> lists = Arrays.asList(new Integer[]{1,2,3,6,7,11,100,200,33,31});
        System.out.println("�������:" + N110821.search(lists, 50));
    }
}
