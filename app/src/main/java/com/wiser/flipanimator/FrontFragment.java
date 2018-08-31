package com.wiser.flipanimator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wiser.flip.FlipManage;

public class FrontFragment extends Fragment {

	private TextView tvFront;

	@Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frg_front, container, false);
		view.setClickable(true);
		tvFront = view.findViewById(R.id.tv_front);
		// 必须绑定点击的View 否则会出现快速多次点击动画显示问题
		FlipManage.with().bindFrontClickView(tvFront);
        tvFront.setOnClickListener(new View.OnClickListener() {

			@Override public void onClick(View view) {
				// 启动翻转动画
				// FlipManage.with().startFlipAnimLR();
				FlipManage.with().startFlipAnimTB();
			}
		});
		return view;
	}

}
