package com.qiahao.nextvideo.ui.matchinghistoric.adapter;

import android.annotation.SuppressLint;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.databinding.CellHistoryUserInformationSummaryBinding;
import com.qiahao.nextvideo.ui.matchinghistoric.ProfileDetailUIModel;
import com.qiahao.nextvideo.ui.matchinghistoric.adapter.UserInformationSummaryPagerViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0017J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0014\u0010\u001c\u001a\u00020\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eJ\u0014\u0010\u001f\u001a\u00020\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eJ\"\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/qiahao/nextvideo/ui/matchinghistoric/adapter/PairingUserInformationSummaryPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/qiahao/nextvideo/ui/matchinghistoric/adapter/UserInformationSummaryPagerViewHolder;", "<init>", "()V", "items", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "downY", "", "delegate", "Lcom/qiahao/nextvideo/ui/matchinghistoric/adapter/PairingUserInformationSummaryPagerAdapterDelegate;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/matchinghistoric/adapter/PairingUserInformationSummaryPagerAdapterDelegate;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/matchinghistoric/adapter/PairingUserInformationSummaryPagerAdapterDelegate;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "", "holder", "position", "addItems", "uiModelProfiles", "", "reloadItems", "reloadItem", "uiModelProfile", "selectedPosition", "payload", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PairingUserInformationSummaryPagerAdapter extends RecyclerView.Adapter<UserInformationSummaryPagerViewHolder> {

    @Nullable
    private PairingUserInformationSummaryPagerAdapterDelegate delegate;
    private int downY;

    @NotNull
    private final ArrayList<ProfileDetailUIModel> items = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateViewHolder$lambda$11$lambda$10(UserInformationSummaryPagerViewHolder userInformationSummaryPagerViewHolder, PairingUserInformationSummaryPagerAdapter pairingUserInformationSummaryPagerAdapter, View view) {
        Integer num = (Integer) ((RecyclerView.ViewHolder) userInformationSummaryPagerViewHolder).itemView.getTag();
        if (num != null) {
            int intValue = num.intValue();
            PairingUserInformationSummaryPagerAdapterDelegate pairingUserInformationSummaryPagerAdapterDelegate = pairingUserInformationSummaryPagerAdapter.delegate;
            if (pairingUserInformationSummaryPagerAdapterDelegate != null) {
                ProfileDetailUIModel profileDetailUIModel = pairingUserInformationSummaryPagerAdapter.items.get(intValue);
                Intrinsics.checkNotNullExpressionValue(profileDetailUIModel, "get(...)");
                pairingUserInformationSummaryPagerAdapterDelegate.pairingUserInformationSummaryPagerAdapterDelegateDidVideoCall(profileDetailUIModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateViewHolder$lambda$11$lambda$2(UserInformationSummaryPagerViewHolder userInformationSummaryPagerViewHolder, PairingUserInformationSummaryPagerAdapter pairingUserInformationSummaryPagerAdapter, View view) {
        Integer num = (Integer) ((RecyclerView.ViewHolder) userInformationSummaryPagerViewHolder).itemView.getTag();
        if (num != null) {
            int intValue = num.intValue();
            PairingUserInformationSummaryPagerAdapterDelegate pairingUserInformationSummaryPagerAdapterDelegate = pairingUserInformationSummaryPagerAdapter.delegate;
            if (pairingUserInformationSummaryPagerAdapterDelegate != null) {
                ProfileDetailUIModel profileDetailUIModel = pairingUserInformationSummaryPagerAdapter.items.get(intValue);
                Intrinsics.checkNotNullExpressionValue(profileDetailUIModel, "get(...)");
                pairingUserInformationSummaryPagerAdapterDelegate.pairingUserInformationSummaryPagerAdapterDelegateDidReport(profileDetailUIModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateViewHolder$lambda$11$lambda$4(UserInformationSummaryPagerViewHolder userInformationSummaryPagerViewHolder, PairingUserInformationSummaryPagerAdapter pairingUserInformationSummaryPagerAdapter, View view) {
        Integer num = (Integer) ((RecyclerView.ViewHolder) userInformationSummaryPagerViewHolder).itemView.getTag();
        if (num != null) {
            int intValue = num.intValue();
            PairingUserInformationSummaryPagerAdapterDelegate pairingUserInformationSummaryPagerAdapterDelegate = pairingUserInformationSummaryPagerAdapter.delegate;
            if (pairingUserInformationSummaryPagerAdapterDelegate != null) {
                ProfileDetailUIModel profileDetailUIModel = pairingUserInformationSummaryPagerAdapter.items.get(intValue);
                Intrinsics.checkNotNullExpressionValue(profileDetailUIModel, "get(...)");
                pairingUserInformationSummaryPagerAdapterDelegate.pairingUserInformationSummaryPagerAdapterDelegateDidDelete(profileDetailUIModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateViewHolder$lambda$11$lambda$6(UserInformationSummaryPagerViewHolder userInformationSummaryPagerViewHolder, PairingUserInformationSummaryPagerAdapter pairingUserInformationSummaryPagerAdapter, View view) {
        Integer num = (Integer) ((RecyclerView.ViewHolder) userInformationSummaryPagerViewHolder).itemView.getTag();
        if (num != null) {
            int intValue = num.intValue();
            PairingUserInformationSummaryPagerAdapterDelegate pairingUserInformationSummaryPagerAdapterDelegate = pairingUserInformationSummaryPagerAdapter.delegate;
            if (pairingUserInformationSummaryPagerAdapterDelegate != null) {
                ProfileDetailUIModel profileDetailUIModel = pairingUserInformationSummaryPagerAdapter.items.get(intValue);
                Intrinsics.checkNotNullExpressionValue(profileDetailUIModel, "get(...)");
                pairingUserInformationSummaryPagerAdapterDelegate.pairingUserInformationSummaryPagerAdapterDelegateDidChat(profileDetailUIModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateViewHolder$lambda$11$lambda$8(UserInformationSummaryPagerViewHolder userInformationSummaryPagerViewHolder, PairingUserInformationSummaryPagerAdapter pairingUserInformationSummaryPagerAdapter, View view) {
        Integer num = (Integer) ((RecyclerView.ViewHolder) userInformationSummaryPagerViewHolder).itemView.getTag();
        if (num != null) {
            int intValue = num.intValue();
            PairingUserInformationSummaryPagerAdapterDelegate pairingUserInformationSummaryPagerAdapterDelegate = pairingUserInformationSummaryPagerAdapter.delegate;
            if (pairingUserInformationSummaryPagerAdapterDelegate != null) {
                ProfileDetailUIModel profileDetailUIModel = pairingUserInformationSummaryPagerAdapter.items.get(intValue);
                Intrinsics.checkNotNullExpressionValue(profileDetailUIModel, "get(...)");
                pairingUserInformationSummaryPagerAdapterDelegate.pairingUserInformationSummaryPagerAdapterDelegateDidLike(profileDetailUIModel);
            }
        }
    }

    public static /* synthetic */ void reloadItem$default(PairingUserInformationSummaryPagerAdapter pairingUserInformationSummaryPagerAdapter, ProfileDetailUIModel profileDetailUIModel, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            obj = null;
        }
        pairingUserInformationSummaryPagerAdapter.reloadItem(profileDetailUIModel, i, obj);
    }

    public final void addItems(@NotNull List<ProfileDetailUIModel> uiModelProfiles) {
        Intrinsics.checkNotNullParameter(uiModelProfiles, "uiModelProfiles");
        this.items.addAll(uiModelProfiles);
        notifyDataSetChanged();
    }

    @Nullable
    public final PairingUserInformationSummaryPagerAdapterDelegate getDelegate() {
        return this.delegate;
    }

    public int getItemCount() {
        return this.items.size();
    }

    @NotNull
    public final ArrayList<ProfileDetailUIModel> getItems() {
        return this.items;
    }

    public final void reloadItem(@NotNull ProfileDetailUIModel uiModelProfile, int selectedPosition, @Nullable Object payload) {
        Intrinsics.checkNotNullParameter(uiModelProfile, "uiModelProfile");
        this.items.set(selectedPosition, uiModelProfile);
        notifyItemChanged(selectedPosition, payload);
    }

    public final void reloadItems(@NotNull List<ProfileDetailUIModel> uiModelProfiles) {
        Intrinsics.checkNotNullParameter(uiModelProfiles, "uiModelProfiles");
        this.items.clear();
        this.items.addAll(uiModelProfiles);
        notifyDataSetChanged();
    }

    public final void setDelegate(@Nullable PairingUserInformationSummaryPagerAdapterDelegate pairingUserInformationSummaryPagerAdapterDelegate) {
        this.delegate = pairingUserInformationSummaryPagerAdapterDelegate;
    }

    public void onBindViewHolder(@NotNull UserInformationSummaryPagerViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ProfileDetailUIModel profileDetailUIModel = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(profileDetailUIModel, "get(...)");
        holder.bind(profileDetailUIModel);
        ((RecyclerView.ViewHolder) holder).itemView.setTag(Integer.valueOf(position));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    public UserInformationSummaryPagerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        CellHistoryUserInformationSummaryBinding inflate = CellHistoryUserInformationSummaryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        final UserInformationSummaryPagerViewHolder userInformationSummaryPagerViewHolder = new UserInformationSummaryPagerViewHolder(inflate);
        final GestureDetector gestureDetector = new GestureDetector(userInformationSummaryPagerViewHolder.getBinding().getRoot().getContext(), new UserInformationSummaryPagerViewHolder.SimpleOnGestureListener() { // from class: com.qiahao.nextvideo.ui.matchinghistoric.adapter.PairingUserInformationSummaryPagerAdapter$onCreateViewHolder$1$gestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                Integer num = (Integer) ((RecyclerView.ViewHolder) UserInformationSummaryPagerViewHolder.this).itemView.getTag();
                if (num != null) {
                    PairingUserInformationSummaryPagerAdapter pairingUserInformationSummaryPagerAdapter = this;
                    int intValue = num.intValue();
                    PairingUserInformationSummaryPagerAdapterDelegate delegate = pairingUserInformationSummaryPagerAdapter.getDelegate();
                    if (delegate != null) {
                        ProfileDetailUIModel profileDetailUIModel = pairingUserInformationSummaryPagerAdapter.getItems().get(intValue);
                        Intrinsics.checkNotNullExpressionValue(profileDetailUIModel, "get(...)");
                        delegate.pairingUserInformationSummaryPagerAdapterDelegateDidDoubleTap(profileDetailUIModel);
                    }
                }
                return super.onDoubleTap(e);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                Integer num = (Integer) ((RecyclerView.ViewHolder) UserInformationSummaryPagerViewHolder.this).itemView.getTag();
                if (num != null) {
                    PairingUserInformationSummaryPagerAdapter pairingUserInformationSummaryPagerAdapter = this;
                    int intValue = num.intValue();
                    PairingUserInformationSummaryPagerAdapterDelegate delegate = pairingUserInformationSummaryPagerAdapter.getDelegate();
                    if (delegate != null) {
                        ProfileDetailUIModel profileDetailUIModel = pairingUserInformationSummaryPagerAdapter.getItems().get(intValue);
                        Intrinsics.checkNotNullExpressionValue(profileDetailUIModel, "get(...)");
                        delegate.pairingUserInformationSummaryPagerAdapterDelegateDidSingleTap(profileDetailUIModel);
                    }
                }
                return super.onSingleTapConfirmed(e);
            }
        });
        userInformationSummaryPagerViewHolder.getBinding().userProfilePictureCorneredImageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.qiahao.nextvideo.ui.matchinghistoric.adapter.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean onTouchEvent;
                onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
                return onTouchEvent;
            }
        });
        userInformationSummaryPagerViewHolder.getBinding().reportImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.matchinghistoric.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PairingUserInformationSummaryPagerAdapter.onCreateViewHolder$lambda$11$lambda$2(UserInformationSummaryPagerViewHolder.this, this, view);
            }
        });
        userInformationSummaryPagerViewHolder.getBinding().deleteImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.matchinghistoric.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PairingUserInformationSummaryPagerAdapter.onCreateViewHolder$lambda$11$lambda$4(UserInformationSummaryPagerViewHolder.this, this, view);
            }
        });
        userInformationSummaryPagerViewHolder.getBinding().chatImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.matchinghistoric.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PairingUserInformationSummaryPagerAdapter.onCreateViewHolder$lambda$11$lambda$6(UserInformationSummaryPagerViewHolder.this, this, view);
            }
        });
        userInformationSummaryPagerViewHolder.getBinding().likedImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.matchinghistoric.adapter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PairingUserInformationSummaryPagerAdapter.onCreateViewHolder$lambda$11$lambda$8(UserInformationSummaryPagerViewHolder.this, this, view);
            }
        });
        userInformationSummaryPagerViewHolder.getBinding().videoCallImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.matchinghistoric.adapter.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PairingUserInformationSummaryPagerAdapter.onCreateViewHolder$lambda$11$lambda$10(UserInformationSummaryPagerViewHolder.this, this, view);
            }
        });
        return userInformationSummaryPagerViewHolder;
    }
}
