package com.example.project_fruitexpert;

import java.text.SimpleDateFormat;
import java.util.Random;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

public class GameHandle extends Handler{
	ImageView iv;
	String str;
	TextView tv,tv_allMoney;
	int many,allMoney;
	int[]arr={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10};
	public GameHandle(ImageView iv, TextView tv,TextView tv_allMoney,int many,int allMoney) {
		this.iv = iv;
		this.tv = tv;
		this.tv_allMoney = tv_allMoney;
		this.many = many;
		this.allMoney=allMoney;
	}


	@Override
	public void handleMessage(Message msg) {
		// TODO 自动生成的方法存根
		super.handleMessage(msg);
		str ="";
		SimpleDateFormat dd = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒SSS毫秒");
		str += dd.format(System.currentTimeMillis());
		int i = new Random().nextInt(10);
		iv.setImageResource(arr[i]);
		switch (i) {
		case 1:
		case 2:
		case 0:
			tv.setText("中了一等奖");
			str += "买了"+many+"注，，"+"中了一等奖";
			allMoney = allMoney+many*100;
			tv_allMoney.setText("余额"+allMoney);
			break;
		case 3:
		case 4:
		case 5:
			tv.setText("中了二等奖");
			str += "中了二等奖";
			allMoney = allMoney+many*50;
			tv_allMoney.setText("余额"+allMoney);
			break;
		case 6:
		case 7:
		case 8:
			tv.setText("中了三等奖");
			str += "买了"+many+"注，，"+"中了三等奖";
			allMoney = allMoney+many*20;
			tv_allMoney.setText("余额"+allMoney);
			break;

		default:
			tv.setText("没有中奖。。。");
			str += "买了"+many+"注，，"+"但是没有中奖。。。";
			tv_allMoney.setText("余额"+allMoney);
			break;
		}
		if (DateDate.list.size()==0) {
			DateDate.list.set(0, str);
		}else {
			DateDate.list.add(str);
		}
	}

}
