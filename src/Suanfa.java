
public class Suanfa {

	public Suanfa() {
		// TODO Auto-generated constructor stub
	}
	private static String[] results = {"��,��, ţ, ��, ��, ��, ��","��,��, ��, ��, ��, ��, ��","��,��, ��, ��, ��, ��, ��"};
	/**
	 * @param args
	 * @Description 
	 * @return void
	 * @date�� 2016-12-29 ����4:55:48
	 * @author:   	hehaodong
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Suanfa fa = new Suanfa();
		fa.isWin(results[0]);
	}
	
	private String buyType = "��";
	private boolean isWin(String result) {
		if(result.contains("��")){
			System.out.println("dddd");
		}
		return true;
	}
}
