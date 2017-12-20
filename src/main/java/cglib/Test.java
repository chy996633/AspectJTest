package cglib;

import aspectJ.YourClass;

public class Test {

    public static void main(String[] args) {
        YourClass enhancedClass = YourClassProxyFactory.getAuthInstance();
        enhancedClass.yourMethodAround(1,"2");
        enhancedClass.yourMethodAround(2);
        enhancedClass.shouldNotBeUsed();
        System.out.println(enhancedClass.getClass());

    }

}
