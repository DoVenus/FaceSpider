package com.venus.spider;

import com.venus.spider.SpiderThead;
import com.venus.spider.webCollector;

public class SpiderThead extends Thread {
	public String Thead;
	public String Deep;
	public String UrlMax;
	public String Target;
	public SpiderThead(String name) {
		// TODO �Զ����ɵĹ��캯�����
		super(name);
	}
	public void run(){
	int T=Integer.valueOf(Thead);
	int D=Integer.valueOf(Deep);
	int UM=Integer.valueOf(UrlMax);
	//ȡ���û�������Ϣ
	webCollector VenusSpider = new webCollector("Venus", true);
    //�����ַ����
    VenusSpider.addSeed(Target);
    VenusSpider.addRegex(".*");
	//���������߳���
    VenusSpider.setThreads(Integer.valueOf(T));
    
    //����ÿ�ε�������ȡ����������
    VenusSpider.setTopN(Integer.valueOf(UM));
    /*�����Ƿ�Ϊ�ϵ���ȡ���������Ϊfalse����������ǰ�������ʷ���ݡ�
       �������Ϊtrue����������crawlPath(���캯���ĵ�һ������)�Ļ����ϼ�
       ����ȡ�����ں�ʱ�ϳ������񣬺ܿ�����Ҫ��;�ж����棬Ҳ�п�������
       �������ϵ���쳣�����ʹ�öϵ���ȡģʽ�����Ա�֤���治����Щ����
       ��Ӱ�죬�����������Ϊ�жϡ��������ϵ��������ֺ󣬼�����ǰ������
       ������ȡ���ϵ���ȡĬ��Ϊfalse*/
    /*----------------------------------------------------------------------------------
    VenusSpider.setResumable(true);
     -----------------------------------------------------------------------------------*/
    /*��ʼ���Ϊ4����ȡ��������Ⱥ���վ�����˽ṹû���κι�ϵ
        ���Խ�������Ϊ����������������������Խ�࣬��ȡ������Խ��*/
    try {
		VenusSpider.start(Integer.valueOf(D));
	} catch (Exception e1) {
		// TODO �Զ����ɵ� catch ��
		e1.printStackTrace();
	}
}
}
