package factory;

import util.EmployeeTypeEnum;

public class Manager extends Employee<Manager>{


    public Manager(Class<Manager> clazz) {
        super(clazz);
    }

    public int getMonthlyCost(){
        return 600;
    }

    public EmployeeTypeEnum getEmployeeType(){
        return EmployeeTypeEnum.MANAGER;
    }

}
