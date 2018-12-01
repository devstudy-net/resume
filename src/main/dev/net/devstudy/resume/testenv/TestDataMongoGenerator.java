package net.devstudy.resume.testenv;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import net.coobird.thumbnailator.Thumbnails;
import net.devstudy.resume.model.LanguageLevel;
import net.devstudy.resume.model.LanguageType;

/**
 * 
 * Please add postgresql JDBC driver to classpath before launch this generator
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class TestDataMongoGenerator {

	private static final String MONGO_URL = "localhost";
	private static final int   MONGO_PORT = 27017;
	private static final String MONGO_DB  = "resume";

	private static final String PHOTO_PATH = "external/test-data/photos/";
	private static final String CERTIFICATES_PATH = "external/test-data/certificates/";
	private static final String MEDIA_DIR = "D:/eclipse/workspace/resume-mongo/src/main/webapp/media";
	private static final String COUTRY = "Ukraine";
	private static final String[] CITIES = { "Kharkiv", "Kiyv", "Odessa" };
	private static final String[] FOREGIN_LANGUAGES = { "Spanish", "French", "German", "Italian" };
	private static final String PASSWORD_HASH = "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq";

	private static final String[] HOBBIES = { "Cycling", "Handball", "Football", "Basketball", "Bowling", "Boxing", "Volleyball", "Baseball", "Skating", "Skiing", "Table tennis", "Tennis",
			"Weightlifting", "Automobiles", "Book reading", "Cricket", "Photo", "Shopping", "Cooking", "Codding", "Animals", "Traveling", "Movie", "Painting", "Darts", "Fishing", "Kayak slalom",
			"Games of chance", "Ice hockey", "Roller skating", "Swimming", "Diving", "Golf", "Shooting", "Rowing", "Camping", "Archery", "Pubs", "Music", "Computer games", "Authorship", "Singing",
			"Foreign lang", "Billiards", "Skateboarding", "Collecting", "Badminton", "Disco" };

	private static List<LanguageType> languageTypes = new ArrayList<>(EnumSet.allOf(LanguageType.class));
	private static List<LanguageLevel> languageLevels = new ArrayList<>(EnumSet.allOf(LanguageLevel.class));
	// Test sentences for content generation
	private static final String DUMMY_CONTENT_TEXT = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc nonummy metus. Vestibulum volutpat pretium libero. Cras id dui. Aenean ut eros et nisl sagittis vestibulum. Nullam nulla eros, ultricies sit amet, nonummy id, imperdiet feugiat, pede. Sed lectus. Donec mollis hendrerit risus. Phasellus nec sem in justo pellentesque facilisis. Etiam imperdiet imperdiet orci. Nunc nec neque. Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi. Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada. Praesent congue erat at massa. Sed cursus turpis vitae tortor. Donec posuere vulputate arcu. Phasellus accumsan cursus velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed aliquam, nisi quis porttitor congue, elit erat euismod orci, ac placerat dolor lectus quis orci. Phasellus consectetuer vestibulum elit. Aenean tellus metus, bibendum sed, posuere ac, mattis non, nunc. Vestibulum fringilla pede sit amet augue. In turpis. Pellentesque posuere. Praesent turpis. Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Donec elit libero, sodales nec, volutpat a, suscipit non, turpis. Nullam sagittis. Suspendisse pulvinar, augue ac venenatis condimentum, sem libero volutpat nibh, nec pellentesque velit pede quis nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Fusce id purus. Ut varius tincidunt libero. Phasellus dolor. Maecenas vestibulum mollis diam. Pellentesque ut neque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In dui magna, posuere eget, vestibulum et, tempor auctor, justo. In ac felis quis tortor malesuada pretium. Pellentesque auctor neque nec urna. Proin sapien ipsum, porta a, auctor quis, euismod ut, mi. Aenean viverra rhoncus pede. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Ut non enim eleifend felis pretium feugiat. Vivamus quis mi. Phasellus a est. Phasellus magna. In hac habitasse platea dictumst. Curabitur at lacus ac velit ornare lobortis. Curabitur a felis in nunc fringilla tristique. Morbi mattis ullamcorper velit. Phasellus gravida semper nisi. Nullam vel sem. Pellentesque libero tortor, tincidunt et, tincidunt eget, semper nec, quam. Sed hendrerit. Morbi ac felis. Nunc egestas, augue at pellentesque laoreet, felis eros vehicula leo, at malesuada velit leo quis pede. Donec interdum, metus et hendrerit aliquet, dolor diam sagittis ligula, eget egestas libero turpis vel mi. Nunc nulla. Fusce risus nisl, viverra et, tempor et, pretium in, sapien. Donec venenatis vulputate lorem. Morbi nec metus. Phasellus blandit leo ut odio. Maecenas ullamcorper, dui et placerat feugiat, eros pede varius nisi, condimentum viverra felis nunc et lorem. Sed magna purus, fermentum eu, tincidunt eu, varius ut, felis. In auctor lobortis lacus. Quisque libero metus, condimentum nec, tempor a, commodo mollis, magna. Vestibulum ullamcorper mauris at ligula. Fusce fermentum. Nullam cursus lacinia erat. Praesent blandit laoreet nibh. Fusce convallis metus id felis luctus adipiscing. Pellentesque egestas, neque sit amet convallis pulvinar, justo nulla eleifend augue, ac auctor orci leo non est. Quisque id mi. Ut tincidunt tincidunt erat. Etiam feugiat lorem non metus. Vestibulum dapibus nunc ac augue. Curabitur vestibulum aliquam leo. Praesent egestas neque eu enim. In hac habitasse platea dictumst. Fusce a quam. Etiam ut purus mattis mauris sodales aliquam. Curabitur nisi. Quisque malesuada placerat nisl. Nam ipsum risus, rutrum vitae, vestibulum eu, molestie vel, lacus. Sed augue ipsum, egestas nec, vestibulum et, malesuada adipiscing, dui. Vestibulum facilisis, purus nec pulvinar iaculis, ligula mi congue nunc, vitae euismod ligula urna in dolor. Mauris sollicitudin fermentum libero. Praesent nonummy mi in odio. Nunc interdum lacus sit amet orci. Vestibulum rutrum, mi nec elementum vehicula, eros quam gravida nisl, id fringilla neque ante vel mi. Morbi mollis tellus ac sapien. Phasellus volutpat, metus eget egestas mollis, lacus lacus blandit dui, id egestas quam mauris ut lacus. Fusce vel dui. Sed in libero ut nibh placerat accumsan. Proin faucibus arcu quis ante. In consectetuer turpis ut velit. Nulla sit amet est. Praesent metus tellus, elementum eu, semper a, adipiscing nec, purus. Cras risus ipsum, faucibus ut, ullamcorper id, varius ac, leo. Suspendisse feugiat. Suspendisse enim turpis, dictum sed, iaculis a, condimentum nec, nisi. Praesent nec nisl a purus blandit viverra. Praesent ac massa at ligula laoreet iaculis. Nulla neque dolor, sagittis eget, iaculis quis, molestie non, velit. Mauris turpis nunc, blandit et, volutpat molestie, porta ut, ligula. Fusce pharetra convallis urna. Quisque ut nisi. Donec mi odio, faucibus at, scelerisque quis, convallis in, nisi. ";
	private static final List<String> SENTENCES;

	static {
		String[] sentences = DUMMY_CONTENT_TEXT.split("\\.");
		List<String> sentencesList = new ArrayList<>(sentences.length);
		for (String sentence : sentences) {
			sentence = sentence.trim();
			if (sentence.length() > 0) {
				sentencesList.add(sentence + ".");
			}
		}
		SENTENCES = Collections.unmodifiableList(sentencesList);
	}

	private static final Random r = new Random();
	//private static int idProfile = 0;
	private static Date birthDay = null;

	public static void main(String[] args) throws Exception {
		clearMedia();
		List<Certificate> certificates = loadCertificates();
		List<Profile> profiles = loadProfiles();
		List<ProfileConfig> profileConfigs = getProfileConfigs();
		MongoClient mongo = null;
		try {
			mongo = new MongoClient(MONGO_URL, MONGO_PORT);
			clearDb(mongo);
			Map<String, Integer> map = insertSkillCategories(mongo);
			for (Profile p : profiles) {
				ProfileConfig profileConfig = profileConfigs.get(r.nextInt(profileConfigs.size()));
				createProfile(mongo, p, profileConfig, map, certificates);
				System.out.println("Created profile for " + p.firstName + " " + p.lastName);
			}
			createProfileIndexes(mongo);
			createRememberMeTokenIndexes(mongo);
			System.out.println("Data generated successful");
		} finally {
			if(mongo != null) {
				mongo.close();
			}
		}
	}

	private static void clearMedia() throws IOException {
		if (Files.exists(Paths.get(MEDIA_DIR))) {
			Files.walkFileTree(Paths.get(MEDIA_DIR), new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					Files.delete(dir);
					return FileVisitResult.CONTINUE;
				}
			});
		}
		System.out.println("Media dir cleared");
	}
	
	private static DB getDb(MongoClient mongo) {
		return mongo.getDB(MONGO_DB);
	}

	private static void clearDb(MongoClient mongo) throws SQLException {
		getDb(mongo).getCollection("profile").drop();
		getDb(mongo).getCollection("skillCategory").drop();
		getDb(mongo).getCollection("rememberMeToken").drop();
		System.out.println("Db cleared");
	}

	private static List<Profile> loadProfiles() {
		File[] photos = new File(PHOTO_PATH).listFiles();
		if(photos == null) {
			throw new IllegalArgumentException(PHOTO_PATH+" not found");
		}
		List<Profile> list = new ArrayList<>(photos.length);
		for (File f : photos) {
			String[] names = f.getName().replace(".jpg", "").split(" ");
			list.add(new Profile(names[0], names[1], f.getAbsolutePath()));
		}
		Collections.sort(list, new Comparator<Profile>() {
			@Override
			public int compare(Profile o1, Profile o2) {
				int firstNameCompare = o1.firstName.compareTo(o2.firstName);
				if (firstNameCompare != 0) {
					return firstNameCompare;
				} else {
					return o1.lastName.compareTo(o2.lastName);
				}
			}
		});
		return list;
	}

	private static List<Certificate> loadCertificates() {
		File[] files = new File(CERTIFICATES_PATH).listFiles();
		if(files == null) {
			throw new IllegalArgumentException(CERTIFICATES_PATH+" not found");
		}
		List<Certificate> list = new ArrayList<>(files.length);
		for (File f : files) {
			String name = f.getName().replace("-", " ");
			name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
			list.add(new Certificate(name, f.getAbsolutePath()));
		}
		return list;
	}
	
	private static void putList(BasicDBObject p, String name, BasicDBList list) {
		if (list != null && !list.isEmpty()) {
			p.put(name, list);
		}
	}

	private static void createProfile(MongoClient mongo, Profile profile, ProfileConfig profileConfig, Map<String, Integer> map, List<Certificate> certificates) throws SQLException, IOException {
		BasicDBObject p = insertProfileData(mongo, profile, profileConfig);
		if (profileConfig.certificates > 0) {
			putList(p, "certificates", insertCertificates(mongo, profileConfig.certificates, certificates));
		}
		putList(p, "education", insertEducation(mongo));
		putList(p, "hobbies", 	insertHobbies(mongo));
		putList(p, "languages", insertLanguages(mongo));
		putList(p, "practics", 	insertPractics(mongo, profileConfig));
		putList(p, "skills", 	insertSkills(mongo, map, profileConfig));
		putList(p, "courses", 	insertCourses(mongo));
		getDb(mongo).getCollection("profile").insert(p);
	}
	
	private static void createProfileIndexes(MongoClient mongo){
		getDb(mongo).getCollection("profile").createIndex(new BasicDBObject("email", 1), "email_idx", true);
		getDb(mongo).getCollection("profile").createIndex(new BasicDBObject("phone", 1), "phone_idx", true);
		getDb(mongo).getCollection("profile").createIndex(new BasicDBObject("uid", 1), "uid_idx", true);
		getDb(mongo).getCollection("profile").createIndex(new BasicDBObject("completed", 1), "completed_idx", false);
		getDb(mongo).getCollection("profile").createIndex(new BasicDBObject("created", 1), "created_idx", false);
		
		getDb(mongo).getCollection("profileRestore").createIndex(new BasicDBObject("token", 1), "token_idx", true);
		
		System.out.println("Indexes created for profile collection");
	}
	
	private static void createRememberMeTokenIndexes(MongoClient mongo){
		getDb(mongo).getCollection("rememberMeToken").createIndex(new BasicDBObject("series", 1), "series_idx", true);
		getDb(mongo).getCollection("rememberMeToken").createIndex(new BasicDBObject("username", 1), "username_idx", false);
		System.out.println("Indexes created for rememberMeToken collection");
	}

	private static BasicDBList insertSkills(MongoClient mongo, Map<String, Integer> map, ProfileConfig profileConfig) throws SQLException {
		BasicDBList list = new BasicDBList();
		Map<String, Set<String>> skillMap = createSkillMap();
		for (Course course : profileConfig.courses) {
			for (String key : skillMap.keySet()) {
				skillMap.get(key).addAll(course.skills.get(key));
			}
		}
		for (Map.Entry<String, Set<String>> entry : skillMap.entrySet()) {
			if (!entry.getValue().isEmpty()) {
				BasicDBObject o = new BasicDBObject();
				o.put("idCategory", map.get(entry.getKey()));
				o.put("category", entry.getKey());
				o.put("value", StringUtils.join(entry.getValue().toArray(), ", "));
				list.add(o);
			}
		}
		return list;
	}

	private static BasicDBList insertPractics(MongoClient mongo, ProfileConfig profileConfig) throws SQLException {
		BasicDBList list = new BasicDBList();
		boolean currentCourse = r.nextBoolean();
		Date finish = addField(new Date(System.currentTimeMillis()), Calendar.MONTH, -(r.nextInt(3) + 1), false);
		
		for (Course course : profileConfig.courses) {
			BasicDBObject o = new BasicDBObject();
			o.put("position", course.name);
			o.put("company", course.company);
			if (currentCourse) {
				o.put("beginDate", addField(new Date(System.currentTimeMillis()), Calendar.MONTH, -1, false));
			} else {
				o.put("beginDate", addField(finish, Calendar.MONTH, -1, false));
				o.put("finishDate", finish);
				finish = addField(finish, Calendar.MONTH, -(r.nextInt(3) + 1), false);
			}
			o.put("responsibilities", course.responsibilities);
			o.put("demo", course.demo);
			o.put("github", course.github);
			list.add(o);
		}
		return list;
	}

	private static BasicDBList insertLanguages(MongoClient mongo) throws SQLException {
		List<String> languages = new ArrayList<>();
		languages.add("English");
		if (r.nextBoolean()) {
			int cnt = r.nextInt(1) + 1;
			List<String> otherLng = new ArrayList<>(Arrays.asList(FOREGIN_LANGUAGES));
			Collections.shuffle(otherLng);
			for (int i = 0; i < cnt; i++) {
				languages.add(otherLng.remove(0));
			}
		}
		BasicDBList list = new BasicDBList();
		
		for (String language : languages) {
			LanguageType langType = languageTypes.get(r.nextInt(languageTypes.size()));
			LanguageLevel langLevel = languageLevels.get(r.nextInt(languageLevels.size()));
			BasicDBObject o = new BasicDBObject();
			
			o.put("name", language);
			o.put("level", langLevel.getDbValue());
			o.put("type", langType.getDbValue());
			list.add(o);
			if (langType != LanguageType.ALL) {
				o = new BasicDBObject();
				o.put("name", language);
				LanguageLevel newLangLevel = languageLevels.get(r.nextInt(languageLevels.size()));
				while (newLangLevel == langLevel) {
					newLangLevel = languageLevels.get(r.nextInt(languageLevels.size()));
				}
				o.put("level", langLevel.getDbValue());
				o.put("type", langType.getReverseType().getDbValue());
				list.add(o);
			}
		}
		return list;
	}

	private static BasicDBList insertHobbies(MongoClient mongo) throws SQLException {
		BasicDBList list = new BasicDBList();
		List<String> hobbies = new ArrayList<>(Arrays.asList(HOBBIES));
		Collections.shuffle(hobbies);
		for (int i = 0; i < 5; i++) {
			list.add(new BasicDBObject("name", hobbies.remove(0)));
		}
		return list;
	}

	private static BasicDBList insertEducation(MongoClient mongo) throws SQLException {
		BasicDBList list = new BasicDBList();
		BasicDBObject o = new BasicDBObject();
		o.put("summary", "The specialist degree in Electronic Engineering");
		Date finish = randomFinishEducation();
		Date begin = addField(finish, Calendar.YEAR, -5, true);
		o.put("beginYear", new DateTime(begin).getYear());
		if (finish.getTime() <= System.currentTimeMillis()) {
			o.put("finishYear", new DateTime(finish).getYear());
		} 
		o.put("university", "Kharkiv National Technical University, Ukraine");
		o.put("faculty", "Computer Science");
		list.add(o);
		return list;
	}

	private static Date addField(Date finish, int field, int value, boolean isBeginEducation) {
		Calendar cl = Calendar.getInstance();
		cl.setTimeInMillis(finish.getTime());
		cl.add(field, value);
		if (isBeginEducation) {
			cl.set(Calendar.DAY_OF_MONTH, 1);
			cl.set(Calendar.MONTH, Calendar.SEPTEMBER);
		}
		return new Date(cl.getTimeInMillis());
	}

	private static Date randomFinishEducation() {
		Calendar cl = Calendar.getInstance();
		cl.setTimeInMillis(birthDay.getTime());
		cl.set(Calendar.DAY_OF_MONTH, 30);
		cl.set(Calendar.MONTH, Calendar.JUNE);
		int year = cl.get(Calendar.YEAR) + 21;
		cl.set(Calendar.YEAR, year + r.nextInt(3));
		return new Date(cl.getTimeInMillis());
	}

	private static BasicDBList insertCourses(MongoClient mongo) throws SQLException {
		if (r.nextBoolean()) {
			BasicDBList list = new BasicDBList();
			BasicDBObject o = new BasicDBObject();
			o.put("name", "Java Advanced Course");
			o.put("school", "SourceIt");
			Date finish = randomFinishEducation();
			if (finish.getTime() <= System.currentTimeMillis()) {
				o.put("finish_date", finish);
			}
			list.add(o);
			return list;
		}
		return null;
	}

	private static BasicDBList insertCertificates(MongoClient mongo, int certificatesCount, List<Certificate> certificates) throws SQLException, IOException {
		Collections.shuffle(certificates);
		BasicDBList list = new BasicDBList();
		for (int i = 0; i < certificatesCount && i < certificates.size(); i++) {
			Certificate certificate = certificates.get(i);
			BasicDBObject o = new BasicDBObject();
			o.put("name", certificate.name);
			String uid = UUID.randomUUID().toString() + ".jpg";
			File photo = new File(MEDIA_DIR + "/certificates/" + uid);
			if (!photo.getParentFile().exists()) {
				photo.getParentFile().mkdirs();
			}
			Files.copy(Paths.get(certificate.largeImg), Paths.get(photo.getAbsolutePath()));
			o.put("largeUrl","/media/certificates/" + uid);
			String smallUid = uid.replace(".jpg", "-sm.jpg");
			Thumbnails.of(photo).size(100, 100).toFile(photo.getAbsolutePath().replace(".jpg", "-sm.jpg"));
			o.put("smallUrl","/media/certificates/" + smallUid);
			list.add(o);
		}
		return list;
	}

	private static String getInfo() {
		int endIndex = r.nextInt(SENTENCES.size())+1;
		int startIndex = r.nextInt(endIndex);
		if (endIndex - startIndex > 4) {
			endIndex = startIndex + 3;
		}
		return StringUtils.join(SENTENCES.subList(startIndex, endIndex), " ");
	}

	private static BasicDBObject insertProfileData(MongoClient mongo, Profile profile, ProfileConfig profileConfig) throws SQLException, IOException {
		BasicDBObject p = new BasicDBObject();
		p.put("uid", (profile.firstName + "-" + profile.lastName).toLowerCase());
		p.put("firstName", profile.firstName);
		p.put("lastName", profile.lastName);
		birthDay = randomBirthDate();
		p.put("birthDay", birthDay);
		p.put("phone", generatePhone());
		p.put("email", (profile.firstName + "-" + profile.lastName).toLowerCase() + "@gmail.com");
		p.put("country", COUTRY);
		p.put("city", CITIES[r.nextInt(CITIES.length)]);
		p.put("objective", profileConfig.objective);
		p.put("summary", profileConfig.summary);
		String uid = UUID.randomUUID().toString() + ".jpg";
		File photo = new File(MEDIA_DIR + "/avatars/" + uid);
		if (!photo.getParentFile().exists()) {
			photo.getParentFile().mkdirs();
		}
		Files.copy(Paths.get(profile.photo), Paths.get(photo.getAbsolutePath()));
		p.put("largePhoto", "/media/avatars/" + uid);
		String smallUid = uid.replace(".jpg", "-sm.jpg");
		Thumbnails.of(photo).size(110, 110).toFile(new File(MEDIA_DIR + "/avatars/" + smallUid));
		p.put("smallPhoto", "/media/avatars/" + smallUid);
		if (r.nextBoolean()) {
			p.put("info", getInfo());
		}
		p.put("password", PASSWORD_HASH);
		p.put("created", new Timestamp(System.currentTimeMillis()));
		BasicDBObject contacts = new BasicDBObject();
		p.put("contacts", contacts);
		if (r.nextBoolean()) {
			contacts.put("skype", (profile.firstName + "-" + profile.lastName).toLowerCase());
		}
		if (r.nextBoolean()) {
			contacts.put("vkontakte", "https://vk.com/" + (profile.firstName + "-" + profile.lastName).toLowerCase());
		} 
		if (r.nextBoolean()) {
			contacts.put("facebook", "https://facebook.com/" + (profile.firstName + "-" + profile.lastName).toLowerCase());
		} 
		if (r.nextBoolean()) {
			contacts.put("linkedin", "https://linkedin.com/" + (profile.firstName + "-" + profile.lastName).toLowerCase());
		} 
		if (r.nextBoolean()) {
			contacts.put("github", "https://github.com/" + (profile.firstName + "-" + profile.lastName).toLowerCase());
		} 
		if (r.nextBoolean()) {
			contacts.put("stackoverflow", "https://stackoverflow.com/" + (profile.firstName + "-" + profile.lastName).toLowerCase());
		} 
		//idProfile++;
		p.put("completed", Boolean.TRUE);
		return p;
	}

	private static Map<String, Integer> insertSkillCategories(MongoClient mongo) throws SQLException {
		Map<String, Set<String>> categories = createSkillMap();
		DBCollection collection = getDb(mongo).getCollection("skillCategory");
		int id = 1;
		Map<String, Integer> map = new HashMap<>();
		for (String category : categories.keySet()) {
			BasicDBObject document = new BasicDBObject();
			map.put(category, id);
			document.put("idCategory", id++);
			document.put("category", category);
			collection.insert(document);
		}
		return map;
	}

	private static String generatePhone() {
		StringBuilder phone = new StringBuilder("+38050");
		for (int i = 0; i < 7; i++) {
			int code = '1' + r.nextInt(9);
			phone.append(((char) code));
		}
		return phone.toString();
	}

	private static Date randomBirthDate() {
		Calendar cl = Calendar.getInstance();
		cl.set(Calendar.DAY_OF_MONTH, r.nextInt(30));
		cl.set(Calendar.MONTH, r.nextInt(12));
		int year = cl.get(Calendar.YEAR) - 30;
		cl.set(Calendar.YEAR, year + r.nextInt(10));
		return new Date(cl.getTimeInMillis());
	}

	private static List<ProfileConfig> getProfileConfigs() {
		List<ProfileConfig> res = new ArrayList<>();
		res.add(new ProfileConfig("Junior java trainee position", "Java core course with developing one simple console application", new Course[] { Course.createCoreCourse() }, 0));
		res.add(new ProfileConfig("Junior java trainee position", "One Java professional course with developing web application blog (Link to demo is provided)",
				new Course[] { Course.createBaseCourse() }, 0));
		res.add(new ProfileConfig("Junior java developer position", "One Java professional course with developing web application resume (Link to demo is provided)",
				new Course[] { Course.createAdvancedCourse() }, 0));
		res.add(new ProfileConfig("Junior java developer position", "One Java professional course with developing web application resume (Link to demo is provided)",
				new Course[] { Course.createAdvancedCourse() }, 1));
		res.add(new ProfileConfig("Junior java developer position", "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
				new Course[] { Course.createAdvancedCourse(), Course.createBaseCourse() }, 1));
		res.add(new ProfileConfig("Junior java developer position", "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
				new Course[] { Course.createAdvancedCourse(), Course.createBaseCourse() }, 1));
		res.add(new ProfileConfig("Junior java developer position", "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
				new Course[] { Course.createAdvancedCourse(), Course.createBaseCourse() }, 1));
		res.add(new ProfileConfig("Junior java developer position", "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
				new Course[] { Course.createAdvancedCourse(), Course.createBaseCourse() }, 2));
		res.add(new ProfileConfig("Junior java developer position",
				"Three Java professional courses with developing one console application and two web applications: blog and resume (Links to demo are provided)",
				new Course[] { Course.createAdvancedCourse(), Course.createBaseCourse(), Course.createCoreCourse() }, 2));
		return res;
	}

	private static Map<String, Set<String>> createSkillMap() {
		Map<String, Set<String>> skills = new LinkedHashMap<>();
		skills.put("Languages", new LinkedHashSet<String>());
		skills.put("DBMS", new LinkedHashSet<String>());
		skills.put("Web", new LinkedHashSet<String>());
		skills.put("Java", new LinkedHashSet<String>());
		skills.put("IDE", new LinkedHashSet<String>());
		skills.put("CVS", new LinkedHashSet<String>());
		skills.put("Web Servers", new LinkedHashSet<String>());
		skills.put("Build system", new LinkedHashSet<String>());
		skills.put("Cloud", new LinkedHashSet<String>());
		return skills;
	}

	/**
	 * 
	 * @author devstudy
	 * @see http://devstudy.net
	 */
	private static final class ProfileConfig {
		private final String objective;
		private final String summary;
		private final Course[] courses;
		private final int certificates;

		private ProfileConfig(String objective, String summary, Course[] courses, int certificates) {
			super();
			this.objective = objective;
			this.summary = summary;
			this.courses = courses;
			this.certificates = certificates;
		}
	}

	/**
	 * 
	 * @author devstudy
	 * @see http://devstudy.net
	 */
	private static final class Profile {
		private final String firstName;
		private final String lastName;
		private final String photo;

		private Profile(String firstName, String lastName, String photo) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.photo = photo;
		}

		@Override
		public String toString() {
			return String.format("Profile [firstName=%s, lastName=%s]", firstName, lastName);
		}
	}

	/**
	 * 
	 * @author devstudy
	 * @see http://devstudy.net
	 */
	private static final class Certificate {
		private final String name;
		private final String largeImg;

		private Certificate(String name, String largeImg) {
			super();
			this.name = name;
			this.largeImg = largeImg;
		}
	}

	/**
	 * 
	 * @author devstudy
	 * @see http://devstudy.net
	 */
	private static final class Course {
		private final String name;
		private final String company;
		private final String github;
		private final String responsibilities;
		private final String demo;
		private final Map<String, Set<String>> skills;

		private Course(String name, String company, String github, String responsibilities, String demo, Map<String, Set<String>> skills) {
			super();
			this.name = name;
			this.company = company;
			this.github = github;
			this.responsibilities = responsibilities;
			this.demo = demo;
			this.skills = skills;
		}

		static Course createCoreCourse() {
			Map<String, Set<String>> skills = createSkillMap();
			skills.get("Languages").add("Java");

			skills.get("DBMS").add("Mysql");

			skills.get("Java").add("Threads");
			skills.get("Java").add("IO");
			skills.get("Java").add("JAXB");
			skills.get("Java").add("GSON");

			skills.get("IDE").add("Eclipse for JEE Developer");

			skills.get("CVS").add("Git");
			skills.get("CVS").add("Github");

			skills.get("Build system").add("Maven");

			return new Course("Java Core Course", "DevStudy.net", null, "Developing the java console application which imports XML, JSON, Properties, CVS to Db via JDBC", null, skills);
		}

		static Course createBaseCourse() {
			Map<String, Set<String>> skills = createSkillMap();
			skills.get("Languages").add("Java");
			skills.get("Languages").add("SQL");

			skills.get("DBMS").add("Postgresql");

			skills.get("Web").add("HTML");
			skills.get("Web").add("CSS");
			skills.get("Web").add("JS");
			skills.get("Web").add("JS");
			skills.get("Web").add("Foundation");
			skills.get("Web").add("JQuery");

			skills.get("Java").add("Servlets");
			skills.get("Java").add("Logback");
			skills.get("Java").add("JSP");
			skills.get("Java").add("JSTL");
			skills.get("Java").add("JDBC");
			skills.get("Java").add("Apache Commons");
			skills.get("Java").add("Google+ Social API");

			skills.get("IDE").add("Eclipse for JEE Developer");

			skills.get("CVS").add("Git");
			skills.get("CVS").add("Github");

			skills.get("Web Servers").add("Tomcat");

			skills.get("Build system").add("Maven");

			skills.get("Cloud").add("OpenShift");

			return new Course("Java Base Course", "DevStudy.net", "https://github.com/TODO",
					"Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
					"http://LINK_TO_DEMO_SITE", skills);
		}

		static Course createAdvancedCourse() {
			Map<String, Set<String>> skills = createSkillMap();
			skills.get("Languages").add("Java");
			skills.get("Languages").add("SQL");
			skills.get("Languages").add("PLSQL");

			skills.get("DBMS").add("Postgresql");

			skills.get("Web").add("HTML");
			skills.get("Web").add("CSS");
			skills.get("Web").add("JS");
			skills.get("Web").add("JS");
			skills.get("Web").add("Bootstrap");
			skills.get("Web").add("JQuery");

			skills.get("Java").add("Spring MVC");
			skills.get("Java").add("Logback");
			skills.get("Java").add("JSP");
			skills.get("Java").add("JSTL");
			skills.get("Java").add("Spring Data JPA");
			skills.get("Java").add("Apache Commons");
			skills.get("Java").add("Spring Security");
			skills.get("Java").add("Hibernate JPA");
			skills.get("Java").add("Facebook Social API");

			skills.get("IDE").add("Eclipse for JEE Developer");

			skills.get("CVS").add("Git");
			skills.get("CVS").add("Github");

			skills.get("Web Servers").add("Tomcat");
			skills.get("Web Servers").add("Nginx");

			skills.get("Build system").add("Maven");

			skills.get("Cloud").add("AWS");

			return new Course("Java Advanced Course", "DevStudy.net", "https://github.com/TODO",
					"Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
					"http://LINK_TO_DEMO_SITE", skills);
		}
	}
}
