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

public class BackFragment extends Fragment {

	private TextView tvBack;

	@Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.frg_back, container, false);
		view.setClickable(true);
        tvBack = view.findViewById(R.id.tv_back);
		// 必须绑定点击的View 否则会出现快速多次点击动画显示问题
		FlipManage.with().bindBackClickView(tvBack);
        tvBack.setOnClickListener(new View.OnClickListener() {

			@Override public void onClick(View view) {
				//启动翻转动画
//				FlipManage.with().startFlipAnimLR();
				FlipManage.with().startFlipAnimTB();
			}
		});
		return view;
	}

}
