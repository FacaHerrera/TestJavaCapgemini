import models.entities.*;
import models.exceptions.TecnicoException;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class TecnicoTest {

    Especialidad so;
    Especialidad redes;
    Especialidad java;
    List<Especialidad> especialidades;
    List<Especialidad> especialidades2;
    List<Especialidad> especialidades3;
    Problema problema;
    Problema problema2;
    Problema problema3;
    TipoProblema tipoProblema;
    TipoProblema tipoProblema2;
    TipoProblema tipoProblema3;
    List<Problema> problemas;
    List<Problema> problemas2;
    List<Problema> problemas3;
    Incidente incidente;
    Incidente incidente2;
    Incidente incidente3;
    Tecnico tec1;
    Tecnico tec2;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Comienzan los tests");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Finalizan los tests");
    }

    /**
     * Armamos la inicializacion de los objetos que forman parte de nuestro contexto de prueba.
     * Dejo un segundo Tecnico para que realicen pruebas posteriores si asi lo desean.
     */
    @Before
    public void setup() {
        so = new Especialidad("Sistemas operativos");
        especialidades = new ArrayList<>();
        especialidades.add(so);

        redes = new Especialidad("Redes");
        especialidades2 = new ArrayList<>();
        especialidades2.add(redes);
        especialidades2.add(so);

        java = new Especialidad("Java");
        especialidades3 = new ArrayList<>();
        especialidades3.add(java);

        problema = new Problema();
        tipoProblema = new TipoProblema();
        tipoProblema.setEspecialidadesQueLoResuelven(especialidades);
        problema.setTipoProblema(tipoProblema);

        problema2 = new Problema();
        tipoProblema2 = new TipoProblema();
        tipoProblema2.setEspecialidadesQueLoResuelven(especialidades2);
        problema2.setTipoProblema(tipoProblema2);

        problema3 = new Problema();
        tipoProblema3 = new TipoProblema();
        tipoProblema3.setEspecialidadesQueLoResuelven(especialidades3);
        problema3.setTipoProblema(tipoProblema3);

        problemas = new ArrayList<>();
        problemas.add(problema);

        problemas2 = new ArrayList<>();
        problemas2.add(problema);
        problemas2.add(problema2);

        problemas3 = new ArrayList<>();
        problemas3.add(problema3);

        incidente = new Incidente();
        incidente.setProblemas(problemas);

        incidente2 = new Incidente();
        incidente2.setProblemas(problemas2);

        incidente3 = new Incidente();
        incidente3.setProblemas(problemas3);

        tec1 = new Tecnico("Facundo", especialidades, new ArrayList<>(), true, new ArrayList<>());
        tec2 = new Tecnico("Lucas", especialidades2, new ArrayList<>(), true, new ArrayList<>());
    }

    /**
     * Probamos que un tecnico pueda resolver un incidente que tenga un problema de algun
     * tipo que pueda ser resuelto por alguna de sus especialidades
     *
     * @throws Exception
     */
    @Test
    public void tecnicoPuedeResolverIncidente() throws Exception {
        tec1.addIncident(incidente);
        Assert.assertEquals(1, tec1.getIncidentesAsignados().size());
    }

    /**
     * En este caso, tenemos un incidente con un problema de Java, y el tecnico 1 no cuenta con esa
     * especialidad, por lo tanto no podra resolverlo.
     *
     * @throws Exception
     */
    @Test(expected = TecnicoException.class)
    public void tecnicoNoPuedeResolverIncidente() throws Exception {
        tec1.addIncident(incidente3);
    }

    /**
     * En este caso, tenemos un incidente con 2 problemas, uno cuyo tipo tiene como especialidad resolutoria
     * Sistemas Operativos, y otro con Redes. El tecnico, tiene ambas especialidades, por ende, podra agregar
     * el incidente a su lista.
     *
     * @throws Exception
     */
    @Test
    public void tecnicoPuedeResolverIncidenteConMultiplesProblemas() throws Exception {
        tec2.addIncident(incidente2);
        Assert.assertEquals(1, tec2.getIncidentesAsignados().size());
    }
}
