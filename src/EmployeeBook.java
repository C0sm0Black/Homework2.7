import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {


    private final Map<String, Employee> employees;

    public EmployeeBook() {
        this.employees = new HashMap<>();
    }

    public void addEmployee(Employee employee) {

        String s = employee.getFirstName() + employee.getMiddleName() + employee.getLastName();


        if (employees.containsKey(s)) {

            System.out.println("Такой сотрудник уже есть");
            return;
        }

        employees.put(s, employee);

    }

    public void removeEmployee(Employee employee) {

        String s = employee.getFirstName() + employee.getMiddleName() + employee.getLastName();

        if (employees.containsKey(s)) {

            employees.remove(s);
            return;
        }

        System.out.println("Такого сотрудника нет!");

    }

    public void printEmployees() {

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {
            System.out.println(pair.getValue().toString());
        }

    }

    public void changeSalary(String firstName, String middleName, String lastName, double newSalary) {

        String s = firstName + middleName + lastName;

        if (employees.containsKey(s)) {

            Employee employee = employees.get(s);
            employee.setSalary(newSalary);
            employees.put(s, employee);
            return;

        }

        System.out.println("Такого сотрудника нет!");

    }

    public void changeDepartment(String firstName, String middleName, String lastName, int newDepartment) {

        String s = firstName + middleName + lastName;

        if (employees.containsKey(s)) {

            Employee employee = employees.get(s);
            employee.setDepartment(newDepartment);
            employees.put(s, employee);
            return;

        }

        System.out.println("Такого сотрудника нет!");

    }

    public void printEmployeesByDepartment() {

        for (int i = 1; i < 6; i++) {

            int index = 0;
            System.out.println("Сотрудники отдела номер: " + i);


            for (Map.Entry<String, Employee> pair : employees.entrySet()) {

                Employee employee = pair.getValue();

                if (i == employee.getDepartment()) {

                    System.out.println("Ф.И.О: " + employee.getLastName() + " " + employee.getFirstName() +
                            " " + employee.getMiddleName());
                    index++;

                }

            }

            if (index == 0) {
                System.out.println("В данном отделе нет сотрудниуов");
            }

        }

    }


    public void printSumSalaryEmployees() {

        double sum = 0;

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();
            sum += employee.getSalary();

        }

        System.out.println("Общая сумма зарплат равна: " + sum);

    }

    public void printMinSalaryEmployees() {

        double min = Double.MAX_VALUE;

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();

            if (employee.getSalary() < min) {
                min = employee.getSalary();
            }

        }

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();

            if (employee != null && employee.getSalary() == min) {

                System.out.println("Сотрудник с минимальной зарплатой - " + employee);
                return;

            }

        }

    }

    public void printMaxSalaryEmployees() {

        double max = Double.MIN_VALUE;

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();

            if (employee.getSalary() > max) {
                max = employee.getSalary();
            }

        }

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();

            if (employee.getSalary() == max) {

                System.out.println("Сотрудник с максимальной зарплатой - " + employee);
                return;

            }

        }

    }

    public void printAverageSalaryEmployees() {

        double sum = 0;
        int count = 0;

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();
            sum += employee.getSalary();
            count++;

        }

        System.out.println("Средняя сумма зарплат равна: " + String.format("%.2f", sum / count));

    }

    public void printFioEmployees() {

        System.out.println("Список сотрудников по Ф.И.О: ");

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();
            System.out.println(employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName());

        }

    }

    public void salaryIndexationEmployees(int percent) {

        if (percent < -100) throw new IllegalArgumentException("Индексация меньше -100% не может быть произведена");

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();
            employee.setSalary(employee.getSalary() + employee.getSalary() * percent / 100);
            employees.put(employee.getFirstName() + employee.getMiddleName() + employee.getLastName(), employee);

        }

    }

    public void departmentMinSalaryEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        double min = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();

            if (employee.getDepartment() == department && employee.getSalary() < min) {

                min = employee.getSalary();
                minSalaryEmployee = employee;

            }

        }

        System.out.println("В отделе номер: " + department + " сотрудник с минимальной зарплатой "
                + minSalaryEmployee.getLastName() + " " + minSalaryEmployee.getFirstName() +
                " " + minSalaryEmployee.getMiddleName() + " " + "с зарплатой: " + minSalaryEmployee.getSalary());

    }

    public void departmentMaxSalaryEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        double max = -1;
        Employee maxSalaryEmployee = null;

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();

            if (employee.getDepartment() == department && employee.getSalary() > max) {

                max = employee.getSalary();
                maxSalaryEmployee = employee;

            }

        }

        System.out.println("В отделе номер: " + department + " сотрудник с максимальной зарплатой "
                + maxSalaryEmployee.getLastName() + " " + maxSalaryEmployee.getFirstName() +
                " " + maxSalaryEmployee.getMiddleName() + " " + "с зарплатой: " + maxSalaryEmployee.getSalary());

    }

    public void departmentSumSalaryEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        double sum = 0;

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();

            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }

        }

        System.out.println("Общая сумма зарплат отдела номер: " + department + " равна: " + sum);

    }

    public void departmentAverageSalaryEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        int count = 0;
        double sum = 0;

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();

            if (employee.getDepartment() == department) {

                sum += employee.getSalary();
                count++;

            }

        }

        System.out.println("Средняя сумма зарплат отдела номер: " + department + " равна: "
                + String.format("%.2f", sum / count));

    }

    public void departmentIndexationSalaryEmployees(int department, int percent) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");
        if (percent < -100) throw new IllegalArgumentException("Индексация меньше -100% не может быть произведена");

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();

            if (employee.getDepartment() == department) {

                employee.setSalary(employee.getSalary() + employee.getSalary() * percent / 100);
                employees.put(employee.getFirstName() + employee.getMiddleName() + employee.getLastName(), employee);

            }

        }

    }

    public void printDepartmentEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        int count = 0;

        System.out.println("Сотруднки отдела номер: " + department);

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();

            if (employee.getDepartment() == department) {

                System.out.println("Ф.И.О: " + employee.getLastName() + " " + employee.getFirstName() + " "
                        + employee.getMiddleName() + ", ID: " + employee.getId() +
                        ", зарплата: " + employee.getSalary());
                count++;

            }

        }

        if (count == 0) {
            System.out.println("Сотрудники в отделе отсуствуют");
        }

    }

    public void minSalaryEmployees(int salary) {

        if (salary < 0) throw new IllegalArgumentException("Значение зарплаты должна быть не меньше нуля!");

        int count = 0;

        System.out.println("Сотрудники с зарплатой меньше " + salary + ":");

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();

            if (employee.getSalary() < salary) {

                System.out.println("ID: " + employee.getId() + ", Ф.И.О: " + employee.getLastName() +
                        " " + employee.getFirstName() + " " + employee.getMiddleName() + ", зарплата: " + employee.getSalary());
                count++;

            }

        }

        if (count == 0) {
            System.out.println("Такие сотрудники отсуствуют");
        }

    }

    public void maxSalaryEmployees(int salary) {

        if (salary < 0) throw new IllegalArgumentException("Значение зарплаты должна быть не меньше нуля!");

        int count = 0;

        System.out.println("Сотрудники с зарплатой больше либо равной " + salary + ":");

        for (Map.Entry<String, Employee> pair : employees.entrySet()) {

            Employee employee = pair.getValue();

            if (employee.getSalary() >= salary) {

                System.out.println("ID: " + employee.getId() + ", Ф.И.О: " + employee.getLastName() +
                        " " + employee.getFirstName() + " " + employee.getMiddleName() + ", зарплата: " + employee.getSalary());
                count++;

            }

        }

        if (count == 0) {
            System.out.println("Такие сотрудники отсуствуют");
        }

    }

}
