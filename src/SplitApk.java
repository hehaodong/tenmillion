import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class SplitApk {

	public SplitApk() {
		// TODO Auto-generated constructor stub
	}
	HashMap<String, String> qudao = new HashMap<String, String>();// �����ţ�������  
    String curPath;// ��ǰ�ļ���·��  
    String apkDirectory;  
  
    public SplitApk(String directory) {  
        this.curPath = new File("").getAbsolutePath();  
        this.apkDirectory = directory;  
    }  
  
    public void mySplit() {  
        File dire = new File(apkDirectory);  
        if (!dire.exists()) {  
            System.out.println("û�и��ļ�");  
            return;  
        }  
  
        if (dire.isDirectory()) {  
            File[] sonFile = dire.listFiles();  
            for (File file : sonFile) {  
                modifyXudao(file.getAbsolutePath());  
            }  
        } else {  
            modifyXudao(apkDirectory);  
        }  
          
        System.out.println("====Over====");  
    }  
  
    /** 
     * apktool��ѹapk���滻����ֵ 
     *  
     * @throws Exception 
     */  
    private void modifyXudao(String apkName) {  
        // ��ѹ /C ִ���ַ���ָ��������Ȼ���ն�  
        String cmdUnpack = "cmd.exe /C java -jar apktool.jar d -f -s "  
                + apkName;  
        runCmd(cmdUnpack);  
  
        String[] apkFilePath = apkName.split("\\\\");  
        String shortApkName = apkFilePath[apkFilePath.length - 1];  
        String dir = shortApkName.split(".apk")[0];  
        File packDir = new File(dir);// ��ý�ѹ��apkĿ¼  
  
        String f_mani = packDir.getAbsolutePath() + "\\AndroidManifest.xml";  
        File manifest = new File(f_mani);  
  
        for (int i = 0; i < 10; i++) {  
            if (manifest.exists()) {  
                break;  
            }  
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
  
        if (!manifest.exists()) {  
            System.out.println("====��֤ʧ��======");  
        }  
  
        /* 
         * ����map������manifese�������޸ĺ�����ǩ�����洢�ڶ�Ӧ�ļ����� 
         */  
        BufferedReader br = null;  
        FileReader fr = null;  
        String keyLine = null;  
        try {  
            fr = new FileReader(manifest);  
            br = new BufferedReader(fr);  
            String line = null;  
            while ((line = br.readLine()) != null) {  
                if (line.contains("\"BaiduMobAd_CHANNEL\"")) { // �ؼ�����===���������õİٶ�ͳ�ƹ���  
                    keyLine = line;  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
            System.out.println("====��֤ʧ��======");  
        } finally {  
            try {  
                if (fr != null) {  
                    fr.close();  
                }  
                if (br != null) {  
                    br.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
  
        if (keyLine != null) {  
            String tmps[] = keyLine.split("\\\"");  
            System.out.println("������������:" + tmps[3]);  
        } else {  
            System.out.println("====��֤ʧ��,��ر�======");  
        }  
  
        // ɾ����;�ļ�  
        String cmdKey = String.format("cmd.exe /C rd /s/q %s", dir);  
        runCmd(cmdKey);  
    }  
  
    /** 
     * ִ��ָ�� 
     *  
     * @param cmd 
     */  
    public void runCmd(String cmd) {  
        Runtime rt = Runtime.getRuntime();  
        BufferedReader br = null;  
        InputStreamReader isr = null;  
        try {  
            Process p = rt.exec(cmd);  
            // p.waitFor();  
            isr = new InputStreamReader(p.getInputStream());  
            br = new BufferedReader(isr);  
            String msg = null;  
            while ((msg = br.readLine()) != null) {  
                System.out.println(msg);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (isr != null) {  
                    isr.close();  
                }  
                if (br != null) {  
                    br.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}
