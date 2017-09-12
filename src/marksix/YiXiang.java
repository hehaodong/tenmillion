package marksix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.andy.sixha.bean.AnimalSet;

import data.Result;



public class YiXiang {

	//http://hkjc.leanapp.cn/api/history/2016
	private static final String ANIM[] = {"鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"}; 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YiXiang yiXiang = new YiXiang();
		//every Zodiac appear times
//		yiXiang.calAppearTimes();
		
//		yiXiang.calAppearSpace();
		//calculate Even or odd Times
		CalResult.calEvenTimes(1, 200);
		//Count the rate of  per issue 
//		CalResult.calASC(1,200);
//		yiXiang.calResult();
	}

	private void buyAnim(){
		for (int i = 1; i < ANIM.length+1; i++) {
			if(i%3 == 0){
				System.out.println(ANIM[i-1]);
			}
		}
	}
	private void calResult(){
		int winTimes = 0;
		List<MarkSix> markSixList = JSONArray.parseArray(Result.data2016,MarkSix.class);
		
		Collections.reverse(markSixList);
		List<String> result = new ArrayList<String>();
		
		Set<String> resultSet = new HashSet<String>();
		
		Set<String> animal  = new HashSet<String>(Arrays.asList(ANIM)); 
		
		int kuisun = 0;
		int moreThanThree = 0;
		for (int i = 2;i<markSixList.size();i++) {
			//前两期
			
			MarkSix markSix = markSixList.get(i);
			
			//当前
			String currentResult[] = getClearAnimal(markSix).split(",");
			
			//前两期
			String beforeTwo[] = getClearAnimal(markSixList.get(i-2)).split(",");
			//前一期
			String beforeOne[] = getClearAnimal(markSixList.get(i-1)).split(",");
			
			Set<String> resultSet1 = new HashSet<String>(Arrays.asList(beforeOne)); 
			Set<String> resultSet2 = new HashSet<String>(Arrays.asList(beforeTwo)); 
			
			
			Set<String> resultSet3 = new HashSet<String>(Arrays.asList(currentResult)); 
			
			
//			System.out.println("前二期"+resultSet1.toString());
//			System.out.println("前一期"+resultSet2.toString());
//			System.out.println("本期"+resultSet3.toString());
			resultSet.clear();
			resultSet.addAll(resultSet1);
			resultSet.addAll(resultSet2);
			System.out.println("并集："+resultSet);
			
			
			animal.removeAll(result);
//			System.out.println("差集："+animal);
			
			//获取差集的第一个
			String diffMark = animal.toString();
			if(diffMark.length() < 3){
				diffMark="@";
			}else if(diffMark.length() == 3){//取差集第一个
				diffMark = diffMark.substring(1,2);
			}
			else if(diffMark.length() == 6){
				diffMark = diffMark.substring(4,5);//取差集第二个
			}
			else{
				diffMark = "@";//取差集第三个   交集超过三个
			}
			
//			System.out.println("前两期差集取一个："+diffMark);
			if("@".equals(diffMark)) {
				moreThanThree++;
			}else if(resultSet3.contains(diffMark)){
				kuisun = 0;
//				winTimes ++;
			}else{
				kuisun ++;
			}
			
			if(resultSet3.contains("鸡")) {
				winTimes ++;
			}
//			System.out.println(kuisun);
			
//			System.out.println(resultSet3.contains(diffMark));
			
//			resultSet3.retainAll(animal);
//			System.out.println("交集："+resultSet3);
//			resultSet3.clear();
			
			animal.clear();
			animal  = new HashSet<String>(Arrays.asList(ANIM)); 
			
			
			
//			result.add(oneResult);
			
			//前两期所有生肖 集合
//			String beforeTwo = getClearAnimal(markSixList.get(i-1)).replace(",","")+getClearAnimal(markSixList.get(i-2)).replace(",","");
			
			
			
//	        boolean isWin = oneResult.contains(getBuyAnimal(i));
//	        System.out.println(getBuyAnimal(i)+"=="+isWin+"----开----"+oneResult);
	        
	        
//	        System.out.println(oneResult);
//	        if(isWin){
//	        	winTimes ++;
//	        }
//	        oneResult.contains(getBuyAnimal());
	        
		}
//		
		System.out.println(resultSet.size());
		System.out.println(winTimes);
//		System.out.println("不买的次数："+moreThanThree);
		
//		System.out.println(markSixList.toString());
	}
	
	private String getBuyAnimal(int i){
		if(i<12){
			return ANIM[i];
		}else{
			return ANIM[i%12];
		}
		
	}
	//获取干净的
	private String getClearAnimal(MarkSix markSix){
		StringBuilder builder = new StringBuilder("");
		builder.append(markSix.getOne_code());
		builder.append(",");
		builder.append(markSix.getSix_code().toString().replace("[","").replace("]","").replace(" ", ""));
		
        Pattern pattern = Pattern.compile("[\\d]");
        Matcher matcher = pattern.matcher(builder.toString());
        
        String oneResult = matcher.replaceAll("").trim();
        
        return oneResult;
	}
	//去重复
	private String clearDouble(String str){
		 return str.replaceAll("(?s)(.)(?=.*\\1)", ""); 
	}
	private void calAinm(){
		
		Set<String> animal = new HashSet<String>();
		for (int i = 0; i < ANIM.length; i++) {
			animal.add(ANIM[i]);
		}
		Set<String> result = new HashSet<String>();
		Set<String> set1 = new HashSet<String>(){{
			add("猪");
			add("龙");
			add("猴");
			add("狗");
			add("蛇");
			add("猪");
			add("兔");
		}};
		Set<String> set2 = new HashSet<String>(){{
			add("龙");
			add("鸡");
			add("牛");
			add("羊");
			add("猴");
			add("鼠");
			add("马");
		}};
		Set<String> set3 = new HashSet<String>(){{
			add("猪");
			add("羊");
			add("虎");
			add("龙");
			add("鼠");
			add("猪");
			add("虎");
		}};
		Set<String> set4 = new HashSet<String>(){{
			add("羊");
			add("羊");
			add("羊");
			add("马");
			add("虎");
			add("羊");
			add("鸡");
		}};
		Set<String> set5 = new HashSet<String>(){{
			add("虎");
			add("兔");
			add("马");
			add("蛇");
			add("兔");
			add("猴");
			add("兔");
		}};
		Set<String> set6 = new HashSet<String>(){{
			add("牛");
			add("猪");
			add("猴");
			add("鸡");
			add("兔");
			add("猴");
			add("狗");
		}};
		
		List<Set> resultList = new ArrayList<Set>();
		resultList.add(set1);
		resultList.add(set2);
		resultList.add(set3);
		resultList.add(set4);
		resultList.add(set5);
		resultList.add(set6);
				
		for (int i = 0; i < resultList.size(); i++) {
			Set<String> resultSet1 = resultList.get(i);
			Set<String> resultSet2 = resultList.get(i+1);
			Set<String> resultSet3 = resultList.get(i+2);
			
			System.out.println("前二期"+resultSet1.toString());
			System.out.println("前一期"+resultSet2.toString());
			System.out.println("本期"+resultSet3.toString());
			result.clear();
			result.addAll(resultSet1);
			result.addAll(resultSet2);
			System.out.println("并集："+result);
			
			
			animal.removeAll(result);
			System.out.println("差集："+animal);
			
			resultSet3.retainAll(animal);
			System.out.println("交集："+resultSet3);
			resultSet3.clear();
			
		}
		
		result.clear();
		result.addAll(set2);
		result.addAll(set3);
		System.out.println("并集："+result);
		
		
		animal.removeAll(result);
		System.out.println("差集："+animal);
		
		set4.retainAll(animal);
		System.out.println("交集："+set4);
		
		
	}
	
	public static boolean useSet(String[] arr, String targetValue) {
	 Set<String>set = new HashSet<String>(Arrays.asList(arr));
	 return set.contains(targetValue);

	}
	private void cal(){
		Set<Integer> result = new HashSet<Integer>();
		Set<Integer> set1 = new HashSet<Integer>(){{
			add(1);
			add(3);
			add(5);
		}};
		
		Set<Integer> set2 = new HashSet<Integer>(){{
			add(1);
			add(2);
			add(3);
		}};
		
		result.clear();
		result.addAll(set1);
		result.retainAll(set2);
		System.out.println("交集："+result);
		
		result.clear();
		result.addAll(set1);
		result.removeAll(set2);
		System.out.println("差集："+result);
		
		result.clear();
		result.addAll(set1);
		result.addAll(set2);
		System.out.println("并集："+result);
	}
	
	/**
	 * 计算出现的次数
	 * 
	 * @Description 
	 * @return void
	 * @date： 2017年7月25日 下午3:09:03
	 * @author:   	hehaodong
	 */
	private void calAppearTimes() {
		String result = HttpGet.sendGet("2016");
		System.out.println(result);
//		result = Result.data2017;
		if(result == null || "".equals(result)) {
			return;
		}
		List<MarkSix> markSixList = JSONArray.parseArray(result,MarkSix.class);
		//重新排序
		Collections.reverse(markSixList);
		for (int i = 0; i < ANIM.length; i++) {
			int times = 0;
			for (int j = 0;j<markSixList.size();j++) {
				MarkSix markSix = markSixList.get(j);
				//以逗号分隔，封装好数据
				String currentResult[] = getClearAnimal(markSix).split(",");
				Set<String> resultSet = new HashSet<String>(Arrays.asList(currentResult)); 
				if(resultSet.contains(ANIM[i])) {
					times++;
				}
			}
			System.out.println(ANIM[i]+"出现"+times+"次");
//			System.out.println(times);
		}
	}
	/**
	 * 计算间隔
	 * 
	 * @Description 
	 * @return void
	 * @date： 2017年9月2日 上午10:47:25
	 * @author:   	hehaodong
	 */
	private void calAppearSpace() {
		String result = HttpGet.sendGet("2013");
//		System.out.println(result);
		result = Result.data2017;
		
		if(result == null || "".equals(result)) {
			return;
		}
		List<MarkSix> markSixList = JSONArray.parseArray(result,MarkSix.class);
		//重新排序
		Collections.reverse(markSixList);
		for (int i = 0; i < ANIM.length; i++) {
			int times = 0;
			int lastPeriod = 0;
			for (int j = 0;j<markSixList.size();j++) {
				MarkSix markSix = markSixList.get(j);
				int stage = Integer.parseInt(markSix.getStage().substring(0, 3));
				//以逗号分隔，封装好数据
				String currentResult[] = getClearAnimal(markSix).split(",");
				Set<String> resultSet = new HashSet<String>(Arrays.asList(currentResult)); 
//				if(j>0) {
					if(resultSet.contains(ANIM[i])) {
						
						System.out.println(ANIM[i]+"在"+stage+"期出现,相隔"+(stage-lastPeriod)+"期");
						lastPeriod = stage;
					}
//				}
//				if(resultSet.contains(ANIM[i])) {
//					System.out.println(ANIM[i]+"在"+markSix.getStage()+"期出现");
//					times++;
//				}
				
			}
//			System.out.println(ANIM[i]+"出现"+times+"次");
			System.out.println("---------------------------");
		}
	}
}
