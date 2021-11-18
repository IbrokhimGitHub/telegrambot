package uz.pdp.FirstTask;

import uz.pdp.entity.RegisterForm;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Long, RegisterForm> map=new HashMap<>();
//        map.put(1l,new RegisterForm("1","2","4","5"));
//        map.put(2l,new RegisterForm("2","2","4","5"));
//        map.put(3l,new RegisterForm("3","2","4","5"));
//        map.put(4l,new RegisterForm("4","2","4","5"));

        RegisterForm registerForm = map.putIfAbsent(5l, new RegisterForm());


        System.out.println(registerForm);
    }
}
