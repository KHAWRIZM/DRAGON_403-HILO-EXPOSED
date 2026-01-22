package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.tuichat.bean.ReactUserBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatFlowReactView extends RecyclerView {
    private ChatFlowReactAdapter adapter;
    private ChatFlowReactLayoutManager layoutManager;
    private int themeColorId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ChatFlowReactAdapter extends RecyclerView.Adapter<ChatFlowReactViewHolder> {
        private MessageReactBean data;
        private ReactOnClickListener reactOnClickListener;
        private int themeColorId;

        ChatFlowReactAdapter() {
        }

        private String formatDisplayUserName(Set<String> set) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = set.iterator();
            int i = 0;
            while (it.hasNext()) {
                sb2.append(getUserDisplayName(it.next()));
                i++;
                if (i != set.size()) {
                    sb2.append("、");
                }
            }
            return sb2.toString();
        }

        private String getUserDisplayName(String str) {
            if (this.data.getReactUserBeanMap() == null) {
                return str;
            }
            ReactUserBean reactUserBean = this.data.getReactUserBeanMap().get(str);
            if (reactUserBean == null) {
                return str;
            }
            return reactUserBean.getDisplayString();
        }

        public int getItemCount() {
            MessageReactBean messageReactBean = this.data;
            if (messageReactBean != null) {
                return messageReactBean.getReactSize();
            }
            return 0;
        }

        public void setData(MessageReactBean messageReactBean) {
            this.data = messageReactBean;
        }

        public void setReactOnClickListener(ReactOnClickListener reactOnClickListener) {
            this.reactOnClickListener = reactOnClickListener;
        }

        public void setThemeColorId(int i) {
            this.themeColorId = i;
        }

        public void onBindViewHolder(ChatFlowReactViewHolder chatFlowReactViewHolder, int i) {
            Map.Entry entry = (Map.Entry) new ArrayList(this.data.getReacts().entrySet()).get(i);
            final String str = (String) entry.getKey();
            Set<String> set = (Set) entry.getValue();
            chatFlowReactViewHolder.faceImageView.setImageBitmap(FaceManager.getEmoji(str));
            chatFlowReactViewHolder.faceImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ChatFlowReactView.ChatFlowReactAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ChatFlowReactAdapter.this.reactOnClickListener != null) {
                        ChatFlowReactAdapter.this.reactOnClickListener.onClick(str);
                    }
                }
            });
            if (this.themeColorId != 0) {
                TextView textView = chatFlowReactViewHolder.userTextView;
                textView.setTextColor(textView.getResources().getColor(this.themeColorId));
                TextView textView2 = chatFlowReactViewHolder.userTextView;
                textView2.setTextColor(textView2.getResources().getColor(this.themeColorId));
            } else {
                TextView textView3 = chatFlowReactViewHolder.userTextView;
                Resources resources = textView3.getResources();
                Context context = chatFlowReactViewHolder.userTextView.getContext();
                int i2 = R.attr.chat_react_text_color;
                textView3.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, i2)));
                TextView textView4 = chatFlowReactViewHolder.userTextView;
                textView4.setTextColor(textView4.getResources().getColor(TUIThemeManager.getAttrResId(chatFlowReactViewHolder.userTextView.getContext(), i2)));
            }
            chatFlowReactViewHolder.userTextView.setText(formatDisplayUserName(set));
        }

        public ChatFlowReactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ChatFlowReactViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_flow_react_item_layout, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ChatFlowReactViewHolder extends RecyclerView.ViewHolder {
        public ImageView faceImageView;
        public TextView userTextView;

        public ChatFlowReactViewHolder(View view) {
            super(view);
            this.userTextView = (TextView) view.findViewById(R.id.users_tv);
            this.faceImageView = (ImageView) view.findViewById(R.id.face_iv);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface ReactOnClickListener {
        void onClick(String str);
    }

    public ChatFlowReactView(Context context) {
        super(context);
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        ChatFlowReactLayoutManager chatFlowReactLayoutManager = new ChatFlowReactLayoutManager(TypedValue.applyDimension(1, 5.76f, displayMetrics), TypedValue.applyDimension(1, 7.68f, displayMetrics));
        this.layoutManager = chatFlowReactLayoutManager;
        setLayoutManager(chatFlowReactLayoutManager);
        ChatFlowReactAdapter chatFlowReactAdapter = new ChatFlowReactAdapter();
        this.adapter = chatFlowReactAdapter;
        setAdapter(chatFlowReactAdapter);
    }

    public void setData(MessageReactBean messageReactBean) {
        ChatFlowReactAdapter chatFlowReactAdapter = this.adapter;
        if (chatFlowReactAdapter != null) {
            chatFlowReactAdapter.setData(messageReactBean);
            this.adapter.notifyDataSetChanged();
        }
    }

    public void setReactOnClickListener(ReactOnClickListener reactOnClickListener) {
        ChatFlowReactAdapter chatFlowReactAdapter = this.adapter;
        if (chatFlowReactAdapter != null) {
            chatFlowReactAdapter.setReactOnClickListener(reactOnClickListener);
        }
    }

    public void setThemeColorId(int i) {
        this.themeColorId = i;
        this.adapter.setThemeColorId(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ChatFlowReactLayoutManager extends RecyclerView.LayoutManager {
        private int horizontalSpacing;
        private int verticalSpacing;

        public ChatFlowReactLayoutManager() {
            this.verticalSpacing = 0;
            this.horizontalSpacing = 0;
        }

        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new RecyclerView.LayoutParams(-2, -2);
        }

        public boolean isAutoMeasureEnabled() {
            return true;
        }

        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            boolean z;
            int i;
            int i2;
            int i3;
            detachAndScrapAttachedViews(recycler);
            int itemCount = getItemCount();
            if (itemCount == 0) {
                return;
            }
            int paddingStart = getPaddingStart();
            int i4 = 0;
            boolean z2 = true;
            boolean z3 = true;
            int i5 = 0;
            int i6 = 0;
            while (i6 < itemCount) {
                View viewForPosition = recycler.getViewForPosition(i6);
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, 0, 0);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                if (i6 != 0 && this.horizontalSpacing + paddingStart + decoratedMeasuredWidth > (getWidth() - getPaddingStart()) - getPaddingEnd()) {
                    i = i4;
                    z2 = true;
                    z = false;
                } else {
                    z = z3;
                    i = i5;
                }
                if (z2) {
                    i2 = getPaddingStart();
                } else {
                    i2 = paddingStart + this.horizontalSpacing;
                }
                int i7 = i2;
                if (z) {
                    i3 = getPaddingTop();
                } else {
                    i3 = this.verticalSpacing + i;
                }
                int i8 = i3;
                int i9 = decoratedMeasuredWidth + i7;
                int i10 = decoratedMeasuredHeight + i8;
                int max = Math.max(i4, i10);
                layoutDecoratedWithMargins(viewForPosition, i7, i8, i9, i10);
                i6++;
                paddingStart = i9;
                z3 = z;
                i5 = i;
                i4 = max;
                z2 = false;
            }
        }

        public ChatFlowReactLayoutManager(float f, float f2) {
            this.verticalSpacing = 0;
            this.horizontalSpacing = 0;
            this.verticalSpacing = Math.round(f2);
            this.horizontalSpacing = Math.round(f);
        }
    }

    public ChatFlowReactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public ChatFlowReactView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
