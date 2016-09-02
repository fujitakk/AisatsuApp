package jp.techacademy.kaori.fujita.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	TextView mTextView;
	Integer hourofday;
	Integer minuteview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);

		mTextView = (TextView) findViewById(R.id.textView);

	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.button1) {
			showTimePickerDialog();
		}
	}

	private void showTimePickerDialog() {
		TimePickerDialog timePickerDialog = new TimePickerDialog(this,
				new TimePickerDialog.OnTimeSetListener() {
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						hourofday = hourOfDay;
						minuteview = minute;

						if(hourofday >= 2 && hourofday <= 9)
						{
							mTextView.setText("おはよう");
						}
						else if(hourofday >= 10 && hourofday <= 17)
						{
							mTextView.setText("こんにちは");
						}
						else
						{
							mTextView.setText("こんばんは");
						}
					}
				},
				13, // 初期値（時間）
				0,  // 初期値（分）
				true);
		timePickerDialog.show();

	}


}
