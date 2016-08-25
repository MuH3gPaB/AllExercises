
public class MyClass {

    public void makeString(String str1, String str2){
        Object a = null;
        new MyClass().addStrings(str1, str2, a);
        System.out.println(a);
    }

    public void addStrings(String str1, String str2, Object result){
        result = str1 + str2;
    }
}
