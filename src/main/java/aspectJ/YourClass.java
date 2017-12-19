package aspectJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class YourClass {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
        YourClass yourClass = context.getBean("YourClass", YourClass.class);
        yourClass.yourMethodBefore();
        yourClass.yourMethodAfter();
        yourClass.yourMethodAround(1);
        yourClass.yourMethodAround(1,"Test");
        yourClass.shouldNotBeUsed();
    }

    public void yourMethodBefore() {
        System.out.println("Executing TestTarget.yourMethodBefore()");
    }

    public void yourMethodAfter(){
        System.out.println("Executing TestTarget.yourMethodAfter()");
    }

    public void yourMethodAround(Integer i){
        System.out.println("Executing TestTarget.yourMethodAround()");
        System.out.println("i : "+i);
    }

    public void yourMethodAround(Integer i,String x){
        System.out.println("Executing TestTarget.yourMethodAround()");
        System.out.println("i : "+i);
        System.out.println("x : "+x);
    }

    @Deprecated
    public void shouldNotBeUsed(){
        System.out.println("SHOULD NOT BE USED");
    }

}
