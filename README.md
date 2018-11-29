# FlipAnimator
两个Fragment上下左右翻转切换动画

`<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <FrameLayout
        android:id="@+id/flBack"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

    <FrameLayout
        android:id="@+id/flFront"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</FrameLayout>`

`@Override protected void onCreate(Bundle savedInstanceState) {
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
	}`
  
  FrontFragment:
  `@Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
	}`
  
  BackFragment:
  `@Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

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
	}`
