package testProjectLab2.src.Service.TxtFileService;
import testProjectLab2.src.Domain.*;
import testProjectLab2.src.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer,Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}
