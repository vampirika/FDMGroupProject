package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.Sysadmin;
import com.fdmgroup.repos.SysAdminRep;
@Service
public class SysAdminDAO {
	@Autowired
	private SysAdminRep repp;

	
	public void addSysadmin(Sysadmin sysadmin) {
		Optional<Sysadmin> sysadmins = repp.findById(sysadmin.getUsername());
		if (!sysadmins.isPresent()) {

			repp.save(sysadmin);
		}
	}

	public Sysadmin getSysadmin(String sysadminId) {
		Optional<Sysadmin> sysadmins = repp.findById(sysadminId);
		if (sysadmins.isPresent()) {

			return sysadmins.get();
		} else {
			System.out.print("No system admin whith this id therefore is ");
			return null;
		}
	}

	public void removeSysadmin(String sysadminId) {
		Optional<Sysadmin> sysadmins = repp.findById(sysadminId);

		if (sysadmins.isPresent()) {
			repp.delete(sysadmins.get());
			System.out.println("sysadmin removed");
		} else {
			System.out.println("No system admin under this id");
		}

	}

	public void updateSysadmin(Sysadmin sysadmin) {

		Optional<Sysadmin> sysadmins = repp.findById(sysadmin.getUsername());
		if (sysadmins.isPresent()) {
			repp.save(sysadmin);
			System.out.println("system admin changed");
		}
	}

	public List<Sysadmin> listSysadmins() {
		List<Sysadmin> allSysadmins = repp.findAll();
		return allSysadmins;
	}

	public SysAdminDAO() {

	}

	
}
