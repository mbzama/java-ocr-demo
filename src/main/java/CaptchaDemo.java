import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class CaptchaDemo {
	public static String PATH = "/home/zama/learning/captcha/1.png";
	//public static String PATH = "1.jpg";
	
	public static void main(String[] args) {
		File file = new File(PATH);
		System.out.println("File loaded: "+file.getAbsolutePath());
		System.out.println("file.exists(): "+file.exists());
		
		ITesseract instance = new Tesseract();
	    //instance.setLanguage("eng");

		String imgtext;
		try {
			if (file.exists()) {
				imgtext = instance.doOCR(file);
				System.out.println(imgtext);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
