package com.github.pjfanning.java.exception;

public class ExceptionUtil {
    private ExceptionUtil() {}

    public static boolean isNonFatal(Throwable t) {
        return !(isFatal(t));
    }

    public static boolean isFatal(Throwable t) {
        //similar to https://www.scala-lang.org/api/2.13.8/scala/util/control/NonFatal$.html
        return (t instanceof VirtualMachineError || t instanceof ThreadDeath
                || t instanceof InterruptedException || t instanceof  LinkageError);
    }
}
