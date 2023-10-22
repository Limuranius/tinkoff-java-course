package edu.hw2;

public class Task4 {
    private Task4() {
    }

    public static CallingInfo[] callingInfo(Throwable e) {
        var stktrace = e.getStackTrace();
        var info = new CallingInfo[stktrace.length];
        for (int i = 0; i < stktrace.length; i++) {
            info[i] = new CallingInfo(
                stktrace[i].getClassName(),
                stktrace[i].getMethodName()
            );
        }
        return info;
    }

    public record CallingInfo(String className, String methodName) {
    }
}
