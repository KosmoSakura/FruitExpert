package com.example.project_fruitexpert;

import android.os.Message;


public class GameRun implements Runnable{
	GameHandle handle;
	
	
	public GameRun(GameHandle handle) {
		this.handle = handle;
	}


	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				return;
			}
			handle.sendEmptyMessage(0);
		}
	}
}
