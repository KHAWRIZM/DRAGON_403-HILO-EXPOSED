package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.qcloud.tuicore.component.RoundCornerImageView;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatPopDataHolder {
    private static final ChatPopDataHolder instance = new ChatPopDataHolder();
    private WeakReference<List<ChatPopActivity.ChatPopMenuAction>> actionList;
    private WeakReference<Bitmap> chatPopBgBitmap;
    private WeakReference<ChatPopActivity.EmojiOnClickListener> emojiOnClickListener;
    private WeakReference<RoundCornerImageView> imageMessageView;
    private Rect messageViewGlobalRect;
    private WeakReference<Drawable> msgAreaBackground;

    private ChatPopDataHolder() {
    }

    public static List<ChatPopActivity.ChatPopMenuAction> getActionList() {
        WeakReference<List<ChatPopActivity.ChatPopMenuAction>> weakReference = instance.actionList;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static Bitmap getChatPopBgBitmap() {
        WeakReference<Bitmap> weakReference = instance.chatPopBgBitmap;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static ChatPopActivity.EmojiOnClickListener getEmojiOnClickListener() {
        WeakReference<ChatPopActivity.EmojiOnClickListener> weakReference = instance.emojiOnClickListener;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static RoundCornerImageView getImageMessageView() {
        WeakReference<RoundCornerImageView> weakReference = instance.imageMessageView;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static Rect getMessageViewGlobalRect() {
        return instance.messageViewGlobalRect;
    }

    public static Drawable getMsgAreaBackground() {
        WeakReference<Drawable> weakReference = instance.msgAreaBackground;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static void setActionList(List<ChatPopActivity.ChatPopMenuAction> list) {
        instance.actionList = new WeakReference<>(list);
    }

    public static void setChatPopBgBitmap(Bitmap bitmap) {
        instance.chatPopBgBitmap = new WeakReference<>(bitmap);
    }

    public static void setEmojiOnClickListener(ChatPopActivity.EmojiOnClickListener emojiOnClickListener) {
        instance.emojiOnClickListener = new WeakReference<>(emojiOnClickListener);
    }

    public static void setImageMessageView(RoundCornerImageView roundCornerImageView) {
        instance.imageMessageView = new WeakReference<>(roundCornerImageView);
    }

    public static void setMessageViewGlobalRect(Rect rect) {
        instance.messageViewGlobalRect = rect;
    }

    public static void setMsgAreaBackground(Drawable drawable) {
        instance.msgAreaBackground = new WeakReference<>(drawable);
    }
}
