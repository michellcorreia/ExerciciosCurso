package entities;

public class NaturalPerson extends Person {

    private Double healthExpenses;


    public NaturalPerson(){
        super();
    }
    public NaturalPerson(String name, Double annualEarnings, Double healthExpenses){
        super(name, annualEarnings);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses(){
        return healthExpenses;
    }
    public void setHealthExpenses(Double healthExpenses){
        this.healthExpenses = healthExpenses;
    }

    @Override
    public Double taxes(){
        Double basicTax;
        if(super.getAnnualEarnings() < 20000.00){
            basicTax = (super.getAnnualEarnings()*0.15) - (healthExpenses*0.5);
        }
        else{
            basicTax = (super.getAnnualEarnings()*0.25) - (healthExpenses*0.5);
        }
        if(basicTax <0.0){
            basicTax = 0.0;
        }
        return basicTax;
    }
    
}
