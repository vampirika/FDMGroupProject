package com.fdmgroup.corona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.entities.Company;
import com.fdmgroup.repos.CompanyRep;
@Service
public class CompanyDAO {
	@Autowired
	private CompanyRep repp;

	private Optional<Company> companies;
	private List<Company> allCompanies;

	public void addCompany(Company company) {
		companies = repp.findById(company.getCompanyId());
		if (!companies.isPresent()) {

			repp.save(company);
		}
	}

	public Company getCompany(int companyId) {
		companies = repp.findById(companyId);
		if (companies.isPresent()) {

			return companies.get();
		} else {
			System.out.print("No companies whith this id therefore is ");
			return null;
		}
	}

	public void removeCompany(int companyId) {
		companies = repp.findById(companyId);

		if (companies.isPresent()) {
			repp.delete(companies.get());
			System.out.println("company removed");
		} else {
			System.out.println("No companies under this id");
		}

	}

	public void updateCompany(Company company) {

		companies = repp.findById(company.getCompanyId());
		if (companies.isPresent()) {
			repp.save(company);
			System.out.println("company changed");
		}
	}

	public List<Company> listCompanies() {
		allCompanies = repp.findAll();

		return allCompanies;
	}

	public CompanyDAO() {

	}

	
}
