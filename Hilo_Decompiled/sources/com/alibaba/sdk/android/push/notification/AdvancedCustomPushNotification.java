package com.alibaba.sdk.android.push.notification;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdvancedCustomPushNotification extends BasicCustomPushNotification {
    private final int mContentView;
    private int mIcon = 0;
    private final int mIconView;
    private final int mNotificationView;
    private final int mTitleView;

    public AdvancedCustomPushNotification(int i10, int i11, int i12, int i13) {
        this.notificationType = 3;
        this.mNotificationView = i10;
        this.mTitleView = i12;
        this.mIconView = i11;
        this.mContentView = i13;
    }

    public int getContentView() {
        return this.mContentView;
    }

    public int getIcon() {
        return this.mIcon;
    }

    public int getIconView() {
        return this.mIconView;
    }

    public int getNotificationView() {
        return this.mNotificationView;
    }

    public int getTitleView() {
        return this.mTitleView;
    }

    public void setIcon(int i10) {
        this.mIcon = i10;
    }

    @Override // com.alibaba.sdk.android.push.notification.BasicCustomPushNotification
    public String toString() {
        return super.toString() + ", notificationView:" + this.mNotificationView + ", titleView:" + this.mTitleView + ", iconView:" + this.mTitleView + ", contentView:" + this.mContentView;
    }
}
