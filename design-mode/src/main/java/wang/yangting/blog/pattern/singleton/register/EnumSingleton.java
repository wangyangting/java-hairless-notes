package wang.yangting.blog.pattern.singleton.register;

/**
 * 枚举式单例
 * 从 JDK 层面就为枚举不被序列化和反射破坏来保驾护航
 *
 * @author wangyangting
 * @date 2020-08-17
 * @blog http://blog.yangting.wang
 * @github https://github.com/wangyangting
 */
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 这一段代码，会编译成 饿汉式静态单例 模式，
     * 所以是线程安全的，
     * 但是还有枚举本身的 JDK 层面来保护序列化破坏不了单例
     *
     * @return EnumSingleton
     */
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

}
