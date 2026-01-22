package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.ClassicUIService;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ICommonMessageAdapter;
import java.lang.reflect.InvocationTargetException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageViewHolderFactory {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static RecyclerView.ViewHolder getInstance(ViewGroup viewGroup, ICommonMessageAdapter iCommonMessageAdapter, int i) {
        View inflate;
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i == -99) {
            return new MessageHeaderHolder(from.inflate(R.layout.loading_progress_bar, viewGroup, false));
        }
        if (i == ClassicUIService.getInstance().getViewType(TipsMessageBean.class)) {
            inflate = from.inflate(R.layout.message_adapter_item_empty, viewGroup, false);
            viewHolder = new TipsMessageHolder(inflate);
        } else if (ClassicUIService.getInstance().checkHiloViewType(i)) {
            if (ClassicUIService.getInstance().checkGroupViewType(i)) {
                if (ClassicUIService.getInstance().checkCustomizeViewType(i)) {
                    inflate = from.inflate(R.layout.message_adapter_item_empty, viewGroup, false);
                } else {
                    inflate = from.inflate(R.layout.message_adapter_room_item_content, viewGroup, false);
                }
            } else if (ClassicUIService.getInstance().checkCustomizeViewType(i)) {
                inflate = from.inflate(R.layout.message_adapter_item_empty, viewGroup, false);
            } else {
                inflate = from.inflate(R.layout.message_adapter_item_content, viewGroup, false);
            }
            try {
                viewHolder = getViewHolder(inflate, i);
                if (viewHolder != null) {
                    try {
                        ((MessageBaseHolder) viewHolder).setAdapter(iCommonMessageAdapter);
                        return viewHolder;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (viewHolder == null) {
                        }
                        ((MessageBaseHolder) viewHolder).setAdapter(iCommonMessageAdapter);
                        return viewHolder;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                viewHolder = null;
            }
        } else {
            inflate = from.inflate(R.layout.message_adapter_item_content, viewGroup, false);
            viewHolder = getViewHolder(inflate, i);
        }
        if (viewHolder == null) {
            viewHolder = new TextMessageHolder(inflate);
        }
        ((MessageBaseHolder) viewHolder).setAdapter(iCommonMessageAdapter);
        return viewHolder;
    }

    private static RecyclerView.ViewHolder getViewHolder(View view, int i) {
        Class<? extends MessageBaseHolder> messageViewHolderClass = ClassicUIService.getInstance().getMessageViewHolderClass(i);
        if (messageViewHolderClass != null) {
            try {
                return messageViewHolderClass.getConstructor(View.class).newInstance(view);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
