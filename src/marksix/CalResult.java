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
	private static final String ANIM[] = {"��","ţ","��","��","��","��","��","��","��","��","��","��"}; 
	
	public CalResult() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ���뵱ǰ�������Ӵ�����ĵڼ��ڣ���Ф���ֵĴ�������������
	 * 
	 * @Description 
	 * @return void
	 * @date�� 2017��7��25�� ����5:49:23
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
		//��������
//		Collections.reverse(markSixList);
		List<MarkSix> newList = markSixList.subList(currentPeriod-1, space);
		for (int i = 0; i < ANIM.length; i++) {
			int times = 0;
			for (int j = 0;j<newList.size();j++) {
				MarkSix markSix = newList.get(j);
				//�Զ��ŷָ�����װ������
				String currentResult[] = getClearAnimal(markSix).split(",");
				Set<String> resultSet = new HashSet<String>(Arrays.asList(currentResult)); 
				if(resultSet.contains(ANIM[i])) {
					times++;
				}
			}
			double rate = times/Double.parseDouble(newList.size()+"");
			System.out.println("��"+currentPeriod+"��--"+space+"��֮�䣺"+ANIM[i]+"���֣�"+times+"��"+"���ʣ�"+rate);
//			System.out.println(times);
		}
	}
	
	//��ȡ�ɾ���
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
}