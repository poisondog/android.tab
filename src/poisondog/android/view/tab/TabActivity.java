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
 * Class Name : TabActivity
 * Create Time : 2014-04-20
 *******************************/
package poisondog.android.view.tab;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
/**
 * @author poisondog <poisondog@gmail.com>
 */
public class TabActivity extends ActionBarActivity {
	private int mMenuResourceID;

	public void setMenuResourceID(int id) {
		mMenuResourceID = id;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if(mMenuResourceID > 0) {
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(mMenuResourceID, menu);
		}
		return super.onCreateOptionsMenu(menu);
	}
}
