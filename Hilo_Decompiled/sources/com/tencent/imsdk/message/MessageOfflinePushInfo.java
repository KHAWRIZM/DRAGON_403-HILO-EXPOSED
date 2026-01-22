package com.tencent.imsdk.message;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageOfflinePushInfo implements Serializable {
    public static final int OFFLINE_APNS_BADGE_MODE_DEFAULT = 0;
    public static final int OFFLINE_APNS_BADGE_MODE_IGNORE = 1;
    public static final int OFFLINE_HARMONY_BADGE_MODE_DEFAULT = 0;
    public static final int OFFLINE_HARMONY_BADGE_MODE_IGNORE = 1;
    public static final int OFFLINE_PUSH_FLAG_DEFAULT = 0;
    public static final int OFFLINE_PUSH_FLAG_NO_PUSH = 1;
    private String description;
    private byte[] extension;
    private int pushFlag;
    private String soundFilePath;
    private String title;
    private APNSOfflinePushInfo apnsConfig = new APNSOfflinePushInfo();
    private AndroidOfflinePushInfo androidConfig = new AndroidOfflinePushInfo();
    private HarmonyOfflinePushInfo harmonyConfig = new HarmonyOfflinePushInfo();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class APNSOfflinePushInfo implements Serializable {
        private int badgeMode;
        private String description;
        private String iOSImageUrl;
        private int iOSPushType = 0;
        private String soundFilePath;
        private String title;

        public APNSOfflinePushInfo() {
        }

        public void setBadgeMode(int i) {
            this.badgeMode = i;
        }

        public void setIOSImageUrl(String str) {
            this.iOSImageUrl = str;
        }

        public void setIOSPushType(int i) {
            this.iOSPushType = i;
        }

        public void setSoundFilePath(String str) {
            this.soundFilePath = str;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class AndroidOfflinePushInfo implements Serializable {
        private String description;
        private String fcmChannelID;
        private String fcmImageUrl;
        private String honorImageUrl;
        private String huaweiCategory;
        private String huaweiImageUrl;
        private int notifyMode;
        private String oppoChannelID;
        private String soundFilePath;
        private String title;
        private String vivoCategory;
        private int vivoClassification = 1;
        private String xiaomiChannelID;

        public AndroidOfflinePushInfo() {
        }

        public void setFCMChannelID(String str) {
            this.fcmChannelID = str;
        }

        public void setFCMImageUrl(String str) {
            this.fcmImageUrl = str;
        }

        public void setHonorImageUrl(String str) {
            this.honorImageUrl = str;
        }

        public void setHuaWeiCategory(String str) {
            this.huaweiCategory = str;
        }

        public void setHuaWeiImageUrl(String str) {
            this.huaweiImageUrl = str;
        }

        public void setOppoChannelID(String str) {
            this.oppoChannelID = str;
        }

        public void setSoundFilePath(String str) {
            this.soundFilePath = str;
        }

        public void setVivoCategory(String str) {
            this.vivoCategory = str;
        }

        public void setVivoClassification(int i) {
            this.vivoClassification = i;
        }

        public void setXiaoMiChannelID(String str) {
            this.xiaomiChannelID = str;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class HarmonyOfflinePushInfo implements Serializable {
        private int badgeMode = 0;
        private String category;
        private String description;
        private String imageUrl;
        private String title;

        public HarmonyOfflinePushInfo() {
        }

        public void setBadgeMode(int i) {
            this.badgeMode = i;
        }

        public void setCategory(String str) {
            this.category = str;
        }

        public void setImageUrl(String str) {
            this.imageUrl = str;
        }
    }

    public AndroidOfflinePushInfo getAndroidConfig() {
        return this.androidConfig;
    }

    public APNSOfflinePushInfo getApnsConfig() {
        return this.apnsConfig;
    }

    public String getDescription() {
        return this.description;
    }

    public byte[] getExtension() {
        return this.extension;
    }

    public HarmonyOfflinePushInfo getHarmonyConfig() {
        return this.harmonyConfig;
    }

    public int getPushFlag() {
        return this.pushFlag;
    }

    public String getSoundFilePath() {
        return this.soundFilePath;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAndroidConfig(AndroidOfflinePushInfo androidOfflinePushInfo) {
        this.androidConfig = androidOfflinePushInfo;
    }

    public void setApnsConfig(APNSOfflinePushInfo aPNSOfflinePushInfo) {
        this.apnsConfig = aPNSOfflinePushInfo;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExtension(byte[] bArr) {
        this.extension = bArr;
    }

    public void setHarmonyConfig(HarmonyOfflinePushInfo harmonyOfflinePushInfo) {
        this.harmonyConfig = harmonyOfflinePushInfo;
    }

    public void setPushFlag(int i) {
        this.pushFlag = i;
    }

    public void setSoundFilePath(String str) {
        this.soundFilePath = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
