package learningStreamConcept.StreamFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    public Integer id;
    public String name;
    public Float salary;
    public String companyName;

    public Employee(Integer id, String name, Float salary, String companyName) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Float salaryincrement(Float increment) {
        return   salary * increment ;
    }


}

public class Main {

    public static void main(String[] args) {
        Integer[] empIds = {2, 4, 5};
        ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
        employeeArrayList.add(new Employee(1, "Dinesh", 15000.0f,"ABC"));
        employeeArrayList.add(new Employee(2, "Vijay", 10000.0f,"ABC"));
        employeeArrayList.add(new Employee(3, "Praveen", 25000.0f,"ABC"));
        employeeArrayList.add(new Employee(4, "Anish", 55000.0f,"ABC"));

        List<Employee> employeeList = employeeArrayList.stream().filter(employee -> {
            if (employee.id.equals(empIds[0]) || employee.id.equals(empIds[1])) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        employeeList.forEach(System.out::println);

        List<Employee> employeeList1 = employeeArrayList.stream().
                filter(employee -> employee.salary >= 20000.0f).collect(Collectors.toList());
        employeeList1.forEach(System.out::println);

        //incrementing the salary of particular employees
        System.out.println("Incrementing salary of particular employees");
        List<Employee> employeeList2 = employeeArrayList.stream().
                filter(employee -> employee.salary<= 20000.0f).map(employee ->{
                     employee.salary += 10000.0f;
                     return employee;
                })
                .collect(Collectors.toList());
        employeeList2.forEach(System.out::println);
        


    }
}