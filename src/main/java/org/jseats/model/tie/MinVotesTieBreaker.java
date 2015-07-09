/**
 * $Id$
 * @author mmiranda
 * @date   26/1/2015 10:31:30
 *
 * Copyright (C) 2015 Scytl Secure Electronic Voting SA
 *
 * All rights reserved.
 *
 */

package org.jseats.model.tie;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.jseats.model.Candidate;

public class MinVotesTieBreaker extends BaseTieBreaker {

	@Override
	public String getName() {
		return "MinVotes Tie Breaker";
	}

	@Override
	public TieScenario innerBreakTie(List<Candidate> candidates) {
		
		final Comparator<Candidate> candidateComparator = (c1, c2) -> Integer.compare(c1.getVotes(), c2.getVotes());
		
		int maxVotes = candidates.stream().min(candidateComparator).get().getVotes();
		List<Candidate> untiedCandidates = candidates.stream().filter(candidate -> candidate.getVotes() == maxVotes).collect(Collectors.toList());
		
		if(untiedCandidates.size() == 1){
			return new TieScenario(untiedCandidates, TieScenario.SOLVED);
		} else {
			return new TieScenario(untiedCandidates, TieScenario.TIED);
		}
	}
}
