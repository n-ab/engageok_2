package com.engageok.prototype_1.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.engageok.prototype_1.models.Event;
import com.engageok.prototype_1.models.Issuetag;
import com.engageok.prototype_1.models.Organization;
import com.engageok.prototype_1.models.User;
import com.engageok.prototype_1.repositories.EventRepo;
import com.engageok.prototype_1.repositories.IssuetagRepo;
import com.engageok.prototype_1.repositories.OrganizationRepo;
import com.engageok.prototype_1.repositories.RoleRepo;
import com.engageok.prototype_1.repositories.UserRepo;

@Service
public class UserService {
	private final UserRepo uRepo;
	private RoleRepo rRepo;
	private EventRepo eRepo;
	private OrganizationRepo oRepo;
	private IssuetagRepo itRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepo uRepo, RoleRepo rRepo, EventRepo eRepo, OrganizationRepo oRepo, IssuetagRepo itRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.uRepo = uRepo;
		this.rRepo = rRepo;
		this.eRepo = eRepo;
		this.oRepo = oRepo;
		this.itRepo = itRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
		// 		USER SERVICES
	
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(rRepo.findByName("ROLE_USER"));
		uRepo.save(user);
		}
	public void saveUserWithAdminRole(User user) {
		System.out.println("2");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(rRepo.findByName("ROLE_ADMIN"));
		uRepo.save(user);
		}
	public void saveUser(User u) {
		uRepo.save(u);
		}
		
		public User findByEmail(String email) {
		return uRepo.findByEmail(email);
		}
		
		public List<User> findAllUsers(){
		return uRepo.findAll();
		}
		
		public User findOneUser(Long id) {
		return uRepo.findOne(id);
		}
		
		//				EVENT SERVICES
		public List<Event> findAllEvents(){
			return eRepo.findAll();
		}
		
		public void saveEvent(Event e) {
			eRepo.save(e);
		}
		
		public Event findOneEvent(Long id) {
			return eRepo.findOne(id);
			}
		
		//				ORGANIZATION SERVICES
		public List<Organization> findAllOrganizations(){
			return oRepo.findAll();
		}
		
		public void saveOrganization(Organization o) {
			oRepo.save(o);
		}
		
		public Organization findOneOrganization(Long id) {
			return oRepo.findOne(id);
			}
		
		//				ISSUETAG SERVICES
		public List<Issuetag> findAllIssuetags(){
			return itRepo.findAll();
		}
		
		public void saveIssuetag(Issuetag it) {
			itRepo.save(it);
		}
		
		public Issuetag findOne(Long id) {
			return itRepo.findOne(id);
		}
		
		
		
		
		
}
