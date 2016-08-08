package com.venus.spider;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import java.io.File;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.venus.opencv.*;
//��������������������ȡ��ʽ�ͶԱ�ʶ��
public class webCollector extends BreadthCrawler {

	public webCollector(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
	}

	@Override
	public void visit(Page page, CrawlDatums venus) {
		String imgsrc;
		page.getUrl();
		Document doc = page.doc();
		Elements img = doc.getElementsByTag("img");
		download VenusImg = new download();
		DetectFace check = new DetectFace();
		//�жϴ洢·���Ƿ�����������ھ��½�һ��
		File sf=new File("Save");
		if(!sf.exists()){  
            sf.mkdirs();  
        }
		for (Element x : img) {
			//ÿһ�θ�ֵ������ѡ����ѡ��DOM��SRC����
			imgsrc = (String) x.attr("src");
			// ����ȡ������ͼƬ��ַ����download������ʱ�ļ�
			String imgname = VenusImg.DownloadS(imgsrc);
			//���ļ�����Ϊ�����ж��Ƿ�����������opencv�����������ļ�
			if (imgname != null) {
				check.Start("Save", imgname);
			}else {
				System.out.println("ͼƬ��ȱʧ");
			}
		}
	}
}
