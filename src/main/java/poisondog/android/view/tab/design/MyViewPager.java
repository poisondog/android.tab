/*
 * Copyright (C) 2018 Adam Huang <poisondog@gmail.com>
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
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import poisondog.core.Mission;
import poisondog.core.NoMission;

/**
 * @author Adam Huang
 * @since 2018-08-27
 */
public class MyViewPager extends ViewPager {
	private boolean mEnableSwipe = true;
	private Mission<Integer> mHook;

	/**
	 * Constructor
	 */
	public MyViewPager(Context context) {
		super(context);
		init();
	}

	/**
	 * Constructor
	 */
	public MyViewPager(Context context, AttributeSet set) {
		super(context, set);
		init();
	}

	private void init() {
		mHook = new NoMission<Integer>();
		addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrollStateChanged(int state) {
			}
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			}
			@Override
			public void onPageSelected(int position) {
				try {
					mHook.execute(position);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void enableSwipe(boolean flag) {
		mEnableSwipe = flag;
	}

	public Mission<Integer> getHook() {
		return new Hook();
	}

	public void setHook(Mission<Integer> handler) {
		mHook = handler;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		if (!mEnableSwipe) {
			// Never allow swiping to switch between pages
			return false;
		}
		return super.onInterceptTouchEvent(event);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (!mEnableSwipe) {
			// Never allow swiping to switch between pages
			return false;
		}
		return super.onTouchEvent(event);
	}

	@Override
	public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
		throw new IllegalArgumentException("not support thie method");
	}

	private class Hook implements Mission<Integer> {
		@Override
		public Void execute(Integer index) {
			setCurrentItem(index);
			return null;
		}
	}

}
