package first.test.a1217.utils;

public
interface InetCallBack<T> {
    void onSuccess(T t);
    void onFail(String err);
}
