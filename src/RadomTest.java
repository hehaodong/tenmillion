import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RadomTest {

	public RadomTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @Description 
	 * @return void
	 * @date： 2016-12-30 上午9:56:59
	 * @author:   	hehaodong
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 49; i++) {
			list.add(radom());
		}
		System.out.println(list.toString());
	}

	public static int radom(){
		Random rand = new Random();
		return rand.nextInt(49); //int范围类的随机数
	}
}
