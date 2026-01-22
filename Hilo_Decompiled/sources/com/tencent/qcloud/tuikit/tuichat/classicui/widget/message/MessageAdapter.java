package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuichat.bean.message.QuoteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.ClassicUIService;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ICommonMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageHeaderHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageViewHolderFactory;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMCheckDataListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageAdapter extends RecyclerView.Adapter implements IMessageAdapter, ICommonMessageAdapter {
    private static final int ITEM_POSITION_UNKNOWN = -1;
    private static final String TAG = "MessageAdapter";
    private int mHighShowPosition;
    private IMCheckDataListener mIMCheckDataListener;
    private OnItemClickListener mOnItemClickListener;
    private MessageRecyclerView mRecycleView;
    private ChatPresenter presenter;
    private boolean mLoading = true;
    private List<TUIMessageBean> mDataSource = new ArrayList();
    private HashMap<String, Boolean> mSelectedPositions = new HashMap<>();
    protected boolean isShowMultiSelectCheckBox = false;
    private boolean isForwardMode = false;
    private boolean isReplyDetailMode = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCheckedStatus(String str, int i) {
        if (isItemChecked(str)) {
            setItemChecked(str, false);
        } else {
            setItemChecked(str, true);
        }
        notifyItemChanged(i);
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
            messageBaseHolder.setOnItemDateListener(this.mIMCheckDataListener);
            FrameLayout frameLayout = messageBaseHolder.msgContentFrame;
            if (frameLayout != null) {
                frameLayout.setOnClickListener(null);
                return;
            }
            return;
        }
        checkBox.setVisibility(0);
        messageBaseHolder.mMutiSelectCheckBox.setChecked(isItemChecked(str));
        messageBaseHolder.mMutiSelectCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageAdapter.this.changeCheckedStatus(str, i);
            }
        });
        ((RecyclerView.ViewHolder) messageBaseHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageAdapter.this.changeCheckedStatus(str, i);
            }
        });
        messageBaseHolder.setOnItemDateListener(this.mIMCheckDataListener);
        messageBaseHolder.setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter.3
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onMessageClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                MessageAdapter.this.changeCheckedStatus(str, i2);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onMessageLongClick(View view, int i2, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onReEditRevokeMessage(View view, int i2, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onRecallClick(View view, int i2, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onReplyMessageClick(View view, int i2, QuoteMessageBean quoteMessageBean) {
                MessageAdapter.this.changeCheckedStatus(str, i2);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                MessageAdapter.this.changeCheckedStatus(str, i2);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onUserIconLongClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                MessageAdapter.this.changeCheckedStatus(str, i2);
            }
        });
        FrameLayout frameLayout2 = messageBaseHolder.msgContentFrame;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageAdapter.this.changeCheckedStatus(str, i);
                }
            });
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ICommonMessageAdapter
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
            return ClassicUIService.getInstance().getViewType(TipsMessageBean.class);
        }
        return ClassicUIService.getInstance().getViewType(item.getClass());
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
            messageBaseHolder.setOnItemDateListener(this.mIMCheckDataListener);
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
            messageContentHolder.isReplyDetailMode = this.isReplyDetailMode;
            messageContentHolder.setPresenter(this.presenter);
            if (this.isForwardMode) {
                messageContentHolder.setDataSource(this.mDataSource);
            }
        } else if (messageViewHolderFactory instanceof HiloRoomContentHolder) {
            HiloRoomContentHolder hiloRoomContentHolder = (HiloRoomContentHolder) messageViewHolderFactory;
            hiloRoomContentHolder.setForwardMode(this.isForwardMode);
            hiloRoomContentHolder.setReplyDetailMode(this.isReplyDetailMode);
            hiloRoomContentHolder.setPresenter(this.presenter);
            if (this.isForwardMode) {
                hiloRoomContentHolder.setDataSource(this.mDataSource);
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
            notifyItemChanged(messagePosition3);
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
            notifyItemChanged(messagePosition4);
            this.mRecycleView.scrollMessageFinish();
            return;
        }
        if (i == 4) {
            int messagePosition5 = getMessagePosition(tUIMessageBean);
            if (messagePosition5 == -1) {
                return;
            }
            notifyItemChanged(messagePosition5);
            return;
        }
        if (i != 5 || (messagePosition = getMessagePosition(tUIMessageBean)) == -1) {
            return;
        }
        notifyItemRemoved(messagePosition);
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MessageContentHolder) {
            MessageContentHolder messageContentHolder = (MessageContentHolder) viewHolder;
            messageContentHolder.msgArea.setBackground(null);
            messageContentHolder.stopHighLight();
            messageContentHolder.onRecycled();
        }
    }

    public void resetSelectableText() {
        int selectedPosition = this.mRecycleView.getSelectedPosition();
        if (selectedPosition < 0) {
            return;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.mRecycleView.findViewHolderForAdapterPosition(selectedPosition);
        if (findViewHolderForAdapterPosition != null) {
            if (findViewHolderForAdapterPosition instanceof MessageContentHolder) {
                ((MessageContentHolder) findViewHolderForAdapterPosition).resetSelectableText();
                return;
            }
            return;
        }
        TUIChatLog.d(TAG, "holder == null");
    }

    public void setForwardMode(boolean z) {
        this.isForwardMode = z;
    }

    public void setHighShowPosition(int i) {
        this.mHighShowPosition = i;
    }

    public void setIMCheckDataListener(IMCheckDataListener iMCheckDataListener) {
        this.mIMCheckDataListener = iMCheckDataListener;
    }

    public void setItemChecked(String str, boolean z) {
        HashMap<String, Boolean> hashMap = this.mSelectedPositions;
        if (hashMap == null) {
            return;
        }
        hashMap.put(str, Boolean.valueOf(z));
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
            notifyItemRangeInserted(this.mDataSource.size() + 1, i2);
        } else if (i == 8) {
            notifyItemRangeInserted(this.mDataSource.size() + 1, i2);
            this.mRecycleView.onMsgAddBack();
        } else if (i == 4) {
            notifyDataSetChanged();
        } else if (i == 2) {
            if (i2 != 0) {
                notifyItemRangeInserted(0, i2);
            }
        } else if (i == 1) {
            notifyDataSetChanged();
            this.mRecycleView.scrollToEnd();
            this.mRecycleView.loadMessageFinish();
        }
        refreshLoadView();
    }
}
