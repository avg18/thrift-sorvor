

import java.util.Vector;
import de.hska.iwi.avg.schufasystem.service.SchufaService.Business;
import de.hska.iwi.avg.schufasystem.service.SchufaService.Person;
import de.hska.iwi.avg.schufasystem.service.SchufaService.Profile;

public class ProfileManager {
		
		private static ProfileManager instance = new ProfileManager();
		Vector<Profile> profiles = new Vector<Profile>();
		
		private ProfileManager() {
			// This simulates an existing internal data base for the running example
			Profile profile = new Profile();
			Person person = new Person("Eva", "Mustermann");
			java.util.Map<Business,String> details = new java.util.HashMap<Business,String>();
			details.put(Business.telco, "10");
			details.put(Business.retail,"5000");
			details.put(Business.finance, "1500");
			
			profile.setP(person);
			profile.setDetails(details);
			this.addProfile(profile);			

			profile = new Profile();
			person = new Person("Peter", "Müller");
			details = new java.util.HashMap<Business,String>();
			details.put(Business.telco, "1000");
			details.put(Business.retail,"200");
			details.put(Business.finance, "100");
			
			profile.setP(person);
			profile.setDetails(details);
			this.addProfile(profile);			
		
		}

		public static ProfileManager getInstance() {
			return instance;
		}
		
		public boolean addProfile(Profile profile){
			if (getProfile (profile.getP()) != null) return false;
			else return profiles.add(profile);
		}
		
		public Profile getProfile(Person person) {

			Profile c = null;
			
			for (int i=0; i< profiles.size(); i++) {
				c = profiles.elementAt(i);
				if (c.getP().getPrename().equals(person.getPrename()) && c.getP().getSurname().equals(person.getSurname()) ) return c;
			}
			return null;
		}		
}		
