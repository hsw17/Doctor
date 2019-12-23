package com.wd.doctor.fragment.choose;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.wd.doctor.R;
import com.wd.doctor.activity.manage.ManageActivity;
import com.wd.doctor.bean.UploadImagePicBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseFragment;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;
import com.wd.mvplibrary.utils.ToastUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static android.app.Activity.RESULT_CANCELED;

/**
 * describe:CustomizeFragment
 * date:2019/12/22
 * author:任(Lenovo)
 * function:
 */
public class CustomizeFragment extends BaseFragment<Presenter> implements Contract.IView {
    @BindView(R.id.linear_view)
    RelativeLayout linearView;
    @BindView(R.id.linear_customize)
    LinearLayout linearCustomize;
    @BindView(R.id.relative_customize)
    RelativeLayout relativeCustomize;
    @BindView(R.id.img_customize)
    ImageView imgCustomize;
    private String sessionId;
    private String doctorId;
    private MultipartBody.Part formData;
    private MultipartBody.Part formData1;
    public static final String TAG = "CustomizeFragment";

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_customize;
    }

    @Override
    protected void initData() {
        super.initData();
        SPUtils user = new SPUtils(getContext(), "user");
        doctorId = (String) user.getSharedPreference("doctorId", "");
        sessionId = (String) user.getSharedPreference("sessionId", "");
        ToastUtils.init(getContext());
    }

    @Override
    public void onSuccess(Object obj) {
        UploadImagePicBean uploadImagePicBean = (UploadImagePicBean) obj;
        Logger.e(TAG,uploadImagePicBean.getMessage());
        if ("0000".equals(uploadImagePicBean.getStatus())) {
            Intent intent = new Intent(getContext(), ManageActivity.class);
            startActivity(intent);
            getActivity().finish();
            ToastUtils.show(uploadImagePicBean.getMessage());
        }else {
            ToastUtils.show(uploadImagePicBean.getMessage());
        }
    }

    @Override
    public void onSuccessOne(Object one) {

    }

    @Override
    public void onSuccessTwo(Object two) {

    }

    @Override
    public void onSuccessThree(Object three) {

    }

    @Override
    public void onSuccessFour(Object four) {

    }

    @Override
    public void onFail(String str) {

    }

    @OnClick({R.id.tv_cinema, R.id.tv_photo, R.id.tv_finish,R.id.linear_customize, R.id.tv_ok_customize_image_pic,R.id.relative_customize})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cinema:
                Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent1, 101);
                break;
            case R.id.tv_photo:
                Intent intent = new Intent(Intent.ACTION_PICK);  //跳转到 ACTION_IMAGE_CAPTURE
                intent.setType("image/*");
                startActivityForResult(intent, 100);
                break;
            case R.id.tv_finish:
                linearView.setVisibility(View.GONE);
                break;
            case R.id.linear_customize:
                linearView.setVisibility(View.VISIBLE);
                break;
            case R.id.relative_customize:
                linearView.setVisibility(View.GONE);
                break;
            case R.id.tv_ok_customize_image_pic:
                if (formData==null) {
                    presenter.doFindUploadImagePic(doctorId,sessionId,formData1);
                }else if (formData1==null){
                    presenter.doFindUploadImagePic(doctorId,sessionId,formData);
                }
                linearView.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != RESULT_CANCELED) {
            //读取返回码
            switch (requestCode) {
                case 100:   //相册返回的数据（相册的返回码）
                    Uri uri01 = data.getData();
                    Logger.e("aaa", "onActivityResult: " + uri01);
                    String[] str = {MediaStore.Images.Media.DATA};
//                    游标
                    Cursor cursor = getActivity().getContentResolver().query(uri01, str, null, null, null);
//                  如果没有找到该列名,会抛出IllegalArgumentException异常
                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    cursor.moveToFirst();

                    String path = cursor.getString(columnIndexOrThrow);
                    Logger.e("aaa", "onActivityResult: " + path);
//                    文件
                    File file = new File(path);
//                      创建请求体
                    Bitmap bitmap = BitmapFactory.decodeFile(path);
                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    formData = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
                    Logger.e("aaa", "onActivityResult: " + formData);
                    imgCustomize.setImageBitmap(bitmap);
                    imgCustomize.setVisibility(View.VISIBLE);
                    linearView.setVisibility(View.GONE);
                    linearCustomize.setVisibility(View.GONE);
                    break;
                case 101:  //相机返回的数据（相机的返回码）
                    try {
                        Bitmap bitmap1 = data.getParcelableExtra("data");
                        File file1 = saveBitmapFile(bitmap1);
                        RequestBody requestBody1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
                        formData1 = MultipartBody.Part.createFormData("image", file1.getName(), requestBody1);
                        imgCustomize.setImageBitmap(bitmap1);
                        imgCustomize.setVisibility(View.VISIBLE);
                        linearView.setVisibility(View.GONE);
                        linearCustomize.setVisibility(View.GONE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
    public File saveBitmapFile(Bitmap bitmap) {
        String timeStamp = String.valueOf(new Date().getTime());
        File file = new File(Environment.getExternalStorageDirectory() +
                File.separator + timeStamp + ".jpg");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
