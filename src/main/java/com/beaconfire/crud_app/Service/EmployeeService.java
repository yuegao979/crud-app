package com.beaconfire.crud_app.Service;

import com.beaconfire.crud_app.DAO.EmployeeDAO;
import com.beaconfire.crud_app.DTO.request.CreateEmployee;
import com.beaconfire.crud_app.DTO.request.UpdateEmployee;
import com.beaconfire.crud_app.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private EmployeeDAO ed;

    @Autowired
    public void setEmployeeDAO(EmployeeDAO ed) {this.ed = ed;}

    public Employee findById(Integer id) {
        return ed.findById(id);
    }

    @NewSpan("service-findAll")
    public List<Employee> findAll() {
        return ed.findAll();
    }

    public void create(CreateEmployee ce) {
        Employee e = new Employee();
        e.setFirstname(ce.getFirstname());
        e.setLastname(ce.getLastname());
        ed.create(e);
    }

    public void update(Integer id, UpdateEmployee ue) {
        Employee e = ed.findById(id);
        if (ue.getFirstname() != null) e.setFirstname(ue.getFirstname());
        if (ue.getLastname() != null) e.setLastname(ue.getLastname());
        ed.update(e);
    }

    public void deleteById(Integer id) {
        Employee e = ed.findById(id);
        ed.deleteById(e);
    }
}
