package kr.melted.devand;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

/**
 * Created by Envy on 2015-12-20.
 */
public class RequestDialog extends DialogFragment {


    private String s1, s2;

    private View rootView;

    public RequestDialog(String target, String host) {
        s1 = target;
        s2 = host;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle("연락처 요청")
                .setMessage(s1 + "님이 회원님의\n연락처를 요청하셨습니다. 수락할까요?")
                .setNegativeButton("거절", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("수락", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }
}
