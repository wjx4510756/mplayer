package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.mymusicplayer.R;

import utils.StaticUtil;

/**
 * Created by wjx4510756 on 2017/6/6.
 */

public class OnOffFragment extends DialogFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.on_off, container);

        RadioButton on = (RadioButton) view.findViewById(R.id.on);
        RadioButton off = (RadioButton) view.findViewById(R.id.off);


        boolean lyc = StaticUtil.sharedPreferences.getBoolean("lyc", true);
        if (lyc) {
            on.setChecked(true);
        } else off.setChecked(true);


        on.setOnClickListener(this);
        off.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.on:
                StaticUtil.editor.putBoolean("lyc", true);
                StaticUtil.editor.commit();
                Toast.makeText(getActivity(), "显示歌词", Toast.LENGTH_SHORT).show();
                dismiss();
                break;
            case R.id.off:
                StaticUtil.editor.putBoolean("lyc", false);
                StaticUtil.editor.commit();
                Toast.makeText(getActivity(), "关闭歌词", Toast.LENGTH_SHORT).show();
                dismiss();
                break;
            default:
                break;
        }
    }
}
