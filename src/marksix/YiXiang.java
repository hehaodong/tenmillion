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
	private static final String ANIM[] = {"��","ţ","��","��","��","��","��","��","��","��","��","��"}; 
	
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
			//ǰ����
			
			MarkSix markSix = markSixList.get(i);
			
			//��ǰ
			String currentResult[] = getClearAnimal(markSix).split(",");
			
			//ǰ����
			String beforeTwo[] = getClearAnimal(markSixList.get(i-2)).split(",");
			//ǰһ��
			String beforeOne[] = getClearAnimal(markSixList.get(i-1)).split(",");
			
			Set<String> resultSet1 = new HashSet<String>(Arrays.asList(beforeOne)); 
			Set<String> resultSet2 = new HashSet<String>(Arrays.asList(beforeTwo)); 
			
			
			Set<String> resultSet3 = new HashSet<String>(Arrays.asList(currentResult)); 
			
			
//			System.out.println("ǰ����"+resultSet1.toString());
//			System.out.println("ǰһ��"+resultSet2.toString());
//			System.out.println("����"+resultSet3.toString());
			resultSet.clear();
			resultSet.addAll(resultSet1);
			resultSet.addAll(resultSet2);
			System.out.println("������"+resultSet);
			
			
			animal.removeAll(result);
//			System.out.println("���"+animal);
			
			//��ȡ��ĵ�һ��
			String diffMark = animal.toString();
			if(diffMark.length() < 3){
				diffMark="@";
			}else if(diffMark.length() == 3){//ȡ���һ��
				diffMark = diffMark.substring(1,2);
			}
			else if(diffMark.length() == 6){
				diffMark = diffMark.substring(4,5);//ȡ��ڶ���
			}
			else{
				diffMark = "@";//ȡ�������   ������������
			}
			
//			System.out.println("ǰ���ڲȡһ����"+diffMark);
			if("@".equals(diffMark)) {
				moreThanThree++;
			}else if(resultSet3.contains(diffMark)){
				kuisun = 0;
//				winTimes ++;
			}else{
				kuisun ++;
			}
			
			if(resultSet3.contains("��")) {
				winTimes ++;
			}
//			System.out.println(kuisun);
			
//			System.out.println(resultSet3.contains(diffMark));
			
//			resultSet3.retainAll(animal);
//			System.out.println("������"+resultSet3);
//			resultSet3.clear();
			
			animal.clear();
			animal  = new HashSet<String>(Arrays.asList(ANIM)); 
			
			
			
//			result.add(oneResult);
			
			//ǰ����������Ф ����
//			String beforeTwo = getClearAnimal(markSixList.get(i-1)).replace(",","")+getClearAnimal(markSixList.get(i-2)).replace(",","");
			
			
			
//	        boolean isWin = oneResult.contains(getBuyAnimal(i));
//	        System.out.println(getBuyAnimal(i)+"=="+isWin+"----��----"+oneResult);
	        
	        
//	        System.out.println(oneResult);
//	        if(isWin){
//	        	winTimes ++;
//	        }
//	        oneResult.contains(getBuyAnimal());
	        
		}
//		
		System.out.println(resultSet.size());
		System.out.println(winTimes);
//		System.out.println("����Ĵ�����"+moreThanThree);
		
//		System.out.println(markSixList.toString());
	}
	
	private String getBuyAnimal(int i){
		if(i<12){
			return ANIM[i];
		}else{
			return ANIM[i%12];
		}
		
	}
	//��ȡ�ɾ���
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
	//ȥ�ظ�
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
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
		}};
		Set<String> set2 = new HashSet<String>(){{
			add("��");
			add("��");
			add("ţ");
			add("��");
			add("��");
			add("��");
			add("��");
		}};
		Set<String> set3 = new HashSet<String>(){{
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
		}};
		Set<String> set4 = new HashSet<String>(){{
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
		}};
		Set<String> set5 = new HashSet<String>(){{
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
		}};
		Set<String> set6 = new HashSet<String>(){{
			add("ţ");
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
			add("��");
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
			
			System.out.println("ǰ����"+resultSet1.toString());
			System.out.println("ǰһ��"+resultSet2.toString());
			System.out.println("����"+resultSet3.toString());
			result.clear();
			result.addAll(resultSet1);
			result.addAll(resultSet2);
			System.out.println("������"+result);
			
			
			animal.removeAll(result);
			System.out.println("���"+animal);
			
			resultSet3.retainAll(animal);
			System.out.println("������"+resultSet3);
			resultSet3.clear();
			
		}
		
		result.clear();
		result.addAll(set2);
		result.addAll(set3);
		System.out.println("������"+result);
		
		
		animal.removeAll(result);
		System.out.println("���"+animal);
		
		set4.retainAll(animal);
		System.out.println("������"+set4);
		
		
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
		System.out.println("������"+result);
		
		result.clear();
		result.addAll(set1);
		result.removeAll(set2);
		System.out.println("���"+result);
		
		result.clear();
		result.addAll(set1);
		result.addAll(set2);
		System.out.println("������"+result);
	}
	
	/**
	 * ������ֵĴ���
	 * 
	 * @Description 
	 * @return void
	 * @date�� 2017��7��25�� ����3:09:03
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
		//��������
		Collections.reverse(markSixList);
		for (int i = 0; i < ANIM.length; i++) {
			int times = 0;
			for (int j = 0;j<markSixList.size();j++) {
				MarkSix markSix = markSixList.get(j);
				//�Զ��ŷָ�����װ������
				String currentResult[] = getClearAnimal(markSix).split(",");
				Set<String> resultSet = new HashSet<String>(Arrays.asList(currentResult)); 
				if(resultSet.contains(ANIM[i])) {
					times++;
				}
			}
			System.out.println(ANIM[i]+"����"+times+"��");
//			System.out.println(times);
		}
	}
	/**
	 * ������
	 * 
	 * @Description 
	 * @return void
	 * @date�� 2017��9��2�� ����10:47:25
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
		//��������
		Collections.reverse(markSixList);
		for (int i = 0; i < ANIM.length; i++) {
			int times = 0;
			int lastPeriod = 0;
			for (int j = 0;j<markSixList.size();j++) {
				MarkSix markSix = markSixList.get(j);
				int stage = Integer.parseInt(markSix.getStage().substring(0, 3));
				//�Զ��ŷָ�����װ������
				String currentResult[] = getClearAnimal(markSix).split(",");
				Set<String> resultSet = new HashSet<String>(Arrays.asList(currentResult)); 
//				if(j>0) {
					if(resultSet.contains(ANIM[i])) {
						
						System.out.println(ANIM[i]+"��"+stage+"�ڳ���,���"+(stage-lastPeriod)+"��");
						lastPeriod = stage;
					}
//				}
//				if(resultSet.contains(ANIM[i])) {
//					System.out.println(ANIM[i]+"��"+markSix.getStage()+"�ڳ���");
//					times++;
//				}
				
			}
//			System.out.println(ANIM[i]+"����"+times+"��");
			System.out.println("---------------------------");
		}
	}
}
