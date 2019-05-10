/*
 * Copyright (C) 2019 Adam Huang <poisondog@gmail.com>
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

import android.widget.LinearLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import poisondog.core.Mission;
import poisondog.core.NoMission;

/**
 * @author Adam Huang
 * @since 2019-05-10
 */
public class MyTabLayout extends LinearLayout {
	private Mission<View> mTabSelectedHandler;
	private Mission<View> mTabUnselectedHandler;
	private Mission<View> mSelectHandler;
	private Mission<Integer> mHook;
	private int mCurrentIndex;

	/**
	 * Constructor
	 */
	public MyTabLayout(Context context) {
		super(context);
		init();
	}

	/**
	 * Constructor
	 */
	public MyTabLayout(Context context, AttributeSet set) {
		super(context, set);
		init();
	}

	private void init() {
		setOrientation(LinearLayout.HORIZONTAL);
		mTabSelectedHandler = new NoMission<>();
		mTabUnselectedHandler = new NoMission<>();
		mSelectHandler = new NoMission<>();
		mHook = new NoMission<>();
	}

	@Override
	public void addView(View v) {
		LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		p.weight = 1;
		v.setLayoutParams(p);
		v.setOnClickListener(new TabSelectListener());
		super.addView(v);
	}

	public View get(int index) {
		return getChildAt(index);
	}

	public int getCurrentIndex() {
		return mCurrentIndex;
	}

	public Mission<Integer> getHook() {
		return new Hook();
	}

	public void setTabSelectedHandler(Mission<View> handler) {
		mTabSelectedHandler = handler;
	}

	public void setTabUnselectedHandler(Mission<View> handler) {
		mTabUnselectedHandler = handler;
	}

	public void setSelectHandler(Mission<View> handler) {
		mSelectHandler = handler;
	}

	public void setHook(Mission<Integer> handler) {
		mHook = handler;
	}

	private class TabSelectListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			try {
				for(int i = 0; i < getChildCount(); i++) {
					View temp = getChildAt(i);
					if (temp == v) {
						mCurrentIndex = i;
						continue;
					}
					mTabUnselectedHandler.execute(temp);
				}
				mTabSelectedHandler.execute(v);
				mHook.execute(indexOfChild(v));
				mSelectHandler.execute(v);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private class Hook implements Mission<Integer> {
		@Override
		public Void execute(Integer position) {
			get(position).performClick();
			return null;
		}
	}

}
