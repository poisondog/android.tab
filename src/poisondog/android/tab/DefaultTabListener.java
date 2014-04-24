/*******************************
 * Class Name : DefaultTabListener
 * Create Time : 2014-04-20
 *******************************/
package poisondog.android.tab;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
/**
 * @author poisondog <poisondog@gmail.com>
 */
public class DefaultTabListener implements ActionBar.TabListener {
	private ViewPager mPager;

	public DefaultTabListener(ViewPager pager) {
		mPager = pager;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
		mPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
	}
}
