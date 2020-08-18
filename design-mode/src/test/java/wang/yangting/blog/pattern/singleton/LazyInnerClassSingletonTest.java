package wang.yangting.blog.pattern.singleton;

import wang.yangting.blog.pattern.singleton.lazy.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;

public class LazyInnerClassSingletonTest {

    public static void main(String[] args) throws Exception {
        // 调用者装B，自己 new 了一个，不走寻常路
        Class<?> clazz = LazyInnerClassSingleton.class;
        Constructor<?> c = clazz.getDeclaredConstructor((Class<?>) null);
        c.setAccessible(true);
        Object o1 = c.newInstance();

        // 正常构建实例
        Object o2 = LazyInnerClassSingleton.getInstance();

        System.out.println(o1 == o2);
    }

}
