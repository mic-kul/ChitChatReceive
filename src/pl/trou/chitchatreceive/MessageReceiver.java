package pl.trou.chitchatreceive;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;

public class MessageReceiver extends BroadcastReceiver {

	public static final String CUSTOM_INTENT = "pl.trou.chitchatsend.MESSAGE";

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(CUSTOM_INTENT)) {
			// Toast.makeText(context, "Intent Detected: " +
			// intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
			String message = intent.getStringExtra("msg");

			NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
			Builder mNotifyBuilder = new NotificationCompat.Builder(context).setSmallIcon(R.drawable.ic_launcher)
					.setContentTitle("ChitChat Message").setContentText("You've received new messages.");

			mNotifyBuilder.setContentText(message);

			mNotificationManager.notify(0, mNotifyBuilder.build());
		}
	}
}
