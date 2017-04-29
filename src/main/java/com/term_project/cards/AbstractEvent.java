package com.term_project.cards;
import com.term_project.character.GameChar;
import com.term_project.game.Stats;

import java.util.List;
import java.util.ArrayList;

/*what pretty much all events need*/
public abstract class AbstractEvent implements Event {
	private String name;
	private String description;
	private List<Stats> usable;
	public AbstractEvent(String name, String description, List<Stats> usable) {
		this.name = name;
		this.description = description;
		this.usable = usable;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public List<Stats> getUsable() {
		return usable;
	}

	@Override
	public List<String> getUsableAsString() {
		List<String> usableString = new ArrayList<>();
		for(Stats stat : usable) {
			if (stat == Stats.MIGHT) {
				usableString.add("might");
			} else if (stat == Stats.SPEED) {
				usableString.add("speed");
			} else if (stat == Stats.SANITY) {
				usableString.add("sanity");
			} else if (stat == Stats.KNOWLEGE) {
				usableString.add("knowlege");
			}
		}
		return usableString;
	}
}
