package first.test.a1217.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public
abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
        public P persenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayouID());
        if(persenter==null){
            persenter=getPersenter();
            persenter.attachView(this);
            Log.e("TAG", "onCreate: 信息"+this.toString() );
        }
        initView();
        initData();

    }

    protected abstract int getLayouID();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P getPersenter();
}
