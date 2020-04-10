package testProjectLab2.src.Service.XMLFileService;

import testProjectLab2.src.Domain.TemaLab;
import testProjectLab2.src.Exceptions.ValidatorException;
import testProjectLab2.src.Repository.XMLFileRepository.TemaLabXMLRepo;

public class TemaLabXMLService extends AbstractXMLService<Integer,TemaLab>{
    private TemaLabXMLRepo xmlrepo;

    public TemaLabXMLService(TemaLabXMLRepo xmlrepo)  {
        super(xmlrepo);
    }

    public void prelungireTemaLab(String nr,String descr,String sl,String sp,int sc) throws ValidatorException {
        if(sc<=Integer.parseInt(sp)){
            String sln=Integer.toString(Integer.parseInt(sl)+1) ;
            String[] params={nr,descr,sln,sp};
            update(params);
        }

    }
    @Override
    protected TemaLab extractEntity(String[] params){
        int id;
        try{
            id = Integer.parseInt(params[0]);
        }
        catch(NumberFormatException ex){
            id = -1;
        }
        return new TemaLab(id,params[1],Integer.parseInt(params[2]),Integer.parseInt(params[3]));
    }

}