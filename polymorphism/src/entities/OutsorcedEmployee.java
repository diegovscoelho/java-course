package entities;

public class OutsorcedEmployee extends Employee {

    private Double additionalCharge;

    public OutsorcedEmployee() {
        super();
    }

    public OutsorcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public Double payment() {
        return super.payment() + (1.1 * additionalCharge);
    }
}
