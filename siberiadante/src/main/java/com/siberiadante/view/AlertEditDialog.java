package com.siberiadante.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siberiadante.R;

/**
 * Created by SiberiaDante on 2017/6/19.
 */

public class AlertEditDialog {
    private Context context;
    private Dialog dialog;
    private LinearLayout mLinear_layout;
    private TextView mTvTitle;
    private EditText mEdtContent;
    private Button btn_neg;
    private Button btn_pos;
    private ImageView img_line;
    private Display display;

    public AlertEditDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public AlertEditDialog builder() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_alert_edit, null);
        mLinear_layout = (LinearLayout) view.findViewById(R.id.linear_alert_dialog_bg);
        mTvTitle = (TextView) view.findViewById(R.id.tv_alert_dialog_title);
        mEdtContent = (EditText) view.findViewById(R.id.edt_alert_dialog_content);
        btn_neg = (Button) view.findViewById(R.id.btn_alert_dialog_cancel);
        btn_pos = (Button) view.findViewById(R.id.btn_alert_dialog_sure);
        img_line = (ImageView) view.findViewById(R.id.img_alert_dialog_line);
        dialog = new Dialog(context, R.style.ActionGeneralDialog);
        dialog.setContentView(view);
        mLinear_layout.setLayoutParams(new FrameLayout.LayoutParams((int) (display.getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));
        return this;
    }
    public AlertEditDialog setTitle(String title) {
        if ("".equals(title)) {
            mTvTitle.setText("标题");
        } else {
            mTvTitle.setText(title);
        }
        return this;
    }

    public String getMsg() {
        return mEdtContent.getText().toString();
    }

    public AlertEditDialog setCancelable(boolean cancelable) {
        dialog.setCancelable(cancelable);
        return this;
    }

    public AlertEditDialog setPositiveButton(String text, final View.OnClickListener listener) {
        if ("".equals(text)) {
            btn_pos.setText("确定");
        } else {
            btn_pos.setText(text);
        }
        btn_pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    public AlertEditDialog setNegativeButton(String text,
                                         final View.OnClickListener listener) {
        if ("".equals(text)) {
            btn_neg.setText("取消");
        } else {
            btn_neg.setText(text);
        }
        btn_neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }
    public void show() {
        dialog.show();
    }
}
