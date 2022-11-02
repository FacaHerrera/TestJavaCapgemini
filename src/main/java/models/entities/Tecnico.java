package models.entities;

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

    public void addIncident(Incidente incidente) {
        try {
            incidente.getProblemas().forEach(p -> {
                List<Especialidad> especialidadesResolutorias = p.getTipoProblema().getEspecialidadesQueLoResuelven();
                for(Especialidad e: getEspecialidades()) {
                    if(especialidadesResolutorias.contains(e)) {
                        getIncidentesAsignados().add(incidente);
                        System.out.println("Se agrego el incidente a la lista del tecnico: " + this.getNombre());
                        break;
                    }
                }
            });

            System.out.println("No es posible agregar el incidente a la lista debido a que las especialidades no corresponden");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
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
