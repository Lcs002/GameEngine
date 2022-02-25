package utils;

import java.lang.reflect.Method;

public class Console {
    private static Console console;

    public static Console getInstance() {
        if (console == null)
            console = new Console();
        return console;
    }

    public void showMethodState(Class c, String methodName) {
        System.out.println("> " + c.getSimpleName() + " :: "+ methodName );
    }

    public void showMethodState(Class c, String methodName, METHOD_STATE state) {
        System.out.println("> " + c.getSimpleName() + " :: " + methodName + " :: "+ state );
    }

    public void showMethodState(Class c, String methodName, METHOD_STATE state, String details) {
        System.out.println("> " + c.getSimpleName() + " :: " + methodName + " :: "+ state + " :: " + details);
    }

    public enum METHOD_STATE {
        START,
        END,
        CREATED,
        ERROR
    }
}
