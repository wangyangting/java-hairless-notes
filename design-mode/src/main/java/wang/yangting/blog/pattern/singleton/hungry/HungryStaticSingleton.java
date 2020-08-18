package wang.yangting.blog.pattern.singleton.hungry;

/**
 * 饿汉式静态单例
 *
 * @author wangyangting
 * @date 2020-08-17
 * @blog http://blog.yangting.wang
 * @github https://github.com/wangyangting
 */
public class HungryStaticSingleton {

    private static final HungryStaticSingleton hungrySingleton;

    static {
        hungrySingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {

    }

    public static HungryStaticSingleton getInstance() {
        return hungrySingleton;
    }

}
