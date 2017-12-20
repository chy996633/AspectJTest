package cglib;

import aspectJ.YourClass;
import net.sf.cglib.proxy.Enhancer;

public class YourClassProxyFactory {

    public static YourClass getAuthInstance(){
        Enhancer en = new Enhancer();
        en.setSuperclass(YourClass.class);
        en.setCallback(new AroundAdvice());
        return (YourClass) en.create();
    }


}
