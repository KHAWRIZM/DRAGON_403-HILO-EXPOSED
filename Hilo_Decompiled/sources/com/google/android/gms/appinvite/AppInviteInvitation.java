package com.google.android.gms.appinvite;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class AppInviteInvitation {
    private static final String[] zzf = {"jpg", "jpeg", "png"};

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class IntentBuilder {
        public static final int MAX_CALL_TO_ACTION_TEXT_LENGTH = 20;
        public static final int MAX_EMAIL_HTML_CONTENT = 512000;
        public static final int MAX_MESSAGE_LENGTH = 100;
        public static final int MIN_CALL_TO_ACTION_TEXT_LENGTH = 2;
        private final Intent intent;
        private String zzg;
        private String zzh;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public @interface PlatformMode {
            public static final int PROJECT_PLATFORM_ANDROID = 2;
            public static final int PROJECT_PLATFORM_IOS = 1;
        }

        public IntentBuilder(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            Intent intent = new Intent("com.google.android.gms.appinvite.ACTION_APP_INVITE");
            this.intent = intent;
            intent.putExtra("com.google.android.gms.appinvite.TITLE", charSequence);
            intent.setPackage("com.google.android.gms");
        }

        public final Intent build() {
            boolean z10;
            if (!TextUtils.isEmpty(this.zzg)) {
                Preconditions.checkNotEmpty(this.zzh, "Email html content must be set when email subject is set.");
                if (this.intent.getData() == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Preconditions.checkArgument(z10, "Custom image must not be set when email html content is set.");
                Preconditions.checkArgument(TextUtils.isEmpty(this.intent.getCharSequenceExtra("com.google.android.gms.appinvite.BUTTON_TEXT")), "Call to action text must not be set when email html content is set.");
                this.intent.putExtra("com.google.android.gms.appinvite.EMAIL_SUBJECT", this.zzg);
                this.intent.putExtra("com.google.android.gms.appinvite.EMAIL_CONTENT", this.zzh);
            } else if (!TextUtils.isEmpty(this.zzh)) {
                throw new IllegalArgumentException("Email subject must be set when email html content is set.");
            }
            return this.intent;
        }

        public final IntentBuilder setAccount(Account account) {
            if (account != null && "com.google".equals(account.type)) {
                this.intent.putExtra("com.google.android.gms.appinvite.ACCOUNT_NAME", account);
            } else {
                this.intent.removeExtra("com.google.android.gms.appinvite.ACCOUNT_NAME");
            }
            return this;
        }

        public final IntentBuilder setAdditionalReferralParameters(Map<String, String> map) {
            if (map != null) {
                this.intent.putExtra("com.google.android.gms.appinvite.REFERRAL_PARAMETERS_URI", AppInviteInvitation.zza(map));
            } else {
                this.intent.removeExtra("com.google.android.gms.appinvite.REFERRAL_PARAMETERS_URI");
            }
            return this;
        }

        public final IntentBuilder setAndroidMinimumVersionCode(int i10) {
            this.intent.putExtra("com.google.android.gms.appinvite.appMinimumVersionCode", i10);
            return this;
        }

        public final IntentBuilder setCallToActionText(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() >= 2 && charSequence.length() <= 20) {
                this.intent.putExtra("com.google.android.gms.appinvite.BUTTON_TEXT", charSequence);
                return this;
            }
            throw new IllegalArgumentException(String.format("Text must be between %d and %d chars in length.", 2, 20));
        }

        public final IntentBuilder setCustomImage(Uri uri) {
            boolean z10;
            boolean z11;
            Preconditions.checkNotNull(uri);
            Preconditions.checkArgument(uri.isAbsolute(), "Image uri is not an absolute uri. Did you forget to add a scheme to the Uri?");
            String lowerCase = uri.getScheme().toLowerCase();
            boolean z12 = false;
            if (!lowerCase.equals("android.resource") && !lowerCase.equals("content") && !lowerCase.equals("file")) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10 && !lowerCase.equals(HttpConstant.HTTP) && !lowerCase.equals(HttpConstant.HTTPS)) {
                z11 = false;
            } else {
                z11 = true;
            }
            Preconditions.checkArgument(z11, "Image uri must be a content URI with scheme \"android.resource\", \"content\" or \"file\", or a network url with scheme \"http\" or \"https\".");
            if (!z10) {
                String lastPathSegment = uri.getLastPathSegment();
                String str = null;
                if (lastPathSegment != null && lastPathSegment.lastIndexOf(InstructionFileId.DOT) != -1) {
                    str = lastPathSegment.substring(lastPathSegment.lastIndexOf(InstructionFileId.DOT) + 1, lastPathSegment.length()).toLowerCase();
                }
                if (TextUtils.isEmpty(str) || AppInviteInvitation.zza(str)) {
                    z12 = true;
                }
                Preconditions.checkArgument(z12, String.valueOf(str).concat(" images are not supported. Only jpg, jpeg, or png images are supported."));
            }
            this.intent.setData(uri.buildUpon().scheme(lowerCase).build());
            if (z10) {
                this.intent.addFlags(1);
            }
            return this;
        }

        public final IntentBuilder setDeepLink(Uri uri) {
            if (uri != null) {
                this.intent.putExtra("com.google.android.gms.appinvite.DEEP_LINK_URL", uri);
            } else {
                this.intent.removeExtra("com.google.android.gms.appinvite.DEEP_LINK_URL");
            }
            return this;
        }

        public final IntentBuilder setEmailHtmlContent(String str) {
            if (str != null && str.getBytes().length > 512000) {
                throw new IllegalArgumentException(String.format("Email html content must be %d bytes or less.", Integer.valueOf(MAX_EMAIL_HTML_CONTENT)));
            }
            this.zzh = str;
            return this;
        }

        public final IntentBuilder setEmailSubject(String str) {
            this.zzg = str;
            return this;
        }

        public final IntentBuilder setGoogleAnalyticsTrackingId(String str) {
            this.intent.putExtra("com.google.android.gms.appinvite.GOOGLE_ANALYTICS_TRACKING_ID", str);
            return this;
        }

        public final IntentBuilder setMessage(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 100) {
                throw new IllegalArgumentException(String.format("Message must be %d chars or less.", 100));
            }
            this.intent.putExtra("com.google.android.gms.appinvite.MESSAGE", charSequence);
            return this;
        }

        public final IntentBuilder setOtherPlatformsTargetApplication(int i10, String str) throws IllegalArgumentException {
            if (i10 != 1) {
                if (i10 == 2) {
                    this.intent.putExtra("com.google.android.gms.appinvite.androidTargetApplication", str);
                } else {
                    throw new IllegalArgumentException("targetPlatform must be either PROJECT_PLATFORM_IOS or PROJECT_PLATFORM_ANDROID.");
                }
            } else {
                this.intent.putExtra("com.google.android.gms.appinvite.iosTargetApplication", str);
            }
            return this;
        }
    }

    private AppInviteInvitation() {
    }

    public static String[] getInvitationIds(int i10, Intent intent) {
        if (i10 == -1) {
            return intent.getStringArrayExtra("com.google.android.gms.appinvite.RESULT_INVITATION_IDS");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle zza(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zza(String str) {
        int i10 = 0;
        while (true) {
            String[] strArr = zzf;
            if (i10 >= strArr.length) {
                return false;
            }
            if (strArr[i10].equals(str)) {
                return true;
            }
            i10++;
        }
    }
}
