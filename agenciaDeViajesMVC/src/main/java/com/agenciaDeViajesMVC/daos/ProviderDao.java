package com.agenciaDeViajesMVC.daos;

import java.util.List;

import com.agenciaDeViajesMVC.modelos.Provider;

/**
 * Interface of ProviderDaoImpl
 * @author dardo.luna
 *
 */
public interface ProviderDao {
	
	/**
	 * Save provider in BD
	 * @param provider to save in BD
	 */
	void saveProvider(Provider provider);
	
	/**
	 * Update provider in BD
	 * @param provider to update in BD
	 */
	void updateProvider(Provider provider);
	
	/**
	 * Remove provider in BD
	 * @param provider to remove in BD
	 */
	void removeProvider(Provider provider);
	
	/**
	 * Search and return list of providers from BD
     * @return List of providers from BD
	 */
	List<Provider> getAllProviders();

}
