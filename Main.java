package appl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }

    }
}