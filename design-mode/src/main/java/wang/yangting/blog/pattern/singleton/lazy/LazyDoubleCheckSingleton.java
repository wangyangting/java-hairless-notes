package wang.yangting.blog.pattern.singleton.lazy;

/**
 * 懒汉式 double check 单例
 *
 * @author wangyangting
 * @date 2020-08-17
 * @blog http://blog.yangting.wang
 * @github https://github.com/wangyangting
 */
public class LazyDoubleCheckSingleton {

    private static LazyDoubleCheckSingleton lazy = null;

    private LazyDoubleCheckSingleton() {

    }

    /**
     * JDK 1.6 之后优化了 synchronized 的性能，
     * 但是还是存在一定的性能问题，可能造成整个类被锁
     *
     * @return LazyDoubleCheckSingleton
     */
    public synchronized static LazyDoubleCheckSingleton getInstance() {
        if (lazy == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazy == null) {
                    lazy = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazy;
    }


}
