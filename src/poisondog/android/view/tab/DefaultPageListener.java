/*
 * Copyright (C) 2014 Adam Huang
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
package poisondog.android.view.tab;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
/**
 * @author Adam Huang <poisondog@gmail.com>
 */
public class DefaultPageListener extends ViewPager.SimpleOnPageChangeListener {
	private TabActivity mActivity;
	private TabAdapter mAdapter;
	private ActionBar mActionBar;

	public DefaultPageListener(TabActivity activity, TabAdapter adapter) {
		mActivity = activity;
		mAdapter = adapter;
		mActionBar = activity.getSupportActionBar();
	}

	@Override
	public void onPageScrolled (int position, float positionOffset, int positionOffsetPixels){
		mActivity.setMenuResourceID(mAdapter.getTab(position).getMenuResourceID());
		mActivity.supportInvalidateOptionsMenu();
	}

	@Override
	public void onPageSelected (int position) {
		mActionBar.setSelectedNavigationItem(position);
		ActionBarTab tab = mAdapter.getTab(position);
		if(!tab.getTitle().isEmpty())
			mActionBar.setTitle(tab.getTitle());
//		tab.updateContent();
	}

	@Override
	public void onPageScrollStateChanged (int state) {
	}
}
