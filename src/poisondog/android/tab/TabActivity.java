/*******************************
 * Class Name : TabActivity
 * Create Time : 2014-04-20
 *******************************/
package poisondog.android.tab;

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
