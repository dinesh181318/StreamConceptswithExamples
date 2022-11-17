package learningStreamConcept.StreamMap;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    public Integer id;
    public String name;
    public Double salary;

    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
    public Double salaryincrement(Double increment) {
        return   salary * increment ;
    }


}


public class Main {
    public static void main(String[] args) {
        Integer[] empIds = {2,3};
        ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
        employeeArrayList.add(new Employee(1,"Dinesh",15000.00));
        employeeArrayList.add(new Employee(2,"Vijay",10000.00));
        employeeArrayList.add(new Employee(3,"Praveen",25000.00));
        employeeArrayList.add(new Employee(4,"Anish",55000.00));

        List<Double> employeeList = employeeArrayList.stream().map(employee -> employee.salary * 2).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        List<String> employeeList1 = employeeArrayList.stream().map(employee -> employee.name.toUpperCase()).collect(Collectors.toList());
        employeeList1.forEach(System.out::println);
        List<Employee> employeeList2 = employeeArrayList.stream().map(employee -> {
                if(employee.id.equals(empIds[1]) || employee.id.equals(empIds[0])){
                    return employee;
        }
                return null;
        }
        ).collect(Collectors.toList());
        employeeList2.forEach(System.out::println);

        DoubleSummaryStatistics stats = employeeArrayList.stream().mapToDouble((employee) -> employee.salary).summaryStatistics();
        System.out.println("highest Salary : "+stats.getMax());
        System.out.println("lowest salary : "+stats.getMin());
        System.out.println("Sum of all salary : "+stats.getSum());
        System.out.println("Average of all salary : "+stats.getAverage());
        System.out.println("how many getting salary : "+stats.getCount());






    }
}
