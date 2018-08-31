package com.wiser.flipanimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.wiser.flip.FlipManage;

public class MainActivity extends AppCompatActivity {

	private FrameLayout	flFront;

	private FrameLayout	flBack;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		flFront = findViewById(R.id.flFront);
		flBack = findViewById(R.id.flBack);

		// 创建View必须绑定管理器
		FlipManage.bind(this, flFront, flBack);

		getSupportFragmentManager().beginTransaction().replace(R.id.flFront, new FrontFragment()).commit();
		getSupportFragmentManager().beginTransaction().replace(R.id.flBack, new BackFragment()).commit();
	}

	@Override protected void onDestroy() {
		FlipManage.with().destroyFlipManage();
		super.onDestroy();
	}
}
