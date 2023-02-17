package entity;

import jakarta.persistence.*;
@NamedQuery(name="select_pplID",query = "SELECT idPerson FROM ConPersonToProtest WHERE idPrtestIn=?1")
@Entity
@Table(name = "con_person_to_protest", schema = "public", catalog = "Protest")
public class ConPersonToProtest {
    private int id;
    private int idPerson;
    private int idPrtestIn;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_person", nullable = false)
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @Basic
    @Column(name = "id_prtest_in", nullable = false)
    public int getIdPrtestIn() {
        return idPrtestIn;
    }

    public void setIdPrtestIn(int idPrtestIn) {
        this.idPrtestIn = idPrtestIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConPersonToProtest that = (ConPersonToProtest) o;

        if (id != that.id) return false;
        if (idPerson != that.idPerson) return false;
        if (idPrtestIn != that.idPrtestIn) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idPerson;
        result = 31 * result + idPrtestIn;
        return result;
    }
}
