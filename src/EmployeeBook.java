public class EmployeeBook {

    private final Employee[] employees;
    private int count;

    public EmployeeBook(int size) {
        this.employees = new Employee[size];
    }

    public void addEmployee(Employee employee) {

        if (employee == null) {

            System.out.println("Значение сотрудника рано null!");
            return;
        }

        if (count == employees.length) {

            System.out.println("Нет места для добавления нового сотрудника!");
            return;

        }

        this.employees[count] = employee;
        count++;

    }

    public void removeEmployee(Employee employee) {

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employee.equals(this.employees[i])) {

                index = i;
                break;
            }

        }

        if (index == -1) {

            System.out.println("Данного сотрудника нет");
            return;

        }

        System.arraycopy(this.employees, index + 1, this.employees, index, count - 1 - index);
        count--;
    }

    public void printEmployees() {

        for (int i = 0; i < count; i++) {
            System.out.println(this.employees[i]);
        }

    }

    public void changeSalary(String firstName, String middleName, String lastName, double newSalary) {

        for (int i = 0; i < count; i++) {

            if (this.employees[i].getFirstName().equals(firstName) && this.employees[i].getMiddleName().equals(middleName)
                    && this.employees[i].getLastName().equals(lastName)) {

                this.employees[i].setSalary(newSalary);
                break;

            }

        }

    }

    public void changeDepartment(String firstName, String middleName, String lastName, int newDepartment) {

        for (int i = 0; i < count; i++) {

            if (this.employees[i].getFirstName().equals(firstName) && this.employees[i].getMiddleName().equals(middleName)
                    && this.employees[i].getLastName().equals(lastName)) {

                this.employees[i].setDepartment(newDepartment);
                break;

            }

        }

    }

    public void printEmployeesByDepartment() {

        for (int i = 1; i < 6; i++) {

            int index = 0;
            System.out.println("Сотрудники отдела номер: " + i);


            for (int j = 0; j < count; j++) {

                if (i == this.employees[j].getDepartment()) {

                    System.out.println("Ф.И.О: " + this.employees[j].getLastName() + " " + this.employees[j].getFirstName() +
                            " " + this.employees[j].getMiddleName());
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

        for (Employee employee : this.employees) {

            if (employee != null) {
                sum += employee.getSalary();
            }
        }

        System.out.println("Общая сумма зарплат равна: " + sum);

    }

    public void printMinSalaryEmployees() {

        double min = Double.MAX_VALUE;

        for (Employee employee : this.employees) {

            if (employee != null && employee.getSalary() < min) {
                min = employee.getSalary();
            }

        }

        for (Employee employee : this.employees) {

            if (employee != null && employee.getSalary() == min) {

                System.out.println("Сотрудник с минимальной зарплатой - " + employee);
                return;

            }

        }

    }

    public void printMaxSalaryEmployees() {

        double max = Double.MIN_VALUE;

        for (Employee employee : this.employees) {

            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
            }

        }

        for (Employee employee : this.employees) {

            if (employee != null && employee.getSalary() == max) {

                System.out.println("Сотрудник с максимальной зарплатой - " + employee);
                return;

            }

        }

    }

    public void printAverageSalaryEmployees() {

        double sum = 0;
        int count = 0;

        for (Employee employee : this.employees) {

            if (employee != null) {
                sum += employee.getSalary();
                count++;
            }

        }

        System.out.println("Средняя сумма зарплат равна: " + String.format("%.2f", sum / count));

    }

    public void printFioEmployees() {

        System.out.println("Список сотрудников по Ф.И.О: ");

        for (Employee employee : this.employees) {

            if (employee != null) {
                System.out.println(employee.getLastName() + " " + employee.getFirstName() + " "
                        + employee.getMiddleName());
            }

        }

    }

    public void salaryIndexationEmployees(int percent) {

        if (percent < -100) throw new IllegalArgumentException("Индексация меньше -100% не может быть произведена");

        for (int i = 0; i < 10; i++) {

            if (this.employees[i] != null) {
                this.employees[i].setSalary(this.employees[i].getSalary() + this.employees[i].getSalary() * percent / 100);
            }

        }

    }

    public void departmentMinSalaryEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        double min = Double.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < 10; i++) {

            if (this.employees[i] != null) {

                if (this.employees[i].getDepartment() == department && this.employees[i].getSalary() < min) {

                    min = this.employees[i].getSalary();
                    index = i;

                }

            }

        }

        System.out.println("В отделе номер: " + department + " сотрудник с минимальной зарплатой "
                + this.employees[index].getLastName() + " " + this.employees[index].getFirstName() +
                " " + this.employees[index].getMiddleName() + " " + "с зарплатой: " + this.employees[index].getSalary());

    }

    public void departmentMaxSalaryEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        double max = -1;
        int index = 0;

        for (int i = 0; i < 10; i++) {

            if (this.employees[i] != null) {

                if (this.employees[i].getDepartment() == department && this.employees[i].getSalary() > max) {

                    max = this.employees[i].getSalary();
                    index = i;

                }

            }

        }

        System.out.println("В отделе номер: " + department + " сотрудник с максимальной зарплатой "
                + this.employees[index].getLastName() + " " + this.employees[index].getFirstName() +
                " " + this.employees[index].getMiddleName() + " " + "с зарплатой: " + this.employees[index].getSalary());

    }

    public void departmentSumSalaryEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        double sum = 0;

        for (Employee employee : this.employees) {

            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }

        System.out.println("Общая сумма зарплат отдела номер: " + department + " равна: " + sum);

    }

    public void departmentAverageSalaryEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        int count = 0;
        double sum = 0;

        for (Employee employee : this.employees) {

            if (employee != null && employee.getDepartment() == department) {

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

        for (int i = 0; i < 10; i++) {

            if (this.employees[i] != null && this.employees[i].getDepartment() == department) {
                this.employees[i].setSalary(this.employees[i].getSalary() + this.employees[i].getSalary() * percent / 100);
            }

        }

    }

    public void printDepartmentEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        int count = 0;

        System.out.println("Сотруднки отдела номер: " + department);

        for (int i = 0; i < 10; i++) {

            if (this.employees[i] != null && this.employees[i].getDepartment() == department) {

                System.out.println("Ф.И.О: " + this.employees[i].getLastName() + " " + this.employees[i].getFirstName() + " "
                        + this.employees[i].getMiddleName() + ", ID: " + employees[i].getId() +
                        ", зарплата: " + this.employees[i].getSalary());
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

        for (Employee employee : this.employees) {

            if (employee != null && employee.getSalary() < salary) {

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

        for (Employee employee : this.employees) {

            if (employee != null && employee.getSalary() >= salary) {

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



