package entities;

public abstract class Person {

    private String name;
    private Double annualEarnings;


    public Person(){
    }
    public Person(String name, Double annualEarnings){
        this.name = name;
        this.annualEarnings = annualEarnings;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Double getAnnualEarnings(){
        return annualEarnings;
    }
    public void setAnnualEarnings(Double annualEarnings){
        this.annualEarnings = annualEarnings;
    }

    public abstract Double taxes();
    
}
