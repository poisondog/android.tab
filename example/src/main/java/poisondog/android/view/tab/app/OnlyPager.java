package poisondog.android.view.tab.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import poisondog.android.view.tab.design.TabPagerAdapter;
import poisondog.android.view.tab.design.MyViewPager;


public class OnlyPager extends Activity {
	private boolean mFlag = true;
	private MyViewPager mPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.with_pager);

		mPager = (MyViewPager) findViewById(R.id.pager);

		mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrollStateChanged(int state) {
				System.out.println("onPageScrollStateChanged");
			}
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				System.out.println("onPageScrolled");
			}
			@Override
			public void onPageSelected(int position) {
				System.out.println("onPageScrolled " + position);
			}
		});

		TabPagerAdapter adapter = new TabPagerAdapter();
		adapter.add(new ContentTab(getLayoutInflater()));
		adapter.add(new ContentTab(getLayoutInflater()));
		adapter.add(new ContentTab(getLayoutInflater()));
		mPager.setAdapter(adapter);
	}
}
