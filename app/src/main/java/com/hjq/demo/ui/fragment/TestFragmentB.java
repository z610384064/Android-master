package com.hjq.demo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hjq.demo.R;
import com.hjq.demo.base.MyLazyFragment;
import com.hjq.demo.bean.PhoneDto;
import com.hjq.demo.ui.adapter.ListViewAdapter;
import com.hjq.demo.utils.PhoneUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author : HJQ
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 项目自定义控件展示
 */
public class TestFragmentB extends MyLazyFragment implements View.OnClickListener {
    @BindView(R.id.listview)
    ListView listview;
    Unbinder unbinder;
    private List<PhoneDto> phoneDtos;
//    @BindView(R.id.cv_test_countdown)
//    CountdownView mCountdownView;
    private ArrayList<String> list;
    public static TestFragmentB newInstance() {
        return new TestFragmentB();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragmentb;
    }

    @Override
    protected int getTitleBarId() {
        return R.id.tb_test_b_title;
    }

    @Override
    protected void initView() {
//        mCountdownView.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        PhoneUtil phoneUtil = new PhoneUtil(mActivity);
        phoneDtos = phoneUtil.getPhone();

//        list=new ArrayList<>();
//        for (int i=0;i<30;i++){
//            list.add(i+"");
//        }
        ListViewAdapter listViewAdapter=new ListViewAdapter(phoneDtos,getFragmentActivity());
        listview.setAdapter(listViewAdapter);
    }

    /**
     * {@link View.OnClickListener}
     */
    @Override
    public void onClick(View v) {
//        if (v == mCountdownView) {
//            toast(getResources().getString(R.string.countdown_code_send_succeed));
//        }
    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}