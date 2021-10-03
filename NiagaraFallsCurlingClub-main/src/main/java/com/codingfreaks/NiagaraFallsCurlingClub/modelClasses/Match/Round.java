package com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Match;

public class Round {
  
  private int roundNo,user1Score,user2Score;

  public Round(int roundNo, int user1Score, int user2Score) {
    this.roundNo = roundNo;
    this.user1Score = user1Score;
    this.user2Score = user2Score;
  }

  public int getRoundNo() {
    return roundNo;
  }

  public void setRoundNo(int roundNo) {
    this.roundNo = roundNo;
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

  


}
