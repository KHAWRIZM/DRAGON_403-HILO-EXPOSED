package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.tuichat.bean.ReactUserBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.presenter.ReactPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatReactDialogFragment extends DialogFragment {
    private ChatInfo chatInfo;
    private BottomSheetDialog dialog;
    private TUIMessageBean messageBean;
    private OnReactClickListener onReactClickListener;
    private RecyclerView reactCategoryList;
    private ReactPresenter reactPresenter;
    private ViewPager2 reactViewPager;
    private int selectedIndex = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnReactClickListener {
        void onClick(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class ReactCategoryAdapter extends RecyclerView.Adapter<ReactCategoryHolder> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class ReactCategoryHolder extends RecyclerView.ViewHolder {
            private TextView categoryName;
            private ImageView reactImg;
            private TextView reactNum;

            public ReactCategoryHolder(View view) {
                super(view);
                this.categoryName = (TextView) view.findViewById(R.id.category_name);
                this.reactNum = (TextView) view.findViewById(R.id.react_num);
                this.reactImg = (ImageView) view.findViewById(R.id.react_img);
            }
        }

        ReactCategoryAdapter() {
        }

        public int getItemCount() {
            MessageReactBean messageReactBean;
            if (ChatReactDialogFragment.this.messageBean == null || (messageReactBean = ChatReactDialogFragment.this.messageBean.getMessageReactBean()) == null) {
                return 0;
            }
            return messageReactBean.getReactSize() + 1;
        }

        public void onBindViewHolder(ReactCategoryHolder reactCategoryHolder, final int i) {
            if (ChatReactDialogFragment.this.selectedIndex == i) {
                ((RecyclerView.ViewHolder) reactCategoryHolder).itemView.setBackgroundResource(R.drawable.chat_gray_round_rect_bg);
            } else {
                ((RecyclerView.ViewHolder) reactCategoryHolder).itemView.setBackground(null);
            }
            if (i == 0) {
                reactCategoryHolder.categoryName.setText("All");
                Iterator<Set<String>> it = ChatReactDialogFragment.this.messageBean.getMessageReactBean().getReacts().values().iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    i2 += it.next().size();
                }
                reactCategoryHolder.reactNum.setText(i2 + "");
                reactCategoryHolder.reactImg.setVisibility(8);
            } else {
                Map<String, Set<String>> reacts = ChatReactDialogFragment.this.messageBean.getMessageReactBean().getReacts();
                ArrayList arrayList = new ArrayList(reacts.keySet());
                int i3 = i - 1;
                reactCategoryHolder.reactImg.setImageBitmap(FaceManager.getEmoji((String) arrayList.get(i3)));
                Set<String> set = reacts.get(arrayList.get(i3));
                reactCategoryHolder.reactNum.setText(set.size() + "");
            }
            ((RecyclerView.ViewHolder) reactCategoryHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.ChatReactDialogFragment.ReactCategoryAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ChatReactDialogFragment.this.reactViewPager.setCurrentItem(i);
                }
            });
        }

        public ReactCategoryHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ReactCategoryHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.minimalist_react_category_layout, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class ReactDetailAdapter extends RecyclerView.Adapter<ReactDetailHolder> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class ReactDetailHolder extends RecyclerView.ViewHolder {
            private RecyclerView recyclerView;

            public ReactDetailHolder(View view) {
                super(view);
                this.recyclerView = view.findViewById(R.id.react_user_list);
            }
        }

        ReactDetailAdapter() {
        }

        public int getItemCount() {
            MessageReactBean messageReactBean;
            if (ChatReactDialogFragment.this.messageBean == null || (messageReactBean = ChatReactDialogFragment.this.messageBean.getMessageReactBean()) == null) {
                return 0;
            }
            return messageReactBean.getReactSize() + 1;
        }

        public void onBindViewHolder(ReactDetailHolder reactDetailHolder, int i) {
            ReactUserAdapter reactUserAdapter = (ReactUserAdapter) reactDetailHolder.recyclerView.getAdapter();
            ArrayList arrayList = new ArrayList();
            Map<String, Set<String>> reacts = ChatReactDialogFragment.this.messageBean.getMessageReactBean().getReacts();
            if (i == 0) {
                for (String str : reacts.keySet()) {
                    Set<String> set = reacts.get(str);
                    if (set != null) {
                        Iterator<String> it = set.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new Pair<>(it.next(), str));
                        }
                    }
                }
            } else {
                String str2 = (String) new ArrayList(reacts.keySet()).get(i - 1);
                Set<String> set2 = reacts.get(str2);
                if (set2 != null) {
                    Iterator<String> it2 = set2.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(new Pair<>(it2.next(), str2));
                    }
                }
            }
            reactUserAdapter.setData(arrayList);
            reactUserAdapter.notifyDataSetChanged();
        }

        public ReactDetailHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ReactDetailHolder reactDetailHolder = new ReactDetailHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.minimalist_react_view_pager_layout, viewGroup, false));
            reactDetailHolder.recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext()));
            reactDetailHolder.recyclerView.setAdapter(new ReactUserAdapter());
            return reactDetailHolder;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class ReactUserAdapter extends RecyclerView.Adapter<ReactUserViewHolder> {
        private List<Pair<String, String>> data;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class ReactUserViewHolder extends RecyclerView.ViewHolder {
            private ImageView emojiIcon;
            private TextView tips;
            private ImageView userFace;
            private TextView userName;

            public ReactUserViewHolder(View view) {
                super(view);
                this.userFace = (ImageView) view.findViewById(R.id.user_face);
                this.emojiIcon = (ImageView) view.findViewById(R.id.emoji_icon);
                this.userName = (TextView) view.findViewById(R.id.user_name);
                this.tips = (TextView) view.findViewById(R.id.tips);
            }
        }

        ReactUserAdapter() {
        }

        public int getItemCount() {
            List<Pair<String, String>> list = this.data;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public void setData(List<Pair<String, String>> list) {
            this.data = list;
        }

        public void onBindViewHolder(ReactUserViewHolder reactUserViewHolder, int i) {
            final Pair<String, String> pair = this.data.get(i);
            final ReactUserBean reactUserBean = ChatReactDialogFragment.this.messageBean.getMessageReactBean().getReactUserBeanMap().get(pair.first);
            GlideEngine.loadImage(reactUserViewHolder.userFace, reactUserBean.getFaceUrl());
            if (pair.second != null) {
                GlideEngine.loadImage(reactUserViewHolder.emojiIcon, FaceManager.getEmoji((String) pair.second));
            }
            reactUserViewHolder.userName.setText(reactUserBean.getDisplayString());
            if (TextUtils.equals((CharSequence) pair.first, TUILogin.getLoginUser())) {
                reactUserViewHolder.tips.setText(ChatReactDialogFragment.this.getResources().getString(R.string.chat_tap_to_remove));
                ((RecyclerView.ViewHolder) reactUserViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.ChatReactDialogFragment.ReactUserAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ChatReactDialogFragment.this.onReactClickListener != null) {
                            ChatReactDialogFragment.this.onReactClickListener.onClick(reactUserBean.getUserId(), (String) pair.second);
                        }
                    }
                });
            } else {
                reactUserViewHolder.tips.setVisibility(8);
                ((RecyclerView.ViewHolder) reactUserViewHolder).itemView.setOnClickListener(null);
            }
        }

        public ReactUserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ReactUserViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.minimalist_react_details_layout, viewGroup, false));
        }
    }

    private void initData() {
        ReactPresenter reactPresenter = new ReactPresenter();
        this.reactPresenter = reactPresenter;
        reactPresenter.setChatInfo(this.chatInfo);
        this.reactPresenter.setMessageId(this.messageBean.getId());
        this.reactPresenter.setChatEventListener();
        this.reactPresenter.setMessageListener(new ReactPresenter.OnMessageChangedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.ChatReactDialogFragment.2
            @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ReactPresenter.OnMessageChangedListener
            public void onMessageChanged(TUIMessageBean tUIMessageBean) {
                if (ChatReactDialogFragment.this.isAdded()) {
                    ChatReactDialogFragment.this.messageBean = tUIMessageBean;
                    ChatReactDialogFragment.this.reactCategoryList.getAdapter().notifyDataSetChanged();
                    ChatReactDialogFragment.this.reactViewPager.getAdapter().notifyDataSetChanged();
                }
            }
        });
        this.reactCategoryList.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.reactCategoryList.setAdapter(new ReactCategoryAdapter());
        this.reactViewPager.setAdapter(new ReactDetailAdapter());
    }

    private void initView() {
        this.reactViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.ChatReactDialogFragment.1
            public void onPageSelected(int i) {
                ChatReactDialogFragment.this.selectedIndex = i;
                ChatReactDialogFragment.this.reactCategoryList.getAdapter().notifyDataSetChanged();
                ChatReactDialogFragment.this.reactCategoryList.smoothScrollToPosition(i);
            }
        });
    }

    public Dialog onCreateDialog(Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext(), R.style.ChatPopActivityStyle);
        this.dialog = bottomSheetDialog;
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        BottomSheetBehavior behavior = this.dialog.getBehavior();
        behavior.S0(false);
        behavior.U0(0.45f);
        behavior.c1(true);
        behavior.R0(ScreenUtil.dip2px(36.0f));
        behavior.c(6);
        return this.dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.chat_react_dialog_layout, viewGroup);
        this.reactViewPager = inflate.findViewById(R.id.react_view_pager);
        this.reactCategoryList = inflate.findViewById(R.id.react_category_list);
        initView();
        initData();
        return inflate;
    }

    public void setChatInfo(ChatInfo chatInfo) {
        this.chatInfo = chatInfo;
    }

    public void setMessageBean(TUIMessageBean tUIMessageBean) {
        this.messageBean = tUIMessageBean;
    }

    public void setOnReactClickListener(OnReactClickListener onReactClickListener) {
        this.onReactClickListener = onReactClickListener;
    }
}
