package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.e;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.a;
import androidx.core.graphics.d;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropFragment;
import com.yalantis.ucrop.UCropGalleryAdapter;
import com.yalantis.ucrop.decoration.GridSpacingItemDecoration;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.model.CustomIntentKey;
import com.yalantis.ucrop.statusbar.ImmersiveManager;
import com.yalantis.ucrop.util.DensityUtil;
import com.yalantis.ucrop.util.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class UCropMultipleActivity extends AppCompatActivity implements UCropFragmentCallback {
    private ArrayList<AspectRatio> aspectRatioList;
    private int currentFragmentPosition;
    private UCropGalleryAdapter galleryAdapter;
    private boolean isForbidCropGifWebp;
    private boolean isSkipCropForbid;
    private boolean mShowLoader;
    private int mStatusBarColor;
    private int mToolbarCancelDrawable;
    private int mToolbarColor;
    private int mToolbarCropDrawable;
    private String mToolbarTitle;
    private int mToolbarTitleSize;
    private int mToolbarWidgetColor;
    private String outputCropFileName;
    private UCropFragment uCropCurrentFragment;
    private ArrayList<String> uCropNotSupportList;
    private ArrayList<String> uCropSupportList;
    private final List<UCropFragment> fragments = new ArrayList();
    private final LinkedHashMap<String, JSONObject> uCropTotalQueue = new LinkedHashMap<>();
    private final HashSet<String> filterSet = new HashSet<>();

    static {
        e.I(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getCropSupportPosition() {
        ArrayList<String> stringArrayList;
        Bundle extras = getIntent().getExtras();
        if (extras == null || (stringArrayList = extras.getStringArrayList(UCrop.Options.EXTRA_SKIP_CROP_MIME_TYPE)) == null || stringArrayList.size() <= 0) {
            return 0;
        }
        this.filterSet.addAll(stringArrayList);
        int i = -1;
        for (int i2 = 0; i2 < this.uCropSupportList.size(); i2++) {
            i++;
            if (!this.filterSet.contains(getPathToMimeType(this.uCropSupportList.get(i2)))) {
                break;
            }
        }
        if (i == -1 || i > this.fragments.size()) {
            return 0;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public String getPathToMimeType(String str) {
        if (FileUtils.isContent(str)) {
            return FileUtils.getMimeTypeFromMediaContentUri(this, Uri.parse(str));
        }
        return FileUtils.getMimeTypeFromMediaContentUri(this, Uri.fromFile(new File(str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String getSandboxPathDir() {
        File file;
        String stringExtra = getIntent().getStringExtra(UCrop.Options.EXTRA_CROP_OUTPUT_DIR);
        if (stringExtra != null && !"".equals(stringExtra)) {
            file = new File(stringExtra);
        } else {
            file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath(), "Sandbox");
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleCropError(Intent intent) {
        Throwable error = UCrop.getError(intent);
        if (error != null) {
            Toast.makeText((Context) this, (CharSequence) error.getMessage(), 1).show();
        } else {
            Toast.makeText((Context) this, (CharSequence) "Unexpected error", 0).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void immersive() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(UCrop.Options.EXTRA_DARK_STATUS_BAR_BLACK, false);
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, a.getColor(this, R.color.ucrop_color_statusbar));
        this.mStatusBarColor = intExtra;
        ImmersiveManager.immersiveAboveAPI23(this, intExtra, intExtra, booleanExtra);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initCropFragments(Intent intent) {
        String str;
        Uri parse;
        String str2;
        AspectRatio aspectRatio;
        this.isSkipCropForbid = intent.getBooleanExtra(UCrop.Options.EXTRA_CROP_FORBID_SKIP, false);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(UCrop.EXTRA_CROP_TOTAL_DATA_SOURCE);
        if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
            this.uCropSupportList = new ArrayList<>();
            this.uCropNotSupportList = new ArrayList<>();
            for (int i = 0; i < stringArrayListExtra.size(); i++) {
                String str3 = stringArrayListExtra.get(i);
                this.uCropTotalQueue.put(str3, new JSONObject());
                if (FileUtils.isContent(str3)) {
                    str = FileUtils.getPath(this, Uri.parse(str3));
                } else {
                    str = str3;
                }
                String pathToMimeType = getPathToMimeType(str3);
                if (!FileUtils.isUrlHasVideo(str) && !FileUtils.isHasVideo(pathToMimeType) && !FileUtils.isHasAudio(pathToMimeType)) {
                    this.uCropSupportList.add(str3);
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        if (!FileUtils.isContent(str3) && !FileUtils.isHasHttp(str3)) {
                            parse = Uri.fromFile(new File(str3));
                        } else {
                            parse = Uri.parse(str3);
                        }
                        String postfixDefaultJPEG = FileUtils.getPostfixDefaultJPEG(this, this.isForbidCropGifWebp, parse);
                        if (TextUtils.isEmpty(this.outputCropFileName)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(FileUtils.getCreateFileName("CROP_" + (i + 1)));
                            sb2.append(postfixDefaultJPEG);
                            str2 = sb2.toString();
                        } else {
                            str2 = (i + 1) + FileUtils.getCreateFileName() + "_" + this.outputCropFileName;
                        }
                        Uri fromFile = Uri.fromFile(new File(getSandboxPathDir(), str2));
                        extras.putParcelable(UCrop.EXTRA_INPUT_URI, parse);
                        extras.putParcelable(UCrop.EXTRA_OUTPUT_URI, fromFile);
                        ArrayList<AspectRatio> arrayList = this.aspectRatioList;
                        if (arrayList != null && arrayList.size() > i) {
                            aspectRatio = this.aspectRatioList.get(i);
                        } else {
                            aspectRatio = null;
                        }
                        if (aspectRatio != null) {
                            extras.putFloat(UCrop.EXTRA_ASPECT_RATIO_X, aspectRatio.getAspectRatioX());
                            extras.putFloat(UCrop.EXTRA_ASPECT_RATIO_Y, aspectRatio.getAspectRatioY());
                        }
                        this.fragments.add(UCropFragment.newInstance(extras));
                    }
                } else {
                    this.uCropNotSupportList.add(str3);
                }
            }
            if (this.uCropSupportList.size() != 0) {
                setGalleryAdapter();
                switchCropFragment(this.fragments.get(getCropSupportPosition()), getCropSupportPosition());
                this.galleryAdapter.setCurrentSelectPosition(getCropSupportPosition());
                return;
            }
            throw new IllegalArgumentException("No clipping data sources are available");
        }
        throw new IllegalArgumentException("Missing required parameters, count cannot be less than 1");
    }

    private void mergeCropResult(Intent intent) {
        String str;
        try {
            String stringExtra = intent.getStringExtra(UCrop.EXTRA_CROP_INPUT_ORIGINAL);
            JSONObject jSONObject = this.uCropTotalQueue.get(stringExtra);
            Uri output = UCrop.getOutput(intent);
            if (output != null) {
                str = output.getPath();
            } else {
                str = "";
            }
            jSONObject.put(CustomIntentKey.EXTRA_OUT_PUT_PATH, str);
            jSONObject.put(CustomIntentKey.EXTRA_IMAGE_WIDTH, UCrop.getOutputImageWidth(intent));
            jSONObject.put(CustomIntentKey.EXTRA_IMAGE_HEIGHT, UCrop.getOutputImageHeight(intent));
            jSONObject.put(CustomIntentKey.EXTRA_OFFSET_X, UCrop.getOutputImageOffsetX(intent));
            jSONObject.put(CustomIntentKey.EXTRA_OFFSET_Y, UCrop.getOutputImageOffsetY(intent));
            jSONObject.put(CustomIntentKey.EXTRA_ASPECT_RATIO, UCrop.getOutputCropAspectRatio(intent));
            this.uCropTotalQueue.put(stringExtra, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onCropCompleteFinish() {
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<String, JSONObject>> it = this.uCropTotalQueue.entrySet().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getValue());
        }
        Intent intent = new Intent();
        intent.putExtra("output", jSONArray.toString());
        setResult(-1, intent);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setGalleryAdapter() {
        RecyclerView findViewById = findViewById(R.id.recycler_gallery);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        findViewById.setLayoutManager(linearLayoutManager);
        if (findViewById.getItemDecorationCount() == 0) {
            findViewById.addItemDecoration(new GridSpacingItemDecoration(Integer.MAX_VALUE, DensityUtil.dip2px(this, 6.0f), true));
        }
        findViewById.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(this, R.anim.ucrop_layout_animation_fall_down));
        findViewById.setBackgroundResource(getIntent().getIntExtra(UCrop.Options.EXTRA_GALLERY_BAR_BACKGROUND, R.drawable.ucrop_gallery_bg));
        UCropGalleryAdapter uCropGalleryAdapter = new UCropGalleryAdapter(this.uCropSupportList);
        this.galleryAdapter = uCropGalleryAdapter;
        uCropGalleryAdapter.setOnItemClickListener(new UCropGalleryAdapter.OnItemClickListener() { // from class: com.yalantis.ucrop.UCropMultipleActivity.1
            @Override // com.yalantis.ucrop.UCropGalleryAdapter.OnItemClickListener
            public void onItemClick(int i, View view) {
                if (UCropMultipleActivity.this.isSkipCropForbid) {
                    return;
                }
                if (UCropMultipleActivity.this.filterSet.contains(UCropMultipleActivity.this.getPathToMimeType((String) UCropMultipleActivity.this.uCropSupportList.get(i)))) {
                    Toast.makeText(UCropMultipleActivity.this.getApplicationContext(), UCropMultipleActivity.this.getString(R.string.ucrop_not_crop), 0).show();
                    return;
                }
                if (UCropMultipleActivity.this.galleryAdapter.getCurrentSelectPosition() == i) {
                    return;
                }
                UCropMultipleActivity.this.galleryAdapter.notifyItemChanged(UCropMultipleActivity.this.galleryAdapter.getCurrentSelectPosition());
                UCropMultipleActivity.this.galleryAdapter.setCurrentSelectPosition(i);
                UCropMultipleActivity.this.galleryAdapter.notifyItemChanged(i);
                UCropMultipleActivity.this.switchCropFragment((UCropFragment) UCropMultipleActivity.this.fragments.get(i), i);
            }
        });
        findViewById.setAdapter(this.galleryAdapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetApi(21)
    private void setStatusBarColor(int i) {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setupAppBar() {
        setStatusBarColor(this.mStatusBarColor);
        Toolbar findViewById = findViewById(R.id.toolbar);
        findViewById.setBackgroundColor(this.mToolbarColor);
        findViewById.setTitleTextColor(this.mToolbarWidgetColor);
        TextView textView = (TextView) findViewById.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.mToolbarWidgetColor);
        textView.setText(this.mToolbarTitle);
        textView.setTextSize(this.mToolbarTitleSize);
        Drawable mutate = r1.a.b(this, this.mToolbarCancelDrawable).mutate();
        mutate.setColorFilter(d.a(this.mToolbarWidgetColor, androidx.core.graphics.e.j));
        findViewById.setNavigationIcon(mutate);
        setSupportActionBar(findViewById);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setupViews(Intent intent) {
        this.aspectRatioList = getIntent().getParcelableArrayListExtra(UCrop.Options.EXTRA_MULTIPLE_ASPECT_RATIO);
        this.isForbidCropGifWebp = intent.getBooleanExtra(UCrop.Options.EXTRA_CROP_FORBID_GIF_WEBP, false);
        this.outputCropFileName = intent.getStringExtra(UCrop.Options.EXTRA_CROP_OUTPUT_FILE_NAME);
        this.mStatusBarColor = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, a.getColor(this, R.color.ucrop_color_statusbar));
        this.mToolbarColor = intent.getIntExtra(UCrop.Options.EXTRA_TOOL_BAR_COLOR, a.getColor(this, R.color.ucrop_color_toolbar));
        this.mToolbarWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, a.getColor(this, R.color.ucrop_color_toolbar_widget));
        this.mToolbarCancelDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, R.drawable.ucrop_ic_cross);
        this.mToolbarCropDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CROP_DRAWABLE, R.drawable.ucrop_ic_done);
        this.mToolbarTitle = intent.getStringExtra(UCrop.Options.EXTRA_UCROP_TITLE_TEXT_TOOLBAR);
        this.mToolbarTitleSize = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_TITLE_TEXT_SIZE_TOOLBAR, 18);
        String str = this.mToolbarTitle;
        if (str == null) {
            str = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.mToolbarTitle = str;
        setupAppBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchCropFragment(UCropFragment uCropFragment, int i) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (!uCropFragment.isAdded()) {
            UCropFragment uCropFragment2 = this.uCropCurrentFragment;
            if (uCropFragment2 != null) {
                beginTransaction.hide(uCropFragment2);
            }
            beginTransaction.add(R.id.fragment_container, uCropFragment, UCropFragment.TAG + "-" + i);
        } else {
            beginTransaction.hide(this.uCropCurrentFragment).show(uCropFragment);
            uCropFragment.fragmentReVisible();
        }
        this.currentFragmentPosition = i;
        this.uCropCurrentFragment = uCropFragment;
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.yalantis.ucrop.UCropFragmentCallback
    public void loadingProgress(boolean z) {
        this.mShowLoader = z;
        supportInvalidateOptionsMenu();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        immersive();
        setContentView(R.layout.ucrop_activity_multiple);
        setupViews(getIntent());
        initCropFragments(getIntent());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem findItem = menu.findItem(R.id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(d.a(this.mToolbarWidgetColor, androidx.core.graphics.e.j));
                findItem.setIcon(icon);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawable = a.getDrawable(this, this.mToolbarCropDrawable);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(d.a(this.mToolbarWidgetColor, androidx.core.graphics.e.j));
            findItem2.setIcon(drawable);
            return true;
        }
        return true;
    }

    @Override // com.yalantis.ucrop.UCropFragmentCallback
    public void onCropFinish(UCropFragment.UCropResult uCropResult) {
        int i = uCropResult.mResultCode;
        if (i != -1) {
            if (i == 96) {
                handleCropError(uCropResult.mResultData);
                return;
            }
            return;
        }
        int size = this.currentFragmentPosition + this.uCropNotSupportList.size();
        int size2 = (this.uCropNotSupportList.size() + this.uCropSupportList.size()) - 1;
        mergeCropResult(uCropResult.mResultData);
        if (size == size2) {
            onCropCompleteFinish();
            return;
        }
        int i2 = this.currentFragmentPosition + 1;
        String pathToMimeType = getPathToMimeType(this.uCropSupportList.get(i2));
        while (this.filterSet.contains(pathToMimeType)) {
            if (i2 == size2) {
                onCropCompleteFinish();
                return;
            } else {
                i2++;
                pathToMimeType = getPathToMimeType(this.uCropSupportList.get(i2));
            }
        }
        switchCropFragment(this.fragments.get(i2), i2);
        UCropGalleryAdapter uCropGalleryAdapter = this.galleryAdapter;
        uCropGalleryAdapter.notifyItemChanged(uCropGalleryAdapter.getCurrentSelectPosition());
        this.galleryAdapter.setCurrentSelectPosition(i2);
        UCropGalleryAdapter uCropGalleryAdapter2 = this.galleryAdapter;
        uCropGalleryAdapter2.notifyItemChanged(uCropGalleryAdapter2.getCurrentSelectPosition());
    }

    protected void onDestroy() {
        UCropDevelopConfig.destroy();
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            UCropFragment uCropFragment = this.uCropCurrentFragment;
            if (uCropFragment != null && uCropFragment.isAdded()) {
                this.uCropCurrentFragment.cropAndSaveImage();
            }
        } else if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.mShowLoader);
        menu.findItem(R.id.menu_loader).setVisible(this.mShowLoader);
        return super/*android.app.Activity*/.onPrepareOptionsMenu(menu);
    }
}
