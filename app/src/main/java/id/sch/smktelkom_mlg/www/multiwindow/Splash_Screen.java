package id.sch.smktelkom_mlg.www.multiwindow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {
    Thread threadSplash;
    TextView txtTitle;
    private long ms = 0;
    private long splashTime = 3000;
    private boolean splashAvtive = true;
    private boolean splashPause = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        Thread th = new Thread() {
            public void run() {
                try {
                    while (splashAvtive & ms < splashTime) {
                        if (!splashPause) {
                            ms = ms + 100;
                        }
                        sleep(100);
                    }
                } catch (Exception e) {
                    //TODO : handle exception
                } finally {
                    Intent i = new Intent(Splash_Screen.this, MainActivity.class);
                    startActivity(i);
                }
            }
        };
        th.start();
    }
}
