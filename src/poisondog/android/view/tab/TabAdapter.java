/*
 * Copyright (C) 2013 The Android Open Source Project
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
/*******************************
 * Class Name : TabAdapter
 * Create Time : 2014-04-20
 *******************************/
package poisondog.android.view.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import java.util.ArrayList;
import java.util.List;
/**
 * @author poisondog <poisondog@gmail.com>
 */
public class TabAdapter extends FragmentPagerAdapter {
	private List<ActionBarTab> mTabs;
	private ActionBar mActionBar;

	public TabAdapter(final ActionBarActivity activity) {
		super(activity.getSupportFragmentManager());
		mActionBar = activity.getSupportActionBar();

		mTabs = new ArrayList<ActionBarTab>();
		mActionBar.removeAllTabs();
	}

	public void add(ActionBarTab tab, ActionBar.TabListener listener) {
		mTabs.add(tab);
		ActionBar.Tab instance = mActionBar.newTab();
		if(tab.getIconResourceID() > 0)
			instance.setIcon(tab.getIconResourceID());
		if(!tab.getText().isEmpty())
			instance.setText(tab.getText());
		instance.setTabListener(listener);
		mActionBar.addTab(instance);
	}

	public ActionBarTab getTab(int position) {
		return mTabs.get(position);
	}

	@Override
	public int getCount() {
		return mTabs.size();
	}

	@Override
	public Fragment getItem(int position) {
		return mTabs.get(position).createFragment();
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}
}
