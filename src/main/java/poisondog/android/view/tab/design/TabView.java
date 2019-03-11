/*
 * Copyright (C) 2017 Adam Huang <poisondog@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package poisondog.android.view.tab.design;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import poisondog.android.tab.R;
import poisondog.core.Mission;
import poisondog.core.NoMission;

/**
 * @author Adam Huang
 * @since 2017-04-19
 */
public class TabView extends LinearLayout {
	private TabLayout mTabLayout;
	private MyViewPager mViewPager;
	private View mRoot;
	private Mission<TabLayout.Tab> mTabSelectedHandler;
	private Mission<TabLayout.Tab> mTabUnselectedHandler;

	/**
	 * Constructor
	 */
	public TabView(Context context) {
		super(context);
		init(context);
	}

	/**
	 * Constructor
	 */
	public TabView(Context context, AttributeSet set) {
		super(context, set);
		init(context);
	}

	public void setTabTop(boolean flag) {
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (flag) {
			mRoot = inflater.inflate(R.layout.tab_top, null, false);
		} else {
			mRoot = inflater.inflate(R.layout.tab_bottom, null, false);
		}
		update();
	}

	public void setSelectedTabIndicatorHeight(int height) {
		mTabLayout.setSelectedTabIndicatorHeight(height);
	}

	public void setTabVisibility(boolean flag) {
		if (flag) {
			mTabLayout.setVisibility(View.VISIBLE);
			mViewPager.enableSwipe(true);
		} else {
			mTabLayout.setVisibility(View.GONE);
			mViewPager.enableSwipe(false);
		}
	}

	private void init(Context context) {
		setTabTop(true);
		mTabSelectedHandler = new NoMission<>();
		mTabUnselectedHandler = new NoMission<>();
		update();
	}

	public void setTabSelectedHandler(Mission<TabLayout.Tab> handler) {
		mTabSelectedHandler = handler;
	}

	public void setTabUnselectedHandler(Mission<TabLayout.Tab> handler) {
		mTabUnselectedHandler = handler;
	}

	private void update() {
		removeAllViews();
		mTabLayout = (TabLayout) mRoot.findViewById(R.id.sliding_tabs);
		mViewPager = (MyViewPager) mRoot.findViewById(R.id.tab_pager);
		mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
		mTabLayout.setupWithViewPager(mViewPager);
		addView(mRoot);

		mTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				super.onTabSelected(tab);
				try {
					mTabSelectedHandler.execute(tab);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
				super.onTabUnselected(tab);
				try {
					mTabUnselectedHandler.execute(tab);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			@Override
			public void onTabReselected(TabLayout.Tab tab) {
				super.onTabReselected(tab);
			}
		});
	}

	public void setAdapter(PagerAdapter adapter) {
		mViewPager.setAdapter(adapter);
		if (!(adapter instanceof TabPagerAdapter))
			return;
		TabPagerAdapter tpa = (TabPagerAdapter) adapter;
		for (int i = 0; i < tpa.getCount(); i++) {
//			mTabLayout.addTab(mTabLayout.newTab().setText(tpa.getPageTitle(i)));
			mTabLayout.getTabAt(i).setCustomView(tpa.get(i).getTitleView());
		}
	}

	public int getCount() {
		return mViewPager.getAdapter().getCount();
	}

	public int getCurrentIndex(){
		return mViewPager.getCurrentItem();
	}

	public void setCurrentIndex(int index) {
		mViewPager.setCurrentItem(index);
	}

	public void addOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
		mViewPager.addOnPageChangeListener(listener);
	}

	public void enableSwipe(boolean flag) {
		mViewPager.enableSwipe(flag);
	}

}
