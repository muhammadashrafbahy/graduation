/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grad.api.Entities;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.*;


/**
 *
 * @author MUHAMMAD ASHRAF BAHY
 */
@Entity
public class task {
 
    private int task_id;
    private Double task_long;
    private Double task_lat;
    private Date exp_date;
 
    private Date Start_date;   
    private String task_descript;
    private String task_name;
    private String task_city;
    private String task_country;
    private String task_dist;
    private String client_name;
    private String state;
    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private int emp_id;
    private employee emp;
   
    
    
    @ManyToOne (cascade = CascadeType.ALL , targetEntity=employee.class)
    public employee getEmp() {
		return emp;
	}

	public void setEmp(employee emp) {
		this.emp = emp;
	}
	
	private clients cl;
	@ManyToOne (cascade = CascadeType.ALL , targetEntity=clients.class)
	
 public clients getCl() {
		return cl;
	}

	public void setCl(clients cl) {
		this.cl = cl;
	}

	public task() {
    }

   
	public task(String client_name,String state ,int emp_id, Double task_long, Double task_lat, Date Start_date, Date exp_date, String task_descript, String task_name, String task_city, String task_country, String task_dist) {
       
        this.task_long = task_long;
        this.task_lat = task_lat;
        this.exp_date = exp_date;
        
        this.Start_date = Start_date;
        this.task_descript = task_descript;
        this.task_name = task_name;
        this.task_city = task_city;
        this.task_country = task_country;
        this.task_dist = task_dist;
       this.client_name =client_name;
       this.state=state;
       this.emp_id =emp_id;
    }
   @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public int getTask_id() {
        return task_id;
    }

   
    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    @Max(value=100)
    @Min(value=0)
    public Double getTask_long() {
        return task_long;
    }

    public void setTask_long(Double task_long) {
        this.task_long = task_long;
    }

    @Max(value=100)
    @Min(value=0)
    public Double getTask_lat() {
        return task_lat;
    }

    public void setTask_lat(Double task_lat) {
        this.task_lat = task_lat;
    }

    
    @Future
    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }
    
    
    @Future
    public Date getStart_date() {
        return Start_date;
    }

    public void setStart_date(Date Start_date) {
        this.Start_date = Start_date;
    }

    
    
    public String getTask_descript() {
        return task_descript;
    }

    public void setTask_descript(String task_descript) {
        this.task_descript = task_descript;
    }

     
    @Size(min=10 )
    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }
    
    
    
    public String getTask_city() {
        return task_city;
    }

    public void setTask_city(String task_city) {
        this.task_city = task_city;
    }

    public String getTask_country() {
        return task_country;
    }

    public void setTask_country(String task_country) {
        this.task_country = task_country;
    }

    public String getTask_dist() {
        return task_dist;
    }

    public void setTask_dist(String task_dist) {
        this.task_dist = task_dist;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }


    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
    
    

}
