package entities;

public class Matricula {
    private int id;
    private int idEstudiante;
    private int idCurso;

    public Matricula() {}

    public Matricula(int id, int idEstudiante, int idCurso) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdEstudiante() { return idEstudiante; }
    public void setIdEstudiante(int idEstudiante) { this.idEstudiante = idEstudiante; }

    public int getIdCurso() { return idCurso; }
    public void setIdCurso(int idCurso) { this.idCurso = idCurso; }
}
