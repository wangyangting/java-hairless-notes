package wang.yangting.blog.pattern.singleton.threadlocal;

/**
 * ThreadLocal 单例
 * 线程间的安全，跨线程不安全（伪线程安全）
 *
 * 可以使用 ThreadLocal 来实现多数据源动态切换
 *
 * @author wangyangting
 * @date 2020-08-17
 * @blog http://blog.yangting.wang
 * @github https://github.com/wangyangting
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }

    };

    private static ThreadLocalSingleton getInstance() {
        return threadLocalInstance.get();
    }

}
