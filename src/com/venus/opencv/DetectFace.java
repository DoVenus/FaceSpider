package com.venus.opencv;

import java.io.File;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;
//�������opencv�Ա�ѵ����������ʶ��
public class DetectFace {
  public void Start(String path,String imgname) {
//------------------------------------------------------------------------------
/*
*���ļ��õ��ļ�����·��
*/
	//��������ʶ��ѵ����
    File xml=new File("loader/etc/lbpcascades/lbpcascade_frontalface.xml");
    //ȡ����ʱ�ļ�
    File img=new File("Temp/temp");
    String xmlpath=xml.getAbsolutePath();
    String imgpath=img.getAbsolutePath();
//------------------------------------------------------------------------------
    
    
    
//------------------------------------------------------------------------------
    //ȡ��ѵ���Ա�����
    CascadeClassifier faceDetector = new CascadeClassifier(xmlpath);   
    //��ȡopencvͼƬʶ�����
    Mat image = Highgui.imread(imgpath);
    //System.out.println(image);
    //���ضԱ���
    MatOfRect faceDetections = new MatOfRect();
    //��ʼ�ȶ�����
    faceDetector.detectMultiScale(image, faceDetections);
//-------------------------------------------------------------------------------
    //�ȶ���ɺ�Ὣ��������ת�Ƶ���ַ�У�����ַΪ�գ���˵��û������
    //������Ա��ж����������򱣴�
    if (faceDetections.dataAddr()!=0){
    	System.out.println("��������");
    	//�����ļ��洢·����Save�ļ�����
    	String Simg="Save/"+imgname;
    	System.out.println(Simg);
        Highgui.imwrite(Simg, image);
        //ɾ���������ʱ�ļ�
        img.delete();
    }else {
		System.out.println("δ��������");
		img.delete();
	}
  }
}
