package com.venus.form;

import java.awt.EventQueue;

public class formThead extends Thread {
	
	public formThead(String name) {
		// TODO �Զ����ɵĹ��캯�����
		super(name);
	}
	//�����������߳�
	public static void mainForm(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainform window = new Mainform();
					window.frmVenusspider.setVisible(true);;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void run(){
		mainForm();
	}

}
