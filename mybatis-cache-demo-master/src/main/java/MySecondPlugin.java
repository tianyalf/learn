import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @createTime:2021/03/31 12:01
 * @author:luofeng30850
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "parameterize", args = java.sql.Statement.class)})
public class MySecondPlugin implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MySecondPlugin...intercept:" + invocation.getMethod());
        Object proceed = invocation.proceed();
        System.out.println(proceed);
        return proceed;
    }

    public Object plugin(Object target) {
        System.out.println("MySecondPlugin...pugin:mybatis将要包装的对象" + target);
        Object wrap = Plugin.wrap(target, this);
        return wrap;
    }

    public void setProperties(Properties properties) {
        System.out.println("MySecondPlugin...插件配置信息:" + properties);
    }
}
