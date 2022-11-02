package models.entities;

import java.util.List;

public class Problema {
    private String descripcion;
    private TipoProblema tipoProblema;
    private NivelDificultad nivelDificultad;
    private List<Estado> historialEstados;
    private Estado estadoActual;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoProblema getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(TipoProblema tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public NivelDificultad getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(NivelDificultad nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public List<Estado> getHistorialEstados() {
        return historialEstados;
    }

    public void setHistorialEstados(List<Estado> historialEstados) {
        this.historialEstados = historialEstados;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }
}
