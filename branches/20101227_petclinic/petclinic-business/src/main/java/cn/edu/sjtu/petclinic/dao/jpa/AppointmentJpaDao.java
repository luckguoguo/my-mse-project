package cn.edu.sjtu.petclinic.dao.jpa;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.petclinic.dao.AppointmentDao;
import cn.edu.sjtu.petclinic.entity.Appointment;

@Repository("appointmentDao")
public class AppointmentJpaDao extends AbstractJpaDaoSupport<Appointment, Long> implements AppointmentDao {

}
