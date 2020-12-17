package first.test.a1217.base;

import android.util.Log;

public
class BasePresenter <V extends BaseView>{
    public V iView;
    public void attachView(V v){
        iView=v;
        Log.e("TAG", "attachView: 信息"+v.toString() );
    }
}
