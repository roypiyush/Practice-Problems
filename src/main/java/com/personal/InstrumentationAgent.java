package com.personal;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.util.LinkedList;

/**
 * THIS CLASS IS NOT READY YET.
 * TO USE specify
 * -javaagent:<location to jar>
 *
 */
public class InstrumentationAgent {
    private static volatile Instrumentation globalInstrumentation;

    public static void premain(final String agentArgs, final Instrumentation inst) {
        globalInstrumentation = inst;
    }

    public static long getObjectSize(final Object object) {
        if (globalInstrumentation == null) {
            throw new IllegalStateException("Agent not initialized.");
        }
        return globalInstrumentation.getObjectSize(object);
    }

    public static long getDeepObjectSize(final Object object) {
        long sum = 0;
        LinkedList linkedList = new LinkedList();
        linkedList.add(object);

        while (!linkedList.isEmpty()) {
            Object first = linkedList.removeFirst();
            if (first == null) {
                continue;
            }
            Field[] fields = first.getClass().getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
                Class<?> type = f.getType();
                Object child = null;
                try {
                    child = f.get(first);
                } catch (Exception e) {
                    return sum;
                }
                if (child == null) {
                    continue;
                } else if (type.getSimpleName().contains("String")) {
                    sum += InstrumentationAgent.getObjectSize(child);
                } else if (type.getSimpleName().contains("int")) {
                    sum += InstrumentationAgent.getObjectSize(child);
                } else if (type.getSimpleName().contains("long")) {
                    sum += InstrumentationAgent.getObjectSize(child);
                } else if (type.getSimpleName().contains("double")) {
                    sum += InstrumentationAgent.getObjectSize(child);
                } else if (type.getSimpleName().contains("float")) {
                    sum += InstrumentationAgent.getObjectSize(child);
                } else if (type.getSimpleName().contains("short")) {
                    sum += InstrumentationAgent.getObjectSize(child);
                } else if (type.getSimpleName().contains("byte")) {
                    sum += InstrumentationAgent.getObjectSize(child);
                } else if (type.getSimpleName().contains("char")) {
                    sum += InstrumentationAgent.getObjectSize(child);
                } else if (type.getSimpleName().contains("boolean")) {
                    sum += InstrumentationAgent.getObjectSize(child);
                } else {
                    linkedList.add(child);
                }
            }
        }
        return sum;
    }
}