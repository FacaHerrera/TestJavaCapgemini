package models.entities;

import models.exceptions.TecnicoException;
import models.exceptions.TecnicoNoAptoException;

import java.util.List;

public class Tecnico {
    private String nombre;
    private List<Especialidad> especialidades;
    private List<Incidente> incidentesAsignados;
    private Boolean estaDisponible;
    private List<TiempoDefaultResolucion> tiemposDefault;

    public Tecnico(String nombre, List<Especialidad> especialidades, List<Incidente> incidentesAsignados, Boolean estaDisponible, List<TiempoDefaultResolucion> tiemposDefault) {
        this.setNombre(nombre);
        this.setEspecialidades(especialidades);
        this.setIncidentesAsignados(incidentesAsignados);
        this.setEstaDisponible(estaDisponible);
        this.setTiemposDefault(tiemposDefault);
    }

    /**
     * Solucionamos el error de la clase, desmenuzando el problema en cuando un tecnico puede resolver y replicando
     * la logica para todos los problemas de un incidente. Creamos una Excepcion personalizada para los errores
     * relacionados con la clase tecnico.
     *
     * @param incidente
     * @throws Exception
     */
    public void addIncident(Incidente incidente) throws Exception {
        try {

            boolean puedeResolver = incidente.getProblemas().stream().allMatch(x -> puedeResolver(x));
            if(!puedeResolver) {
                throw new TecnicoNoAptoException("El tecnico no puede ser asignado ya que no cuenta con las especialidades necesarias");
            }
            else incidentesAsignados.add(incidente);

        } catch (Exception e) {
            throw new TecnicoException(e.getMessage());
        }
    }
    public boolean puedeResolver(Problema unProblema) {
        List<Especialidad> especialidadesResolutorias = unProblema.getTipoProblema().getEspecialidadesQueLoResuelven();
        for(Especialidad e: this.getEspecialidades()) {
            if(especialidadesResolutorias.contains(e))
                return true;
        }

        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public List<Incidente> getIncidentesAsignados() {
        return incidentesAsignados;
    }

    public void setIncidentesAsignados(List<Incidente> incidentesAsignados) {
        this.incidentesAsignados = incidentesAsignados;
    }

    public Boolean getEstaDisponible() {
        return estaDisponible;
    }

    public void setEstaDisponible(Boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    public List<TiempoDefaultResolucion> getTiemposDefault() {
        return tiemposDefault;
    }

    public void setTiemposDefault(List<TiempoDefaultResolucion> tiemposDefault) {
        this.tiemposDefault = tiemposDefault;
    }
}
