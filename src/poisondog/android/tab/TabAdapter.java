/*******************************
 * Class Name : TabAdapter
 * Create Time : 2014-04-20
 *******************************/
package poisondog.android.tab;

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
