package com.youfchen.web.examination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.youfchen.entity.QuestionEntity;
import com.youfchen.repository.ExaminiationRepository;

@Controller
public class ExaminationController {
	
	public static final String[] options = new String[]{"A","B","C","D","E","F"};
	
	public static final String DEFAULT_CATEGORY = "ALL";

	@Autowired
	private ExaminiationRepository examiniationRepository;
	
	@GetMapping(value="/")
	public String welcomePage(final Model model){
		Page<QuestionEntity> examEntities = this.examiniationRepository.findAll(new PageRequest(0, 10));
		model.addAttribute("examEntities", examEntities);
		model.addAttribute("category", DEFAULT_CATEGORY);
		return "index";
	}
	
	@GetMapping(value="/index")
	public String indexPage(){
		return "redirect:/";
	}
	
	@GetMapping(value="/examinationItems")
	public String pagination(final Model model,@RequestParam(name="page") final int page, 
			@RequestParam(name="pageSize") final int pageSize,
			@RequestParam(name="category",defaultValue=DEFAULT_CATEGORY) final String category){
		Page<QuestionEntity> examEntities = null;
		if (DEFAULT_CATEGORY.equalsIgnoreCase(category)) {
			examEntities = this.examiniationRepository.findAll(new PageRequest(page, pageSize));
		} else {
			examEntities = this.examiniationRepository.findByCategory(category, new PageRequest(page, pageSize));
		}
		model.addAttribute("examEntities", examEntities);
		model.addAttribute("category", category);
		return "index";
	}
	
	@ModelAttribute
	public void addOptionsAttribute(final Model model){
		model.addAttribute("options", options);
	}
	
	@GetMapping(value="/error")
	public String errorPage(){
		return "error";
	}
}
