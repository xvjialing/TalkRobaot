package com.lytech.xjl.talkrobaot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.lytech.xjl.talkrobaot.bean.Message;
import com.lytech.xjl.talkrobaot.net.NetUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.tv_message)
    EditText tvMessage;
//    @BindView(R.id.rv_message)
//    RecyclerView rvMessage;
    @BindView(R.id.btn_send)
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();


    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
//        rvMessage.setLayoutManager(manager);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onViewClicked: ");
                NetUtils.getInstance()
                        .getNetService()
                        .talk(getText())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subject<Message>() {
                            @Override
                            public boolean hasObservers() {
                                return false;
                            }

                            @Override
                            public boolean hasThrowable() {
                                return false;
                            }

                            @Override
                            public boolean hasComplete() {
                                return false;
                            }

                            @Override
                            public Throwable getThrowable() {
                                return null;
                            }

                            @Override
                            protected void subscribeActual(Observer<? super Message> observer) {

                            }

                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Message message) {
                                Log.d(TAG, "onNext: "+message.getResult().getContent());
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });
    }

    public String getText() {
        return tvMessage.getText().toString().trim();
    }

    /**
     * 向recycler中添加消息
     *
     * @param message
     * @param tag     true为左边，false为右边
     */
    public void addMessage(String message, boolean tag) {

    }

}
