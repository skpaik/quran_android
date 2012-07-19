package com.quran.labs.androidquran;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class HelpActivity extends SherlockActivity implements OnClickListener {
	protected Button mEmailButton;
	protected TextView mHelpText;

	public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Sherlock);
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.help);
        mEmailButton = (Button)findViewById(R.id.btnEmailUs);
        mEmailButton.setOnClickListener(this);

        mHelpText = (TextView)findViewById(R.id.txtHelp);
        mHelpText.setText(Html.fromHtml(getString(R.string.help)));
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnEmailUs:
         Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
         emailIntent.setType("plain/text");
         emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                 getString(R.string.email_subject));
         emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                 new String[] { getString(R.string.email_to) });
         startActivity(Intent.createChooser(emailIntent,
                 getString(R.string.send_email)));
			break;
		default:
			break;
		}		
	}

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      if (item.getItemId() == android.R.id.home){
         finish();
         return true;
      }
      return false;
   }
}
