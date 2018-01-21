package com.oa.controller.hq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojos.OaExamproject;
import com.oa.pojos.OaPertemp;
import com.oa.service.hq.ExamprojectService;
import com.oa.service.hq.ExamtaskService;
import com.oa.service.hq.LevelService;
import com.oa.service.hq.MyJiXiaoService;
import com.oa.service.hq.PertempService;
import com.oa.vo.ResultMap;
import com.oa.vo.hq.DetailKhExamtaskVo;
import com.oa.vo.hq.FindJxVo;
import com.oa.vo.hq.KhExamprojectVo;
import com.oa.vo.hq.KhExamtaskVo;
import com.oa.vo.hq.KhLevelVo;
import com.oa.vo.hq.KhPertempVo;
import com.oa.vo.hq.KhScoreVo;
import com.oa.vo.hq.MyJxVo;

@Controller
public class MyJxController {
	@Autowired
	MyJiXiaoService MyJxService;	//我的绩效
	@Autowired
	PertempService pertempService;	//考核模板
	@Autowired
	ExamprojectService examService;	//考核项目
	@Autowired
	LevelService leService;			//等级标准
	@Autowired
	ExamtaskService taskService;	//考核任务
	
	/**
	 * 返回到'我的绩效'界面
	 * @return
	 */
	@RequestMapping("/to_myJx")
	public String toMyJx(){
		return "myJx";
	}
	
	/**
	 * 获取'我的绩效'数据
	 * @return
	 */
	@RequestMapping("/myJx_list")
	public @ResponseBody Map<String, Object> myJxList(int page, int limit,String time,String myJxType,String season,String empId){
		return MyJxService.findMyJiXiao(page,limit,time,myJxType,season,empId);
	}
	
	/**
	 * 返回到'绩效查询'界面
	 * @return
	 */
	@RequestMapping("/to_find_jx")
	public String toFindJx(){
		return "findJx";
	}
	
	/**
	 * 获取'绩效查询'数据
	 * @return
	 */
	@RequestMapping("/find_jx_list")
	public @ResponseBody Map<String, Object> findJxList(){
		Map<String, Object> map=new HashMap<>();
		List<FindJxVo> list = new ArrayList<>();
		list.add(new FindJxVo("竹笛",1,"优秀",90,90,"总体表现很不错"));
		list.add(new FindJxVo("紫雪儿",1,"良好",84,86,"工作认真"));
		list.add(new FindJxVo("莉莉",2,"合格",74,72,"还应继续努力"));
		list.add(new FindJxVo("敏儿",3,"优秀",92,95,"很棒"));
		list.add(new FindJxVo("晓晓",4,"不合格",60,50,"要加油吖"));
		map.put("data", list);
		map.put("count", list.size());
		map.put("code", 0);
		return map;
	}
	
	/**
	 * 返回到'考核评分'界面
	 * @return
	 */
	@RequestMapping("/to_kh_score")
	public String toKhScore(){
		return "khScore";
	}
	
	/**
	 * 获取'考核评分'数据
	 * @return
	 */
	@RequestMapping("/find_kh_score_list")
	public @ResponseBody Map<String, Object> findKhScoreList(){
		Map<String, Object> map=new HashMap<>();
		List<KhScoreVo> list = new ArrayList<>();
		list.add(new KhScoreVo("员工绩效","自评","晓晓","2018-01-01","2018-01-02"));
		list.add(new KhScoreVo("考核1","自评","竹笛","2018-01-2","2018-01-03"));
		list.add(new KhScoreVo("考核1","经理评","莉莉","2018-01-6","2018-01-07"));
		list.add(new KhScoreVo("考核2","自评","雪儿","2018-01-9","2018-01-10"));
		list.add(new KhScoreVo("考核3","自评","水麒麟","2018-01-12","2018-01-13"));
		map.put("data", list);
		map.put("count", list.size());
		map.put("code", 0);
		return map;
	}
	
	/**
	 * 返回到'考核任务'界面
	 * @return
	 */
	@RequestMapping("/to_kh_examtask")
	public String toKhExamtask(){
		return "khExamtask";
	}
	
	/**
	 * 获取'考核任务'数据
	 * @return
	 */
	@RequestMapping("/find_kh_examtask_list")
	public @ResponseBody Map<String,Object> findKhExamtaskList(int page,int limit,String taskyear,String taskType){
		return taskService.findTask(page, limit, taskyear, taskType);
 	}
	
	/**
	 * 删除'考核任务'数据
	 * @return
	 */
	@RequestMapping("/delExamtask")
	public @ResponseBody Map<String,Object> delExamtaskList(String da){
		try {
			boolean result = taskService.delExamtask(da);
			ResultMap.putObj("success", result);
			ResultMap.putObj("msg", result?"删除成功":"删除失败");
			return ResultMap.getResultMap();
		} catch (Exception e) {
			ResultMap.putObj("success", false);
			ResultMap.putObj("msg", e.getMessage());
			return ResultMap.getResultMap();
		}
	}
	
