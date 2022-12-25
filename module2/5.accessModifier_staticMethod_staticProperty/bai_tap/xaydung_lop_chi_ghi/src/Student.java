public class Student {
    private String name="john";
    private String classes="C02";
    public String getName(){return name;}
    public String getClasses(){return classes;}
    protected void setName(String value){this.name=value;}
    void setClasses(String value){this.classes=value;}
    public Student(){}
    public void display(){
        System.out.println("Student{ name: "+this.getName()+" | class:"+this.getClasses()+" }");
    }

}
