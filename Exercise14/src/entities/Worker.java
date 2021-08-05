package entities;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import entities.enums.WorkerLevel;

public class Worker {

	private Department department;		 						
	private List<HourContract> contracts = new ArrayList<>();
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	
	public Worker() {	
	}
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public Double getBaseSalary() {
		return baseSalary;
	}
	public List<HourContract> getContracts(){
		return contracts;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);							// <-- Adicionar� o contrato passado como argumento.
	}
	public void removeContract(HourContract contract) {
		contracts.remove(contract);							// <-- Remover� o contrato passado como argumento.
	}
	
	public Double income(Date dateChoice) {
		Double sum = baseSalary;
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		for(int i=0; i<getContracts().size(); i++) {
			cal1.setTime(getContracts().get(i).getDate());
			cal2.setTime(dateChoice);
			if(Objects.equals(cal1.get(Calendar.MONTH), cal2.get(Calendar.MONTH)) &&  Objects.equals(cal1.get(Calendar.YEAR), cal2.get(Calendar.YEAR))) {
				sum += getContracts().get(i).totalValue();
			}
		}
		return sum;
	}
		
	public String toString(Date dateChoice) {
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
		return String.format("Name: %s%nDepartment: %s%nIncome for %s: R$ %.2f", getName(), getDepartment().getName(), sdf2.format(dateChoice), income(dateChoice));
	}
		
	
	
}
