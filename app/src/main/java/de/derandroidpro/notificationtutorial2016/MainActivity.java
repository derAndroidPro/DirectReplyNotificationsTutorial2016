package de.derandroidpro.notificationtutorial2016;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent().hasExtra(getString(R.string.NOTIFICATION_ID_KEY))){
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.cancel(getIntent().getIntExtra(getString(R.string.NOTIFICATION_ID_KEY), 0));
        }

        btnNotification = (Button) findViewById(R.id.button);
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNotificationServiceIntent = new Intent(MainActivity.this, NotificationDisplayService.class);
                startService(startNotificationServiceIntent);
            }
        });
    }

}
