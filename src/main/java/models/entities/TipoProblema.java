package models.entities;

import java.util.List;

public class TipoProblema {
    private String descripcion;
    private Integer horasMaximasResolucion;
    private List<Especialidad> especialidadesQueLoResuelven;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getHorasMaximasResolucion() {
        return horasMaximasResolucion;
    }

    public void setHorasMaximasResolucion(Integer horasMaximasResolucion) {
        this.horasMaximasResolucion = horasMaximasResolucion;
    }

    public List<Especialidad> getEspecialidadesQueLoResuelven() {
        return especialidadesQueLoResuelven;
    }

    public void setEspecialidadesQueLoResuelven(List<Especialidad> especialidadesQueLoResuelven) {
        this.especialidadesQueLoResuelven = especialidadesQueLoResuelven;
    }
}
