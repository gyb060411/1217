package first.test.a1217.presenter;

import first.test.a1217.base.BasePresenter;
import first.test.a1217.bean.SchoolBean;
import first.test.a1217.contract.SchoolContract;
import first.test.a1217.model.MainModelImp;
import first.test.a1217.utils.InetCallBack;
import first.test.a1217.utils.URLConstart;

public
class SchoolPresenterImp extends BasePresenter<SchoolContract.MainView> implements SchoolContract.MainPersenter {
    private SchoolContract.MainView mainView;
 private SchoolContract.MainModel mainModel;

    public SchoolPresenterImp(SchoolContract.MainView mainView) {
        this.mainView = mainView;
     this.mainModel=new MainModelImp(this);
    }

    @Override
    public void par() {
        mainModel.getModel(URLConstart.School, new InetCallBack<SchoolBean>() {
            @Override
            public void onSuccess(SchoolBean schoolBean) {
                mainView.getSchool(schoolBean);
            }

            @Override
            public void onFail(String err) {
                mainView.onError(err);
            }
        });
    }
}
