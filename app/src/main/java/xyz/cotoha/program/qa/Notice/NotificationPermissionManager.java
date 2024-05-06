package xyz.cotoha.program.qa.Notice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import androidx.core.app.NotificationManagerCompat;

public class NotificationPermissionManager {

    public static final int REQUEST_CODE = 200;

    public static boolean areNotificationsEnabled(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public static void openNotificationSettingsForApp(Activity activity) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, activity.getPackageName());
        activity.startActivityForResult(intent, REQUEST_CODE);
    }
}
