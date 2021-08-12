package entities;

public class LegalPerson extends Person{

    private Integer employeeQuantity;


    public LegalPerson(){
        super();
    }
    public LegalPerson(String name, Double annualEarnings, Integer employeeQuantity){
        super(name, annualEarnings);
        this.employeeQuantity = employeeQuantity;
    }

    public Integer getEmployeeQuantity(){
        return employeeQuantity;
    }
    public void setEmployeeQuantity(Integer employeeQuantity){
        this.employeeQuantity = employeeQuantity;
    }

    @Override
    public Double taxes(){
        Double basicTax;
        if(employeeQuantity <= 10){
            basicTax = (super.getAnnualEarnings()*0.16);
        }
        else{
            basicTax = (super.getAnnualEarnings()*0.14);
        }
        if(basicTax <0.0){
            basicTax = 0.0;
        }
        return basicTax;
    }
    
}
