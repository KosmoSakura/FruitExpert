package com.example.project_fruitexpert;

/**
 * 每一注5元钱
 * 
 * */
import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class Game extends Activity {
	Button btn_startGame;
	EditText edt_money, tv_many;
	Thread th;
	ImageView iv_fruilts;
	TextView tv_allMoney, tv_result;
	int add, many;// many是所卖的注数，add是充值的内容。
	int allMoney = 100;// 总共的余额

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		tv_allMoney = (TextView) findViewById(R.id.tv_allMoney);
		btn_startGame = (Button) findViewById(R.id.btn_startGame);
		tv_result = (TextView) findViewById(R.id.tv_result);
		tv_many = (EditText) findViewById(R.id.tv_many);
		iv_fruilts = (ImageView) findViewById(R.id.iv_fruilts);
		tv_allMoney.setText("余额：" + allMoney);

	}

	public void myClick(View v) {
		switch (v.getId()) {
		case R.id.btn_addMoney:// 充值
			AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
			LayoutInflater lay = LayoutInflater.from(Game.this);
			View view = lay.inflate(R.layout.dialog, null);
			Button btn_add = (Button) view.findViewById(R.id.btn_add);
			edt_money = (EditText) view.findViewById(R.id.edt_money);
			btn_add.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					add = Integer.parseInt(edt_money.getText() + "");
					add = add + 1;
					edt_money.setText(add + "");
				}
			});
			Button btn_cut = (Button) view.findViewById(R.id.btn_cut);
			btn_cut.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					add = Integer.parseInt(edt_money.getText() + "");
					if (add > 0) {
						add = add - 1;
					} else {
						add = 0;
						Toast.makeText(Game.this, "充值不能小于零", Toast.LENGTH_SHORT)
								.show();
					}
					edt_money.setText(add + "");
				}
			});
			builder.setCancelable(false);
			builder.setPositiveButton("完成",
					new android.content.DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(Game.this, "已充值", Toast.LENGTH_SHORT)
									.show();
							allMoney = allMoney
									+ Integer.parseInt(edt_money.getText() + "");
							tv_allMoney.setText("余额：" + allMoney);
						}
					});
			add = 0;
			builder.setTitle("请充值");
			builder.setView(view);
			builder.show();
			break;
		case R.id.btn_startGame:// 开始游戏
			many = Integer.parseInt("0" + tv_many.getText() + "");
			if (many > 0) {
				allMoney = allMoney - many * 5;
				if (allMoney < 0) {
					Toast.makeText(Game.this, "余额不足", Toast.LENGTH_SHORT)
							.show();
				} else if (allMoney >= 0) {
					tv_allMoney.setText("余额：" + allMoney);
					btn_startGame.setText("结束");
					tv_result.setText("开奖中..");
					GameRun run = new GameRun(new GameHandle(iv_fruilts,
							tv_result, tv_allMoney, many, allMoney));
					th = new Thread(run);
					th.start();
					btn_startGame.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							btn_startGame.setText("开始");
							th.interrupt();
							
						}
					});
				}
			} else {
				Toast.makeText(Game.this, "对不起，注数不能小于1", Toast.LENGTH_SHORT)
						.show();
			}
			break;
		}
	}

}
