package first.test.a1217.utils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public
class RetrofitUtils implements INetWorkInterface{
    private static RetrofitUtils retrofitUtils;
    private ApiService apiService;
    private RetrofitUtils(){
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstart.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }
    public static RetrofitUtils getInstance(){
        if(retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if(retrofitUtils == null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    @Override
    public <T> void get(String url, InetCallBack<T> callBack) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        String string = responseBody.string();
                        callBack.getClass()
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                })
    }
}
