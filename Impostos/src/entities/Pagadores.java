package entities;

public abstract class Pagadores {

    private String name;
    private Double annualIncome;

    public Pagadores(String nome, Double rendaAnual) {
        this.name = nome;
        this.annualIncome = rendaAnual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public abstract Double calcImposto();

}
