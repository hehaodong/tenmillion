/** * °´Å¥ÖØ¸´µã»÷ * * */
public class BtnClickUtils {
	private BtnClickUtils() {
	}

	public static boolean isFastDoubleClick() {
		long time = System.currentTimeMillis();
		long timeD = time - mLastClickTime;
		if (0 < timeD && timeD < 1000) {
			return true;
		}
		mLastClickTime = time;
		return false;
	}

	private static long mLastClickTime = 0;
}