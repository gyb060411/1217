package first.test.a1217.contract;

import first.test.a1217.base.BaseView;
import first.test.a1217.bean.SchoolBean;
import first.test.a1217.utils.InetCallBack;

public
class SchoolContract {
    public interface MainView extends BaseView{
        void getSchool(SchoolBean schoolBean);
        void onError(String error);
    }
    public  interface MainModel{
        <T>void getModel(String url, InetCallBack<T> callBack);
    }
    public interface MainPersenter{
        void par();
    }
}
