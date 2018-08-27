package poisondog.android;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import poisondog.android.view.tab.design.TabPagerAdapter;
import poisondog.android.view.tab.design.TabView;
import poisondog.core.Mission;

public class Hello extends Activity {
	private boolean mFlag = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main);

		final TabView tab = (TabView)findViewById(R.id.tab);
		Button button = (Button)findViewById(R.id.b1);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mFlag = !mFlag;
				tab.setTabVisibility(mFlag);
			}
		});

//		tab.setSelectedTabIndicatorHeight(0);
		tab.setTabSelectedHandler(new Mission<TabLayout.Tab>() {
			@Override
			public Void execute(TabLayout.Tab tab) {
				View tabView = tab.getCustomView();
				if (tabView != null)
					tabView.setBackgroundColor(0xFF00FF00);
				return null;
			}
		});
		tab.setTabUnselectedHandler(new Mission<TabLayout.Tab>() {
			@Override
			public Void execute(TabLayout.Tab tab) {
				View tabView = tab.getCustomView();
				if (tabView != null)
					tabView.setBackgroundColor(0x00000000);
				return null;
			}
		});

		tab.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrollStateChanged(int state) {
				System.out.println("onPageScrollStateChanged");
			}
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//				System.out.println("onPageScrolled");
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
		tab.setAdapter(adapter);

	}
}
