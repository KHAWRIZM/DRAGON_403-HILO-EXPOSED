package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu;

import android.app.Dialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatPopMenuEmojiDialogFragment extends DialogFragment {
    public static final int SPAN_COUNT = 7;
    private BottomSheetDialog dialog;
    private EmojiClickListener emojiClickListener;
    private RecyclerView emojiGridList;
    private List<Emoji> emojiList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class EmojiAdapter extends RecyclerView.Adapter<EmojiHolder> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class EmojiHolder extends RecyclerView.ViewHolder {
            private final ImageView emojiImg;

            public EmojiHolder(View view) {
                super(view);
                this.emojiImg = (ImageView) view.findViewById(R.id.emoji_img);
            }
        }

        EmojiAdapter() {
        }

        public int getItemCount() {
            if (ChatPopMenuEmojiDialogFragment.this.emojiList == null) {
                return 0;
            }
            return ChatPopMenuEmojiDialogFragment.this.emojiList.size();
        }

        public void onBindViewHolder(EmojiHolder emojiHolder, int i) {
            final Emoji emoji = (Emoji) ChatPopMenuEmojiDialogFragment.this.emojiList.get(i);
            emojiHolder.emojiImg.setImageBitmap(emoji.getIcon());
            ((RecyclerView.ViewHolder) emojiHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopMenuEmojiDialogFragment.EmojiAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ChatPopMenuEmojiDialogFragment.this.emojiClickListener != null) {
                        ChatPopMenuEmojiDialogFragment.this.emojiClickListener.onClick(emoji);
                    }
                    ChatPopMenuEmojiDialogFragment.this.dismiss();
                }
            });
        }

        public EmojiHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new EmojiHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_pop_menu_emoji_item_layout, viewGroup, false));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    interface EmojiClickListener {
        void onClick(Emoji emoji);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class FaceGridDecoration extends RecyclerView.ItemDecoration {
        private final int columnNum;
        private int itemWidth;
        private int topBottomSpace;
        private int width;

        public FaceGridDecoration(int i) {
            this.columnNum = i;
        }

        private int getLeftRightSpace() {
            int i = this.width;
            int i2 = this.columnNum;
            return (i - (this.itemWidth * i2)) / (i2 - 1);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view) % this.columnNum;
            int leftRightSpace = getLeftRightSpace();
            int i = this.columnNum;
            rect.left = (childAdapterPosition * leftRightSpace) / i;
            rect.right = (leftRightSpace * ((i - 1) - childAdapterPosition)) / i;
            int i2 = this.topBottomSpace;
            rect.top = i2;
            rect.bottom = i2;
        }

        public FaceGridDecoration setItemWidth(int i) {
            this.itemWidth = i;
            return this;
        }

        public FaceGridDecoration setTopBottomSpace(int i) {
            this.topBottomSpace = i;
            return this;
        }

        public FaceGridDecoration setWidth(int i) {
            this.width = i;
            return this;
        }
    }

    private void initData() {
        this.emojiList = FaceManager.getEmojiList();
        this.emojiGridList.setLayoutManager(new GridLayoutManager(getContext(), 7));
        this.emojiGridList.setAdapter(new EmojiAdapter());
        this.emojiGridList.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopMenuEmojiDialogFragment.1
            @Override // java.lang.Runnable
            public void run() {
                ChatPopMenuEmojiDialogFragment.this.emojiGridList.addItemDecoration(new FaceGridDecoration(7).setTopBottomSpace(ScreenUtil.dip2px(10.0f)).setWidth(ChatPopMenuEmojiDialogFragment.this.emojiGridList.getWidth()).setItemWidth(ChatPopMenuEmojiDialogFragment.this.emojiGridList.getChildAt(0).getWidth()));
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
        behavior.c(3);
        return this.dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.chat_popmenu_emoji_dialog_layout, viewGroup);
        this.emojiGridList = inflate.findViewById(R.id.emoji_grid_list);
        initData();
        return inflate;
    }

    public void setEmojiClickListener(EmojiClickListener emojiClickListener) {
        this.emojiClickListener = emojiClickListener;
    }
}