	/**
	 * 返回到'考核任务-查看'界面
	 * @return
	 */
	@RequestMapping("/to_see_kh_examtask")
	public ModelAndView toSeeKhExamtask(String etId){
		ModelAndView mv=new ModelAndView("seeKhExamtask");
		KhExamtaskVo etVo = taskService.findExamtaskOne(etId);
		mv.addObject("et", etVo);
		return mv;
	}
	
	/**
	 * 考核任务-明细
	 * @param etId 考核任务id
	 * @return
	 */
	@RequestMapping("/to_detail_kh_examtask")
	public ModelAndView toDetailKhExamtask(String etId){
		ModelAndView mv=new ModelAndView("detailKhExamtask");
		DetailKhExamtaskVo detailEtVo =taskService.findDetailExamtaskOne(etId);
		return mv;
	}
	/**
	 * 返回到'考核任务-新增'界面
	 * @return
	 */
	@RequestMapping("/to_add_kh_examtask")
	public ModelAndView toAddKhExamtask(String ptId){
		ModelAndView mv=new ModelAndView("detailKhExamtask");
		//===============待续
		return mv;
	}
	
	/**
	 * 返回到'考核任务-编辑'界面
	 * @return
	 */
	@RequestMapping("/to_edit_kh_examtask")
	public String toEditKhExamtask(){
		return "editKhExamtask";
	}
	
	/**
	 * 返回到'考核任务-新增-选择考核模板'界面
	 * @return
	 */
	@RequestMapping("/to_kh_addPertempLayer")
	public ModelAndView tokhAddPertempLayer(){
		ModelAndView mv=new ModelAndView("khAddPertempLayer");
		List<KhPertempVo> listPt = pertempService.findAllPertemp();
		mv.addObject("list",listPt);
		return mv;
	}
	 
	/**
	 * 返回到'考核模板'界面
	 * @return
	 */
	@RequestMapping("/to_kh_pertemp")
	public String toKhPertemp(){
		return "khPertemp";
	}
	
	/**
	 * 获取'考核模板'数据
	 * @return
	 */
	@RequestMapping("/find_kh_pertemp_list")
	public @ResponseBody Map<String,Object> findKhPertempList(int page,int limit,String khName,String khType,String khPertempTime1,String khPertempTime2){
		return pertempService.findPertemp(page, limit,khName,khType,khPertempTime1,khPertempTime2);
	}
	
	/**
	 * 删除'考核模板'数据
	 * @return
	 */
	@RequestMapping("/del_kh_pertemp_list")
	public @ResponseBody Map<String,Object> delKhPertempList(String da){
		try {
			boolean result = pertempService.delPertemp(da);
			ResultMap.putObj("success", result);
			ResultMap.putObj("msg", result?"删除成功":"删除失败");
			return ResultMap.getResultMap();
		} catch (Exception e) {
			ResultMap.putObj("success", false);
			ResultMap.putObj("msg", e.getMessage());
			return ResultMap.getResultMap();
		}
	}
	
	/**
	 * '考核模板-增加'界面
	 * @return
	 */
	@RequestMapping("/to_add_kh_pertemp")
	public String toAddKhPertemp(){
        return "addKhPertemp";
	}
	
	/**
	 * '考核模板-编辑'界面
	 * khId 考核模板id
	 * @return
	 */
	@RequestMapping("/to_edit_kh_pertemp")
	public ModelAndView toEditKhPertemp(int state,String khId){
		ModelAndView mv=new ModelAndView("addKhPertemp");
		mv.addObject("state", state);
		KhPertempVo pt = pertempService.findPertempOne(khId);	//考核模板
		mv.addObject("pt", pt);
        return mv;
	}
	
	/**
	 * '考核项目-新增'界面
	 * ptId  考核模板id
	 * @return
	 */
	@RequestMapping("/to_add_kh_examprojectLayer")
	public ModelAndView tokhExamprojectLayer(String ptId){
		ModelAndView mv=new ModelAndView("khExamprojectLayer");
		mv.addObject("ptId", ptId);
		return mv;
	}
	
	/**
	 * '考核项目-编辑'界面
	 * epId 考核项目id
	 * @return
	 */
	@RequestMapping("/to_edit_kh_examprojectLayer")
	public ModelAndView toEditkhExamprojectLayer(String epId){
		KhExamprojectVo exam= examService.queryExamproject(epId);
		ModelAndView mv=new ModelAndView("khExamprojectLayer"); 
		mv.addObject("ep", exam);
		return mv;
	}
	
	/**
	 * 获取'考核项目'数据
	 * ptId 获取考核模板id
	 * @return
	 */
	@RequestMapping("/find_kh_examproject_list")
	public @ResponseBody Map<String,Object> findKhExamprojectList(String ptId){
		return examService.findOaExamproject(ptId);
	}
	
