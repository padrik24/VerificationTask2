package com.nn.podrazhanets.verificationtask2;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends SingleFragmentActivity {


    @Override
    protected Fragment getFragment() {
        return MainFragment.newInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.menuSettings:
                showMessage(item.getTitle().toString());
                fragment = getSupportFragmentManager().findFragmentByTag(SettingsFragment.class.getName());
                if(fragment == null || !fragment.isVisible()) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, SettingsFragment.newInstance(), SettingsFragment.class.getName())
                            .addToBackStack(SettingsFragment.class.getName())
                            .commit();
                }
                break;
            case R.id.menuSearch:
                showMessage(item.getTitle().toString());
                fragment = getSupportFragmentManager().findFragmentByTag(SearchFragment.class.getName());
                if(fragment == null || !fragment.isVisible()) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, SearchFragment.newInstance(), SearchFragment.class.getName())
                            .addToBackStack(SearchFragment.class.getName())
                            .commit();
                }
                break;
            case R.id.menuLogout:
                showMessage(item.getTitle().toString());
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
