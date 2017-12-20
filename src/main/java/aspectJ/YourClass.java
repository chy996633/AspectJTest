package aspectJ;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class YourClass extends Father<String>{

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
        YourClass yourClass = context.getBean("YourClass", YourClass.class);
        yourClass.yourMethodBefore();
        yourClass.yourMethodAfter();
        yourClass.yourMethodAround(1);
        yourClass.yourMethodAround(1,"Test");
        yourClass.shouldNotBeUsed();
        yourClass.printOutMethods();
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

    public void printOutMethods(){
        for (Method m :getClass().getDeclaredMethods()){
            System.out.println(m.getReturnType()+" "+ m.getName()+" "+ m.isBridge());
        }
        System.out.println(Arrays.toString(getClass().getDeclaredMethods()));
    }

    @Deprecated
    public void shouldNotBeUsed(){
        System.out.println("SHOULD NOT BE USED");
    }

    @Override
    String get() {
        return null;
    }

    @Override
    FileOutputStream getOutStream() {
        try {
            return new FileOutputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
