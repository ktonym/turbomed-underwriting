package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.*;
import ke.co.turbosoft.med.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akipkoech on 12/9/14.
 */
@Service
@Transactional
public class InitializeDb {

    @Autowired
    private CorporateRepo corpRepo;

    @Autowired
    private ContactInfoRepo contactInfoRepo;

    @Autowired
    private CorpAnnivRepo corpAnnivRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @PostConstruct
    public void init(){

        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setEmail("hr@kbc.com");
        contactInfo.setFirstName("Kuria");
        contactInfo.setSurname("Maina");
        contactInfo.setTel("+2542043234");
        contactInfo.setJobTitle("Human Resource Manager");
        //contactInfo.setCorporate(corp1);
        contactInfoRepo.save(contactInfo);

        Corporate corp1 = new Corporate();
        corp1.setAbbreviation("KBC");
        corp1.setEmail("info@kbc.com");
        corp1.setJoined(LocalDate.now());
        corp1.setCorporateName("Kenya Broadcasting Corporation");
        List<ContactInfo> contactInfoList = new ArrayList<>();
        contactInfoList.add(contactInfo);
        corp1.setContactInfo(contactInfoList);
        corpRepo.save(corp1);

        Corporate corp2 = new Corporate();
        corp2.setAbbreviation("NWS");
        corp2.setEmail("info@nawasco.com");
        corp2.setJoined(LocalDate.now());
        corp2.setCorporateName("Nakuru Water Services Corporation");
        corpRepo.save(corp2);

        Corporate corp3 = new Corporate();
        corp3.setAbbreviation("TSB");
        corp3.setEmail("info@tana.com");
        corp3.setJoined(LocalDate.now());
        corp3.setCorporateName("Tana Water Services Board");
        corpRepo.save(corp3);

        Corporate corp4 = new Corporate();
        corp4.setAbbreviation("KOF");
        corp4.setEmail("info@kenyaordnance.com");
        corp4.setJoined(LocalDate.now());
        corp4.setCorporateName("Kenya Ordnance Factories Corporation");
        corpRepo.save(corp4);

        Corporate corp5 = new Corporate();
        corp5.setAbbreviation("ABK");
        corp5.setEmail("info@abercrombie.com");
        corp5.setJoined(LocalDate.now());
        corp5.setCorporateName("Abercrombie & Kent");
        corpRepo.save(corp5);

        Corporate corp6 = new Corporate();
        corp6.setAbbreviation("ACK");
        corp6.setEmail("info@ack.org");
        corp6.setJoined(LocalDate.now());
        corp6.setCorporateName("Anglican Church of Kenya");
        corpRepo.save(corp6);

//        Role uw_role = new Role();
//        uw_role.setRoleName("uw_user");
//        roleRepo.save(uw_role);
//
//        Role uw_supervisor = new Role();
//        uw_supervisor.setRoleName("uw_spvz");
//        roleRepo.save(uw_supervisor);
//
//        Role clm_analyst = new Role();
//        clm_analyst.setRoleName("clm_user");
//        roleRepo.save(clm_analyst);
//
//        Role clm_supervisor = new Role();
//        clm_supervisor.setRoleName("clm_spvz");
//        roleRepo.save(clm_supervisor);
//
//        Role sys_adm = new Role();
//        sys_adm.setRoleName("sys_adm");
//        roleRepo.save(sys_adm);

        UserRole userRole1 = new UserRole();
        userRole1.setRole(RoleType.SYS_ADM);
        userRoleRepo.save(userRole1);

        UserRole userRole2 = new UserRole();
        userRole2.setRole(RoleType.UW_UZR);
        userRoleRepo.save(userRole2);

        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRole1);
        userRoles.add(userRole2);

        User user1 = new User();
        user1.setUsername("akipkoech");
        user1.setFirstName("Anthony");
        user1.setLastName("Kipkoech");
        user1.setPassword("pass123");
        user1.setEmail("akipkoech@madison.co.ke");
        user1.setUserRoles(userRoles);
        userRepo.save(user1);

//        UserRole userRoleAdm = new UserRole();
//        userRoleAdm.setUser(user1);
//        userRoleAdm.setRole(RoleType.SYS_ADM);
//        userRoleRepo.save(userRoleAdm);

        User user2 = new User();
        user2.setUsername("emwangi");
        user2.setFirstName("Esther");
        user2.setLastName("Mwangi");
        user2.setPassword("pass123");
        user2.setEmail("mwessy08@yahoo.com");
        userRepo.save(user2);

    }

}
