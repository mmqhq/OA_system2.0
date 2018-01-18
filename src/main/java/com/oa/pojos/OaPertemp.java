package com.oa.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oa_pertemp database table.
 * 
 */
@Entity
@Table(name="oa_pertemp")
@NamedQuery(name="OaPertemp.findAll", query="SELECT o FROM OaPertemp o")
public class OaPertemp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pt_id")
	private String ptId;

	@Temporal(TemporalType.DATE)
	@Column(name="pt_crdate")
	private Date ptCrdate;

	@Column(name="pt_creater")
	private String ptCreater;

	@Column(name="pt_name")
	private String ptName;

	@Column(name="pt_remark")
	private String ptRemark;

	@Column(name="pt_score")
	private int ptScore;

	@Column(name="pt_state")
	private int ptState;

	@Column(name="pt_type")
	private int ptType;

	//bi-directional many-to-one association to OaExamproject
	@OneToMany(mappedBy="oaPertemp")
	private List<OaExamproject> oaExamprojects;

	//bi-directional many-to-one association to OaExamtask
	@OneToMany(mappedBy="oaPertemp")
	private List<OaExamtask> oaExamtasks;

	//bi-directional many-to-one association to OaLevel
	@OneToMany(mappedBy="oaPertemp")
	private List<OaLevel> oaLevels;

	//bi-directional many-to-one association to OaEmp
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="emp_id")
	private OaEmp oaEmp;

	public OaPertemp() {
	}

	public String getPtId() {
		return this.ptId;
	}

	public void setPtId(String ptId) {
		this.ptId = ptId;
	}

	public Date getPtCrdate() {
		return this.ptCrdate;
	}

	public void setPtCrdate(Date ptCrdate) {
		this.ptCrdate = ptCrdate;
	}

	public String getPtCreater() {
		return this.ptCreater;
	}

	public void setPtCreater(String ptCreater) {
		this.ptCreater = ptCreater;
	}

	public String getPtName() {
		return this.ptName;
	}

	public void setPtName(String ptName) {
		this.ptName = ptName;
	}

	public String getPtRemark() {
		return this.ptRemark;
	}

	public void setPtRemark(String ptRemark) {
		this.ptRemark = ptRemark;
	}

	public int getPtScore() {
		return this.ptScore;
	}

	public void setPtScore(int ptScore) {
		this.ptScore = ptScore;
	}

	public int getPtState() {
		return this.ptState;
	}

	public void setPtState(int ptState) {
		this.ptState = ptState;
	}

	public int getPtType() {
		return this.ptType;
	}

	public void setPtType(int ptType) {
		this.ptType = ptType;
	}

	public List<OaExamproject> getOaExamprojects() {
		return this.oaExamprojects;
	}

	public void setOaExamprojects(List<OaExamproject> oaExamprojects) {
		this.oaExamprojects = oaExamprojects;
	}

	public OaExamproject addOaExamproject(OaExamproject oaExamproject) {
		getOaExamprojects().add(oaExamproject);
		oaExamproject.setOaPertemp(this);

		return oaExamproject;
	}

	public OaExamproject removeOaExamproject(OaExamproject oaExamproject) {
		getOaExamprojects().remove(oaExamproject);
		oaExamproject.setOaPertemp(null);

		return oaExamproject;
	}

	public List<OaExamtask> getOaExamtasks() {
		return this.oaExamtasks;
	}

	public void setOaExamtasks(List<OaExamtask> oaExamtasks) {
		this.oaExamtasks = oaExamtasks;
	}

	public OaExamtask addOaExamtask(OaExamtask oaExamtask) {
		getOaExamtasks().add(oaExamtask);
		oaExamtask.setOaPertemp(this);

		return oaExamtask;
	}

	public OaExamtask removeOaExamtask(OaExamtask oaExamtask) {
		getOaExamtasks().remove(oaExamtask);
		oaExamtask.setOaPertemp(null);

		return oaExamtask;
	}

	public List<OaLevel> getOaLevels() {
		return this.oaLevels;
	}

	public void setOaLevels(List<OaLevel> oaLevels) {
		this.oaLevels = oaLevels;
	}

	public OaLevel addOaLevel(OaLevel oaLevel) {
		getOaLevels().add(oaLevel);
		oaLevel.setOaPertemp(this);

		return oaLevel;
	}

	public OaLevel removeOaLevel(OaLevel oaLevel) {
		getOaLevels().remove(oaLevel);
		oaLevel.setOaPertemp(null);

		return oaLevel;
	}

	public OaEmp getOaEmp() {
		return this.oaEmp;
	}

	public void setOaEmp(OaEmp oaEmp) {
		this.oaEmp = oaEmp;
	}

}