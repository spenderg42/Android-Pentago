package edu.harding.AndroidPentago;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class GameActivity extends FragmentActivity {

	private final String LOGTAG = "TTT";

    public boolean mMovingWithinApp = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		boolean PvP = getIntent().getExtras().getBoolean("PvP");
		
		Log.d(LOGTAG, "onCreate - GameActivity");
		
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		
		if (fragment == null) {
			Log.d(LOGTAG, "Creating fragment");
			Bundle args = new Bundle();
			args.putBoolean("PvP", PvP);
			fragment = new GameFragment();
			fragment.setArguments(args);
			fm.beginTransaction()
				.add(R.id.fragmentContainer, fragment)
				.commit();
		}
	}

    @Override
    public void onBackPressed()
    {
        mMovingWithinApp = true;
        super.onBackPressed();
    }

}
