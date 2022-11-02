package models.entities;

import java.util.List;

public class Cliente {
    private String razonSocial;
    private String cuit;
    private List<Servicio> serviciosContratados;
    private List<Incidente> incidentes;
}
