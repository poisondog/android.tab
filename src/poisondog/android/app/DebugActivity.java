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
package poisondog.android.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
/**
 * @author Adam Huang <poisondog@gmail.com>
 */
public class DebugActivity extends ActionBarActivity {

	public void printClassName() {
		System.out.println("Class name :: " + getClass().getSimpleName());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		printClassName();
		System.out.println("Method name :: onCreate");
	}

	@Override
	public void onAttachFragment(Fragment fragment) {
		super.onAttachFragment(fragment);
		printClassName();
		System.out.println("Method name :: onAttachFragment");
	}

	@Override
	public void onContentChanged() {
		super.onContentChanged();
		printClassName();
		System.out.println("Method name :: onContentChanged");
	}

	@Override
	protected void onStart() {
		super.onStart();
		printClassName();
		System.out.println("Method name :: onStart");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		printClassName();
		System.out.println("Method name :: onRestart");
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		printClassName();
		System.out.println("Method name :: onActivityResult");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		printClassName();
		System.out.println("Method name :: onRestoreInstanceState");
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		printClassName();
		System.out.println("Method name :: onPostCreate");
	}

	@Override
	protected void onResume() {
		super.onResume();
		printClassName();
		System.out.println("Method name :: onResume");
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
		printClassName();
		System.out.println("Method name :: onPostResume");
	}

	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		printClassName();
		System.out.println("Method name :: onAttachedToWindow");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		boolean result = super.onCreateOptionsMenu(menu);
		printClassName();
		System.out.println("Method name :: onCreateOptionsMenu");
		return result;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean result = super.onPrepareOptionsMenu(menu);
		printClassName();
		System.out.println("Method name :: onPrepareOptionsMenu");
		return result;
	}

	@Override
	public void onUserInteraction() {
		super.onUserInteraction();
		printClassName();
		System.out.println("Method name :: onUserInteraction");
	}

	@Override
	protected void onUserLeaveHint() {
		super.onUserLeaveHint();
		printClassName();
		System.out.println("Method name :: onUserLeaveHint");
	}

	@Override
	protected void onPause() {
		super.onPause();
		printClassName();
		System.out.println("Method name :: onPause");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		printClassName();
		System.out.println("Method name :: onSaveInstanceState");
	}

	@Override
	protected void onStop() {
		super.onStop();
		printClassName();
		System.out.println("Method name :: onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		printClassName();
		System.out.println("Method name :: onDestroy");
	}

	@Override
	protected void onTitleChanged(CharSequence title, int color) {
		super.onTitleChanged(title, color);
		printClassName();
		System.out.println("Method name :: onTitleChanged");
	}
}
