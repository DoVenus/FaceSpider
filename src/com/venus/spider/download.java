package com.venus.spider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;  
 
/*�������������ץȡ����ͼƬ��ַ����ʱ�ļ�����*/
public class download {
	//������ʱ�ļ��洢·��
    private String Tempath="Temp/temp";
    public String DownloadS(String url) {  
    	//��ʼ��ͼƬ��Ϊ��
    	String imageName=null;
        try {   
                imageName = url.substring(url.lastIndexOf("/") + 1, url.length());  
                URL uri = new URL(url);  
                InputStream in = uri.openStream();
                File sf=new File("Temp");  
                //�ж��ļ����Ƿ�����������,�½�һ��
                if(!sf.exists()){  
                    sf.mkdirs();  
                }
                //���ļ����ķ�ʽ�������ʱ�ļ�
                FileOutputStream fo = new FileOutputStream(new File(Tempath));  
                //����ÿ�ζ�ȡ���ֽڴ�С
                byte[] buf = new byte[1024];  
                int length = 0;  
                //��ȡԶ���ļ���д�뵽����
                while ((length = in.read(buf, 0, buf.length)) != -1) {  
                    fo.write(buf, 0, length);  
                }  
             // ��ϣ��ر���������
                in.close();  
                fo.close();  
                return imageName;
        } catch (Exception e) {  
           System.out.println(e);
        } 
        return imageName;
    }  
}
