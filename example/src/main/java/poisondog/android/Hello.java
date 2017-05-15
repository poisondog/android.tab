package poisondog.android;

import android.app.Activity;
import android.os.Bundle;
import poisondog.android.view.tab.design.TabView;
import poisondog.android.view.tab.design.TabPagerAdapter;
import poisondog.android.view.tab.design.NextPage;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

public class Hello extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main);

		final TabView tab = (TabView)findViewById(R.id.tab);

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
