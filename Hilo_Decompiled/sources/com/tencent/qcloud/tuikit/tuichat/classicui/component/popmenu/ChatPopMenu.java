package com.tencent.qcloud.tuikit.tuichat.classicui.component.popmenu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.res.h;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.EmojiIndicatorView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.component.face.RecentEmojiManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatPopMenu {
    private static final int ACTION_COLUMN_NUM = 5;
    private static final int EMOJI_COLUMN_NUM = 8;
    private static final int EMOJI_ROW_NUM = 3;
    private static final String RECENT_EMOJI_KEY = "recentEmoji";
    private static final int RECENT_EMOJI_NUM = 6;
    private static final int RECT_RADIUS = 16;
    private static final int SHADOW_WIDTH = 10;
    private final GridLayoutManager actionGridLayoutManager;
    private final RecyclerView actionRecyclerView;
    private View anchorView;
    private final Context context;
    private View divideLine;
    private EmojiOnClickListener emojiOnClickListener;
    private FacePageAdapter facePageAdapter;
    private final EmojiIndicatorView facePageIndicator;
    private final LinearLayout facePageLinearLayout;
    private final RecyclerView facePageRecyclerView;
    private final int indicatorHeight;
    private MessageRecyclerView.OnEmptySpaceClickListener mEmptySpaceClickListener;
    private final MenuAdapter menuAdapter;
    private int minY;
    private int paddingBottomOffset;
    private int paddingTopOffset;
    private final View popupView;
    private final PopupWindow popupWindow;
    private RecyclerView recentFaceView;
    private final List<ChatPopMenuAction> chatPopMenuActionList = new ArrayList();
    private final List<Emoji> emojiList = new ArrayList();
    private final List<String> recentEmojiList = new ArrayList();
    private boolean isShowMoreFace = false;
    private int oldFacePageIndex = 0;
    private boolean isShowFaces = false;
    private final ChatPopMenu chatPopMenu = this;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ChatPopMenuAction {
        private OnClickListener actionClickListener;
        private int actionIcon;
        private String actionName;

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
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface EmojiOnClickListener {
        void onClick(Emoji emoji);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class FaceGridAdapter extends RecyclerView.Adapter<FaceViewHolder> {
        private List<Emoji> data;

        FaceGridAdapter() {
        }

        public int getItemCount() {
            List<Emoji> list = this.data;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void setData(List<Emoji> list) {
            this.data = list;
            notifyDataSetChanged();
        }

        public void onBindViewHolder(FaceViewHolder faceViewHolder, int i) {
            final Emoji emoji = this.data.get(i);
            faceViewHolder.faceIv.setBackground(new BitmapDrawable(((RecyclerView.ViewHolder) faceViewHolder).itemView.getResources(), emoji.getIcon()));
            if (ChatPopMenu.this.emojiOnClickListener != null) {
                faceViewHolder.faceIv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.component.popmenu.ChatPopMenu.FaceGridAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ChatPopMenu.this.emojiOnClickListener.onClick(emoji);
                        ChatPopMenu.this.updateRecentEmoji(emoji);
                        ChatPopMenu.this.hide();
                    }
                });
            }
        }

        public FaceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new FaceViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_menu_face_item_layout, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class FaceGridDecoration extends RecyclerView.ItemDecoration {
        private final int columnNum;
        private final int leftRightSpace;
        private final int topBottomSpace;

        public FaceGridDecoration(int i, int i2, int i3) {
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class FacePageAdapter extends RecyclerView.Adapter<FacePageViewHolder> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class FacePageViewHolder extends RecyclerView.ViewHolder {
            public RecyclerView recyclerView;

            public FacePageViewHolder(View view) {
                super(view);
                this.recyclerView = (RecyclerView) view;
            }
        }

        FacePageAdapter() {
        }

        public int getItemCount() {
            return (int) Math.ceil((ChatPopMenu.this.emojiList.size() * 1.0f) / 24.0f);
        }

        public void onBindViewHolder(FacePageViewHolder facePageViewHolder, int i) {
            FaceGridAdapter faceGridAdapter = new FaceGridAdapter();
            facePageViewHolder.recyclerView.setAdapter(faceGridAdapter);
            int i2 = i * 24;
            int i3 = (i + 1) * 24;
            if (i3 > ChatPopMenu.this.emojiList.size()) {
                i3 = ChatPopMenu.this.emojiList.size();
            }
            faceGridAdapter.setData(ChatPopMenu.this.emojiList.subList(i2, i3));
        }

        public FacePageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            RecyclerView recyclerView = new RecyclerView(viewGroup.getContext());
            recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            recyclerView.setLayoutManager(new GridLayoutManager(viewGroup.getContext(), 8));
            recyclerView.addItemDecoration(new FaceGridDecoration(8, ScreenUtil.dip2px(9.12f), ScreenUtil.dip2px(16.32f)));
            return new FacePageViewHolder(recyclerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class FaceViewHolder extends RecyclerView.ViewHolder {
        ImageView faceIv;

        public FaceViewHolder(View view) {
            super(view);
            this.faceIv = (ImageView) view.findViewById(R.id.face_iv);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class GridDecoration extends RecyclerView.ItemDecoration {
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
    public class MenuAdapter extends RecyclerView.Adapter<MenuItemViewHolder> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class MenuItemViewHolder extends RecyclerView.ViewHolder {
            public ImageView icon;
            public TextView title;

            public MenuItemViewHolder(View view) {
                super(view);
                this.title = (TextView) view.findViewById(R.id.menu_title);
                this.icon = (ImageView) view.findViewById(R.id.menu_icon);
            }
        }

        MenuAdapter() {
        }

        public int getItemCount() {
            return ChatPopMenu.this.chatPopMenuActionList.size();
        }

        public void onBindViewHolder(MenuItemViewHolder menuItemViewHolder, int i) {
            final ChatPopMenuAction chatPopMenuAction = ChatPopMenu.this.getChatPopMenuAction(i);
            menuItemViewHolder.title.setText(chatPopMenuAction.actionName);
            menuItemViewHolder.icon.setImageDrawable(h.f(ChatPopMenu.this.context.getResources(), chatPopMenuAction.actionIcon, (Resources.Theme) null));
            ((RecyclerView.ViewHolder) menuItemViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.component.popmenu.ChatPopMenu.MenuAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    chatPopMenuAction.actionClickListener.onClick();
                    ChatPopMenu.this.chatPopMenu.hide();
                    if (ChatPopMenu.this.mEmptySpaceClickListener != null) {
                        ChatPopMenu.this.mEmptySpaceClickListener.onClick();
                    }
                }
            });
        }

        public MenuItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MenuItemViewHolder(LayoutInflater.from(ChatPopMenu.this.context).inflate(R.layout.chat_pop_menu_item_layout, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class PopIndicatorDrawable extends Drawable {
        private final View anchorView;
        private final int indicatorHeight;
        private final Paint paint;
        private final Path path;
        private final float radius;

        public PopIndicatorDrawable(View view, int i, float f) {
            Paint paint = new Paint();
            this.paint = paint;
            this.path = new Path();
            this.radius = f;
            this.anchorView = view;
            this.indicatorHeight = i;
            paint.setColor(-1);
            paint.setStyle(Paint.Style.FILL);
            paint.setShadowLayer(10.0f, 0.0f, 0.0f, -5592406);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            float width = bounds.width();
            float height = bounds.height();
            float width2 = this.anchorView.getWidth();
            int[] iArr = new int[2];
            this.anchorView.getLocationOnScreen(iArr);
            boolean z = false;
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = new int[2];
            ChatPopMenu.this.popupView.getLocationOnScreen(iArr2);
            int i3 = (int) ((i + (width2 / 2.0f)) - iArr2[0]);
            if (i2 < iArr2[1]) {
                z = true;
            }
            this.path.reset();
            if (z) {
                float f = this.indicatorHeight + 10;
                Path path = this.path;
                RectF rectF = new RectF(10.0f, f, width - 10.0f, height - 10.0f);
                float f2 = this.radius;
                path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
                this.path.moveTo(i3 - this.indicatorHeight, f);
                this.path.lineTo(i3, f - this.indicatorHeight);
                this.path.lineTo(i3 + this.indicatorHeight, f);
            } else {
                float f3 = (height - 10.0f) - this.indicatorHeight;
                Path path2 = this.path;
                RectF rectF2 = new RectF(10.0f, 10.0f, width - 10.0f, f3);
                float f4 = this.radius;
                path2.addRoundRect(rectF2, f4, f4, Path.Direction.CW);
                this.path.moveTo(i3 - this.indicatorHeight, f3);
                this.path.lineTo(i3, this.indicatorHeight + f3);
                this.path.lineTo(i3 + this.indicatorHeight, f3);
            }
            this.path.close();
            canvas.drawPath(this.path, this.paint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class RecentFaceAdapter extends RecyclerView.Adapter<RecentFaceViewHolder> {

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
            for (Emoji emoji : ChatPopMenu.this.emojiList) {
                if (TextUtils.equals(emoji.getFaceKey(), str)) {
                    return emoji;
                }
            }
            return null;
        }

        public int getItemCount() {
            return 7;
        }

        public void onBindViewHolder(RecentFaceViewHolder recentFaceViewHolder, final int i) {
            final Emoji emoji;
            if (i != 6) {
                emoji = getEmoji((String) ChatPopMenu.this.recentEmojiList.get(i));
            } else {
                emoji = new Emoji();
                emoji.setIcon(!ChatPopMenu.this.isShowMoreFace ? BitmapFactory.decodeResource(ChatPopMenu.this.context.getResources(), R.drawable.chat_menu_face_show_more) : BitmapFactory.decodeResource(ChatPopMenu.this.context.getResources(), R.drawable.chat_menu_face_hide_more));
            }
            if (emoji == null) {
                return;
            }
            recentFaceViewHolder.faceIv.setImageBitmap(emoji.getIcon());
            if (ChatPopMenu.this.emojiOnClickListener != null) {
                recentFaceViewHolder.faceIv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.component.popmenu.ChatPopMenu.RecentFaceAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i == 6) {
                            ChatPopMenu.this.isShowMoreFace = !r2.isShowMoreFace;
                            ChatPopMenu.this.refreshLayout();
                            RecentFaceAdapter.this.notifyItemChanged(i);
                            return;
                        }
                        ChatPopMenu.this.emojiOnClickListener.onClick(emoji);
                        ChatPopMenu.this.updateRecentEmoji(emoji);
                        ChatPopMenu.this.hide();
                    }
                });
            }
        }

        public RecentFaceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new RecentFaceViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_menu_recent_face_item_layout, viewGroup, false));
        }
    }

    public ChatPopMenu(Context context) {
        this.context = context;
        initEmojiList();
        View inflate = LayoutInflater.from(context).inflate(R.layout.chat_pop_menu_layout, (ViewGroup) null);
        this.popupView = inflate;
        this.indicatorHeight = context.getResources().getDimensionPixelOffset(R.dimen.chat_pop_menu_indicator_height);
        inflate.setPadding(inflate.getPaddingLeft() + 10, inflate.getPaddingTop() + 10, inflate.getPaddingRight() + 10, inflate.getPaddingBottom() + 10);
        RecyclerView findViewById = inflate.findViewById(R.id.chat_pop_menu_content_view);
        this.actionRecyclerView = findViewById;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 5);
        this.actionGridLayoutManager = gridLayoutManager;
        findViewById.setLayoutManager(gridLayoutManager);
        findViewById.addItemDecoration(new GridDecoration(null, 5, context.getResources().getDimensionPixelSize(R.dimen.chat_pop_menu_item_space_width), context.getResources().getDimensionPixelSize(R.dimen.chat_pop_menu_item_space_height)));
        MenuAdapter menuAdapter = new MenuAdapter();
        this.menuAdapter = menuAdapter;
        findViewById.setAdapter(menuAdapter);
        this.divideLine = inflate.findViewById(R.id.divide_line);
        RecyclerView findViewById2 = inflate.findViewById(R.id.recent_faces);
        this.recentFaceView = findViewById2;
        findViewById2.setItemAnimator((RecyclerView.ItemAnimator) null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        this.recentFaceView.addItemDecoration(new GridDecoration(null, 7, ScreenUtil.dip2px(13.44f), 0));
        this.recentFaceView.setLayoutManager(linearLayoutManager);
        this.recentFaceView.setAdapter(new RecentFaceAdapter());
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.face_grid_ll);
        this.facePageLinearLayout = linearLayout;
        RecyclerView findViewById3 = inflate.findViewById(R.id.face_grid);
        this.facePageRecyclerView = findViewById3;
        this.facePageIndicator = (EmojiIndicatorView) inflate.findViewById(R.id.face_indicator);
        linearLayout.setVisibility(8);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(context, 0, false);
        new PagerSnapHelper().attachToRecyclerView(findViewById3);
        findViewById3.setLayoutManager(linearLayoutManager2);
        FacePageAdapter facePageAdapter = new FacePageAdapter();
        this.facePageAdapter = facePageAdapter;
        findViewById3.setAdapter(facePageAdapter);
        setFacePageIndicator(linearLayoutManager2);
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, false);
        this.popupWindow = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setTouchable(true);
        popupWindow.setAnimationStyle(R.style.ChatPopMenuAnimation);
        popupWindow.setOutsideTouchable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatPopMenuAction getChatPopMenuAction(int i) {
        return this.chatPopMenuActionList.get(i);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshLayout() {
        if (this.isShowMoreFace) {
            this.facePageLinearLayout.setVisibility(0);
            this.actionRecyclerView.setVisibility(8);
            this.divideLine.setVisibility(0);
        } else {
            this.facePageLinearLayout.setVisibility(8);
            if (this.chatPopMenuActionList.isEmpty()) {
                this.divideLine.setVisibility(8);
                this.actionRecyclerView.setVisibility(8);
            } else {
                this.divideLine.setVisibility(0);
                this.actionRecyclerView.setVisibility(0);
            }
        }
        showAtLocation();
    }

    private void setFacePageIndicator(final LinearLayoutManager linearLayoutManager) {
        this.facePageIndicator.init(this.facePageAdapter.getItemCount());
        this.facePageRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.component.popmenu.ChatPopMenu.1
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                int findFirstVisibleItemPosition;
                if (i >= 0) {
                    findFirstVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                } else {
                    findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                }
                if (findFirstVisibleItemPosition != -1 && ChatPopMenu.this.oldFacePageIndex != findFirstVisibleItemPosition) {
                    ChatPopMenu.this.facePageIndicator.playBy(ChatPopMenu.this.oldFacePageIndex, findFirstVisibleItemPosition);
                    ChatPopMenu.this.oldFacePageIndex = findFirstVisibleItemPosition;
                }
            }
        });
    }

    private void showAtLocation() {
        int i;
        View view = this.popupView;
        view.setPadding(view.getPaddingLeft(), this.popupView.getPaddingTop() - this.paddingTopOffset, this.popupView.getPaddingRight(), this.popupView.getPaddingBottom() - this.paddingBottomOffset);
        this.paddingTopOffset = 0;
        this.paddingBottomOffset = 0;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.popupView.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredWidth = this.popupView.getMeasuredWidth();
        int measuredHeight = this.popupView.getMeasuredHeight();
        float width = this.anchorView.getWidth();
        float height = this.anchorView.getHeight();
        int[] iArr = new int[2];
        this.anchorView.getLocationOnScreen(iArr);
        int screenWidth = ScreenUtil.getScreenWidth(this.context);
        int i2 = iArr[0];
        int i3 = this.indicatorHeight;
        int i4 = i2 - i3;
        int i5 = iArr[1];
        int i6 = (i5 - measuredHeight) - i3;
        if ((i2 * 2) + width > screenWidth) {
            i4 = ((int) ((i2 + width) - measuredWidth)) + i3;
        }
        int i7 = i4;
        if (i6 <= this.minY) {
            this.paddingTopOffset = i3;
            View view2 = this.popupView;
            view2.setPadding(view2.getPaddingLeft(), this.popupView.getPaddingTop() + this.paddingTopOffset, this.popupView.getPaddingRight(), this.popupView.getPaddingBottom());
            i = (int) (i5 + height + i3);
        } else {
            this.paddingBottomOffset = i3;
            View view3 = this.popupView;
            view3.setPadding(view3.getPaddingLeft(), this.popupView.getPaddingTop(), this.popupView.getPaddingRight(), this.popupView.getPaddingBottom() + this.paddingBottomOffset);
            i = i6 - this.indicatorHeight;
        }
        if (this.popupWindow.isShowing()) {
            this.popupWindow.update(i7, i, -1, -1, true);
        } else {
            this.popupWindow.showAtLocation(this.anchorView, 0, i7, i);
        }
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

    public void hide() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.popupWindow.dismiss();
        }
    }

    public void setChatPopMenuActionList(List<ChatPopMenuAction> list) {
        this.chatPopMenuActionList.clear();
        this.chatPopMenuActionList.addAll(list);
        if (!this.chatPopMenuActionList.isEmpty() && this.chatPopMenuActionList.size() < 5) {
            this.actionGridLayoutManager.setSpanCount(this.chatPopMenuActionList.size());
        }
        this.menuAdapter.notifyDataSetChanged();
    }

    public void setEmojiOnClickListener(EmojiOnClickListener emojiOnClickListener) {
        this.emojiOnClickListener = emojiOnClickListener;
    }

    public void setEmptySpaceClickListener(MessageRecyclerView.OnEmptySpaceClickListener onEmptySpaceClickListener) {
        this.mEmptySpaceClickListener = onEmptySpaceClickListener;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.setOnDismissListener(onDismissListener);
        }
    }

    public void setShowFaces(boolean z) {
        this.isShowFaces = z;
    }

    public void show(View view, int i) {
        this.anchorView = view;
        this.minY = i;
        if (!this.isShowFaces) {
            this.recentFaceView.setVisibility(8);
            this.divideLine.setVisibility(8);
        } else {
            this.recentFaceView.setVisibility(0);
            if (this.chatPopMenuActionList.isEmpty()) {
                this.divideLine.setVisibility(8);
                this.actionRecyclerView.setVisibility(8);
            } else {
                this.divideLine.setVisibility(0);
                this.actionRecyclerView.setVisibility(0);
            }
        }
        this.popupView.setLayerType(1, null);
        this.popupView.setBackground(new PopIndicatorDrawable(view, this.indicatorHeight, 16.0f));
        showAtLocation();
    }
}
