import models.entities.*;
import org.junit.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class TecnicoTest {

    Especialidad so;
    List<Especialidad> especialidades;
    Problema problema;
    TipoProblema tipoProblema;
    List<Problema> problemas;
    Incidente incidente;
    Tecnico tec1;


    @BeforeClass
    public static void beforeClass() {
        System.out.println("Comienzan los tests");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Finalizan los tests");
    }

    @Before
    public void setup() {
        so = new Especialidad("Sistemas operativos");
        especialidades = new ArrayList<>();
        especialidades.add(so);

        problema = new Problema();
        tipoProblema = new TipoProblema();
        tipoProblema.setEspecialidadesQueLoResuelven(especialidades);
        problema.setTipoProblema(tipoProblema);
        problemas = new ArrayList<>();
        problemas.add(problema);

        incidente = new Incidente();
        incidente.setProblemas(problemas);

        tec1 = new Tecnico("Facundo", especialidades, new ArrayList<Incidente>(), true, new ArrayList<TiempoDefaultResolucion>());
    }

    @Test
    public void tecnicoPuedeResolverIncidente() {
        tec1.addIncident(incidente);
        Assert.assertEquals(1, tec1.getIncidentesAsignados().size());
    }
}
