package com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Match;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Match.Round;

@Document(collection="tblMatches")
public class Match {

  @MongoId(FieldType.OBJECT_ID)
  private String matchId;
  private String tournamentId,user1Id,user2Id,winnerId;
  private int user1Score,user2Score;
  private List<Round> roundList; 
    
public Match(){

}

public Match(String tournamentId, String user1Id, String user2Id, String winnerId, int user1Score,
    int user2Score, List<Round> roundList) {
  this.tournamentId = tournamentId;
  this.user1Id = user1Id;
  this.user2Id = user2Id;
  this.winnerId = winnerId;
  this.user1Score = user1Score;
  this.user2Score = user2Score;
  this.roundList = roundList;
}

public String getMatchId() {
  return matchId;
}

public void setMatchId(String matchId) {
  this.matchId = matchId;
}

public String getTournamentId() {
  return tournamentId;
}

public void setTournamentId(String tournamentId) {
  this.tournamentId = tournamentId;
}

public String getUser1Id() {
  return user1Id;
}

public void setUser1Id(String user1Id) {
  this.user1Id = user1Id;
}

public String getUser2Id() {
  return user2Id;
}

public void setUser2Id(String user2Id) {
  this.user2Id = user2Id;
}

public String getWinnerId() {
  return winnerId;
}

public void setWinnerId(String winnerId) {
  this.winnerId = winnerId;
}

public int getUser1Score() {
  return user1Score;
}

public void setUser1Score(int user1Score) {
  this.user1Score = user1Score;
}

public int getUser2Score() {
  return user2Score;
}

public void setUser2Score(int user2Score) {
  this.user2Score = user2Score;
}

public List<Round> getRoundList() {
  return roundList;
}

public void setRoundList(List<Round> roundList) {
  this.roundList = roundList;
}





}
