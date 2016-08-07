package com.example.project_fruitexpert;




import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;

public class Record extends Activity {
	ListView lv;
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_record);
		lv = (ListView) findViewById(R.id.lv);
		if (DateDate.list.size()==0) {
			DateDate.list.add("不知道怎么传数据讷。。。");
		}
		adapter = new ArrayAdapter<String>(Record.this, R.layout.arrayadapter, R.id.hahahaha, DateDate.list);
		lv.setAdapter(adapter);
		
	}
}
