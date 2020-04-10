package testProjectLab2.src.Domain;

public class TemaLab implements HasId<Integer> {
    private int nr;
    private String descriere;
    private int termenLimita;
   // private int saptamanaCurenta;
    private int saptamanaPredarii;
    public TemaLab(int nr,String descriere,int termenLimita,int saptamanaPredarii){
        this.setId(nr);
        this.setDescriere(descriere);
        this.setTermenLimita(termenLimita);
        //this.setSaptamanaCurenta(saptamanaCurenta);
        this.setSaptamanaPredarii(saptamanaPredarii);
    }
    @Override
    public Integer getId() {
        return nr;
    }
    @Override
    public void setId(Integer nr) {
        this.nr = nr;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public int getTermenLimita() {
        return termenLimita;
    }

    public void setTermenLimita(int termenLimita) {
        this.termenLimita = termenLimita;
    }

    public int getSaptamanaPredarii() {
        return saptamanaPredarii;
    }

    public void setSaptamanaPredarii(int saptamanaPredarii) {
        this.saptamanaPredarii = saptamanaPredarii;
    }
    @Override
    public String toString(){
        return this.nr+"#"+this.descriere+"#"+this.termenLimita+"#"+this.saptamanaPredarii;
    }

    //public int getSaptamanaCurenta() { return saptamanaCurenta; }

    //public void setSaptamanaCurenta(int saptamanaCurenta) {this.saptamanaCurenta = saptamanaCurenta;}
}
