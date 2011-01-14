package cn.edu.sjtu.petclinic.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_administrator")
@DiscriminatorValue("0")
public class Administrator extends User {

}
