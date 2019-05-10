package poisondog.android.view.tab.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import poisondog.android.view.tab.design.TabPagerAdapter;
import poisondog.android.view.tab.design.TabView;
import poisondog.android.view.tab.design.MyTabLayout;
import poisondog.android.view.tab.design.MyViewPager;
import poisondog.core.Mission;
import android.view.ViewGroup;


public class OnlyTab extends Activity {
	private boolean mFlag = true;
	private MyTabLayout mTabLayout;
	private MyViewPager mPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.with_tab);

		mPager = (MyViewPager)findViewById(R.id.content);
		mTabLayout = (MyTabLayout)findViewById(R.id.tabs);
//		mTabLayout.enableSwipe(false);
//		mTabLayout.setSelectedTabIndicatorHeight(0);
		mTabLayout.setTabSelectedHandler(new Mission<View>() {
			@Override
			public Void execute(View v) {
				v.setBackgroundColor(0xFF00FF00);
				return null;
			}
		});
		mTabLayout.setTabUnselectedHandler(new Mission<View>() {
			@Override
			public Void execute(View v) {
				v.setBackgroundColor(0x00000000);
				return null;
			}
		});
		mTabLayout.setHook(mPager.getHook());
		mPager.setHook(mTabLayout.getHook());

		mTabLayout.addView(createButton("b1"));
		mTabLayout.addView(createButton("b2"));
		mTabLayout.addView(createButton("b3"));
		mTabLayout.addView(createButton("b4"));

		TabPagerAdapter adapter = new TabPagerAdapter();
		adapter.add(new ContentTab(getLayoutInflater()));
		adapter.add(new ContentTab(getLayoutInflater()));
		adapter.add(new ContentTab(getLayoutInflater()));
		adapter.add(new ContentTab(getLayoutInflater()));

		mPager.setAdapter(adapter);
		mPager.enableSwipe(false);

		mTabLayout.get(1).setEnabled(false);
		mTabLayout.get(2).setEnabled(false);
	}

	private Button createButton(String name) {
		Button b2 = new Button(this);
		b2.setText(name);
		return b2;
	}
}
