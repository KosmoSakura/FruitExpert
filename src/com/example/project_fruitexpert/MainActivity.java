package com.example.project_fruitexpert;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
		
	public void myClick(View v){
		switch (v.getId()) {
		case R.id.btn_record:
			Intent in = new Intent();
			in.setClass(MainActivity.this,Record.class);
			startActivity(in);
			break;
		case R.id.btn_enterGame:
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, Game.class);
			startActivity(intent);
			break;
		}
	}
	
}
