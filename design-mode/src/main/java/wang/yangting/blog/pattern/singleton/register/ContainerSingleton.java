package wang.yangting.blog.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器式单例
 * Spring 中经常这样用
 *
 * @author wangyangting
 * @date 2020-08-17
 * @blog http://blog.yangting.wang
 * @github https://github.com/wangyangting
 */
public class ContainerSingleton {
    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    private ContainerSingleton() {

    }

    private static Object getBean(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 线程不安全的
        // ConcurrentHashMap 只是它内部安全
        // 但是这个方法不是线程安全的
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = Class.forName(className).newInstance();
                ioc.put(className, obj);
            }
        }
        return ioc.get(className);
    }
}
