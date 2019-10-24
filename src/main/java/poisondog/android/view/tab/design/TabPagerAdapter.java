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

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Adam Huang
 * @since 2017-04-19
 */
public class TabPagerAdapter extends PagerAdapter {
	private List<Tab> mList;

	/**
	 * Constructor
	 */
	public TabPagerAdapter() {
		mList = new LinkedList<Tab>();
	}

	public void add(Tab tab) {
		mList.add(tab);
	}

	public Tab get(int index) {
		return mList.get(index);
	}

	public void clear() {
		for (Tab tab : mList) {
			((ViewGroup)tab.getContent().getParent()).removeView(tab.getContent());
		}
		mList.clear();
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object o) {
		return o == view;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return mList.get(position).getTitle();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = mList.get(position).getContent();
		container.addView(view);
		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

}
