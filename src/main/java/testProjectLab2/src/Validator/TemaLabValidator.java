package testProjectLab2.src.Validator;

import testProjectLab2.src.Domain.TemaLab;
import testProjectLab2.src.Exceptions.ValidatorException;

public class TemaLabValidator implements IValidator<TemaLab> {

    public void validate(TemaLab t) throws ValidatorException {
        if(t.getId()== null || t.getId() == -1){
            throw new ValidatorException("Nr tema invalid\n");
        }else if(t.getDescriere()== null || t.getDescriere().equals("")) {
            throw new ValidatorException("Descriere tema invalida\n");
        }else if(t.getSaptammanaPredarii()<=0 || t.getSaptammanaPredarii()>14) {
            throw new ValidatorException("Saptamana predarii invalida\n");
        }else if(t.getTermenLimita()<=0 || t.getTermenLimita()>14) {
            throw new ValidatorException("Termen limita invalid\n");
        }
    }
}
