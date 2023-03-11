public class Main {

    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook(10);
        employeeBook.addEmployee(new Employee("Иван", "Андреевич", "Донченко", 1, 45_000));
        employeeBook.addEmployee(new Employee("Евгений", "Евгеньевич", "Бирюков", 1, 48_000));
        employeeBook.addEmployee(new Employee("Виктор", "Михайлович", "Угаров", 2, 54_000));
        employeeBook.addEmployee(new Employee("Галина", "Васильевна", "Логинова", 3, 63_000));
        Employee employee5 = new Employee("Ольга", "Викторовна", "Владимирова", 4, 38_000);
        employeeBook.addEmployee(employee5);
        employeeBook.addEmployee(new Employee("Роман", "Владиславович", "Рыбас", 5, 71_000));

        employeeBook.printEmployees();
        employeeBook.printSumSalaryEmployees();
        employeeBook.printMinSalaryEmployees();
        employeeBook.printMaxSalaryEmployees();
        employeeBook.printAverageSalaryEmployees();
        employeeBook.printFioEmployees();
        employeeBook.salaryIndexationEmployees(101);
        employeeBook.printEmployees();
        employeeBook.departmentMinSalaryEmployees(1);
        employeeBook.departmentMaxSalaryEmployees(1);
        employeeBook.departmentSumSalaryEmployees(1);
        employeeBook.departmentAverageSalaryEmployees(1);
        employeeBook.departmentIndexationSalaryEmployees(1, -50);
        employeeBook.printEmployees();
        employeeBook.printDepartmentEmployees(5);
        employeeBook.minSalaryEmployees(50000);
        employeeBook.maxSalaryEmployees(500000);


        System.out.println();

        employeeBook.printEmployees();
        employeeBook.removeEmployee(employee5);
        employeeBook.printEmployees();

        System.out.println();

        employeeBook.changeSalary("Евгений", "Евгеньевич", "Бирюков", 89_000);
        employeeBook.printEmployees();

        System.out.println();

        employeeBook.changeDepartment("Виктор", "Михайлович", "Угаров", 3);
        employeeBook.printEmployees();
        employeeBook.printEmployeesByDepartment();


    }

}

