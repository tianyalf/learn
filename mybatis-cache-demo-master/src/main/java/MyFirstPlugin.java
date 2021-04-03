import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @createTime:2021/03/30 23:14
 * @author:luofeng30850
 * @description: 插件编写：
 * 1、编写Interceptor的实现类
 * 2、使用@Intercepts注解完成插件签名
 * 3、将写好的插件注册到全局配置文件中
 */

/**
 * 完成插件签名：告诉mybatis当前插件用来拦截哪个对象的哪个方法
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "parameterize", args = java.sql.Statement.class)})
public class MyFirstPlugin implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MyFirstPlugin...intercept:" + invocation.getMethod());
        //执行目标方法
        Object proceed = invocation.proceed();
        return proceed;
    }

    /**
     * pugin:包装目标对象，即为目标对象创建一个代理对象
     *
     * @param target
     * @return
     */
    public Object plugin(Object target) {
        System.out.println("MyFirstPlugin...pugin:mybatis将要包装的对象" + target);
        //可以借助Plugin的wrap方法来使用当前Interceptor包装我们的目标对象
        Object wrap = Plugin.wrap(target, this);
        //返回为当前target创建的代理对象
        return wrap;
    }

    /**
     * 将插件注册时的property属性设置进来
     *
     * @param properties
     */
    public void setProperties(Properties properties) {
        System.out.println("MyFirstPlugin...插件配置的信息：" + properties);
    }
}
