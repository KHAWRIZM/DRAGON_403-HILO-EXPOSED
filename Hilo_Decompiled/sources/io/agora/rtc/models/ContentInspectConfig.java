package io.agora.rtc.models;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class ContentInspectConfig {
    public static final int CONTENT_INSPECT_TYPE_INVALID = 0;
    public static final int CONTENT_INSPECT_TYPE_MODERATION = 1;
    public static final int CONTENT_INSPECT_TYPE_SUPERVISE = 2;
    public static final int MAX_CONTENT_INSPECT_MODULE_COUNT = 32;
    public String extraInfo;
    public int moduleCount;
    public ContentInspectModule[] modules;

    public ContentInspectConfig() {
        this.modules = new ContentInspectModule[32];
        for (int i10 = 0; i10 < 32; i10++) {
            this.modules[i10] = new ContentInspectModule();
        }
        this.moduleCount = 0;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class ContentInspectModule {
        public int interval;
        public int type;

        public ContentInspectModule() {
            this.type = 0;
            this.interval = 0;
        }

        public ContentInspectModule(int i10, int i11) {
            this.type = i10;
            this.interval = i11;
        }
    }

    public ContentInspectConfig(ContentInspectModule[] contentInspectModuleArr, String str) {
        this.modules = new ContentInspectModule[32];
        for (int i10 = 0; i10 < 32; i10++) {
            this.modules[i10] = new ContentInspectModule();
        }
        for (int i11 = 0; i11 < contentInspectModuleArr.length; i11++) {
            ContentInspectModule contentInspectModule = this.modules[i11];
            ContentInspectModule contentInspectModule2 = contentInspectModuleArr[i11];
            contentInspectModule.type = contentInspectModule2.type;
            contentInspectModule.interval = contentInspectModule2.interval;
            this.moduleCount++;
        }
        this.extraInfo = str;
    }

    public ContentInspectConfig(ContentInspectModule[] contentInspectModuleArr) {
        this.modules = new ContentInspectModule[32];
        for (int i10 = 0; i10 < 32; i10++) {
            this.modules[i10] = new ContentInspectModule();
        }
        for (int i11 = 0; i11 < contentInspectModuleArr.length; i11++) {
            ContentInspectModule contentInspectModule = this.modules[i11];
            ContentInspectModule contentInspectModule2 = contentInspectModuleArr[i11];
            contentInspectModule.type = contentInspectModule2.type;
            contentInspectModule.interval = contentInspectModule2.interval;
            this.moduleCount++;
        }
    }
}
