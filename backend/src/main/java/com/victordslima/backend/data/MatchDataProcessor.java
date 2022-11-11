package com.victordslima.backend.data;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import com.victordslima.backend.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

  private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

  @Override
  public Match process(final MatchInput matchInput) throws Exception {

    Match match = new Match();

    match.setId(Long.parseLong(matchInput.getId()));
    match.setCity(matchInput.getCity());

    match.setDate(LocalDate.parse(matchInput.getDate()));

    match.setPlayerOfMatch(matchInput.getPlayer_of_match());
    match.setVenue(matchInput.getVenue());

    String firstInningsTeam, seconInningsTeam;

    if ("bat".equals(matchInput.getToss_decision())) {
        firstInningsTeam = matchInput.getToss_winner();
        seconInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())
         ? matchInput.getTeam2() : matchInput.getTeam1();
    } else {
        seconInningsTeam = matchInput.getToss_winner();
        firstInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())
         ? matchInput.getTeam2() : matchInput.getTeam1();
    }
    match.setTeam1(firstInningsTeam);
    match.setTeam2(seconInningsTeam);

    match.setTossWinner(matchInput.getToss_winner());
    match.setTossDecision(matchInput.getToss_decision());
    match.setResult(matchInput.getResult());
    match.setResultMargin(matchInput.getResult_margin());
    match.setUmpire1(matchInput.getUmpire1());
    match.setUmpire2(matchInput.getUmpire2());

    return match;

  }

}