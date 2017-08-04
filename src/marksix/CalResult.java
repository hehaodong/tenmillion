package marksix;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONArray;

import data.Result;

public class CalResult {
	private static final String ANIM[] = {"鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"}; 
	private static int evenTimes;
	public CalResult() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 输入当前期数，从此往后的第几期，生肖出现的次数，升序排列
	 * 
	 * @Description 
	 * @return void
	 * @date： 2017年7月25日 下午5:49:23
	 * @author:   	hehaodong
	 */
	public static void calASC(int currentPeriod,int space) {
//		String result = HttpGet.sendGet("");
		String result = Result.data2017;
		System.out.println(result);
		if(result == null || "".equals(result)) {
			return;
		}
		List<MarkSix> markSixList = JSONArray.parseArray(result,MarkSix.class);
		//重新排序
//		Collections.reverse(markSixList);
		List<MarkSix> newList = markSixList.subList(currentPeriod-1, space);
		for (int i = 0; i < ANIM.length; i++) {
			int times = 0;
			for (int j = 0;j<newList.size();j++) {
				MarkSix markSix = newList.get(j);
				//以逗号分隔，封装好数据
				String currentResult[] = getClearAnimal(markSix).split(",");
				Set<String> resultSet = new HashSet<String>(Arrays.asList(currentResult)); 
				if(resultSet.contains(ANIM[i])) {
					times++;
				}
			}
			double rate = times/Double.parseDouble(newList.size()+"");
			System.out.println("从"+currentPeriod+"期--"+space+"期之间："+ANIM[i]+"出现："+times+"次"+"概率："+rate);
//			System.out.println(times);
		}
	}
	/**
	 * 计算某一个时间内，奇偶数出现的次数和概率
	 * @param currentPeriod
	 * @param space
	 * @Description 
	 * @return void
	 * @date： 2017年7月28日 下午3:24:43
	 * @author:   	hehaodong
	 */
	public static void calEvenTimes(int currentPeriod,int space) {
//		String result = HttpGet.sendGet("2010");
		String result = Result.data2017;
		if(result == null || "".equals(result)) {
			return;
		}
		List<MarkSix> markSixList = JSONArray.parseArray(result,MarkSix.class);
		//重新排序
		Collections.reverse(markSixList);
		if(space > markSixList.size()) {
			space = markSixList.size();
		}
		List<MarkSix> newList = markSixList.subList(currentPeriod-1, space);
		for (int j = 0; j < newList.size(); j++) {
			MarkSix markSix = newList.get(j);
			if(isEven(Integer.parseInt(markSix.getOne_code().substring(0,2))) ) {
				System.out.println(markSix.getOne_code());
				evenTimes++;
				System.out.println(evenTimes);
			}
		}
		double rate = evenTimes/Double.parseDouble(newList.size()+"");
		System.out.println("从"+currentPeriod+"期--"+space+"期之间,出现：偶数"+evenTimes+"次"+"概率："+rate);
		System.out.println("从"+currentPeriod+"期--"+space+"期之间,出现：奇数"+(newList.size()-evenTimes)+"次"+"概率："+(1-rate));

	}
	//获取干净的
	private static String getClearAnimal(MarkSix markSix){
		StringBuilder builder = new StringBuilder("");
		builder.append(markSix.getOne_code());
		builder.append(",");
		builder.append(markSix.getSix_code().toString().replace("[","").replace("]","").replace(" ", ""));
		
        Pattern pattern = Pattern.compile("[\\d]");
        Matcher matcher = pattern.matcher(builder.toString());
        
        String oneResult = matcher.replaceAll("").trim();
        
        return oneResult;
	}
	
	/**
	 * 判断是否偶数
	 * @param number
	 * @return
	 * @Description 
	 * @return boolean
	 * @date： 2017年7月28日 下午3:21:20
	 * @author:   	hehaodong
	 */
	public static boolean isEven(int number) {
//		System.out.println(number);
		return (number % 2 == 0);
	}
}
