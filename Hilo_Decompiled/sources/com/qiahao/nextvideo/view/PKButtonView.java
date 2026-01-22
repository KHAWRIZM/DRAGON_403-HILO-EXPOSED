package com.qiahao.nextvideo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.g;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.data.room.RoomPKScore;
import com.qiahao.nextvideo.data.room.RoomPKScoreRes;
import com.qiahao.nextvideo.data.room.RoomPKUser;
import com.qiahao.nextvideo.databinding.RoomButtonPkBinding;
import com.qiahao.nextvideo.room.dialog.PKSupportDialog;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\rJ\b\u0010\u0015\u001a\u00020\u0013H\u0007J0\u0010\u0016\u001a\u00020\u00132\u001c\b\u0002\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/view/PKButtonView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/qiahao/nextvideo/databinding/RoomButtonPkBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/RoomButtonPkBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/RoomButtonPkBinding;)V", "initView", "", "getRootBinding", "refreshPro", "refreshAvatar", "list", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/room/RoomPKUser;", "Lkotlin/collections/ArrayList;", "isInvite", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPKButtonView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PKButtonView.kt\ncom/qiahao/nextvideo/view/PKButtonView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,126:1\n1869#2,2:127\n61#3,9:129\n61#3,9:138\n*S KotlinDebug\n*F\n+ 1 PKButtonView.kt\ncom/qiahao/nextvideo/view/PKButtonView\n*L\n73#1:127,2\n52#1:129,9\n55#1:138,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PKButtonView extends FrameLayout {

    @Nullable
    private RoomButtonPkBinding binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PKButtonView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView() {
        View root;
        RoomButtonPkBinding roomButtonPkBinding = (RoomButtonPkBinding) g.h(LayoutInflater.from(getContext()), R.layout.room_button_pk, this, true);
        this.binding = roomButtonPkBinding;
        if (roomButtonPkBinding != null && (root = roomButtonPkBinding.getRoot()) != null) {
            root.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.view.a
                @Override // java.lang.Runnable
                public final void run() {
                    PKButtonView.initView$lambda$2(PKButtonView.this);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(final PKButtonView pKButtonView) {
        final View view;
        final View view2;
        TextView textView;
        View view3;
        pKButtonView.setBackgroundColor(androidx.core.content.a.getColor(pKButtonView.getContext(), 2131101182));
        RoomButtonPkBinding roomButtonPkBinding = pKButtonView.binding;
        if (roomButtonPkBinding != null && (view3 = roomButtonPkBinding.buttonBg) != null) {
            ImageKtxKt.toHorizontalMirror(view3, R.drawable.pk_chest_bg);
        }
        RoomButtonPkBinding roomButtonPkBinding2 = pKButtonView.binding;
        if (roomButtonPkBinding2 != null && (textView = roomButtonPkBinding2.level) != null) {
            textView.setBackground(ShapeUtil.INSTANCE.createShape("#FFFD79", "#FFC300", 5, GradientDrawable.Orientation.TOP_BOTTOM));
        }
        RoomButtonPkBinding roomButtonPkBinding3 = pKButtonView.binding;
        final long j = 800;
        if (roomButtonPkBinding3 != null && (view2 = roomButtonPkBinding3.redClick) != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.view.PKButtonView$initView$lambda$2$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    GroupDetailBean groupDetailBean;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(view2) > j || (view2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(view2, currentTimeMillis);
                        Context context = pKButtonView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
                        if (mpk != null) {
                            groupDetailBean = mpk.getInviteGroup();
                        } else {
                            groupDetailBean = null;
                        }
                        new PKSupportDialog(context, groupDetailBean, true).show();
                    }
                }
            });
        }
        RoomButtonPkBinding roomButtonPkBinding4 = pKButtonView.binding;
        if (roomButtonPkBinding4 != null && (view = roomButtonPkBinding4.blueClick) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.view.PKButtonView$initView$lambda$2$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    GroupDetailBean groupDetailBean;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(view) > j || (view instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(view, currentTimeMillis);
                        Context context = pKButtonView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
                        if (mpk != null) {
                            groupDetailBean = mpk.getReceiveGroup();
                        } else {
                            groupDetailBean = null;
                        }
                        new PKSupportDialog(context, groupDetailBean, false).show();
                    }
                }
            });
        }
    }

    private final void refreshAvatar(ArrayList<RoomPKUser> list, boolean isInvite) {
        int i;
        int i2;
        int i3;
        RoomButtonPkBinding roomButtonPkBinding;
        QMUIRadiusImageView qMUIRadiusImageView;
        String str;
        RoomPKUser roomPKUser;
        String avatar;
        RoomButtonPkBinding roomButtonPkBinding2;
        QMUIRadiusImageView qMUIRadiusImageView2;
        String str2;
        RoomPKUser roomPKUser2;
        String avatar2;
        RoomButtonPkBinding roomButtonPkBinding3;
        QMUIRadiusImageView qMUIRadiusImageView3;
        String str3;
        RoomPKUser roomPKUser3;
        String avatar3;
        int i4;
        int i5;
        int i6;
        RoomButtonPkBinding roomButtonPkBinding4;
        QMUIRadiusImageView qMUIRadiusImageView4;
        String str4;
        RoomPKUser roomPKUser4;
        String avatar4;
        RoomButtonPkBinding roomButtonPkBinding5;
        QMUIRadiusImageView qMUIRadiusImageView5;
        String str5;
        RoomPKUser roomPKUser5;
        String avatar5;
        RoomButtonPkBinding roomButtonPkBinding6;
        QMUIRadiusImageView qMUIRadiusImageView6;
        String str6;
        RoomPKUser roomPKUser6;
        String avatar6;
        if (isInvite) {
            if (list != null) {
                i4 = list.size();
            } else {
                i4 = 0;
            }
            if (i4 >= 1 && (roomButtonPkBinding6 = this.binding) != null && (qMUIRadiusImageView6 = roomButtonPkBinding6.redOne) != null) {
                if (list == null || (roomPKUser6 = list.get(0)) == null || (avatar6 = roomPKUser6.getAvatar()) == null) {
                    str6 = "";
                } else {
                    str6 = avatar6;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView6, str6, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
            if (list != null) {
                i5 = list.size();
            } else {
                i5 = 0;
            }
            if (i5 >= 2 && (roomButtonPkBinding5 = this.binding) != null && (qMUIRadiusImageView5 = roomButtonPkBinding5.redTwo) != null) {
                if (list == null || (roomPKUser5 = list.get(1)) == null || (avatar5 = roomPKUser5.getAvatar()) == null) {
                    str5 = "";
                } else {
                    str5 = avatar5;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView5, str5, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
            if (list != null) {
                i6 = list.size();
            } else {
                i6 = 0;
            }
            if (i6 >= 3 && (roomButtonPkBinding4 = this.binding) != null && (qMUIRadiusImageView4 = roomButtonPkBinding4.redThree) != null) {
                if (list == null || (roomPKUser4 = list.get(2)) == null || (avatar4 = roomPKUser4.getAvatar()) == null) {
                    str4 = "";
                } else {
                    str4 = avatar4;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView4, str4, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
                return;
            }
            return;
        }
        if (list != null) {
            i = list.size();
        } else {
            i = 0;
        }
        if (i >= 1 && (roomButtonPkBinding3 = this.binding) != null && (qMUIRadiusImageView3 = roomButtonPkBinding3.blueOne) != null) {
            if (list == null || (roomPKUser3 = list.get(0)) == null || (avatar3 = roomPKUser3.getAvatar()) == null) {
                str3 = "";
            } else {
                str3 = avatar3;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView3, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        }
        if (list != null) {
            i2 = list.size();
        } else {
            i2 = 0;
        }
        if (i2 >= 2 && (roomButtonPkBinding2 = this.binding) != null && (qMUIRadiusImageView2 = roomButtonPkBinding2.blueTwo) != null) {
            if (list == null || (roomPKUser2 = list.get(1)) == null || (avatar2 = roomPKUser2.getAvatar()) == null) {
                str2 = "";
            } else {
                str2 = avatar2;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        }
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        if (i3 >= 3 && (roomButtonPkBinding = this.binding) != null && (qMUIRadiusImageView = roomButtonPkBinding.blueThree) != null) {
            if (list == null || (roomPKUser = list.get(2)) == null || (avatar = roomPKUser.getAvatar()) == null) {
                str = "";
            } else {
                str = avatar;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void refreshAvatar$default(PKButtonView pKButtonView, ArrayList arrayList, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        pKButtonView.refreshAvatar(arrayList, z);
    }

    @Nullable
    public final RoomButtonPkBinding getBinding() {
        return this.binding;
    }

    @Nullable
    public final RoomButtonPkBinding getRootBinding() {
        return this.binding;
    }

    @SuppressLint({"SetTextI18n"})
    public final void refreshPro() {
        RoomPKScoreRes roomPKPro;
        RoomPKScore roomPKScore;
        RoomPKScore roomPKScore2;
        ArrayList<RoomPKUser> arrayList;
        ArrayList<RoomPKUser> arrayList2;
        long j;
        long j2;
        long j3;
        float f;
        View view;
        Long score;
        Long score2;
        Long score3;
        View view2;
        TextView textView;
        long j4;
        Long score4;
        TextView textView2;
        long j5;
        Long score5;
        TextView textView3;
        String str;
        GroupDetailBean inviteGroup;
        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
        if (mpk != null && (roomPKPro = mpk.getRoomPKPro()) != null) {
            ArrayList<RoomPKScore> scoreInfo = roomPKPro.getScoreInfo();
            ViewGroup.LayoutParams layoutParams = null;
            if (scoreInfo != null) {
                roomPKScore = null;
                roomPKScore2 = null;
                for (RoomPKScore roomPKScore3 : scoreInfo) {
                    RoomPK mpk2 = MeetingRoomManager.INSTANCE.getMPK();
                    if (mpk2 != null && (inviteGroup = mpk2.getInviteGroup()) != null) {
                        str = inviteGroup.getGroupId();
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, roomPKScore3.getGroupId())) {
                        roomPKScore = roomPKScore3;
                    } else {
                        roomPKScore2 = roomPKScore3;
                    }
                }
            } else {
                roomPKScore = null;
                roomPKScore2 = null;
            }
            RoomButtonPkBinding roomButtonPkBinding = this.binding;
            if (roomButtonPkBinding != null && (textView3 = roomButtonPkBinding.level) != null) {
                textView3.setText("Lv." + roomPKPro.getBoxLevel());
            }
            if (roomPKScore != null) {
                arrayList = roomPKScore.getTopSupport();
            } else {
                arrayList = null;
            }
            refreshAvatar(arrayList, true);
            if (roomPKScore2 != null) {
                arrayList2 = roomPKScore2.getTopSupport();
            } else {
                arrayList2 = null;
            }
            refreshAvatar(arrayList2, false);
            RoomButtonPkBinding roomButtonPkBinding2 = this.binding;
            if (roomButtonPkBinding2 != null && (textView2 = roomButtonPkBinding2.redNumber) != null) {
                if (roomPKScore != null && (score5 = roomPKScore.getScore()) != null) {
                    j5 = score5.longValue();
                } else {
                    j5 = 0;
                }
                textView2.setText(String.valueOf(j5));
            }
            RoomButtonPkBinding roomButtonPkBinding3 = this.binding;
            if (roomButtonPkBinding3 != null && (textView = roomButtonPkBinding3.blueNumber) != null) {
                if (roomPKScore2 != null && (score4 = roomPKScore2.getScore()) != null) {
                    j4 = score4.longValue();
                } else {
                    j4 = 0;
                }
                textView.setText(String.valueOf(j4));
            }
            RoomButtonPkBinding roomButtonPkBinding4 = this.binding;
            if (roomButtonPkBinding4 != null && (view2 = roomButtonPkBinding4.redPro) != null) {
                layoutParams = view2.getLayoutParams();
            }
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.b) layoutParams;
            if (roomPKScore != null && (score3 = roomPKScore.getScore()) != null) {
                j = score3.longValue();
            } else {
                j = 0;
            }
            if (roomPKScore2 != null && (score2 = roomPKScore2.getScore()) != null) {
                j2 = score2.longValue();
            } else {
                j2 = 0;
            }
            long j6 = j + j2;
            if (roomPKScore != null && (score = roomPKScore.getScore()) != null) {
                j3 = score.longValue();
            } else {
                j3 = 0;
            }
            if (j6 == 0) {
                f = 0.5f;
            } else if (j3 == 0) {
                f = 0.0f;
            } else {
                f = ((float) j3) / ((float) j6);
            }
            ((ConstraintLayout.b) layoutParams2).V = f;
            RoomButtonPkBinding roomButtonPkBinding5 = this.binding;
            if (roomButtonPkBinding5 != null && (view = roomButtonPkBinding5.redPro) != null) {
                view.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void setBinding(@Nullable RoomButtonPkBinding roomButtonPkBinding) {
        this.binding = roomButtonPkBinding;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PKButtonView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PKButtonView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }
}
