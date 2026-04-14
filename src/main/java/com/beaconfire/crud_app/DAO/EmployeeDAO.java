package com.beaconfire.crud_app.DAO;

import com.beaconfire.crud_app.DTO.request.CreateEmployee;
import com.beaconfire.crud_app.DTO.request.UpdateEmployee;
import com.beaconfire.crud_app.Entity.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO {
    private SessionFactory sf;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {this.sf = sf;}

    public Employee findById(Integer id) {
        return sf.getCurrentSession().get(Employee.class, id);
    }

    @NewSpan("dao-findAll")
    public List<Employee> findAll() {
        return sf.getCurrentSession()
                .createQuery("from Employee", Employee.class)
                .list();
    }

    public void create(Employee e) {
        sf.getCurrentSession().save(e);
    }

    public void update(Employee e) {
        sf.getCurrentSession().update(e);
    }

    public void deleteById(Employee e) {
        sf.getCurrentSession().delete(e);
    }
}
