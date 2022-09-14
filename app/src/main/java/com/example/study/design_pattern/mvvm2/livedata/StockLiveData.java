//package com.example.study.design_pattern.mvvm2.livedata;
//
//import androidx.annotation.MainThread;
//import androidx.lifecycle.LiveData;
//
//import java.math.BigDecimal;
//
///**
// * <pre>
// *     author : liaozh
// *     e-mail : xxx@xx
// *     time   : 2022/05/24
// *     desc   :
// *     version: 1.0
// * </pre>
// */
//public class StockLiveData extends LiveData<BigDecimal> {
//    private static StockLiveData sInstance; //单实例
//    private StockManager stockManager;
//
//    private SimplePriceListener listener = new SimplePriceListener() {
//        @Override
//        public void onPriceChanged(BigDecimal price) {
//            setValue(price);//监听到股价变化 使用setValue(price) 告知所有活跃观察者
//        }
//    };
//
//    //获取单例
//    @MainThread
//    public static StockLiveData get(String symbol) {
//        if (sInstance == null) {
//            sInstance = new StockLiveData(symbol);
//        }
//        return sInstance;
//    }
//
//    private StockLiveData(String symbol) {
//        stockManager = new StockManager(symbol);
//    }
//
//    //活跃的观察者（LifecycleOwner）数量从 0 变为 1 时调用
//    @Override
//    protected void onActive() {
//        stockManager.requestPriceUpdates(listener);//开始观察股价更新
//    }
//
//    //活跃的观察者（LifecycleOwner）数量从 1 变为 0 时调用。这不代表没有观察者了，可能是全都不活跃了。可以使用hasObservers()检查是否有观察者。
//    @Override
//    protected void onInactive() {
//        stockManager.removeUpdates(listener);//移除股价更新的观察
//    }
//}
