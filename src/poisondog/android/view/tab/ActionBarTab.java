// 2014-01-14
/*******************************
 * ActionBarTab
 *******************************/
package poisondog.android.view.tab;

import android.support.v4.app.Fragment;
/**
 * @author poisondog <poisondog@gmail.com>
 */
public interface ActionBarTab {
	public Fragment createFragment();
	public int getMenuResourceID();
	public int getIconResourceID();
	public String getText();
	public String getTitle();
	public void updateContent();
}
