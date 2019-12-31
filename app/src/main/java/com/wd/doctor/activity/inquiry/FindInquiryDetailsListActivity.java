package com.wd.doctor.activity.inquiry;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.doctor.R;
import com.wd.doctor.R2;
import com.wd.doctor.adapter.MyRecViewInquiryDetailsListAdapter;
import com.wd.doctor.bean.FindInquiryDetailsListBean;
import com.wd.doctor.bean.PushMessageBean;
import com.wd.doctor.contract.Contract;
import com.wd.doctor.presenter.Presenter;
import com.wd.doctor.util.RsaCoder;
import com.wd.mvplibrary.app.Constant;
import com.wd.mvplibrary.base.BaseActivity;
import com.wd.mvplibrary.utils.Logger;
import com.wd.mvplibrary.utils.SPUtils;
import com.wd.mvplibrary.utils.ToastUtils;

import java.security.interfaces.RSAKey;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.content.TextContent;
import cn.jpush.im.android.api.event.MessageEvent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.Message;
import cn.jpush.im.android.api.options.MessageSendingOptions;
import cn.jpush.im.api.BasicCallback;

public class FindInquiryDetailsListActivity extends BaseActivity<Presenter> implements Contract.IView {

    public static final String TAG = "FindInquiryDetailsListActivity";
    @BindView(R2.id.xRec_view_details)
    XRecyclerView xRecViewDetails;
    @BindView(R2.id.tv_name_details)
    TextView tvNameDetails;
    @BindView(R2.id.et_content_details)
    EditText etContentDetails;
    @BindView(R2.id.img_expression)
    ImageView imgExpression;
    @BindView(R2.id.img_picture)
    ImageView imgPicture;
    @BindView(R2.id.img_send)
    ImageView imgSend;
    private String contentDetails;
    private String inquiryId;
    private String userId1;
    private String doctorId;
    private String sessionId;
    private String userName;
    private String jiGuangPwd;
    private String md5;
    private MyRecViewInquiryDetailsListAdapter myRecViewInquiryDetailsListAdapter;

    @Override
    protected Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_find_inquiry_details_list;
    }

    @Override
    protected void initData() {
        super.initData();
        JMessageClient.init(this);
        ToastUtils.init(this);
        Intent intent = getIntent();
        int RecordId = intent.getIntExtra("RecordId", 0);
        int userId = intent.getIntExtra("userId", 0);
        String name = intent.getStringExtra("name");
        tvNameDetails.setText(name);
        inquiryId = RecordId + "";
        userId1 = userId + "";
        Logger.e(TAG, inquiryId);
        Logger.e(TAG, userId1);
        SPUtils user = new SPUtils(this, "user");
        doctorId = (String) user.getSharedPreference("doctorId", "");
        sessionId = (String) user.getSharedPreference("sessionId", "");
        userName = (String) user.getSharedPreference("userName", "");
        jiGuangPwd = (String) user.getSharedPreference("jiGuangPwd", "");
        presenter.doFindInquiryDetailsList(doctorId, sessionId, inquiryId, "1", "10");
        JMessageClient.registerEventReceiver(this);
        etContentDetails.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                contentDetails = etContentDetails.getText().toString();
                if (contentDetails !=null) {
                    imgSend.setVisibility(View.VISIBLE);
                    imgPicture.setVisibility(View.GONE);
                }else {
                    imgSend.setVisibility(View.GONE);
                    imgPicture.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        try {
            jiGuangPwd = RsaCoder.decryptByPublicKey(jiGuangPwd);
            md5 = RsaCoder.MD5(jiGuangPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JMessageClient.login(userName, md5, new BasicCallback() {
            @Override
            public void gotResult(int i, String s) {
                ToastUtils.show(s+i);
                if (i==0) {
                    imgSend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String trim = etContentDetails.getText().toString();
                            Logger.e(TAG,"消息发送成功"+inquiryId);
                            Conversation conversation = Conversation.createSingleConversation ( userName, "b5f102cc307091e167ce52e0" );
                            Message message = conversation.createSendMessage ( new TextContent( trim ) );

                            message.setOnSendCompleteCallback ( new BasicCallback() {
                                @Override
                                public void gotResult(int i, String s) {
                                    if (i==0){
                                        ToastUtils.show("发送成功");
                                        presenter.doPushMessage(doctorId,sessionId,inquiryId,contentDetails, Constant.TYPE_ONE,userId1);
                                        etContentDetails.setText ( "" );
                                    }else {
                                        ToastUtils.show("发送失败");
                                    }
                                }
                            } );
                            MessageSendingOptions options = new MessageSendingOptions();
                            options.setRetainOffline(false);
                            JMessageClient.sendMessage(message);
                            myRecViewInquiryDetailsListAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }

    //接受消息的事件
    public void onEventMainThread(MessageEvent event) {
        Message msg = event.getMessage();
        switch (msg.getContentType()) {
            case text:
                // 处理文字消息
                TextContent textContent = (TextContent) msg.getContent();
                textContent.getText();
                presenter.doFindInquiryDetailsList(doctorId, sessionId, inquiryId, "1", "10");
                break;
        }
    }

    @Override
    public void onSuccess(Object obj) {
        FindInquiryDetailsListBean findInquiryDetailsListBean = (FindInquiryDetailsListBean) obj;
        Logger.e(TAG, findInquiryDetailsListBean.getMessage()+"findInquiryDetailsListBean");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xRecViewDetails.setLayoutManager(linearLayoutManager);
        List<FindInquiryDetailsListBean.ResultBean> result = findInquiryDetailsListBean.getResult();
        myRecViewInquiryDetailsListAdapter = new MyRecViewInquiryDetailsListAdapter(result, this);
        xRecViewDetails.setAdapter(myRecViewInquiryDetailsListAdapter);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
    }

    @Override
    public void onSuccessOne(Object one) {
        PushMessageBean pushMessageBean = (PushMessageBean) one;
        Logger.e(TAG,pushMessageBean.getMessage()+"pushMessageBean");
        if ("0000".equals(pushMessageBean.getStatus())) {
            presenter.doFindInquiryDetailsList(doctorId, sessionId, inquiryId, "1", "10");
        }
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

    @OnClick({R.id.img_back, R.id.img_voice_details, R.id.img_expression, R.id.img_picture})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_voice_details:
                break;
            case R.id.img_expression:

                break;
            case R.id.img_picture:

                break;
        }
    }
}
