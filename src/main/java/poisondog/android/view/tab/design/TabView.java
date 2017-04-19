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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.util.AttributeSet;

/**
 * @author Adam Huang
 * @since 2017-04-19
 */
public class TabView extends LinearLayout {
	private TabLayout mTabs;
	private ViewPager mViewPager;

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

	private void init(Context context) {
		setOrientation(VERTICAL);
		mTabs = new TabLayout(context);
		mViewPager = new ViewPager(context);
		mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabs));
		addView(mTabs);
		addView(mViewPager);
	}

	public void setAdapter(PagerAdapter adapter) {
		for (int i = 0; i < adapter.getCount(); i++) {
			mTabs.addTab(mTabs.newTab().setText(adapter.getPageTitle(i)));
		}
		mViewPager.setAdapter(adapter);
	}
}
