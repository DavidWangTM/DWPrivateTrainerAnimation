package tm.davidwang.dwprivatetraineranimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RelativeLayout explore_re,arrow_re,mianview,down_re;
    final int duration = 400;
    private ImageView card0,card1,card2,card3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findID();
        inData();
    }

    private void findID(){
        mianview = (RelativeLayout)findViewById(R.id.mianview);
        down_re = (RelativeLayout)findViewById(R.id.down_re);
        explore_re = (RelativeLayout)findViewById(R.id.explore_re);
        arrow_re = (RelativeLayout)findViewById(R.id.arrow_re);
        mianview.setOnClickListener(this);

        card0 = (ImageView)findViewById(R.id.card0);
        card1 = (ImageView)findViewById(R.id.card1);
        card2 = (ImageView)findViewById(R.id.card2);
        card3 = (ImageView)findViewById(R.id.card3);
    }

    private void inData(){
        ObjectAnimator.ofFloat(arrow_re, "translationY", 0, dip2px(85)).start();
        ObjectAnimator.ofFloat(explore_re, "scaleX", 1, 0).start();
        ObjectAnimator.ofFloat(card0, "translationX", 0, dip2px(430)).start();
        ObjectAnimator.ofFloat(card1, "translationX", 0, dip2px(450)).start();
        ObjectAnimator.ofFloat(card2, "translationX", 0, dip2px(470)).start();
        ObjectAnimator.ofFloat(card3, "translationX", 0, dip2px(490)).start();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Bottom();
                Top();
            }
        }, 1000);

    }

    private void Top(){
        ObjectAnimator.ofFloat(card0, "translationX", dip2px(430), 0).setDuration(duration*2 - 400).start();
        ObjectAnimator.ofFloat(card1, "translationX", dip2px(450), 0).setDuration(duration*2 - 300).start();
        ObjectAnimator.ofFloat(card2, "translationX", dip2px(470), 0).setDuration(duration*2 - 200).start();
        ObjectAnimator.ofFloat(card3, "translationX", dip2px(490), 0).setDuration(duration*2 - 100).start();
    }

    private void Bottom(){
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(arrow_re, "translationY", dip2px(85), 0)
        );
        set.setDuration(duration).start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                BottomOpen();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void BottomOpen(){
        explore_re.setVisibility(View.VISIBLE);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(arrow_re, "scaleX",1,0.6f),
                ObjectAnimator.ofFloat(arrow_re, "scaleY",1,0.6f),
                ObjectAnimator.ofFloat(explore_re, "scaleX", 0,1),
                ObjectAnimator.ofFloat(arrow_re, "translationX", 0,dip2px(83))
        );
        set.setDuration(duration).start();
    }

    private int dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.mianview:
                Bottom();
                Top();
                break;
        }


    }
}
