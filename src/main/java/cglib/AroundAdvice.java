package cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class AroundAdvice implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("Before yourMethodAround()");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("After yourMethodAround()");
        return result + " 方法结束";
    }
}
