public class person {
    public String name;
    public int age;
    public person(){}
    public person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}
