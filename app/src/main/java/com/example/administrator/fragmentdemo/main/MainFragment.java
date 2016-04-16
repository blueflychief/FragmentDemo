package com.example.administrator.fragmentdemo.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.fragmentdemo.R;
import com.example.administrator.fragmentdemo.config.UrlConstants;
import com.example.administrator.fragmentdemo.utils.nohttp.CallServer;
import com.example.administrator.fragmentdemo.utils.nohttp.HttpListener;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.Request;
import com.yolanda.nohttp.Response;

import org.json.JSONObject;

public class MainFragment extends Fragment {

    public static final String TAG = MainFragment.class.getSimpleName();

    public static final String EXTRA_TEXT = "extra_text";

    private String mText;
    private TextView mTextView;

    public static Fragment newInstance(String text) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mText = getArguments().getString(EXTRA_TEXT);

    }

    private HttpListener<JSONObject> objectListener = new HttpListener<JSONObject>() {
        @Override
        public void onSucceed(int what, Response<JSONObject> response) {
            JSONObject jsonObject = response.get();
            if (0 == jsonObject.optInt("error", -1)) {
                StringBuilder builder = new StringBuilder(jsonObject.toString());
                builder.append("\n\n解析数据: \n\n请求方法: ").append(jsonObject.optString("method")).append("\n");
                builder.append("请求地址: ").append(jsonObject.optString("url")).append("\n");
                builder.append("响应数据: ").append(jsonObject.optString("data")).append("\n");
                builder.append("错误码: ").append(jsonObject.optInt("error"));
                mTextView.setText(builder.toString());
            }
        }

        @Override
        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
            mTextView.setText("请求失败" + exception.getMessage());
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = (TextView) view.findViewById(R.id.tvText);
        Request<JSONObject> request = NoHttp.createJsonObjectRequest(UrlConstants.URL_NOHTTP_JSONOBJECT);
        CallServer.getRequestInstance().add(getActivity(), 0, request, objectListener, true, true);
    }
}
