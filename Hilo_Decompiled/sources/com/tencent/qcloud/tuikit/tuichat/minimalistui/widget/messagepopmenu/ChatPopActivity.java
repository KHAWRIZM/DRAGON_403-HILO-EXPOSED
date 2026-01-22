package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.h;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.component.RoundCornerImageView;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.component.face.RecentEmojiManager;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.MinimalistUIService;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.ImageMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageViewHolderFactory;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopMenuEmojiDialogFragment;
import com.tencent.qcloud.tuikit.tuichat.util.BlurUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tech.sud.gip.core.view.round.RoundedDrawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatPopActivity extends AppCompatActivity {
    private static final int ACTION_MAX_NUM_PER_PAGE = 4;
    private static final String RECENT_EMOJI_KEY = "recentEmoji";
    private static final int RECENT_EMOJI_NUM = 6;
    private static final String TAG = "ChatPopActivity";
    private View actionArea;
    private RecyclerView actionRecyclerView;
    private List<ChatPopMenuAction> chatPopMenuActionList;
    private RelativeLayout dialogContainer;
    private FrameLayout frameLayout;
    private MenuActionAdapter menuActionAdapter;
    private View moreBtn;
    private ViewGroup popupView;
    private RecyclerView recentFaceView;
    private ScrollView scrollMessageContainer;
    private final List<Emoji> emojiList = new ArrayList();
    private final List<String> recentEmojiList = new ArrayList();
    private boolean isShowFaces = true;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ChatPopMenuAction {
        private OnClickListener actionClickListener;
        private int actionIcon;
        private String actionName;
        private int textColor = Integer.MAX_VALUE;

        @FunctionalInterface
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public interface OnClickListener {
            void onClick();
        }

        public OnClickListener getActionClickListener() {
            return this.actionClickListener;
        }

        public int getActionIcon() {
            return this.actionIcon;
        }

        public String getActionName() {
            return this.actionName;
        }

        public void setActionClickListener(OnClickListener onClickListener) {
            this.actionClickListener = onClickListener;
        }

        public void setActionIcon(int i) {
            this.actionIcon = i;
        }

        public void setActionName(String str) {
            this.actionName = str;
        }

        public void setTextColor(int i) {
            this.textColor = i;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface EmojiOnClickListener {
        void onClick(Emoji emoji);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class GridDecoration extends RecyclerView.ItemDecoration {
        private final int columnNum;
        private final Drawable divider;
        private final int leftRightSpace;
        private final int topBottomSpace;

        public GridDecoration(Drawable drawable, int i, int i2, int i3) {
            this.divider = drawable;
            this.columnNum = i;
            this.leftRightSpace = i2;
            this.topBottomSpace = i3;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = this.columnNum;
            int i2 = childAdapterPosition % i;
            int i3 = this.leftRightSpace;
            rect.left = (i2 * i3) / i;
            rect.right = (i3 * ((i - 1) - i2)) / i;
            if (childAdapterPosition >= i) {
                rect.top = this.topBottomSpace;
            }
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if (this.divider == null) {
                return;
            }
            canvas.save();
            int ceil = ((int) Math.ceil((recyclerView.getChildCount() * 1.0f) / this.columnNum)) - 1;
            int i = 0;
            while (i < ceil) {
                View childAt = recyclerView.getChildAt(this.columnNum * i);
                i++;
                View childAt2 = recyclerView.getChildAt((this.columnNum * i) - 1);
                int bottom = childAt.getBottom();
                this.divider.setBounds(childAt.getLeft(), (bottom - this.divider.getIntrinsicHeight()) + (this.topBottomSpace / 2), childAt2.getRight(), bottom + (this.topBottomSpace / 2));
                this.divider.draw(canvas);
            }
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class MenuActionAdapter extends RecyclerView.Adapter<MenuItemViewHolder> {
        private int page = 1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class MenuItemViewHolder extends RecyclerView.ViewHolder {
            public ImageView icon;
            public TextView title;

            public MenuItemViewHolder(View view) {
                super(view);
                this.title = (TextView) view.findViewById(R.id.action_name);
                this.icon = (ImageView) view.findViewById(R.id.action_icon);
            }
        }

        MenuActionAdapter() {
        }

        public int getItemCount() {
            if (ChatPopActivity.this.chatPopMenuActionList == null) {
                return 0;
            }
            return Math.min(ChatPopActivity.this.chatPopMenuActionList.size() - ((this.page - 1) * 4), 4);
        }

        public void switchNextPage() {
            int i = this.page + 1;
            this.page = i;
            if ((i * 4) - ChatPopActivity.this.chatPopMenuActionList.size() >= 4) {
                this.page = 1;
            }
            notifyDataSetChanged();
        }

        public void onBindViewHolder(MenuItemViewHolder menuItemViewHolder, int i) {
            final ChatPopMenuAction chatPopMenuAction = ChatPopActivity.this.getChatPopMenuAction(((this.page - 1) * 4) + i);
            if (chatPopMenuAction.textColor != Integer.MAX_VALUE) {
                menuItemViewHolder.title.setTextColor(chatPopMenuAction.textColor);
            } else {
                menuItemViewHolder.title.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            }
            menuItemViewHolder.title.setText(chatPopMenuAction.actionName);
            menuItemViewHolder.icon.setImageDrawable(h.f(((RecyclerView.ViewHolder) menuItemViewHolder).itemView.getResources(), chatPopMenuAction.actionIcon, (Resources.Theme) null));
            ((RecyclerView.ViewHolder) menuItemViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.MenuActionAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    chatPopMenuAction.actionClickListener.onClick();
                    ChatPopActivity.this.hide();
                }
            });
        }

        public MenuItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MenuItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_minimalist_pop_menu_action_item_layou, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class RecentFaceAdapter extends RecyclerView.Adapter<RecentFaceViewHolder> {
        private Emoji moreBtn;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class RecentFaceViewHolder extends RecyclerView.ViewHolder {
            ImageView faceIv;

            public RecentFaceViewHolder(View view) {
                super(view);
                this.faceIv = (ImageView) view.findViewById(R.id.face_iv);
            }
        }

        RecentFaceAdapter() {
        }

        private Emoji getEmoji(String str) {
            for (Emoji emoji : ChatPopActivity.this.emojiList) {
                if (TextUtils.equals(emoji.getFaceKey(), str)) {
                    return emoji;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onEmojiClicked(Emoji emoji) {
            if (emoji == this.moreBtn) {
                ChatPopMenuEmojiDialogFragment chatPopMenuEmojiDialogFragment = new ChatPopMenuEmojiDialogFragment();
                chatPopMenuEmojiDialogFragment.setEmojiClickListener(new ChatPopMenuEmojiDialogFragment.EmojiClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.RecentFaceAdapter.2
                    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopMenuEmojiDialogFragment.EmojiClickListener
                    public void onClick(Emoji emoji2) {
                        RecentFaceAdapter.this.onEmojiClicked(emoji2);
                    }
                });
                chatPopMenuEmojiDialogFragment.show(ChatPopActivity.this.getSupportFragmentManager(), "ChatEmoji");
            } else {
                EmojiOnClickListener emojiOnClickListener = ChatPopDataHolder.getEmojiOnClickListener();
                if (emojiOnClickListener != null) {
                    emojiOnClickListener.onClick(emoji);
                    ChatPopActivity.this.updateRecentEmoji(emoji);
                    ChatPopActivity.this.hide();
                }
            }
        }

        public int getItemCount() {
            return 7;
        }

        public void onBindViewHolder(RecentFaceViewHolder recentFaceViewHolder, int i) {
            final Emoji emoji;
            if (i != 6) {
                emoji = getEmoji((String) ChatPopActivity.this.recentEmojiList.get(i));
            } else {
                emoji = this.moreBtn;
            }
            if (emoji == null) {
                return;
            }
            recentFaceViewHolder.faceIv.setImageBitmap(emoji.getIcon());
            recentFaceViewHolder.faceIv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.RecentFaceAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RecentFaceAdapter.this.onEmojiClicked(emoji);
                }
            });
        }

        public RecentFaceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_menu_recent_face_item_layout, viewGroup, false);
            this.moreBtn = new Emoji();
            this.moreBtn.setIcon(BitmapFactory.decodeResource(viewGroup.getResources(), R.drawable.chat_pop_menu_add_icon));
            return new RecentFaceViewHolder(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatPopMenuAction getChatPopMenuAction(int i) {
        return this.chatPopMenuActionList.get(i);
    }

    private int getStatusBarHeight() {
        int i;
        try {
            i = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Exception unused) {
            Log.e(TAG, "setLocation getStatusBarHeight exception");
            i = 0;
        }
        if (i == 0) {
            return ScreenUtil.dip2px(32.0f);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        RoundCornerImageView imageMessageView;
        TUIMessageBean tUIMessageBean = (TUIMessageBean) getIntent().getSerializableExtra("messageBean");
        RecyclerView.ViewHolder messageViewHolderFactory = MessageViewHolderFactory.getInstance(this.frameLayout, null, MinimalistUIService.getInstance().getViewType(tUIMessageBean.getClass()));
        if (messageViewHolderFactory instanceof MessageContentHolder) {
            MessageContentHolder messageContentHolder = (MessageContentHolder) messageViewHolderFactory;
            messageContentHolder.setFloatMode(true);
            if ((messageViewHolderFactory instanceof ImageMessageHolder) && (imageMessageView = ChatPopDataHolder.getImageMessageView()) != null) {
                ImageMessageHolder imageMessageHolder = (ImageMessageHolder) messageViewHolderFactory;
                imageMessageHolder.contentImage.setLeftTopRadius(imageMessageView.getLeftTopRadius());
                imageMessageHolder.contentImage.setLeftBottomRadius(imageMessageView.getLeftBottomRadius());
                imageMessageHolder.contentImage.setRightBottomRadius(imageMessageView.getRightBottomRadius());
                imageMessageHolder.contentImage.setRightTopRadius(imageMessageView.getRightTopRadius());
            }
            messageContentHolder.layoutViews(tUIMessageBean, 0);
            messageContentHolder.msgArea.setBackground(ChatPopDataHolder.getMsgAreaBackground());
        }
        if (tUIMessageBean.isSelf()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.recentFaceView.getLayoutParams();
            layoutParams.addRule(21);
            layoutParams.removeRule(20);
            this.recentFaceView.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.scrollMessageContainer.getLayoutParams();
            layoutParams2.addRule(21);
            layoutParams2.removeRule(20);
            this.scrollMessageContainer.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.actionArea.getLayoutParams();
            layoutParams3.addRule(21);
            layoutParams3.removeRule(20);
            this.actionArea.setLayoutParams(layoutParams3);
        } else {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.recentFaceView.getLayoutParams();
            layoutParams4.addRule(20);
            layoutParams4.removeRule(21);
            this.recentFaceView.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.scrollMessageContainer.getLayoutParams();
            layoutParams5.addRule(20);
            layoutParams5.removeRule(21);
            this.scrollMessageContainer.setLayoutParams(layoutParams5);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.actionArea.getLayoutParams();
            layoutParams6.addRule(20);
            layoutParams6.removeRule(21);
            this.actionArea.setLayoutParams(layoutParams6);
        }
        this.frameLayout.addView(messageViewHolderFactory.itemView);
        this.moreBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatPopActivity.this.menuActionAdapter.switchNextPage();
            }
        });
        final GestureDetector gestureDetector = new GestureDetector((Context) this, (GestureDetector.OnGestureListener) new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                ChatPopActivity.this.onBackPressed();
                return true;
            }
        });
        this.popupView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view == ChatPopActivity.this.popupView) {
                    gestureDetector.onTouchEvent(motionEvent);
                    return true;
                }
                return false;
            }
        });
        initEmojiList();
        this.actionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MenuActionAdapter menuActionAdapter = new MenuActionAdapter();
        this.menuActionAdapter = menuActionAdapter;
        this.actionRecyclerView.setAdapter(menuActionAdapter);
        this.recentFaceView.setItemAnimator((RecyclerView.ItemAnimator) null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 0, false);
        this.recentFaceView.addItemDecoration(new GridDecoration(null, 7, ScreenUtil.dip2px(8.0f), 0));
        this.recentFaceView.setLayoutManager(linearLayoutManager);
        this.recentFaceView.setAdapter(new RecentFaceAdapter());
        if (!this.isShowFaces) {
            this.recentFaceView.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initDefaultEmoji() {
        List list;
        try {
            list = (List) RecentEmojiManager.getInstance().getCollection(RECENT_EMOJI_KEY);
        } catch (IOException e) {
            e.printStackTrace();
            list = null;
            if (list == null) {
            }
            this.recentEmojiList.addAll(list);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            list = null;
            if (list == null) {
            }
            this.recentEmojiList.addAll(list);
        }
        if (list == null) {
            List<Emoji> subList = this.emojiList.subList(0, 6);
            ArrayList arrayList = new ArrayList();
            Iterator<Emoji> it = subList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getFaceKey());
            }
            list = new ArrayList(arrayList);
            try {
                RecentEmojiManager.getInstance().putCollection(RECENT_EMOJI_KEY, list);
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        this.recentEmojiList.addAll(list);
    }

    private void initEmojiList() {
        this.emojiList.addAll(FaceManager.getEmojiList());
        initDefaultEmoji();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setLocation() {
        Rect messageViewGlobalRect = ChatPopDataHolder.getMessageViewGlobalRect();
        int dip2px = ScreenUtil.dip2px(214.0f);
        List<ChatPopMenuAction> list = this.chatPopMenuActionList;
        if (list != null && list.size() <= 4) {
            dip2px = (ScreenUtil.dip2px(40.0f) * this.chatPopMenuActionList.size()) + ScreenUtil.dip2px(8.0f);
        }
        int dip2px2 = ScreenUtil.dip2px(48.0f);
        int screenHeight = ScreenUtil.getScreenHeight(this);
        int statusBarHeight = getStatusBarHeight();
        if (messageViewGlobalRect.top - dip2px2 >= statusBarHeight && messageViewGlobalRect.bottom + dip2px <= screenHeight) {
            this.dialogContainer.setY((r5 - dip2px2) - statusBarHeight);
            return;
        }
        int height = messageViewGlobalRect.height();
        if (height + dip2px + dip2px2 <= screenHeight - statusBarHeight) {
            if ((screenHeight - ((dip2px2 + dip2px) + height)) / 2 > dip2px) {
                this.dialogContainer.setY(r0 + statusBarHeight);
                return;
            } else {
                this.dialogContainer.setY((r3 - statusBarHeight) - r0);
                return;
            }
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.actionArea.getLayoutParams();
        layoutParams.removeRule(3);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dip2px2;
        this.actionArea.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRecentEmoji(Emoji emoji) {
        this.recentEmojiList.remove(emoji.getFaceKey());
        this.recentEmojiList.add(0, emoji.getFaceKey());
        try {
            RecentEmojiManager.getInstance().putCollection(RECENT_EMOJI_KEY, this.recentEmojiList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        setContentView(R.layout.chat_minimalist_pop_menu_layout);
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        this.popupView = viewGroup;
        this.dialogContainer = (RelativeLayout) viewGroup.findViewById(R.id.dialog_content_layout);
        this.moreBtn = this.popupView.findViewById(R.id.more_btn);
        this.actionArea = this.popupView.findViewById(R.id.action_area);
        this.actionRecyclerView = this.popupView.findViewById(R.id.chat_pop_menu_action_view);
        this.recentFaceView = this.popupView.findViewById(R.id.recent_faces);
        ScrollView scrollView = (ScrollView) this.popupView.findViewById(R.id.scroll_container);
        this.scrollMessageContainer = scrollView;
        scrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        List<ChatPopMenuAction> actionList = ChatPopDataHolder.getActionList();
        this.chatPopMenuActionList = actionList;
        if (actionList == null || actionList.size() <= 4) {
            this.moreBtn.setVisibility(8);
        }
        Window window = getWindow();
        Bitmap fastBlur = BlurUtils.fastBlur(this, ChatPopDataHolder.getChatPopBgBitmap());
        if (fastBlur != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable((Resources) null, fastBlur);
            bitmapDrawable.setColorFilter(new LightingColorFilter(6710886, 0));
            window.setBackgroundDrawable(bitmapDrawable);
        } else {
            window.setBackgroundDrawable(new ColorDrawable(-1090519040));
        }
        this.frameLayout = (FrameLayout) findViewById(R.id.message_frame);
        setLocation();
        init();
    }
}
