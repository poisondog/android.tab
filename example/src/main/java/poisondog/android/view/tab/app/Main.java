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
package poisondog.android.view.tab.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
	}

	public void openTabAndPager(View v) {
		Intent intent = new Intent(this, TabAndPager.class);
		startActivity(intent);
	}

	public void openPager(View v) {
		Intent intent = new Intent(this, OnlyPager.class);
		startActivity(intent);
	}

	public void openTab(View v) {
		Intent intent = new Intent(this, OnlyTab.class);
		startActivity(intent);
	}

}
