package com.example.android.rssfeed;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class RssfeedActivity extends Activity implements MyListFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssfeed);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rssfeed, menu);
        return true;
    }


	@Override
	public void onRssItemSelected(String link) {
		// TODO Auto-generated method stub
		DetailFragment fragment = (DetailFragment) getFragmentManager()
				.findFragmentById(R.id.detailFragment);
		if(fragment != null && fragment.isInLayout()) {
			fragment.setText(link);
		} else {
			Intent intent = new Intent(getApplicationContext(),
					DetailActivity.class);
			intent.putExtra(DetailActivity.EXTRA_URL, link);
			startActivity(intent);
		}
	}
    
}