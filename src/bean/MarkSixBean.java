package bean;

public class MarkSixBean {

	public MarkSixBean() {
		// TODO Auto-generated constructor stub
	}

	private int period;//期数
	private boolean buyType;//买单还是买双
	private int buyAmount;//购买金额
	private int totalAmount;//累计成本
	private boolean openType;//开出来的类型
	private boolean isWin;//是否赢
	private int buyNumber;
	private int lastTotalAmount;
	private int deficitTimes;
	
	
	public MarkSixBean(int period, boolean buyType, int buyAmount,
			int totalAmount,boolean openType,boolean isWin,int buyNumber) {
		super();
		this.period = period;
		this.buyType = buyType;
		this.buyAmount = buyAmount;
		this.totalAmount = totalAmount;
		this.openType = openType;
		this.isWin = isWin;
		this.buyNumber = buyNumber;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		int winAmount = 0;
		if(isWin){
			if(deficitTimes > 0){
				winAmount =lastTotalAmount;
			}else{
				winAmount = (buyAmount*90/100);
			}
		}
		
		return "第"+period+"期，买"+(buyType?"单":"双")+"，买"+buyAmount+"元，开"+buyNumber+","+(isWin?"赢"+winAmount:"输"+buyAmount)+"，累计成本为:"+(isWin?0:totalAmount);
	}
	
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public boolean getBuyType() {
		return buyType;
	}
	public void setBuyType(boolean buyType) {
		this.buyType = buyType;
	}
	public int getBuyAmount() {
		return buyAmount;
	}
	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public boolean isOpenType() {
		return openType;
	}
	public void setOpenType(boolean openType) {
		this.openType = openType;
	}
	public boolean isWin() {
		return isWin;
	}
	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}
	public int getBuyNumber() {
		return buyNumber;
	}
	public void setBuyNumber(int buyNumber) {
		this.buyNumber = buyNumber;
	}
	public int getLastTotalAmount() {
		return lastTotalAmount;
	}
	public void setLastTotalAmount(int lastTotalAmount) {
		this.lastTotalAmount = lastTotalAmount;
	}
	public int getDeficitTimes() {
		return deficitTimes;
	}
	public void setDeficitTimes(int deficitTimes) {
		this.deficitTimes = deficitTimes;
	}
	

}
