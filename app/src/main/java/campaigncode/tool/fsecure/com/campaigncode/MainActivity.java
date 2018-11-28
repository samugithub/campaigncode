package campaigncode.tool.fsecure.com.campaigncode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

import static campaigncode.tool.fsecure.com.campaigncode.MainActivity.xvalue.*;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    private InstallReferrerReceiver mInstallReferrerReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getTextbyButton();
        changeTextbyButton();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public static class xvalue {
        private int count;
        //private int count;

        public xvalue(int count) {
            this.count = count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }


    public static String text1 = "TEST1";
    public static String text2 = "TextView";
    private static final xvalue obj = new xvalue(1);

    private void changeTextbyButton() {

        // teksti näytöllä mihin tuo uusi teksti laitetaan "TEST1"
        final TextView changeText = (TextView) findViewById(R.id.text1);
        //Tämä on se button ja oma id eli sinulla myinst -> on button1
        final Button changeTextButton = (Button) findViewById(R.id.button1);
        //final int x = 1;
        //new xvalue(1);

        obj.setCount(1);
        //tämä tekee sen actionin ali käskee softaa päivittämään buttonin painalluksesta sen teksti kentän uudella arvolla
        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (obj.getCount() == 1) {
                    obj.setCount(0);

                    changeText.setText(text2);
                } else {
                    obj.setCount(1);
                    changeText.setText(text1);
                }


            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getTextbyButton()
    {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton = (Button)findViewById(R.id.button2);
        final EditText mtokenid = (EditText) findViewById(R.id.editText1);

        mButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Log.v("changeText", mtokenid.getText().toString());
                    }
                });

    }
    public void sendReferral(Context context) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        context.startActivity(Intent.createChooser(sendIntent, text1));

    }

}
