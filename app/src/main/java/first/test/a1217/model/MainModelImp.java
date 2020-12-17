package first.test.a1217.model;

import first.test.a1217.contract.SchoolContract;
import first.test.a1217.presenter.SchoolPresenterImp;
import first.test.a1217.utils.InetCallBack;
import first.test.a1217.utils.RetrofitUtils;

public
class MainModelImp implements SchoolContract.MainModel {
    private SchoolContract.MainPersenter persenter;

    public MainModelImp(SchoolContract.MainPersenter persenter) {
        this.persenter = persenter;
    }

    @Override
    public <T> void getModel(String url, InetCallBack<T> callBack) {
        RetrofitUtils.getInstance().get(url,callBack);
    }
}
