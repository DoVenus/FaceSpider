import com.venus.form.*;

public class Main  {
	public static void main(String[] args) throws Exception {
		//����opencv���п�
		System.loadLibrary("opencv_java246");
		//�����������߳�
		formThead formThead=new formThead("MainForm");
		formThead.run();
	}
}