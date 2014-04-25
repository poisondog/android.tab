/*******************************
 * Class Name : DefaultPageListener
 * Create Time : 2014-04-20
 *******************************/
package poisondog.android.tab;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
/**
 * @author poisondog <poisondog@gmail.com>
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
		mActionBar.setTitle(mAdapter.getTab(position).getTitle());
	}
}
