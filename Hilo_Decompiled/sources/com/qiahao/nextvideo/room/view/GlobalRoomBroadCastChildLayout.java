package com.qiahao.nextvideo.room.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.DefaultMoreData;
import com.qiahao.nextvideo.data.model.SocketGlobalBroadCastBean;
import com.qiahao.nextvideo.databinding.LayoutGlobalBroad11Binding;
import com.qiahao.nextvideo.databinding.LayoutGlobalRoomBroadCastChildBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.dialog.SendGroupBroadcastDialog;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.base.DefaultMoreDialog;
import com.qiahao.nextvideo.ui.home.GlobalBroadActivity;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\nJ\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\"H\u0002J\u0006\u0010$\u001a\u00020\"J,\u0010%\u001a\u00020\"2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0006\u0010,\u001a\u00020-R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/qiahao/nextvideo/room/view/GlobalRoomBroadCastChildLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "globalBroadCastBean", "Lcom/qiahao/nextvideo/data/model/SocketGlobalBroadCastBean;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/model/SocketGlobalBroadCastBean;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/qiahao/nextvideo/data/model/SocketGlobalBroadCastBean;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mBindingDefault", "Lcom/qiahao/nextvideo/databinding/LayoutGlobalRoomBroadCastChildBinding;", "getMBindingDefault", "()Lcom/qiahao/nextvideo/databinding/LayoutGlobalRoomBroadCastChildBinding;", "setMBindingDefault", "(Lcom/qiahao/nextvideo/databinding/LayoutGlobalRoomBroadCastChildBinding;)V", "mBindingBroadCast11", "Lcom/qiahao/nextvideo/databinding/LayoutGlobalBroad11Binding;", "getMBindingBroadCast11", "()Lcom/qiahao/nextvideo/databinding/LayoutGlobalBroad11Binding;", "setMBindingBroadCast11", "(Lcom/qiahao/nextvideo/databinding/LayoutGlobalBroad11Binding;)V", "mGlobalBroadCastBean", "getMGlobalBroadCastBean", "()Lcom/qiahao/nextvideo/data/model/SocketGlobalBroadCastBean;", "setMGlobalBroadCastBean", "(Lcom/qiahao/nextvideo/data/model/SocketGlobalBroadCastBean;)V", "initView", "", "refreshBroadCast11View", "refreshDefaultView", "updateViewShow", "bgView", "Landroid/view/View;", TUIConstants.TUIChat.INPUT_MORE_ICON, "Landroid/widget/ImageView;", "content", "Landroid/widget/TextView;", "getCurrentSize", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGlobalRoomBroadCastChildLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlobalRoomBroadCastChildLayout.kt\ncom/qiahao/nextvideo/room/view/GlobalRoomBroadCastChildLayout\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,253:1\n439#2:254\n439#2:264\n439#2:265\n439#2:266\n439#2:267\n439#2:268\n439#2:269\n439#2:270\n61#3,9:255\n*S KotlinDebug\n*F\n+ 1 GlobalRoomBroadCastChildLayout.kt\ncom/qiahao/nextvideo/room/view/GlobalRoomBroadCastChildLayout\n*L\n91#1:254\n186#1:264\n192#1:265\n197#1:266\n202#1:267\n207#1:268\n212#1:269\n219#1:270\n92#1:255,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GlobalRoomBroadCastChildLayout extends LinearLayout {

    @NotNull
    private static final String TAG = "GlobalRoomBroadCastChil";

    @Nullable
    private LayoutGlobalBroad11Binding mBindingBroadCast11;

    @Nullable
    private LayoutGlobalRoomBroadCastChildBinding mBindingDefault;

    @NotNull
    private Context mContext;

    @Nullable
    private SocketGlobalBroadCastBean mGlobalBroadCastBean;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlobalRoomBroadCastChildLayout(@NotNull Context context, @NotNull SocketGlobalBroadCastBean socketGlobalBroadCastBean) {
        this(context, null, socketGlobalBroadCastBean);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(socketGlobalBroadCastBean, "globalBroadCastBean");
    }

    private final void refreshBroadCast11View() {
        ImageView imageView;
        TextView textView;
        String senderNick;
        TextView textView2;
        String str;
        QMUIRadiusImageView qMUIRadiusImageView;
        String str2;
        final ConstraintLayout constraintLayout;
        TextView textView3;
        ImageView imageView2;
        ImageView imageView3;
        int i;
        LayoutGlobalBroad11Binding layoutGlobalBroad11Binding = this.mBindingBroadCast11;
        int i2 = 0;
        if (layoutGlobalBroad11Binding != null && (imageView3 = layoutGlobalBroad11Binding.f٦٦top) != null) {
            SocketGlobalBroadCastBean socketGlobalBroadCastBean = this.mGlobalBroadCastBean;
            if (socketGlobalBroadCastBean != null && socketGlobalBroadCastBean.isPinned()) {
                i = 0;
            } else {
                i = 8;
            }
            imageView3.setVisibility(i);
        }
        LayoutGlobalBroad11Binding layoutGlobalBroad11Binding2 = this.mBindingBroadCast11;
        if (layoutGlobalBroad11Binding2 != null && (imageView2 = layoutGlobalBroad11Binding2.f٦٦top) != null) {
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_global_broad_cast_tip_v10), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        }
        LayoutGlobalBroad11Binding layoutGlobalBroad11Binding3 = this.mBindingBroadCast11;
        if (layoutGlobalBroad11Binding3 != null && (textView3 = layoutGlobalBroad11Binding3.content) != null) {
            textView3.setTextColor(Color.parseColor("#FFFF00"));
        }
        LayoutGlobalBroad11Binding layoutGlobalBroad11Binding4 = this.mBindingBroadCast11;
        if (layoutGlobalBroad11Binding4 != null && (constraintLayout = layoutGlobalBroad11Binding4.constraint) != null) {
            final long j = 800;
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.GlobalRoomBroadCastChildLayout$refreshBroadCast11View$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                        ConstraintLayout constraintLayout2 = constraintLayout;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new DefaultMoreData(ResourcesKtxKt.getStringById(this, 2131954282), DefaultMoreData.GO_ROOM));
                        arrayList.add(new DefaultMoreData(ResourcesKtxKt.getStringById(this, 2131954280), DefaultMoreData.GO_BROADCAST));
                        arrayList.add(new DefaultMoreData(ResourcesKtxKt.getStringById(this, 2131954281), DefaultMoreData.GO_BROADCAST_DIALOG));
                        Context context = this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        final DefaultMoreDialog defaultMoreDialog = new DefaultMoreDialog(context, arrayList);
                        final GlobalRoomBroadCastChildLayout globalRoomBroadCastChildLayout = this;
                        defaultMoreDialog.setMListener(new Function1<String, Unit>() { // from class: com.qiahao.nextvideo.room.view.GlobalRoomBroadCastChildLayout$refreshBroadCast11View$1$1$1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((String) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(String str3) {
                                String str4;
                                Intrinsics.checkNotNullParameter(str3, "type");
                                int hashCode = str3.hashCode();
                                if (hashCode == -1163024131) {
                                    if (str3.equals(DefaultMoreData.GO_BROADCAST_DIALOG)) {
                                        Context context2 = defaultMoreDialog.getContext();
                                        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                                        new SendGroupBroadcastDialog(context2, MeetingRoomManager.INSTANCE.getMGroupId(), 1).show();
                                        return;
                                    }
                                    return;
                                }
                                if (hashCode == -295309782) {
                                    if (str3.equals(DefaultMoreData.GO_BROADCAST)) {
                                        GlobalBroadActivity.Companion companion = GlobalBroadActivity.INSTANCE;
                                        Context context3 = defaultMoreDialog.getContext();
                                        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                                        companion.start(context3);
                                        return;
                                    }
                                    return;
                                }
                                if (hashCode == 192675282 && str3.equals(DefaultMoreData.GO_ROOM)) {
                                    StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
                                    SocketGlobalBroadCastBean mGlobalBroadCastBean = GlobalRoomBroadCastChildLayout.this.getMGlobalBroadCastBean();
                                    if (mGlobalBroadCastBean == null || (str4 = mGlobalBroadCastBean.getGroupId()) == null) {
                                        str4 = "";
                                    }
                                    StartRoomUtils.startRoom$default(startRoomUtils, str4, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
                                }
                            }
                        });
                        defaultMoreDialog.show();
                    }
                }
            });
        }
        SocketGlobalBroadCastBean socketGlobalBroadCastBean2 = this.mGlobalBroadCastBean;
        if (socketGlobalBroadCastBean2 != null) {
            LayoutGlobalBroad11Binding layoutGlobalBroad11Binding5 = this.mBindingBroadCast11;
            Drawable drawable = null;
            if (layoutGlobalBroad11Binding5 != null && (qMUIRadiusImageView = layoutGlobalBroad11Binding5.avatar) != null) {
                if (socketGlobalBroadCastBean2 != null) {
                    str2 = socketGlobalBroadCastBean2.getSenderAvatar();
                } else {
                    str2 = null;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
            }
            LayoutGlobalBroad11Binding layoutGlobalBroad11Binding6 = this.mBindingBroadCast11;
            String str3 = "";
            if (layoutGlobalBroad11Binding6 != null && (textView2 = layoutGlobalBroad11Binding6.content) != null) {
                SocketGlobalBroadCastBean socketGlobalBroadCastBean3 = this.mGlobalBroadCastBean;
                if (socketGlobalBroadCastBean3 == null || (str = socketGlobalBroadCastBean3.getMsg()) == null) {
                    str = "";
                }
                textView2.setText(str);
            }
            LayoutGlobalBroad11Binding layoutGlobalBroad11Binding7 = this.mBindingBroadCast11;
            if (layoutGlobalBroad11Binding7 != null && (textView = layoutGlobalBroad11Binding7.name) != null) {
                SocketGlobalBroadCastBean socketGlobalBroadCastBean4 = this.mGlobalBroadCastBean;
                if (socketGlobalBroadCastBean4 != null && (senderNick = socketGlobalBroadCastBean4.getSenderNick()) != null) {
                    str3 = senderNick;
                }
                textView.setText(str3);
            }
            LayoutGlobalBroad11Binding layoutGlobalBroad11Binding8 = this.mBindingBroadCast11;
            if (layoutGlobalBroad11Binding8 != null && (imageView = layoutGlobalBroad11Binding8.svipType) != null) {
                SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
                SocketGlobalBroadCastBean socketGlobalBroadCastBean5 = this.mGlobalBroadCastBean;
                if (socketGlobalBroadCastBean5 != null) {
                    i2 = socketGlobalBroadCastBean5.getSenderSvipLevel();
                }
                Integer svipType = svipTypeUtils.getSvipType(Integer.valueOf(i2));
                if (svipType != null) {
                    drawable = androidx.core.content.a.getDrawable(getContext(), svipType.intValue());
                }
                imageView.setImageDrawable(drawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshDefaultView$lambda$5(final GlobalRoomBroadCastChildLayout globalRoomBroadCastChildLayout, View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DefaultMoreData(ResourcesKtxKt.getStringById(globalRoomBroadCastChildLayout, 2131954282), DefaultMoreData.GO_ROOM));
        arrayList.add(new DefaultMoreData(ResourcesKtxKt.getStringById(globalRoomBroadCastChildLayout, 2131954280), DefaultMoreData.GO_BROADCAST));
        arrayList.add(new DefaultMoreData(ResourcesKtxKt.getStringById(globalRoomBroadCastChildLayout, 2131954281), DefaultMoreData.GO_BROADCAST_DIALOG));
        Context context = globalRoomBroadCastChildLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final DefaultMoreDialog defaultMoreDialog = new DefaultMoreDialog(context, arrayList);
        defaultMoreDialog.setMListener(new Function1() { // from class: com.qiahao.nextvideo.room.view.c
            public final Object invoke(Object obj) {
                Unit refreshDefaultView$lambda$5$lambda$4$lambda$3;
                refreshDefaultView$lambda$5$lambda$4$lambda$3 = GlobalRoomBroadCastChildLayout.refreshDefaultView$lambda$5$lambda$4$lambda$3(GlobalRoomBroadCastChildLayout.this, defaultMoreDialog, (String) obj);
                return refreshDefaultView$lambda$5$lambda$4$lambda$3;
            }
        });
        defaultMoreDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit refreshDefaultView$lambda$5$lambda$4$lambda$3(GlobalRoomBroadCastChildLayout globalRoomBroadCastChildLayout, DefaultMoreDialog defaultMoreDialog, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "type");
        int hashCode = str.hashCode();
        if (hashCode != -1163024131) {
            if (hashCode != -295309782) {
                if (hashCode == 192675282 && str.equals(DefaultMoreData.GO_ROOM)) {
                    StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
                    SocketGlobalBroadCastBean socketGlobalBroadCastBean = globalRoomBroadCastChildLayout.mGlobalBroadCastBean;
                    if (socketGlobalBroadCastBean == null || (str2 = socketGlobalBroadCastBean.getGroupId()) == null) {
                        str2 = "";
                    }
                    StartRoomUtils.startRoom$default(startRoomUtils, str2, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
                }
            } else if (str.equals(DefaultMoreData.GO_BROADCAST)) {
                GlobalBroadActivity.Companion companion = GlobalBroadActivity.INSTANCE;
                Context context = defaultMoreDialog.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                companion.start(context);
            }
        } else if (str.equals(DefaultMoreData.GO_BROADCAST_DIALOG)) {
            Context context2 = defaultMoreDialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            new SendGroupBroadcastDialog(context2, MeetingRoomManager.INSTANCE.getMGroupId(), 1).show();
        }
        return Unit.INSTANCE;
    }

    private final void updateViewShow(View bgView, ImageView icon, TextView content) {
        int i;
        SocketGlobalBroadCastBean socketGlobalBroadCastBean = this.mGlobalBroadCastBean;
        int i2 = 0;
        if (socketGlobalBroadCastBean != null) {
            i = socketGlobalBroadCastBean.getSenderNobleLevel();
        } else {
            i = 0;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
                if (bgView != null) {
                    bgView.setBackgroundResource(R.drawable.bg_global_room_broad_cast_child);
                }
                if (icon != null) {
                    ImageKtxKt.loadImage$default(icon, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_global_broad_cast_tip), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    return;
                }
                return;
            case 3:
                if (bgView != null) {
                    bgView.setBackgroundResource(R.drawable.bg_global_room_broad_cast_child_v3);
                }
                if (icon != null) {
                    ImageKtxKt.loadImage$default(icon, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_global_broad_cast_tip), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    return;
                }
                return;
            case 4:
                if (bgView != null) {
                    bgView.setBackgroundResource(R.drawable.bg_global_room_broad_cast_child_v4);
                }
                if (icon != null) {
                    ImageKtxKt.loadImage$default(icon, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_global_broad_cast_tip), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    return;
                }
                return;
            case 5:
                if (bgView != null) {
                    bgView.setBackgroundResource(R.drawable.bg_global_room_broad_cast_child_v5);
                }
                if (icon != null) {
                    ImageKtxKt.loadImage$default(icon, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_global_broad_cast_tip_v5), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
                if (content != null) {
                    content.setTextColor(Color.parseColor("#fa5200"));
                    return;
                }
                return;
            case 6:
                if (bgView != null) {
                    bgView.setBackgroundResource(R.drawable.bg_global_room_broad_cast_child_v6);
                }
                if (icon != null) {
                    ImageKtxKt.loadImage$default(icon, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_global_broad_cast_tip_v6), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
                if (content != null) {
                    content.setTextColor(Color.parseColor("#ffea3c"));
                    return;
                }
                return;
            case 7:
                if (bgView != null) {
                    bgView.setBackgroundResource(R.drawable.bg_global_room_broad_cast_child_v7);
                }
                if (icon != null) {
                    ImageKtxKt.loadImage$default(icon, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_global_broad_cast_tip_v6), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
                if (content != null) {
                    content.setTextColor(Color.parseColor("#ffea3c"));
                    return;
                }
                return;
            case 8:
                if (bgView != null) {
                    bgView.setBackgroundResource(R.drawable.bg_global_room_broad_cast_child_v8);
                }
                if (icon != null) {
                    ImageKtxKt.loadImage$default(icon, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_global_broad_cast_tip_v8), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
                if (content != null) {
                    content.setTextColor(Color.parseColor("#FFEC18"));
                    return;
                }
                return;
            case 9:
                if (bgView != null) {
                    bgView.setBackgroundResource(R.drawable.bg_global_room_broad_cast_child9);
                }
                if (icon != null) {
                    ImageKtxKt.loadImage$default(icon, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_global_broad_cast_tip_v9), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
                if (content != null) {
                    content.setTextColor(Color.parseColor("#925D03"));
                    return;
                }
                return;
            case 10:
                if (bgView != null) {
                    bgView.setBackgroundResource(R.drawable.bg_global_room_broad_cast_child10);
                }
                if (icon != null) {
                    ImageKtxKt.loadImage$default(icon, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_global_broad_cast_tip_v10), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
                if (content != null) {
                    content.setTextColor(Color.parseColor("#8B4908"));
                    return;
                }
                return;
            default:
                SocketGlobalBroadCastBean socketGlobalBroadCastBean2 = this.mGlobalBroadCastBean;
                if (socketGlobalBroadCastBean2 != null) {
                    i2 = socketGlobalBroadCastBean2.getSenderNobleLevel();
                }
                if (i2 > 10) {
                    if (bgView != null) {
                        bgView.setBackgroundResource(R.drawable.bg_global_room_broad_cast_child10);
                    }
                    if (icon != null) {
                        ImageKtxKt.loadImage$default(icon, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_global_broad_cast_tip_v10), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    }
                    if (content != null) {
                        content.setTextColor(Color.parseColor("#8B4908"));
                        return;
                    }
                    return;
                }
                if (bgView != null) {
                    bgView.setBackgroundResource(R.drawable.bg_global_room_broad_cast_child);
                }
                if (icon != null) {
                    ImageKtxKt.loadImage$default(icon, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_global_broad_cast_tip), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    return;
                }
                return;
        }
    }

    static /* synthetic */ void updateViewShow$default(GlobalRoomBroadCastChildLayout globalRoomBroadCastChildLayout, View view, ImageView imageView, TextView textView, int i, Object obj) {
        if ((i & 1) != 0) {
            view = null;
        }
        if ((i & 2) != 0) {
            imageView = null;
        }
        if ((i & 4) != 0) {
            textView = null;
        }
        globalRoomBroadCastChildLayout.updateViewShow(view, imageView, textView);
    }

    public final int getCurrentSize() {
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        SocketGlobalBroadCastBean socketGlobalBroadCastBean = this.mGlobalBroadCastBean;
        if (socketGlobalBroadCastBean != null) {
            i = socketGlobalBroadCastBean.getSenderSvipLevel();
        } else {
            i = 0;
        }
        CharSequence charSequence = null;
        float f = 0.0f;
        if (i >= 11) {
            Paint paint = new Paint();
            LayoutGlobalBroad11Binding layoutGlobalBroad11Binding = this.mBindingBroadCast11;
            if (layoutGlobalBroad11Binding != null && (textView4 = layoutGlobalBroad11Binding.content) != null) {
                f = textView4.getTextSize();
            }
            paint.setTextSize(f);
            LayoutGlobalBroad11Binding layoutGlobalBroad11Binding2 = this.mBindingBroadCast11;
            if (layoutGlobalBroad11Binding2 != null && (textView3 = layoutGlobalBroad11Binding2.content) != null) {
                charSequence = textView3.getText();
            }
            int measureText = (int) (paint.measureText(String.valueOf(charSequence)) + UiKtxKt.toPX(4) + UiKtxKt.toPX(4) + UiKtxKt.toPX(32) + UiKtxKt.toPX(10) + UiKtxKt.toPX(10));
            int px = UiKtxKt.toPX(UserProxyUtility.specialRelationInvite);
            if (measureText <= px) {
                return px;
            }
            return measureText;
        }
        Paint paint2 = new Paint();
        LayoutGlobalRoomBroadCastChildBinding layoutGlobalRoomBroadCastChildBinding = this.mBindingDefault;
        if (layoutGlobalRoomBroadCastChildBinding != null && (textView2 = layoutGlobalRoomBroadCastChildBinding.content) != null) {
            f = textView2.getTextSize();
        }
        paint2.setTextSize(f);
        LayoutGlobalRoomBroadCastChildBinding layoutGlobalRoomBroadCastChildBinding2 = this.mBindingDefault;
        if (layoutGlobalRoomBroadCastChildBinding2 != null && (textView = layoutGlobalRoomBroadCastChildBinding2.content) != null) {
            charSequence = textView.getText();
        }
        float measureText2 = paint2.measureText(String.valueOf(charSequence));
        Dimens dimens = Dimens.INSTANCE;
        return (int) (measureText2 + dimens.dpToPx(3) + dimens.dpToPx(8) + dimens.dpToPx(5) + dimens.dpToPx(3) + dimens.dpToPx(10) + dimens.dpToPx(19));
    }

    @Nullable
    public final LayoutGlobalBroad11Binding getMBindingBroadCast11() {
        return this.mBindingBroadCast11;
    }

    @Nullable
    public final LayoutGlobalRoomBroadCastChildBinding getMBindingDefault() {
        return this.mBindingDefault;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @Nullable
    public final SocketGlobalBroadCastBean getMGlobalBroadCastBean() {
        return this.mGlobalBroadCastBean;
    }

    public final void initView() {
        int i;
        SocketGlobalBroadCastBean socketGlobalBroadCastBean = this.mGlobalBroadCastBean;
        if (socketGlobalBroadCastBean != null) {
            i = socketGlobalBroadCastBean.getSenderSvipLevel();
        } else {
            i = 0;
        }
        if (i >= 11) {
            this.mBindingBroadCast11 = (LayoutGlobalBroad11Binding) androidx.databinding.g.h(LayoutInflater.from(this.mContext), R.layout.layout_global_broad11, this, true);
            refreshBroadCast11View();
        } else {
            this.mBindingDefault = (LayoutGlobalRoomBroadCastChildBinding) androidx.databinding.g.h(LayoutInflater.from(this.mContext), R.layout.layout_global_room_broad_cast_child, this, true);
            refreshDefaultView();
        }
    }

    public final void refreshDefaultView() {
        LinearLayout linearLayout;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        String str;
        AppCompatImageView appCompatImageView;
        FrameLayout frameLayout;
        ImageView imageView2;
        int i;
        LayoutGlobalRoomBroadCastChildBinding layoutGlobalRoomBroadCastChildBinding = this.mBindingDefault;
        String str2 = null;
        if (layoutGlobalRoomBroadCastChildBinding != null) {
            linearLayout = layoutGlobalRoomBroadCastChildBinding.contentBg;
        } else {
            linearLayout = null;
        }
        if (layoutGlobalRoomBroadCastChildBinding != null) {
            imageView = layoutGlobalRoomBroadCastChildBinding.icon;
        } else {
            imageView = null;
        }
        if (layoutGlobalRoomBroadCastChildBinding != null) {
            textView = layoutGlobalRoomBroadCastChildBinding.content;
        } else {
            textView = null;
        }
        updateViewShow(linearLayout, imageView, textView);
        LayoutGlobalRoomBroadCastChildBinding layoutGlobalRoomBroadCastChildBinding2 = this.mBindingDefault;
        if (layoutGlobalRoomBroadCastChildBinding2 != null && (imageView2 = layoutGlobalRoomBroadCastChildBinding2.f٦٧top) != null) {
            SocketGlobalBroadCastBean socketGlobalBroadCastBean = this.mGlobalBroadCastBean;
            if (socketGlobalBroadCastBean != null && socketGlobalBroadCastBean.isPinned()) {
                i = 0;
            } else {
                i = 8;
            }
            imageView2.setVisibility(i);
        }
        LayoutGlobalRoomBroadCastChildBinding layoutGlobalRoomBroadCastChildBinding3 = this.mBindingDefault;
        if (layoutGlobalRoomBroadCastChildBinding3 != null && (frameLayout = layoutGlobalRoomBroadCastChildBinding3.allContent) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GlobalRoomBroadCastChildLayout.refreshDefaultView$lambda$5(GlobalRoomBroadCastChildLayout.this, view);
                }
            });
        }
        SocketGlobalBroadCastBean socketGlobalBroadCastBean2 = this.mGlobalBroadCastBean;
        if (socketGlobalBroadCastBean2 != null) {
            LayoutGlobalRoomBroadCastChildBinding layoutGlobalRoomBroadCastChildBinding4 = this.mBindingDefault;
            if (layoutGlobalRoomBroadCastChildBinding4 != null && (appCompatImageView = layoutGlobalRoomBroadCastChildBinding4.avatar) != null) {
                if (socketGlobalBroadCastBean2 != null) {
                    str2 = socketGlobalBroadCastBean2.getSenderAvatar();
                }
                ImageKtxKt.loadImage$default(appCompatImageView, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
            }
            LayoutGlobalRoomBroadCastChildBinding layoutGlobalRoomBroadCastChildBinding5 = this.mBindingDefault;
            if (layoutGlobalRoomBroadCastChildBinding5 != null && (textView2 = layoutGlobalRoomBroadCastChildBinding5.content) != null) {
                SocketGlobalBroadCastBean socketGlobalBroadCastBean3 = this.mGlobalBroadCastBean;
                if (socketGlobalBroadCastBean3 == null || (str = socketGlobalBroadCastBean3.getMsg()) == null) {
                    str = "";
                }
                textView2.setText(str);
            }
        }
    }

    public final void setMBindingBroadCast11(@Nullable LayoutGlobalBroad11Binding layoutGlobalBroad11Binding) {
        this.mBindingBroadCast11 = layoutGlobalBroad11Binding;
    }

    public final void setMBindingDefault(@Nullable LayoutGlobalRoomBroadCastChildBinding layoutGlobalRoomBroadCastChildBinding) {
        this.mBindingDefault = layoutGlobalRoomBroadCastChildBinding;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final void setMGlobalBroadCastBean(@Nullable SocketGlobalBroadCastBean socketGlobalBroadCastBean) {
        this.mGlobalBroadCastBean = socketGlobalBroadCastBean;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalRoomBroadCastChildLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, @NotNull SocketGlobalBroadCastBean socketGlobalBroadCastBean) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(socketGlobalBroadCastBean, "globalBroadCastBean");
        this.mContext = context;
        this.mGlobalBroadCastBean = socketGlobalBroadCastBean;
        initView();
    }
}
