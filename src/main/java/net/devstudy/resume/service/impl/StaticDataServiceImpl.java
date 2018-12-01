package net.devstudy.resume.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import net.devstudy.resume.entity.Hobby;
import net.devstudy.resume.model.LanguageLevel;
import net.devstudy.resume.model.LanguageType;
import net.devstudy.resume.service.StaticDataService;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Service
public class StaticDataServiceImpl implements StaticDataService {

	@Value("${practic.years.ago}")
	private int practicYearsAgo;

	@Value("${education.years.ago}")
	private int educationYearsAgo;
	
	@Value("${course.years.ago}")
	private int courseYearsAgo;

	private final Set<Hobby> allHobbies;
	
	private final Set<String> allHobbyNames;

	public StaticDataServiceImpl() {
		super();
		this.allHobbies    = Collections.unmodifiableSet(createAllHobbiesSet());
		this.allHobbyNames = Collections.unmodifiableSet(createAllHobbiNamesSet());
	}

	protected Set<Hobby> createAllHobbiesSet() {
		return new TreeSet<>(Arrays.asList(new Hobby[] { new HobbyReadOnlyEntity("Cycling"), new HobbyReadOnlyEntity("Handball"), new HobbyReadOnlyEntity("Football"), new HobbyReadOnlyEntity("Basketball"),
				new HobbyReadOnlyEntity("Bowling"), new HobbyReadOnlyEntity("Boxing"), new HobbyReadOnlyEntity("Volleyball"), new HobbyReadOnlyEntity("Baseball"), new HobbyReadOnlyEntity("Skating"),
				new HobbyReadOnlyEntity("Skiing"), new HobbyReadOnlyEntity("Table tennis"), new HobbyReadOnlyEntity("Tennis"), new HobbyReadOnlyEntity("Weightlifting"),
				new HobbyReadOnlyEntity("Automobiles"), new HobbyReadOnlyEntity("Book reading"), new HobbyReadOnlyEntity("Cricket"), new HobbyReadOnlyEntity("Photo"),
				new HobbyReadOnlyEntity("Shopping"), new HobbyReadOnlyEntity("Cooking"), new HobbyReadOnlyEntity("Codding"), new HobbyReadOnlyEntity("Animals"), new HobbyReadOnlyEntity("Traveling"),
				new HobbyReadOnlyEntity("Movie"), new HobbyReadOnlyEntity("Painting"), new HobbyReadOnlyEntity("Darts"), new HobbyReadOnlyEntity("Fishing"), new HobbyReadOnlyEntity("Kayak slalom"),
				new HobbyReadOnlyEntity("Games of chance"), new HobbyReadOnlyEntity("Ice hockey"), new HobbyReadOnlyEntity("Roller skating"), new HobbyReadOnlyEntity("Swimming"),
				new HobbyReadOnlyEntity("Diving"), new HobbyReadOnlyEntity("Golf"), new HobbyReadOnlyEntity("Shooting"), new HobbyReadOnlyEntity("Rowing"), new HobbyReadOnlyEntity("Camping"),
				new HobbyReadOnlyEntity("Archery"), new HobbyReadOnlyEntity("Pubs"), new HobbyReadOnlyEntity("Music"), new HobbyReadOnlyEntity("Computer games"), new HobbyReadOnlyEntity("Authorship"),
				new HobbyReadOnlyEntity("Singing"), new HobbyReadOnlyEntity("Foreign lang"), new HobbyReadOnlyEntity("Billiards"), new HobbyReadOnlyEntity("Skateboarding"),
				new HobbyReadOnlyEntity("Collecting"), new HobbyReadOnlyEntity("Badminton"), new HobbyReadOnlyEntity("Disco") }));
	}

	protected Set<String> createAllHobbiNamesSet() {
		Set<String> set = new HashSet<>();
		for (Hobby h : allHobbies) {
			set.add(h.getName());
		}
		return set;
	}

	@Override
	public Set<Hobby> listAllHobbies() {
		return allHobbies;
	}

	@Override
	public List<Hobby> createHobbyEntitiesByNames(List<String> names) {
		List<Hobby> result = new ArrayList<>(names.size());
		for (String name : names) {
			if (allHobbyNames.contains(name)) {
				result.add(new Hobby(name));
			}
		}
		return result;
	}

	@Override
	public List<Integer> listEducationYears() {
		return listYears(educationYearsAgo);
	}

	@Override
	public List<Integer> listPracticsYears() {
		return listYears(practicYearsAgo);
	}
	
	@Override
	public List<Integer> listCourcesYears() {
		return listYears(practicYearsAgo);
	}

	protected List<Integer> listYears(int count) {
		List<Integer> years = new ArrayList<>();
		int now = DateTime.now().getYear();
		for (int i = 0; i < count; i++) {
			years.add(now - i);
		}
		return years;
	}

	@Override
	public Map<Integer, String> mapMonths() {
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		Map<Integer, String> map = new LinkedHashMap<>();
		for (int i = 0; i < months.length; i++) {
			map.put(i + 1, months[i]);
		}
		return map;
	}
	
	@Override
	public Collection<LanguageType> getAllLanguageTypes() {
		return EnumSet.allOf(LanguageType.class);
	}
	
	@Override
	public Collection<LanguageLevel> getAllLanguageLevels() {
		return EnumSet.allOf(LanguageLevel.class);
	}
	
	/**
	 * This class contains logic to prevent any Hobby instance changes
	 * 
	 * @author devstudy
	 * @see http://devstudy.net
	 */
	protected static final class HobbyReadOnlyEntity extends Hobby {
		private static final long serialVersionUID = 1480761757121979601L;

		protected HobbyReadOnlyEntity(String name) {
			super(name);
		}

		@Override
		public void setName(String name) {
			throw new UnsupportedOperationException("This hobby instance is readonly instance!");
		}

		@Override
		public void setSelected(boolean selected) {
			throw new UnsupportedOperationException("This hobby instance is readonly instance!");
		}
	}
}
