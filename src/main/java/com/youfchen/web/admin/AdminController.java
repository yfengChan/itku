package com.youfchen.web.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.youfchen.entity.AnswerEntity;
import com.youfchen.entity.QuestionEntity;
import com.youfchen.entity.UserEntity;
import com.youfchen.repository.ExaminiationRepository;
import com.youfchen.repository.UserRepository;

@Controller
public class AdminController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ExaminiationRepository examiniationRepository;
	
	@GetMapping(value="/login")
	public String adminPage(final Model model){
		return "login";
	}
	
	@PostMapping(value="/login")
	public String fail(final Model model){
		return "login";
	}
	
	@PostMapping(value="/maintenancePage")
	public String authorize(@ModelAttribute final UserEntity userEntity,final Model model){
		model.addAttribute("questionEntity", new QuestionEntity());
		UserEntity returnUser = userRepository.findByUsernameAndPassword(userEntity.getUsername(), userEntity.getPassword());
		if (returnUser != null && "admin".equalsIgnoreCase(returnUser.getRole())) {
			return "maintenance";
		}
		model.addAttribute("errorInfo", "Invalid User");
		return "maintenance";
	}
	
	@PostMapping(value="/addNewItem")
	public String addItem(@ModelAttribute final QuestionEntity questionEntity){
		for (AnswerEntity answerEntity : questionEntity.getAnswers()) {
			answerEntity.setQuestionEntity(questionEntity);
		}
		this.examiniationRepository.save(questionEntity);
		return "maintenance";
	}
}
