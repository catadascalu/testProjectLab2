package testProjectLab2;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testProjectLab2.src.Domain.Nota;
import testProjectLab2.src.Domain.Student;
import testProjectLab2.src.Domain.TemaLab;
import testProjectLab2.src.Exceptions.ValidatorException;
import testProjectLab2.src.Repository.XMLFileRepository.NotaXMLRepo;
import testProjectLab2.src.Repository.XMLFileRepository.StudentXMLRepo;
import testProjectLab2.src.Repository.XMLFileRepository.TemaLabXMLRepo;
import testProjectLab2.src.Service.XMLFileService.StudentXMLService;
import testProjectLab2.src.Validator.IValidator;
import testProjectLab2.src.Validator.NotaValidator;
import testProjectLab2.src.Validator.StudentValidator;
import testProjectLab2.src.Validator.TemaLabValidator;



/**
 * Unit test for simple App.
 */
public class AppTest 
{

    StudentXMLService service;
    StudentXMLRepo studentRepository;
    TemaLabXMLRepo temaRepository;
    NotaXMLRepo notaRepository;

    @Before
    public void initData(){

        StudentValidator studentValidator = new StudentValidator();

        studentRepository = new StudentXMLRepo(studentValidator, "StudentiXML.xml");


        service = new StudentXMLService(studentRepository);
    }
    /**
     * Rigorous Test :-)

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
     */

    @Test
    public void testAddStudentToRepository(){
        int length = studentRepository.getSize();
        String[] params = {"11", "Student_test", "932", "email_test@scs.ro", "prof_1"};
        try {
            service.add(params);
        }
        catch(ValidatorException ex){
            //System.out.println(ex.getMessage());
            Assert.fail();
        }
        assertTrue(studentRepository.getSize() == length + 1);
        assertEquals(studentRepository.findOne("11").getNume(), "Student_test");
    }

    @Test
    public void testAddStudentWithException(){
        int length = studentRepository.getSize();
        String[] params = {"12", "Student_test", "0", "email_test@scs.ro", "prof_1"};
        try {
            service.add(params);
            Assert.fail("Grupa invalid\n");
        }
        catch(ValidatorException ex){
            System.out.println(ex.getMessage());
        }

        assertTrue(studentRepository.getSize() == length);
    }
}
