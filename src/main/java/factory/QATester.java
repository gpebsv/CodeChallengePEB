package factory;

import factory.Employee;
import util.EmployeeTypeEnum;

public class QATester extends Employee<QATester> {


    public QATester(Class<QATester> clazz) {
        super(clazz);
    }

    public int getMonthlyCost(){
        return 1000;
    }

    public EmployeeTypeEnum getEmployeeType(){
        return EmployeeTypeEnum.QATESTER;
    }

}
