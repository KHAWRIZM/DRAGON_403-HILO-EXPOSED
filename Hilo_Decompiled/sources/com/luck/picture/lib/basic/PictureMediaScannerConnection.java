package com.luck.picture.lib.basic;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PictureMediaScannerConnection implements MediaScannerConnection.MediaScannerConnectionClient {
    private ScanListener mListener;
    private final MediaScannerConnection mMs;
    private final String mPath;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface ScanListener {
        void onScanFinish();
    }

    public PictureMediaScannerConnection(Context context, String str, ScanListener scanListener) {
        this.mListener = scanListener;
        this.mPath = str;
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context.getApplicationContext(), this);
        this.mMs = mediaScannerConnection;
        mediaScannerConnection.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (!TextUtils.isEmpty(this.mPath)) {
            this.mMs.scanFile(this.mPath, null);
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.mMs.disconnect();
        ScanListener scanListener = this.mListener;
        if (scanListener != null) {
            scanListener.onScanFinish();
        }
    }

    public PictureMediaScannerConnection(Context context, String str) {
        this.mPath = str;
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context.getApplicationContext(), this);
        this.mMs = mediaScannerConnection;
        mediaScannerConnection.connect();
    }
}
