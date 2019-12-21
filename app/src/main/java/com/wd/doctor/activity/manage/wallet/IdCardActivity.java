package com.wd.doctor.activity.manage.wallet;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.sdk.model.IDCardParams;
import com.baidu.ocr.sdk.model.IDCardResult;
import com.baidu.ocr.sdk.model.Word;
import com.wd.doctor.R;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;

import java.io.File;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IdCardActivity extends BaseActivity<Presenter> implements Contract.IView {


    @BindView(R.id.img_id_card_back)
    ImageView imgIdCardBack;
    @BindView(R.id.img_id_card_front)
    ImageView imgIdCardFront;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img_camera_id_card_front)
    ImageView imgCameraIdCardFront;
    @BindView(R.id.img_camera_id_card_back)
    ImageView imgCameraIdCardBack;
    @BindView(R.id.btn_next_id_card)
    Button btnNextIdCard;
    @BindView(R.id.btn_finish_id_card)
    Button btnFinishIdCard;
    @BindView(R.id.linear_id_card_front)
    LinearLayout linearIdCardFront;
    @BindView(R.id.linear_id_card_back)
    LinearLayout linearIdCardBack;
    @BindView(R.id.img_cuowu_front)
    ImageView imgCuowuFront;
    @BindView(R.id.img_cuowu_back)
    ImageView imgCuowuBack;
    private String path;
    private String path1;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_id_card;
    }

    @Override
    protected void initData() {
        super.initData();
        OCR.getInstance(this).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken accessToken) {
                // 调用成功，返回AccessToken对象
                String token = accessToken.getAccessToken();
            }

            @Override
            public void onError(OCRError ocrError) {
                // 调用失败，返回OCRError子类SDKError对象
            }
        },getApplicationContext(),"eG2VaGYB41ffrpAvTqQ50FPK","qL7Uas2mUGtfRZ6nNPGnRvQHi3f5wjEF");
    }

    @Override
    public void onSuccess(Object obj) {

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

    @OnClick({R.id.img_back, R.id.img_camera_id_card_front, R.id.img_camera_id_card_back, R.id.btn_next_id_card, R.id.btn_finish_id_card,
            R.id.img_cuowu_front, R.id.img_cuowu_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_camera_id_card_front:
                Intent intent = new Intent(Intent.ACTION_PICK);  //跳转到 ACTION_IMAGE_CAPTURE
                intent.setType("image/*");
                startActivityForResult(intent, 100);
                break;
            case R.id.img_camera_id_card_back:
                Intent intent1 = new Intent(Intent.ACTION_PICK);
                intent1.setType("image/*");
                startActivityForResult(intent1, 101);
                break;
            case R.id.btn_next_id_card:
                btnFinishIdCard.setVisibility(View.VISIBLE);
                btnNextIdCard.setVisibility(View.GONE);
                imgCuowuFront.setVisibility(View.VISIBLE);
                imgCuowuBack.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_finish_id_card:
                IDCardParams idCardParams = new IDCardParams();
                idCardParams.setImageFile(new File(path));
                OCR.getInstance(this).recognizeIDCard(idCardParams, new OnResultListener<IDCardResult>() {
                    @Override
                    public void onResult(IDCardResult idCardResult) {
                        Logger.e("address",idCardResult.toString());
                        
                    }

                    @Override
                    public void onError(OCRError ocrError) {
                        Logger.e("aaa",ocrError.toString());
                    }
                });
                break;
            case R.id.img_cuowu_front:
                imgIdCardFront.setImageDrawable(null);
                imgCuowuFront.setVisibility(View.GONE);
                linearIdCardFront.setVisibility(View.VISIBLE);
                break;
            case R.id.img_cuowu_back:
                imgIdCardBack.setImageDrawable(null);
                imgCuowuBack.setVisibility(View.GONE);
                linearIdCardBack.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != RESULT_CANCELED) {
            //读取返回码
            switch (requestCode) {
                case 100://相册返回的数据（相册的返回码）
                    Uri uri01 = data.getData();
                    Logger.e("aaa", "onActivityResult: " + uri01);
                    String[] str = {MediaStore.Images.Media.DATA};
//                    游标
                    Cursor cursor = getContentResolver().query(uri01, str, null, null, null);
//                  如果没有找到该列名,会抛出IllegalArgumentException异常
                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    cursor.moveToFirst();

                    path = cursor.getString(columnIndexOrThrow);
                    Logger.e("aaa", "onActivityResult: " + path);
//                    文件
                    Bitmap bitmap = BitmapFactory.decodeFile(path);
                    imgIdCardFront.setImageBitmap(bitmap);
                    linearIdCardFront.setVisibility(View.GONE);
                    break;
                case 101:
                    Uri uri02 = data.getData();
                    Logger.e("aaa", "onActivityResult: " + uri02);
                    String[] str1 = {MediaStore.Images.Media.DATA};
//                    游标
                    Cursor cursor1 = getContentResolver().query(uri02, str1, null, null, null);
//                  如果没有找到该列名,会抛出IllegalArgumentException异常
                    int columnIndexOrThrow1 = cursor1.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    cursor1.moveToFirst();

                    path1 = cursor1.getString(columnIndexOrThrow1);
                    Logger.e("aaa", "onActivityResult: " + path1);
//                    文件
                    Bitmap bitmap1 = BitmapFactory.decodeFile(path1);
                    imgIdCardBack.setImageBitmap(bitmap1);
                    linearIdCardBack.setVisibility(View.GONE);
                    break;

            }
        }
    }
}
