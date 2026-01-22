package com.alibaba.sdk.android.push.notification;

import android.R;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class BasicCustomPushNotification implements Serializable {
    public static final String CUSTOM_NOTIFICATION_TAG = "custom_notification_";
    public static final int NOTIFICATION_TYPE_CUSTOM_ADVANCED = 3;
    public static final int NOTIFICATION_TYPE_CUSTOM_BASIC = 2;
    public static final int NOTIFICATION_TYPE_DEFAULT = 1;
    public static final int REMIND_TYPE_SILENT = 0;
    public static final int REMIND_TYPE_SOUND = 2;
    public static final int REMIND_TYPE_VIBRATE = 1;
    public static final int REMIND_TYPE_VIBRATE_AND_SOUND = 3;
    protected boolean buildWhenAppInForeground;
    protected int notificationFlags;
    protected int notificationType;
    protected int remindType;
    protected boolean serverOptionFirst;
    protected int statusBarDrawable;

    public BasicCustomPushNotification() {
        this.buildWhenAppInForeground = true;
        this.statusBarDrawable = R.drawable.stat_notify_chat;
        this.remindType = 3;
        this.notificationFlags = 16;
        this.serverOptionFirst = false;
        this.notificationType = 2;
    }

    public int getNotificationFlags() {
        return this.notificationFlags;
    }

    public int getNotificationType() {
        return this.notificationType;
    }

    public int getRemindType() {
        return this.remindType;
    }

    public int getStatusBarDrawable() {
        return this.statusBarDrawable;
    }

    public boolean isBuildWhenAppInForeground() {
        return this.buildWhenAppInForeground;
    }

    public boolean isServerOptionFirst() {
        return this.serverOptionFirst;
    }

    public void setBuildWhenAppInForeground(boolean z10) {
        this.buildWhenAppInForeground = z10;
    }

    public void setNotificationFlags(int i10) {
        this.notificationFlags = i10;
    }

    public void setRemindType(int i10) {
        if (i10 == 0 || 1 == i10 || 2 == i10 || 3 == i10) {
            this.remindType = i10;
        }
    }

    public void setServerOptionFirst(boolean z10) {
        this.serverOptionFirst = z10;
    }

    public void setStatusBarDrawable(int i10) {
        this.statusBarDrawable = i10;
    }

    public String toString() {
        return "type:" + this.notificationType + ", statusBarDrawable:" + this.statusBarDrawable + ", remindType:" + this.remindType + ", flags:" + this.notificationFlags + ", serverOptionFirst:" + this.serverOptionFirst + ", buildWhenAppInForeground:" + isBuildWhenAppInForeground();
    }

    public BasicCustomPushNotification(int i10, int i11, int i12) {
        this.buildWhenAppInForeground = true;
        this.serverOptionFirst = false;
        this.notificationType = 2;
        this.statusBarDrawable = i10;
        this.remindType = i12;
        this.notificationFlags = i11;
    }
}
