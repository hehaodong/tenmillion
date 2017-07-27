import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import bean.MarkSixBean;

public class MarkSix {

	public MarkSix() {
		// TODO Auto-generated constructor stub
	}

	// 16年
	 private static int results16[] =
	 {0,47,11,8,38,47,26,24,13,9,5,13,36,4,2,32,41,10,31,24,46,45,47,7,42,31,33,40,14,43,2,
	 39,35,14,39,13,27,28,47,7,31,31,10,3,38,3,21,49,12,40,29,43,21,42,35,18,11,42,22,20,49,
	 38,11,47,19,11,37,4,24,49,29,18,36,35,5,38,22,29,18,48,36,4,35,24,12,15,28,49,7,3,40,13,
	 24,26,30,33,3,3,30,25,2,22,27,14,22,23,30,26,25,14,42,27,40,6,30,34,9,13,46,10,12,
	 19,35,14,41,42,8,47,48,28,37,42,26,33,32,5,41,33,25,16,7,11,29,45,37,23,29,39,47,41,26,33};
	// 15年
	 private static int results15[] =
	 {0,1,1,1,1,2,2,1,1,2,2,2,1,1,1,2,2,2,1,2,1,1,1,1,2,1,2,1,1,2,1,
	 2,2,1,1,1,2,1,1,1,2,2,1,2,2,2,1,1,1,1,2,2,1,2,2,2,2,1,1,2,1,
	 1,2,2,1,2,2,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,2,1,1,2,2,2,
	 2,1,2,2,2,1,2,2,2,2,1,1,1,2,2,2,1,2,1,2,1,2,2,2,2,2,2,2,1,2,
	 1,1,2,2,1,2,1,1,1,1,1,2,1,1,1,2,1,2,2,2,1,2,2,1,2,1,1,2,1,1,
	 2,1
	 };
	// 14年
	private static int results14[] = { 0, 21, 43, 46, 25, 14, 21, 33, 28, 44, 7, 6, 18,
			45, 37, 39, 14, 19, 30, 11, 35, 45, 14, 5, 44, 34, 22, 38, 40, 27,
			30, 27, 27, 14, 4, 6, 36, 11, 25, 3, 31, 6, 25, 13, 27, 42, 3, 14,
			16, 46, 14, 30, 25, 30, 48, 5, 8, 7, 7, 6, 19, 49, 1, 35, 31, 15,
			6, 27, 40, 15, 21, 7, 48, 36, 28, 21, 20, 47, 36, 8, 43, 44, 10,
			49, 13, 14, 40, 19, 38, 28, 14, 11, 37, 32, 11, 15, 16, 18, 13, 47,
			49, 6, 25, 1, 31, 32, 35, 29, 27, 23, 38, 24, 47, 7, 8, 48, 39, 8,
			33, 18, 25, 42, 19, 18, 31, 33, 31, 33, 3, 43, 26, 6, 10, 46, 12,
			44, 19, 44, 31, 33, 35, 16, 46, 31, 19, 16, 33, 22, 33, 30, 40, 7,
			27 };
	//13年的
	private static int results13[] = { 0,39,7,48,7,13,11,26,1,24,5,28,32,22,13,37,32,47,18,34,7,15,21,17,37,5,2,28,4,12,18,
	8,34,27,11,43,17,5,4,25,39,2,18,48,9,48,6,19,9,36,14,33,36,13,22,27,17,34,36,6,38,
	27,23,7,2,30,28,5,1,44,39,30,39,22,17,14,13,17,49,8,42,25,44,34,20,30,21,49,42,48,42,
	9,31,44,23,1,36,46,33,20,16,36,17,37,6,17,36,33,49,41,31,19,34,34,4,15,20,30,20,38,12,
	49,18,26,30,40,17,21,36,20,21,16,46,32,48,36,4,13,18,9,14,21,29,20,16,27,29,47,27,39,6,5,14};
	private static int results12[] = {0,40, 23, 14, 2, 49, 34, 48, 14, 24, 38, 48, 4, 47, 6, 10, 13, 31, 13, 30, 21, 31, 25, 43, 42, 41, 2, 19, 1, 28, 21, 6, 26, 40, 4, 35, 16, 9, 13, 32, 28, 47, 40, 39, 42, 43, 43, 37, 29, 3, 38, 38, 45, 27, 5, 48, 45, 8, 28, 16, 48, 10, 12, 7, 1, 5, 32, 31, 13, 29, 3, 27, 43, 3, 37, 44, 20, 1, 24, 47, 39, 28, 24, 9, 32, 6, 9, 37, 37, 38, 46, 7, 34, 41, 33, 40, 32, 4, 41, 35, 8, 3, 22, 38, 14, 45, 2, 23, 4, 25, 41, 6, 44, 14, 42, 18, 8, 38, 34, 41, 37, 15, 6, 12, 34, 43, 32, 5, 13, 47, 22, 37, 17, 15, 8, 25, 48, 43, 47, 7, 47, 49, 15, 41, 31, 1, 14, 47, 12, 30, 2, 10};
	private static int results11[] = {0,38, 1, 5, 41, 24, 2, 5, 32, 31, 34, 1, 25, 31, 5, 29, 14, 32, 5, 21, 35, 29, 35, 33, 48, 49, 43, 10, 47, 49, 44, 47, 40, 14, 13, 23, 46, 33, 47, 5, 13, 38, 6, 13, 42, 25, 22, 16, 32, 17, 29, 42, 6, 30, 2, 40, 1, 12, 7, 10, 48, 34, 24, 31, 36, 30, 34, 10, 21, 22, 20, 35, 36, 29, 15, 30, 37, 27, 13, 38, 19, 42, 38, 39, 2, 46, 22, 35, 38, 18, 17, 8, 10, 23, 4, 35, 8, 31, 48, 30, 6, 22, 5, 36, 3, 47, 38, 35, 28, 45, 28, 10, 12, 22, 9, 11, 32, 43, 29, 13, 15, 20, 20, 9, 21, 28, 22, 10, 30, 29, 49, 44, 5, 40, 45, 30, 16, 12, 17, 19, 21, 9, 46, 48, 20, 37, 48, 37, 2, 10, 38, 4, 43, 40, 3};
	private static int results10[] = {0,12, 12, 11, 36, 7, 23, 10, 40, 10, 37, 14, 27, 34, 9, 42, 8, 35, 14, 23, 19, 35, 48, 18, 17, 15, 27, 46, 32, 8, 18, 37, 41, 13, 27, 27, 2, 12, 6, 27, 46, 5, 47, 25, 34, 6, 12, 5, 27, 47, 38, 41, 42, 37, 45, 28, 35, 16, 43, 34, 23, 37, 7, 42, 22, 22, 22, 24, 42, 33, 31, 24, 13, 27, 49, 19, 49, 2, 24, 44, 37, 14, 11, 43, 24, 10, 1, 6, 26, 30, 18, 27, 41, 49, 14, 17, 32, 9, 20, 44, 15, 24, 3, 8, 11, 17, 32, 19, 33, 17, 40, 35, 8, 30, 41, 20, 29, 42, 17, 36, 31, 30, 48, 21, 20, 16, 16, 46, 47, 46, 46, 1, 3, 19, 44, 16, 7, 14, 13, 41, 40, 28, 2, 2, 16, 40, 27, 41, 1, 10, 42, 27, 6};
	private static int results9[] = {0,19, 14, 23, 49, 10, 38, 10, 18, 41, 45, 21, 31, 4, 24, 4, 7, 26, 21, 24, 45, 21, 14, 17, 41, 30, 44, 23, 48, 36, 15, 7, 35, 48, 26, 7, 4, 28, 14, 10, 21, 19, 24, 38, 26, 26, 34, 47, 48, 15, 31, 38, 4, 40, 34, 39, 16, 37, 48, 42, 4, 20, 42, 24, 20, 11, 44, 31, 20, 44, 39, 19, 31, 41, 26, 2, 20, 26, 4, 24, 45, 20, 45, 46, 13, 36, 38, 34, 25, 3, 1, 2, 11, 31, 20, 22, 4, 2, 40, 23, 32, 14, 47, 10, 35, 39, 7, 23, 24, 5, 49, 5, 35, 1, 14, 34, 30, 14, 47, 19, 21, 22, 43, 10, 12, 5, 9, 36, 45, 15, 26, 2, 25, 44, 8, 6, 8, 36, 8, 35, 20, 42, 38, 4, 36, 49, 12, 37, 37, 30, 42, 31, 7, 19, 26};
	private static int results8[] = {0,9, 18, 46, 10, 13, 43, 13, 20, 35, 1, 12, 8, 48, 41, 13, 7, 49, 10, 35, 42, 11, 43, 4, 39, 25, 39, 9, 39, 37, 14, 24, 7, 31, 27, 41, 5, 9, 15, 34, 31, 30, 46, 33, 45, 42, 34, 5, 35, 12, 18, 22, 10, 44, 41, 46, 20, 35, 6, 43, 10, 26, 40, 25, 28, 6, 6, 48, 8, 2, 2, 3, 11, 32, 36, 14, 1, 5, 24, 38, 25, 24, 15, 13, 3, 48, 10, 30, 13, 36, 6, 45, 15, 49, 31, 40, 29, 40, 39, 17, 8, 35, 9, 21, 9, 20, 5, 23, 24, 43, 31, 31, 4, 23, 32, 40, 8, 49, 28, 7, 17, 29, 27, 36, 13, 45, 13, 48, 3, 31, 28, 18, 35, 47, 36, 8, 39, 10, 29, 39, 29, 41, 24, 23, 26, 43, 22, 3, 15, 14};
	private static int results7[] = {0,4, 8, 43, 33, 32, 44, 26, 10, 47, 40, 47, 15, 39, 8, 6, 4, 41, 26, 43, 29, 29, 2, 21, 45, 7, 13, 36, 1, 25, 34, 34, 49, 11, 27, 19, 26, 12, 17, 48, 2, 40, 45, 49, 17, 38, 11, 5, 16, 38, 34, 15, 37, 7, 13, 6, 31, 46, 10, 5, 41, 37, 46, 6, 7, 34, 17, 13, 17, 12, 41, 34, 33, 49, 16, 21, 32, 20, 33, 34, 23, 22, 47, 30, 46, 4, 13, 7, 32, 32, 17, 7, 12, 13, 43, 35, 15, 40, 15, 22, 42, 33, 37, 11, 9, 20, 38, 38, 10, 15, 47, 24, 27, 49, 10, 32, 13, 24, 49, 24, 2, 42, 14, 20, 48, 45, 14, 41, 2, 8, 46, 32, 29, 46, 7, 1, 3, 36, 28, 16, 38, 16, 30, 15, 19, 42, 10, 16, 43, 48, 14, 13, 41};
	private static int results6[] = {0,42, 43, 41, 11, 4, 41, 45, 14, 44, 47, 14, 30, 15, 8, 29, 5, 18, 43, 41, 46, 17, 45, 20, 31, 30, 41, 22, 34, 16, 18, 32, 45, 39, 17, 15, 4, 30, 6, 37, 8, 11, 35, 21, 33, 47, 30, 10, 11, 39, 41, 20, 30, 23, 8, 33, 42, 26, 10, 41, 33, 9, 41, 18, 19, 41, 18, 5, 19, 16, 43, 15, 17, 8, 40, 12, 18, 40, 47, 14, 6, 2, 3, 19, 2, 13, 15, 26, 5, 17, 10, 19, 7, 47, 29, 34, 49, 5, 43, 36, 23, 18, 35, 29, 22, 41, 6, 31, 19, 12, 37, 48, 17, 8, 28, 26, 44, 23, 37, 44, 10, 18, 9, 36, 9, 40, 20, 36, 24, 20, 37, 19, 10, 40, 37, 30, 6, 4, 9, 44, 23, 38, 43, 40, 35, 26, 22, 17, 12, 46, 35, 4, 43, 13, 47};
	private static int results5[] = {0,36, 33, 19, 3, 32, 44, 2, 24, 9, 20, 20, 11, 4, 6, 27, 18, 22, 3, 23, 5, 43, 27, 40, 33, 19, 27, 28, 38, 7, 25, 1, 29, 35, 20, 5, 5, 27, 18, 14, 33, 18, 17, 39, 7, 9, 48, 34, 25, 47, 44, 42, 10, 18, 14, 35, 42, 18, 21, 18, 41, 6, 4, 40, 3, 13, 25, 5, 8, 17, 3, 4, 44, 29, 2, 5, 17, 45, 42, 17, 42, 21, 10, 3, 27, 4, 11, 44, 24, 27, 33, 26, 13, 2, 10, 10, 19, 38, 8, 32, 47, 15, 41, 6, 1, 2, 5, 8, 34, 31, 13, 5, 10, 49, 6, 14, 13, 45, 48, 12, 3, 5, 19, 33, 46, 23, 19, 37, 1, 26, 22, 30, 18, 13, 24, 17, 33, 2, 26, 24, 23, 10, 29, 35, 40, 4, 24, 6, 11, 23, 17, 44, 27, 15, 35, 34};
	private static int results4[] = {0,14, 6, 31, 13, 21, 10, 40, 12, 19, 40, 20, 25, 26, 42, 10, 42, 24, 3, 31, 10, 48, 37, 6, 5, 41, 10, 21, 11, 42, 17, 6, 38, 36, 41, 6, 11, 23, 31, 22, 32, 10, 29, 12, 19, 16, 14, 33, 14, 40, 28, 10, 49, 41, 47, 40, 29, 47, 39, 42, 49, 14, 49, 9, 12, 38, 37, 15, 22, 25, 10, 24, 15, 34, 38, 26, 43, 31, 45, 9, 45, 36, 7, 47, 32, 12, 45, 48, 31, 9, 12, 39, 29, 3, 22, 12, 36, 2, 35, 37, 21, 23, 33, 17, 48, 42, 34, 26, 45, 10, 30, 35, 3, 32, 8, 17, 37, 48, 42, 15, 18, 3, 6, 1, 19, 37, 7, 4, 11, 38, 13, 8, 11, 4, 19, 1, 43, 6, 23, 36, 1};
	private static int results3[] = {0,27, 44, 27, 46, 11, 34, 14, 49, 19, 5, 22, 45, 5, 43, 43, 29, 42, 24, 36, 15, 1, 8, 38, 12, 40, 24, 3, 34, 38, 22, 21, 28, 41, 10, 24, 24, 38, 3, 11, 12, 47, 9, 34, 6, 24, 38, 10, 29, 44, 1, 26, 4, 7, 32, 23, 39, 22, 38, 7, 21, 39, 47, 30, 49, 38, 2, 11, 47, 12, 49, 26, 29, 37, 11, 29, 6, 26, 42, 12, 18, 35, 48, 36, 3, 27, 43, 43, 33, 28, 42, 7, 18, 35, 20, 36, 33, 32, 17, 30, 43, 36, 15, 35, 24, 18, 29, 16, 46, 23, 48, 49, 6, 29, 20, 24, 15, 46};
	private static int results2[] = {0,24, 4, 42, 15, 9, 8, 17, 1, 46, 38, 33, 21, 18, 42, 28, 1, 34, 45, 41, 1, 19, 38, 13, 17, 2, 22, 25, 29, 19, 5, 40, 2, 36, 10, 30, 35, 15, 41, 4, 21, 8, 33, 37, 12, 45, 2, 1, 37, 18, 36, 30, 44, 5, 37, 20, 28, 41, 7, 13, 34, 8, 28, 34, 24, 8, 32, 17, 2, 34, 11, 28, 21, 24, 28, 27, 40, 15, 39, 9, 47, 22, 23, 35, 39, 3, 4, 5, 31, 27, 13, 43, 20, 9, 28, 11, 14, 1, 12, 13, 1, 16, 40, 33, 35, 26, 47, 17, 37, 39, 42, 45, 14, 22};
	private static int results[];
	//
	private int earnResult = 0;// 赚多少钱
	private int firstBuyAmount = 500;// 第一次买的钱
	private int buyAmount = 0;// 购买金额
	private int totalCost;// 总成本
	private double rate = 0.9;// 赔率
	private int deficitTimes = 0;// 亏损次数
	private int winTimes = 3;//赢钱次数
	private int totalDeficit;// 亏损总次数
	private boolean buyType = true;// true为单，false为双
	private int buy_type = 0;//0为双，1为单
	
