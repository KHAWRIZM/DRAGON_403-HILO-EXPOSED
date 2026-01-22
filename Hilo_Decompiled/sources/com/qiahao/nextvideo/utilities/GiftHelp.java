package com.qiahao.nextvideo.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Layout;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bumptech.glide.Glide;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.oudi.utils.ImageUtils;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.model.cp.TextStyles;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.player.svga.SVGAMediaSource;
import com.qiahao.base_common.player.vap.VapMediaSource;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.tencent.qgame.animplayer.inter.IFetchResource;
import com.tencent.qgame.animplayer.mix.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ2\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\n\u001a\u00020\u000bJ2\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bJ \u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u001dJ$\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\u0017H\u0002J\u001e\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0015¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/utilities/GiftHelp;", "", "<init>", "()V", "getSVGAData", "Lcom/qiahao/base_common/player/svga/SVGAMediaSource;", "giftItem", "Lcom/qiahao/nextvideo/data/model/GiftDateItem;", "getVAP", "Lcom/qiahao/base_common/player/vap/VapMediaSource;", "context", "Landroid/content/Context;", "getVAP2", "", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "listener", "Lkotlin/Function1;", "fetchAvatar", "Landroid/graphics/Bitmap;", "giftAvatar", "", "isMystery", "", "userAvatar", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBitmap", "url", "getBitmap2", "(Ljava/lang/String;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDynamicEntity", "dynamic", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "isSend", "setGiftText", "dynamicEntity", "data", "key", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGiftHelp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftHelp.kt\ncom/qiahao/nextvideo/utilities/GiftHelp\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,379:1\n1869#2,2:380\n*S KotlinDebug\n*F\n+ 1 GiftHelp.kt\ncom/qiahao/nextvideo/utilities/GiftHelp\n*L\n327#1:380,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftHelp {

    @NotNull
    public static final GiftHelp INSTANCE = new GiftHelp();

    private GiftHelp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchAvatar(String str, Boolean bool, String str2, Context context, Continuation<? super Bitmap> continuation) {
        GiftHelp$fetchAvatar$1 giftHelp$fetchAvatar$1;
        int i;
        Bitmap bitmap;
        try {
            if (continuation instanceof GiftHelp$fetchAvatar$1) {
                giftHelp$fetchAvatar$1 = (GiftHelp$fetchAvatar$1) continuation;
                int i2 = giftHelp$fetchAvatar$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    giftHelp$fetchAvatar$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = giftHelp$fetchAvatar$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = giftHelp$fetchAvatar$1.label;
                    if (i == 0) {
                        if (i != 1) {
                            if (i == 2) {
                                ResultKt.throwOnFailure(obj);
                                bitmap = (Bitmap) obj;
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            bitmap = (Bitmap) obj;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        if (str.length() > 0) {
                            giftHelp$fetchAvatar$1.label = 1;
                            obj = getBitmap2(str, context, giftHelp$fetchAvatar$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            bitmap = (Bitmap) obj;
                        } else {
                            if (Intrinsics.areEqual(bool, Boxing.boxBoolean(true))) {
                                return ImageUtils.getBitmap(2131232937, UiKtxKt.toPX(100), UiKtxKt.toPX(100));
                            }
                            if (str2.length() <= 0) {
                                return null;
                            }
                            giftHelp$fetchAvatar$1.label = 2;
                            obj = getBitmap2(str2, context, giftHelp$fetchAvatar$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            bitmap = (Bitmap) obj;
                        }
                    }
                    return bitmap;
                }
            }
            if (i == 0) {
            }
            return bitmap;
        } catch (Exception unused) {
            return null;
        }
        giftHelp$fetchAvatar$1 = new GiftHelp$fetchAvatar$1(this, continuation);
        Object obj2 = giftHelp$fetchAvatar$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = giftHelp$fetchAvatar$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getBitmap2(String str, Context context, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GiftHelp$getBitmap2$2(context, str, null), continuation);
    }

    private final void setDynamicEntity(SVGADynamicEntity dynamic, String url, boolean isSend) {
        String str;
        if (url.length() > 0) {
            String imageCircle = ImageSizeKt.imageCircle(url, 100);
            if (isSend) {
                str = SVGAUtil.SENDER_AVATAR;
            } else {
                str = SVGAUtil.RECEIVER_AVATAR;
            }
            dynamic.setDynamicImage(imageCircle, str);
        }
    }

    static /* synthetic */ void setDynamicEntity$default(GiftHelp giftHelp, SVGADynamicEntity sVGADynamicEntity, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            z = true;
        }
        giftHelp.setDynamicEntity(sVGADynamicEntity, str, z);
    }

    @Nullable
    public final Bitmap getBitmap(@NotNull String url, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(context, "context");
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(context);
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return null;
        }
        c5.c R0 = Glide.with(context).b().K0(ImageSizeKt.imageCircle(url, UiKtxKt.toPX(100))).c().R0(100, 100);
        Intrinsics.checkNotNullExpressionValue(R0, "submit(...)");
        try {
            return (Bitmap) R0.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            Glide.with(context).f(R0);
        }
    }

    @NotNull
    public final SVGAMediaSource getSVGAData(@NotNull GiftDateItem giftItem) {
        Intrinsics.checkNotNullParameter(giftItem, "giftItem");
        SVGAMediaSource sVGAMediaSource = new SVGAMediaSource(giftItem.getEffectSvga());
        SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
        if (StringKtxKt.isUrl(giftItem.getGiftSendAvatar())) {
            setDynamicEntity(sVGADynamicEntity, giftItem.getGiftSendAvatar(), true);
        } else {
            SvipData svip = giftItem.getSvip();
            if (svip != null && svip.isMystery()) {
                Bitmap bitmap = ImageUtils.getBitmap(2131232937, UiKtxKt.toPX(100), UiKtxKt.toPX(100));
                Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
                sVGADynamicEntity.setDynamicImage(bitmap, SVGAUtil.SENDER_AVATAR);
            } else if (StringKtxKt.isUrl(giftItem.getSendUserAvatar())) {
                setDynamicEntity(sVGADynamicEntity, giftItem.getSendUserAvatar(), true);
            }
        }
        if (giftItem.getGiftReceiverAvatar().length() > 0) {
            setDynamicEntity(sVGADynamicEntity, giftItem.getGiftReceiverAvatar(), false);
        } else {
            SvipData receiveSvip = giftItem.getReceiveSvip();
            if (receiveSvip != null && receiveSvip.isMystery()) {
                Bitmap bitmap2 = ImageUtils.getBitmap(2131232937, UiKtxKt.toPX(100), UiKtxKt.toPX(100));
                Intrinsics.checkNotNullExpressionValue(bitmap2, "getBitmap(...)");
                sVGADynamicEntity.setDynamicImage(bitmap2, SVGAUtil.RECEIVER_AVATAR);
            } else if (giftItem.getReceiverAvatar().length() > 0) {
                setDynamicEntity(sVGADynamicEntity, giftItem.getReceiverAvatar(), false);
            }
        }
        setGiftText(sVGADynamicEntity, giftItem, SVGAUtil.SENDER_NAME);
        setGiftText(sVGADynamicEntity, giftItem, SVGAUtil.RECEIVER_NAME);
        setGiftText(sVGADynamicEntity, giftItem, SVGAUtil.GIFT_TEXT);
        sVGAMediaSource.setDynamicEntity(sVGADynamicEntity);
        return sVGAMediaSource;
    }

    @NotNull
    public final VapMediaSource getVAP(@NotNull final GiftDateItem giftItem, @NotNull final Context context) {
        Intrinsics.checkNotNullParameter(giftItem, "giftItem");
        Intrinsics.checkNotNullParameter(context, "context");
        VapMediaSource vapMediaSource = new VapMediaSource(giftItem.getEffectSvga());
        vapMediaSource.setFetchResource(new IFetchResource() { // from class: com.qiahao.nextvideo.utilities.GiftHelp$getVAP$1
            @Override // com.tencent.qgame.animplayer.inter.IFetchResource
            public void fetchImage(Resource resource, Function1<? super Bitmap, Unit> result) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                Intrinsics.checkNotNullParameter(result, "result");
                if (resource.getTag().length() > 0) {
                    String tag = resource.getTag();
                    if (Intrinsics.areEqual(tag, SVGAUtil.SENDER_AVATAR)) {
                        if (GiftDateItem.this.getGiftSendAvatar().length() > 0) {
                            result.invoke(GiftHelp.INSTANCE.getBitmap(GiftDateItem.this.getGiftSendAvatar(), context));
                            return;
                        }
                        SvipData svip = GiftDateItem.this.getSvip();
                        if (svip != null && svip.isMystery()) {
                            result.invoke(ImageUtils.getBitmap(2131232937, UiKtxKt.toPX(100), UiKtxKt.toPX(100)));
                            return;
                        } else {
                            if (GiftDateItem.this.getSendUserAvatar().length() > 0) {
                                result.invoke(GiftHelp.INSTANCE.getBitmap(GiftDateItem.this.getSendUserAvatar(), context));
                                return;
                            }
                            return;
                        }
                    }
                    if (Intrinsics.areEqual(tag, SVGAUtil.RECEIVER_AVATAR)) {
                        if (GiftDateItem.this.getGiftReceiverAvatar().length() > 0) {
                            result.invoke(GiftHelp.INSTANCE.getBitmap(GiftDateItem.this.getGiftReceiverAvatar(), context));
                            return;
                        }
                        SvipData receiveSvip = GiftDateItem.this.getReceiveSvip();
                        if (receiveSvip != null && receiveSvip.isMystery()) {
                            result.invoke(ImageUtils.getBitmap(2131232937, UiKtxKt.toPX(100), UiKtxKt.toPX(100)));
                            return;
                        } else {
                            if (GiftDateItem.this.getReceiverAvatar().length() > 0) {
                                result.invoke(GiftHelp.INSTANCE.getBitmap(GiftDateItem.this.getReceiverAvatar(), context));
                                return;
                            }
                            return;
                        }
                    }
                    result.invoke((Object) null);
                    return;
                }
                result.invoke((Object) null);
            }

            @Override // com.tencent.qgame.animplayer.inter.IFetchResource
            public void fetchText(Resource resource, Function1<? super String, Unit> result) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                Intrinsics.checkNotNullParameter(result, "result");
                if (resource.getTag().length() > 0) {
                    String tag = resource.getTag();
                    int hashCode = tag.hashCode();
                    String str = "";
                    if (hashCode != -1920850213) {
                        if (hashCode != 570610396) {
                            if (hashCode == 870265429 && tag.equals(SVGAUtil.SENDER_NAME)) {
                                String sendUserNick = GiftDateItem.this.getSendUserNick();
                                if (sendUserNick != null) {
                                    str = sendUserNick;
                                }
                                result.invoke(DataExternalKt.maxLengthSuffix(str, 8, ".."));
                                return;
                            }
                        } else if (tag.equals(SVGAUtil.GIFT_TEXT)) {
                            result.invoke(GiftDateItem.this.getGiftText());
                            return;
                        }
                    } else if (tag.equals(SVGAUtil.RECEIVER_NAME)) {
                        String receiveUserNick = GiftDateItem.this.getReceiveUserNick();
                        if (receiveUserNick != null) {
                            str = receiveUserNick;
                        }
                        result.invoke(DataExternalKt.maxLengthSuffix(str, 8, ".."));
                        return;
                    }
                    result.invoke((Object) null);
                    return;
                }
                result.invoke((Object) null);
            }

            @Override // com.tencent.qgame.animplayer.inter.IFetchResource
            public void releaseResource(List<Resource> resources) {
                Intrinsics.checkNotNullParameter(resources, "resources");
            }
        });
        return vapMediaSource;
    }

    public final void getVAP2(@NotNull final GiftDateItem giftItem, @NotNull final LifecycleCoroutineScope lifecycleScope, @NotNull Function1<? super VapMediaSource, Unit> listener, @NotNull final Context context) {
        Intrinsics.checkNotNullParameter(giftItem, "giftItem");
        Intrinsics.checkNotNullParameter(lifecycleScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(context, "context");
        VapMediaSource vapMediaSource = new VapMediaSource(giftItem.getEffectSvga());
        vapMediaSource.setFetchResource(new IFetchResource() { // from class: com.qiahao.nextvideo.utilities.GiftHelp$getVAP2$1
            @Override // com.tencent.qgame.animplayer.inter.IFetchResource
            public void fetchImage(Resource resource, Function1<? super Bitmap, Unit> result) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                Intrinsics.checkNotNullParameter(result, "result");
                if (resource.getTag().length() > 0) {
                    String tag = resource.getTag();
                    if (Intrinsics.areEqual(tag, SVGAUtil.SENDER_AVATAR)) {
                        BuildersKt.launch$default(lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new GiftHelp$getVAP2$1$fetchImage$1(giftItem, context, result, null), 3, (Object) null);
                        return;
                    } else if (Intrinsics.areEqual(tag, SVGAUtil.RECEIVER_AVATAR)) {
                        BuildersKt.launch$default(lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new GiftHelp$getVAP2$1$fetchImage$2(giftItem, context, result, null), 3, (Object) null);
                        return;
                    } else {
                        result.invoke((Object) null);
                        return;
                    }
                }
                result.invoke((Object) null);
            }

            @Override // com.tencent.qgame.animplayer.inter.IFetchResource
            public void fetchText(Resource resource, Function1<? super String, Unit> result) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                Intrinsics.checkNotNullParameter(result, "result");
                if (resource.getTag().length() > 0) {
                    String tag = resource.getTag();
                    int hashCode = tag.hashCode();
                    String str = "";
                    if (hashCode != -1920850213) {
                        if (hashCode != 570610396) {
                            if (hashCode == 870265429 && tag.equals(SVGAUtil.SENDER_NAME)) {
                                String sendUserNick = giftItem.getSendUserNick();
                                if (sendUserNick != null) {
                                    str = sendUserNick;
                                }
                                result.invoke(DataExternalKt.maxLengthSuffix(str, 8, ".."));
                                return;
                            }
                        } else if (tag.equals(SVGAUtil.GIFT_TEXT)) {
                            result.invoke(giftItem.getGiftText());
                            return;
                        }
                    } else if (tag.equals(SVGAUtil.RECEIVER_NAME)) {
                        String receiveUserNick = giftItem.getReceiveUserNick();
                        if (receiveUserNick != null) {
                            str = receiveUserNick;
                        }
                        result.invoke(DataExternalKt.maxLengthSuffix(str, 8, ".."));
                        return;
                    }
                    result.invoke((Object) null);
                    return;
                }
                result.invoke((Object) null);
            }

            @Override // com.tencent.qgame.animplayer.inter.IFetchResource
            public void releaseResource(List<Resource> resources) {
                Intrinsics.checkNotNullParameter(resources, "resources");
            }
        });
        listener.invoke(vapMediaSource);
    }

    public final void setGiftText(@NotNull SVGADynamicEntity dynamicEntity, @NotNull GiftDateItem data, @NotNull String key) {
        int parseColor;
        Typeface typeface;
        Typeface typeface2;
        Typeface typeface3;
        Intrinsics.checkNotNullParameter(dynamicEntity, "dynamicEntity");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        List<TextStyles> textStyleList = data.getTextStyleList();
        TextStyles textStyles = null;
        if (textStyleList != null) {
            for (TextStyles textStyles2 : textStyleList) {
                if (Intrinsics.areEqual(textStyles2.getTextKey(), key)) {
                    textStyles = textStyles2;
                }
            }
        }
        if (textStyles == null) {
            return;
        }
        try {
            String textColor = textStyles.getTextColor();
            if (textColor == null) {
                textColor = "#000000";
            }
            parseColor = Color.parseColor(textColor);
        } catch (Exception unused) {
            parseColor = Color.parseColor("#000000");
        }
        int hashCode = key.hashCode();
        float f = 15.0f;
        String str = "";
        if (hashCode != -1920850213) {
            if (hashCode != 570610396) {
                if (hashCode == 870265429 && key.equals(SVGAUtil.SENDER_NAME)) {
                    SVGAUtil sVGAUtil = SVGAUtil.INSTANCE;
                    String sendUserNick = data.getSendUserNick();
                    if (sendUserNick != null) {
                        str = sendUserNick;
                    }
                    String maxLengthSuffix = DataExternalKt.maxLengthSuffix(str, 8, "..");
                    Integer valueOf = Integer.valueOf(parseColor);
                    Float textSize = textStyles.getTextSize();
                    if (textSize != null) {
                        f = textSize.floatValue();
                    }
                    Float valueOf2 = Float.valueOf(f);
                    if (Intrinsics.areEqual(textStyles.isBold(), Boolean.TRUE)) {
                        typeface3 = Typeface.DEFAULT_BOLD;
                    } else {
                        typeface3 = Typeface.DEFAULT;
                    }
                    sVGAUtil.setText(dynamicEntity, maxLengthSuffix, key, valueOf, valueOf2, typeface3, Layout.Alignment.ALIGN_CENTER);
                    return;
                }
                return;
            }
            if (key.equals(SVGAUtil.GIFT_TEXT)) {
                SVGAUtil sVGAUtil2 = SVGAUtil.INSTANCE;
                String giftText = data.getGiftText();
                if (giftText == null) {
                    giftText = "";
                }
                Integer valueOf3 = Integer.valueOf(parseColor);
                Float textSize2 = textStyles.getTextSize();
                if (textSize2 != null) {
                    f = textSize2.floatValue();
                }
                Float valueOf4 = Float.valueOf(f);
                if (Intrinsics.areEqual(textStyles.isBold(), Boolean.TRUE)) {
                    typeface2 = Typeface.DEFAULT_BOLD;
                } else {
                    typeface2 = Typeface.DEFAULT;
                }
                sVGAUtil2.setText(dynamicEntity, giftText, key, valueOf3, valueOf4, typeface2, Layout.Alignment.ALIGN_CENTER);
                return;
            }
            return;
        }
        if (key.equals(SVGAUtil.RECEIVER_NAME)) {
            SVGAUtil sVGAUtil3 = SVGAUtil.INSTANCE;
            String receiveUserNick = data.getReceiveUserNick();
            if (receiveUserNick != null) {
                str = receiveUserNick;
            }
            String maxLengthSuffix2 = DataExternalKt.maxLengthSuffix(str, 8, "..");
            Integer valueOf5 = Integer.valueOf(parseColor);
            Float textSize3 = textStyles.getTextSize();
            if (textSize3 != null) {
                f = textSize3.floatValue();
            }
            Float valueOf6 = Float.valueOf(f);
            if (Intrinsics.areEqual(textStyles.isBold(), Boolean.TRUE)) {
                typeface = Typeface.DEFAULT_BOLD;
            } else {
                typeface = Typeface.DEFAULT;
            }
            sVGAUtil3.setText(dynamicEntity, maxLengthSuffix2, key, valueOf5, valueOf6, typeface, Layout.Alignment.ALIGN_CENTER);
        }
    }
}
