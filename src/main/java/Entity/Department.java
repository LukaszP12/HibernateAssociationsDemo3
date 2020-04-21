package Entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public
class Department{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_department")
    Integer id_department;

    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "id_company")
    Company company;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Integer getId_department() {
        return id_department;
    }

    public void setId_department(Integer id_department) {
        this.id_department = id_department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id_department=" + id_department +
                ", name='" + name + '\'' +
                ", company=" + company +
                '}';
    }

}