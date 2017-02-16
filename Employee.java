package appl;
/**
 * Created by User on 16.02.2017.
 */
public class Employee {
    private String employee_name;
    private int foods;
    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getFoods() {
        return foods;
    }

    public void setFoods(int foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Работник: " + this.employee_name + " Состав заказа = " + this.foods;
    }
}

