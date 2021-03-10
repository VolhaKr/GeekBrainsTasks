package lesson7hw_annotations;

import java.lang.reflect.Method;

public class MethodWithPriority {
           private int priority;
        private Method method;

    public MethodWithPriority(int priority, Method method) {
        this.priority = priority;
        this.method = method;
    }

    public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

    }

