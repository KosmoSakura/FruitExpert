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
				// TODO 自动生成的 catch 块
				return;
			}
			handle.sendEmptyMessage(0);
		}
	}
}
