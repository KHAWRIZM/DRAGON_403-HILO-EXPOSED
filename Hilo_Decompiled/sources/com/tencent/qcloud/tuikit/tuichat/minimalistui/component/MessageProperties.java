package com.tencent.qcloud.tuikit.tuichat.minimalistui.component;

import android.graphics.drawable.Drawable;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageProperties implements IMessageProperties {
    private static MessageProperties sP = new MessageProperties();
    private int[] avatarSize = null;
    private int mAvatarId;
    private int mAvatarRadius;
    private int mChatContextFontSize;
    private Drawable mChatTimeBubble;
    private int mChatTimeFontColor;
    private int mChatTimeFontSize;
    private Drawable mFriendBubble;
    private int mFriendChatContentFontColor;
    private int mLeftNameVisibility;
    private Drawable mMyBubble;
    private int mMyChatContentFontColor;
    private int mNameFontColor;
    private int mNameFontSize;
    private int mRightNameVisibility;
    private Drawable mTipsMessageBubble;
    private int mTipsMessageFontColor;
    private int mTipsMessageFontSize;

    private MessageProperties() {
    }

    public static MessageProperties getInstance() {
        if (sP == null) {
            sP = new MessageProperties();
        }
        return sP;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getAvatar() {
        return this.mAvatarId;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getAvatarRadius() {
        return this.mAvatarRadius;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int[] getAvatarSize() {
        return this.avatarSize;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getChatContextFontSize() {
        return this.mChatContextFontSize;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public Drawable getChatTimeBubble() {
        return this.mChatTimeBubble;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getChatTimeFontColor() {
        return this.mChatTimeFontColor;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getChatTimeFontSize() {
        return this.mChatTimeFontSize;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public Drawable getLeftBubble() {
        return this.mFriendBubble;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getLeftChatContentFontColor() {
        return this.mFriendChatContentFontColor;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getLeftNameVisibility() {
        return this.mLeftNameVisibility;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getNameFontColor() {
        return this.mNameFontColor;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getNameFontSize() {
        return this.mNameFontSize;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public Drawable getRightBubble() {
        return this.mMyBubble;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getRightChatContentFontColor() {
        return this.mMyChatContentFontColor;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getRightNameVisibility() {
        return this.mRightNameVisibility;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public Drawable getTipsMessageBubble() {
        return this.mTipsMessageBubble;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getTipsMessageFontColor() {
        return this.mTipsMessageFontColor;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getTipsMessageFontSize() {
        return this.mTipsMessageFontSize;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setAvatar(int i) {
        this.mAvatarId = i;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setAvatarRadius(int i) {
        this.mAvatarRadius = ScreenUtil.getPxByDp(i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setAvatarSize(int[] iArr) {
        if (iArr != null && iArr.length == 2) {
            this.avatarSize = r0;
            int[] iArr2 = {ScreenUtil.getPxByDp(iArr[0])};
            this.avatarSize[1] = ScreenUtil.getPxByDp(iArr[1]);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setChatContextFontSize(int i) {
        this.mChatContextFontSize = i;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setChatTimeBubble(Drawable drawable) {
        this.mChatTimeBubble = drawable;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setChatTimeFontColor(int i) {
        this.mChatTimeFontColor = i;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setChatTimeFontSize(int i) {
        this.mChatTimeFontSize = i;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setLeftBubble(Drawable drawable) {
        this.mFriendBubble = drawable;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setLeftChatContentFontColor(int i) {
        this.mFriendChatContentFontColor = i;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setLeftNameVisibility(int i) {
        this.mLeftNameVisibility = i;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setNameFontColor(int i) {
        this.mNameFontColor = i;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setNameFontSize(int i) {
        this.mNameFontSize = i;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setRightBubble(Drawable drawable) {
        this.mMyBubble = drawable;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setRightChatContentFontColor(int i) {
        this.mMyChatContentFontColor = i;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setRightNameVisibility(int i) {
        this.mRightNameVisibility = i;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setTipsMessageBubble(Drawable drawable) {
        this.mTipsMessageBubble = drawable;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setTipsMessageFontColor(int i) {
        this.mTipsMessageFontColor = i;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setTipsMessageFontSize(int i) {
        this.mTipsMessageFontSize = i;
    }
}
