package factory;

import util.EmployeeTypeEnum;


public class Developer extends Employee<Developer> {


    public Developer(Class<Developer> clazz) {
        super(clazz);
    }

    public int getMonthlyCost(){
        return 2000;
    }

    public EmployeeTypeEnum getEmployeeType(){
        return EmployeeTypeEnum.DEVELOPER;
    }

}
