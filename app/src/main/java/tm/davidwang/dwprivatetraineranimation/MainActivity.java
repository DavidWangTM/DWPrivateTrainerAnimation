package tm.davidwang.dwprivatetraineranimation;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.nineoldandroids.animation.ObjectAnimator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RelativeLayout explore_re,arrow_re,mianview,down_re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findID();
        inData();
    }

    private void findID(){
        mianview = (RelativeLayout)findViewById(R.id.mianview);
//        mianview.setOnClickListener(this);
        down_re = (RelativeLayout)findViewById(R.id.down_re);

        explore_re = (RelativeLayout)findViewById(R.id.explore_re);
        explore_re.setOnClickListener(this);
        arrow_re = (RelativeLayout)findViewById(R.id.arrow_re);
    }

    private void inData(){
        ObjectAnimator.ofFloat(arrow_re, "translationY", 0, dip2px(85)).start();
        ObjectAnimator.ofFloat(explore_re, "scaleX", 1, 0).start();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                ObjectAnimator.ofFloat(arrow_re, "translationY",dip2px(85),0).setDuration(300).start();
            }
        }, 300);

    }

    private int dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.mianview:

                break;
            case R.id.explore_re:
                explore_re.setVisibility(View.VISIBLE);
                ObjectAnimator.ofFloat(arrow_re, "translationY",dip2px(85),0).setDuration(500).start();
                ObjectAnimator.ofFloat(explore_re, "scaleX", 0,1).start();

                break;
        }


    }
}
