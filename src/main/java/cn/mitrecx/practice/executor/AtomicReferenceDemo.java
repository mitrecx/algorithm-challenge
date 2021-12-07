package cn.mitrecx.practice.executor;

import java.util.concurrent.atomic.AtomicReference;

/**
 * https://www.jianshu.com/p/e334f02dd664
 */
public class AtomicReferenceDemo {
    public static AtomicReference<Student> atomicStudentRef = new AtomicReference<Student>();

    public static void main(String[] args) {
        Student s1 = new Student(1, "Mitre");
        atomicStudentRef.set(s1);
        Student s2 = new Student(2, "Rosie");
        atomicStudentRef.compareAndSet(s1, s2);
        System.out.println(atomicStudentRef.get().toString());
    }

    static class Student {
        private int id;
        public String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Student{" + "id=" + id + ", name=" + name + "}";
        }
    }
}
