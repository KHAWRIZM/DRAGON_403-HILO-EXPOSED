package com.oudi.utils;

import android.app.Application;
import android.os.Build;
import android.os.Environment;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class PathUtils {
    private PathUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getDataPath() {
        return Environment.getDataDirectory().getAbsolutePath();
    }

    public static String getDownloadCachePath() {
        return Environment.getDownloadCacheDirectory().getAbsolutePath();
    }

    public static String getExternalAlarmsPath() {
        if (isExternalStorageDisable()) {
            return "";
        }
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS).getAbsolutePath();
    }

    public static String getExternalAppAlarmsPath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getExternalFilesDir(Environment.DIRECTORY_ALARMS).getAbsolutePath();
    }

    public static String getExternalAppCachePath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getExternalCacheDir().getAbsolutePath();
    }

    public static String getExternalAppDataPath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getExternalCacheDir().getParentFile().getAbsolutePath();
    }

    public static String getExternalAppDcimPath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getExternalFilesDir(Environment.DIRECTORY_DCIM).getAbsolutePath();
    }

    public static String getExternalAppDocumentsPath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath();
    }

    public static String getExternalAppDownloadPath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    }

    public static String getExternalAppFilesPath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getExternalFilesDir(null).getAbsolutePath();
    }

    public static String getExternalAppMoviesPath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath();
    }

    public static String getExternalAppMusicPath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getExternalFilesDir(Environment.DIRECTORY_MUSIC).getAbsolutePath();
    }

    public static String getExternalAppNotificationsPath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS).getAbsolutePath();
    }

    public static String getExternalAppObbPath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getObbDir().getAbsolutePath();
    }

    public static String getExternalAppPicturesPath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
    }

    public static String getExternalAppPodcastsPath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getExternalFilesDir(Environment.DIRECTORY_PODCASTS).getAbsolutePath();
    }

    public static String getExternalAppRingtonesPath(Application application) {
        if (isExternalStorageDisable()) {
            return "";
        }
        return application.getExternalFilesDir(Environment.DIRECTORY_RINGTONES).getAbsolutePath();
    }

    public static String getExternalDcimPath() {
        if (isExternalStorageDisable()) {
            return "";
        }
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
    }

    public static String getExternalDocumentsPath() {
        if (isExternalStorageDisable()) {
            return "";
        }
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath();
    }

    public static String getExternalDownloadsPath() {
        if (isExternalStorageDisable()) {
            return "";
        }
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    }

    public static String getExternalMoviesPath() {
        if (isExternalStorageDisable()) {
            return "";
        }
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath();
    }

    public static String getExternalMusicPath() {
        if (isExternalStorageDisable()) {
            return "";
        }
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath();
    }

    public static String getExternalNotificationsPath() {
        if (isExternalStorageDisable()) {
            return "";
        }
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS).getAbsolutePath();
    }

    public static String getExternalPicturesPath() {
        if (isExternalStorageDisable()) {
            return "";
        }
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
    }

    public static String getExternalPodcastsPath() {
        if (isExternalStorageDisable()) {
            return "";
        }
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS).getAbsolutePath();
    }

    public static String getExternalRingtonesPath() {
        if (isExternalStorageDisable()) {
            return "";
        }
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath();
    }

    public static String getExternalStoragePath() {
        if (isExternalStorageDisable()) {
            return "";
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static String getInternalAppCachePath(Application application) {
        return application.getCacheDir().getAbsolutePath();
    }

    public static String getInternalAppCodeCacheDir(Application application) {
        return application.getCodeCacheDir().getAbsolutePath();
    }

    public static String getInternalAppDataPath(Application application) {
        File dataDir;
        if (Build.VERSION.SDK_INT >= 24) {
            dataDir = application.getDataDir();
            return dataDir.getAbsolutePath();
        }
        return application.getApplicationInfo().dataDir;
    }

    public static String getInternalAppDbPath(Application application, String str) {
        return application.getDatabasePath(str).getAbsolutePath();
    }

    public static String getInternalAppDbsPath(Application application) {
        return application.getApplicationInfo().dataDir + "/databases";
    }

    public static String getInternalAppFilesPath(Application application) {
        return application.getFilesDir().getAbsolutePath();
    }

    public static String getInternalAppNoBackupFilesPath(Application application) {
        return application.getNoBackupFilesDir().getAbsolutePath();
    }

    public static String getInternalAppSpPath(Application application) {
        return application.getApplicationInfo().dataDir + "shared_prefs";
    }

    public static String getRootPath() {
        return Environment.getRootDirectory().getAbsolutePath();
    }

    private static boolean isExternalStorageDisable() {
        return !"mounted".equals(Environment.getExternalStorageState());
    }
}
