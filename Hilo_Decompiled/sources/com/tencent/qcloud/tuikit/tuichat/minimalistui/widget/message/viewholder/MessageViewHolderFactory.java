package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.MinimalistUIService;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.ICommonMessageAdapter;
import java.lang.reflect.InvocationTargetException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageViewHolderFactory {
    public static RecyclerView.ViewHolder getInstance(ViewGroup viewGroup, ICommonMessageAdapter iCommonMessageAdapter, int i) {
        View inflate;
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i == -99) {
            return new MessageHeaderHolder(from.inflate(R.layout.loading_progress_bar, viewGroup, false));
        }
        if (i == MinimalistUIService.getInstance().getViewType(TipsMessageBean.class)) {
            inflate = from.inflate(R.layout.message_adapter_item_empty, viewGroup, false);
            viewHolder = new TipsMessageHolder(inflate);
        } else {
            inflate = from.inflate(R.layout.minimalist_message_adapter_item_content, viewGroup, false);
            viewHolder = getViewHolder(inflate, i);
        }
        if (viewHolder == null) {
            viewHolder = new TextMessageHolder(inflate);
        }
        ((MessageBaseHolder) viewHolder).setAdapter(iCommonMessageAdapter);
        return viewHolder;
    }

    private static RecyclerView.ViewHolder getViewHolder(View view, int i) {
        Class<? extends MessageBaseHolder> messageViewHolderClass = MinimalistUIService.getInstance().getMessageViewHolderClass(i);
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