	private List<Integer> buyList = new ArrayList<Integer>();
	private List<Integer> resultList = new ArrayList<Integer>();

	/**
	 * @param args
	 * @Description
	 * @return void
	 * @date： 2016-12-26 下午1:55:33
	 * @author: hehaodong
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		results = results14;
		MarkSix markSix = new MarkSix();
//		 markSix.cal();
//		markSix.calSerial2();
		markSix.calOneOdd();
	}

	public void cal() {
		List<Integer> totalList = new ArrayList<Integer>(); 
		List<MarkSixBean> beanList = new ArrayList<MarkSixBean>();
		for (int i = 1; i < results.length; i++) {
			MarkSixBean sixBean = new MarkSixBean();
			sixBean.setPeriod(i);
			sixBean.setBuyType(buyType);
			sixBean.setBuyNumber(results[i]);
			boolean isWin = isWin(results[i]);
			sixBean.setWin(isWin);
			if (deficitTimes == 0) {// 重新开始
				buyAmount = firstBuyAmount;
				totalCost = buyAmount;
				sixBean.setLastTotalAmount(0);
			} else if (deficitTimes == 1) {// 如果亏损一次，本金2倍
				buyAmount = (int) (firstBuyAmount * 2);
				sixBean.setLastTotalAmount((int)(buyAmount*rate)-totalCost);
				totalCost = buyAmount + totalCost;
//				System.out.println("亏本第2期\n 成本为：" + totalCost);
			} else if (deficitTimes == 2) {// 如果之前连续亏损2次了，本金2倍
				buyAmount = (int) (firstBuyAmount * 4);
				sixBean.setLastTotalAmount((int)(buyAmount*rate)-totalCost);
				totalCost = buyAmount + totalCost;
//				System.out.println("亏本第3期\n 成本为：" + totalCost);
			} else if (deficitTimes == 3) {// 亏损了3次 ,本金8倍
				buyAmount = (int) (firstBuyAmount * 8);
//				System.out.println("亏本第4期\n 购买金额为：" + buyAmount);
				sixBean.setLastTotalAmount((int)(buyAmount*rate)-totalCost);
				totalCost = buyAmount + totalCost;
//				System.out.println("亏本第4期\n 成本为：" + totalCost);
			} else if (deficitTimes == 4) {// 亏损了4，本金16倍
				buyAmount = (int) (firstBuyAmount * 16);
//				System.out.println("亏本第5期\n 购买金额为：" + buyAmount);
				sixBean.setLastTotalAmount((int)(buyAmount*rate)-totalCost);
				totalCost = buyAmount + totalCost;
//				System.out.println("成本为：" + totalCost);
			} else if (deficitTimes == 5) {// 亏损了5，本金32倍
				buyAmount = (int) (firstBuyAmount * 32);
//				System.out.println("亏本第6期\n 购买金额为：" + buyAmount);
				sixBean.setLastTotalAmount((int)(buyAmount*rate)-totalCost);
				totalCost = buyAmount + totalCost;
//				System.out.println("成本为：" + totalCost);
			} else if (deficitTimes == 6) {// 亏损了6次，本金64倍
				buyAmount = (int) (firstBuyAmount * 64);
//				System.out.println("亏本第7期\n 购买金额为：" + buyAmount);
				sixBean.setLastTotalAmount((int)(buyAmount*rate)-totalCost);
				totalCost = buyAmount + totalCost;
//				System.out.println("成本为：" + totalCost);
			} else if (deficitTimes == 7) {// 亏损了6次，本金64倍
				buyAmount = (int) (firstBuyAmount * 128);
//				System.out.println("亏本第8期\n 购买金额为：" + buyAmount);
				sixBean.setLastTotalAmount((int)(buyAmount*rate)-totalCost);
				totalCost = buyAmount + totalCost;
//				System.out.println("成本为：" + totalCost);
			} else if (deficitTimes == 8) {// 亏损了6次，本金64倍
				buyAmount = (int) (firstBuyAmount * 256);
//				System.out.println("亏本第9期\n 购买金额为：" + buyAmount);
				sixBean.setLastTotalAmount((int)(buyAmount*rate)-totalCost);
				totalCost = buyAmount + totalCost;
//				System.out.println("成本为：" + totalCost);
			} else if (deficitTimes == 9) {// 亏损了6次，本金64倍
				buyAmount = (int) (firstBuyAmount * 512);
//				System.out.println("亏本第10期\n 购买金额为：" + buyAmount);
				sixBean.setLastTotalAmount((int)(buyAmount*rate)-totalCost);
				totalCost = buyAmount + totalCost;
//				System.out.println("成本为：" + totalCost);
			} else if (deficitTimes == 10) {// 亏损了6次，本金64倍
				buyAmount = (int) (firstBuyAmount * 1024);
//				System.out.println("亏本第11期\n 购买金额为：" + buyAmount);
				sixBean.setLastTotalAmount((int)(buyAmount*rate)-totalCost);
				totalCost = buyAmount + totalCost;
//				System.out.println("成本为：" + totalCost);7150
			} else {
				System.out.println("亏损次数====" + deficitTimes);
			}
//			totalList.add(totalCost);
			sixBean.setTotalAmount(totalCost);
			sixBean.setBuyAmount(buyAmount);
			if(i%2==0){
				buyType = !buyType;
			}
			if (isWin) {
				totalDeficit = totalDeficit + deficitTimes;
				sixBean.setDeficitTimes(deficitTimes);
				deficitTimes = 0;
				if(winTimes == 2){
					buyType = !buyType;
				}
				winTimes++;
				earnResult = earnResult + (int) (buyAmount * rate);
				buyAmount = firstBuyAmount;
				
			} else {
				if(deficitTimes == 2){
					buyType = !buyType;
				}
				deficitTimes++;
				winTimes = 0;
				earnResult = earnResult - buyAmount;
			}
			beanList.add(sixBean);
		}
		System.out.println("赔率为：" + rate + "\n 连续" + (results.length - 1)
				+ "期,最终结果为：===" + earnResult + "\n 亏损总次数：" + totalDeficit);
//		Collections.sort(totalList);
//		System.out.println(totalList.toString());
		for (MarkSixBean markSixBean : beanList) {
			System.out.println(markSixBean.toString());
		}
	}

	/**
	 * 一期单，一期双
	 * 
	 * @Description 
	 * @return void
	 * @date： 2017-1-9 下午4:52:18
	 * @author:   	hehaodong
	 */
	public void calOneOdd(){
		int loseTimes = 0;
		for (int i = 1; i < results.length; i++){
			if(isWinNew(results[i])){
				winTimes++;
				loseTimes = 0;
			}else{
				loseTimes++;
				deficitTimes++;
			}
			buyList.add(buy_type);
			resultList.add(results[i]);
			if(i >2 ){
				if(i > 3){
					if( i >4){
						if(isOdd(results[i-4])==isOdd(results[i-3])==isOdd(results[i-2])==isOdd(results[i-1])){
							buy_type = (results[i-2]+1)%2; //取反
						}else {
							if(isOdd(results[i-3])==isOdd(results[i-2])==isOdd(results[i-1])){
								buy_type = (results[i-2]+1)%2; //取反
							}else{
								if(isOdd(results[i-2])==isOdd(results[i-1])){
									buy_type = (results[i-2]+1)%2; //取反
								}else{
									buy_type = (buyList.get(i-1)+1)%2;
								}
							}
						}
					}else{
						if(i%2==0){
							buy_type = 0;
						}else{
							buy_type = 1;
						}
					}
					
				}else{
					if(isOdd(results[i-2])==isOdd(results[i-1])){
						buy_type = (results[i-2]+1)%2; //取反
					}else{
						buy_type = (buyList.get(i-1)+1)%2;
					}
				}
				
			}else{
				if(i%2==0){
					buy_type = 0;
				}else{
					buy_type = 1;
				}
			}
			
			
		}
		System.out.println("单数"+winTimes+"\n偶数"+deficitTimes);
		System.out.println("购买类型"+resultList.toString());
		System.out.println("购买类型"+buyList.toString());
	}
	private boolean isWinNew(int number){
		if((buy_type%2==0)==(number%2==0)){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean isWin(int number) {
		if (buyType) {// 买单
			if (number % 2 != 0) {
				return true;
			} else {
				return false;
			}
		} else {
			// 买双
			if (number % 2 == 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	private int appearTimes = 0;
	private boolean lastStatus = false;

	private boolean isOdd(int number) {

		return (number % 2 == 0);
	}

	// 连续3期单，一期双的，10次,连续10期双的，6次 连续4期的，7次,
	private void calSerial2() {
		int threeTimes = 0;
		for (int i = 1; i < results.length; i++) {
			if (i > 1 && i < results.length - 1) {
				if (isOdd(results[i - 1]) == isOdd(results[i])) {
					
					 if(isOdd(results[i]) == isOdd(results[i+1])){//连续3次以上的
						 threeTimes ++;
						 
//						 if(isOdd(results[i+1]) ==isOdd(results[i+2])){
//							 
//						 }else{
//							 System.out.println(results[i-1]);
//							 System.out.println(results[i]);
//							 System.out.println(results[i+1]);
//							 System.out.println("======="+i+"==========");
//						 }
					 }else{
					 System.out.println(results[i-1]);
					 System.out.println(results[i]);
					 System.out.println(results[i+1]);
					 System.out.println("----------"+i+"------------");
					 appearTimes++;
					 }
				}
			}
		}
		System.out.println("出现连续2期相同，第三期不同的次数" + appearTimes);
		System.out.println("出现连续3期以上相同的次数" + threeTimes);
		//(13年的:19+19=38 30.4  34.2)(14年的：(20+17)*0.8 =29.6  33.3)(15年的：(20+19)*0.8=31.2  35.1)(16年的：(22+17)*0.8=31.2  35.1)
		// 12+7=19  11.4 15.2 (14年的：6+11=17  0.8为:12.6__0.9为:16.3)(15年的：11+10=21 0.8为:10.2__0.9为:14.1)(16年的：6+10=16 0.8为：15.2__0.9为：19.1)
		
	}

	
	private void calSerial3() {
		List<Integer> c = new ArrayList<Integer>(); // 连续的子数组
		int size2Times = 0;
		int size3Times = 0;
		int sizeMoreTimes = 0;
		
		int winAmoumt = 0;
		for (int i = 1; i < results.length-1; i++) {
//			if (i > 1 && i < results.length - 1) {
				if(isTheSame(results[i], results[i-1])){
					c.add(results[i]);
				}else{
					if (c.size() > 1) {
	                    System.out.println(c);
	                }
					
					if(c.size() == 2){
						winAmoumt = winAmoumt + (int)(2000*0.9);
						System.out.println(winAmoumt);
						size2Times++;
					}else if(c.size() > 2){
						winAmoumt = winAmoumt -2000;
					}
					if(c.size() == 3){
						winAmoumt = winAmoumt + (int)(2000*0.9);
						System.out.println(winAmoumt);
						size3Times++;
					}else if(c.size() >3){
						winAmoumt = winAmoumt -2000;
						sizeMoreTimes++;
					}
	 
	                c.clear();
	                c.add(results[i]);
				}
//			}
		}
		System.out.println("出现连续2次的有：" + size2Times);
		System.out.println("出现连续3次的有：" + size3Times);
		System.out.println("出现连续3以上次的有：" + sizeMoreTimes);
		System.out.println("最后能赚多少钱"+winAmoumt);

	}
	
	private boolean isTheSame(int a,int b){
		return (a%2==0)==(b%2==0);
	}

	private void calSerial4() {
		for (int i = 1; i < results.length; i++) {
			if (i > 1 && i < results.length - 3) {
				if (isOdd(results[i - 1]) && isOdd(results[i])
						&& isOdd(results[i + 1]) && isOdd(results[i + 2])) {
					// if(isOdd(results[i+2]) && isOdd(results[i+1])){//连续3次以上的
					// }else{
					// System.out.println(results[i-1]);
					// System.out.println(results[i]);
					// System.out.println(results[i+1]);
					// System.out.println(results[i+2]);
					// System.out.println("-----------------------");
					// appearTimes++;
					// }
					if (isOdd(results[i + 2]) && isOdd(results[i + 3])) {// 连续3次以上的
					} else {
						System.out.println(results[i - 1]);
						System.out.println(results[i]);
						System.out.println(results[i + 1]);
						System.out.println(results[i + 2]);
						System.out.println("-----------------------");
						appearTimes++;
					}
				}
			}
		}
		System.out.println("出现的次数" + appearTimes);

	}
	//判断大双
	private void calBigEven(){
		
	}
	//判断小双
	private void calSmallEven(){
		
	}
	//判断大d单
	private void calBigOdd(){
		
	}
	//判断小单
	private void calSmallOdd(){
		
	}
}