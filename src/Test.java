import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Test {
    public static void main(String[] args) {  
//        System.out.println(chinese("s"));
//        System.out.println(chinese("中国"));
//		String card = "445221195685241986";
//			StringBuffer buffer = new StringBuffer(card);
//			
//			buffer.replace(2, card.length()-3, "**************");
//			System.out.println(formtMDH("2014-10-23 20:40:11"));
//			sort();
//    	Pattern pattern = Pattern.compile("^[\u4E00-\u9FA5A-Za-z0-9_]{2,12}$");
//    	Matcher matcher = pattern.matcher("ff电风扇Fff%$");
//    	
//    	System.out.println(matcher.matches());
//          System.out.println(isChinese("ds好的"));
//    	car();
//    	testlambda();
    	
System.out.println("==**==渠道验证工具==**==");  

if (args.length != 1) {  
    System.out.println("==ERROR==usage:java -jar channelV.jar apkDirectory======");  
    System.out.println("==INFO==Example: java -jar channelV.jar /apps======");  
    return;  
}  

String apk = args[0];  

SplitApk sp = new SplitApk(apk);  
sp.mySplit(); 
    }  
    
//    private static void testlambda(){
//    	Runnable r = ()->System.out.println("hello,lambda");
//        r.run();
//    }
    private static void car(){
        String carNo ="粤S A9 h  42";
        
        carNo = carNo.replaceAll(" ", "").toUpperCase();
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}");
        Matcher matcher = pattern.matcher(carNo);
        if (!matcher.matches()) {
        	System.out.println("车牌号格式不正确");
        }else{
            carNo = carNo.substring(1,carNo.length());
            System.out.println("=="+carNo);
        }
    }
    private static void sort(){
    	List<Integer> inputList = new ArrayList<Integer>();
    	int dd;
    	for (int i = 0; i < 10; i++) { 
    		dd = (int) (Math.random()*100);
    		inputList.add(dd); 
    		System.out.println("eeee="+dd);
    	} 
    	Collections.sort(inputList);
    	inputList.remove(0);
    	inputList.remove(inputList.size()-1);
    	double sum = 0;
    	for (int i = 0; i < inputList.size(); i++) {
    		sum += inputList.get(i).doubleValue();
		}
    	double ava = sum / inputList.size();
    	int ddddd = (int)ava;
    	System.out.println("ava======"+ava);
    	System.out.println("value=="+binarysearchKey(inputList.toArray(), ddddd));
//    	
//    	for (int i = 0; i < inputList.size(); i++) {
//    		(inputList.get(i).doubleValue() - sum);
//		}
    }
    
    public static Integer binarysearchKey(Object[] array, int targetNum) {  
    	  
        Arrays.sort(array);  
        int targetindex = 0;  
        int left = 0, right = 0;  
        for (right = array.length - 1; left != right;) {  
            int midIndex = (right + left) / 2;  
            int mid = (right - left);  
            int midValue = (Integer) array[midIndex];  
            if (targetNum == midValue) {  
                return midIndex;  
            }  
      
            if (targetNum > midValue) {  
                left = midIndex;  
            } else {  
                right = midIndex;  
            }  
      
            if (mid <= 2) {  
                break;  
            }  
        }  
        System.out.println("和要查找的数：" + targetNum + "最接近的数："  
                + array[targetindex]);  
        return (Integer) (((Integer) array[right] - (Integer) array[left]) / 2 > targetNum ? array[right]  
                : array[left]);  
    }
    
	public static String formtMDH(String dateStr) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date retDate = format.parse(dateStr);
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			return format.format(retDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
    public static boolean isChinese(String str) {
//      if(TextUtils.isEmpty(str)){
//          return false;
//      }
      String reg = "[\\u4e00-\\u9fa5]+";//表示+表示一个或多个中文，
       return str.matches(reg);
  }
    
	public static boolean chinese(String str) {
		Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	
}
