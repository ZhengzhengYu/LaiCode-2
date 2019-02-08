public class Student {
    public int age;
    private final String name;
    private static String school;
    private static final String GREETINGS = "Hello";

    public Student(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void sayHello() {
        System.out.println(GREETINGS + "! I am " + name + ". I am " + age);
    }
}
