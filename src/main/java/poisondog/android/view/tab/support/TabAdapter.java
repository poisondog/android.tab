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
package poisondog.android.view.tab.support;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Adam Huang <poisondog@gmail.com>
 */
public class TabAdapter extends FragmentStatePagerAdapter {
	private List<Tab> mTabs;

	public TabAdapter(FragmentManager manager) {
		super(manager);
		mTabs = new ArrayList<Tab>();
	}

	public void add(Tab tab) {
		mTabs.add(tab);
		notifyDataSetChanged();
	}

	public void clear() {
		mTabs.clear();
	}

	public Tab getTab(int position) {
		return mTabs.get(position);
	}

	@Override
	public int getCount() {
		return mTabs.size();
	}

	@Override
	public Fragment getItem(int position) {
		return mTabs.get(position).getContent();
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}
}