	/**
	 * 删除'考核项目'数据
	 * @return
	 */
	@RequestMapping("/del_kh_project")
	public @ResponseBody Map<String,Object> delProject(String da){
		try {
			boolean result =examService.delLevel(da);
			ResultMap.putObj("success", result);
			ResultMap.putObj("msg", result?"删除成功":"删除失败");
			return ResultMap.getResultMap();
		} catch (Exception e) {
			ResultMap.putObj("success", false);
			ResultMap.putObj("msg", e.getMessage());
			return ResultMap.getResultMap();
		}
	}
	
	/**
	 * 返回到'等级标准-新增'界面
	 * @return
	 */
	@RequestMapping("/to_add_kh_levelLayer")
	public ModelAndView tokhLevelLayer(String ptId){
		ModelAndView mv=new ModelAndView("khLevelLayer");
		mv.addObject("ptId", ptId);
		return mv;
	}
	
	/**
	 * 返回到'等级标准-编辑'界面
	 * @return
	 */
	@RequestMapping("/to_edit_kh_levelLayer")
	public ModelAndView toEditkhLevelLayer(String leId){
		KhLevelVo leVo= leService.queryLevel(leId);
		ModelAndView mv=new ModelAndView("khLevelLayer"); 
		mv.addObject("lel", leVo);
		return mv;
	}
	
	/**
	 * 获取'等级标准'数据
	 * @return
	 */
	@RequestMapping("/find_kh_level_list")
	public @ResponseBody Map<String,Object> findKhLevelList(String ptId){
		return leService.findOaLevel(ptId);
	}
	
	/**
	 * 新增-编辑-'等级标准'数据
	 * @return
	 */
	@RequestMapping("/to_addLevelList")
	public @ResponseBody String findAddLevelList(String ptId,String leId,String name,int minscore,int maxscore){
		try {
			boolean result;
			if(leId!=null && !"".equals(leId)){
				//epId不为空-编辑
				result = leService.editLevel(leId, name, minscore, maxscore);
			}else{
				//epId为空-新增
				result = leService.addOaLevel(ptId,name, minscore, maxscore);
			}
			ResultMap.putObj("success", result);
			ResultMap.putObj("msg", result?"修改等级标准成功":"修改等级标准失败");
			return result?"修改等级标准成功":"修改等级标准失败";
		} catch (Exception e) {
			e.printStackTrace();
			return "出现异常，修改等级标准失败！";
		}
	}
	
	/**
	 * 删除'等级标准'数据
	 * @return
	 */
	@RequestMapping("/del_kh_level")
	public @ResponseBody Map<String,Object> delKhLevel(String da){
		try {
			boolean result = leService.delLevel(da);
			ResultMap.putObj("success", result);
			ResultMap.putObj("msg", result?"删除成功":"删除失败");
			return ResultMap.getResultMap();
		} catch (Exception e) {
			ResultMap.putObj("success", false);
			ResultMap.putObj("msg", e.getMessage());
			return ResultMap.getResultMap();
		}
	}
	
	/**
	 * 新增-编辑-'考核项目'
	 * @return
	 */
	@RequestMapping("/to_addExamprojectList")
	public @ResponseBody String findAddExamprojectList(String ptId,String epId,String proName,int standScore,int minScore,int maxScore,String scorerule,String remark){
		try {
			boolean result;
			if(epId!=null && !"".equals(epId)){
				//epId不为空-编辑
				result = examService.editExamproject(epId,proName, standScore, minScore, maxScore, scorerule, remark);
			}else{
				//epId为空-新增
				result = examService.addExamproject(ptId,proName, standScore, minScore, maxScore, scorerule, remark);
			}
			ResultMap.putObj("success", result);
			ResultMap.putObj("msg", result?"增加考核项目成功":"增加考核项目失败");
			return result?"增加考核项目成功":"增加考核项目失败";
		} catch (Exception e) {
			e.printStackTrace();
			ResultMap.putObj("success", false);
			ResultMap.putObj("msg", e.getMessage());
			return "出现异常，新增失败！"+ResultMap.getResultMap();
		}
	}

	/**
	 * 考核模板-保存
	 */
	@RequestMapping("/to_save_khPertemp")
	public @ResponseBody String SaveKhPertemp(String ptId,String khName,String khType,String empId,String khPeople,int khScore,String khRemark){
		try {
			System.out.println("=============="+khRemark);
			if(ptId!=null && !"".equals(ptId)){
				//编辑
				return pertempService.editPertemp(ptId,khName, khType, empId, khPeople, khScore, khRemark);
			}else{
				//新增
				return pertempService.savePertemp(khName, khType, empId, khPeople, khScore, khRemark);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "保存失败！";
		}
	}
}
