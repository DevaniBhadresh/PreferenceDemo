package com.PrefDemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PrefDemoActivity extends Activity implements OnClickListener {
	
    /** Called when the activity is first created. */
	public static final String PREFS_NAME = "LoginPrefs";

	EditText txtUnm,txtPass;
	Button btnLogin;
	SharedPreferences pref;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtUnm=(EditText)findViewById(R.id.txtUnm);
        txtPass=(EditText)findViewById(R.id.txtPass);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        pref=getSharedPreferences(PREFS_NAME, 0);
        if (pref.getString("logged", "").toString().equals("logged")) {
			Intent intent = new Intent(PrefDemoActivity.this, sec.class);
			startActivity(intent);
		}
        btnLogin.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(txtUnm.getText().toString().equals("bhadresh")&&txtPass.getText().toString().equals("bhadresh"))
        {
			SharedPreferences pref = getSharedPreferences(PREFS_NAME, 0);
			SharedPreferences.Editor editor = pref.edit();
			editor.putString("logged", "logged");
			editor.commit();

			Intent intent = new Intent(PrefDemoActivity.this, sec.class);
			startActivity(intent);
        }
		else
		{
			Toast.makeText(PrefDemoActivity.this, "Invalid User", Toast.LENGTH_LONG).show();
		}
             
	}
}