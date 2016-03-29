package dao;

import java.util.ArrayList;

import model.Packages;

public interface PackagesDao {
	public boolean AddPackage(Packages pkg);
	public boolean DeletePackage(Packages pkg);
	public boolean DeletePackage(String pkg_id);
	public ArrayList<Packages> ListPackages();
}
