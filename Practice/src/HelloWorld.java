public class HelloWorld {
    public static void main(String[] args) {
        Student firstStudent = new Student("Tom");
        Student secondStudent = new Student("Jerry");
        Student thirdStudent = null;
        firstStudent.setAge(18);
        secondStudent.setAge(10);
        firstStudent.sayHello();
        secondStudent.sayHello();
        Student fourthStudent = null;
        try{
            thirdStudent.sayHello();
        } catch (NullPointerException e) {
            System.out.println("Expected error occured! -" + e.toString());
        }
    }
}
