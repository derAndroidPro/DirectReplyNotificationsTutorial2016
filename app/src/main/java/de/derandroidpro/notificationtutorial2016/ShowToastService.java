package de.derandroidpro.notificationtutorial2016;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ShowToastService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Dieser Toast wurde über eine Notification Action gestartet", Toast.LENGTH_SHORT).show();
        if(intent.hasExtra(getString(R.string.NOTIFICATION_ID_KEY))){
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.cancel(intent.getIntExtra(getString(R.string.NOTIFICATION_ID_KEY), 0));
        }
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
}
