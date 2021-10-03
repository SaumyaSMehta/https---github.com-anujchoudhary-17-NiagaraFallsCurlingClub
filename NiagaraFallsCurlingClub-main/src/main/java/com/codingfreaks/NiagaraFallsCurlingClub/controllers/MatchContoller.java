package com.codingfreaks.NiagaraFallsCurlingClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.User;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Match.Match;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Match.Round;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.MatchRepository;
import com.codingfreaks.NiagaraFallsCurlingClub.repositories.UserRepository;

@Controller
public class MatchContoller {
  private String userId;


  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MatchRepository matchRepository;

    

  @RequestMapping(value="/matches",method = RequestMethod.GET)
  public String matches(Model model,RedirectAttributes redirectAttrs,@RequestParam("uid") String uid){
    List<Round> listRound=new ArrayList<Round>();

    listRound.add(new Round(1, 5, 10));
    listRound.add(new Round(2,9,7));
    listRound.add(new Round(3, 4, 1));

    Match match=new Match("tournamentID","61513400ea57383872890b1e","615234ff9e33af1dc97d1f1b","61513400ea57383872890b1e",10,9,listRound);

    User user1=userFound(match.getUser1Id());
    System.out.println(user1.getFirstName());

    User user2=userFound(match.getUser2Id());
    System.out.println(user2.getFirstName());

    int winnerInt=winnerUser(match.getUser1Score(), match.getUser2Score());

    model.addAttribute("user1Name", user1.getFirstName());
    model.addAttribute("user2Name", user2.getFirstName());
    model.addAttribute("user1Score", match.getUser1Score());
    model.addAttribute("user2Score", match.getUser2Score());
    if(winnerInt==1){model.addAttribute("winner",user1.getFirstName());}
    else{model.addAttribute("winner",user2.getFirstName());}
    model.addAttribute("listRound", match.getRoundList());
      
    model.addAttribute("userid",uid);
    userId=uid;

    matchRepository.save(match);

    

    System.out.println("Match controller id received ~~~~~ "+userId);

    return "views/match.html";
  }

  public User userFound(String uid){
    User user =  userRepository.findById(uid).orElse(null);
    return user;
  }

  public int winnerUser(int user1score,int user2Score){
    if(user1score>user2Score){
      return 1;
    }
    else{
      return 2;
    }
  }
}
