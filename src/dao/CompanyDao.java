package dao;

import java.util.ArrayList;

import model.Company;

public interface CompanyDao {
	public boolean AddCompany(Company company);
	public boolean DeleteCompany(Company company);
	public boolean DeleteCompany(String com_id);
	public ArrayList<Company> ListCompanies();
}
