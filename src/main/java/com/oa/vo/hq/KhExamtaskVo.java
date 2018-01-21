package com.oa.vo.hq;

import java.util.Date;

/**
 * 考核任务实体
 * @author 萌萌琼
 */
public class KhExamtaskVo {
	 private String etId;
	 private String etName;		//考核名称
	 private String khName;		//考核模板名称
	 private String khType;		//考核类型
	 private int khScore;		//考核分数
	 private int etYear;		//年份
	 private int etIssue;		//期次
	 private Date etStartdate;
	 private Date etEnddate;
	 private String etTime;   //考核周期
	 private String empBossName;   //考核管理员
	 private String empName;   //考核人员
	 private String etRemark;   //备注
	 private String etState;		//存在状态
	 private String etFbState;	//发布状态
	public String getEtRemark() {
		return etRemark;
	}
	public void setEtRemark(String etRemark) {
		this.etRemark = etRemark;
	}
	public String getEmpBossName() {
		return empBossName;
	}
	public void setEmpBossName(String empBossName) {
		this.empBossName = empBossName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEtState() {
		return etState;
	}
	public void setEtState(String etState) {
		this.etState = etState;
	}
	public int getKhScore() {
		return khScore;
	}
	public void setKhScore(int khScore) {
		this.khScore = khScore;
	}
	public String getEtTime() {
		return etTime;
	}
	public void setEtTime(String etTime) {
		this.etTime = etTime;
	}
	public String getEtId() {
		return etId;
	}
	public void setEtId(String etId) {
		this.etId = etId;
	}
	public String getEtName() {
		return etName;
	}
	public void setEtName(String etName) {
		this.etName = etName;
	}
	public String getKhName() {
		return khName;
	}
	public void setKhName(String khName) {
		this.khName = khName;
	}
	public String getKhType() {
		return khType;
	}
	public void setKhType(String khType) {
		this.khType = khType;
	}
	public int getEtYear() {
		return etYear;
	}
	public void setEtYear(int etYear) {
		this.etYear = etYear;
	}
	public int getEtIssue() {
		return etIssue;
	}
	public void setEtIssue(int etIssue) {
		this.etIssue = etIssue;
	}
	public Date getEtStartdate() {
		return etStartdate;
	}
	public void setEtStartdate(Date etStartdate) {
		this.etStartdate = etStartdate;
	}
	public Date getEtEnddate() {
		return etEnddate;
	}
	public void setEtEnddate(Date etEnddate) {
		this.etEnddate = etEnddate;
	}
	public String getEtFbState() {
		return etFbState;
	}
	public void setEtFbState(String etFbState) {
		this.etFbState = etFbState;
	}
	public KhExamtaskVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhExamtaskVo(String etId, String etName, String khName, String khType, int khScore, int etYear, int etIssue,
			Date etStartdate, Date etEnddate, String etTime, String empBossName, String empName, String etRemark,
			String etState, String etFbState) {
		super();
		this.etId = etId;
		this.etName = etName;
		this.khName = khName;
		this.khType = khType;
		this.khScore = khScore;
		this.etYear = etYear;
		this.etIssue = etIssue;
		this.etStartdate = etStartdate;
		this.etEnddate = etEnddate;
		this.etTime = etTime;
		this.empBossName = empBossName;
		this.empName = empName;
		this.etRemark = etRemark;
		this.etState = etState;
		this.etFbState = etFbState;
	}
}
