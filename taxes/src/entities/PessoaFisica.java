package entities;

public class PessoaFisica extends Pagadores {

    private Double heathExpenditures;

    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
        super(nome, rendaAnual);
        this.heathExpenditures = gastosSaude;
    }

    public Double getHeathExpenditures() {
        return heathExpenditures;
    }

    public void setHeathExpenditures(Double heathExpenditures) {
        this.heathExpenditures = heathExpenditures;
    }

    @Override
    public Double calcImposto() {
        if(getAnnualIncome() < 20000.00) {
            if(heathExpenditures > 0) {
                return getAnnualIncome() * 0.15 - (heathExpenditures * 0.5);
            } else {
                return getAnnualIncome() * 0.15;
            }
        } else {
            if(heathExpenditures > 0) {
                return getAnnualIncome() * 0.25 - (heathExpenditures * 0.5);
            } else {
                return getAnnualIncome() * 0.25;
            }
        }
    }
}
