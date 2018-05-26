package br.ufc.mestrado.grafana;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "grafana_data")
public class GrafanaData {
	@Basic
	private long id;
	@Basic
	private int value;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.sql.Timestamp savedHour;
	
	public GrafanaData() {}
	
	@Id
	@Column(name = "value_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public java.sql.Timestamp getSavedHour() {
		return savedHour;
	}
	public void setSavedHour(java.sql.Timestamp savedHour) {
		this.savedHour = savedHour;
	}
	

	
}
