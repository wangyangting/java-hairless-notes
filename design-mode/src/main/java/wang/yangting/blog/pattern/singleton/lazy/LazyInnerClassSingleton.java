package wang.yangting.blog.pattern.singleton.lazy;

/**
 * 懒汉式静态类单例
 * 全程没有用到 synchronized 关键字
 * 性能最优的
 *
 * @author wangyangting
 * @date 2020-08-17
 * @blog http://blog.yangting.wang
 * @github https://github.com/wangyangting
 */
public class LazyInnerClassSingleton {

    /**
     * 虽然构造方法被私有了，但是还是可以被反射攻击
     */
    private LazyInnerClassSingleton() {
        if (LazyHolder.LAZY != null) {
            throw new RuntimeException("不允许构建多个实例");
        }
    }

    /**
     * 懒汉式单例
     *
     * LazyHolder 里面的逻辑需要等到外部方法调用时才执行，
     * 巧妙利用了内部类的特性，
     * JVM 底层执行逻辑，完美地避免了线程的安全问题
     *
     * @return
     */
    public static LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY;
    }

    private static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }

}
