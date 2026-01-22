package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.reply;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatReactView extends FrameLayout {
    private static final int EMOJI_LIMIT = 5;
    private ChatReactAdapter adapter;
    private LinearLayoutManager layoutManager;
    private View moreIcon;
    private TextView reactNumText;
    private RecyclerView reactRecyclerView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ChatReactAdapter extends RecyclerView.Adapter<ChatReactViewHolder> {
        private MessageReactBean data;

        ChatReactAdapter() {
        }

        public int getItemCount() {
            MessageReactBean messageReactBean = this.data;
            if (messageReactBean != null) {
                return Math.min(messageReactBean.getReactSize(), 5);
            }
            return 0;
        }

        public void setData(MessageReactBean messageReactBean) {
            this.data = messageReactBean;
        }

        public void onBindViewHolder(ChatReactViewHolder chatReactViewHolder, int i) {
            chatReactViewHolder.faceImageView.setImageBitmap(FaceManager.getEmoji((String) ((Map.Entry) new ArrayList(this.data.getReacts().entrySet()).get(i)).getKey()));
        }

        public ChatReactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ChatReactViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_minimalist_react_item_layout, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ChatReactViewHolder extends RecyclerView.ViewHolder {
        public ImageView faceImageView;

        public ChatReactViewHolder(View view) {
            super(view);
            this.faceImageView = (ImageView) view.findViewById(R.id.face_iv);
        }
    }

    public ChatReactView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.chat_minimalist_react_preview_layout, this);
        this.reactRecyclerView = inflate.findViewById(R.id.reacts_emoji_list);
        this.reactNumText = (TextView) inflate.findViewById(R.id.reacts_num_text);
        this.moreIcon = inflate.findViewById(R.id.more_icon);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.reactRecyclerView.setLayoutManager(this.layoutManager);
        ChatReactAdapter chatReactAdapter = new ChatReactAdapter();
        this.adapter = chatReactAdapter;
        this.reactRecyclerView.setAdapter(chatReactAdapter);
    }

    public void setData(MessageReactBean messageReactBean) {
        Iterator<Set<String>> it = messageReactBean.getReacts().values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().size();
        }
        this.reactNumText.setText(i + "");
        if (i > 5) {
            this.moreIcon.setVisibility(0);
        } else {
            this.moreIcon.setVisibility(8);
        }
        ChatReactAdapter chatReactAdapter = this.adapter;
        if (chatReactAdapter != null) {
            chatReactAdapter.setData(messageReactBean);
            this.adapter.notifyDataSetChanged();
        }
    }

    public ChatReactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public ChatReactView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
