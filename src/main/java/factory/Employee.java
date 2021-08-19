package factory;

import lombok.Data;
import util.EmployeeTypeEnum;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Employee<T> {


    private Class<T> clazz;

    public Employee(Class<T> clazz) {
        this.clazz = clazz;

    }

     double monthlyCost;
     List<Employee>assignedEmployees = new ArrayList<>();

    abstract int getMonthlyCost();
    abstract EmployeeTypeEnum getEmployeeType();

    public void assignEmployee(Employee employee){
        assignedEmployees.add(employee);
    }

}
