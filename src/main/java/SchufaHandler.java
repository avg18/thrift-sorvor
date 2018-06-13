

import org.apache.thrift.TException;

import de.hska.iwi.avg.schufasystem.service.SchufaService.Business;
import de.hska.iwi.avg.schufasystem.service.SchufaService.Int;
import de.hska.iwi.avg.schufasystem.service.SchufaService.Person;
import de.hska.iwi.avg.schufasystem.service.SchufaService.PersonNotFoundException;
import de.hska.iwi.avg.schufasystem.service.SchufaService.Profile;
import de.hska.iwi.avg.schufasystem.service.SchufaService.SchufaService;

public class SchufaHandler implements SchufaService.Iface{

	private ProfileManager pManager = ProfileManager.getInstance();
	
	
	@Override
	public Int getScore(Person p, Business b) throws TException {

		
		Profile profile = pManager.getProfile(p);
		
		if (profile == null) {
			System.out.println("No profile available!");
			return new Int();
		} else {
			return new Int().setValue(Integer.parseInt(profile.getDetails().get(b)));
		}
	}

	@Override
	public Profile updateProfile(Person p, Business b, String s) throws PersonNotFoundException, TException {

		Profile profile = pManager.getProfile(p);

		if (profile == null) {
			System.out.println("No profile available - throw PersonNotFoundException...");
			throw new PersonNotFoundException("This person is unknown!");
		} else {
			profile.getDetails().put(b, s);
			return profile;
		}
	}
}
