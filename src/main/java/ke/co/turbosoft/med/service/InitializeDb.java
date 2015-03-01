package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.ContactInfo;
import ke.co.turbosoft.med.entity.Corporate;
import ke.co.turbosoft.med.repository.ContactInfoRepo;
import ke.co.turbosoft.med.repository.CorpAnnivRepo;
import ke.co.turbosoft.med.repository.CorporateRepo;
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

    }

}
