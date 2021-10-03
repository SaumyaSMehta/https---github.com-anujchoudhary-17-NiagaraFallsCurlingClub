package com.codingfreaks.NiagaraFallsCurlingClub.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Team;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.User;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.TeamRepository;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TeamManagementController {

  private String teamId;

  @Autowired
  private TeamRepository teamRepository;

  @Autowired
  private UserRepository userRepository;


  String userId;

  @RequestMapping(value="/team_management",method=RequestMethod.GET)
  public String team_management(Model model,  @RequestParam("uid") String uid){

    model.addAttribute("userList", totalUsers());
    model.addAttribute("teamList", totalTeams());
    model.addAttribute("teamSelect", "123");

    System.out.println(totalUsers().get(0).getFirstName());

    userId = uid;
    return "views/teamManagement.html";

  }

  @RequestMapping(value="/team_management",method = RequestMethod.POST)
  public String createTeam(RedirectAttributes redirectAttrs, @RequestParam String teamName){

    List<User> listUser=new ArrayList<User>();
    List<User> allUsers=totalUsers();

    Team team=new Team(teamName,"gfff");

    teamRepository.save(team);

    redirectAttrs.addAttribute("uid", userId);
    return "redirect:team_management";
  }

  @PostMapping(value = "/saveTeam")
  public String saveTeams(RedirectAttributes redirectAttrs,@ModelAttribute String teamSelect){
    
    System.out.println("anuj randi : "+ teamSelect);


    redirectAttrs.addAttribute("uid", userId);
    return "redirect:team_management";
  }

  private List<User> totalUsers(){
    List<User> users =  userRepository.findAll();
    return users;
  }

  private List<Team> totalTeams(){
    List<Team> teams=teamRepository.findAll();
    return teams;
  }


}
