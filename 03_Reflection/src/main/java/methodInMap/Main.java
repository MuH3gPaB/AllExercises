package methodInMap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class myClass = Class.forName("methodInMap.MyClass");
        Method[] methods = myClass.getDeclaredMethods();
        Map<String, Method> methodsMap = new HashMap<String, Method>();

        for(Method method : methods){
            methodsMap.put(method.getName(), method);
        }

        for(Entry entry: methodsMap.entrySet()){
            System.out.print("Name : " + entry.getKey());
            Method method = (Method) entry.getValue();
            System.out.println("   Value : " + method.invoke(myClass.newInstance(), null));
        }
    }
}
