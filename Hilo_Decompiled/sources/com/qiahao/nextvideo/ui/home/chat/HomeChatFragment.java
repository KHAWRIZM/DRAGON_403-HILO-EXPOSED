package com.qiahao.nextvideo.ui.home.chat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.oudi.core.utils.FragmentUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.SkinData;
import com.qiahao.nextvideo.databinding.FragmentHomeChatBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.SkinMessage;
import com.qiahao.nextvideo.room.adapter.ViewPagerFragmentAdapter;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.TabEntity;
import com.qiahao.nextvideo.ui.home.chat.dialog.IMCleanDialog;
import com.qiahao.nextvideo.ui.home.chat.dialog.IMMessageListener;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.im.StrangerProvide;
import com.qiahao.nextvideo.ui.reusable.views.ViewSelector;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0006J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ'\u0010\u0019\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u000fJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u000fJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0006J\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u0006R\u0017\u0010!\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R&\u0010(\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b/\u0010.¨\u00060"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/HomeChatFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentHomeChatBinding;", "Lo6/b;", "Landroidx/viewpager/widget/ViewPager$j;", "<init>", "()V", "", "refreshSkin", "setAllConversationHasRead", "initObserve", "processStatusBarCover", "", "position", "updateTextSize", "(I)V", "getLayoutResId", "()I", "onInitialize", "initView", "onTabSelect", "onTabReselect", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "state", "onPageScrollStateChanged", "onResume", "onDestroy", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "mFragments", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/home/chat/MessageFragment;", "mMessageFragment", "Lcom/qiahao/nextvideo/ui/home/chat/MessageFragment;", "mCurrentPosition", "I", "pageViewSize", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHomeChatFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeChatFragment.kt\ncom/qiahao/nextvideo/ui/home/chat/HomeChatFragment\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,245:1\n13472#2,2:246\n61#3,9:248\n1#4:257\n*S KotlinDebug\n*F\n+ 1 HomeChatFragment.kt\ncom/qiahao/nextvideo/ui/home/chat/HomeChatFragment\n*L\n87#1:246,2\n103#1:248,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HomeChatFragment extends BaseBindingFragment<FragmentHomeChatBinding> implements o6.b, ViewPager.j {
    private int mCurrentPosition;

    @Nullable
    private MessageFragment mMessageFragment;

    @NotNull
    private final nd.a compositeDisposable = new nd.a();

    @NotNull
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final int pageViewSize = 2;

    private final void initObserve() {
        nd.c subscribe = UserStore.INSTANCE.getShared().getViewPagePublicRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.chat.HomeChatFragment$initObserve$1
            public final void accept(Boolean bool) {
                ViewSelector viewSelector;
                FragmentHomeChatBinding fragmentHomeChatBinding = (FragmentHomeChatBinding) HomeChatFragment.this.getBinding();
                if (fragmentHomeChatBinding == null || (viewSelector = fragmentHomeChatBinding.viewPager) == null) {
                    return;
                }
                viewSelector.setAllowUserInteraction(bool.booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
    }

    private final void processStatusBarCover() {
        LinearLayout linearLayout;
        FragmentHomeChatBinding fragmentHomeChatBinding = (FragmentHomeChatBinding) getBinding();
        if (fragmentHomeChatBinding != null && (linearLayout = fragmentHomeChatBinding.container) != null) {
            linearLayout.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.chat.j
                @Override // java.lang.Runnable
                public final void run() {
                    HomeChatFragment.processStatusBarCover$lambda$8(HomeChatFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processStatusBarCover$lambda$8(final HomeChatFragment homeChatFragment) {
        ConstraintLayout constraintLayout;
        ViewGroup.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        ConstraintLayout constraintLayout2;
        FragmentHomeChatBinding fragmentHomeChatBinding = (FragmentHomeChatBinding) homeChatFragment.getBinding();
        LinearLayout linearLayout = null;
        if (fragmentHomeChatBinding != null && (constraintLayout = fragmentHomeChatBinding.title) != null) {
            FragmentHomeChatBinding fragmentHomeChatBinding2 = (FragmentHomeChatBinding) homeChatFragment.getBinding();
            if (fragmentHomeChatBinding2 != null && (constraintLayout2 = fragmentHomeChatBinding2.title) != null) {
                layoutParams = constraintLayout2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                layoutParams2.height = Dimens.INSTANCE.dpToPx(42);
            } else {
                layoutParams2 = null;
            }
            constraintLayout.setLayoutParams(layoutParams2);
        }
        FragmentHomeChatBinding fragmentHomeChatBinding3 = (FragmentHomeChatBinding) homeChatFragment.getBinding();
        if (fragmentHomeChatBinding3 != null) {
            linearLayout = fragmentHomeChatBinding3.container;
        }
        homeChatFragment.getStatusBarTopOrBottom(linearLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.home.chat.k
            public final Object invoke(Object obj, Object obj2) {
                Unit processStatusBarCover$lambda$8$lambda$7;
                processStatusBarCover$lambda$8$lambda$7 = HomeChatFragment.processStatusBarCover$lambda$8$lambda$7(HomeChatFragment.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return processStatusBarCover$lambda$8$lambda$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processStatusBarCover$lambda$8$lambda$7(HomeChatFragment homeChatFragment, int i, int i2) {
        LinearLayout linearLayout;
        FragmentHomeChatBinding fragmentHomeChatBinding = (FragmentHomeChatBinding) homeChatFragment.getBinding();
        if (fragmentHomeChatBinding != null && (linearLayout = fragmentHomeChatBinding.container) != null) {
            linearLayout.setPadding(0, i, 0, 0);
        }
        return Unit.INSTANCE;
    }

    private final void refreshSkin() {
        String str;
        ImageView imageView;
        Drawable drawable;
        ImageView imageView2;
        SkinMessage skinMessage = SkinMessage.INSTANCE;
        SkinData skinData = skinMessage.skinData();
        if (skinData == null || (str = skinData.getTopBg1()) == null) {
            str = "";
        }
        File file = new File(str);
        if (skinMessage.checkSkin() && file.exists() && file.isFile()) {
            FragmentHomeChatBinding fragmentHomeChatBinding = (FragmentHomeChatBinding) getBinding();
            if (fragmentHomeChatBinding != null && (imageView2 = fragmentHomeChatBinding.topBg) != null) {
                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, file, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65531, (Object) null);
                return;
            }
            return;
        }
        FragmentHomeChatBinding fragmentHomeChatBinding2 = (FragmentHomeChatBinding) getBinding();
        if (fragmentHomeChatBinding2 != null && (imageView = fragmentHomeChatBinding2.topBg) != null) {
            Context context = getContext();
            if (context != null) {
                drawable = androidx.core.content.a.getDrawable(context, R.drawable.ic_group_top_bg_all);
            } else {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAllConversationHasRead() {
        V2TIMManager.getMessageManager().markAllMessageAsRead(new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.home.chat.HomeChatFragment$setAllConversationHasRead$1
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int p0, String p1) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                StrangerProvide.INSTANCE.displayData();
                MessageProvide.displayData$default(MessageProvide.INSTANCE, null, 1, null);
            }
        });
    }

    private final void updateTextSize(int position) {
        TextView textView;
        CommonTabLayout commonTabLayout;
        int i = this.pageViewSize;
        for (int i2 = 0; i2 < i; i2++) {
            FragmentHomeChatBinding fragmentHomeChatBinding = (FragmentHomeChatBinding) getBinding();
            if (fragmentHomeChatBinding != null && (commonTabLayout = fragmentHomeChatBinding.segmentTabLayout) != null) {
                textView = commonTabLayout.g(i2);
            } else {
                textView = null;
            }
            if (position == i2) {
                if (textView != null) {
                    textView.setTextSize(17.0f);
                }
                if (textView != null) {
                    textView.setTypeface(null, 1);
                }
            } else {
                if (textView != null) {
                    textView.setTextSize(16.0f);
                }
                if (textView != null) {
                    textView.setTypeface(null, 1);
                }
            }
        }
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_home_chat;
    }

    public final void initView() {
        final ImageView imageView;
        ViewSelector viewSelector;
        ViewSelector viewSelector2;
        CommonTabLayout commonTabLayout;
        CommonTabLayout commonTabLayout2;
        CommonTabLayout commonTabLayout3;
        ViewSelector viewSelector3;
        ViewSelector viewSelector4;
        ViewSelector viewSelector5;
        MessageFragment messageFragment;
        if (this.mFragments.isEmpty()) {
            FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
            MessageFragment findFragment = fragmentUtils.findFragment(getChildFragmentManager(), MessageFragment.class);
            if (findFragment instanceof MessageFragment) {
                messageFragment = findFragment;
            } else {
                messageFragment = null;
            }
            this.mMessageFragment = messageFragment;
            if (messageFragment == null) {
                this.mMessageFragment = new MessageFragment();
            }
            Fragment fragment = this.mMessageFragment;
            if (fragment != null) {
                this.mFragments.add(fragment);
            }
            ContactFragment findFragment2 = fragmentUtils.findFragment(getChildFragmentManager(), ContactFragment.class);
            if (findFragment2 == null) {
                findFragment2 = new ContactFragment();
            }
            this.mFragments.add(findFragment2);
        }
        FragmentHomeChatBinding fragmentHomeChatBinding = (FragmentHomeChatBinding) getBinding();
        if (fragmentHomeChatBinding != null && (viewSelector5 = fragmentHomeChatBinding.viewPager) != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            viewSelector5.setAdapter(new ViewPagerFragmentAdapter(childFragmentManager, this.mFragments));
        }
        FragmentHomeChatBinding fragmentHomeChatBinding2 = (FragmentHomeChatBinding) getBinding();
        if (fragmentHomeChatBinding2 != null && (viewSelector4 = fragmentHomeChatBinding2.viewPager) != null) {
            viewSelector4.setOffscreenPageLimit(this.mFragments.size());
        }
        FragmentHomeChatBinding fragmentHomeChatBinding3 = (FragmentHomeChatBinding) getBinding();
        if (fragmentHomeChatBinding3 != null && (viewSelector3 = fragmentHomeChatBinding3.viewPager) != null) {
            viewSelector3.addOnPageChangeListener(this);
        }
        String[] strArr = {ResourcesKtxKt.getStringById(this, 2131952208), ResourcesKtxKt.getStringById(this, 2131952802)};
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            arrayList.add(new TabEntity(strArr[i2], 0, 0));
        }
        FragmentHomeChatBinding fragmentHomeChatBinding4 = (FragmentHomeChatBinding) getBinding();
        if (fragmentHomeChatBinding4 != null && (commonTabLayout3 = fragmentHomeChatBinding4.segmentTabLayout) != null) {
            commonTabLayout3.setTabData(arrayList);
        }
        FragmentHomeChatBinding fragmentHomeChatBinding5 = (FragmentHomeChatBinding) getBinding();
        if (fragmentHomeChatBinding5 != null && (commonTabLayout2 = fragmentHomeChatBinding5.segmentTabLayout) != null) {
            commonTabLayout2.setOnTabSelectListener(this);
        }
        FragmentHomeChatBinding fragmentHomeChatBinding6 = (FragmentHomeChatBinding) getBinding();
        if (fragmentHomeChatBinding6 != null && (commonTabLayout = fragmentHomeChatBinding6.segmentTabLayout) != null) {
            commonTabLayout.setCurrentTab(0);
        }
        FragmentHomeChatBinding fragmentHomeChatBinding7 = (FragmentHomeChatBinding) getBinding();
        if (fragmentHomeChatBinding7 != null && (viewSelector2 = fragmentHomeChatBinding7.viewPager) != null) {
            viewSelector2.setCurrentItem(0);
        }
        FragmentHomeChatBinding fragmentHomeChatBinding8 = (FragmentHomeChatBinding) getBinding();
        if (fragmentHomeChatBinding8 != null && (viewSelector = fragmentHomeChatBinding8.viewPager) != null) {
            i = viewSelector.getCurrentItem();
        }
        updateTextSize(i);
        FragmentHomeChatBinding fragmentHomeChatBinding9 = (FragmentHomeChatBinding) getBinding();
        if (fragmentHomeChatBinding9 != null && (imageView = fragmentHomeChatBinding9.clearUnread) != null) {
            final long j = 800;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.HomeChatFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        final Context context = this.getContext();
                        if (context != null) {
                            IMCleanDialog iMCleanDialog = new IMCleanDialog(context);
                            final HomeChatFragment homeChatFragment = this;
                            iMCleanDialog.setClickListener(new IMMessageListener() { // from class: com.qiahao.nextvideo.ui.home.chat.HomeChatFragment$initView$2$1$1
                                @Override // com.qiahao.nextvideo.ui.home.chat.dialog.IMMessageListener
                                public void delete() {
                                    TipDialog tipContent = new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131954185));
                                    final HomeChatFragment homeChatFragment2 = homeChatFragment;
                                    tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.HomeChatFragment$initView$2$1$1$delete$1
                                        public void cancel() {
                                            OnCommonDialogListener.DefaultImpls.cancel(this);
                                        }

                                        public void confirm() {
                                            io.reactivex.rxjava3.core.i0<ApiResponse<Object>> clearInteractionMessage = AppServer.INSTANCE.getApis().clearInteractionMessage();
                                            final HomeChatFragment homeChatFragment3 = HomeChatFragment.this;
                                            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(clearInteractionMessage, new Function1<ApiResponse<Object>, Unit>() { // from class: com.qiahao.nextvideo.ui.home.chat.HomeChatFragment$initView$2$1$1$delete$1$confirm$1
                                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                    invoke((ApiResponse<Object>) obj);
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(ApiResponse<Object> apiResponse) {
                                                    MessageFragment messageFragment2;
                                                    Intrinsics.checkNotNullParameter(apiResponse, "it");
                                                    MessageProvide messageProvide = MessageProvide.INSTANCE;
                                                    messageProvide.clearUnreadMessageCount("Hilo_Information");
                                                    messageProvide.clearUnreadMessageCount("Hilo_Assistant");
                                                    messageProvide.clearUnreadMessageCount("Hilo_Notification");
                                                    messageProvide.cleanAllMessage();
                                                    messageFragment2 = HomeChatFragment.this.mMessageFragment;
                                                    if (messageFragment2 != null) {
                                                        messageFragment2.refreshGiftData();
                                                    }
                                                }
                                            }, new Function1<Throwable, Unit>() { // from class: com.qiahao.nextvideo.ui.home.chat.HomeChatFragment$initView$2$1$1$delete$1$confirm$2
                                                public final void invoke(Throwable th) {
                                                    Intrinsics.checkNotNullParameter(th, "it");
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                    invoke((Throwable) obj);
                                                    return Unit.INSTANCE;
                                                }
                                            }, (Function0) null, false, 12, (Object) null), HomeChatFragment.this.getCompositeDisposable());
                                        }
                                    }).show();
                                }

                                @Override // com.qiahao.nextvideo.ui.home.chat.dialog.IMMessageListener
                                public void markRead() {
                                    TipDialog tipContent = new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131952222));
                                    final HomeChatFragment homeChatFragment2 = homeChatFragment;
                                    tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.HomeChatFragment$initView$2$1$1$markRead$1
                                        public void cancel() {
                                            OnCommonDialogListener.DefaultImpls.cancel(this);
                                        }

                                        public void confirm() {
                                            HomeChatFragment.this.setAllConversationHasRead();
                                            MessageProvide messageProvide = MessageProvide.INSTANCE;
                                            messageProvide.clearUnreadMessageCount("Hilo_Information");
                                            messageProvide.clearUnreadMessageCount("Hilo_Assistant");
                                            messageProvide.clearUnreadMessageCount("Hilo_Notification");
                                        }
                                    }).show();
                                }
                            }).show();
                        }
                    }
                }
            });
        }
        refreshSkin();
        initObserve();
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        this.compositeDisposable.d();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        processStatusBarCover();
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        CommonTabLayout commonTabLayout;
        this.mCurrentPosition = position;
        FragmentHomeChatBinding fragmentHomeChatBinding = (FragmentHomeChatBinding) getBinding();
        if (fragmentHomeChatBinding != null && (commonTabLayout = fragmentHomeChatBinding.segmentTabLayout) != null) {
            commonTabLayout.setCurrentTab(position);
        }
        updateTextSize(position);
    }

    public void onResume() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        processStatusBarCover();
    }

    public void onTabReselect(int position) {
    }

    public void onTabSelect(int position) {
        ViewSelector viewSelector;
        this.mCurrentPosition = position;
        FragmentHomeChatBinding fragmentHomeChatBinding = (FragmentHomeChatBinding) getBinding();
        if (fragmentHomeChatBinding != null && (viewSelector = fragmentHomeChatBinding.viewPager) != null) {
            viewSelector.setCurrentItem(position);
        }
    }
}
