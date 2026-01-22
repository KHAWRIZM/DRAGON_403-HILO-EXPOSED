package com.qiahao.nextvideo.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.data.model.OpenScreenBean;
import com.qiahao.nextvideo.data.service.SplashService;
import com.qiahao.nextvideo.databinding.SplashAdvertisingViewBinding;
import io.reactivex.rxjava3.core.z;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\r\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\fJ\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\fJ\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0017\u00106\u001a\u0002058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/qiahao/nextvideo/app/AdvertisingContentView;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/ViewGroup;", "parent", "Lla/b;", "", "mainViewInitBehaviorRelay", "<init>", "(Landroid/view/ViewGroup;Lla/b;)V", "", "showH5View", "()V", "countDownH5View", "showCountDownView", "showWeekCpTopLayout", "showWeekTopLayout", "Landroid/view/View;", "p0", "onViewAttachedToWindow", "(Landroid/view/View;)V", "v", "onViewDetachedFromWindow", "show", "hide", "onClick", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "Lla/b;", "getMainViewInitBehaviorRelay", "()Lla/b;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Lnd/c;", "mComposer", "Lnd/c;", "getMComposer", "()Lnd/c;", "setMComposer", "(Lnd/c;)V", "", "mCountDownSum", "I", "Lcom/qiahao/nextvideo/data/model/OpenScreenBean;", "mCurrentSplashData", "Lcom/qiahao/nextvideo/data/model/OpenScreenBean;", "Lcom/qiahao/nextvideo/databinding/SplashAdvertisingViewBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/SplashAdvertisingViewBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/SplashAdvertisingViewBinding;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AdvertisingContentView implements View.OnAttachStateChangeListener, View.OnClickListener {

    @NotNull
    private final SplashAdvertisingViewBinding binding;

    @NotNull
    private final nd.a compositeDisposable;

    @Nullable
    private Context context;

    @Nullable
    private nd.c mComposer;
    private int mCountDownSum;

    @Nullable
    private OpenScreenBean mCurrentSplashData;

    @NotNull
    private final la.b mainViewInitBehaviorRelay;

    @NotNull
    private final ViewGroup parent;

    public AdvertisingContentView(@NotNull ViewGroup viewGroup, @NotNull la.b bVar) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(bVar, "mainViewInitBehaviorRelay");
        this.parent = viewGroup;
        this.mainViewInitBehaviorRelay = bVar;
        this.compositeDisposable = new nd.a();
        this.mCountDownSum = 3;
        SplashAdvertisingViewBinding inflate = SplashAdvertisingViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.context = inflate.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
        this.binding = inflate;
        inflate.getRoot().addOnAttachStateChangeListener(this);
    }

    private final void countDownH5View() {
        String str;
        String str2;
        this.binding.bgContent.setVisibility(0);
        OpenScreenBean currentShowData = SplashService.INSTANCE.getShared().getCurrentShowData();
        this.mCurrentSplashData = currentShowData;
        if (currentShowData != null) {
            Intrinsics.checkNotNull(currentShowData);
            int type = currentShowData.getType();
            if (type != 0) {
                if (type != 1) {
                    if (type == 2) {
                        showWeekTopLayout();
                        showCountDownView();
                        return;
                    }
                    return;
                }
                showWeekCpTopLayout();
                showCountDownView();
                return;
            }
            OpenScreenBean openScreenBean = this.mCurrentSplashData;
            if (openScreenBean != null) {
                str = openScreenBean.getLocalFile();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                this.binding.bgAdvertisingImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                OpenScreenBean openScreenBean2 = this.mCurrentSplashData;
                if (openScreenBean2 == null || (str2 = openScreenBean2.getLocalFile()) == null) {
                    str2 = "";
                }
                File file = new File(str2);
                if (file.exists()) {
                    AppCompatImageView appCompatImageView = this.binding.bgAdvertisingImageView;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "bgAdvertisingImageView");
                    ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, file, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65531, (Object) null);
                }
                showCountDownView();
                return;
            }
            this.mainViewInitBehaviorRelay.accept(Boolean.TRUE);
            return;
        }
        this.mainViewInitBehaviorRelay.accept(Boolean.TRUE);
    }

    @SuppressLint({"SetTextI18n"})
    private final void showCountDownView() {
        this.binding.countText.setVisibility(0);
        this.binding.countText.setText(ResourcesKtxKt.getStringById(this, 2131954095) + " " + this.mCountDownSum);
        nd.c subscribe = z.interval(1L, 1L, TimeUnit.SECONDS).subscribeOn(ke.a.b()).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.app.AdvertisingContentView$showCountDownView$1
            public final void accept(Long l) {
                int i;
                int i2;
                int i3;
                nd.c mComposer;
                Intrinsics.checkNotNullParameter(l, "it");
                AdvertisingContentView advertisingContentView = AdvertisingContentView.this;
                i = advertisingContentView.mCountDownSum;
                advertisingContentView.mCountDownSum = i - 1;
                TextView textView = AdvertisingContentView.this.getBinding().countText;
                String stringById = ResourcesKtxKt.getStringById(AdvertisingContentView.this, 2131954095);
                i2 = AdvertisingContentView.this.mCountDownSum;
                textView.setText(stringById + " " + i2);
                i3 = AdvertisingContentView.this.mCountDownSum;
                if (i3 > 1 || (mComposer = AdvertisingContentView.this.getMComposer()) == null || mComposer.isDisposed()) {
                    return;
                }
                nd.c mComposer2 = AdvertisingContentView.this.getMComposer();
                if (mComposer2 != null) {
                    mComposer2.dispose();
                }
                AdvertisingContentView.this.getMainViewInitBehaviorRelay().accept(Boolean.TRUE);
            }
        });
        this.mComposer = subscribe;
        if (subscribe != null) {
            RxUtilsKt.addTo(subscribe, this.compositeDisposable);
        }
    }

    private final void showH5View() {
        this.binding.countText.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.app.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdvertisingContentView.showH5View$lambda$1(AdvertisingContentView.this, view);
            }
        });
        this.binding.bgAdvertisingImageView.setOnClickListener(this);
        this.binding.cpWeekLayout.setOnClickListener(this);
        this.binding.weekStarLayout.setOnClickListener(this);
        if (SplashService.INSTANCE.getShared().needShowH5()) {
            countDownH5View();
        } else {
            this.mainViewInitBehaviorRelay.accept(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showH5View$lambda$1(AdvertisingContentView advertisingContentView, View view) {
        nd.c cVar;
        nd.c cVar2 = advertisingContentView.mComposer;
        if (cVar2 != null && !cVar2.isDisposed() && (cVar = advertisingContentView.mComposer) != null) {
            cVar.dispose();
        }
        advertisingContentView.mainViewInitBehaviorRelay.accept(Boolean.TRUE);
    }

    private final void showWeekCpTopLayout() {
        String str;
        String nick2;
        String nick1;
        String localPic2Url;
        String str2;
        this.binding.cpWeekLayout.setVisibility(0);
        OpenScreenBean openScreenBean = this.mCurrentSplashData;
        if (openScreenBean != null) {
            String str3 = null;
            if (openScreenBean != null) {
                str = openScreenBean.getLocalPic1Url();
            } else {
                str = null;
            }
            String str4 = "";
            if (str != null && str.length() != 0) {
                OpenScreenBean openScreenBean2 = this.mCurrentSplashData;
                if (openScreenBean2 == null || (str2 = openScreenBean2.getLocalPic1Url()) == null) {
                    str2 = "";
                }
                File file = new File(str2);
                if (file.exists()) {
                    AppCompatImageView appCompatImageView = this.binding.cpAvatar1;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "cpAvatar1");
                    ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, file, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65531, (Object) null);
                }
            }
            OpenScreenBean openScreenBean3 = this.mCurrentSplashData;
            if (openScreenBean3 != null) {
                str3 = openScreenBean3.getLocalPic2Url();
            }
            if (str3 != null && str3.length() != 0) {
                OpenScreenBean openScreenBean4 = this.mCurrentSplashData;
                if (openScreenBean4 != null && (localPic2Url = openScreenBean4.getLocalPic2Url()) != null) {
                    str4 = localPic2Url;
                }
                File file2 = new File(str4);
                if (file2.exists()) {
                    AppCompatImageView appCompatImageView2 = this.binding.cpAvatar2;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "cpAvatar2");
                    ImageKtxKt.loadImage$default(appCompatImageView2, (String) null, (Uri) null, file2, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65531, (Object) null);
                }
            }
            OpenScreenBean openScreenBean5 = this.mCurrentSplashData;
            if (openScreenBean5 != null && (nick1 = openScreenBean5.getNick1()) != null && nick1.length() > 0) {
                TextView textView = this.binding.cpNick1;
                OpenScreenBean openScreenBean6 = this.mCurrentSplashData;
                Intrinsics.checkNotNull(openScreenBean6);
                textView.setText(openScreenBean6.getNick1());
            }
            OpenScreenBean openScreenBean7 = this.mCurrentSplashData;
            if (openScreenBean7 != null && (nick2 = openScreenBean7.getNick2()) != null && nick2.length() > 0) {
                TextView textView2 = this.binding.cpNick2;
                OpenScreenBean openScreenBean8 = this.mCurrentSplashData;
                Intrinsics.checkNotNull(openScreenBean8);
                textView2.setText(openScreenBean8.getNick2());
            }
        }
    }

    private final void showWeekTopLayout() {
        String nick1;
        String str;
        String localPic1Url;
        String str2;
        this.binding.weekStarLayout.setVisibility(0);
        OpenScreenBean openScreenBean = this.mCurrentSplashData;
        if (openScreenBean != null) {
            if (openScreenBean != null && (localPic1Url = openScreenBean.getLocalPic1Url()) != null && localPic1Url.length() > 0) {
                OpenScreenBean openScreenBean2 = this.mCurrentSplashData;
                if (openScreenBean2 == null || (str2 = openScreenBean2.getLocalPic1Url()) == null) {
                    str2 = "";
                }
                File file = new File(str2);
                if (file.exists()) {
                    AppCompatImageView appCompatImageView = this.binding.weekStarAvatar;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "weekStarAvatar");
                    ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, file, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65531, (Object) null);
                }
            }
            OpenScreenBean openScreenBean3 = this.mCurrentSplashData;
            if (openScreenBean3 != null && (nick1 = openScreenBean3.getNick1()) != null && nick1.length() > 0) {
                TextView textView = this.binding.weekStarNick;
                OpenScreenBean openScreenBean4 = this.mCurrentSplashData;
                if (openScreenBean4 != null) {
                    str = openScreenBean4.getNick1();
                } else {
                    str = null;
                }
                textView.setText(str);
            }
        }
    }

    @NotNull
    public final SplashAdvertisingViewBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    @Nullable
    public final nd.c getMComposer() {
        return this.mComposer;
    }

    @NotNull
    public final la.b getMainViewInitBehaviorRelay() {
        return this.mainViewInitBehaviorRelay;
    }

    @NotNull
    public final ViewGroup getParent() {
        return this.parent;
    }

    public final void hide() {
        this.parent.removeView(this.binding.getRoot());
        this.binding.getRoot().removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        String str;
        nd.c cVar;
        String groupId;
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 == 2131362104 || id2 == 2131362557 || id2 == 2131365697) {
            SplashService.Companion companion = SplashService.INSTANCE;
            OpenScreenBean openScreenBean = this.mCurrentSplashData;
            String str2 = "";
            if (openScreenBean == null || (str = openScreenBean.getH5Url()) == null) {
                str = "";
            }
            companion.setMAdvertisingH5(str);
            OpenScreenBean openScreenBean2 = this.mCurrentSplashData;
            if (openScreenBean2 != null && (groupId = openScreenBean2.getGroupId()) != null) {
                str2 = groupId;
            }
            companion.setMGroupId(str2);
            nd.c cVar2 = this.mComposer;
            if (cVar2 != null && !cVar2.isDisposed() && (cVar = this.mComposer) != null) {
                cVar.dispose();
            }
            this.mainViewInitBehaviorRelay.accept(Boolean.TRUE);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.compositeDisposable.dispose();
    }

    public final void setMComposer(@Nullable nd.c cVar) {
        this.mComposer = cVar;
    }

    public final void show() {
        this.binding.getRoot().setVisibility(0);
        showH5View();
    }
}
