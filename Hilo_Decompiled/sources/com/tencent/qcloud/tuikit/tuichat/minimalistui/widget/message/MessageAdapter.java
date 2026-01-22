package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuichat.bean.message.QuoteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.MinimalistUIService;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.ICommonMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageHeaderHolder;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageViewHolderFactory;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageAdapter extends RecyclerView.Adapter implements IMessageAdapter, ICommonMessageAdapter {
    private static final int ITEM_POSITION_UNKNOWN = -1;
    private static final String TAG = "MessageAdapter";
    private int mHighShowPosition;
    private OnItemClickListener mOnItemClickListener;
    private MessageRecyclerView mRecycleView;
    private OnCheckListChangedListener onCheckListChangedListener;
    private ChatPresenter presenter;
    private boolean mLoading = true;
    private List<TUIMessageBean> mDataSource = new ArrayList();
    private HashMap<String, Boolean> mSelectedPositions = new HashMap<>();
    protected boolean isShowMultiSelectCheckBox = false;
    private boolean isForwardMode = false;
    private boolean isReplyDetailMode = false;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnCheckListChangedListener {
        void onCheckListChanged(List<TUIMessageBean> list);
    }

    private int getMessagePosition(TUIMessageBean tUIMessageBean) {
        int indexOf;
        List<TUIMessageBean> list = this.mDataSource;
        if (list == null || list.isEmpty() || (indexOf = this.mDataSource.indexOf(tUIMessageBean)) == -1) {
            return -1;
        }
        return indexOf + 1;
    }

    private boolean isItemChecked(String str) {
        if (this.mSelectedPositions.size() <= 0 || !this.mSelectedPositions.containsKey(str)) {
            return false;
        }
        return this.mSelectedPositions.get(str).booleanValue();
    }

    private void onItemChanged(int i) {
        int i2 = i - 1;
        int i3 = i + 1;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 <= getItemCount()) {
            i = i3;
        }
        notifyItemRangeChanged(i2, i - i2);
    }

    private void onItemInsert(int i, int i2) {
        notifyItemRangeInserted(i, i2);
        int i3 = i - 2;
        notifyItemRangeChanged(i3, ((i + i2) + 2) - i3);
    }

    private void onItemRemove(int i) {
        int i2 = i - 1;
        int i3 = i + 1;
        if (i2 >= 0) {
            notifyItemChanged(i2);
        }
        if (i3 <= getItemCount()) {
            notifyItemChanged(i3);
        }
        notifyItemRemoved(i);
    }

    private void refreshLoadView() {
        notifyItemChanged(0);
    }

    private void setCheckBoxStatus(final int i, final String str, MessageBaseHolder messageBaseHolder) {
        CheckBox checkBox = messageBaseHolder.mMutiSelectCheckBox;
        if (checkBox == null) {
            return;
        }
        if (!this.isShowMultiSelectCheckBox) {
            checkBox.setVisibility(8);
            messageBaseHolder.setOnItemClickListener(this.mOnItemClickListener);
            FrameLayout frameLayout = messageBaseHolder.msgContentFrame;
            if (frameLayout != null) {
                frameLayout.setOnClickListener(null);
                return;
            }
            return;
        }
        checkBox.setVisibility(0);
        messageBaseHolder.mMutiSelectCheckBox.setChecked(isItemChecked(str));
        messageBaseHolder.mMutiSelectCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageAdapter.this.changeCheckedStatus(str, i);
            }
        });
        ((RecyclerView.ViewHolder) messageBaseHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageAdapter.this.changeCheckedStatus(str, i);
            }
        });
        messageBaseHolder.setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageAdapter.3
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onMessageClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                MessageAdapter.this.changeCheckedStatus(str, i2);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onMessageLongClick(View view, int i2, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onReEditRevokeMessage(View view, int i2, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onRecallClick(View view, int i2, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onReplyMessageClick(View view, int i2, QuoteMessageBean quoteMessageBean) {
                MessageAdapter.this.changeCheckedStatus(str, i2);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                MessageAdapter.this.changeCheckedStatus(str, i2);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onUserIconLongClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                MessageAdapter.this.changeCheckedStatus(str, i2);
            }
        });
        FrameLayout frameLayout2 = messageBaseHolder.msgContentFrame;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageAdapter.this.changeCheckedStatus(str, i);
                }
            });
        }
    }

    public void changeCheckedStatus(String str, int i) {
        if (isItemChecked(str)) {
            setItemChecked(str, false);
        } else {
            setItemChecked(str, true);
        }
        notifyItemChanged(i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.ICommonMessageAdapter
    public TUIMessageBean getItem(int i) {
        List<TUIMessageBean> list;
        if (i == 0 || (list = this.mDataSource) == null || list.size() == 0 || i >= this.mDataSource.size() + 1) {
            return null;
        }
        return this.mDataSource.get(i - 1);
    }

    public int getItemCount() {
        return this.mDataSource.size() + 1;
    }

    public List<TUIMessageBean> getItemList(int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            if (i == 0) {
                i = 1;
            }
            if (i2 == 0) {
                i2 = 1;
            }
            List<TUIMessageBean> list = this.mDataSource;
            if (list != null && list.size() != 0 && i <= i2) {
                if (i < this.mDataSource.size() + 1 && i2 < this.mDataSource.size() + 1) {
                    return new ArrayList(this.mDataSource.subList(i - 1, i2));
                }
                return new ArrayList(0);
            }
            return new ArrayList(0);
        }
        return new ArrayList(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getItemViewType(int i) {
        if (i == 0) {
            return -99;
        }
        TUIMessageBean item = getItem(i);
        if (item.getStatus() == 275) {
            return MinimalistUIService.getInstance().getViewType(TipsMessageBean.class);
        }
        return MinimalistUIService.getInstance().getViewType(item.getClass());
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public ArrayList<TUIMessageBean> getSelectedItem() {
        HashMap<String, Boolean> hashMap = this.mSelectedPositions;
        if (hashMap != null && hashMap.size() != 0) {
            ArrayList<TUIMessageBean> arrayList = new ArrayList<>();
            for (int i = 0; i < getItemCount() - 1; i++) {
                if (isItemChecked(this.mDataSource.get(i).getId())) {
                    arrayList.add(this.mDataSource.get(i));
                }
            }
            return arrayList;
        }
        return null;
    }

    public boolean isShowMultiSelectCheckBox() {
        return this.isShowMultiSelectCheckBox;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        MessageRecyclerView messageRecyclerView = (MessageRecyclerView) recyclerView;
        this.mRecycleView = messageRecyclerView;
        messageRecyclerView.setItemViewCacheSize(5);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        TUIMessageBean item = getItem(i);
        if (viewHolder instanceof MessageBaseHolder) {
            if (viewHolder instanceof MessageContentHolder) {
                ((MessageContentHolder) viewHolder).isMultiSelectMode = this.isShowMultiSelectCheckBox;
            }
            MessageBaseHolder messageBaseHolder = (MessageBaseHolder) viewHolder;
            messageBaseHolder.setOnItemClickListener(this.mOnItemClickListener);
            if (item != null) {
                str = item.getId();
            } else {
                str = "";
            }
            setCheckBoxStatus(i, str, messageBaseHolder);
            messageBaseHolder.layoutViews(item, i);
            if (getItemViewType(i) == -99) {
                if (this.isForwardMode) {
                    ((MessageHeaderHolder) messageBaseHolder).setLoadingStatus(false);
                    return;
                } else {
                    ((MessageHeaderHolder) messageBaseHolder).setLoadingStatus(this.mLoading);
                    return;
                }
            }
            if (i == this.mHighShowPosition && messageBaseHolder.mContentLayout != null) {
                messageBaseHolder.startHighLight();
                this.mHighShowPosition = -1;
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder messageViewHolderFactory = MessageViewHolderFactory.getInstance(viewGroup, this, i);
        if (messageViewHolderFactory instanceof MessageContentHolder) {
            MessageContentHolder messageContentHolder = (MessageContentHolder) messageViewHolderFactory;
            messageContentHolder.isForwardMode = this.isForwardMode;
            messageContentHolder.isMessageDetailMode = this.isReplyDetailMode;
            messageContentHolder.setPresenter(this.presenter);
            if (this.isForwardMode) {
                messageContentHolder.setDataSource(this.mDataSource);
            }
        }
        return messageViewHolderFactory;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageAdapter
    public void onDataSourceChanged(List<TUIMessageBean> list) {
        this.mDataSource = list;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageAdapter
    public void onScrollToEnd() {
        MessageRecyclerView messageRecyclerView = this.mRecycleView;
        if (messageRecyclerView != null) {
            messageRecyclerView.scrollToEnd();
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageAdapter
    public void onViewNeedRefresh(int i, TUIMessageBean tUIMessageBean) {
        int messagePosition;
        this.mLoading = false;
        refreshLoadView();
        if (i == 7) {
            notifyDataSetChanged();
            int messagePosition2 = getMessagePosition(tUIMessageBean);
            if (messagePosition2 == -1) {
                return;
            }
            this.mRecycleView.scrollToPosition(messagePosition2);
            this.mRecycleView.setHighShowPosition(messagePosition2);
            return;
        }
        if (i == 9) {
            int messagePosition3 = getMessagePosition(tUIMessageBean);
            if (messagePosition3 == -1) {
                return;
            }
            this.mRecycleView.scrollToPosition(messagePosition3);
            this.mRecycleView.setHighShowPosition(messagePosition3);
            onItemChanged(messagePosition3);
            this.mRecycleView.scrollMessageFinish();
            return;
        }
        if (i == 10) {
            notifyDataSetChanged();
            int messagePosition4 = getMessagePosition(tUIMessageBean);
            if (messagePosition4 == -1) {
                return;
            }
            this.mRecycleView.scrollToEnd();
            this.mRecycleView.smoothScrollToPosition(messagePosition4);
            this.mRecycleView.setHighShowPosition(messagePosition4);
            onItemChanged(messagePosition4);
            this.mRecycleView.scrollMessageFinish();
            return;
        }
        if (i == 4) {
            int messagePosition5 = getMessagePosition(tUIMessageBean);
            if (messagePosition5 == -1) {
                return;
            }
            onItemChanged(messagePosition5);
            return;
        }
        if (i != 5 || (messagePosition = getMessagePosition(tUIMessageBean)) == -1) {
            return;
        }
        onItemRemove(messagePosition);
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MessageContentHolder) {
            MessageContentHolder messageContentHolder = (MessageContentHolder) viewHolder;
            messageContentHolder.msgArea.setBackground(null);
            messageContentHolder.stopHighLight();
            messageContentHolder.onRecycled();
        }
    }

    public void setForwardMode(boolean z) {
        this.isForwardMode = z;
    }

    public void setHighShowPosition(int i) {
        this.mHighShowPosition = i;
    }

    public void setItemChecked(String str, boolean z) {
        HashMap<String, Boolean> hashMap = this.mSelectedPositions;
        if (hashMap == null) {
            return;
        }
        hashMap.put(str, Boolean.valueOf(z));
        OnCheckListChangedListener onCheckListChangedListener = this.onCheckListChangedListener;
        if (onCheckListChangedListener != null) {
            onCheckListChangedListener.onCheckListChanged(getSelectedItem());
        }
    }

    public void setOnCheckListChangedListener(OnCheckListChangedListener onCheckListChangedListener) {
        this.onCheckListChangedListener = onCheckListChangedListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
    }

    public void setReplyDetailMode(boolean z) {
        this.isReplyDetailMode = z;
    }

    public void setShowMultiSelectCheckBox(boolean z) {
        HashMap<String, Boolean> hashMap;
        this.isShowMultiSelectCheckBox = z;
        if (!z && (hashMap = this.mSelectedPositions) != null) {
            hashMap.clear();
        }
    }

    public void showLoading() {
        if (this.isForwardMode || this.mLoading) {
            return;
        }
        this.mLoading = true;
        notifyItemChanged(0);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageAdapter
    public void onViewNeedRefresh(int i, int i2) {
        this.mLoading = false;
        if (i == 0) {
            notifyDataSetChanged();
            this.mRecycleView.scrollToEnd();
        } else if (i == 3) {
            onItemInsert(this.mDataSource.size() + 1, i2);
        } else if (i == 8) {
            onItemInsert(this.mDataSource.size() + 1, i2);
            this.mRecycleView.onMsgAddBack();
        } else if (i == 4) {
            notifyDataSetChanged();
        } else if (i == 2) {
            if (i2 != 0) {
                onItemInsert(0, i2);
            }
        } else if (i == 1) {
            notifyDataSetChanged();
            this.mRecycleView.scrollToEnd();
            this.mRecycleView.loadMessageFinish();
        }
        refreshLoadView();
    }
}
