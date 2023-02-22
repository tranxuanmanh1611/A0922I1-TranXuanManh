public class Countries {
    public int id;
    public String abbreviation;
    public String name;
    Countries(){}
    Countries(int id,String abbreviation,String name){
        this.id=id;
        this.abbreviation=abbreviation;
        this.name=name;
    }
    public String toStringToFile(){
        return Integer.toString(id)+","+abbreviation+","+name;
    }
}
