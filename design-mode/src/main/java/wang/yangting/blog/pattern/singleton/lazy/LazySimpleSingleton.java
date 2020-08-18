package wang.yangting.blog.pattern.singleton.lazy;

/**
 * 懒汉式 synchronized 单例
 *
 * @author wangyangting
 * @date 2020-08-17
 * @blog http://blog.yangting.wang
 * @github https://github.com/wangyangting
 */
public class LazySimpleSingleton {

    private volatile static LazySimpleSingleton lazy = null;

    private LazySimpleSingleton() {

    }

    /**
     * JDK 1.6 之后优化了 synchronized 的性能，
     * 但是还是存在一定的性能问题，可能造成整个类被锁
     *
     * @return LazySimpleSingleton
     */
    public synchronized static LazySimpleSingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySimpleSingleton();

            // CPU 执行的时候回转换成 JVM 指令执行
            // 指令重排序的问题，volatile
            // 1. 分配内存给整个对象
            // 2. 初始化这个对象
            // 3. 将初始化号的对象和内存地址建立关联，赋值
            // 4. 用户初次访问
            //
            // 其中，步骤 2 和 3 可能会颠倒，简称重排序
            // 这时候就可以使用 volatile 关键字了
        }
        return lazy;
    }


}
