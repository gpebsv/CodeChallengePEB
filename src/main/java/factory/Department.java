package factory;

import lombok.Data;
import util.EmployeeTypeEnum;
import util.EmptyEmployeeListException;

import java.util.ArrayList;
import java.util.List;

@Data
public class Department {
    List<Employee<Manager>> managerList = new ArrayList<>();

    private int getManagerMonthlyCost(Employee<Manager> manager){
        int cost = 0;
        List<Employee> list = manager.getAssignedEmployees();
        for (Employee e: list
             ) {
            if(e.getEmployeeType() == EmployeeTypeEnum.MANAGER && !e.getAssignedEmployees().isEmpty()){
                cost += getManagerMonthlyCost(e) + e.getMonthlyCost();
            } else {
                cost += e.getMonthlyCost();
            }
        }
        return cost;
    }

    public int getDepartmentMonthlyCost() throws EmptyEmployeeListException {
        int cost=0;
        if (this.managerList.isEmpty()) { throw new EmptyEmployeeListException("No Employees on Department");}
        for (Employee<Manager> m: this.managerList) {
            cost += this.getManagerMonthlyCost(m) + m.getMonthlyCost();
        }
        return cost;
    }

    public void addManager(Employee<Manager> manager){
        this.managerList.add(manager);
    }
}
