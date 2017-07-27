
public class Suanfa {

	public Suanfa() {
		// TODO Auto-generated constructor stub
	}
	private static String[] results = {"Êó,Êó, Å£, Éß, Áú, Âí, ¼¦","Ñò,Êó, Ñò, ¹·, Áú, ºï, Âí","Áú,Öí, »¢, Ñò, Âí, Éß, ºï"};
	/**
	 * @param args
	 * @Description 
	 * @return void
	 * @date£º 2016-12-29 ÏÂÎç4:55:48
	 * @author:   	hehaodong
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Suanfa fa = new Suanfa();
		fa.isWin(results[0]);
	}
	
	private String buyType = "Êó";
	private boolean isWin(String result) {
		if(result.contains("Êó")){
			System.out.println("dddd");
		}
		return true;
	}
}
