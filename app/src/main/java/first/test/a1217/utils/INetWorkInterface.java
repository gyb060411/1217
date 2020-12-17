package first.test.a1217.utils;

public
interface INetWorkInterface {
    <T> void get(String url, InetCallBack<T> callBack);
}
