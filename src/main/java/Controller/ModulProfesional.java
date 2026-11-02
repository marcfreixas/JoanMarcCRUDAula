package Controller;

public class ModulProfesional {
    private int id;
    private String nom;
    private int id_profe;

    public ModulProfesional(String nom, int id_profe) {
        this.nom = nom;
        this.id_profe = id_profe;
    }

    public ModulProfesional(int id, String nom, int id_profe) {
        this.id = id;
        this.nom = nom;
        this.id_profe = id_profe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_profe() {
        return id_profe;
    }

    public void setId_profe(int id_profe) {
        this.id_profe = id_profe;
    }

    public int getId()
    {
        return id;
    }
}
