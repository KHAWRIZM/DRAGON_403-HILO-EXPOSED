package com.tencent.imsdk.message;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SoundElement extends MessageBaseElement {
    private int soundBusinessID;
    private String soundDownloadUrl;
    private int soundDuration;
    private String soundFilePath;
    private int soundFileSize;
    private String soundUUID;

    public SoundElement() {
        setElementType(4);
    }

    public int getSoundBusinessID() {
        return this.soundBusinessID;
    }

    public String getSoundDownloadUrl() {
        return this.soundDownloadUrl;
    }

    public int getSoundDuration() {
        return this.soundDuration;
    }

    public String getSoundFilePath() {
        return this.soundFilePath;
    }

    public int getSoundFileSize() {
        return this.soundFileSize;
    }

    public String getSoundUUID() {
        return this.soundUUID;
    }

    public void setSoundDuration(int i) {
        this.soundDuration = i;
    }

    public void setSoundFilePath(String str) {
        this.soundFilePath = str;
    }

    public void setSoundFileSize(int i) {
        this.soundFileSize = i;
    }

    @Override // com.tencent.imsdk.message.MessageBaseElement
    public boolean update(MessageBaseElement messageBaseElement) {
        if (this.elementType == messageBaseElement.elementType) {
            SoundElement soundElement = (SoundElement) messageBaseElement;
            if (this.soundFilePath.equals(soundElement.soundFilePath)) {
                this.soundUUID = soundElement.soundUUID;
                this.soundFileSize = soundElement.soundFileSize;
                this.soundDuration = soundElement.soundDuration;
                this.soundDownloadUrl = soundElement.soundDownloadUrl;
                this.soundBusinessID = soundElement.soundBusinessID;
                return true;
            }
            return false;
        }
        return false;
    }
}
