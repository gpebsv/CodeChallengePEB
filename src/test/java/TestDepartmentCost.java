import factory.*;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.EmptyEmployeeListException;

import static org.junit.jupiter.api.Assertions.fail;

@Log
public final class TestDepartmentCost {

    Department department = new Department();

@BeforeEach
public void initiate(){
    Employee<Developer> developerEmployee1 = new Developer(Developer.class);
    Employee<Developer> developerEmployee2 = new Developer(Developer.class);
    Employee<Developer> developerEmployee3 = new Developer(Developer.class);

    Employee<QATester> qaTesterEmployee1 = new QATester(QATester.class);
    Employee<QATester> qaTesterEmployee2 = new QATester(QATester.class);

    Employee<Manager> managerEmployeeA = new Manager(Manager.class);
    Employee<Manager> managerEmployeeB = new Manager(Manager.class);
    Employee<Manager> managerEmployeeC = new Manager(Manager.class);
    Employee<Manager> managerEmployeeD = new Manager(Manager.class);
    Employee<Manager> managerEmployeeE = new Manager(Manager.class);
    //3000

    managerEmployeeB.assignEmployee(developerEmployee1);
    managerEmployeeB.assignEmployee(qaTesterEmployee1);

    managerEmployeeA.assignEmployee(managerEmployeeB);

    managerEmployeeC.assignEmployee(managerEmployeeD);
    managerEmployeeC.assignEmployee(developerEmployee3);

    managerEmployeeE.assignEmployee(developerEmployee2);
    managerEmployeeE.assignEmployee(qaTesterEmployee2);


    department.addManager(managerEmployeeA);
    department.addManager(managerEmployeeC);
    department.addManager(managerEmployeeE);
    log.info("Data Initialized");
}

    @DisplayName("Monthly cost 11000, two levels")
    @Test
     void test1MonthlyCostCase11000(){
        int cost = 0;
        try {
            cost = department.getDepartmentMonthlyCost();
        } catch ( EmptyEmployeeListException e){
            log.info("Empty Employee List");
            fail("Should not have thrown any exception");
        }
        assert(cost>0);
        log.info("Cost of Department > 0");
        assert(cost==11000);
        log.info("Cost of Department: ".concat(String.valueOf(cost)));
    }

    @DisplayName("Monthly Cost 14800, three levels")
    @Test
    void test2MonthlyCost14800(){
        int cost = 0;
        Employee<Developer> developerEmployee4 = new Developer(Developer.class);
        Employee<Manager> managerEmployeeF = new Manager(Manager.class);
        Employee<Manager> managerEmployeeG = new Manager(Manager.class);
        Employee<Manager> managerEmployeeH = new Manager(Manager.class);
        managerEmployeeH.assignEmployee(developerEmployee4);
        managerEmployeeG.assignEmployee(managerEmployeeH);
        managerEmployeeF.assignEmployee(managerEmployeeG);
        department.addManager(managerEmployeeF);
        try {
            cost = department.getDepartmentMonthlyCost();
        } catch (EmptyEmployeeListException e){
            log.info("Empty Employee List");
            fail("Should not have thrown any exception");
        }
        assert(cost>0);
        log.info("Cost of Department > 0");
        assert (cost>11000);
        log.info("Cost of Department > 11000, greater than cost on test1");
        assert(cost==14800);
        log.info("Cost of Department: ".concat(String.valueOf(cost)));
    }

}
