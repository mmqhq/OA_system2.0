package com.oa.controller.hq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oa.pojos.OaExamproject;
import com.oa.pojos.OaJob;
import com.oa.pojos.OaPertemp;
import com.oa.service.hq.ExamprojectService;
import com.oa.service.hq.PertempService;
import com.oa.vo.ResultMap;
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
	PertempService pertempService;
	@Autowired
	ExamprojectService examService;
	
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
	public @ResponseBody Map<String, Object> myJxList(){
		Map<String, Object> map=new HashMap<>();
		List<MyJxVo> list = new ArrayList<>();
		list.add(new MyJxVo(1,"优秀",90,90,90,"总体表现很不错"));
		list.add(new MyJxVo(1,"良好",85,84,86,"工作认真"));
		list.add(new MyJxVo(2,"合格",72,74,72,"还应继续努力"));
		list.add(new MyJxVo(3,"优秀",93,92,95,"很棒"));
		list.add(new MyJxVo(4,"不合格",55,60,50,"要加油吖"));
		map.put("data", list);
		map.put("count", list.size());
		map.put("code", 0);
		return map;
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
	public @ResponseBody Map<String, Object> findKhExamtaskList(){
		Map<String, Object> map=new HashMap<>();
		List<KhExamtaskVo> list = new ArrayList<>();
		list.add(new KhExamtaskVo("考核任务1","员工绩效","月度考核","2018",1,"2018-01-02~2018-01-03","已完成"));
		list.add(new KhExamtaskVo("考核任务2","考核2","年度考核","2018",2,"2018-01-06~2018-01-08","已发布"));
		list.add(new KhExamtaskVo("考核任务3","考核3","季度考核","2018",3,"2018-01-12~2018-01-13","进行中"));
		list.add(new KhExamtaskVo("2018年员工绩效","员工绩效","月度考核","2018",1,"2018-01-15~2018-01-16","进行中"));
		list.add(new KhExamtaskVo("2018年考核1","考核1","月度考核","2018",2,"2018-01-16~2018-01-17","已完成"));
		map.put("data", list);
		map.put("count", list.size());
		map.put("code", 0);
		return map;
	}
	
	/**
	 * 返回到'考核任务-查看'界面
	 * @return
	 */
	@RequestMapping("/to_see_kh_examtask")
	public String toSeeKhExamtask(){
		return "seeKhExamtask";
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
	 * '考核模板-编辑'界面
	 * @return
	 */
	@RequestMapping("/to_edit_kh_pertemp")
	public ModelAndView toEditKhPertemp(String khId){
		ModelAndView mv=new ModelAndView("editKhPertemp");
		KhPertempVo khPtVo=pertempService.findPertempOne(khId);
        mv.addObject("pt",khPtVo);
        return mv;
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
	 * '考核项目-编辑'界面
	 * @return
	 */
	@RequestMapping("/to_edit_kh_examprojectLayer")
	public ModelAndView tokhExamprojectLayer(){
		ModelAndView mv=new ModelAndView("khExamprojectLayer");
		return mv;
	}
	
	/**
	 * 返回到'考核等级-编辑'界面
	 * @return
	 */
	@RequestMapping("/to_edit_kh_levelLayer")
	public String tokhLevelLayer(){
		return "khLevelLayer";
	}
	
	/**
	 * 获取'考核项目'数据
	 * @return
	 */
	@RequestMapping("/find_edit_kh_examproject_list")
	public @ResponseBody Map<String,Object>  findEditKhExamproject(){
		return examService.findOaExamproject();
	}
	

	/**
	 * 新增'考核项目'
	 * @return
	 */
	@RequestMapping("/to_addExamprojectList")
	public @ResponseBody String findAddExamprojectList(String khName,int standScore,int minScore,int maxScore,String scorerule,String remark){
		try {
			boolean result = examService.addExamproject(khName, standScore, minScore, maxScore, scorerule, remark);
			ResultMap.putObj("success", result);
			ResultMap.putObj("msg", result?"增加考核项目成功":"增加考核项目失败");
			return result?"增加考核项目成功":"增加考核项目失败";
		} catch (Exception e) {
			e.printStackTrace();
			ResultMap.putObj("success", false);
			ResultMap.putObj("msg", e.getMessage());
			//return ResultMap.getResultMap();
			return "出现异常，新增失败！"+ResultMap.getResultMap();
		}
	}
	
	/**
	 * 获取'等级标准'数据
	 * @return
	 */
	@RequestMapping("/find_edit_kh_level_list")
	public @ResponseBody Map<String, Object> findEditKhLevel(){
		Map<String, Object> map=new HashMap<>();
		List<KhLevelVo> list = new ArrayList<>();
		list.add(new KhLevelVo("优秀",90,100,1));
		list.add(new KhLevelVo("良好",80,89,2));
		list.add(new KhLevelVo("合格",60,79,3));
		list.add(new KhLevelVo("不合格",0,59,4));
		map.put("data", list);
		map.put("count", list.size());
		map.put("code", 0);
		return map;
	}
	
		
}
